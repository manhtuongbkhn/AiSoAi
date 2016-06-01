package aisoai.screens.hometabscreen;

import aisoai.R;
import aisoai.TITApplication;
import aisoai.screens.titentities.activity.TITTabActivity;
import aisoai.screens.titentities.control.TITTabControl;

public class HomeTabActivity extends TITTabActivity
{
    @Override
    protected void linkToLayout()
    {
        setContentView(R.layout.home_tab);
    }

    @Override
    protected void scaleView()
    {

    }

    @Override
    protected TITTabControl linkControl()
    {
        return TITApplication.getScreenControlManager().getHomeTabControl();
    }

    @Override
    public HomeTabControl getControl()
    {
        return (HomeTabControl) control;
    }
}
