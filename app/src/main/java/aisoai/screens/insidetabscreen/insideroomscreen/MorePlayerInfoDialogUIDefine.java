package aisoai.screens.insidetabscreen.insideroomscreen;

import aisoai.config.ClientConfig;

class  MorePlayerInfoDialogUIDefine
{
    public static int ADDFRIENDIV_WIDTH()
    {
        Float f=80f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int ROOMAVATARIV_HEIGHT()
    {
        return ADDFRIENDIV_WIDTH()/2;
    }
}