package aisoai.screens.gamescreeens.tetrisgame;

import aisoai.screens.gamescreeens.titentities.TITGameControl;

public class HorizontalLine extends TetrisLine
{
    public HorizontalLine(float x1, float y1, float x2, float y2, TITGameControl iControl)
    {
        super(x1, y1, x2, y2, iControl);
    }

    public static HorizontalLine createHorizontalLine(int pointColumn,TITGameControl iControl)
    {
        float x1,x2,y1,y2;
        x1=TetrisGameConfig.POINT_X(pointColumn);
        x2=x1;
        y1=TetrisGameConfig.POINT_Y(17);
        y2=TetrisGameConfig.POINT_Y(2);
        HorizontalLine horizontalLine=new HorizontalLine(x1,y1,x2,y2,iControl);
        return horizontalLine;
    }
}
