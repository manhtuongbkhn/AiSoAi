package aisoai.screens.gamescreeens.carogame;

import org.andengine.opengl.texture.region.TextureRegion;

import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.TITSprite;

public class Bout extends TITSprite
{

    public Bout(float x, float y, float width, float height,TextureRegion textureRegion,
                                                                            TITGameControl iControl)
    {
        super(x, y, width, height, textureRegion, iControl);
    }

    @Override
    public TITGameControl getControl()
    {
        return (CaroGameControl) control;
    }

    public static Bout createBout(TITGameControl iControl)
    {
        float x,y,width,height;
        TextureRegion textureRegion=CaroGameResource.getBout();
        width=CaroGameConfig.BOUT_WIDTH();
        height=CaroGameConfig.BOUT_HEIGHT();
        x=CaroGameConfig.BOUT_X();
        y=CaroGameConfig.HIDEN_BOUT_Y();

        Bout bout=new Bout(x,y,width,height,textureRegion,iControl);
        bout.setZIndex(CaroGameConfig.BOUT_LAYER);
        return bout;
    }

    public void hiden()
    {
        setY(CaroGameConfig.HIDEN_BOUT_Y());
    }

    public void toTop()
    {
        setY(CaroGameConfig.BOUT_Y(true));
    }

    public void toBot()
    {
        setY(CaroGameConfig.BOUT_Y(false));
    }
}
