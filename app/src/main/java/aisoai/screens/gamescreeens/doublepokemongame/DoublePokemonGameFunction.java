package aisoai.screens.gamescreeens.doublepokemongame;

public class DoublePokemonGameFunction
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
            case 3:
                return 2;
            case 4:
            case 5:
            default:
                return 1;
        }
    }
}
