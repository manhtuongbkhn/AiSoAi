package aisoai.screens.signinscreen;

import android.content.Context;
import android.widget.ProgressBar;
import android.widget.TextView;

import aisoai.R;
import aisoai.config.ClientConfig;
import aisoai.config.StrDefine;
import aisoai.config.UIDefine;
import aisoai.screens.titentities.control.TITControl;
import aisoai.screens.titentities.dialog.TITIDialog;

public class LoginDialog extends TITIDialog
{
    private ProgressBar pbWaiting;
    private TextView tvNotification;

    public LoginDialog(Context context, TITControl control)
    {
        super(context, control);
    }

    @Override
    public int getIcon()
    {
        return R.drawable.hourglass_icon;
    }

    @Override
    protected String getTitle()
    {
        return "Đăng nhập";
    }

    @Override
    protected int getLayout()
    {
        return R.layout.login_dialog;
    }

    @Override
    protected void linkToLayout()
    {
        pbWaiting=(ProgressBar) findViewById(R.id.pbWaiting);
        tvNotification=(TextView) findViewById(R.id.tvNotification);
        tvNotification.setText(StrDefine.LOGIN_WAITING);
    }

    @Override
    protected void scaleView()
    {
        pbWaiting.requestLayout();
        pbWaiting.getLayoutParams().width=LoginDialogUIDefine.WAITINGPB_WIDTH();
        pbWaiting.getLayoutParams().height=LoginDialogUIDefine.WAITINGPB_HEIGHT();


        tvNotification.setTextSize(UIDefine.MEDIUMTEXT_SIZE());
    }

    @Override
    protected void closeEvent()
    {

    }

    @Override
    protected int getWidth()
    {
        return LoginDialogUIDefine.LOGINDL_WIDTH();
    }

    @Override
    protected int getHeight()
    {
        return LoginDialogUIDefine.LOGINDL_HEIGHT();
    }

    @Override
    public SignInControl getControl()
    {
        return (SignInControl) control;
    }
}

class LoginDialogUIDefine
{
    public static int LOGINDL_WIDTH()
    {
        Float f = 280f * ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int LOGINDL_HEIGHT()
    {
        Float f = 60f * ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    public static int WAITINGPB_WIDTH()
    {
        Float f = 50*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int WAITINGPB_HEIGHT()
    {
        return WAITINGPB_WIDTH();
    }
}