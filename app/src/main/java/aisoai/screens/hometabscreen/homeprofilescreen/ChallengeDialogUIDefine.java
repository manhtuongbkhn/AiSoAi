package aisoai.screens.hometabscreen.homeprofilescreen;

import aisoai.config.ClientConfig;

public class ChallengeDialogUIDefine
{
    public static int CHALLENGEDL_WIDTH()
    {
        Float f=280*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int CHALLENGEDL_HEIGHT()
    {
        Float f=190*ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    public static int CONFIRMIBT_WIDTH()
    {
        Float f=50* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int CONFIRMIBT_HEIGHT()
    {
        return CONFIRMIBT_WIDTH();
    }

    public static int CANCELIBT_WIDTH()
    {
        Float f=50*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int CANCELIBT_HEIGHT()
    {
        return CONFIRMIBT_WIDTH();
    }

    public static int GAMESP_WIDTH()
    {
        Float f=140* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int GAMESP_HEIGHT()
    {
        Float f=100*ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    public static int GAMEITEM_WIDTH()
    {
        Float f=140* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int GAMEITEM_HEIGHT()
    {
        Float f=100*ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    public static int GAMEICONIV_WIDTH()
    {
        Float f=70* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int GAMEICONIV_HEIGHT()
    {
        return GAMEICONIV_WIDTH();
    }
}
