package aisoai.screens.titentities.dialog.choicegamedialog;

import aisoai.config.ClientConfig;

public class ChoiceGameUIDefine
{
    public static int CHOICEGAMEDL_WIDTH()
    {
        Float f=280f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int CHOICEGAMEDL_HEIGHT()
    {
        Float f=280f* ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    /////////////////////////////////////////////////

    public static int ITEM_WIDTH()
    {
        Float f=93f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int ITEM_HEIGHT()
    {
        Float f=100f*ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    public static int GAMEICONIV_WIDTH()
    {
        Float f=80f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int GAMEICON_HEIGHT()
    {
        return GAMEICONIV_WIDTH();
    }
}
