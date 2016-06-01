package aisoai.screens.gamescreeens.tetrisgame;

import org.andengine.opengl.texture.region.TextureRegion;

import aisoai.screens.gamescreeens.titentities.TITGameControl;

public class StoneItem extends Item
{
    public StoneItem(float x, float y, float width, float height, TextureRegion textureRegion,
                     TITGameControl iControl)
    {
        super(x, y, width, height, textureRegion, iControl);
    }

    public static StoneItem createWall(int row,int column,TITGameControl iControl)
    {
        float x,y,width,height;
        width=TetrisGameConfig.ITEM_WIDTH();
        height=TetrisGameConfig.ITEM_HEIGHT();
        x=TetrisGameConfig.ITEM_X(column);
        y=TetrisGameConfig.ITEM_Y(row);
        TextureRegion textureRegion=TetrisGameResource.getWall();
        StoneItem stoneItem =new StoneItem(x,y,width,height,textureRegion,iControl);
        stoneItem.setRow(row);
        stoneItem.setColumn(column);
        return stoneItem;
    }
}
