package aisoai.screens.gamescreeens.tetrisgame;

import aisoai.TITApplication;
import aisoai.screens.gamescreeens.titentities.TITGameActivity;
import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.TITGameResource;
import aisoai.screens.gamescreeens.titentities.TITScene;
import aisoai.screens.gamescreeens.titentities.titsinglegame.TITSingleGameActivity;

public class TetrisGameActivity extends TITSingleGameActivity
{
    @Override
    protected TITGameControl linkControl()
    {
        return TITApplication.getScreenControlManager().getTetrisGameControl();
    }

    @Override
    public TetrisGameControl getControl()
    {
        return (TetrisGameControl) control;
    }

    @Override
    public TITGameResource initGameResource()
    {
        return new TetrisGameResource(this);
    }

    @Override
    public TITScene initScene()
    {
        return new TetrisGameSence();
    }
}
