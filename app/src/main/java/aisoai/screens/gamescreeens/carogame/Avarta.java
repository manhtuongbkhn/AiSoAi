package aisoai.screens.gamescreeens.carogame;

import org.andengine.opengl.texture.region.TextureRegion;

import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.TITSprite;

public class Avarta extends TITSprite
{

    public Avarta(float x,float y,float width,float height,TextureRegion textureRegion,
                                                                            TITGameControl iControl)
    {
        super(x, y, width, height, textureRegion, iControl);
    }

    @Override
    public CaroGameControl getControl()
    {
        return (CaroGameControl) control;
    }

    public static Avarta createAvatar(boolean top,TextureRegion textureRegion,TITGameControl iControl)
    {
        float x,y,width,height;
        x=CaroGameConfig.AVATAR_X();
        y=CaroGameConfig.AVATAR_Y(top);
        width=CaroGameConfig.AVATAR_WIDTH();
        height=CaroGameConfig.AVATAR_HEIGHT();
        Avarta avarta=new Avarta(x,y,width,height,textureRegion,iControl);
        avarta.setZIndex(CaroGameConfig.AVATAR_LAYER);
        return avarta;
    }
}
