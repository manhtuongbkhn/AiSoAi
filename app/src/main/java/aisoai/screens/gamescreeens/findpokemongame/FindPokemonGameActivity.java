package aisoai.screens.gamescreeens.findpokemongame;

import aisoai.TITApplication;
import aisoai.screens.gamescreeens.titentities.TITGameActivity;
import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.TITGameResource;
import aisoai.screens.gamescreeens.titentities.TITScene;
import aisoai.screens.gamescreeens.titentities.titsinglegame.TITSingleGameActivity;

public class FindPokemonGameActivity extends TITSingleGameActivity
{

    @Override
    protected TITGameControl linkControl()
    {
        return TITApplication.getScreenControlManager().getFindPokemonGameControl();
    }

    @Override
    public FindPokemonGameControl getControl()
    {
        return (FindPokemonGameControl) control;
    }

    @Override
    public TITGameResource initGameResource()
    {
        return new FindPokemonGameResource(this);
    }

    @Override
    public TITScene initScene()
    {
        return new FindPokemonGameScene();
    }
}
