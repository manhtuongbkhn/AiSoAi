package aisoai.screens.scoringscreen;

import aisoai.config.ClientConfig;
import aisoai.config.UIDefine;

public class ScoringUIDefine
{
    public static int ROOMAVATARIV_WIDTH()
    {
        Float f=50f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int ROOMAVATARIV_HEIGHT()
    {
        Float f=50f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int GAMEICONIV_WIDTH()
    {
        Float f=50f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int GAMEICONIV_HEIGHT()
    {
        Float f=50f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int WINERIV_WIDTH()
    {
        Float f=60f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int WINERIV_HEIGHT()
    {
        Float f=60f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int CUPIV_WIDTH()
    {
        Float f=50f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int CUPIV_HEIGHT()
    {
        Float f=50f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int EXITROOMBT_WIDTH()
    {
        Float f=50f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int EXITROOMBT_HEIGHT()
    {
        Float f=50f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int RIGHTLL_WIDTH()
    {
        Float f=240f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int ITEM_HEIGHT()
    {
        Float f=80f*ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    public static int SUMMARYPOINTTEXT_SIZE()
    {
        Float f= UIDefine.GIGATICTEXT_SIZE()*ClientConfig.SCREEN_WIDTH_PX/320;
        return f.intValue();
    }
}
