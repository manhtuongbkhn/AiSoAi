package aisoai.screens.hometabscreen.friendtabcreen.chatfriendscreen;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import aisoai.R;
import aisoai.config.UIDefine;
import aisoai.screens.insidetabscreen.chatroomscreen.ChatRoomUIDefine;
import aisoai.screens.titentities.activity.TITNormalActivity;
import aisoai.titapplib.TITUserVariable;

public class MessageArrayAdapter extends ArrayAdapter<FriendMessageInfo>
{
    private TITNormalActivity titActivity;
    private ArrayList<FriendMessageInfo> messageArr;

    private View row;
    private LinearLayout llPlayerAvatar;
    private ImageView ivPlayerAvatar;

    private TextView tvPlayerName;
    private TextView tvTime;
    private TextView tvMessage;

    public MessageArrayAdapter(TITNormalActivity titActivity,ArrayList<FriendMessageInfo> messageArr)
    {
        super(titActivity,R.layout.message_item_other,messageArr);
        this.titActivity=titActivity;
        this.messageArr=messageArr;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        FriendMessageInfo messageInfo=messageArr.get(position);
        String sendUserFullName=messageInfo.getFullName();
        String userId=messageInfo.getUserId();
        LayoutInflater inflater;
        if(userId.equals(TITUserVariable.getUserInfo().getUserProfile().getUserId()))
        {
            inflater=titActivity.getLayoutInflater();
            row=inflater.inflate(R.layout.message_item_me,parent,false);
        }
        else
        {
            inflater=titActivity.getLayoutInflater();
            row=inflater.inflate(R.layout.message_item_other,parent,false);
        }

        linkToLayout();
        scaleView(messageInfo);
        setContentView(messageInfo);
        return row;
    }

    public void linkToLayout()
    {
        llPlayerAvatar=(LinearLayout) row.findViewById(R.id.llPlayerAvatar);
        ivPlayerAvatar=(ImageView) row.findViewById(R.id.ivPlayerAvatar);

        tvPlayerName=(TextView) row.findViewById(R.id.tvPlayerName);
        tvTime=(TextView) row.findViewById(R.id.tvTime);
        tvMessage=(TextView) row.findViewById(R.id.tvMessageContent);
    }

    public void scaleView(FriendMessageInfo messageInfo)
    {
        row.requestLayout();
        row.getLayoutParams().width= ChatFriendUIDefine.ITEM_WIDTH();

        tvTime.requestLayout();
        tvTime.getLayoutParams().width= ChatFriendUIDefine.TIMETV_WIDTH();
        tvTime.getLayoutParams().height= ChatFriendUIDefine.TIMETV_HEIGHT();

        tvPlayerName.requestLayout();
        tvMessage.requestLayout();

        String fullName=messageInfo.getFullName();
        String messageContent=messageInfo.getMessage();

        Float maxWidth;
        Float namePxWidth=tvPlayerName.getPaint().measureText(fullName);
        Float messagePxWidth=tvMessage.getPaint().measureText(messageContent);
        namePxWidth=namePxWidth*1.2f;
        messagePxWidth=messagePxWidth*1.2f;

        if(namePxWidth<= ChatRoomUIDefine.MAXPLAYERNAME_WIDTH())
            tvPlayerName.getLayoutParams().width=namePxWidth.intValue();
        else
            tvPlayerName.getLayoutParams().width=ChatFriendUIDefine.MAXPLAYERNAME_WIDTH();

        tvPlayerName.getLayoutParams().height=ChatFriendUIDefine.PLAYERNAMETV_HEIGHT();

        int lineCount;
        if(messagePxWidth<= ChatRoomUIDefine.MAXMESSAGELL_WIDTH())
        {
            tvMessage.getLayoutParams().width=messagePxWidth.intValue();
            lineCount=1;
        }
        else
        {
            tvMessage.getLayoutParams().width= ChatFriendUIDefine.MAXMESSAGELL_WIDTH();
            Float fLineCount=messagePxWidth/ ChatFriendUIDefine.MAXMESSAGELL_WIDTH();
            lineCount=fLineCount.intValue()+1;
        }

        tvMessage.getLayoutParams().height=ChatFriendUIDefine.MESSAGETV_HEIGHT(lineCount);

        llPlayerAvatar.requestLayout();
        llPlayerAvatar.getLayoutParams().width= ChatFriendUIDefine.PLAYERAVATARLL_WIDTH();

        llPlayerAvatar.getLayoutParams().height=tvPlayerName.getLayoutParams().height+
                tvMessage.getLayoutParams().height;

        ivPlayerAvatar.requestLayout();
        ivPlayerAvatar.getLayoutParams().width= ChatFriendUIDefine.PLAYERAVATARIV_WIDTH();
        ivPlayerAvatar.getLayoutParams().height= ChatFriendUIDefine.PLAYERAVATARIV_HEIGHT();

        tvPlayerName.setTextSize(UIDefine.SMALLTEXT_SIZE());
        tvMessage.setTextSize(UIDefine.SMALLTEXT_SIZE());
        tvTime.setTextSize(UIDefine.SMALLTEXT_SIZE());
    }

    public void setContentView(FriendMessageInfo messageInfo)
    {
        Bitmap sendPlayerAvatar=messageInfo.getAvatar();
        String fullName=messageInfo.getFullName();
        String messageContent=messageInfo.getMessage();
        String sendTime=messageInfo.getTime();

        ivPlayerAvatar.setImageBitmap(sendPlayerAvatar);
        tvPlayerName.setText(fullName);
        tvTime.setText(sendTime);
        tvMessage.setText(messageContent);
    }
}
