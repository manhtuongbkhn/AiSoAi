package aisoai.screens.gamescreeens.doublepokemongame;

import aisoai.TITApplication;
import aisoai.screens.gamescreeens.titentities.TITGameActivity;
import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.TITGameResource;
import aisoai.screens.gamescreeens.titentities.TITScene;
import aisoai.screens.gamescreeens.titentities.titsinglegame.TITSingleGameActivity;

public class DoublePokemonGameActivity extends TITSingleGameActivity
{
    @Override
    protected TITGameControl linkControl()
    {
        return TITApplication.getScreenControlManager().getDoublePokemonGameControl();
    }

    @Override
    public DoublePokemonGameControl getControl()
    {
        return (DoublePokemonGameControl) control;
    }

    @Override
    public TITGameResource initGameResource()
    {
        return new DoublePokemonGameResource(this);
    }

    @Override
    public TITScene initScene()
    {
        return new DoublePokemonGameScene();
    }
}
