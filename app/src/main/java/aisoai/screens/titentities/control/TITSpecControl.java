package aisoai.screens.titentities.control;

import aisoai.screens.titentities.activity.TITSpecActivity;

abstract public class TITSpecControl extends TITNormalControl implements ITITSpecControl
{
    protected TITSpecControlStatus status=TITSpecControlStatus.READY;
    protected TITTabControl tabControl;

    @Override
    public void init()
    {
        status=TITSpecControlStatus.RUNING;
    }

    public void setTabControl(TITTabControl tabControl)
    {
        this.tabControl = tabControl;
    }

    abstract public TITTabControl getTabControl();

    @Override
    abstract public Class< ? extends TITSpecActivity> initActivity();

    @Override
    abstract public TITSpecActivity getActivity();

    @Override
    public Class <? extends TITSpecActivity> getActivityClass()
    {
        return initActivity();
    }

    public TITSpecControlStatus getStatus()
    {
        return status;
    }

    @Override
    public void finish()
    {
        status=TITSpecControlStatus.SLEEPING;
    }
}
