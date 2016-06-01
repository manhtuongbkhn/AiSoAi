package aisoai.screens.insidetabscreen;

import aisoai.TITApplication;
import aisoai.R;
import aisoai.screens.titentities.activity.TITTabActivity;
import aisoai.screens.titentities.control.TITTabControl;

public class InsideTabActivity extends TITTabActivity
{
    @Override
    protected void linkToLayout()
    {
        setContentView(R.layout.inside_room_tab);
    }

    @Override
    protected void scaleView()
    {

    }

    @Override
    protected TITTabControl linkControl()
    {
        return TITApplication.getScreenControlManager().getInsideTabControl();
    }

    @Override
    public InsideTabControl getControl()
    {
        return (InsideTabControl) control;
    }
}
