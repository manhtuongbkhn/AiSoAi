package aisoai.screens.titentities.dialog;

import aisoai.config.ClientConfig;
import aisoai.config.UIDefine;

public class MoreUserInfoDialogUIDefine
{
    public static int MOREUSERINFODL_WIDTH()
    {
        Float f = 280f * ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int USERAVATARIV_WIDTH()
    {
        Float f=55f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int USERAVATARIV_HEIGHT()
    {
        return USERAVATARIV_WIDTH();
    }


    public static int GENDERIV_WIDTH()
    {
        Float f=25f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int GENDERIV_HEIGHT()
    {
        return GENDERIV_WIDTH();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public static int GAMEMATURITYITEM_WIDTH()
    {
        Float f=280*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int GAMEMATURITYITEM_HEIGHT()
    {
        Float f=60*ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    public static int GAMEICONIV_WIDTH()
    {
        Float f=45*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int GAMEICONIV_HEIGHT()
    {
        return GAMEICONIV_WIDTH();
    }

    public static int RANKIV_WIDTH()
    {
        Float f=45*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int RANKIV_HEIGHT()
    {
        return RANKIV_WIDTH();
    }
}