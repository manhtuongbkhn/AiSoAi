package aisoai.screens.gamescreeens.tetrisgame;

import org.andengine.opengl.texture.region.TextureRegion;

import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.TITSprite;

public class Item extends TITSprite
{
    private int row;
    private int column;

    public Item(float x,float y,float width,float height,TextureRegion textureRegion,
                                                                        TITGameControl iControl)
    {
        super(x, y, width, height, textureRegion, iControl);
    }

    @Override
    public TetrisGameControl getControl()
    {
        return (TetrisGameControl) control;
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
        return TetrisGameFuction.getItemIndex(row,column);
    }

    public boolean equals(Object otherObj)
    {
        if(otherObj instanceof Item)
        {
            Item otherItem=(Item) otherObj;
            return getIndex()==otherItem.getIndex();
        }
        else
            return false;
    }
}
