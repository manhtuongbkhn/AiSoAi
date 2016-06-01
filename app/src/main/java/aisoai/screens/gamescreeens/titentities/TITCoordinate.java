package aisoai.screens.gamescreeens.titentities;

public class TITCoordinate
{
    private float x;
    private float y;
    public TITCoordinate(){}

    public TITCoordinate(float ix, float iy)
    {
        x=ix;
        y=iy;
    }

    public void printCoordinate()
    {
        System.out.println(this.x+">>>>"+this.y);
    }

    public float getX()
    {
        return x;
    }

    public void setX(float ix)
    {
        this.x = ix;
    }

    public float getY()
    {
        return y;
    }

    public void setY(float iy)
    {
        this.y = iy;
    }
}
