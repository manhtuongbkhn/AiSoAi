package aisoai.screens.hometabscreen.friendtabcreen.chatfriendscreen;

import com.google.gson.JsonObject;

import aisoai.R;
import aisoai.config.KJS;
import aisoai.config.StrDefine;
import aisoai.firebasecommunicate.TITFirebaseCommunicate;
import aisoai.firebasecommunicate.TITFirebaseMessage;
import aisoai.screens.hometabscreen.friendtabcreen.FriendTabControl;
import aisoai.screens.hometabscreen.friendtabcreen.friendlistscreen.FriendInfo;
import aisoai.screens.titentities.model.TITModel;
import aisoai.screens.titentities.TITRequestFactory;
import aisoai.screens.titentities.control.TITTabControl;
import aisoai.screens.titentities.control.TITSpecControl;
import aisoai.titapplib.TITFilter;
import aisoai.titapplib.TITUserVariable;

public class ChatFriendControl extends TITSpecControl
{
    @Override
    public void init()
    {
        //System.out.println("-Init");
        super.init();

        MessageArrayAdapter arrayAdapter=new MessageArrayAdapter
                (getActivity(),getModel().getMessageArr());
        getActivity().getLvMessage().setAdapter(arrayAdapter);
        getActivity().getLvMessage().invalidateViews();

        if(getModel().getFriendInfo()!=null)
        {
            String friendFacebookId = getModel().getFriendInfo().getUserProfile().getFacebookId();
            TITFirebaseCommunicate.getDefaultFirebaseCommunicate(null).
                    registerConversation(friendFacebookId);
        }
    }

    @Override
    public void reinit()
    {
        //System.out.println("-Reinit");
        getModel().getMessageArr().clear();
        getActivity().getLvMessage().invalidateViews();

        if(getModel().getFriendInfo()!=null)
        {
            String friendFacebookId = getModel().getFriendInfo().getUserProfile().getFacebookId();
            TITFirebaseCommunicate.getDefaultFirebaseCommunicate(null).
                    registerConversation(friendFacebookId);
        }
    }

    public void newFriendChatEvent(FriendInfo friendInfo)
    {
        getModel().setFriendInfo(friendInfo);
    }

    @Override
    public void finish()
    {
        super.finish();
        TITFirebaseCommunicate.getDefaultFirebaseCommunicate(null).unregisterConversation();
    }

    public void sendMessageEvent(String message)
    {
        if(getModel().getFriendInfo()!=null)
        {
            message = TITFilter.filterMessage(message);
            String friendFacebookId = getModel().getFriendInfo().getUserProfile().getFacebookId();
            TITFirebaseCommunicate.getDefaultFirebaseCommunicate(null).
                    sendMessageRequest(message, friendFacebookId);
        }
        else
            getActivity().showMessage(StrDefine.NOFRIEND_CHAT,1);
    }

    public void firebaseNewMessageNotify(String messageId,String senderFacebookId,
                                            String receiverFacebookId,TITFirebaseMessage message)
    {
        System.out.println("-"+message.getContent());
        String facebookId= TITUserVariable.getUserInfo().getUserProfile().getFacebookId();
        String userId,fullName,avatarUrl;
        String messageContent=message.getContent();
        int systemUserId;

        if(facebookId.equals(senderFacebookId))
        {
            systemUserId=TITUserVariable.getUserInfo().getUserProfile().getSystemUserId();
            userId=TITUserVariable.getUserInfo().getUserProfile().getUserId();
            fullName=TITUserVariable.getUserInfo().getUserProfile().getFullName();
            avatarUrl=TITUserVariable.getUserInfo().getUserProfile().getAvatarUrl();
        }
        else
        {
            systemUserId=getModel().getFriendInfo().getUserProfile().getSystemUserId();
            userId=getModel().getFriendInfo().getUserProfile().getUserId();
            fullName=getModel().getFriendInfo().getUserProfile().getFullName();
            avatarUrl=getModel().getFriendInfo().getUserProfile().getAvatarUrl();
        }


        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty(KJS.MESSAGE_ID,messageId);
        jsonObject.addProperty(KJS.USER_ID,userId);
        jsonObject.addProperty(KJS.SYSTEM_USER_ID,systemUserId);
        jsonObject.addProperty(KJS.FULL_NAME,fullName);
        jsonObject.addProperty(KJS.SEND_TIME,message.getTime());
        jsonObject.addProperty(KJS.MESSAGE_CONTENT,messageContent);
        jsonObject.addProperty(KJS.AVATAR_URL,avatarUrl);

        FriendMessageInfo messageInfo=new FriendMessageInfo(jsonObject)
        {
            @Override
            public void reloadImage()
            {
                getActivity().getLvMessage().invalidateViews();
            }
        };
        getModel().getMessageArr().add(messageInfo);
        getActivity().getLvMessage().invalidateViews();
    }


    @Override
    public TITTabControl getTabControl()
    {
        return (FriendTabControl) tabControl;
    }

    @Override
    public Class<ChatFriendActivity> initActivity()
    {
        return ChatFriendActivity.class;
    }

    @Override
    protected TITModel initModel()
    {
        return new ChatFriendModel();
    }

    @Override
    protected TITRequestFactory initRequestFactory()
    {
        return new ChatFriendRF();
    }

    @Override
    public ChatFriendActivity getActivity()
    {
        return (ChatFriendActivity) activity;
    }

    @Override
    public ChatFriendModel getModel()
    {
        return (ChatFriendModel) model;
    }

    @Override
    public ChatFriendRF getRequestFactory()
    {
        return (ChatFriendRF)requestFactory;
    }

    @Override
    public String initTitle()
    {
        return "Chat Friend";
    }

    @Override
    public int initDrawableId()
    {
        return R.drawable.chat;
    }
}
