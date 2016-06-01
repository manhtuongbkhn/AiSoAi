package aisoai.screens.hometabscreen.homeprofilescreen;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;

import aisoai.R;
import aisoai.gameinfo.TITGameInfo;
import aisoai.gameinfo.TITGameInfoFactory;
import aisoai.screens.titentities.control.TITControl;
import aisoai.screens.titentities.dialog.TITIDialog;

public class ChallengeDialog extends TITIDialog
{
    public ChallengeDialog(Context context, TITControl control)
    {
        super(context,control);
    }

    private Spinner spGame;
    private ImageButton ibtConfirm;
    private ImageButton ibtCancel;

    @Override
    protected int getLayout()
    {
        return R.layout.challenge_dialog;
    }

    @Override
    protected void linkToLayout()
    {
        spGame=(Spinner) findViewById(R.id.spGame);
        ibtConfirm=(ImageButton) findViewById(R.id.ibtConfirm);
        ibtConfirm.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dismiss();
                getControl().challengeConfirmEvent();
            }
        });

        ibtCancel=(ImageButton) findViewById(R.id.ibtCancel);

        ibtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    protected void scaleView()
    {
        spGame.requestLayout();
        spGame.getLayoutParams().width=ChallengeDialogUIDefine.GAMESP_WIDTH();
        spGame.getLayoutParams().height=ChallengeDialogUIDefine.GAMESP_HEIGHT();

        ibtConfirm.requestLayout();
        ibtConfirm.getLayoutParams().width= ChallengeDialogUIDefine.CONFIRMIBT_WIDTH();
        ibtConfirm.getLayoutParams().height= ChallengeDialogUIDefine.CONFIRMIBT_HEIGHT();

        ibtCancel.requestLayout();
        ibtCancel.getLayoutParams().width= ChallengeDialogUIDefine.CONFIRMIBT_WIDTH();
        ibtCancel.getLayoutParams().height= ChallengeDialogUIDefine.CONFIRMIBT_HEIGHT();
    }

    public void setContent()
    {
        ArrayList<TITGameInfo> gameInfoArr= TITGameInfoFactory.getAllGameInfoArr();
        spGame.setAdapter
                (new GameArrayAdapter((ProfileActivity) control.getActivity(),gameInfoArr));
        spGame.setAdapter
                (new GameArrayAdapter((ProfileActivity) control.getActivity(),gameInfoArr));
    }

    @Override
    public int getIcon()
    {
        return R.drawable.top20;
    }

    @Override
    protected void closeEvent()
    {
        dismiss();
    }

    @Override
    public String getTitle()
    {
        return "Tham Gia Thách Đấu";
    }

    @Override
    protected int getWidth()
    {
        return ChallengeDialogUIDefine.CHALLENGEDL_WIDTH();
    }

    @Override
    protected int getHeight()
    {
        return ChallengeDialogUIDefine.CHALLENGEDL_HEIGHT();
    }

    @Override
    public ProfileControl getControl()
    {
        return (ProfileControl) control;
    }

    public Spinner getSpGame()
    {
        return spGame;
    }
}