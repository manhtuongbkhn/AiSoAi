package aisoai.screens.gamescreeens.snakehuntinggame;

import java.util.ArrayList;

public class Snake
{
    private SnakeHuntingControl control;
    private boolean started =false;
    private boolean stop=true;
    private int runTimeMillis;

    private ArrayList<SnakePart> snakePartArr=new ArrayList<SnakePart>();

    public Snake(int row,int column,int direction,int len,SnakeHuntingControl iControl)
    {
        this.control=iControl;
        SnakeHead snakeHead=SnakeHead.createSnakeHead(row,column,direction,iControl);
        SnakeTail snakeTail=null;
        switch (direction)
        {
            case 1:
                snakeTail = SnakeTail.createSnakeTail(row, column - 1, 1, iControl);
                break;
            case 2:
                snakeTail = SnakeTail.createSnakeTail(row - 1, column, 1, iControl);
                break;
            case 3:
                snakeTail = SnakeTail.createSnakeTail(row, column + 1, 1, iControl);
                break;
            case 4:
                snakeTail = SnakeTail.createSnakeTail(row + 1, column - 1, 1, iControl);
                break;
        }

        snakePartArr.add(snakeHead);
        snakePartArr.add(snakeTail);
    }

    public ArrayList<SnakePart> getSnakePartArr()
    {
        return snakePartArr;
    }

    public void start()
    {
        started =true;
        Thread thread=new Thread()
        {
            @Override
            public void run()
            {
                stop=false;
                while(!stop)
                {
                    SnakeHead snakeHead = (SnakeHead) snakePartArr.get(0);
                    int currentRow = snakeHead.getRow();
                    int currentColumn = snakeHead.getColumn();
                    int nextRow;
                    int nextColumn;

                    switch (snakeHead.getDirection())
                    {
                        case 1:
                            nextRow = currentRow;
                            nextColumn = currentColumn + 1;
                            break;
                        case 2:
                            nextRow = currentRow + 1;
                            nextColumn = currentColumn;
                            break;
                        case 3:
                            nextRow = currentRow;
                            nextColumn = currentColumn - 1;
                            break;
                        case 4:
                        default:
                            nextRow = currentRow - 1;
                            nextColumn = currentColumn;
                            break;
                    }

                    if(control.getScene().isHaveApple(nextRow,nextColumn))
                    {
                        eatApple(nextRow,nextColumn);
                        control.eateAppleEvent();
                    }
                    else
                    {
                        move(nextRow, nextColumn);

                        boolean b1=checkCollidesWithWall(snakeHead);
                        boolean b2=checkCollidesWittOtherSnakePart(snakeHead);
                        if(b1||b2)
                        {
                            control.collidesEvent();
                        }
                    }
                    refeshImage();

                    try {Thread.sleep(runTimeMillis);}
                    catch (InterruptedException e) {}
                }
            }
        };
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }

    private void eatApple(int nextRow,int nextColumn)
    {
        SnakeHead snakeHead=(SnakeHead) snakePartArr.get(0);

        int headRow=snakeHead.getRow();
        int headColumn=snakeHead.getColumn();
        int headDirection=snakeHead.getDirection();
        SnakeBody snakeBody=SnakeBody.createSnakeBody(headRow,headColumn,headDirection,control);

        snakeHead.setRow(nextRow);
        snakeHead.setColumn(nextColumn);
        float newX = SnakeHuntingGameConfig.ITEM_X(nextColumn);
        float newY = SnakeHuntingGameConfig.ITEM_Y(nextRow);
        snakeHead.setX(newX);
        snakeHead.setY(newY);

        snakePartArr.add(1, snakeBody);
        control.getScene().attachChild(snakeBody);
    }

    private void move(int nextRow,int nextColumn)
    {
        for (int i = snakePartArr.size() - 1; i >= 1; i--)
        {
            SnakePart currentPart = snakePartArr.get(i);
            SnakePart nextPart = snakePartArr.get(i - 1);

            currentPart.setRow(nextPart.getRow());
            currentPart.setColumn(nextPart.getColumn());
            currentPart.setX(nextPart.getX());
            currentPart.setY(nextPart.getY());
            currentPart.setDirection(nextPart.getDirection());
        }

        SnakeHead snakeHead = (SnakeHead) snakePartArr.get(0);
        snakeHead.setRow(nextRow);
        snakeHead.setColumn(nextColumn);
        float newX = SnakeHuntingGameConfig.ITEM_X(nextColumn);
        float newY = SnakeHuntingGameConfig.ITEM_Y(nextRow);
        snakeHead.setX(newX);
        snakeHead.setY(newY);

    }

    private void refeshImage()
    {
        for(int i=0;i<snakePartArr.size();i++)
        {
            SnakePart nextPart;
            SnakePart previousPart;
            if(i==0)
                nextPart=null;
            else
                nextPart=snakePartArr.get(i-1);

            if(i==getSnakePartArr().size()-1)
                previousPart=null;
            else
                previousPart=snakePartArr.get(i+1);

            SnakePart currentSnakePart=snakePartArr.get(i);
            currentSnakePart.refreshImage(nextPart, previousPart);
        }
    }

    private boolean checkCollidesWithWall(SnakeHead snakeHead)
    {
        ArrayList<Wall> wallArr=control.getScene().getWallArr();
        for(int i=0;i<wallArr.size();i++)
        {
            Wall wall=wallArr.get(i);
            if(snakeHead.collidesWith(wall))
                return true;
        }
        return false;
    }

    private boolean checkCollidesWittOtherSnakePart(SnakeHead snakeHead)
    {
        int snakeHeadRow=snakeHead.getRow();
        int snakeHeadColumn=snakeHead.getColumn();
        for(int i=1;i<snakePartArr.size();i++)
        {
            SnakePart snakePart=snakePartArr.get(i);
            int otherSnakePartRow=snakePart.getRow();
            int otherSnakePartColumn=snakePart.getColumn();

            if(snakeHeadRow==otherSnakePartRow&&snakeHeadColumn==otherSnakePartColumn)
                return true;
        }
        return false;
    }

    public void changeDirection(int changeDirection)
    {
        SnakeHead snakeHead=(SnakeHead) snakePartArr.get(0);
        int currentDirection=snakeHead.getDirection();
        switch (currentDirection)
        {
            case 1:
                if (changeDirection != 3)
                {
                    snakeHead.setDirection(changeDirection);
                    if (!started)
                        start();
                }
                break;
            case 2:
                if (changeDirection != 4)
                {
                    snakeHead.setDirection(changeDirection);
                    if (!started)
                        start();
                }
                break;
            case 3:
                if (changeDirection != 1)
                {
                    snakeHead.setDirection(changeDirection);
                    if (!started)
                        start();
                }
                break;
            case 4:
                if (changeDirection != 2)
                {
                    snakeHead.setDirection(changeDirection);
                    if (!started)
                        start();
                }
                break;
        }
    }

    public void stop()
    {
        stop=true;
    }

    public int getRunTimeMillis()
    {
        return runTimeMillis;
    }

    public void setRunTimeMillis(int runTimeMillis)
    {
        this.runTimeMillis = runTimeMillis;
    }

    public ArrayList<Integer> getIndexArr()
    {
        ArrayList<Integer> indexArr=new ArrayList<Integer>();
        for(int i=0;i<snakePartArr.size();i++)
        {
            SnakePart snakePart=snakePartArr.get(i);
            int row=snakePart.getRow();
            int column=snakePart.getColumn();
            int index=SnakeHuntingGameFunction.getItemIndex(row,column);
            indexArr.add(index);
        }
        return indexArr;
    }
}
