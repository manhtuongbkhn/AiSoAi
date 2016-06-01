package aisoai.screens.titentities.control;

import aisoai.screens.titentities.activity.TITTabActivity;

abstract public class TITSpecTabControl extends TITTabControl implements ITITSpecControl
{
    protected TITSpecControlStatus status=TITSpecControlStatus.READY;
    protected TITTabControl tabControl;

    @Override
    public void init()
    {
        status=TITSpecControlStatus.RUNING;
    }

    @Override
    public void reinit()
    {

    }


    public TITSpecTabControl()
    {
        super();
    }

    public void setTabControl(TITTabControl tabControl)
    {
        this.tabControl = tabControl;
    }

    @Override
    public Class <? extends TITTabActivity> getActivityClass()
    {
        return initActivity();
    }

    @Override
    public void finish()
    {
        super.finish();
        status=TITSpecControlStatus.SLEEPING;
    }

    @Override
    public TITSpecControlStatus getStatus()
    {
        return status;
    }
}
