package aisoai.screens.gamescreeens.carogame;

public class CaroGameFunction
{
    public static int getItemIndex(int itemRow,int itemColumn)
    {
        return itemColumn-1+(itemRow-1)*16;
    }

    public static int getItemRow(int itemIndex)
    {
        return itemIndex/16+1;
    }

    public static int getItemColumn(int itemIndex)
    {
        return itemIndex%16+1;
    }

}
