package aisoai.screens.insidetabscreen;

import java.util.ArrayList;

import aisoai.screens.insidetabscreen.chatroomscreen.ChatRoomControl;
import aisoai.screens.insidetabscreen.insideroomscreen.InsideRoomControl;
import aisoai.screens.insidetabscreen.insideroomscreen.InsideRoomModel;
import aisoai.screens.titentities.model.TITModel;
import aisoai.screens.titentities.TITRequestFactory;
import aisoai.screens.titentities.activity.TITTabActivity;
import aisoai.screens.titentities.control.ITITSpecControl;
import aisoai.screens.titentities.control.TITTabControl;

public class InsideTabControl extends TITTabControl
{

    @Override
    public void tabChangeEvent(String tabId)
    {

    }

    @Override
    public void init()
    {

    }

    @Override
    public Class<? extends TITTabActivity> initActivity()
    {
        return InsideTabActivity.class;
    }

    @Override
    protected TITModel initModel()
    {
        return new InsideRoomModel();
    }

    @Override
    protected TITRequestFactory initRequestFactory()
    {
        return new InsideTabRF();
    }

    @Override
    public TITTabActivity getActivity()
    {
        return (InsideTabActivity) activity;
    }

    @Override
    protected ArrayList<ITITSpecControl> initSpecControlArr()
    {
        ArrayList<ITITSpecControl> specControlArr=new ArrayList<ITITSpecControl>();
        InsideRoomControl insideRoomControl=new InsideRoomControl();
        ChatRoomControl chatRoomControl=new ChatRoomControl();
        specControlArr.add(insideRoomControl);
        specControlArr.add(chatRoomControl);
        return specControlArr;
    }

    public InsideRoomControl getInsideRoomControl()
    {
        return (InsideRoomControl) controlArr.get(0);
    }

    public ChatRoomControl getChatRoomControl()
    {
        return (ChatRoomControl) controlArr.get(1);
    }

    @Override
    public TITModel getModel()
    {
        return model;
    }

    @Override
    public TITRequestFactory getRequestFactory()
    {
        return (InsideTabRF) requestFactory;
    }
}
