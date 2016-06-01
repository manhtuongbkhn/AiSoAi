package aisoai.screens.hometabscreen.roomlistscreen.createroomdialog;

import aisoai.config.ClientConfig;

public class CreateRoomUIDefine
{
    public static int CREATEROOMDL_WIDTH()
    {
        Float f=280f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int CREATEROOMDL_HEIGHT()
    {
        Float f=280f* ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    public static int INVITEET_WIDTH()
    {
        Float f=150f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int INVITEET_HEIGHT()
    {
        Float f=40f* ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    public static int ROOMAVATARSP_WIDTH()
    {
        Float f=150f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int ROOMAVATARSP_HEIGHT()
    {
        Float f=60f* ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    public static int ROOMAVATARITEM_WIDTH()
    {
        return ROOMAVATARSP_WIDTH();
    }

    public static int ROOMAVATARITEM_HEIGHT()
    {
        return ROOMAVATARSP_HEIGHT();
    }

    public static int ROOMAVATARIV_WIDTH()
    {
        Float f=50f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int ROOMAVATARIV_HEIGHT()
    {
        return ROOMAVATARIV_WIDTH();
    }

    public static int PASSET_WIDTH()
    {
        Float f=150f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int PASSET_HEIGHT()
    {
        Float f=40f* ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    public static int CONFIRMIBT_WIDTH()
    {
        Float f=50f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int CONFIRMIBT_HEIGHT()
    {
        return CONFIRMIBT_WIDTH();
    }

    public static int CANCELIBT_WIDTH()
    {
        Float f=50f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int CANCELIBT_HEIGHT()
    {
        return CANCELIBT_WIDTH();
    }
}
