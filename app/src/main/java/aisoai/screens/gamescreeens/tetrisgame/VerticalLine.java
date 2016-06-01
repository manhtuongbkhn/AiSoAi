package aisoai.screens.gamescreeens.tetrisgame;

import aisoai.screens.gamescreeens.titentities.TITGameControl;

public class VerticalLine extends TetrisLine
{
    public VerticalLine(float x1, float y1, float x2, float y2, TITGameControl iControl)
    {
        super(x1, y1, x2, y2, iControl);
    }

    public static VerticalLine createVerticalLine(int pointRow,TITGameControl iControl)
    {
        float x1,x2,y1,y2;
        x1=TetrisGameConfig.POINT_X(2);
        x2=TetrisGameConfig.POINT_X(12);
        y1=TetrisGameConfig.POINT_Y(pointRow);
        y2=y1;
        VerticalLine verticalLine=new VerticalLine(x1,y1,x2,y2,iControl);
        return verticalLine;
    }
}
