package aisoai.screens.insidetabscreen.insideroomscreen.invitation;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import aisoai.R;
import aisoai.config.UIDefine;
import aisoai.screens.insidetabscreen.insideroomscreen.InsideRoomControl;
import aisoai.screens.insidetabscreen.insideroomscreen.InsideRoomUIDefine;
import aisoai.screens.titentities.activity.TITNormalActivity;

public class FriendArrayAdapter extends ArrayAdapter
{
    private TITNormalActivity titActivity;
    private ArrayList<InvitationFriendInfo> friendArr;
    private InsideRoomControl control;

    private View row;
    private ImageView ivFriendAvatar;
    private TextView tvFriendName;

    private TextView tvMatchCount;

    private ImageView ivInvite;
    private ImageView ivMoreInfo;

    public FriendArrayAdapter(TITNormalActivity titActivity, InsideRoomControl control,
                              ArrayList<InvitationFriendInfo> friendArr)
    {
        super(titActivity, R.layout.friend_dialog_item,friendArr);
        this.titActivity=titActivity;
        this.friendArr=friendArr;
        this.control=control;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent)
    {
        LayoutInflater inflater=titActivity.getLayoutInflater();
        row=inflater.inflate(R.layout.friend_dialog_item,parent,false);
        linkToLayout(position);
        scaleView();
        setContentView(position);
        return row;
    }

    public void linkToLayout(final int postion)
    {
        ivFriendAvatar=(ImageView) row.findViewById(R.id.ivFriendAvatar);
        tvFriendName=(TextView) row.findViewById(R.id.tvFriendName);
        tvMatchCount=(TextView) row.findViewById(R.id.tvMatchCount);
        ivInvite =(ImageView) row.findViewById(R.id.ivInvite);
        ivMoreInfo =(ImageView) row.findViewById(R.id.ivMoreInfo);

        ivInvite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.inviteFriendEvent(postion);
            }
        });

        ivMoreInfo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        tvFriendName.setTextSize(UIDefine.MEDIUMTEXT_SIZE());
        tvMatchCount.setTextSize(UIDefine.SMALLTEXT_SIZE());
        tvFriendName.setTextSize(UIDefine.SMALLTEXT_SIZE());
    }

    public void scaleView()
    {
        row.requestLayout();
        row.getLayoutParams().width= InsideRoomUIDefine.FRIENDITEM_WIDTH();
        row.getLayoutParams().height=InsideRoomUIDefine.FRIENDITEM_HEIGHT();

        ivFriendAvatar.requestLayout();
        ivFriendAvatar.getLayoutParams().width=InsideRoomUIDefine.FRIENDAVATARIV_WIDTH();
        ivFriendAvatar.getLayoutParams().height=InsideRoomUIDefine.FRIENDAVATAR_HEIGHT();

        ivInvite.requestLayout();
        ivInvite.getLayoutParams().width=InsideRoomUIDefine.INVITEIBT_WIDTH();
        ivInvite.getLayoutParams().height=InsideRoomUIDefine.INVITEIBT_HEIGHT();

        ivMoreInfo.requestLayout();
        ivMoreInfo.getLayoutParams().width=InsideRoomUIDefine.MOREINFOIBT_WIDTH();
        ivMoreInfo.getLayoutParams().height=InsideRoomUIDefine.MOREINFOIBT_HEIGHT();
    }

    public void setContentView(int position)
    {
        InvitationFriendInfo friendInfo=friendArr.get(position);
        Bitmap avatarBitmap=friendInfo.getUserProfile().getAvatarBitmap();
        String fullName=friendInfo.getUserProfile().getFullName();
        Integer matchCount=friendInfo.getGameUserInfo().getTotalMatchCount();
        Integer winPercent=friendInfo.getGameUserInfo().getTotalWinPercent();
        Integer status=friendInfo.getStatus();

        ivFriendAvatar.setImageBitmap(avatarBitmap);
        tvFriendName.setText(fullName);
        tvMatchCount.setText(matchCount.toString()+" trận");

    }
}
