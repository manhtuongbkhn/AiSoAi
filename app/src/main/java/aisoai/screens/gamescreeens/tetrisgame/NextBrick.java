package aisoai.screens.gamescreeens.tetrisgame;

import org.andengine.opengl.texture.region.TiledTextureRegion;

import aisoai.screens.gamescreeens.titentities.TITAnimatedSprite;
import aisoai.screens.gamescreeens.titentities.TITGameControl;

public class NextBrick extends TITAnimatedSprite
{

    public NextBrick(float x,float y,float width,float height,
                                    TiledTextureRegion tiledTextureRegion,TITGameControl iControl)
    {
        super(x, y, width, height, tiledTextureRegion, iControl);
    }

    @Override
    public TetrisGameControl getControl()
    {
        return (TetrisGameControl) control;
    }

    public static NextBrick createNextBrick(TITGameControl iControl)
    {
        float x,y,width,height;
        TiledTextureRegion tiledTextureRegion=TetrisGameResource.getNextBrick();
        width=TetrisGameConfig.NEXT_BRICK_WIDTH();
        height=TetrisGameConfig.NEXT_BRICK_HEIGHT();
        x=TetrisGameConfig.NEXT_BRICK_X();
        y=TetrisGameConfig.NEXT_BRICK_Y();
        NextBrick nextBrick=new NextBrick(x,y,width,height,tiledTextureRegion,iControl);
        nextBrick.setType(0);
        return nextBrick;
    }

    public void setType(int type)
    {
        setCurrentTileIndex(type);
    }
}
