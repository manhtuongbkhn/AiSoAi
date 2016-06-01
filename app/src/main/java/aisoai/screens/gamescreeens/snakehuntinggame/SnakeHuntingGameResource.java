package aisoai.screens.gamescreeens.snakehuntinggame;

import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;

import aisoai.screens.gamescreeens.titentities.TITGameActivity;
import aisoai.screens.gamescreeens.titentities.TITGameResource;

public class SnakeHuntingGameResource extends TITGameResource
{
    private static TiledTextureRegion head;
    private static TiledTextureRegion tail;
    private static TiledTextureRegion body;
    private static TiledTextureRegion apple;
    private static TextureRegion directionButton;
    private static TiledTextureRegion wall;
    private static TextureRegion background;

    public SnakeHuntingGameResource(TITGameActivity titGameActivity)
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
        head=createTiledTextureRegionFromAsset("snakehuntinggame/head.png",1,1,2);
        tail=createTiledTextureRegionFromAsset("snakehuntinggame/tail.png",1,1,2);
        body=createTiledTextureRegionFromAsset("snakehuntinggame/body.png",2,1,2);
        apple=createTiledTextureRegionFromAsset("snakehuntinggame/apple.png",1,1,2);
        directionButton =createTextureRegionFromAsset("direction_button.png", 2);
        wall=createTiledTextureRegionFromAsset("snakehuntinggame/wall.png",1,1,1);
        background=createTextureRegionFromAsset("snakehuntinggame/background.png", 4);
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
        head=null;
        tail=null;
        body=null;
        apple=null;
        directionButton=null;
        wall=null;
        background=null;
    }

    public static TiledTextureRegion getTail()
    {
        return tail;
    }

    public static TiledTextureRegion getBody()
    {
        return body;
    }

    public static TiledTextureRegion getHead()
    {
        return head;
    }

    public static TextureRegion getDirectionButton()
    {
        return directionButton;
    }

    public static TiledTextureRegion getApple()
    {
        return apple;
    }

    public static TiledTextureRegion getWall()
    {
        return wall;
    }

    public static TextureRegion getBackground()
    {
        return background;
    }
}
