package aisoai.screens.titentities.model;

import android.graphics.Bitmap;

import com.google.gson.JsonObject;

import aisoai.config.KJS;
import aisoai.loadnetimage.TITRequestImage;

abstract public class TITMessageInfo
{
    protected String userId;
    protected int systemUserId;
    protected String fullName;
    protected String time;
    protected String message;
    protected Bitmap avatar;

    public TITMessageInfo(JsonObject jsonObject)
    {
        userId=jsonObject.get(KJS.USER_ID).getAsString();
        systemUserId=jsonObject.get(KJS.SYSTEM_USER_ID).getAsInt();
        fullName =jsonObject.get(KJS.FULL_NAME).getAsString();
        time =jsonObject.get(KJS.SEND_TIME).getAsString();
        message =jsonObject.get(KJS.MESSAGE_CONTENT).getAsString();
        String avatarUrl=jsonObject.get(KJS.AVATAR_URL).getAsString();
        new TITRequestImage(avatarUrl,6)
        {
            @Override
            protected void setImage(Bitmap bitmap)
            {
                avatar =bitmap;
                reloadImage();
            }
        };
    }

    public String getUserId()
    {
        return userId;
    }

    public int getSystemUserId() {
        return systemUserId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    public Bitmap getAvatar() {
        return avatar;
    }

    abstract public void reloadImage();
}
