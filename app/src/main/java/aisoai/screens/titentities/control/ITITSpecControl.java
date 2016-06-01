package aisoai.screens.titentities.control;

import android.app.Activity;

public interface ITITSpecControl
{
    public Class <? extends Activity> getActivityClass();
    public String initTitle();
    public int initDrawableId();
    public void setTabControl(TITTabControl control);
    public void reinit();
    public void finish();
    public TITSpecControlStatus getStatus();
}
