package aisoai.screens.gamescreeens.tetrisgame.brick;

import java.util.ArrayList;

import aisoai.screens.gamescreeens.tetrisgame.BrickItem;
import aisoai.screens.gamescreeens.tetrisgame.TetrisGameConfig;
import aisoai.screens.gamescreeens.tetrisgame.TetrisGameControl;
import aisoai.screens.gamescreeens.tetrisgame.TetrisGameFuction;

public class Brick
{
    protected TetrisGameControl control;
    protected int centerRow;
    protected int centerColumn;
    protected ArrayList<BrickItem> birckItemArr=new ArrayList<>();
    protected boolean stop=true;

    protected int slowRunTimeMillis;
    protected int runTimeMillis;

    public Brick(TetrisGameControl iControl,int iSlowRunTimeMillis)
    {
        this.control=iControl;
        this.slowRunTimeMillis=iSlowRunTimeMillis;
        this.runTimeMillis=this.slowRunTimeMillis;
    }

    public void addBrickItem(BrickItem brickItem)
    {
        birckItemArr.add(brickItem);
    }

    public ArrayList<BrickItem> getBirckItemArr()
    {
        return birckItemArr;
    }

    public int getCenterRow()
    {
        return centerRow;
    }

    public void setCenterRow(int centerRow)
    {
        this.centerRow = centerRow;
    }

    public int getCenterColumn()
    {
        return centerColumn;
    }

    public void setCenterColumn(int centerColumn)
    {
        this.centerColumn = centerColumn;
    }

    public int getSlowRunTimeMillis()
    {
        return slowRunTimeMillis;
    }

    public void move()
    {
        stop=false;
        Thread thread=new Thread()
        {
            @Override
            public void run()
            {
                while(!stop)
                {
                    syncBrick("down");
                    try {Thread.sleep(runTimeMillis);} catch (InterruptedException e) {}
                }
            }
        };
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }

    public void stop()
    {
        stop=true;
    }

    public void rotate90()
    {
        syncBrick("rotate90");
    }

    public void setSpeed(int iRunTimeMillis)
    {
        this.runTimeMillis=iRunTimeMillis;
    }

    public void turnLeft()
    {
        syncBrick("turnLeft");
    }

    public void turnRight()
    {
        syncBrick("turnRight");
    }



    synchronized private void syncBrick(String methodName)
    {
        switch (methodName)
        {
            case "rotate90":
                syncRotate90();
                break;
            case "turnLeft":
                syncTurnLeft();
                break;
            case "turnRight":
                syncTurnRight();
                break;
            case "down":
                syncDown();
                break;
            case "increaseSpeed":
                break;
            case "reduceSpeed":
                break;
        }
    }

    private void syncRotate90()
    {
        ArrayList<Integer> nextIndexArr=new ArrayList<>();
        for(int i=0;i<birckItemArr.size();i++)
        {
            BrickItem brickItem=birckItemArr.get(i);
            int nextIndex= TetrisGameFuction.rotate90
                    (brickItem.getIndex(), getCenterRow(), getCenterColumn());
            nextIndexArr.add(nextIndex);
        }
        if(control.getScene().checkNextIndexArrCanWrite(nextIndexArr))
        {
            for (int i = 0; i < birckItemArr.size(); i++)
            {
                BrickItem brickItem = birckItemArr.get(i);
                int nextIndex = TetrisGameFuction.rotate90
                        (brickItem.getIndex(), getCenterRow(), getCenterColumn());
                int nextRow = TetrisGameFuction.getItemRow(nextIndex);
                int nextColumn = TetrisGameFuction.getItemColumn(nextIndex);

                brickItem.setRow(nextRow);
                brickItem.setColumn(nextColumn);
                float newX = TetrisGameConfig.ITEM_X(nextColumn);
                float newY = TetrisGameConfig.ITEM_Y(nextRow);

                brickItem.setX(newX);
                brickItem.setY(newY);
            }
        }
    }

