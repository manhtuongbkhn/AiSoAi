package aisoai.screens.gamescreeens.titentities.physicextension;

import aisoai.screens.gamescreeens.titentities.TITCoordinate;

public class TITVector
{
    private TITCoordinate corner;
    private TITCoordinate tip;

    public TITVector(TITCoordinate corner,TITCoordinate tip)
    {
        this.corner=corner;
        this.tip=tip;
    }

    public TITVector(TITCoordinate tip)
    {
        corner=new TITCoordinate(0f,0f);
        this.tip=tip;
    }

    public TITVector multi(float scale)
    {
        float x=getX()*scale;
        float y=getY()*scale;
        TITCoordinate newCorner=new TITCoordinate(corner.getX(),corner.getY());
        TITCoordinate newtip=new TITCoordinate(x+corner.getX(),y+corner.getY());
        return new TITVector(newCorner,newtip);
    }

    public TITVector div(float scale)
    {
        return multi(1/scale);
    }

    public float getX()
    {
        return tip.getX()-corner.getX();
    }

    public float getY()
    {
        return tip.getY()-corner.getY();
    }

    public TITCoordinate getCorner()
    {
        return corner;
    }

    public TITCoordinate getTip()
    {
        return tip;
    }
}
