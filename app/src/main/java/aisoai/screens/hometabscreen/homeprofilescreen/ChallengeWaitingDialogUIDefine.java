package aisoai.screens.hometabscreen.homeprofilescreen;

import aisoai.config.ClientConfig;

public class ChallengeWaitingDialogUIDefine
{
    public static int CONFIRMIBT_WIDTH()
    {
        return ChallengeDialogUIDefine.CONFIRMIBT_WIDTH();
    }

    public static int CONFIRMIBT_HEIGHT()
    {
        return CONFIRMIBT_WIDTH();
    }

    public static int CANCELIBT_WIDTH()
    {
        return CONFIRMIBT_WIDTH();
    }

    public static int CANCELIBT_HEIGHT()
    {
        return CONFIRMIBT_WIDTH();
    }

    public static int WAITINGPB_WIDTH()
    {
        Float f=70*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int WAITINGPB_HEIGHT()
    {
        return WAITINGPB_WIDTH();
    }
}
