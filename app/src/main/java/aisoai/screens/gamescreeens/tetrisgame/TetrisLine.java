package aisoai.screens.gamescreeens.tetrisgame;

import org.andengine.util.color.Color;

import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.TITLine;

public class TetrisLine extends TITLine
{
    public TetrisLine(float x1, float y1, float x2, float y2, TITGameControl iControl)
    {
        super(x1, y1, x2, y2, iControl);
        setColor(Color.GREEN);
        setLineWidth(TetrisGameConfig.LINE_WIDTH());
    }

    @Override
    protected TetrisGameControl getControl()
    {
        return (TetrisGameControl) control;
    }
}
