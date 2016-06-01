package aisoai.screens.insidetabscreen.insideroomscreen;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import aisoai.config.KJS;
import aisoai.screens.titentities.model.TITUserInfo;
import aisoai.titapplib.TITFunction;

abstract public class PlayerInfo extends TITUserInfo
{
    protected boolean isOwner;

    public PlayerInfo(JsonObject jsonObject)
    {
        super(jsonObject);
        isOwner=jsonObject.get(KJS.IS_OWNER).getAsBoolean();
    }

    public boolean isOwner()
    {
        return isOwner;
    }
}
