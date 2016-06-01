package aisoai.screens.hometabscreen.friendtabcreen.chatfriendscreen;

import com.google.gson.JsonObject;
import java.util.Date;
import aisoai.config.KJS;
import aisoai.screens.titentities.model.TITMessageInfo;

abstract public class FriendMessageInfo extends TITMessageInfo
{
    protected String messageId;
    protected Date date;

    public FriendMessageInfo(JsonObject jsonObject)
    {
        super(jsonObject);
        messageId=jsonObject.get(KJS.MESSAGE_ID).getAsString();
        date=new Date(time);
        time= "T"+date.getMonth()+" N"+date.getDay()+" "+date.getHours()+":"+
                                                            date.getMinutes()+":"+date.getSeconds();
    }

    public String getMessageId()
    {
        return messageId;
    }

    public Date getDate()
    {
        return date;
    }
}
