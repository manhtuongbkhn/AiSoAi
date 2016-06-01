package aisoai.screens.gamescreeens.tetrisgame;

import org.andengine.entity.IEntity;
import java.util.ArrayList;
import aisoai.screens.gamescreeens.tetrisgame.brick.Brick;
import aisoai.screens.gamescreeens.titentities.TITScene;

public class TetrisGameSence extends TITScene
{
    private Brick currentBrick;
    private ArrayList<Item> itemArr=new ArrayList<Item>();
    private NextBrick nextBrick;

    @Override
    protected TetrisGameControl getControl()
    {
        return (TetrisGameControl) control;
    }

    public void addBrick(Brick brick)
    {
        this.currentBrick=brick;
        ArrayList<BrickItem> brickItemArr=brick.getBirckItemArr();
        for(int i=0;i<brickItemArr.size();i++)
        {
            BrickItem brickItem=brickItemArr.get(i);
            attachChild(brickItem);
        }
    }

    public void removeBrick()
    {
        ArrayList<BrickItem> brickItemArr=currentBrick.getBirckItemArr();
        for(int i=0;i<brickItemArr.size();i++)
        {
            BrickItem brickItem=brickItemArr.get(i);
            detachChild(brickItem);

        }
        currentBrick=null;
    }

    @Override
    public void attachChild(IEntity iEntity)
    {
        if(iEntity instanceof Item)
        {
            Item iItem=(Item) iEntity;
            int row=iItem.getRow();
            int column=iItem.getColumn();
            itemArr.add(iItem);
        }

        if(iEntity instanceof NextBrick)
        {
            NextBrick iNextBrick=(NextBrick) iEntity;
            this.nextBrick=iNextBrick;
        }

        super.attachChild(iEntity);
    }

    @Override
    public boolean detachChild(IEntity iEntity)
    {
        if(iEntity instanceof Item)
        {
            Item iItem=(Item) iEntity;
            int row=iItem.getRow();
            int column=iItem.getColumn();
            itemArr.remove(iItem);
        }

        if(iEntity instanceof NextBrick)
        {
            NextBrick iNextBrick=(NextBrick) iEntity;
            this.nextBrick=null;
        }

        return super.detachChild(iEntity);
    }

    public Item getItem(int row,int column)
    {
        int itemIndex=TetrisGameFuction.getItemIndex(row,column);
        return getItem(itemIndex);
    }

    public Item getItem(int itemIndex)
    {
        for(int i=0;i<itemArr.size();i++)
        {
            Item item=itemArr.get(i);
            if(itemIndex==item.getIndex())
                return item;
        }
        return null;
    }

    public void removeItem(Item item)
    {
        itemArr.remove(item);
    }

    public Brick getCurrentBrick()
    {
        return currentBrick;
    }

    public NextBrick getNextBrick()
    {
        return nextBrick;
    }

    public boolean checkIndexSpace(int itemIndex)
    {
        if(getItem(itemIndex)==null)
            return true;
        else
            return false;
    }

    public boolean checkIndexCanWrite(int itemIdex)
    {
        if(checkIndexSpace(itemIdex))
            return true;
        else
            return getCurrentBrick().cotainItemIndex(itemIdex);
    }

    public boolean checkNextIndexArrCanWrite(ArrayList<Integer> nextItemArr)
    {
        for(int i=0;i<nextItemArr.size();i++)
        {
            int nextIndex=nextItemArr.get(i);
            if(!checkIndexCanWrite(nextIndex))
                return false;
        }
        return true;
    }

    public ArrayList<BrickItem> getBrickItemArrByRow(int row)
    {
        ArrayList<BrickItem> rowItemArr=new ArrayList<BrickItem>();
        for(int i=0;i<itemArr.size();i++)
        {
            Item item=itemArr.get(i);
            if(item.getRow()==row)
            {
                if(item instanceof BrickItem)
                {
                    rowItemArr.add((BrickItem) item);
                }
            }
        }
        return rowItemArr;
    }

    public int reloadAllItem()
    {
        int fullItemRowCount=0;
        while (true)
        {
            boolean b=clearFullItemRow();
            if(b)
                fullItemRowCount++;
            else
                break;
        }
        return fullItemRowCount;
    }

    public boolean clearFullItemRow()
    {
        boolean have=false;
        int fullItemRow=0;
        ArrayList<BrickItem> rowBrickItemArr=null;
        for(int row=2;row<=16;row++)
        {
            rowBrickItemArr=getBrickItemArrByRow(row);
            if(rowBrickItemArr.size()==0)
                break;
            if(rowBrickItemArr.size()==10)
            {
                have=true;
                fullItemRow=row;
                break;
            }
        }

        if(!have)
            return false;
        else
        {
            while(rowBrickItemArr.size()>0)
            {
                Item item=rowBrickItemArr.get(0);
                detachChild(item);
                rowBrickItemArr.remove(0);
            }

            for(int i=0;i<itemArr.size();i++)
            {
                Item item=itemArr.get(i);
                int itemRow=item.getRow();
                int itemColumn=item.getColumn();
                if(itemRow>fullItemRow)
                {
                    if(item instanceof BrickItem)
                    {
                        int nextRow=itemRow-1;
                        int nextColumn=itemColumn;
                        item.setRow(nextRow);
                        item.setColumn(nextColumn);
                        float newX = TetrisGameConfig.ITEM_X(nextColumn);
                        float newY = TetrisGameConfig.ITEM_Y(nextRow);
                        item.setX(newX);
                        item.setY(newY);
                    }
                }
            }
            return true;
        }
    }

    public boolean checkGameOver()
    {
        for (int i=0;i<itemArr.size();i++)
        {
            Item item=itemArr.get(i);
            if(item instanceof BrickItem)
            {
                int itemRow=item.getRow();
                if (itemRow>=17)
                    return true;
            }
        }
        return false;
    }
}
