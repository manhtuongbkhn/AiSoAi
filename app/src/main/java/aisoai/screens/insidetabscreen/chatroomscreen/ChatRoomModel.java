package aisoai.screens.insidetabscreen.chatroomscreen;

import java.util.ArrayList;

import aisoai.screens.titentities.model.TITMessageInfo;
import aisoai.screens.titentities.model.TITModel;

public class ChatRoomModel extends TITModel
{
    private ArrayList<TITMessageInfo> messageArr=new ArrayList<TITMessageInfo>();

    public ArrayList<TITMessageInfo> getMessageArr()
    {
        return messageArr;
    }

    public void setMessageArr(ArrayList<TITMessageInfo> messageArr)
    {
        this.messageArr = messageArr;
    }
}
