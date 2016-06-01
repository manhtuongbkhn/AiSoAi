package aisoai.screens.gamescreeens.tetrisgame;


import aisoai.screens.gamescreeens.titentities.titsinglegame.TITSingleGameConfig;

public class TetrisGameConfig
{
    public static float ITEM_WIDTH()
    {
        return 20* TITSingleGameConfig.GS_WIDTH()/320;
    }

    public static float ITEM_HEIGHT()
    {
        return ITEM_WIDTH();
    }

    public static float ITEM_X(int itemColumn)
    {
        return (itemColumn-1)* ITEM_WIDTH();
    }

    public static float ITEM_Y(int itemRow)
    {
        return 320*TITSingleGameConfig.GS_WIDTH()/320-itemRow*ITEM_HEIGHT();
    }

    public static float BUTTON_WIDTH()
    {
        return 60*TITSingleGameConfig.GS_WIDTH()/320;
    }

    public static float BUTTON_HEIGHT()
    {
        return BUTTON_WIDTH();
    }

    public static float DIRECTIONBUTTON_X(int direction)
    {
        if(direction==3)
            return 40*TITSingleGameConfig.GS_WIDTH()/320- BUTTON_WIDTH()/2;
        if(direction==2)
            return 120*TITSingleGameConfig.GS_WIDTH()/320- BUTTON_WIDTH()/2;
        if(direction==1)
            return 200*TITSingleGameConfig.GS_WIDTH()/320- BUTTON_WIDTH()/2;
        return 0;
    }

    public static float ROTATEBUTTON_X()
    {
        return 280*TITSingleGameConfig.GS_WIDTH()/320- BUTTON_WIDTH()/2;
    }

    public static float BUTTON_Y()
    {
        float gsw=TITSingleGameConfig.GS_WIDTH();
        float gsh=TITSingleGameConfig.GS_HEIGHT();

        return gsw+(gsh-gsw)/2- BUTTON_WIDTH()/2;
    }

    public static float POINT_X(int pointColumn)
    {
        return (pointColumn-1)*ITEM_WIDTH();
    }

    public static float POINT_Y(int pointRow)
    {
        return 320*TITSingleGameConfig.GS_WIDTH()/320-(pointRow-1)*ITEM_HEIGHT();
    }

    public static float NEXT_BRICK_WIDTH()
    {
        return 80*TITSingleGameConfig.GS_WIDTH()/320;
    }

    public static float NEXT_BRICK_HEIGHT()
    {
        return NEXT_BRICK_WIDTH();
    }

    public static float NEXT_BRICK_X()
    {
        return 240*TITSingleGameConfig.GS_WIDTH()/320;
    }

    public static float NEXT_BRICK_Y()
    {
        return 0;
    }

    public static int CENTER_ROW=19;
    public static int CENTER_COLUMN=7;

    public static float LINE_WIDTH()
    {
        return 1*TITSingleGameConfig.GS_WIDTH()/320;
    }
}