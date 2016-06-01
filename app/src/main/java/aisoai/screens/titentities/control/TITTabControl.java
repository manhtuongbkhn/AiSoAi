package aisoai.screens.titentities.control;

import java.util.ArrayList;

import aisoai.screens.titentities.activity.TITTabActivity;

abstract public class TITTabControl extends TITAppControl
{
    protected ArrayList<ITITSpecControl> controlArr;

    public TITTabControl()
    {
        super();
        controlArr=initSpecControlArr();
        for(int i=0;i<controlArr.size();i++)
        {
            ITITSpecControl specControl=controlArr.get(i);
            specControl.setTabControl(this);
        }
    }

    public ArrayList<ITITSpecControl> getControlArr()
    {
        return controlArr;
    }


    public void tabChangeEvent(String tabId)
    {
        System.out.println("-TabId:"+tabId);
        for(int i=0;i<controlArr.size();i++)
        {
            ITITSpecControl specControl=controlArr.get(i);
            if(specControl.initTitle().equals(tabId))
            {
                if(specControl.getStatus()==TITSpecControlStatus.SLEEPING)
                {
                    specControl.reinit();
                }
            }
            else
            {
                specControl.finish();
            }
        }
    }

    @Override
    public void finish()
    {
        for(int i=0;i<controlArr.size();i++)
        {
            ITITSpecControl specControl=controlArr.get(i);
            specControl.finish();
        }
    }

    @Override
    abstract public Class< ? extends TITTabActivity> initActivity();

    @Override
    abstract public TITTabActivity getActivity();

    protected abstract ArrayList<ITITSpecControl> initSpecControlArr();
}
