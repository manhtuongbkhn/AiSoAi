package aisoai.screens.gamescreeens.snakehuntinggame;

import org.andengine.opengl.texture.region.TiledTextureRegion;

import aisoai.screens.gamescreeens.titentities.TITAnimatedSprite;
import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.titsinglegame.TITSingleGameConfig;

public class Wall extends TITAnimatedSprite
{

    public Wall(float x,float y,float width,float height,TiledTextureRegion tiledTextureRegion,
                                                                            TITGameControl iControl)
    {
        super(x, y, width, height, tiledTextureRegion, iControl);
    }

    @Override
    public SnakeHuntingControl getControl()
    {
        return (SnakeHuntingControl) control;
    }

    public static Wall createTopWall(TITGameControl iControl)
    {
        float x,y,width,height;
        TiledTextureRegion tiledTextureRegion=SnakeHuntingGameResource.getWall();
        width= TITSingleGameConfig.GS_WIDTH();
        height=10* TITSingleGameConfig.GS_WIDTH()/320f-2;
        x=0;
        y=0;
        Wall wall=new Wall(x,y,width,height,tiledTextureRegion,iControl);
        return wall;
    }

    public static Wall createLeftWall(TITGameControl iControl)
    {
        float x,y,width,height;
        TiledTextureRegion tiledTextureRegion=SnakeHuntingGameResource.getWall();
        width=10* TITSingleGameConfig.GS_WIDTH()/320f-2f;
        height=240f* TITSingleGameConfig.GS_WIDTH()/320f+4f;
        x=0;
        y=10f* TITSingleGameConfig.GS_WIDTH()/320f-2f
        ;
        Wall wall=new Wall(x,y,width,height,tiledTextureRegion,iControl);
        return wall;
    }

    public static Wall createBotWall(TITGameControl iControl)
    {
        float x,y,width,height;
        TiledTextureRegion tiledTextureRegion=SnakeHuntingGameResource.getWall();
        width= TITSingleGameConfig.GS_WIDTH();
        height=10* TITSingleGameConfig.GS_WIDTH()/320f-2f;
        x=0;
        y=250* TITSingleGameConfig.GS_WIDTH()/320f+2f;
        Wall wall=new Wall(x,y,width,height,tiledTextureRegion,iControl);
        return wall;
    }

    public static Wall createRightWall(TITGameControl iControl)
    {
        float x,y,width,height;
        TiledTextureRegion tiledTextureRegion=SnakeHuntingGameResource.getWall();
        width=10f* TITSingleGameConfig.GS_WIDTH()/320f-2f;
        height=240f* TITSingleGameConfig.GS_WIDTH()/320f+4f;
        x=310* TITSingleGameConfig.GS_WIDTH()/320f+2f;
        y=10* TITSingleGameConfig.GS_WIDTH()/320f-2f;
        Wall wall=new Wall(x,y,width,height,tiledTextureRegion,iControl);
        return wall;
    }

    public static Wall createCustomWall(int startRow,int startColumn,
                                            int itemWidth,int itemHeight,TITGameControl iControl)
    {
        float x,y,width,height;
        TiledTextureRegion tiledTextureRegion=SnakeHuntingGameResource.getWall();
        x=SnakeHuntingGameConfig.ITEM_X(startColumn)+2f;
        y=SnakeHuntingGameConfig.ITEM_Y(startRow)+2f;
        width=itemWidth*SnakeHuntingGameConfig.ITEM_WIDTH()-4f;
        height=itemHeight*SnakeHuntingGameConfig.ITEM_HEIGHT()-4f;
        Wall wall=new Wall(x,y,width,height,tiledTextureRegion,iControl);
        return wall;
    }
}
