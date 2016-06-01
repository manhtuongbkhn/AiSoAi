package aisoai.screens.gamescreeens.carogame;

import org.andengine.engine.options.ScreenOrientation;

import aisoai.TITApplication;
import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.TITGameResource;
import aisoai.screens.gamescreeens.titentities.TITScene;
import aisoai.screens.gamescreeens.titentities.titvsgame.TITVsGameActivity;

public class CaronGameActivity extends TITVsGameActivity
{
    @Override
    protected float getCameraPostionX()
    {
        return -CaroGameConfig.HUD_WIDTH;
    }

    @Override
    protected float getCameraPostionY()
    {
        return 0;
    }

    @Override
    protected ScreenOrientation getScreenOrientation()
    {
        return ScreenOrientation.LANDSCAPE_FIXED;
    }

    @Override
    protected TITGameControl linkControl()
    {
        return TITApplication.getScreenControlManager().getCaroGameControl();
    }

    @Override
    public CaroGameControl getControl()
    {
        return (CaroGameControl) control;
    }

    @Override
    public TITGameResource initGameResource()
    {
        return new CaroGameResource(this);
    }

    @Override
    public TITScene initScene()
    {
        return new CaroGameSence();
    }
}
