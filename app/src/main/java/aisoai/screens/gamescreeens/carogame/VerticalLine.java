package aisoai.screens.gamescreeens.carogame;

import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.TITLine;

public class VerticalLine extends TITLine
{
    public VerticalLine(float x1, float y1, float x2, float y2, TITGameControl iControl)
    {
        super(x1, y1, x2, y2, iControl);
    }

    @Override
    protected CaroGameControl getControl()
    {
        return (CaroGameControl) control;
    }

    public static VerticalLine createLine(int row,TITGameControl iControl)
    {
        float x1=0;
        float y1=CaroGameConfig.VERLINE_Y(row);
        float x2=CaroGameConfig.GS_WIDTH;
        float y2=y1;
        VerticalLine line=new VerticalLine(x1,y1,x2,y2,iControl);
        line.setColor(CaroGameConfig.LINE_COLOR);
        return line;
    }
}
