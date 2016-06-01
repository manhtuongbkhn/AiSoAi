package aisoai.screens.hometabscreen.homeprofilescreen;

import aisoai.config.ClientConfig;
import aisoai.config.UIDefine;

public class ProfileUIDefine
{
    public static int USERAVATARIV_WIDTH()
    {
        Float f=60f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int USERAVATARIV_HEIGHT()
    {
        return USERAVATARIV_WIDTH();
    }


    public static int GENDERIV_WIDTH()
    {
        Float f=30f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int GENDERIV_HEIGHT()
    {
        return GENDERIV_WIDTH();
    }

    public static int CHALLENGEIBT_WIDTH()
    {
        Float f=100f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int CHALLENGEIBT_HEIGHT()
    {
        Float f=40f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int TRAININGIBT_WIDTH()
    {
        Float f=100f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int SHAREBT_WIDTH()
    {
        Float f=70f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int SHAREBT_HEIGHT()
    {
        Float f=30f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static float SHARETEXT_SIZE()
    {
        return 10f*ClientConfig.SCREEN_WIDTH_DP/320;
    }

    public static int TRANINGIBT_HEIGHT()
    {
        Float f=40f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public static int CHALLENGEWAITINGDL_WIDTH()
    {
        Float f=280*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int CHALLENGEWAITTINGDL_HEIGHT()
    {
        Float f=140*ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public static int GAMEMATURITYITEM_WIDTH()
    {
        Float f=320*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int GAMEMATURITYITEM_HEIGHT()
    {
        Float f=70*ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    public static int GAMEICONIV_WIDTH()
    {
        Float f=50*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int GAMEICONIV_HEIGHT()
    {
        return GAMEICONIV_WIDTH();
    }

    public static int RANKIV_WIDTH()
    {
        Float f=50*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int RANKIV_HEIGHT()
    {
        return RANKIV_WIDTH();
    }
}
