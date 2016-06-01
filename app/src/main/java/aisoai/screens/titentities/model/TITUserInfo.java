package aisoai.screens.titentities.model;

import android.graphics.Bitmap;
import com.google.gson.JsonObject;

abstract public class TITUserInfo
{
    protected TITUserProfile userProfile;
    protected TITGameUserInfo gameUserInfo;


    public TITUserInfo(JsonObject jsonObject)
    {
        userProfile=new TITUserProfile(jsonObject)
        {
            @Override
            public void reloadImage(Bitmap bitmap)
            {
                TITUserInfo.this.reloadImage(bitmap);
            }
        };
        gameUserInfo=new TITGameUserInfo(jsonObject);
    }

    public void reload(JsonObject jsonObject)
    {
        gameUserInfo=new TITGameUserInfo(jsonObject);
    }

    abstract public void reloadImage(Bitmap bitmap);

    public boolean equals(Object otherObject)
    {
        if(otherObject instanceof TITUserInfo)
        {
            TITUserInfo otherUserInfo=(TITUserInfo) otherObject;
            boolean b1=userProfile.getSystemUserId()==otherUserInfo.getUserProfile().getSystemUserId();
            boolean b2=userProfile.getUserId()==otherUserInfo.getUserProfile().getUserId();
            return b1&&b2;
        }
        else
            return false;
    }

    public TITUserProfile getUserProfile()
    {
        return userProfile;
    }

    public void setUserProfile(TITUserProfile userProfile)
    {
        this.userProfile = userProfile;
    }

    public TITGameUserInfo getGameUserInfo()
    {
        return gameUserInfo;
    }

    public void setGameUserInfo(TITGameUserInfo gameUserInfo)
    {
        this.gameUserInfo = gameUserInfo;
    }
}
