package aisoai.screens.hometabscreen.topuser;

import android.widget.ListView;

import aisoai.R;
import aisoai.TITApplication;
import aisoai.screens.titentities.activity.TITSpecActivity;
import aisoai.screens.titentities.control.TITSpecControl;

public class TopPlayerActivity extends TITSpecActivity
{
    private ListView lvPlayer;
    private MoreTopPlayerInfoDialog dlMoreTopPlayerInfo;

    @Override
    protected void linkToLayout()
    {
        setContentView(R.layout.top_player);
        lvPlayer=(ListView) findViewById(R.id.lvPlayer);
    }

    @Override
    protected void scaleView()
    {
    }

    @Override
    protected TITSpecControl linkControl()
    {
        return TITApplication.getScreenControlManager().getTopUserControl();
    }

    @Override
    public TopPlayerControl getControl()
    {
        return (TopPlayerControl) control;
    }

    public ListView getLvPlayer()
    {
        return lvPlayer;
    }

    public MoreTopPlayerInfoDialog getDlMoreTopPlayerInfo()
    {
        return dlMoreTopPlayerInfo;
    }

    public void setDlMoreTopPlayerInfo(MoreTopPlayerInfoDialog dlMoreTopPlayerInfo)
    {
        this.dlMoreTopPlayerInfo = dlMoreTopPlayerInfo;
    }
}
