package aisoai.screens.gamescreeens.carogame;

import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.TiledTextureRegion;

import aisoai.screens.gamescreeens.titentities.TITAnimatedSprite;
import aisoai.screens.gamescreeens.titentities.TITGameControl;

public class Item extends TITAnimatedSprite
{
    private int row;
    private int column;

    public Item(float x,float y,float width,float height,TiledTextureRegion tiledTextureRegion, TITGameControl iControl)
    {
        super(x, y, width, height, tiledTextureRegion, iControl);
    }

    @Override
    public CaroGameControl getControl()
    {
        return (CaroGameControl) control;
    }

    @Override
    public boolean onAreaTouched(TouchEvent event,float x,float y)
    {
        if(event.getAction()== TouchEvent.ACTION_UP)
        {
            getControl().itemTouchEvent(Item.this);
        }
        return true;
    }

    public static Item createItem(int row,int column,TITGameControl iControl)
    {
        float width=CaroGameConfig.ITEM_WIDTH();
        float height=CaroGameConfig.ITEM_HEIGHT();
        float x=CaroGameConfig.ITEM_X(column);
        float y=CaroGameConfig.ITEM_Y(row);
        TiledTextureRegion tiledTextureRegion=CaroGameResource.getItem();
        Item item=new Item(x,y,width,height,tiledTextureRegion,iControl);
        item.setCurrentTileIndex(0);
        item.setRow(row);
        item.setColumn(column);
        return item;
    }

    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public int getColumn()
    {
        return column;
    }

    public void setColumn(int column)
    {
        this.column = column;
    }

    public int getIndex()
    {
        return CaroGameFunction.getItemIndex(row,column);
    }
}
