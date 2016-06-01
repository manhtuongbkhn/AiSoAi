package aisoai.screens.hometabscreen.friendtabcreen;

import aisoai.R;
import aisoai.TITApplication;
import aisoai.screens.titentities.activity.TITTabActivity;
import aisoai.screens.titentities.control.TITTabControl;

public class FriendTabActivity extends TITTabActivity
{
    @Override
    protected void linkToLayout()
    {
        setContentView(R.layout.friend_tab);
    }

    @Override
    protected void scaleView()
    {

    }

    @Override
    protected FriendTabControl linkControl()
    {
        return TITApplication.getScreenControlManager().getFriendTabControl();
    }

    @Override
    public FriendTabControl getControl()
    {
        return (FriendTabControl) control;
    }
}
