package aisoai.screens.gamescreeens.doublepokemongame;


import aisoai.screens.gamescreeens.titentities.titsinglegame.TITSingleGameConfig;

public class DoublePokemonGameConfig
{
    public static float BOX_WIDTH()
    {
        return 60* TITSingleGameConfig.GS_WIDTH()/320;
    }

    public static float BOX_HEIGHT()
    {
        return 60* TITSingleGameConfig.GS_HEIGHT()/390;
    }

    public static float POKEMONBUTTON_WIDTH()
    {
        return 60* TITSingleGameConfig.GS_WIDTH()/320;
    }

    public static float POKEMONBUTTON_HEIGHT()
    {
        return POKEMONBUTTON_WIDTH();
    }

    public static float POKEMONBUTTON_X(int column)
    {
        return (40+(column-1)*60)* TITSingleGameConfig.GS_WIDTH()/320-POKEMONBUTTON_WIDTH()/2;
    }

    public static float POKEMONBUTTON_Y(int row)
    {
        return (45+(row-1)*60)* TITSingleGameConfig.GS_HEIGHT()/390-POKEMONBUTTON_HEIGHT()/2;
    }

    public static float POKEMONBUTTONBOARD_WIDTH()
    {
        return TITSingleGameConfig.GS_WIDTH();
    }

    public static float POKEMONBUTTONBOARD_HEIGHT()
    {
        return 330f* TITSingleGameConfig.GS_HEIGHT()/390f;
    }

    public static float POKEMONBUTTONBOARD_X()
    {
        return 0;
    }

    public static float POKEMONBUTTONBOARD_Y()
    {
        return 0;
    }

    public static float MEMORYBUTTON_WIDTH()
    {
        return 200f* TITSingleGameConfig.GS_WIDTH()/320f;
    }

    public static float MEMORYBUTTON_HEIGHT()
    {
        return 50f* TITSingleGameConfig.GS_WIDTH()/320f;
    }

    public static float MEMORYBUTTON_X()
    {
        return 160* TITSingleGameConfig.GS_WIDTH()/320f-MEMORYBUTTON_WIDTH()/2;
    }

    public static float MEMORYBUTTON_Y()
    {
        return 360* TITSingleGameConfig.GS_HEIGHT()/390f-MEMORYBUTTON_HEIGHT()/2;
    }

    public static float MODIFIER_DELAY_TIME()
    {
        return 0.2f;
    }
}
