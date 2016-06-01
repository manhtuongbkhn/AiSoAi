package aisoai.screens.titentities.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import aisoai.R;
import aisoai.TITApplication;
import aisoai.config.ClientConfig;
import aisoai.config.StrDefine;
import aisoai.config.UIDefine;
import aisoai.screens.signinscreen.SignInControl;
import aisoai.screens.startscreen.StartControl;
import aisoai.screens.titentities.control.TITControl;

public class NetWorkErrorDialog extends TITIDialog
{
    private TextView tvTitle;
    private TextView tvNotification;
    private ImageButton ibtConnect;

    public NetWorkErrorDialog(Context context, TITControl control)
    {
        super(context, control);
    }

    @Override
    protected int getLayout()
    {
        return R.layout.network_error_dialog;
    }

    @Override
    protected void linkToLayout()
    {
        tvTitle=(TextView) findViewById(R.id.tvTitle);
        tvNotification=(TextView) findViewById(R.id.tvNotification);
        ibtConnect=(ImageButton) findViewById(R.id.ibtConnect);

        tvTitle.setText(StrDefine.NETWORKERROR_TITLE);
        tvNotification.setText(StrDefine.NETWORKERROR_NOTIFICATION);
        ibtConnect.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TITApplication.getScreenControlManager().changeScreen(new SignInControl());
            }
        });
    }


    @Override
    protected void scaleView()
    {
        ibtConnect.requestLayout();
        ibtConnect.getLayoutParams().width= NetWorkDialogErrorUIDefine.CONNECTIBT_WIDTH();
        ibtConnect.getLayoutParams().height= NetWorkDialogErrorUIDefine.CONNECTIBT_HEIGHT();
        tvNotification.setTextSize(UIDefine.MEDIUMTEXT_SIZE());
    }

    @Override
    protected void closeEvent()
    {
    }

    @Override
    public int getIcon()
    {
        return R.drawable.connect;
    }

    @Override
    protected String getTitle()
    {
        return "Lỗi Kết Nối !";
    }


    @Override
    protected int getWidth()
    {
        return NetWorkDialogErrorUIDefine.NETWORKERRORDL_WIDTH();
    }

    @Override
    protected int getHeight()
    {
        return NetWorkDialogErrorUIDefine.NETWORKERRORDL_HEIGHT();
    }

    @Override
    public TITControl getControl()
    {
        return control;
    }
}

class NetWorkDialogErrorUIDefine
{
    public static int NETWORKERRORDL_WIDTH()
    {
        Float f = 280f * ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int NETWORKERRORDL_HEIGHT()
    {
        Float f = 100f * ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    public static int CONNECTIBT_WIDTH()
    {
        Float f = 80f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int CONNECTIBT_HEIGHT()
    {
        return CONNECTIBT_WIDTH()/2;
    }
}
