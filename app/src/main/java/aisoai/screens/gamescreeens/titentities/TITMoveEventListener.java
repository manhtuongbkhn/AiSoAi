package aisoai.screens.gamescreeens.titentities;

import android.view.MotionEvent;

abstract public class TITMoveEventListener
{
    private TITCoordinate downCoordinate;
    private TITCoordinate upCoordinate;
    private Status status;

    public TITMoveEventListener()
    {
        status=Status.SLEEPING;
    }

    public void handler(MotionEvent event)
    {
        float x,y;
        x=event.getX();
        y=event.getY();
        switch ((event.getAction()))
        {
            case MotionEvent.ACTION_DOWN:
                downCoordinate=new TITCoordinate(x,y);
                status=Status.READY;
                break;
            case MotionEvent.ACTION_MOVE:
                status=Status.READY.MOVING;
                break;
            case MotionEvent.ACTION_UP:
                upCoordinate=new TITCoordinate(x,y);
                if(status==Status.MOVING)
                {
                    float deltaX=upCoordinate.getX()-downCoordinate.getX();
                    float deltaY=upCoordinate.getY()-downCoordinate.getY();
                    Float tanAlpha=deltaY/deltaX;
                    Double dRadianAngle=Math.atan(tanAlpha.doubleValue());
                    float fRadianAngle=dRadianAngle.floatValue();
                    Double dPi=Math.PI;
                    float pi=dPi.floatValue();
                    float angle=fRadianAngle*180/pi;
                    if(deltaX>=0)
                    {
                        if(deltaY>=0)
                        {

                        }
                        else
                        {
                            angle=360-angle*(-1);
                        }
                    }
                    else
                    {
                        if(deltaY>=0)
                        {
                            angle=180-angle*(-1);
                        }
                        else
                        {
                            angle=angle+180;
                        }
                    }
                    onMoved(downCoordinate.getX(),downCoordinate.getY(),angle);
                }
                status=Status.SLEEPING;
                break;
        }
    }

    abstract protected void onMoved(float downX,float downY,float angle);


    enum Status
    {
        SLEEPING,READY,MOVING,
    }
}
