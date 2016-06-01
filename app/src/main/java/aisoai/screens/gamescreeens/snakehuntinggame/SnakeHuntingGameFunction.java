package aisoai.screens.gamescreeens.snakehuntinggame;

class SnakeHuntingGameFunction
{
    public static int getItemIndex(int itemRow,int itemColumn)
    {
        return itemColumn-1+(itemRow-1)*20;
    }

    public static int getItentRow(int itemIndex)
    {
        return itemIndex/20+1;
    }

    public static int getItemColumn(int itemIndex)
    {
        return itemIndex%20+1;
    }
}