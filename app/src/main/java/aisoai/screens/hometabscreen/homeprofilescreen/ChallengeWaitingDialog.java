package aisoai.screens.hometabscreen.homeprofilescreen;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import aisoai.R;
import aisoai.config.UIDefine;
import aisoai.screens.titentities.control.TITControl;
import aisoai.screens.titentities.dialog.TITIDialog;

public class ChallengeWaitingDialog extends TITIDialog
{
    private ProgressBar pbWaiting;
    private TextView tvGuessTime;
    private TextView tvRealityTime;
    private ImageButton ibtCancel;

    public ChallengeWaitingDialog(Context context, TITControl control)
    {
        super(context, control);
    }

    @Override
    protected String getTitle()
    {
        return "Vui Lòng Chờ !";
    }

    @Override
    protected int getLayout()
    {
        return R.layout.challenge_waiting_dialog;
    }

    @Override
    protected void linkToLayout()
    {
        pbWaiting=(ProgressBar) findViewById(R.id.pbWaiting);
        tvGuessTime=(TextView) findViewById(R.id.tvGuessTime);
        tvRealityTime=(TextView) findViewById(R.id.tvRealityTime);
        ibtCancel=(ImageButton) findViewById(R.id.ibtCancel);
        ibtCancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getControl().cancelChallengeEvent();
            }
        });
    }

    @Override
    protected void scaleView()
    {
        pbWaiting.requestLayout();
        pbWaiting.getLayoutParams().width=ChallengeWaitingDialogUIDefine.WAITINGPB_WIDTH();
        pbWaiting.getLayoutParams().height=ChallengeWaitingDialogUIDefine.WAITINGPB_HEIGHT();

        tvGuessTime.setTextSize(UIDefine.MEDIUMTEXT_SIZE());
        tvRealityTime.setTextSize(UIDefine.MEDIUMTEXT_SIZE());

        ibtCancel.requestLayout();
        ibtCancel.getLayoutParams().width= ChallengeWaitingDialogUIDefine.CANCELIBT_WIDTH();
        ibtCancel.getLayoutParams().height= ChallengeWaitingDialogUIDefine.CANCELIBT_HEIGHT();
    }

    @Override
    protected void closeEvent()
    {
        getControl().cancelChallengeEvent();
    }

    @Override
    public int getIcon()
    {
        return R.drawable.hourglass_icon;
    }

    @Override
    protected int getWidth()
    {
        return ProfileUIDefine.CHALLENGEWAITINGDL_WIDTH();
    }

    @Override
    protected int getHeight()
    {
        return ProfileUIDefine.CHALLENGEWAITTINGDL_HEIGHT();
    }

    @Override
    public ProfileControl getControl()
    {
        return (ProfileControl) control;
    }

    public void setGuessTime(Integer minute,Integer second)
    {
        String guessTime=new String("Ước tính:  ");
        if(minute<10)
            guessTime=guessTime+"0"+minute.toString();
        else
            guessTime=guessTime+minute.toString();

        guessTime=guessTime+":";

        if(second<10)
            guessTime=guessTime+"0"+second.toString();
        else
            guessTime=guessTime+second.toString();
        tvGuessTime.setText(guessTime);
    }

    public void setRealityTime(Integer minute,Integer second)
    {
        String realityTime=new String("Thực tế:    ");
        if(minute<10)
            realityTime=realityTime+"0"+minute.toString();
        else
            realityTime=realityTime+minute.toString();

        realityTime=realityTime+":";

        if(second<10)
            realityTime=realityTime+"0"+second.toString();
        else
            realityTime=realityTime+second.toString();
        tvRealityTime.setText(realityTime);
    }
}
