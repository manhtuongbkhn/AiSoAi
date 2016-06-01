package aisoai.screens.gamescreeens.tetrisgame;

import android.view.MotionEvent;

import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.TextureRegion;

import aisoai.screens.gamescreeens.titentities.TITGameControl;

public class RotateButton extends Button
{
    public RotateButton(float x, float y, float width, float height, TextureRegion textureRegion,
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
            getControl().speedButtonTouchEvent(RotateButton.this);
        }
    }

    public static RotateButton createSpeedButton(TITGameControl iControl)
    {
        float x,y,width,height;
        width=TetrisGameConfig.BUTTON_WIDTH();
        height=TetrisGameConfig.BUTTON_HEIGHT();
        x=TetrisGameConfig.ROTATEBUTTON_X();
        y=TetrisGameConfig.BUTTON_Y();
        TextureRegion textureRegion=TetrisGameResource.getSpeed();
        RotateButton rotateButton =new RotateButton(x,y,width,height,textureRegion,iControl);
        return rotateButton;
    }
}
