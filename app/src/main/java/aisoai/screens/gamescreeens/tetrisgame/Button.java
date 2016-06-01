package aisoai.screens.gamescreeens.tetrisgame;

import org.andengine.opengl.texture.region.TextureRegion;

import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.TITSprite;

public class Button extends TITSprite
{
    public Button(float x,float y,float width,float height,TextureRegion textureRegion,
                                                                        TITGameControl iControl)
    {
        super(x, y, width, height, textureRegion, iControl);
    }

    @Override
    public TetrisGameControl getControl()
    {
        return (TetrisGameControl) control;
    }
}
