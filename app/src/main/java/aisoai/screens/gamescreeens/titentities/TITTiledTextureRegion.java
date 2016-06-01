package aisoai.screens.gamescreeens.titentities;

import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;

public class TITTiledTextureRegion extends TiledTextureRegion
{
    public TITTiledTextureRegion(ITexture pTexture, ITextureRegion... pTextureRegions)
    {
        super(pTexture, pTextureRegions);
    }
}
