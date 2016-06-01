package aisoai.screens.scoringscreen;

import android.content.pm.ActivityInfo;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import aisoai.R;
import aisoai.screens.titentities.activity.TITNormalActivity;

abstract public class ScoringActivity extends TITNormalActivity
{
    private ImageView ivRoomAvatar;
    private TextView tvRoomName;
    private ImageView ivGameIcon;
    private ImageView ivWinPlayerAvatar;
    private ImageView ivCup;

    private ImageView ivSummaryPoint;
    private Button btExitRoom;
    private Button btBackRoom;

    @Override
    protected void linkToLayout()
    {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(initLayout());
        ivRoomAvatar=(ImageView) findViewById(R.id.ivRoomAvatar);
        tvRoomName=(TextView) findViewById(R.id.tvRoomName);
        ivGameIcon=(ImageView) findViewById(R.id.ivGameIcon);
        ivWinPlayerAvatar=(ImageView) findViewById(R.id.ivWinPlayerAvatar);
        ivCup=(ImageView) findViewById(R.id.ivCup);

        ivSummaryPoint=(ImageView) findViewById(R.id.ivSummaryPoint);
        btExitRoom=(Button) findViewById(R.id.btExitRoom);
        btBackRoom=(Button) findViewById(R.id.btBackRoom);

        btExitRoom.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getControl().exitRoomFinishEvent();
            }
        });

        btBackRoom.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getControl().backRoomFinishEvent();
            }
        });
    }

    abstract protected int initLayout();

    @Override
    protected void scaleView()
    {
        ivRoomAvatar.requestLayout();
        ivRoomAvatar.getLayoutParams().width=ScoringUIDefine.ROOMAVATARIV_WIDTH();
        ivRoomAvatar.getLayoutParams().height=ScoringUIDefine.ROOMAVATARIV_HEIGHT();

        ivGameIcon.requestLayout();
        ivGameIcon.getLayoutParams().width=ScoringUIDefine.GAMEICONIV_WIDTH();
        ivGameIcon.getLayoutParams().height=ScoringUIDefine.GAMEICONIV_HEIGHT();

        ivCup.requestLayout();
        ivCup.getLayoutParams().width=ScoringUIDefine.CUPIV_WIDTH();
        ivCup.getLayoutParams().height=ScoringUIDefine.CUPIV_HEIGHT();

        ivWinPlayerAvatar.requestLayout();
        ivWinPlayerAvatar.getLayoutParams().width=ScoringUIDefine.WINERIV_WIDTH();
        ivWinPlayerAvatar.getLayoutParams().height=ScoringUIDefine.WINERIV_HEIGHT();

        btExitRoom.requestLayout();
        btExitRoom.getLayoutParams().width= ScoringUIDefine.EXITROOMBT_WIDTH();
        btExitRoom.getLayoutParams().height= ScoringUIDefine.EXITROOMBT_HEIGHT();

        btBackRoom.getLayoutParams().width= ScoringUIDefine.EXITROOMBT_WIDTH();
        btBackRoom.getLayoutParams().height= ScoringUIDefine.EXITROOMBT_HEIGHT();
    }

    public ImageView getIvRoomAvatar()
    {
        return ivRoomAvatar;
    }

    public TextView getTvRoomName()
    {
        return tvRoomName;
    }

    public ImageView getIvGameIcon()
    {
        return ivGameIcon;
    }

    public ImageView getIvWinPlayerAvatar()
    {
        return ivWinPlayerAvatar;
    }

    public ImageView getIvSummaryPoint()
    {
        return ivSummaryPoint;
    }

    public Button getBtExitRoom()
    {
        return btExitRoom;
    }

    public Button getBtBackRoom()
    {
        return btBackRoom;
    }

    @Override
    public ScoringControl getControl()
    {
        return (ScoringControl) control;
    }
}
