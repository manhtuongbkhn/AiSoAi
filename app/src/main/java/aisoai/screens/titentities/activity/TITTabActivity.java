package aisoai.screens.titentities.activity;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;

import aisoai.R;
import aisoai.config.ClientConfig;
import aisoai.screens.titentities.control.ITITSpecControl;
import aisoai.titapplib.TITUserVariable;
import aisoai.screens.titentities.control.TITTabControl;
import aisoai.screens.titentities.dialog.ExitDialog;
import aisoai.screens.titentities.dialog.NetWorkErrorDialog;
import aisoai.screens.titentities.dialog.WasInvitedDialog;

abstract public class TITTabActivity extends TabActivity implements ITITAppActivity
{
    protected TITTabControl control;
    protected TabHost tabHost;

    protected WasInvitedDialog wasInvitedDialog;
    protected NetWorkErrorDialog netWorkErrorDialog;
    protected ExitDialog exitDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        linkToLayout();
        initTabhost();
        scaleView();
        setControl();
        addTabSpec();
    }
    abstract protected void linkToLayout();
    abstract protected void scaleView();

    protected void setControl()
    {
        TITTabControl linkControl=linkControl();
        this.control=linkControl;
        linkControl.setActivity(this);
        linkControl.init();
    }

    abstract protected TITTabControl linkControl();

    protected void addTabSpec()
    {
        ArrayList<ITITSpecControl> controlArr=control.getControlArr();
        for(int i=0;i<controlArr.size();i++)
        {
            ITITSpecControl iSpecControl=controlArr.get(i);
            Class specActivityClass=iSpecControl.getActivityClass();
            String title=iSpecControl.initTitle();
            int drawbleId=iSpecControl.initDrawableId();

            TabHost.TabSpec tabSpec=tabHost.newTabSpec(title);
            //tabSpec.setIndicator("", getResources().getDrawable(drawbleId));
            View view=getLayoutInflater().inflate(R.layout.spec_icon,null);
            ImageView imageView=(ImageView) view.findViewById(R.id.ivSpecIcon);
            imageView.requestLayout();
            imageView.getLayoutParams().width=TITTabActivityUIDefine.SPECICONIV_WIDTH();
            imageView.getLayoutParams().height=TITTabActivityUIDefine.SPECICONIV_HEIGHT();
            imageView.setImageResource(drawbleId);
            tabSpec.setIndicator(view);
            Intent intentTab=new Intent(this,specActivityClass);
            tabSpec.setContent(intentTab);
            tabHost.addTab(tabSpec);
        }
    }

    protected void initTabhost()
    {
        tabHost=getTabHost();
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener()
        {
            @Override
            public void onTabChanged(String tabId)
            {
                getControl().tabChangeEvent(tabId);
            }
        });
    }

    public void showMessage(String message,int type)
    {
        if(type==1)
            Toast.makeText(TITTabActivity.this, message, Toast.LENGTH_LONG).show();
        if(type==2)
            Toast.makeText(TITTabActivity.this,message,Toast.LENGTH_SHORT).show();
    }

    public void changeActivity(Class inputClass,boolean finish)
    {
        Intent intent=new Intent(TITTabActivity.this,inputClass);
        startActivity(intent);
        if(finish)
            finish();
    }

    public void changeActivity(Class inputClass,boolean finish,Bundle bundle)
    {
        Intent intent=new Intent(TITTabActivity.this,inputClass);
        intent.putExtra("bundle", bundle);
        startActivity(intent);
        if(finish)
            finish();
    }

    @Override
    public void finish()
    {
        getControl().finish();
        super.finish();
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

    //Get Set Method

    abstract public TITTabControl getControl();

    @Override
    public Activity getActivity()
    {
        return TITTabActivity.this;
    }
}
