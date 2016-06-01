package aisoai.screens.hometabscreen.topuser;

import com.google.gson.JsonObject;

import aisoai.config.KJS;
import aisoai.screens.titentities.model.TITUserInfo;

abstract public class TopPlayerInfo extends TITUserInfo
{
    protected int rankPostion;
    protected int rankPoint;

    public TopPlayerInfo(JsonObject jsonObject)
    {
        super(jsonObject);
        rankPostion=jsonObject.get(KJS.RANK_POSTION).getAsInt();
        rankPoint=jsonObject.get(KJS.RANK_POINT).getAsInt();
    }

    public int getRankPostion()
    {
        return rankPostion;
    }

    public int getRankPoint()
    {
        return rankPoint;
    }
}
