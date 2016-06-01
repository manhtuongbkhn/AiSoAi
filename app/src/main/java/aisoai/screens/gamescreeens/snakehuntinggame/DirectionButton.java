package aisoai.screens.gamescreeens.snakehuntinggame;

import android.view.MotionEvent;

import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.TextureRegion;

import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.TITSprite;

public class DirectionButton extends TITSprite
{
    private int direction;
    /*
        1:right
        2:down
        3:left
        4:up
     */
    public DirectionButton(float x,float y,float width,float height,TextureRegion textureRegion,
                                                                        TITGameControl iControl)
    {
        super(x, y, width, height, textureRegion, iControl);
    }

    @Override
    public boolean onAreaTouched(TouchEvent event,float x,float y)
    {
        MotionEvent motionEvent=event.getMotionEvent();
        if(motionEvent.getAction()==MotionEvent.ACTION_DOWN)
        {
            TouchEventHandlerThread thread=new TouchEventHandlerThread(x,y);
            thread.start();
        }
        return true;
    }

    class TouchEventHandlerThread extends Thread
    {
        private float x;
        private float y;

        public TouchEventHandlerThread(float iX,float iY)
        {
            x=iX;
            y=iY;
            this.setPriority(Thread.NORM_PRIORITY);
        }

        @Override
        public void run()
        {
            getControl().directionButtonTouchEvent(DirectionButton.this);
        }
    }

    @Override
    public SnakeHuntingControl getControl()
    {
        return (SnakeHuntingControl) control;
    }

    public static DirectionButton createDirectionButton(int direction,TITGameControl iControl)
    {
        float x,y,width,height;
        TextureRegion textureRegion=SnakeHuntingGameResource.getDirectionButton();
        width=SnakeHuntingGameConfig.DIRECTION_BUTTON_WIDTH();
        height=SnakeHuntingGameConfig.DIRECTION_BUTTON_HEIGHT();
        x=SnakeHuntingGameConfig.DIRECTION_BUTTON_X(direction);
        y=SnakeHuntingGameConfig.DIRECTION_BUTTON_Y(direction);
        DirectionButton directionButton=new DirectionButton(x,y,width,height,textureRegion,iControl);
        switch (direction)
        {
            case 1:
                directionButton.setRotation(90f);
                break;
            case 2:
                directionButton.setRotation(180f);
                break;
            case 3:
                directionButton.setRotation(270f);
                break;
            case 4:
                directionButton.setRotation(0);
                break;
        }
        directionButton.setDirection(direction);
        return directionButton;
    }

    public int getDirection()
    {
        return direction;
    }

    public void setDirection(int direction)
    {
        this.direction = direction;
    }
}
