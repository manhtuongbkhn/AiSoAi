package aisoai.screens.gamescreeens.titentities;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.texture.region.TiledTextureRegion;

abstract public class TITAnimatedSprite extends AnimatedSprite
{
    protected TITGameControl control;

    public TITAnimatedSprite(float x,float y,float width,float height,
                                  TiledTextureRegion tiledTextureRegion,TITGameControl iControl)
    {
        super(x,y,width,height,tiledTextureRegion,iControl.getActivity().getVertexBufferObjectManager());
        this.control=iControl;
    }

    public void setControl(TITGameControl control)
    {
        this.control=control;
    }

    abstract public TITGameControl getControl();
}
