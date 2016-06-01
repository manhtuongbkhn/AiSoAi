package aisoai.screens.hometabscreen.settings;

import aisoai.config.ClientConfig;

public class SettingsUIDefine
{
    public static int IBT_WIDTH()
    {
        Float f=200f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int IBT_HEIGHT()
    {
        Float f=40f*ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }
}
