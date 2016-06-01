package aisoai.screens.gamescreeens.titentities.titsinglegame;

import android.graphics.Color;

import aisoai.config.ClientConfig;
import aisoai.config.UIDefine;
import aisoai.screens.gamescreeens.titentities.TITGameConfig;

public class TITSingleGameConfig
{
    public static float AVATAR_WIDTH()
    {
        return 50f* TITGameConfig.SCREEN_WIDTH/320f;
    }

    public static float AVATAR_HEIGHT()
    {
        return AVATAR_WIDTH();
    }

    public static float HUD_WIDTH()
    {
        return TITGameConfig.SCREEN_WIDTH;
    }

    public static float HUD_HEIGHT()
    {
        return (90f/320f)* TITGameConfig.SCREEN_WIDTH;
    }

    public static float GS_WIDTH()
    {
        return TITGameConfig.SCREEN_WIDTH;
    }

    public static float GS_HEIGHT()
    {
        return TITGameConfig.SCREEN_HEIGHT-HUD_HEIGHT();
    }

    public static float CAMERA_X()
    {
        return 0.0f* TITGameConfig.SCREEN_WIDTH;
    }

    public static float CAMERA_Y()
    {
        return -HUD_HEIGHT();
    }

    public static float CENTER_AVATAR1_X()
    {
        return (90f/320f)* TITGameConfig.SCREEN_WIDTH;
    }

    public static float CENTER_AVATAR2_X()
    {
        return (230f/320f)* TITGameConfig.SCREEN_WIDTH;
    }

    public static float CENTER_AVATAR3_X()
    {
        return (30f/320f)* TITGameConfig.SCREEN_WIDTH;
    }

    public static float CENTER_AVATAR4_X()
    {
        return (290f/320f)* TITGameConfig.SCREEN_WIDTH;
    }

    public static float CENTER_AVATAR_Y()
    {
        return (30f/320f)* TITGameConfig.SCREEN_WIDTH;
    }

    public static int TIME_FONT_SIZE()
    {
        Float f= UIDefine.MAXTEXT_SIZE()* ClientConfig.SCREEN_WIDTH_PX/320;
        return f.intValue();
    }

    public static int POINT_FONT_SIZE()
    {
        Float f=UIDefine.BIGTEXT_SIZE()*ClientConfig.SCREEN_WIDTH_PX/320;
        return f.intValue();
    }

    public static float CENTER_POINT1_X()
    {
        return (90f/320f)* TITGameConfig.SCREEN_WIDTH;
    }

    public static float CENTER_POINT2_X()
    {
        return (230f/320f)* TITGameConfig.SCREEN_WIDTH;
    }

    public static float CENTER_POINT3_X()
    {
        return (30f/320f)* TITGameConfig.SCREEN_WIDTH;
    }

    public static float CENTER_POINT4_X()
    {
        return (290f/320f)* TITGameConfig.SCREEN_WIDTH;
    }

    public static float CENTER_POINT_Y()
    {
        return (75f/320)* TITGameConfig.SCREEN_WIDTH;
    }

    public static int TIME_COLOR= Color.argb(255, 7, 42, 255);
    public static int POINT_COLOR= Color.BLUE;

    public static int TIME_MAX_CHAR=3;
    public static int POINT_MAX_CHAR=4;
    public static int AVARTA_LAYER=20;
    public static int TIME_TEXT_LAYER=20;
    public static int POINT_TEXT_LAYER=20;
}
