package aisoai.screens.startscreen;

import aisoai.config.ClientConfig;

public class StartAcUIDefine
{
    public static int LOGOIV_WIDTH()
    {
        Float f=180f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int LOGOIV_HEIGHT()
    {
        Float f=120f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }
}
