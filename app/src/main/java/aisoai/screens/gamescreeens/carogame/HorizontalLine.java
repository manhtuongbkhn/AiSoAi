package aisoai.screens.gamescreeens.carogame;

import org.andengine.util.color.Color;

import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.TITLine;

public class HorizontalLine extends TITLine
{
    public HorizontalLine(float x1, float y1, float x2, float y2, TITGameControl iControl)
    {
        super(x1, y1, x2, y2, iControl);
    }

    @Override
    protected CaroGameControl getControl()
    {
        return (CaroGameControl) control;
    }

    public static HorizontalLine createLine(int column,TITGameControl iControl)
    {
        float x1=CaroGameConfig.HORLINE_X(column);
        float y1=0;
        float x2=x1;
        float y2=CaroGameConfig.GS_HEIGHT;

        HorizontalLine line=new HorizontalLine(x1,y1,x2,y2,iControl);
        line.setColor(CaroGameConfig.LINE_COLOR);
        return line;
    }
}
