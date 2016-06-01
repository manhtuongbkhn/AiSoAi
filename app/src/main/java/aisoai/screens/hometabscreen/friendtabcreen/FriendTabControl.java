package aisoai.screens.hometabscreen.friendtabcreen;

import java.util.ArrayList;
import aisoai.R;
import aisoai.screens.hometabscreen.friendtabcreen.chatfriendscreen.ChatFriendControl;
import aisoai.screens.hometabscreen.friendtabcreen.friendlistscreen.FriendListControl;
import aisoai.screens.hometabscreen.friendtabcreen.friendlistscreen.FriendInfo;
import aisoai.screens.titentities.activity.TITTabActivity;
import aisoai.screens.titentities.control.ITITSpecControl;
import aisoai.screens.titentities.control.TITSpecTabControl;
import aisoai.screens.titentities.model.TITModel;
import aisoai.screens.titentities.TITRequestFactory;

public class FriendTabControl extends TITSpecTabControl
{
    @Override
    public void init()
    {
        super.init();
    }

    public void chatFriendEvent(FriendInfo friendInfo)
    {
        getChatFriendControl().newFriendChatEvent(friendInfo);
        getActivity().getTabHost().setCurrentTab(1);
    }

    @Override
    public FriendTabActivity getActivity()
    {
        return (FriendTabActivity) activity;
    }

    @Override
    public Class<? extends TITTabActivity> initActivity()
    {
        return FriendTabActivity.class;
    }

    @Override
    protected TITModel initModel()
    {
        return new TITModel();
    }

    @Override
    protected TITRequestFactory initRequestFactory()
    {
        return new FriendTabRF();
    }

    @Override
    protected ArrayList<ITITSpecControl> initSpecControlArr()
    {
        ArrayList<ITITSpecControl> controlArr=new ArrayList<ITITSpecControl>();
        FriendListControl friendListControl=new FriendListControl();
        ChatFriendControl chatFriendControl=new ChatFriendControl();
        controlArr.add(friendListControl);
        controlArr.add(chatFriendControl);
        return controlArr;
    }

    public FriendListControl getFriendListControl()
    {
        return (FriendListControl) controlArr.get(0);
    }

    public ChatFriendControl getChatFriendControl()
    {
        return (ChatFriendControl) controlArr.get(1);
    }

    @Override
    public TITModel getModel()
    {
        return model;
    }

    @Override
    public FriendTabRF getRequestFactory()
    {
        return (FriendTabRF) requestFactory;
    }


    @Override
    public String initTitle()
    {
        return "Friend Tab";
    }

    @Override
    public int initDrawableId()
    {
        return R.drawable.friends;
    }
}
