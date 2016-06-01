package aisoai.screens.hometabscreen.friendtabcreen.friendlistscreen;

import aisoai.config.ClientConfig;

public class FriendListUIDefine
{
    public static int ITEM_WIDTH()
    {
        Float f=320f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int ITEM_HEIGHT()
    {
        Float f=70f*ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    public static int FRIENDAVATARIV_WIDTH()
    {
        Float f=60f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int FRIENDAVATAR_HEIGHT()
    {
        return FRIENDAVATARIV_WIDTH();
    }

    public static int PLAYERNAMETV_WIDTH()
    {
        Float f=120f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int PLAYERNAMETV_HEIGHT()
    {
        Float f=30f*ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    public static int MESSAGEIV_WIDTH()
    {
        Float f=25*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int MESSAGEIV_HEIGHT()
    {
        return MESSAGEIV_WIDTH();
    }

    public static int RANKIV_WIDTH()
    {
        Float f=30*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int RANKIV_HEIGHT()
    {
        Float f=30*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int PLAYERRANKIV_WIDTH()
    {
        Float f=30f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int PLAYERRANKIV_HEIGHT()
    {
        return PLAYERRANKIV_WIDTH();
    }


    public static int MOREINFOIBT_WIDTH()
    {
        Float f=30f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int MOREINFOIBT_HEIGHT()
    {
        return MOREINFOIBT_WIDTH();
    }

    public static int STATUSIV_WIDTH()
    {
        Float f=20f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int STATUSIV_HEIGHT()
    {
        return STATUSIV_WIDTH();
    }
}
