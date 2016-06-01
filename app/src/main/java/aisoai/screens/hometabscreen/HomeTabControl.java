package aisoai.screens.hometabscreen;

import java.util.ArrayList;

import aisoai.screens.hometabscreen.friendtabcreen.FriendTabControl;
import aisoai.screens.hometabscreen.homeprofilescreen.ProfileControl;
import aisoai.screens.hometabscreen.roomlistscreen.RoomListControl;
import aisoai.screens.hometabscreen.settings.SettingsControl;
import aisoai.screens.hometabscreen.topuser.TopPlayerControl;
import aisoai.screens.titentities.control.ITITSpecControl;
import aisoai.screens.titentities.model.TITModel;
import aisoai.screens.titentities.control.TITTabControl;
import aisoai.screens.titentities.TITRequestFactory;

public class HomeTabControl extends TITTabControl
{
    @Override
    public void init()
    {

    }

    @Override
    public Class<HomeTabActivity> initActivity()
    {
        return HomeTabActivity.class;
    }

    @Override
    protected TITModel initModel()
    {
        return new TITModel();
    }

    @Override
    protected TITRequestFactory initRequestFactory()
    {
        return new HomeTabRF();
    }

    @Override
    public HomeTabActivity getActivity()
    {
        return (HomeTabActivity) activity;
    }

    @Override
    protected ArrayList<ITITSpecControl> initSpecControlArr()
    {
        ArrayList<ITITSpecControl> controlArr=new ArrayList<ITITSpecControl>();
        ProfileControl profileControl=new ProfileControl();
        RoomListControl roomListControl=new RoomListControl();
        FriendTabControl friendTabControl=new FriendTabControl();
        TopPlayerControl topPlayerControl =new TopPlayerControl();
        SettingsControl settingsControl=new SettingsControl();
        controlArr.add(profileControl);
        controlArr.add(roomListControl);
        controlArr.add(friendTabControl);
        controlArr.add(topPlayerControl);
        controlArr.add(settingsControl);
        return controlArr;
    }

    public ProfileControl getProfileControl()
    {
        return (ProfileControl) controlArr.get(0);
    }

    public RoomListControl getRoomListControl()
    {
        return (RoomListControl) controlArr.get(1);
    }

    public FriendTabControl getFriendTabControl()
    {
        return (FriendTabControl) controlArr.get(2);
    }

    public TopPlayerControl getTopUserControl()
    {
        return (TopPlayerControl) controlArr.get(3);
    }

    public SettingsControl getSettingsControl()
    {
        return (SettingsControl) controlArr.get(4);
    }

    @Override
    public TITModel getModel()
    {
        return model;
    }

    @Override
    public HomeTabRF getRequestFactory()
    {
        return (HomeTabRF) requestFactory;
    }

}
