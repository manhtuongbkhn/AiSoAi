package aisoai.screens.gamescreeens.titentities.physicextension;

import java.util.ArrayList;

import aisoai.screens.gamescreeens.titentities.TITCoordinate;

public class TITPhysicFunction
{
    public static TITForce syntheticForce(String name,ArrayList<TITForce> forceArr)
    {
        float x=0f,y=0f;
        for(int i=0;i<forceArr.size();i++)
        {
            x=x+forceArr.get(i).getVector().getX();
            y=y+forceArr.get(i).getVector().getY();
        }
        TITVector vector=new TITVector(new TITCoordinate(x,y));
        TITForce force=new TITForce(name,vector);
        return force;
    }
}
