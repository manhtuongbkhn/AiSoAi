package aisoai.screens.gamescreeens.tetrisgame;

import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;

import aisoai.screens.gamescreeens.titentities.TITGameActivity;
import aisoai.screens.gamescreeens.titentities.TITGameResource;

public class TetrisGameResource extends TITGameResource
{
    private static TextureRegion item1;
    private static TextureRegion item2;
    private static TextureRegion item3;
    private static TextureRegion item4;
    private static TextureRegion item5;
    private static TextureRegion item6;
    private static TextureRegion item7;
    private static TextureRegion wall;
    private static TextureRegion directionButton;
    private static TextureRegion speed;
    private static TiledTextureRegion nextBrick;

    public TetrisGameResource(TITGameActivity titGameActivity)
    {
        super(titGameActivity);
    }

    @Override
    protected void initFonts()
    {
    }

    @Override
    protected void initPictures()
    {
        item1=createTextureRegionFromAsset("tetrisgame/item1.png",0);
        item2=createTextureRegionFromAsset("tetrisgame/item2.png",0);
        item3=createTextureRegionFromAsset("tetrisgame/item3.png",0);
        item4=createTextureRegionFromAsset("tetrisgame/item4.png",0);
        item5=createTextureRegionFromAsset("tetrisgame/item5.png",0);
        item6=createTextureRegionFromAsset("tetrisgame/item6.png",0);
        item7=createTextureRegionFromAsset("tetrisgame/item7.png",0);
        wall=createTextureRegionFromAsset("tetrisgame/wall.png",0);
        directionButton =createTextureRegionFromAsset("direction_button.png", 2);
        speed=createTextureRegionFromAsset("touch_button.png",2);
        nextBrick=createTiledTextureRegionFromAsset("tetrisgame/next_brick.png",4,2,3);
    }

    @Override
    protected void initSounds()
    {

    }

    @Override
    protected void initMusics()
    {

    }

    @Override
    protected void clearResource()
    {
        item1=null;
        item2=null;
        item3=null;
        item4=null;
        item5=null;
        item6=null;
        item7=null;
        wall=null;
        directionButton=null;
        speed=null;
        nextBrick=null;
    }

    public static TextureRegion getItem2()
    {
        return item2;
    }

    public static TextureRegion getItem3()
    {
        return item3;
    }

    public static TextureRegion getItem1()
    {
        return item1;
    }

    public static TextureRegion getItem4()
    {
        return item4;
    }

    public static TextureRegion getItem5()
    {
        return item5;
    }

    public static TextureRegion getItem6()
    {
        return item6;
    }

    public static TextureRegion getItem7()
    {
        return item7;
    }

    public static TextureRegion getWall()
    {
        return wall;
    }

    public static TextureRegion getDirectionButton()
    {
        return directionButton;
    }

    public static TextureRegion getSpeed()
    {
        return speed;
    }

    public static TiledTextureRegion getNextBrick()
    {
        return nextBrick;
    }
}
