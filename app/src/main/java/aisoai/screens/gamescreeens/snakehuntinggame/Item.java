package aisoai.screens.gamescreeens.snakehuntinggame;

import org.andengine.opengl.texture.region.TiledTextureRegion;

import aisoai.screens.gamescreeens.titentities.TITAnimatedSprite;
import aisoai.screens.gamescreeens.titentities.TITGameControl;

public class Item extends TITAnimatedSprite
{
    protected int row;
    protected int column;

    public Item(float x,float y,float width,float height,TiledTextureRegion tiledTextureRegion,
                                                                            TITGameControl iControl)
    {
        super(x, y, width, height, tiledTextureRegion, iControl);
    }

    @Override
    public SnakeHuntingControl getControl()
    {
        return (SnakeHuntingControl) control;
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
}
