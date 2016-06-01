package aisoai.screens.insidetabscreen.insideroomscreen;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import aisoai.config.UIDefine;
import aisoai.screens.titentities.activity.TITNormalActivity;
import aisoai.titapplib.TITUserVariable;
import aisoai.R;

public class PlayerArrayAdapter extends ArrayAdapter<PlayerInfo>
{
    private TITNormalActivity titActivity;
    private ArrayList<PlayerInfo> playerArr;
    private InsideRoomControl control;

    private View row;
    private ImageView ivPlayerAvatar;
    private TextView tvPlayerName;

    private TextView tvMatchCount;
    private TextView tvWinPercent;
    private ImageButton ibtMoreInfo;
    private ImageButton ibtKickPlayer;

    public PlayerArrayAdapter(TITNormalActivity titActivity, InsideRoomControl control,
                              ArrayList<PlayerInfo> playerArr)
    {
        super(titActivity, R.layout.player_item,playerArr);
        this.titActivity=titActivity;
        this.playerArr=playerArr;
        this.control=control;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent)
    {
        LayoutInflater inflater=titActivity.getLayoutInflater();
        row=inflater.inflate(R.layout.player_item,parent,false);
        linkToLayout(position);
        scaleView();
        setContentView(position);
        return row;
    }

    public void linkToLayout(final int postion)
    {
        ivPlayerAvatar=(ImageView) row.findViewById(R.id.ivPlayerAvatar);
        tvPlayerName=(TextView) row.findViewById(R.id.tvPlayerName);
        tvMatchCount=(TextView) row.findViewById(R.id.tvMatchCount);
        tvWinPercent=(TextView) row.findViewById(R.id.tvWinPercent);
        ibtMoreInfo=(ImageButton) row.findViewById(R.id.ibtMoreInfo);
        ibtKickPlayer=(ImageButton) row.findViewById(R.id.ibtKickPlayer);

        ibtKickPlayer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                control.kickPlayerEvent(postion);
            }
        });

        ibtMoreInfo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                control.morePlayerInfoEvent(postion);
            }
        });
    }

    public void scaleView()
    {
        row.requestLayout();
        row.getLayoutParams().width= InsideRoomUIDefine.PLAYERITEM_WIDTH();
        row.getLayoutParams().height= InsideRoomUIDefine.PLAYERITEM_HEIGHT();

        ivPlayerAvatar.requestLayout();
        ivPlayerAvatar.getLayoutParams().width= InsideRoomUIDefine.PLAYERAVATARIV_WIDTH();
        ivPlayerAvatar.getLayoutParams().height= InsideRoomUIDefine.PLAYERAVATAR_HEIGHT();

        ibtMoreInfo.requestLayout();
        ibtMoreInfo.getLayoutParams().width= InsideRoomUIDefine.MOREINFOIBT_WIDTH();
        ibtMoreInfo.getLayoutParams().height= InsideRoomUIDefine.MOREINFOIBT_HEIGHT();

        tvPlayerName.setTextSize(UIDefine.MEDIUMTEXT_SIZE());
        tvMatchCount.setTextSize(UIDefine.SMALLTEXT_SIZE());
        tvWinPercent.setTextSize(UIDefine.SMALLTEXT_SIZE());
    }

    public void setContentView(int position)
    {
        PlayerInfo playerInfo=playerArr.get(position);

        Bitmap avatarBitmap=playerInfo.getUserProfile().getAvatarBitmap();
        String fullName=playerInfo.getUserProfile().getFullName();
        Integer matchCount=playerInfo.getGameUserInfo().getTotalMatchCount();
        Integer winPercent=playerInfo.getGameUserInfo().getTotalWinPercent();

        ivPlayerAvatar.setImageBitmap(avatarBitmap);
        tvPlayerName.setText(fullName);
        tvMatchCount.setText(matchCount.toString()+" Trận");
        tvWinPercent.setText("Win: "+winPercent.toString()+"%");
        ibtKickPlayer.requestLayout();

        if(!userIsRoomMaster())
        {
            ibtKickPlayer.getLayoutParams().width = 0;
            ibtKickPlayer.getLayoutParams().height = 0;
        }
        else
        {
            if(!playerIsMe(playerInfo))
            {
                ibtKickPlayer.getLayoutParams().width = InsideRoomUIDefine.KICKPLAYERIBT_WIDTH();
                ibtKickPlayer.getLayoutParams().height = InsideRoomUIDefine.KICKPLAYERIBT_HEIGHT();
            }
            else
            {
                ibtKickPlayer.getLayoutParams().width = 0;
                ibtKickPlayer.getLayoutParams().height = 0;
            }
        }
    }

    public boolean userIsRoomMaster()
    {
        PlayerInfo firstPlayerInfo=playerArr.get(0);
        if(firstPlayerInfo.isOwner())
            return playerIsMe(firstPlayerInfo);
        else
            return false;
    }

    public boolean playerIsMe(PlayerInfo playerInfo)
    {
        String myUserId= TITUserVariable.getUserInfo().getUserProfile().getUserId();
        String playerId=playerInfo.getUserProfile().getUserId();
        return myUserId.equals(playerId);
    }
}
