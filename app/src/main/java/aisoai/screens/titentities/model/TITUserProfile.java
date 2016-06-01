package aisoai.screens.titentities.model;

import android.graphics.Bitmap;

import com.google.gson.JsonObject;

import aisoai.config.KJS;
import aisoai.loadnetimage.TITRequestImage;

abstract public class TITUserProfile
{
    protected int systemUserId;
    protected String userId;
    protected String fullName;
    protected String facebookId;
    protected String facebookUrl;
    protected String avatarUrl;
    protected String gender;
    protected Bitmap avatarBitmap;

    public TITUserProfile(JsonObject jsonObject)
    {
        systemUserId=jsonObject.get(KJS.SYSTEM_USER_ID).getAsInt();
        userId=jsonObject.get(KJS.USER_ID).getAsString();
        fullName=jsonObject.get(KJS.FULL_NAME).getAsString();
        facebookId=jsonObject.get(KJS.FACEBOOK_ID).getAsString();
        facebookUrl=jsonObject.get(KJS.FACEBOOK_URL).getAsString();
        avatarUrl=jsonObject.get(KJS.AVATAR_URL).getAsString();
        gender=jsonObject.get(KJS.GENDER).getAsString();
        int avatarPriority;
        if(jsonObject.get(KJS.AVATAR_PRIORITY)==null)
        {
            avatarPriority=4;
        }
        else
        {
            avatarPriority=jsonObject.get(KJS.AVATAR_PRIORITY).getAsInt();
        }
        new TITRequestImage(avatarUrl,avatarPriority)
        {
            @Override
            protected void setImage(Bitmap bitmap)
            {
                avatarBitmap=bitmap;
                reloadImage(bitmap);
            }
        };
    }

    abstract public void reloadImage(Bitmap bitmap);

    public int getSystemUserId()
    {
        return systemUserId;
    }

    public void setSystemUserId(int systemUserId)
    {
        this.systemUserId = systemUserId;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getFacebookId()
    {
        return facebookId;
    }

    public void setFacebookId(String facebookId)
    {
        this.facebookId = facebookId;
    }

    public String getFacebookUrl()
    {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl)
    {
        this.facebookUrl = facebookUrl;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getAvatarUrl()
    {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl)
    {
        this.avatarUrl = avatarUrl;
    }

    public Bitmap getAvatarBitmap()
    {
        return avatarBitmap;
    }

    public void setAvatarBitmap(Bitmap avatarBitmap)
    {
        this.avatarBitmap = avatarBitmap;
    }
}
