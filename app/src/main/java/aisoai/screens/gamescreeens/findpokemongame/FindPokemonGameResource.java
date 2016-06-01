package aisoai.screens.gamescreeens.findpokemongame;

import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;

import aisoai.screens.gamescreeens.titentities.TITGameActivity;
import aisoai.screens.gamescreeens.titentities.TITGameResource;

public class FindPokemonGameResource extends TITGameResource
{
    private static TiledTextureRegion pokemon;
    private static TextureRegion background;

    public FindPokemonGameResource(TITGameActivity titGameActivity)
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
        pokemon=createTiledTextureRegionFromAsset("findpokemongame/pokemon.png",4,4,5);
        background=createTextureRegionFromAsset("findpokemongame/background.png",4);
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
        pokemon=null;
        background=null;
    }

    public static TiledTextureRegion getPokemon()
    {
        return pokemon.deepCopy();
    }

    public static TextureRegion getBackground()
    {
        return background;
    }
}
