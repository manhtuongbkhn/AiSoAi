package aisoai.screens.gamescreeens.titentities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.IEntity;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.util.FPSLogger;
import org.andengine.input.touch.controller.MultiTouch;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import aisoai.config.ClientConfig;
import aisoai.screens.titentities.activity.ITITActivity;
import aisoai.screens.titentities.dialog.ExitDialog;
import aisoai.screens.titentities.dialog.NetWorkErrorDialog;

public abstract class TITGameActivity extends SimpleBaseGameActivity implements ITITActivity
{
    protected TITGameControl control;
    protected NetWorkErrorDialog netWorkErrorDialog;
    private ExitDialog exitDialog;

    @Override
    public EngineOptions onCreateEngineOptions()
    {
        float cameraWidth,cameraHeight;
        switch (getScreenOrientation())
        {
            case PORTRAIT_FIXED:
            case PORTRAIT_SENSOR:
                cameraWidth=TITGameConfig.SCREEN_WIDTH;
                cameraHeight=TITGameConfig.SCREEN_HEIGHT;
                break;
            case LANDSCAPE_FIXED:
            case LANDSCAPE_SENSOR:
            default:
                cameraWidth=TITGameConfig.SCREEN_HEIGHT;
                cameraHeight=TITGameConfig.SCREEN_WIDTH;
                break;
        }
        float cameraPostionX=getCameraPostionX();
        float cameraPostionY=getCameraPostionY();
        TITCamera titCamera=new TITCamera
                (cameraPostionX,cameraPostionY,cameraWidth,cameraHeight);
        RatioResolutionPolicy ratioResolutionPolicy=new RatioResolutionPolicy(cameraWidth/cameraHeight);
        EngineOptions engineOptions=
                new EngineOptions(true,getScreenOrientation(),ratioResolutionPolicy,titCamera);
        engineOptions.getTouchOptions().setNeedsMultiTouch(true);
        engineOptions.getAudioOptions().setNeedsMusic(true);
        engineOptions.getAudioOptions().setNeedsSound(true);
        TITGameConfig.MULTITOUCHSUPPORT= MultiTouch.isSupported(this);
        TITGameConfig.MULTITOUCHSUPPORTDISTINCT=MultiTouch.isSupportedDistinct(this);
        return engineOptions;
    }

    abstract protected float getCameraPostionX();
    abstract protected float getCameraPostionY();
    abstract protected ScreenOrientation getScreenOrientation();

    @Override
    protected void onCreateResources()
    {
        titGameResource= initGameResource();
        titGameResource.init();
    }

    @Override
    protected Scene onCreateScene()
    {
        mEngine.registerUpdateHandler(new FPSLogger());
        TITScene titScene= initScene();
        return titScene;
    }

    @Override
    protected void onLoadComplete()
    {
        setControl();
    }

    protected void setControl()
    {
        Thread thread=new Thread()
        {
            @Override
            public void run()
            {
                TITGameControl linkControl=linkControl();
                TITGameActivity.this.control=linkControl;
                linkControl.setActivity(TITGameActivity.this);
                linkControl.setEngine(getEngine());
                linkControl.setGameResource(titGameResource);
                linkControl.init();
            }
        };
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }

    abstract protected TITGameControl linkControl();

    public boolean detachChild(final IEntity iEntity)
    {
        runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                getEngine().getScene().detachChild(iEntity);
            }
        });
        return true;
    }

    public void showMessage(String message,int type)
    {
        if(type==1)
            Toast.makeText(TITGameActivity.this, message, Toast.LENGTH_LONG).show();
        if(type==2)
            Toast.makeText(TITGameActivity.this,message,Toast.LENGTH_SHORT).show();
    }

    public void changeActivity(Class inputClass,boolean finish)
    {
        Intent intent=new Intent(TITGameActivity.this,inputClass);
        startActivity(intent);
        if(finish)
            finish();
    }

    public void changeActivity(Class inputClass,boolean finish,Bundle bundle)
    {
        Intent intent=new Intent(TITGameActivity.this,inputClass);
        intent.putExtra("bundle",bundle);
        startActivity(intent);
        if(finish)
            finish();
    }

    @Override
    public void setNetWorkErrorDialog(NetWorkErrorDialog netWorkErrorDialog)
    {
        this.netWorkErrorDialog = netWorkErrorDialog;
    }

    @Override
    public NetWorkErrorDialog getNetWorkErrorDialog()
    {
        return netWorkErrorDialog;
    }

    @Override
    public ExitDialog getExitDialog()
    {
        return exitDialog;
    }

    @Override
    public void setExitDialog(ExitDialog exitDialog)
    {
        this.exitDialog = exitDialog;
    }

    @Override
    public Context getContext()
    {
        return this;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            getControl().backEvent();
        }
        return true;
    }

    abstract public TITGameControl getControl();
    abstract public TITGameResource initGameResource();
    abstract public TITScene initScene();

    private TITGameResource titGameResource;//No Problem

    @Override
    public Activity getActivity()
    {
        return this;
    }
}
