package aisoai.screens.gamescreeens.snakehuntinggame;

import org.andengine.opengl.texture.region.TiledTextureRegion;

import aisoai.screens.gamescreeens.titentities.TITGameControl;

abstract public class SnakePart extends Item
{
    protected int direction;
    /*
        1:right
        2:down
        3:left
        4:up
     */

    public SnakePart(float x, float y, float width, float height,
                                    TiledTextureRegion tiledTextureRegion,TITGameControl iControl)
    {
        super(x, y, width, height, tiledTextureRegion, iControl);
    }

    @Override
    public SnakeHuntingControl getControl()
    {
        return (SnakeHuntingControl) control;
    }

    public int getDirection()
    {
        return direction;
    }

    public void setDirection(int direction)
    {
        this.direction = direction;
    }

    abstract public void refreshImage(SnakePart nextPart,SnakePart previousPart);
}
