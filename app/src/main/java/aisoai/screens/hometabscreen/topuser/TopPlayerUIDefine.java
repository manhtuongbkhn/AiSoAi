package aisoai.screens.hometabscreen.topuser;

import aisoai.config.ClientConfig;

public class TopPlayerUIDefine
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

    public static int PLAYERAVATARIV_WIDTH()
    {
        Float f=60f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int PLAYERAVATAR_HEIGHT()
    {
        return PLAYERAVATARIV_WIDTH();
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

    public static int MOREINFOIBT_WIDTH()
    {
        Float f=30f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int MOREINFOIBT_HEIGHT()
    {
        return MOREINFOIBT_WIDTH();
    }

}
