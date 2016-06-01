package aisoai.screens.insidetabscreen.chatroomscreen;

import aisoai.config.ClientConfig;

public class ChatRoomUIDefine
{
    public static int MESSAGELV_WIDTH()
    {
        Float f=320f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int MESSAGELV_HEIGHT()
    {
        Float f=360f*ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    //Item Message
    public static int ITEM_WIDTH()
    {
        Float f=320f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int PLAYERAVATARLL_WIDTH()
    {
        Float f=60f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int PLAYERAVATARIV_WIDTH()
    {
        Float f=50f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int PLAYERAVATARIV_HEIGHT()
    {
        return PLAYERAVATARIV_WIDTH();
    }


    public static int TIMETV_WIDTH()
    {
        Float f=80*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int TIMETV_HEIGHT()
    {
        Float f=20*ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    public static int MAXMESSAGELL_WIDTH()
    {
        Float f=230f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int MAXPLAYERNAME_WIDTH()
    {
       return MAXMESSAGELL_WIDTH()-TIMETV_WIDTH();
    }

    public static int PLAYERNAMETV_HEIGHT()
    {
        return TIMETV_HEIGHT();
    }

    public static int MESSAGETV_HEIGHT(int lineCount)
    {
        Float f=(10+lineCount*10)*ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }
    ///////////////////////////////////////////////////////////////////////////////

    public static int TYPINGMESSAGEET_WIDTH()
    {
        Float f=180f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int TYPINGMESSAGEET_HEIGHT()
    {
        Float f=40f*ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    public static int EMOTICONIBT_WIDTH()
    {
        Float f=30f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int EMOTICONIBT_HEIGHT()
    {
        return EMOTICONIBT_WIDTH();
    }

    public static int SENDIBT_WIDTH()
    {
        Float f=60f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int SENDIBT_HEIGHT()
    {
        return SENDIBT_WIDTH();
    }
}
