package aisoai.screens.gamescreeens.snakehuntinggame;

import org.andengine.opengl.texture.region.TiledTextureRegion;

import aisoai.screens.gamescreeens.titentities.TITGameControl;

public class SnakeBody extends SnakePart
{
    public SnakeBody(float x,float y,float width,float height,TiledTextureRegion tiledTextureRegion,
                                                                        TITGameControl iControl)
    {
        super(x, y, width, height, tiledTextureRegion, iControl);
    }

    @Override
    public void refreshImage(SnakePart nextPart,SnakePart previousPart)
    {
        if(nextPart.getRow()==previousPart.getRow()||nextPart.getColumn()==previousPart.getColumn())
        {
            setCurrentTileIndex(0);
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
        else
        {
            setCurrentTileIndex(1);
            int nextDeltaRow=nextPart.getRow()-getRow();
            int nextDeltaColumn=nextPart.getColumn()-getColumn();

            int preDeltaRow=previousPart.getRow()-getRow();
            int preDeltaColumn = previousPart.getColumn()-getColumn();

            int deltaRow=nextDeltaRow+preDeltaRow;
            int deltaColumn=nextDeltaColumn+preDeltaColumn;

            if(deltaRow==-1&&deltaColumn==-1)
                setRotation(0f);

            if(deltaRow==-1&&deltaColumn==1)
                setRotation(90f);

            if(deltaRow==1&&deltaColumn==1)
                setRotation(180f);

            if(deltaRow==1&&deltaColumn==-1)
                setRotation(270f);
        }
    }

    public static SnakeBody createSnakeBody(int row,int column,int direction,TITGameControl iControl)
    {
        float x,y,width,height;
        TiledTextureRegion tiledTextureRegion=SnakeHuntingGameResource.getBody();
        x =SnakeHuntingGameConfig.ITEM_X(column);
        y=SnakeHuntingGameConfig.ITEM_Y(row);
        width=SnakeHuntingGameConfig.ITEM_WIDTH();
        height=SnakeHuntingGameConfig.ITEM_HEIGHT();
        SnakeBody snakeBody=new SnakeBody(x,y,width,height,tiledTextureRegion,iControl);
        snakeBody.setDirection(direction);
        snakeBody.setRow(row);
        snakeBody.setColumn(column);

        snakeBody.setCurrentTileIndex(0);
        snakeBody.setRotation(270f);
        return snakeBody;
    }
}
