package aisoai.screens.gamescreeens.titentities;

public class TITCircleCoordinates extends TITNPolygonCoordinates
{
    private float radius;

    public TITCircleCoordinates(TITCoordinate center,float radius)
    {
        this.center=center;
        this.radius=radius;
    }

    public float getRadius()
    {
        return radius;
    }

    public void setRadius(float radius)
    {
        this.radius = radius;
    }
}
