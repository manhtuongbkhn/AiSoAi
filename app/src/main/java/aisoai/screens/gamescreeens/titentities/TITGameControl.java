package aisoai.screens.gamescreeens.titentities;

import com.google.gson.JsonObject;

import org.andengine.engine.Engine;

import aisoai.TITApplication;
import aisoai.screens.gamescreeens.titentities.titsinglegame.TITSingleGameHUD;
import aisoai.screens.scoringscreen.ScoringControl;
import aisoai.screens.titentities.control.TITControl;

abstract public class TITGameControl extends TITControl
{
    public Engine engine;
    public TITGameResource gameResource;

    public TITGameControl()
    {
        super();
    }

    @Override
    public void init()
    {
        initHUD();
        initPlaySpace();
    }

    abstract protected void initHUD();

    abstract protected void initPlaySpace();

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public void playingGameUserInfoNotify(JsonObject fromServerData)
    {

    }

    public void startScoringNotify(JsonObject fromServerData)
    {
        finish();
        try {Thread.sleep(300);} catch (InterruptedException e) {}
        getScene().clearChildScene();
        getEngine().clearUpdateHandlers();
        getEngine().stop();
        getEngine().clearDrawHandlers();
        gameResource.destroy();

        getActivity().showMessage("Kết thúc game!", 1);
        TITApplication.getScreenControlManager().changeScreen(initScoringControl());
    }

    abstract protected ScoringControl initScoringControl();

    public TITCamera getCamera()
    {
        return (TITCamera) engine.getCamera();
    }


    public void setGameResource(TITGameResource gameResource)
    {
        this.gameResource = gameResource;
    }

    public Engine getEngine()
    {
        return getActivity().getEngine();
    }

    public void setEngine(Engine engine)
    {
        this.engine=engine;
    }

    public TITHUD getHud()
    {
        return (TITHUD) getCamera().getHUD();
    }

    abstract public TITScene getScene();
    //abstract public TITGameResource getGameResource();

    @Override
    abstract protected TITGameModel initModel();

    @Override
    abstract public TITGameActivity getActivity();
    @Override
    abstract public TITGameModel getModel();
}
