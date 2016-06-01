package aisoai.screens.titentities.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import aisoai.R;
import aisoai.config.ClientConfig;
import aisoai.config.UIDefine;
import aisoai.screens.titentities.control.TITAppControl;

public class WasInvitedDialog extends TITIDialog
{
    private ImageView ivPlayerAvatar;
    private TextView tvNotification;
    private ImageButton ibtConfirm;
    private ImageButton ibtCancel;

    public WasInvitedDialog(Context context, TITAppControl control)
    {
        super(context,control);
    }

    @Override
    protected int getLayout()
    {
        return R.layout.was_invited_dialog;
    }

    @Override
    protected void linkToLayout()
    {
        ivPlayerAvatar=(ImageView) findViewById(R.id.ivPlayerAvatar);
        tvNotification=(TextView) findViewById(R.id.tvNotification);
        ibtConfirm=(ImageButton) findViewById(R.id.ibtConfirm);
        ibtCancel=(ImageButton) findViewById(R.id.ibtCancel);
    }

    @Override
    protected void scaleView()
    {
        ivPlayerAvatar.requestLayout();
        ivPlayerAvatar.getLayoutParams().width=WasInvitedDialogUIDefine.PLAYERIV_WIDTH();
        ivPlayerAvatar.getLayoutParams().height=WasInvitedDialogUIDefine.PLAYERIV_HEIGHT();

        ibtConfirm.requestLayout();
        ibtConfirm.getLayoutParams().width=WasInvitedDialogUIDefine.CONFIRMIBT_WIDTH();
        ibtConfirm.getLayoutParams().height=WasInvitedDialogUIDefine.CONFIRMIBT_HEIGHT();

        ibtCancel.requestLayout();
        ibtCancel.getLayoutParams().width=WasInvitedDialogUIDefine.CONFIRMIBT_WIDTH();
        ibtCancel.getLayoutParams().height=WasInvitedDialogUIDefine.CONFIRMIBT_HEIGHT();

        ibtConfirm.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getControl().invitationAnswerEvent(true);
                dismiss();
            }
        });

        ibtCancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getControl().invitationAnswerEvent(false);
                dismiss();
            }
        });
        tvNotification.setTextSize(UIDefine.MEDIUMTEXT_SIZE());
    }

    public ImageView getIvPlayerAvatar()
    {
        return ivPlayerAvatar;
    }

    public TextView getTvNotification()
    {
        return tvNotification;
    }

    @Override
    public int getIcon()
    {
        return R.drawable.invitaion_message;
    }

    @Override
    protected String getTitle()
    {
        return "Lời Mời";
    }

    @Override
    protected void closeEvent()
    {
        dismiss();
    }

    @Override
    protected int getWidth()
    {
        return WasInvitedDialogUIDefine.WASINVITEDDL_WIDTH();
    }

    @Override
    protected int getHeight()
    {
        return WasInvitedDialogUIDefine.WASINVITEDDL_HEIGHT();
    }

    @Override
    public TITAppControl getControl()
    {
        return (TITAppControl) control;
    }
}

class WasInvitedDialogUIDefine
{
    public static int WASINVITEDDL_WIDTH()
    {
        Float f = 280f * ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int WASINVITEDDL_HEIGHT()
    {
        Float f = 100f * ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }

    public static int PLAYERIV_WIDTH()
    {
        Float f = 50f * ClientConfig.SCREEN_WIDTH_PX / 320f;
        return f.intValue();
    }

    public static int PLAYERIV_HEIGHT()
    {
        return PLAYERIV_WIDTH();
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