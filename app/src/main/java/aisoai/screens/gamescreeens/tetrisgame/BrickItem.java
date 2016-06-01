package aisoai.screens.gamescreeens.tetrisgame;

import org.andengine.opengl.texture.region.TextureRegion;

import aisoai.screens.gamescreeens.titentities.TITGameControl;

public class BrickItem extends Item
{
    public BrickItem(float x, float y, float width, float height, TextureRegion textureRegion,
                     TITGameControl iControl)
    {
        super(x, y, width, height, textureRegion, iControl);
    }

    public static BrickItem createBrickItem(int type,int row,int colum,TITGameControl iControl)
    {
        float x,y,width,height;
        width=TetrisGameConfig.ITEM_WIDTH();
        height=TetrisGameConfig.ITEM_HEIGHT();
        x=TetrisGameConfig.ITEM_X(colum);
        y=TetrisGameConfig.ITEM_Y(row);
        TextureRegion textureRegion;
        switch (type)
        {
            case 1:
                textureRegion=TetrisGameResource.getItem1();
                break;
            case 2:
                textureRegion=TetrisGameResource.getItem2();
                break;
            case 3:
                textureRegion=TetrisGameResource.getItem3();
                break;
            case 4:
                textureRegion=TetrisGameResource.getItem4();
                break;
            case 5:
                textureRegion=TetrisGameResource.getItem5();
                break;
            case 6:
                textureRegion=TetrisGameResource.getItem6();
                break;
            case 7:
            default:
                textureRegion=TetrisGameResource.getItem7();
                break;
        }
        BrickItem brickItem=new BrickItem(x,y,width,height,textureRegion,iControl);
        brickItem.setRow(row);
        brickItem.setColumn(colum);
        return brickItem;
    }
}
