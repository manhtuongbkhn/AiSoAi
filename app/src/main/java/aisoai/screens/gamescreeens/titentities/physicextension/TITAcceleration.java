package aisoai.screens.gamescreeens.titentities.physicextension;

public class TITAcceleration extends TITMoveQuantity
{
    public TITAcceleration(String name, TITVector direction)
    {
        super(name,direction);
    }

    public static TITAcceleration initTITForce(float weight,TITForce force)
    {
        return new TITAcceleration(force.getName(),force.getVector().div(weight));
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof TITAcceleration)
        {
            TITAcceleration otherAcceleration=(TITAcceleration) obj;
            return getName().equals(otherAcceleration.getName());
        }
        else
            return false;
    }
}
