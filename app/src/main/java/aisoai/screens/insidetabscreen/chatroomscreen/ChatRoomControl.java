package aisoai.screens.insidetabscreen.chatroomscreen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import aisoai.R;
import aisoai.config.KJS;
import aisoai.screens.insidetabscreen.InsideTabControl;
import aisoai.screens.titentities.model.TITMessageInfo;
import aisoai.screens.titentities.model.TITModel;
import aisoai.screens.titentities.TITRequestFactory;
import aisoai.screens.titentities.activity.TITSpecActivity;
import aisoai.titapplib.TITFunction;
import aisoai.screens.titentities.control.TITSpecControl;
import aisoai.screens.titentities.control.TITTabControl;

public class ChatRoomControl extends TITSpecControl
{
    @Override
    public void init()
    {
        super.init();
        MessageArrayAdapter arrayAdapter=new MessageArrayAdapter
                                                        (getActivity(),getModel().getMessageArr());
        getActivity().getLvMessage().setAdapter(arrayAdapter);
        getActivity().getLvMessage().invalidateViews();
        getRequestFactory().allMessageInfoRequest();
    }

    @Override
    public void reinit()
    {
    }

    @Override
    public void finish()
    {

    }

    public void sendMessageEvent(String message)
    {
        JsonObject jsonObject= TITFunction.checkMessage(message);
        if(jsonObject.get(KJS.SUCESS).getAsBoolean())
            getRequestFactory().sendMessageRequest(message);
        getActivity().getEtTypingMessage().setText("");
    }

    /////////////////////////////////////////////////////////////////

    public void allMessageInfoResponse(JsonObject fromServerData)
    {
        System.out.println("All Message Response\n");
        System.out.println(fromServerData.toString());
        JsonArray messageInfoJsonArray=fromServerData.getAsJsonArray(KJS.ARRAY);
        for(int i=0;i<messageInfoJsonArray.size();i++)
        {
            JsonObject messageInfoJson=messageInfoJsonArray.get(i).getAsJsonObject();
            TITMessageInfo messageInfo=new TITMessageInfo(messageInfoJson)
            {
                @Override
                public void reloadImage()
                {
                    getActivity().getLvMessage().invalidateViews();
                }
            };
            getModel().getMessageArr().add(messageInfo);
        }
        getActivity().getLvMessage().invalidateViews();
    }

    public void sendMessageResponse(JsonObject fromServerData)
    {
    }

    public void newMessageNotify(JsonObject fromServerData)
    {
        JsonObject messageInfoJson=fromServerData;
        TITMessageInfo messageInfo=new TITMessageInfo(messageInfoJson)
        {
            @Override
            public void reloadImage()
            {
                getActivity().getLvMessage().invalidateViews();
            }
        };
        getModel().getMessageArr().add(messageInfo);
        getActivity().getLvMessage().invalidateViews();
    }

    @Override
    public ChatRoomActivity getActivity()
    {
        return (ChatRoomActivity) activity;
    }

    @Override
    public ChatRoomModel getModel()
    {
        return (ChatRoomModel)model;
    }

    @Override
    public ChatRoomRF getRequestFactory()
    {
        return (ChatRoomRF) requestFactory;
    }

    @Override
    public TITTabControl getTabControl()
    {
        return (InsideTabControl) tabControl;
    }

    @Override
    public Class<? extends TITSpecActivity> initActivity()
    {
        return ChatRoomActivity.class;
    }

    @Override
    protected TITModel initModel()
    {
        return new ChatRoomModel();
    }

    @Override
    protected TITRequestFactory initRequestFactory()
    {
        return new ChatRoomRF();
    }


    @Override
    public String initTitle()
    {
        return "Chat Room";
    }

    @Override
    public int initDrawableId()
    {
        return R.drawable.chat;
    }

}
