package aisoai.screens.signinscreen;

import aisoai.config.ClientConfig;

public class SignInAcUIDefine
{
    public static int LOGOIV_WIDTH()
    {
        Float f=180f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int LOGOIV_HEIGHT()
    {
        Float f=120f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int LOGINFBBT_WIDTH()
    {
        Float f=200f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int LOGINFBBT_HEIGHT()
    {
        Float f=40f* ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }
}
