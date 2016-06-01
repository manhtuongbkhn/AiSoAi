package aisoai.screens.gamescreeens.snakehuntinggame;

import aisoai.screens.gamescreeens.titentities.titsinglegame.TITSingleGameConfig;

public class SnakeHuntingGameConfig
{
    public static float ITEM_WIDTH()
    {
        return 15* TITSingleGameConfig.GS_WIDTH()/320;
    }

    public static float ITEM_HEIGHT()
    {
        return ITEM_WIDTH();
    }

    public static float ITEM_X(int column)
    {
        return (column-1)* ITEM_WIDTH()+10* TITSingleGameConfig.GS_WIDTH()/320;
    }

    public static float ITEM_Y(int row)
    {
        return (row-1)* ITEM_HEIGHT()+10* TITSingleGameConfig.GS_WIDTH()/320;
    }

    public static float DIRECTION_BUTTON_WIDTH()
    {
        return 65* TITSingleGameConfig.GS_WIDTH()/320;
    }

    public static float DIRECTION_BUTTON_HEIGHT()
    {
        return DIRECTION_BUTTON_WIDTH();
    }

    public static float DIRECTION_BUTTON_X(int direction)
    {
        switch (direction)
        {
            case 2:
            case 4:
                return TITSingleGameConfig.GS_WIDTH()/2-DIRECTION_BUTTON_WIDTH()/2;
            case 1:
                return TITSingleGameConfig.GS_WIDTH()/2+DIRECTION_BUTTON_WIDTH()/2;
            case 3:
                return TITSingleGameConfig.GS_WIDTH()/2-3*DIRECTION_BUTTON_WIDTH()/2;
            default:
                return 0;
        }
    }

    public static float DIRECTION_BUTTON_Y(int direction)
    {
        float gsw= TITSingleGameConfig.GS_WIDTH();
        float gsh= TITSingleGameConfig.GS_HEIGHT();
        float gsp=13*gsw/16;
        switch (direction)
        {
            case 1:
            case 2:
            case 3:
                return gsp+(gsh-gsp)/2;
            case 4:
                return gsp+(gsh-gsp)/2-DIRECTION_BUTTON_HEIGHT();
        }
        return DIRECTION_BUTTON_WIDTH();
    }
}
