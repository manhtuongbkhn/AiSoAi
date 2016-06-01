package aisoai.screens.gamescreeens.titentities.physicextension;

public class TITForce extends TITMoveQuantity
{
    public TITForce(String name, TITVector direction)
    {
        super(name,direction);
    }

    public static TITForce initTITForce(float weight,TITAcceleration acceleration)
    {
        return new TITForce(acceleration.getName(),acceleration.getVector().multi(weight));
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof TITForce)
        {
            TITForce otherForce=(TITForce) obj;
            boolean b= getName().equals(otherForce.getName());
            return b;
        }
        else
        {
            return false;
        }
    }
}