    private void syncTurnLeft()
    {
        ArrayList<Integer> nextIndexArr=new ArrayList<>();
        for(int i=0;i<birckItemArr.size();i++)
        {
            BrickItem brickItem = birckItemArr.get(i);
            int currentRow = brickItem.getRow();
            int currentColumn = brickItem.getColumn();
            int nextRow = currentRow;
            int nextColumn = currentColumn-1;
            int nextIndex=TetrisGameFuction.getItemIndex(nextRow,nextColumn);
            nextIndexArr.add(nextIndex);
        }

        if(control.getScene().checkNextIndexArrCanWrite(nextIndexArr))
        {
            for (int i = 0; i < birckItemArr.size(); i++)
            {
                BrickItem brickItem = birckItemArr.get(i);
                int currentRow = brickItem.getRow();
                int currentColumn = brickItem.getColumn();
                int nextRow = currentRow;
                int nextColumn = currentColumn - 1;
                brickItem.setRow(nextRow);
                brickItem.setColumn(nextColumn);
                float newX = TetrisGameConfig.ITEM_X(nextColumn);
                float newY = TetrisGameConfig.ITEM_Y(nextRow);

                brickItem.setX(newX);
                brickItem.setY(newY);
            }
            centerRow=centerRow;
            centerColumn=centerColumn-1;
        }
    }

    private void syncTurnRight()
    {
        ArrayList<Integer> nextIndexArr=new ArrayList<>();
        for(int i=0;i<birckItemArr.size();i++)
        {
            BrickItem brickItem = birckItemArr.get(i);
            int currentRow = brickItem.getRow();
            int currentColumn = brickItem.getColumn();
            int nextRow = currentRow;
            int nextColumn = currentColumn+1;
            int nextIndex=TetrisGameFuction.getItemIndex(nextRow,nextColumn);
            nextIndexArr.add(nextIndex);
        }

        if(control.getScene().checkNextIndexArrCanWrite(nextIndexArr))
        {
            for (int i = 0; i < birckItemArr.size(); i++)
            {
                BrickItem brickItem = birckItemArr.get(i);
                int currentRow = brickItem.getRow();
                int currentColumn = brickItem.getColumn();
                int nextRow = currentRow;
                int nextColumn = currentColumn + 1;

                brickItem.setRow(nextRow);
                brickItem.setColumn(nextColumn);
                float newX = TetrisGameConfig.ITEM_X(nextColumn);
                float newY = TetrisGameConfig.ITEM_Y(nextRow);

                brickItem.setX(newX);
                brickItem.setY(newY);
            }
            centerRow=centerRow;
            centerColumn=centerColumn+1;
        }
    }

    private void syncDown()
    {
        ArrayList<Integer> nextIndexArr=new ArrayList<>();
        for(int i=0;i<birckItemArr.size();i++)
        {
            BrickItem brickItem = birckItemArr.get(i);
            int currentRow = brickItem.getRow();
            int currentColumn = brickItem.getColumn();
            int nextRow = currentRow-1;
            int nextColumn = currentColumn;
            int nextIndex=TetrisGameFuction.getItemIndex(nextRow,nextColumn);
            nextIndexArr.add(nextIndex);
        }
        if(control.getScene().checkNextIndexArrCanWrite(nextIndexArr))
        {
            for (int i = 0; i < birckItemArr.size(); i++)
            {
                BrickItem brickItem = birckItemArr.get(i);
                int currentRow = brickItem.getRow();
                int currentColumn = brickItem.getColumn();
                int nextRow = currentRow - 1;
                int nextColumn = currentColumn;

                brickItem.setRow(nextRow);
                brickItem.setColumn(nextColumn);
                float newX = TetrisGameConfig.ITEM_X(nextColumn);
                float newY = TetrisGameConfig.ITEM_Y(nextRow);

                brickItem.setX(newX);
                brickItem.setY(newY);
            }
            centerRow = centerRow - 1;
            centerColumn = centerColumn;
        }
        else //Fall Finish Event
        {
            stop=true;
            control.fallFinishEvent();
        }
    }

    public boolean cotainItemIndex(int itemIndex)
    {
        for(int i=0;i<birckItemArr.size();i++)
        {
            BrickItem brickItem=birckItemArr.get(i);
            if(brickItem.getIndex()==itemIndex)
                return true;
        }
        return false;
    }
}
