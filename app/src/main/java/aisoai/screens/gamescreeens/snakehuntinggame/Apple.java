package aisoai.screens.gamescreeens.snakehuntinggame;

import org.andengine.opengl.texture.region.TiledTextureRegion;
import aisoai.screens.gamescreeens.titentities.TITGameControl;

public class Apple extends Item
{
    private int index;

    public Apple(float x,float y,float width,float height,TiledTextureRegion tiledTextureRegion,
                                                                        TITGameControl iControl)
    {
        super(x, y, width, height, tiledTextureRegion, iControl);
    }

    @Override
    public SnakeHuntingControl getControl()
    {
        return (SnakeHuntingControl) control;
    }

    public static Apple createApple(int index,int appleIndex,TITGameControl iControl)
    {
        int row=SnakeHuntingGameFunction.getItentRow(appleIndex);
        int column=SnakeHuntingGameFunction.getItemColumn(appleIndex);
        return createApple(index,row,column,iControl);
    }

    public static Apple createApple(int index,int row,int column,TITGameControl iControl)
    {
        float x,y,width,height;
        width=SnakeHuntingGameConfig.ITEM_WIDTH();
        height=SnakeHuntingGameConfig.ITEM_HEIGHT();
        x=SnakeHuntingGameConfig.ITEM_X(column);
        y=SnakeHuntingGameConfig.ITEM_Y(row);
        TiledTextureRegion tiledTextureRegion=SnakeHuntingGameResource.getApple();
        Apple apple=new Apple(x,y,width,height,tiledTextureRegion,iControl);
        apple.setRow(row);
        apple.setColumn(column);
        apple.setIndex(index);
        return apple;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }
}
