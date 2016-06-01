package aisoai.screens.gamescreeens.tetrisgame;

public class TetrisGameFuction
{
    public static int getItemIndex(int itemRow,int itemColumn)
    {
        return itemColumn-1+(itemRow-1)*12;
    }

    public static int getItemRow(int itemIndex)
    {
        return itemIndex/12+1;
    }

    public static int getItemColumn(int itemIndex)
    {
        return itemIndex%12+1;
    }

    public static int getPointIndex(int pointRow,int pointColumn)
    {
        return pointColumn-1+(pointRow-1)*13;
    }

    public static int getPointRow(int pointIndex)
    {
        return pointIndex/13+1;
    }

    public static int getPointColumn(int pointIndex)
    {
        return pointIndex%13+1;
    }

    public static int rotate90(int itemIndex,int centerRow,int centerColumn)
    {
        int itemRow=TetrisGameFuction.getItemRow(itemIndex);
        int itemColumn=TetrisGameFuction.getItemColumn(itemIndex);

        int nextRow=-1;
        int nextColumn=-1;

        if (itemRow==centerRow+1&&itemColumn==centerColumn-2)//(4,1)
        {
            //(4,4)
            nextRow=centerRow+1;
            nextColumn=centerColumn+1;
        }

        if (itemRow==centerRow+1&&itemColumn==centerColumn-1)//(4,2)
        {
            //(3,4)
            nextRow=centerRow;
            nextColumn=centerColumn+1;
        }

        if (itemRow==centerRow+1&&itemColumn==centerColumn)//(4,3)
        {
            //(2,4)
            nextRow=centerRow-1;
            nextColumn=centerColumn+1;
        }

        if (itemRow==centerRow+1&&itemColumn==centerColumn+1)//(4,4)
        {
            //(1,4)
            nextRow=centerRow-2;
            nextColumn=centerColumn+1;
        }

        if (itemRow==centerRow&&itemColumn==centerColumn+1)//(3,4)
        {
            //(1,3)
            nextRow=centerRow-2;
            nextColumn=centerColumn;
        }

        if (itemRow==centerRow-1&&itemColumn==centerColumn+1)//(2,4)
        {
            //(1,2)
            nextRow=centerRow-2;
            nextColumn=centerColumn-1;
        }

        if (itemRow==centerRow-2&&itemColumn==centerColumn+1)//(1,4)
        {
            //(1,1)
            nextRow=centerRow-2;
            nextColumn=centerColumn-2;
        }

        if (itemRow==centerRow-2&&itemColumn==centerColumn)//(1,3)
        {
            //(2,1)
            nextRow=centerRow-1;
            nextColumn=centerColumn-2;
        }

        if (itemRow==centerRow-2&&itemColumn==centerColumn-1)//(1,2)
        {
            //(3,1)
            nextRow=centerRow;
            nextColumn=centerColumn-2;
        }

        if (itemRow==centerRow-2&&itemColumn==centerColumn-2)//(1,1)
        {
            //(4,1)
            nextRow=centerRow+1;
            nextColumn=centerColumn-2;
        }

        if (itemRow==centerRow-1&&itemColumn==centerColumn-2)//(2,1)
        {
            //(4,2)
            nextRow=centerRow+1;
            nextColumn=centerColumn-1;
        }

        if (itemRow==centerRow&&itemColumn==centerColumn-2)//(3,1)
        {
            //(4,3)
            nextRow=centerRow+1;
            nextColumn=centerColumn;
        }

        if (itemRow==centerRow&&itemColumn==centerColumn-1)//(3,2)
        {
            //(3,3)
            nextRow=centerRow;
            nextColumn=centerColumn;
        }

        if (itemRow==centerRow&&itemColumn==centerColumn)//(3,3)
        {
            //(2,3)
            nextRow=centerRow-1;
            nextColumn=centerColumn;
        }

        if (itemRow==centerRow-1&&itemColumn==centerColumn)//(2,3)
        {
            //(2,2)
            nextRow=centerRow-1;
            nextColumn=centerColumn-1;
        }

        if (itemRow==centerRow-1&&itemColumn==centerColumn-1)//(2,2)
        {
            //(3,2)
            nextRow=centerRow;
            nextColumn=centerColumn-1;
        }

        int nextIndex=TetrisGameFuction.getItemIndex(nextRow,nextColumn);
        return nextIndex;
    }
}
