package aisoai.screens.titentities.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import aisoai.R;
import aisoai.config.ClientConfig;
import aisoai.config.StrDefine;
import aisoai.config.UIDefine;
import aisoai.screens.titentities.control.TITControl;

public class ExitDialog extends TITIDialog
{
    private TextView tvNotification;
    private ImageButton ibtConfirm;
    private ImageButton ibtCancel;

    public ExitDialog(Context context, TITControl control)
    {
        super(context, control);
    }

    @Override
    public int getIcon()
    {
        return R.drawable.turnoff_icon;
    }

    @Override
    protected int getLayout()
    {
        return R.layout.exit_dialog;
    }

    @Override
    protected void linkToLayout()
    {
        tvNotification=(TextView) findViewById(R.id.tvNotification);
        ibtConfirm=(ImageButton) findViewById(R.id.ibtConfirm);
        ibtCancel=(ImageButton) findViewById(R.id.ibtCancel);

        ibtConfirm.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getControl().exitDialogConfirmEvent();
            }
        });

        ibtCancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dismiss();
            }
        });

        tvNotification.setText(StrDefine.EXIT_NOTIFICATION);
    }

    @Override
    protected void scaleView()
    {
        ibtConfirm.requestLayout();
        ibtConfirm.getLayoutParams().width=ExitDialogUIDefine.CONFIRMIBT_WIDTH();
        ibtConfirm.getLayoutParams().height=ExitDialogUIDefine.CONFIRMIBT_HEIGHT();

        ibtCancel.requestLayout();
        ibtCancel.getLayoutParams().width=ExitDialogUIDefine.CANCELIBT_WIDTH();
        ibtCancel.getLayoutParams().height=ExitDialogUIDefine.CANCELIBT_HEIGHT();
        tvNotification.setTextSize(UIDefine.MEDIUMTEXT_SIZE());
    }

    @Override
    protected void closeEvent()
    {
        dismiss();
    }

    @Override
    public String getTitle()
    {
        return "Thoát Ứng Dụng";
    }

    @Override
    protected int getWidth()
    {
        return ExitDialogUIDefine.EXITDL_WIDTH();
    }

    @Override
    protected int getHeight()
    {
        return ExitDialogUIDefine.EXITDL_HEIGHT();
    }

    @Override
    public TITControl getControl()
    {
        return control;
    }
}

class ExitDialogUIDefine
{
    public static int EXITDL_WIDTH()
    {
        Float f = 280f * ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int EXITDL_HEIGHT()
    {
        Float f = 100f * ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    public static int CONFIRMIBT_WIDTH()
    {
        Float f = 40f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int CONFIRMIBT_HEIGHT()
    {
        return CONFIRMIBT_WIDTH();
    }

    public static int CANCELIBT_WIDTH()
    {
        Float f = 40f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int CANCELIBT_HEIGHT()
    {
        return CANCELIBT_WIDTH();
    }
}