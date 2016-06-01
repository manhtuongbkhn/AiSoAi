package aisoai.screens.hometabscreen.friendtabcreen.friendlistscreen;

import android.graphics.Bitmap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import aisoai.R;
import aisoai.config.KJS;
import aisoai.facebookcommunincate.TITFacebookCommunicate;
import aisoai.firebasecommunicate.TITFirebaseCommunicate;
import aisoai.firebasecommunicate.TITFirebaseMessage;
import aisoai.screens.hometabscreen.friendtabcreen.FriendTabControl;
import aisoai.screens.titentities.control.TITSpecControl;
import aisoai.screens.titentities.model.TITModel;
import aisoai.screens.titentities.TITRequestFactory;

public class FriendListControl extends TITSpecControl
{
    @Override
    public void init()
    {
        super.init();
        FriendArrayAdapter arrayAdapter=
                                new FriendArrayAdapter(getActivity(),this,getModel().getFriendArr());
        getActivity().getLvFriend().setAdapter(arrayAdapter);
        getRequestFactory().friendListRequest();

        ArrayList<String> idArr= TITFacebookCommunicate.
                getCurrentFacebookCommunicate().getFriendFacebookIdArr();
        TITFirebaseCommunicate.getDefaultFirebaseCommunicate(null).registerNotification(idArr);
    }

    @Override
    public void reinit()
    {
        getRequestFactory().friendListRequest();

        ArrayList<String> idArr= TITFacebookCommunicate.
                getCurrentFacebookCommunicate().getFriendFacebookIdArr();
        TITFirebaseCommunicate.getDefaultFirebaseCommunicate(null).registerNotification(idArr);
    }

    @Override
    public void finish()
    {
        super.finish();
        getRequestFactory().cancelFriendListRequest();
        TITFirebaseCommunicate.getDefaultFirebaseCommunicate(null).unregisterNotification();
    }

    public void friendItemClickEvent(int postion)
    {
        FriendInfo friendInfo=getModel().getFriendArr().get(postion);
        friendInfo.setMessage(false);
        getTabControl().chatFriendEvent(friendInfo);
    }

    public void moreInfoEvent(int postion)
    {

        getActivity().setDlMoreFriendInfo
                            (new MoreFriendInfoDialog(getTabControl().getActivity(),this));
        FriendInfo friendInfo=getModel().getFriendArr().get(postion);
        getActivity().getDlMoreFriendInfo().setContent(friendInfo);
        getActivity().getDlMoreFriendInfo().show();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public void friendListResponse(JsonObject fromServerData)
    {
        boolean sucess=fromServerData.get(KJS.SUCESS).getAsBoolean();
        System.out.println("Get Friend List Sucess");
    }

    public void reloadFriendListNotify(JsonObject fromServerData)
    {
        friendListMethod("reloadFriendListNotify",fromServerData);
    }

    private void syncReloadFriendListNotify(JsonObject fromServerData)
    {
        if(getModel().getFriendArr().size()==0)
        {
            JsonArray jsonArray = fromServerData.getAsJsonArray(KJS.ARRAY);
            for (int i = 0; i < jsonArray.size(); i++)
            {
                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                jsonObject.addProperty(KJS.AVATAR_PRIORITY,8);
                FriendInfo friendInfo = new FriendInfo(jsonObject)
                {
                    @Override
                    public void reloadImage(Bitmap bitmap)
                    {
                        getActivity().getLvFriend().invalidateViews();
                    }
                };
                getModel().getFriendArr().add(friendInfo);
            }
        }
        else
        {
            JsonArray jsonArray = fromServerData.getAsJsonArray(KJS.ARRAY);
            for (int i = 0; i < jsonArray.size(); i++)
            {
                FriendInfo friendInfo=getModel().getFriendArr().get(i);
                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                friendInfo.reload(jsonObject);
            }
        }
        getActivity().getLvFriend().invalidateViews();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////

    public void firebaseNewNotificationNotify(String senderFacebookId,
                                               String receiverFacebookId,TITFirebaseMessage message)
    {
        friendListMethod("firebaseNewNotificationNotify",senderFacebookId);
    }

    private void syncFirebaseNewNotificationNotify(String senderFacebookId)
    {
        for(int i=0;i<getModel().getFriendArr().size();i++)
        {
            FriendInfo friendInfo=getModel().getFriendArr().get(i);
            String facebookId=friendInfo.getUserProfile().getFacebookId();
            if(facebookId.equals(senderFacebookId))
            {
                friendInfo.setMessage(true);
            }
        }
        getActivity().getLvFriend().invalidateViews();
    }

    private synchronized void friendListMethod(String methodName,Object param1)
    {
        switch (methodName)
        {
            case "reloadFriendListNotify":
                JsonObject fromServerData=(JsonObject) param1;
                syncReloadFriendListNotify(fromServerData);
                break;
            case "firebaseNewNotificationNotify":
                String senderFacebookId=(String) param1;
                syncFirebaseNewNotificationNotify(senderFacebookId);
                break;
        }
    }

    @Override
    public FriendListActivity getActivity()
    {
        return (FriendListActivity) activity;
    }

    @Override
    public FriendListModel getModel()
    {
        return (FriendListModel) model;
    }

    @Override
    public FriendListRF getRequestFactory()
    {
        return (FriendListRF) requestFactory;
    }

    @Override
    public FriendTabControl getTabControl()
    {
        return (FriendTabControl) tabControl;
    }


    @Override
    public Class<FriendListActivity> initActivity()
    {
        return FriendListActivity.class;
    }

    @Override
    protected TITModel initModel()
    {
        return new FriendListModel();
    }

    @Override
    protected TITRequestFactory initRequestFactory()
    {
        return new FriendListRF();
    }

    @Override
    public String initTitle()
    {
        return "Friend List";
    }

    @Override
    public int initDrawableId()
    {
        return R.drawable.friends;
    }
}
