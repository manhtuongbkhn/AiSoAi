package aisoai.screens.gamescreeens.findpokemongame;

import aisoai.screens.gamescreeens.titentities.titsinglegame.TITSingleGameConfig;

public class FindPokemonGameConfig
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
        return TITSingleGameConfig.GS_HEIGHT();
    }

    public static float POKEMONBUTTONBOARD_X()
    {
        return 0;
    }

    public static float POKEMONBUTTONBOARD_Y()
    {
        return 0;
    }
}
