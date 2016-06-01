package aisoai.screens.titentities.activity;

import aisoai.config.ClientConfig;

class TITTabActivityUIDefine
{
    public static int SPECICONIV_WIDTH()
    {
        Float f=30f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int SPECICONIV_HEIGHT()
    {
        return SPECICONIV_WIDTH();
    }
}