package aisoai.screens.gamescreeens.carogame;

import org.andengine.util.color.Color;

import aisoai.screens.gamescreeens.titentities.TITGameConfig;

public class CaroGameConfig
{
    public static float CAMERA_WIDTH= TITGameConfig.SCREEN_HEIGHT;
    public static float CAMERA_HEIGHT=TITGameConfig.SCREEN_WIDTH;

    public static float GS_WIDTH=CAMERA_HEIGHT;
    public static float GS_HEIGHT=CAMERA_HEIGHT;

    public static float HUD_WIDTH=CAMERA_WIDTH-GS_WIDTH;
    public static float HUD_HEIGHT=CAMERA_HEIGHT;

    public static float AVATAR_WIDTH()
    {
        return 80*CAMERA_HEIGHT/320;
    }

    public static float AVATAR_HEIGHT()
    {
        return AVATAR_WIDTH();
    }

    public static float AVATAR_X()
    {
        return 50*HUD_WIDTH/160-AVATAR_WIDTH()/2;
    }

    public static float AVATAR_Y(boolean top)
    {
        if(top)
            return 50*HUD_HEIGHT/320-AVATAR_HEIGHT()/2;
        else
            return 270*HUD_HEIGHT/320-AVATAR_WIDTH()/2;
    }

    public static float BOUT_WIDTH()
    {
        return 40*CAMERA_HEIGHT/320;
    }

    public static float BOUT_HEIGHT()
    {
        return BOUT_WIDTH();
    }

    public static float BOUT_X()
    {
        return 130*HUD_WIDTH/160-BOUT_WIDTH()/2;
    }

    public static float BOUT_Y(boolean top)
    {
        if(top)
            return 50*HUD_HEIGHT/320-BOUT_HEIGHT()/2;
        else
            return 270*HUD_HEIGHT/320-BOUT_HEIGHT()/2;
    }

    public static float HIDEN_BOUT_Y()
    {
        return -BOUT_HEIGHT();
    }

    public static float LINE_SPACE_WIDTH()
    {
        return 20*CAMERA_HEIGHT/320;
    }

    public static float LINE_SPACE_HEIGHT()
    {
        return LINE_SPACE_WIDTH();
    }

    public static float HORLINE_X(int column)
    {
        return (column-1)* LINE_SPACE_WIDTH();
    }

    public static float VERLINE_Y(int row)
    {
        return (row-1)* LINE_SPACE_HEIGHT();
    }

    public static float ITEM_WIDTH()
    {
        return 18*CAMERA_HEIGHT/320;
    }

    public static float ITEM_HEIGHT()
    {
        return ITEM_WIDTH();
    }

    public static float ITEM_X(int column)
    {
        return (column-0.5f)*LINE_SPACE_WIDTH()-ITEM_WIDTH()/2;
    }

    public static float ITEM_Y(int row)
    {
        return (row-0.5f)*LINE_SPACE_HEIGHT()-ITEM_HEIGHT()/2;
    }

    public static float ITEMCENTER_X(int column)
    {
        return (column-0.5f)*LINE_SPACE_WIDTH();
    }

    public static float ITEMCENTER_Y(int row)
    {
        return (row-0.5f)*LINE_SPACE_HEIGHT();
    }

    public static Color LINE_COLOR=Color.GREEN;

    public static float WINLINE_WIDTH()
    {
        return 3*CAMERA_HEIGHT/320;
    }

    public static int TIME_TEXT_LAYER=16;
    public static int AVATAR_LAYER=16;
    public static int BOUT_LAYER=16;
}
