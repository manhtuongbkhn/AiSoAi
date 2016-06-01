package aisoai.screens.gamescreeens.tetrisgame;

import android.view.MotionEvent;

import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.TextureRegion;

import aisoai.screens.gamescreeens.titentities.TITGameControl;

public class DirectionButton extends Button
{
    private int direction;

    public DirectionButton(float x,float y,float width,float height,TextureRegion textureRegion,
                                                                        TITGameControl iControl)
    {
        super(x, y, width, height, textureRegion, iControl);
    }

    @Override
    public boolean onAreaTouched(TouchEvent event,float x,float y)
    {
        MotionEvent motionEvent=event.getMotionEvent();
        switch (motionEvent.getAction())
        {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_MOVE:
                TouchEventHandlerThread thread=new TouchEventHandlerThread(motionEvent,x,y);
                thread.start();
                break;
        }
        return true;
    }

    class TouchEventHandlerThread extends Thread
    {
        private MotionEvent motionEvent;
        private float x;
        private float y;

        public TouchEventHandlerThread(MotionEvent iMotionEvent,float iX,float iY)
        {
            this.motionEvent=iMotionEvent;
            x=iX;
            y=iY;
            this.setPriority(Thread.NORM_PRIORITY);
        }

        @Override
        public void run()
        {
            getControl().directionButtonTouchEvent(motionEvent,DirectionButton.this);
        }
    }

    public static DirectionButton createDirectionButton(int direction,TITGameControl iControl)
    {
        float x,y,width,height;
        width=TetrisGameConfig.BUTTON_WIDTH();
        height=TetrisGameConfig.BUTTON_HEIGHT();
        x=TetrisGameConfig.DIRECTIONBUTTON_X(direction);
        y=TetrisGameConfig.BUTTON_Y();
        TextureRegion textureRegion=TetrisGameResource.getDirectionButton();
        DirectionButton directionButton=new DirectionButton(x,y,width,height,textureRegion,iControl);
        if(direction==1)
            directionButton.setRotation(90f);
        if(direction==2)
            directionButton.setRotation(180f);
        if(direction==3)
            directionButton.setRotation(270f);
        directionButton.setDirection(direction);
        return  directionButton;
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
