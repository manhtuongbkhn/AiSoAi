package aisoai.screens.titentities.activity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Toast;

import aisoai.config.ClientConfig;
import aisoai.titapplib.TITUserVariable;
import aisoai.screens.titentities.control.TITAppControl;
import aisoai.screens.titentities.control.TITNormalControl;
import aisoai.screens.titentities.dialog.ExitDialog;
import aisoai.screens.titentities.dialog.NetWorkErrorDialog;
import aisoai.screens.titentities.dialog.WasInvitedDialog;


abstract public class TITNormalActivity extends Activity implements ITITAppActivity
{
    protected TITAppControl control;
    protected WasInvitedDialog wasInvitedDialog;
    protected NetWorkErrorDialog netWorkErrorDialog;
    protected ExitDialog exitDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        linkToLayout();
        scaleView();
        setControl();
    }

    abstract protected void linkToLayout();
    abstract protected void scaleView();

    protected void setControl()
    {
        TITNormalControl linkControl=linkControl();
        this.control=linkControl;
        linkControl.setActivity(this);
        linkControl.init();
    }

    abstract protected TITNormalControl linkControl();

    @Override
    public void showMessage(String message,int type)
    {
        if(type==1)
            Toast.makeText(TITNormalActivity.this, message, Toast.LENGTH_LONG).show();
        if(type==2)
            Toast.makeText(TITNormalActivity.this,message,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void changeActivity(Class inputClass,boolean finish)
    {
        Intent intent=new Intent(TITNormalActivity.this,inputClass);
        startActivity(intent);
        if(finish)
            finish();
    }

    @Override
    public void changeActivity(Class inputClass,boolean finish,Bundle bundle)
    {
        Intent intent=new Intent(TITNormalActivity.this,inputClass);
        intent.putExtra("bundle", bundle);
        startActivity(intent);
        if(finish)
            finish();
    }

    protected void getScreenConfig()
    {
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics ();
        display.getMetrics(outMetrics);

        float density=getResources().getDisplayMetrics().density;
        float dpHeight=outMetrics.heightPixels/density;
        float dpWidth=outMetrics.widthPixels/density;
        ClientConfig.SCREEN_WIDTH_DP=dpWidth;
        ClientConfig.SCREEN_HEIGHT_DP=dpHeight;
        ClientConfig.SCREEN_WIDTH_PX=display.getWidth();
        ClientConfig.SCREEN_HEIGHT_PX=display.getHeight();
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
    public void setWasInvitedDialog(WasInvitedDialog wasInvitedDialog)
    {
        this.wasInvitedDialog = wasInvitedDialog;
    }

    @Override
    public WasInvitedDialog getWasInvitedDialog()
    {
        return wasInvitedDialog;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            System.out.println("Back Event TITActivity");
            getControl().backEvent();
        }
        return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event)
    {
        if (!TITUserVariable.isWaitingResponse())
            return super.dispatchTouchEvent(event);
        return true;
    }

    @Override
    public Context getContext()
    {
        return this;
    }

    abstract public TITNormalControl getControl();

    @Override
    public Activity getActivity()
    {
        return TITNormalActivity.this;
    }
}
