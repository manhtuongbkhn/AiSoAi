package aisoai.screens.gamescreeens.titentities.physicextension;

public class TITSpeed extends TITMoveQuantity
{
    public TITSpeed(String name, TITVector direction)
    {
        super(name,direction);
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof TITSpeed)
        {
            TITSpeed otherSpeed=(TITSpeed) obj;
            return getName().equals(otherSpeed.getName());
        }
        else
            return false;
    }
}
