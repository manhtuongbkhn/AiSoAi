package aisoai.screens.insidetabscreen.insideroomscreen;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import aisoai.TITApplication;
import aisoai.config.UIDefine;
import aisoai.R;
import aisoai.screens.insidetabscreen.insideroomscreen.invitation.FriendListDialog;
import aisoai.screens.insidetabscreen.insideroomscreen.invitation.MoreFriendInfoDialog;
import aisoai.screens.titentities.activity.TITSpecActivity;
import aisoai.screens.titentities.control.TITSpecControl;
import aisoai.screens.titentities.dialog.choicegamedialog.ChoiceGameDialog;


public class InsideRoomActivity extends TITSpecActivity
{
    private ImageView ivRoomAvatar;
    private ImageView ivGameIcon;
    private TextView tvRoomName;
    private TextView tvRoomInvite;
    private TextView tvPlayerCount;
    private ImageView ivPlayerIcon;
    private ListView lvRoomPlayer;
    private ImageButton ibtStartGame;
    private ImageButton ibtInviteFriends;
    private ImageButton ibtExitRoom;

    private DownTimeDialog dlTime;
    private FriendListDialog dlFriendList;
    private MorePlayerInfoDialog dlMorePlayerInfo;
    private MoreFriendInfoDialog dlMoreFriendInfo;
    private IRChoiceGameDialog dlChoiceGame;

    @Override
    protected void linkToLayout()
    {
        setContentView(R.layout.inside_room);
        ivRoomAvatar=(ImageView) findViewById(R.id.ivRoomAvatar);
        ivGameIcon=(ImageView) findViewById(R.id.ivGameIcon);
        tvRoomName=(TextView) findViewById(R.id.tvRoomName);
        tvRoomInvite=(TextView) findViewById(R.id.tvRoomInvite);
        tvPlayerCount=(TextView) findViewById(R.id.tvCountPlayer);
        ivPlayerIcon=(ImageView) findViewById(R.id.ivPlayerIcon);
        lvRoomPlayer=(ListView) findViewById(R.id.lvRoomPlayer);
        ibtStartGame=(ImageButton) findViewById(R.id.ibtStartGame);
        ibtInviteFriends=(ImageButton) findViewById(R.id.ibtInviteFriends);
        ibtExitRoom=(ImageButton) findViewById(R.id.ibtExitRoom);

        ivGameIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getControl().changeGameEvent();
            }
        });

        ibtStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getControl().startGameEvent();
            }
        });

        ibtInviteFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getControl().invitationsEvent();
            }
        });

        ibtExitRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getControl().exitRoomEvent();
            }
        });
        dlChoiceGame=new IRChoiceGameDialog(this,null);
    }

    @Override
    protected void scaleView()
    {
        ivRoomAvatar.requestLayout();
        ivRoomAvatar.getLayoutParams().width= InsideRoomUIDefine.ROOMAVATARIV_WIDTH();
        ivRoomAvatar.getLayoutParams().height= InsideRoomUIDefine.ROOMAVATARIV_HEIGHT();

        ivGameIcon.requestLayout();
        ivGameIcon.getLayoutParams().width=InsideRoomUIDefine.GAMEICONIV_WIDTH();
        ivGameIcon.getLayoutParams().height=InsideRoomUIDefine.GAMEICONIV_HEIGHT();

        ivPlayerIcon.requestLayout();
        ivPlayerIcon.getLayoutParams().width= InsideRoomUIDefine.PLAYERICONIV_WIDTH();
        ivPlayerIcon.getLayoutParams().height= InsideRoomUIDefine.PLAYERICONIV_HEIGHT();

        ibtStartGame.requestLayout();
        ibtStartGame.getLayoutParams().width= InsideRoomUIDefine.STARTGAMEIBT_WIDTH();
        ibtStartGame.getLayoutParams().height= InsideRoomUIDefine.STARTGAMEIBT_HEIGHT();

        ibtInviteFriends.requestLayout();
        ibtInviteFriends.getLayoutParams().width= InsideRoomUIDefine.INVITEFRIENDSIBT_WIDTH();
        ibtInviteFriends.getLayoutParams().height= InsideRoomUIDefine.INVITEFRIENDSIBT_HEIGHT();

        ibtExitRoom.requestLayout();
        ibtExitRoom.getLayoutParams().width= InsideRoomUIDefine.EXITROOMIBT_WIDTH();
        ibtExitRoom.getLayoutParams().height= InsideRoomUIDefine.EXITROOMIBT_HEIGHT();

        tvRoomName.setTextSize(UIDefine.MEDIUMTEXT_SIZE());
        tvRoomInvite.setTextSize(UIDefine.SMALLTEXT_SIZE());
        tvPlayerCount.setTextSize(UIDefine.SMALLTEXT_SIZE());
    }

    public ImageView getIvRoomAvatar()
    {
        return ivRoomAvatar;
    }

    public ImageView getIvGameIcon()
    {
        return ivGameIcon;
    }

    public TextView getTvRoomName()
    {
        return tvRoomName;
    }

    public TextView getTvRoomInvite()
    {
        return tvRoomInvite;
    }

    public TextView getTvPlayerCount()
    {
        return tvPlayerCount;
    }

    public ListView getLvRoomPlayer()
    {
        return lvRoomPlayer;
    }

    public ImageButton getIbtStartGame()
    {
        return ibtStartGame;
    }

    public void setIbtStartGame(ImageButton ibtStartGame)
    {
        this.ibtStartGame = ibtStartGame;
    }

    public ImageButton getIbtInviteFriends() {
        return ibtInviteFriends;
    }

    public void setIbtInviteFriends(ImageButton ibtInviteFriends) {
        this.ibtInviteFriends = ibtInviteFriends;
    }

    public ImageButton getIbtExitRoom()
    {
        return ibtExitRoom;
    }

    public IRChoiceGameDialog getDlChoiceGame()
    {
        return dlChoiceGame;
    }

    public void setDlChoiceGame(IRChoiceGameDialog dlChoiceGame)
    {
        this.dlChoiceGame = dlChoiceGame;
    }

    public void setDlTime(DownTimeDialog dlTime)
    {
        this.dlTime = dlTime;
    }

    public DownTimeDialog getDlTime()
    {
        return dlTime;
    }

    public FriendListDialog getDlFriendList()
    {
        return dlFriendList;
    }

    public MorePlayerInfoDialog getDlMorePlayerInfo()
    {
        return dlMorePlayerInfo;
    }

    public void setDlMorePlayerInfo(MorePlayerInfoDialog dlMorePlayerInfo)
    {
        this.dlMorePlayerInfo = dlMorePlayerInfo;
    }

    public MoreFriendInfoDialog getDlMoreFriendInfo() {
        return dlMoreFriendInfo;
    }

    public void setDlMoreFriendInfo(MoreFriendInfoDialog dlMoreFriendInfo) {
        this.dlMoreFriendInfo = dlMoreFriendInfo;
    }

    public void setDlFriendList(FriendListDialog dlFriendList)
    {
        this.dlFriendList = dlFriendList;
    }

    @Override
    protected TITSpecControl linkControl()
    {
        return TITApplication.getScreenControlManager().getInsideRoomControl();
    }

    @Override
    public InsideRoomControl getControl()
    {
        return (InsideRoomControl) control;
    }
}
