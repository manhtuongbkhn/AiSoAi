package aisoai.screens.insidetabscreen.insideroomscreen.invitation;

import com.google.gson.JsonObject;

import aisoai.config.KJS;
import aisoai.screens.titentities.model.TITUserInfo;

abstract public class InvitationFriendInfo extends TITUserInfo
{
    private int status;

    public InvitationFriendInfo(JsonObject jsonObject)
    {
        super(jsonObject);
        status=jsonObject.get(KJS.USER_STATUS).getAsInt();
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
}
