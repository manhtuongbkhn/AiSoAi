package aisoai.screens.hometabscreen.friendtabcreen.friendlistscreen;

import com.google.gson.JsonObject;

import aisoai.config.KJS;
import aisoai.screens.titentities.model.TITUserInfo;

abstract public class FriendInfo extends TITUserInfo
{
    private int status;
    private boolean message;

    public FriendInfo(JsonObject jsonObject)
    {
        super(jsonObject);
        status=jsonObject.get(KJS.USER_STATUS).getAsInt();
        message=false;
    }

    public void reload(JsonObject jsonObject)
    {
        super.reload(jsonObject);
        status=jsonObject.get(KJS.USER_STATUS).getAsInt();
    }

    public int getStatus()
    {
        return status;
    }

    public boolean isMessage()
    {
        return message;
    }

    public void setMessage(boolean message)
    {
        this.message = message;
    }
}
