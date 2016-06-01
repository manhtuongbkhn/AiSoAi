package aisoai.screens.hometabscreen.friendtabcreen.friendlistscreen;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

import aisoai.R;
import aisoai.config.UIDefine;
import aisoai.screens.titentities.activity.TITNormalActivity;

public class FriendArrayAdapter extends ArrayAdapter
{
    private TITNormalActivity titActivity;
    private ArrayList<FriendInfo> friendArr;
    private FriendListControl control;

    private View row;
    private ImageView ivFriendAvatar;
    private TextView tvFriendName;

    private ImageView ivMessage;
    private TextView tvMatchCount;
    private TextView tvWinPercent;

    private ImageView ivMoreInfo;
    private ImageView ivStatus;

    public FriendArrayAdapter(TITNormalActivity titActivity,FriendListControl control,
                                  ArrayList<FriendInfo> friendArr)
    {
        super(titActivity, R.layout.friend_item,friendArr);
        this.titActivity=titActivity;
        this.friendArr=friendArr;
        this.control=control;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent)
    {
        LayoutInflater inflater=titActivity.getLayoutInflater();
        row=inflater.inflate(R.layout.friend_item,parent,false);
        linkToLayout(position);
        scaleView();
        setContentView(position);
        return row;
    }

    public void linkToLayout(final int postion)
    {
        ivFriendAvatar=(ImageView) row.findViewById(R.id.ivFriendAvatar);
        tvFriendName=(TextView) row.findViewById(R.id.tvFriendName);
        ivMessage=(ImageView) row.findViewById(R.id.ivMessage);
        tvMatchCount=(TextView) row.findViewById(R.id.tvMatchCount);
        tvWinPercent=(TextView) row.findViewById(R.id.tvWinPercent);
        ivMoreInfo=(ImageView) row.findViewById(R.id.ivMoreInfo);

        ivMoreInfo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                control.moreInfoEvent(postion);
            }
        });
        ivStatus=(ImageView) row.findViewById(R.id.ivStatus);
    }

    public void scaleView()
    {
        row.requestLayout();
        row.getLayoutParams().width= FriendListUIDefine.ITEM_WIDTH();
        row.getLayoutParams().height= FriendListUIDefine.ITEM_HEIGHT();

        ivFriendAvatar.requestLayout();
        ivFriendAvatar.getLayoutParams().width= FriendListUIDefine.FRIENDAVATARIV_WIDTH();
        ivFriendAvatar.getLayoutParams().height= FriendListUIDefine.FRIENDAVATAR_HEIGHT();

        ivMessage.requestLayout();
        ivMessage.getLayoutParams().width=FriendListUIDefine.MESSAGEIV_WIDTH();
        ivMessage.getLayoutParams().height=FriendListUIDefine.MESSAGEIV_HEIGHT();

        ivMoreInfo.requestLayout();
        ivMoreInfo.getLayoutParams().width= FriendListUIDefine.MOREINFOIBT_WIDTH();
        ivMoreInfo.getLayoutParams().height= FriendListUIDefine.MOREINFOIBT_HEIGHT();

        ivStatus.requestLayout();
        ivStatus.getLayoutParams().width= FriendListUIDefine.STATUSIV_WIDTH();
        ivStatus.getLayoutParams().height= FriendListUIDefine.STATUSIV_HEIGHT();

        tvFriendName.setTextSize(UIDefine.MEDIUMTEXT_SIZE());
        tvMatchCount.setTextSize(UIDefine.SMALLTEXT_SIZE());
    }

    public void setContentView(int position)
    {
        FriendInfo friendInfo=friendArr.get(position);
        Bitmap avatarBitmap=friendInfo.getUserProfile().getAvatarBitmap();
        String fullName=friendInfo.getUserProfile().getFullName();
        Integer matchCount=friendInfo.getGameUserInfo().getTotalMatchCount();
        Integer winPercent=friendInfo.getGameUserInfo().getTotalWinPercent();
        Integer status=friendInfo.getStatus();

        ivFriendAvatar.setImageBitmap(avatarBitmap);
        tvFriendName.setText(fullName);
        if(friendInfo.isMessage())
            ivMessage.setImageResource(R.drawable.message);

        tvMatchCount.setText(friendInfo.getGameUserInfo().getTotalMatchCount()+" trận");
        tvWinPercent.setText("Win: "+friendInfo.getGameUserInfo().getTotalWinPercent()+"%");
        switch (status)
        {
            case 0:
                ivStatus.setImageResource(R.drawable.offline);
                break;
            case 1:
                ivStatus.setImageResource(R.drawable.online);
                break;
            case 2:
                ivStatus.setImageResource(R.drawable.busy);
                break;
            case 3:
                ivStatus.setImageResource(R.drawable.invisible);
                break;
        }
    }
}
