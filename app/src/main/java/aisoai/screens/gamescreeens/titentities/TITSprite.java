package aisoai.screens.gamescreeens.titentities;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.TextureRegion;

abstract public class TITSprite extends Sprite
{
    protected TITGameControl control;

    public TITSprite(float x,float y,float width,float height,TextureRegion textureRegion,
                                                TITGameControl iControl)
    {
        super(x,y,width,height,textureRegion,
                                        iControl.getActivity().getVertexBufferObjectManager());
        this.control=iControl;
    }

    public void setControl(TITGameControl control)
    {
        this.control=control;
    }

    abstract public TITGameControl getControl();
}
