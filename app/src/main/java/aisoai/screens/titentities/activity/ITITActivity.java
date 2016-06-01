package aisoai.screens.titentities.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import aisoai.screens.titentities.control.TITControl;
import aisoai.screens.titentities.dialog.ExitDialog;
import aisoai.screens.titentities.dialog.NetWorkErrorDialog;

public interface ITITActivity
{
    public void showMessage(String message,int type);
    public void changeActivity(Class inputClass,boolean finish);
    public void changeActivity(Class inputClass,boolean finish,Bundle bundle);
    public void setNetWorkErrorDialog(NetWorkErrorDialog netWorkErrorDialog);
    public NetWorkErrorDialog getNetWorkErrorDialog();
    public ExitDialog getExitDialog();
    public void setExitDialog(ExitDialog exitDialog);
    public Context getContext();
    public Activity getActivity();
    public TITControl getControl();
    public void finish();
}
