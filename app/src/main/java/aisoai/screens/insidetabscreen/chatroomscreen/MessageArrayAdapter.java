package aisoai.screens.insidetabscreen.chatroomscreen;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

import aisoai.config.UIDefine;
import aisoai.screens.titentities.activity.TITNormalActivity;
import aisoai.screens.titentities.model.TITMessageInfo;
import aisoai.titapplib.TITUserVariable;
import aisoai.R;

public class MessageArrayAdapter extends ArrayAdapter<TITMessageInfo>
{
    private TITNormalActivity titActivity;
    private ArrayList<TITMessageInfo> messageArr;

    private View row;
    private LinearLayout llPlayerAvatar;
    private ImageView ivPlayerAvatar;

    private TextView tvPlayerName;
    private TextView tvTime;
    private TextView tvMessage;

    public MessageArrayAdapter(TITNormalActivity titActivity,ArrayList<TITMessageInfo> messageArr)
    {
        super(titActivity,R.layout.message_item_other,messageArr);
        this.titActivity=titActivity;
        this.messageArr=messageArr;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        TITMessageInfo messageInfo=messageArr.get(position);
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

    public void scaleView(TITMessageInfo messageInfo)
    {
        row.requestLayout();
        row.getLayoutParams().width= ChatRoomUIDefine.ITEM_WIDTH();

        tvTime.requestLayout();
        tvTime.getLayoutParams().width= ChatRoomUIDefine.TIMETV_WIDTH();
        tvTime.getLayoutParams().height= ChatRoomUIDefine.TIMETV_HEIGHT();

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
            tvPlayerName.getLayoutParams().width=ChatRoomUIDefine.MAXPLAYERNAME_WIDTH();

        tvPlayerName.getLayoutParams().height=ChatRoomUIDefine.PLAYERNAMETV_HEIGHT();

        int lineCount;
        if(messagePxWidth<= ChatRoomUIDefine.MAXMESSAGELL_WIDTH())
        {
            tvMessage.getLayoutParams().width=messagePxWidth.intValue();
            lineCount=1;
        }
        else
        {
            tvMessage.getLayoutParams().width= ChatRoomUIDefine.MAXMESSAGELL_WIDTH();
            Float fLineCount=messagePxWidth/ ChatRoomUIDefine.MAXMESSAGELL_WIDTH();
            lineCount=fLineCount.intValue()+1;
        }

        tvMessage.getLayoutParams().height=ChatRoomUIDefine.MESSAGETV_HEIGHT(lineCount);

        llPlayerAvatar.requestLayout();
        llPlayerAvatar.getLayoutParams().width= ChatRoomUIDefine.PLAYERAVATARLL_WIDTH();

        llPlayerAvatar.getLayoutParams().height=tvPlayerName.getLayoutParams().height+
                tvMessage.getLayoutParams().height;

        ivPlayerAvatar.requestLayout();
        ivPlayerAvatar.getLayoutParams().width= ChatRoomUIDefine.PLAYERAVATARIV_WIDTH();
        ivPlayerAvatar.getLayoutParams().height= ChatRoomUIDefine.PLAYERAVATARIV_HEIGHT();

        tvPlayerName.setTextSize(UIDefine.SMALLTEXT_SIZE());
        tvMessage.setTextSize(UIDefine.SMALLTEXT_SIZE());
        tvTime.setTextSize(UIDefine.SMALLTEXT_SIZE());
    }

    public void setContentView(TITMessageInfo messageInfo)
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
