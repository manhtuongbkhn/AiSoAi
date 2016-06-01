package aisoai.screens.gamescreeens.carogame;

import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import aisoai.screens.gamescreeens.titentities.TITGameActivity;
import aisoai.screens.gamescreeens.titentities.TITGameResource;

public class CaroGameResource extends TITGameResource
{
    private static TiledTextureRegion item;
    private static TextureRegion bout;

    public CaroGameResource(TITGameActivity titGameActivity)
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
        item=createTiledTextureRegionFromAsset("carogame/item.png",3,1,4);
        bout=createTextureRegionFromAsset("carogame/bout.png",1);
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
        item=null;
    }

    public static TiledTextureRegion getItem()
    {
        return item;
    }

    public static TextureRegion getBout()
    {
        return bout;
    }
}
