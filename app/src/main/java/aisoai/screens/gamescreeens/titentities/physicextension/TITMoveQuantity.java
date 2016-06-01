package aisoai.screens.gamescreeens.titentities.physicextension;

import aisoai.firebasecommunicate.TITFirebaseMessage;

public class TITMoveQuantity
{
    protected String name;
    protected TITVector vector;

    public TITMoveQuantity(String name,TITVector vector)
    {
        this.name=name;
        this.vector = vector;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


    public TITVector getVector()
    {
        return vector;
    }

    public void setVector(TITVector vector)
    {
        this.vector = vector;
    }
}
