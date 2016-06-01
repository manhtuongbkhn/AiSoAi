package aisoai.screens.gamescreeens.carogame;

import org.andengine.entity.IEntity;

import java.util.ArrayList;
import aisoai.screens.gamescreeens.titentities.TITScene;

public class CaroGameSence extends TITScene
{
    private ArrayList<Item> itemArr=new ArrayList<Item>();


    @Override
    protected CaroGameControl getControl()
    {
        return (CaroGameControl) control;
    }

    @Override
    public void attachChild(IEntity iEntity)
    {
        if(iEntity instanceof Item)
        {
            Item item=(Item) iEntity;
            itemArr.add(item);
        }
        super.attachChild(iEntity);
    }

    @Override
    public boolean detachChild(IEntity iEntity)
    {
        if(iEntity instanceof Item)
        {
            Item item=(Item) iEntity;
            itemArr.remove(item);
        }
        return super.detachChild(iEntity);
    }

    public Item getItem(int row,int column)
    {
        int itemIndex=CaroGameFunction.getItemIndex(row,column);
        return getItem(itemIndex);
    }

    public Item getItem(int itemIndex)
    {
        return itemArr.get(itemIndex);
    }
}
