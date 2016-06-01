package aisoai.screens.gamescreeens.titentities.physicextension;

import org.andengine.opengl.texture.region.TextureRegion;

import java.util.ArrayList;

import aisoai.screens.gamescreeens.titentities.TITCoordinate;
import aisoai.screens.gamescreeens.titentities.TITGameConfig;
import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.TITSprite;

abstract public class TITPhysicSprite extends TITSprite
{
    private float weight;
    private TITSpeed speed;
    private TITAcceleration acceleration;
    private ArrayList<TITForce> forceArr;

    public TITPhysicSprite(float x,float y,float width,float height,TextureRegion textureRegion,
                                                            TITGameControl iControl,float weight)
    {
        super(x,y,width,height,textureRegion,iControl);
        this.weight=weight;
        TITVector vector=new TITVector(new TITCoordinate(0,0));
        speed=new TITSpeed("this",vector);
        speed=new TITSpeed("this",vector);
        forceArr=new ArrayList<TITForce>();
    }

    public void registerForce(TITForce newForce)
    {
        boolean exist=false;
        for(int i=0;i<forceArr.size();i++)
        {
            TITForce force=forceArr.get(i);
            if(newForce.equals(force))
                exist=true;
        }
        if(!exist)
        {
            forceArr.add(newForce);
        }
    }

    public void unregisterForce(TITForce force)
    {
        forceArr.remove(force);
    }

    public void registerAcceleration(TITAcceleration iAcceleration)
    {
        TITForce force=TITForce.initTITForce(weight,iAcceleration);
        registerForce(force);
    }

    public void unregisterAcceleration(TITAcceleration iAcceleration)
    {
        TITForce force=TITForce.initTITForce(weight,iAcceleration);
        unregisterForce(force);
    }

    public void addSpeed(TITSpeed iSpeed)
    {
        float x=speed.getVector().getX()+iSpeed.getVector().getX();
        float y=speed.getVector().getY()+iSpeed.getVector().getY();
        speed.getVector().getTip().setX(x);
        speed.getVector().getTip().setY(y);
    }

    protected void reloadAcceleration()
    {
        TITForce syntheticForce=TITPhysicFunction.syntheticForce("this", forceArr);
        acceleration=TITAcceleration.initTITForce(weight,syntheticForce);
    }

    private boolean stop=true;

    public void start()
    {
        stop=false;
        Thread thread=new Thread()
        {
            @Override
            public void run()
            {
                while(!stop)
                {
                    reloadAcceleration();
                    float x0 = getX();
                    float y0 = getY();
                    float vx0 = speed.getVector().getX();
                    float vy0 = speed.getVector().getY();
                    float ax = acceleration.getVector().getX();
                    float ay = acceleration.getVector().getY();
                    Integer millisTime = TITGameConfig.PHYSICENTITYRUN_DELAYTIMEMILLIS;
                    float secondTime = millisTime.floatValue() / 1000f;
                    float newX = x0 + vx0 * secondTime + ax * secondTime * secondTime / 2;
                    float newY = y0 + vy0 * secondTime + ay * secondTime * secondTime / 2;

                    setCoordinate(newX, newY);
                    float vx = vx0 + ax * secondTime;
                    float vy = vy0 + ay * secondTime;
                    speed.getVector().getTip().setX(vx);
                    speed.getVector().getTip().setY(vy);
                    afterSetCoordinate();

                    try {Thread.sleep(millisTime);} catch (InterruptedException e) {}
                }
            }
        };
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }

    abstract public void setCoordinate(float newX, float newY);

    public void afterSetCoordinate()
    {

    }

    public void stop()
    {
        stop=true;
    }

    public float getWeight()
    {
        return weight;
    }

    public TITSpeed getSpeed()
    {
        return speed;
    }

    public TITAcceleration getAcceleration()
    {
        return acceleration;
    }
}
