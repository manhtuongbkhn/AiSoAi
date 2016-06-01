package aisoai.screens.gamescreeens.titentities.titsinglegame;

import org.andengine.engine.options.ScreenOrientation;

import aisoai.screens.gamescreeens.titentities.TITGameActivity;

abstract public class TITSingleGameActivity extends TITGameActivity
{
    @Override
    protected float getCameraPostionX()
    {
        return 0;
    }

    @Override
    protected float getCameraPostionY()
    {
        return TITSingleGameConfig.CAMERA_Y();
    }

    @Override
    protected ScreenOrientation getScreenOrientation()
    {
        return ScreenOrientation.PORTRAIT_FIXED;
    }
}
