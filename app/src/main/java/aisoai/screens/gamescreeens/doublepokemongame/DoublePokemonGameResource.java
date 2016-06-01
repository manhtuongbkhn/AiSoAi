package aisoai.screens.gamescreeens.doublepokemongame;

import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import aisoai.screens.gamescreeens.titentities.TITGameActivity;
import aisoai.screens.gamescreeens.titentities.TITGameResource;

public class DoublePokemonGameResource extends TITGameResource
{
    private static TiledTextureRegion pokemon;
    private static TextureRegion background;
    private static TiledTextureRegion memory;

    public DoublePokemonGameResource(TITGameActivity titGameActivity)
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
        pokemon=createTiledTextureRegionFromAsset("doublepokemongame/pokemon.png",4,6,5);
        background=createTextureRegionFromAsset("findpokemongame/background.png",4);
        memory=createTiledTextureRegionFromAsset("doublepokemongame/memory_button.png",2,1,4);
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

    }

    public static TiledTextureRegion getPokemon()
    {
        return pokemon;
    }

    public static TextureRegion getBackground()
    {
        return background;
    }

    public static TiledTextureRegion getMemory()
    {
        return memory;
    }
}
