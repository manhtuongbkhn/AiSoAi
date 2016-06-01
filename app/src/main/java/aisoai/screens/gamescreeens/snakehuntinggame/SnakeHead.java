package aisoai.screens.gamescreeens.snakehuntinggame;

import org.andengine.opengl.texture.region.TiledTextureRegion;

import aisoai.screens.gamescreeens.titentities.TITGameControl;

public class SnakeHead extends SnakePart
{
    public SnakeHead(float x, float y, float width, float height,
                                    TiledTextureRegion tiledTextureRegion, TITGameControl iControl)
    {
        super(x, y, width, height, tiledTextureRegion, iControl);
    }

    @Override
    public void refreshImage(SnakePart nextPart,SnakePart previousPart)
    {
        switch (direction)
        {
            case 1:
                setRotation(90f);
                break;
            case 2:
                setRotation(180f);
                break;
            case 3:
                setRotation(270f);
                break;
            case 4:
                setRotation(0f);
                break;
        }
    }

    public static SnakeHead createSnakeHead(int row,int column,int direction,TITGameControl iControl)
    {
        float x,y,width,height;
        TiledTextureRegion tiledTextureRegion=SnakeHuntingGameResource.getHead();
        x=SnakeHuntingGameConfig.ITEM_X(column);
        y=SnakeHuntingGameConfig.ITEM_Y(row);
        width=SnakeHuntingGameConfig.ITEM_WIDTH();
        height=SnakeHuntingGameConfig.ITEM_HEIGHT();
        SnakeHead snakeHead=new SnakeHead(x,y,width,height,tiledTextureRegion,iControl);
        snakeHead.setCurrentTileIndex(0);
        snakeHead.setDirection(direction);
        snakeHead.setRow(row);
        snakeHead.setColumn(column);
        snakeHead.refreshImage(null,null);
        return snakeHead;
    }


}
