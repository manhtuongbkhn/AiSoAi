package aisoai.screens.hometabscreen.roomlistscreen;

import aisoai.config.ClientConfig;

public class RoomListUIDefine
{
    //Item List
    public static int ITEM_WIDTH()
    {
        Float f=ClientConfig.SCREEN_WIDTH_PX;
        return f.intValue();
    }

    public static int ITEM_HEIGHT()
    {
        Float f=70f*ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    public static int ROOMAVATARIV_WIDTH()
    {
        Float f=60f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int ROOMAVATARIV_HEIGHT()
    {
        return ROOMAVATARIV_WIDTH();
    }

    public static int ROOMLOCKIV_WIDTH()
    {
        Float f=20f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int ROOMLOCKIV_HEIGHT()
    {
        return ROOMLOCKIV_WIDTH();
    }

    public static int PLAYERICONIV_WIDTH()
    {
        Float f=20f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int PLAYERICONIV_HEIGHT()
    {
        return PLAYERICONIV_WIDTH();
    }

    //List Room Bot

    public static int GAMEICONIBT_WIDTH()
    {
        Float f=50f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int GAMEICONIBT_HEIGHT()
    {
        Float f=50f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int CREATEROOMIBT_WIDTH()
    {
        Float f=50f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int CREATEROOMIBT_HEIGHT()
    {
        Float f=50f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int ROOMSEARCHET_WIDTH()
    {
        Float f = 140f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int ROOMSEARCHET_HEIGHT()
    {
        Float f = 40f*ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public static int PASSWORDDL_WIDTH()
    {
        Float f = 280f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int PASSWORDDL_HEIGHT()
    {
        Float f=100f*ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    public static int PASSWORDET_WIDTH()
    {
        Float f=230f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int PASSWORDET_HEIGHT()
    {
        Float f=40f*ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    public static int CONFIRMIBT_WIDTH()
    {
        Float f = 40f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int CONFIRMIBT_HEIGHT()
    {
        return CONFIRMIBT_WIDTH();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
}