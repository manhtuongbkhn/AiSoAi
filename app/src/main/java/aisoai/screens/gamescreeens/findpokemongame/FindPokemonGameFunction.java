package aisoai.screens.gamescreeens.findpokemongame;

public class FindPokemonGameFunction
{
    public static int getBeginColumn(int widthColumn)
    {
        switch (widthColumn)
        {
            case 2:
            case 3:
                return 2;
            case 4:
            case 5:
            default:
                return 1;
        }
    }

    public static int getBeginRow(int heightRow)
    {
        switch (heightRow)
        {
            case 2:
                return 3;
            case 3:
            case 4:
                return 2;
            case 5:
            case 6:
            default:
                return 1;
        }
    }
}
