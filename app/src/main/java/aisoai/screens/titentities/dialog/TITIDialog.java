package aisoai.screens.titentities.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import aisoai.R;
import aisoai.config.ClientConfig;
import aisoai.config.UIDefine;
import aisoai.screens.titentities.control.TITControl;

public abstract class TITIDialog extends Dialog
{
    protected TITControl control;
    private FrameLayout fl;
    private LinearLayout llDialog;
    private LinearLayout llTitle;
    private ImageView ivDialogIcon;
    private TextView tvTitle;
    private LinearLayout llContent;
    private ImageButton ibtClose;

    public TITIDialog(Context context,TITControl control)
    {
        super(context);
        this.control=control;
        setDefault();
        titLinkToLayout();
        titScaleView();
    }

    private void setDefault()
    {
        getWindow();
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    private void titLinkToLayout()
    {
        setContentView(getLayout());

        fl=(FrameLayout) findViewById(R.id.fl);
        llDialog=(LinearLayout) findViewById(R.id.llDialog);
        llTitle=(LinearLayout) findViewById(R.id.llTitle);
        llTitle.setBackgroundColor(TITDialogUIDefine.TITLELL_COLOR());
        ivDialogIcon=(ImageView) findViewById(R.id.ivDialogIcon);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText(getTitle());
        tvTitle.setTextColor(TITDialogUIDefine.TITLE_COLOR());
        llContent=(LinearLayout) findViewById(R.id.llContent);
        ibtClose=(ImageButton) findViewById(R.id.ibtClose);
        ibtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                closeEvent();
            }
        });

        linkToLayout();
    }

    private void titScaleView()
    {
        fl.requestLayout();
        fl.getLayoutParams().width=getWidth()+2*TITDialogUIDefine.DIALOGLL_MARGIN()+
                                                                2*TITDialogUIDefine.BORDER_MARGIN();
        fl.getLayoutParams().height= getHeight()+2*TITDialogUIDefine.DIALOGLL_MARGIN()+
                            2*TITDialogUIDefine.BORDER_MARGIN()+TITDialogUIDefine.TITLELL_HEIGHT();

        LinearLayout.LayoutParams llLP;
        FrameLayout.LayoutParams flLP;
        int margin;

        llDialog.requestLayout();
        flLP=(FrameLayout.LayoutParams)llDialog.getLayoutParams();
        flLP.width=getWidth()+2*TITDialogUIDefine.BORDER_MARGIN();
        flLP.height=getHeight()+TITDialogUIDefine.TITLELL_HEIGHT()+
                                                                2*TITDialogUIDefine.BORDER_MARGIN();
        margin=TITDialogUIDefine.DIALOGLL_MARGIN();
        flLP.setMargins(margin, margin, margin, margin);
        llDialog.setLayoutParams(flLP);

        llTitle.requestLayout();
        llLP=(LinearLayout.LayoutParams)llTitle.getLayoutParams();
        llLP.height=TITDialogUIDefine.TITLELL_HEIGHT();
        margin=TITDialogUIDefine.BORDER_MARGIN();
        llLP.setMargins(margin,margin,margin,0);
        llTitle.setLayoutParams(llLP);

        ivDialogIcon.requestLayout();
        ivDialogIcon.getLayoutParams().width=TITDialogUIDefine.DIALOGICON_WIDTH();
        ivDialogIcon.getLayoutParams().height=TITDialogUIDefine.DIALOGICON_HEIGHT();
        ivDialogIcon.setImageResource(getIcon());
        tvTitle.setTextSize(UIDefine.BIGTEXT_SIZE());

        llContent.requestLayout();
        llLP=(LinearLayout.LayoutParams)llContent.getLayoutParams();
        llLP.width=getWidth();
        llLP.height=getHeight();
        margin=TITDialogUIDefine.BORDER_MARGIN();
        llLP.setMargins(margin,0,margin,margin);
        llContent.setLayoutParams(llLP);

        ibtClose.requestLayout();
        ibtClose.getLayoutParams().width=TITDialogUIDefine.CLOSEIBT_WIDTH();
        ibtClose.getLayoutParams().height=TITDialogUIDefine.CLOSEIBT_HEIGHT();

        scaleView();
    }

    public void setControl(TITControl control)
    {
        this.control=control;
    }

    abstract public int getIcon();

    abstract protected String getTitle();
    abstract protected int getLayout();
    abstract protected void linkToLayout();
    abstract protected void scaleView();
    abstract protected void closeEvent();
    abstract protected int getWidth();
    abstract protected int getHeight();
    abstract public TITControl getControl();
}

class TITDialogUIDefine
{
    public static int TITLELL_COLOR()
    {
        return Color.argb(255,102,255,255);
    }

    public static int TITLE_COLOR()
    {
        return Color.argb(255,255,51,255);
    }

    public static int DIALOGICON_WIDTH()
    {
        Float f=30f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int DIALOGICON_HEIGHT()
    {
        return DIALOGICON_WIDTH();
    }

    public static int TITLELL_HEIGHT()
    {
        Float f=40f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int DIALOGLL_MARGIN()
    {
        Float f=16f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int BORDER_MARGIN()
    {
        Float f=4f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int CLOSEIBT_WIDTH()
    {
        Float f = 30f* ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int CLOSEIBT_HEIGHT()
    {
        return CLOSEIBT_WIDTH();
    }

    public static int WASINVITEDDL_WIDTH()
    {
        Float f=280f*ClientConfig.SCREEN_WIDTH_PX/320f;
        return f.intValue();
    }

    public static int WASINVITEDDL_HEIGHT()
    {
        Float f=120f *ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }
}