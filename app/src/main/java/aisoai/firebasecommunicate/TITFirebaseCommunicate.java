package aisoai.firebasecommunicate;

import android.app.Activity;
import com.facebook.AccessToken;
import com.firebase.client.AuthData;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import aisoai.config.ClientConfig;
import aisoai.config.ServerConfig;
import aisoai.screens.TITScreenControlManager;

public class TITFirebaseCommunicate
{
    private TITScreenControlManager controlManager;
    private static TITFirebaseCommunicate defaultFirebaseCommunicate;

    private TITFirebaseCommunicate(Activity activity)
    {
        Firebase.setAndroidContext(activity);
        controlManager= TITScreenControlManager.getDefaultScreenControlManager();
    }

    public static TITFirebaseCommunicate getDefaultFirebaseCommunicate(Activity activity)
    {
        if(defaultFirebaseCommunicate==null&&activity!=null)
            defaultFirebaseCommunicate=new TITFirebaseCommunicate(activity);
        return defaultFirebaseCommunicate;
    }

    public void reset()
    {

    }

    public void loginRequest(AccessToken accessToken,
                                    final ArrayList<String> friendFacebookIdArr)
    {
        String url= TITFirebaseConfig.FIREBASE_URL;
        final Firebase firebase = new Firebase(url);
        firebase.authWithOAuthToken("facebook", accessToken.getToken(), new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData)
            {
                checkUserExistRequest(friendFacebookIdArr);
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError)
            {
                controlManager.getControl().firebaseLoginResponse(0);
            }
        });
    }

    private void checkUserExistRequest(final ArrayList<String> friendFacebookIdArr)
    {
        final String facebookId=AccessToken.getCurrentAccessToken().getUserId();
        String url= TITFirebaseConfig.FIREBASE_URL;
        final Firebase firebase=new Firebase(url);
        firebase.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                boolean exist = dataSnapshot.hasChild(facebookId);
                if (!exist)
                {
                    createNewUserRequest(friendFacebookIdArr);
                } else
                {
                    DataSnapshot childDataSnapshot = dataSnapshot.child(facebookId);
                    reloadFriend(friendFacebookIdArr, dataSnapshot);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                controlManager.getControl().firebaseLoginResponse(-1);
            }
        });
    }

    private void createNewUserRequest(final ArrayList<String> friendFacebookIdArr)
    {
        String facebookId=AccessToken.getCurrentAccessToken().getUserId();
        String url= TITFirebaseConfig.FIREBASE_URL;
        final Firebase firebase=new Firebase(url).child(facebookId);
        HashMap<String,TITFirebaseMessage> friend=new HashMap<String,TITFirebaseMessage>();
        HashMap<String,HashMap<String,TITFirebaseMessage>> user=
                                        new HashMap<String,HashMap<String,TITFirebaseMessage>>();
        TITFirebaseMessage message=new TITFirebaseMessage("Tham gia!",false);
        friend.put("-",message);
        for(int i=0;i<friendFacebookIdArr.size();i++)
        {
            String friendFacebookId=friendFacebookIdArr.get(i);
            user.put(friendFacebookId,friend);
        }
        firebase.setValue(user);
        controlManager.getControl().firebaseLoginResponse(1);
    }

    private void reloadFriend(ArrayList<String> friendFacebookIdArr,
                                                                        DataSnapshot dataSnapshot)
    {
        String facebookId=AccessToken.getCurrentAccessToken().getUserId();
        String url= TITFirebaseConfig.FIREBASE_URL;
        final Firebase firebase=new Firebase(url).child(facebookId);

        for(int i=0;i<friendFacebookIdArr.size();i++)
        {
            String friendFacebookId=friendFacebookIdArr.get(i);
            if(!dataSnapshot.hasChild(friendFacebookId))
            {
                HashMap<String,TITFirebaseMessage> friend=new HashMap<String,TITFirebaseMessage>();
                TITFirebaseMessage message=new TITFirebaseMessage("Tham gia!",true);
                friend.put("-",message);
                firebase.child(friendFacebookId).setValue(friend);
            }
        }
        Iterator<DataSnapshot> dataSnapshotIterator=dataSnapshot.getChildren().iterator();
        while (dataSnapshotIterator.hasNext())
        {
            DataSnapshot childDataSnapshot=dataSnapshotIterator.next();
            String friendFacebookId=childDataSnapshot.getKey();
            if(!friendFacebookIdArr.contains(friendFacebookId))
                firebase.child(friendFacebookId).setValue(null);
        }

        controlManager.getControl().firebaseLoginResponse(1);
    }

    public void sendMessageRequest(String content,String receiverFacebookId)
    {
        String url= TITFirebaseConfig.FIREBASE_URL;
        AccessToken accessToken=AccessToken.getCurrentAccessToken();
        String facebookId=accessToken.getUserId();
        TITFirebaseMessage message=new TITFirebaseMessage(content,false);
        Firebase firebase=new Firebase(url).child(facebookId).child(receiverFacebookId);
        firebase.push().setValue(message);
    }

    private ArrayList<Query> notificationQueryArr =new ArrayList<Query>();
    private ChildEventListener notificationChildEventListener;

    public void registerNotification(ArrayList<String> friendFacebookIdArr)
    {;
        final String facebookId=AccessToken.getCurrentAccessToken().getUserId();
        String url= TITFirebaseConfig.FIREBASE_URL;
        notificationChildEventListener=new ChildEventListener()
        {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                String time = dataSnapshot.child("time").getValue(String.class);
                String content = dataSnapshot.child("content").getValue(String.class);
                boolean received = dataSnapshot.child("received").getValue(Boolean.class);
                TITFirebaseMessage message = new TITFirebaseMessage(time, content,received);
                String senderFacebookId = dataSnapshot.getRef().getParent().getParent().getKey();
                controlManager.getFriendListControl().firebaseNewNotificationNotify
                        (senderFacebookId, facebookId, message);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s)
            {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot)
            {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s)
            {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError)
            {

            }
        };

        for(int i=0;i<friendFacebookIdArr.size();i++)
        {
            String friendFacebookId=friendFacebookIdArr.get(i);
            Firebase firebase=new Firebase(url).child(friendFacebookId).child(facebookId);
            Query query=firebase.orderByChild("received").equalTo(false);
            notificationQueryArr.add(query);
            query.addChildEventListener(notificationChildEventListener);
        }
    }

    public void unregisterNotification()
    {
        for(int i=0;i< notificationQueryArr.size();i++)
        {
            Query query= notificationQueryArr.get(i);
            query.removeEventListener(notificationChildEventListener);
        }
        notificationQueryArr.clear();
        notificationChildEventListener=null;
    }

    private ArrayList<Query> conversationQueryArr=new ArrayList<Query>();
    private ArrayList<ChildEventListener> conversationChildEventListenerArr=
                                                                new ArrayList<ChildEventListener>();
    public void registerConversation(final String friendFacebookId)
    {
        cofrimReceivedAllMessage(friendFacebookId);

        final String facebookId=AccessToken.getCurrentAccessToken().getUserId();
        Firebase firebase;
        Query query;
        ChildEventListener conversationChildEventListener;
        String url= TITFirebaseConfig.FIREBASE_URL;

        firebase=new Firebase(url).child(facebookId).child(friendFacebookId);
        query=firebase.orderByKey().limitToLast(ClientConfig.MAX_FIREBASEMESSAGE_CHAT);
        conversationChildEventListener=new ChildEventListener()
        {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                String messageId=dataSnapshot.getKey();
                String time = dataSnapshot.child("time").getValue(String.class);
                String content = dataSnapshot.child("content").getValue(String.class);
                boolean received = dataSnapshot.child("received").getValue(Boolean.class);
                TITFirebaseMessage message = new TITFirebaseMessage(time, content,received);
                controlManager.getChatFriendControl().firebaseNewMessageNotify
                        (messageId, facebookId, friendFacebookId, message);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s)
            {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot)
            {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s)
            {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError)
            {

            }
        };
        query.addChildEventListener(conversationChildEventListener);
        conversationQueryArr.add(query);
        conversationChildEventListenerArr.add(conversationChildEventListener);

        firebase=new Firebase(url).child(friendFacebookId).child(facebookId);
        query=firebase.orderByKey().limitToLast(ClientConfig.MAX_FIREBASEMESSAGE_CHAT);
        conversationChildEventListener=new ChildEventListener()
        {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                String messageId=dataSnapshot.getKey();
                String time = dataSnapshot.child("time").getValue(String.class);
                String content = dataSnapshot.child("content").getValue(String.class);
                boolean received = dataSnapshot.child("received").getValue(Boolean.class);
                TITFirebaseMessage message = new TITFirebaseMessage(time, content,received);
                controlManager.getChatFriendControl().firebaseNewMessageNotify
                                                    (messageId,friendFacebookId,facebookId,message);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s)
            {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot)
            {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s)
            {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError)
            {

            }
        };
        query.addChildEventListener(conversationChildEventListener);
        conversationQueryArr.add(query);
        conversationChildEventListenerArr.add(conversationChildEventListener);
    }

    private ChildEventListener confrimChildEventListener;
    private Query confirmQuery;

    private void cofrimReceivedAllMessage(final String friendFacebookId)
    {
        final String facebookId=AccessToken.getCurrentAccessToken().getUserId();
        final String url= TITFirebaseConfig.FIREBASE_URL;
        confrimChildEventListener=new ChildEventListener()
        {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                String messageId=dataSnapshot.getKey();
                Firebase firebase=new Firebase(url).child(friendFacebookId).
                                                child(facebookId).child(messageId).child("received");
                firebase.setValue(true);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s)
            {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot)
            {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s)
            {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError)
            {

            }
        };

        Firebase firebase=new Firebase(url).child(friendFacebookId).child(facebookId);
        confirmQuery=firebase.orderByChild("received").equalTo(false);
        confirmQuery.addChildEventListener(confrimChildEventListener);
    }

    public void unregisterConversation()
    {
        for(int i=0;i<conversationQueryArr.size();i++)
        {
            Query query=conversationQueryArr.get(i);
            query.removeEventListener(conversationChildEventListenerArr.get(i));
        }
        conversationQueryArr.clear();
        conversationChildEventListenerArr.clear();

        if(confirmQuery!=null)
            confirmQuery.removeEventListener(confrimChildEventListener);

        confirmQuery=null;
        confrimChildEventListener=null;
    }
}