package aisoai.screens.hometabscreen.roomlistscreen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.JsonObject;

import java.util.ArrayList;

import aisoai.config.KJS;
import aisoai.config.UIDefine;
import aisoai.screens.titentities.activity.TITNormalActivity;
import aisoai.R;
import aisoai.screens.titentities.dialog.TITRoomAvatarRouter;

public class RoomArrayAdapter extends ArrayAdapter<JsonObject>
{
    private TITNormalActivity titActivity;
    private ArrayList<JsonObject> roomArr;

    private View row;
    private ImageView ivRoomAvatar;
    private ImageView ivRoomLock;
    private TextView tvRoomName;
    private TextView tvRoomInvite;
    private TextView tvCountPlayer;
    private ImageView ivPlayerIcon;
    private TextView tvRoomStatus;

    public RoomArrayAdapter(TITNormalActivity titActivity,ArrayList<JsonObject> roomArr)
    {
        super(titActivity,R.layout.room_item,roomArr);
        this.titActivity=titActivity;
        this.roomArr=roomArr;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent)
    {
        LayoutInflater inflater=titActivity.getLayoutInflater();
        row=inflater.inflate(R.layout.room_item,parent,false);
        linkToLayout();
        scaleView();
        setContentView(position);
        return row;
    }

    public void linkToLayout()
    {
        ivRoomAvatar=(ImageView)row.findViewById(R.id.ivRoomAvatar);
        ivRoomLock=(ImageView) row.findViewById(R.id.ivRoomLock);
        tvRoomName=(TextView) row.findViewById(R.id.tvRoomName);
        tvRoomInvite=(TextView) row.findViewById(R.id.tvRoomInvite);
        tvCountPlayer=(TextView) row.findViewById(R.id.tvCountPlayer);
        ivPlayerIcon=(ImageView) row.findViewById(R.id.ivPlayerIcon);
        tvRoomStatus=(TextView) row.findViewById(R.id.tvRoomStatus);
    }

    public void scaleView()
    {
        row.requestLayout();
        row.getLayoutParams().width= RoomListUIDefine.ITEM_WIDTH();
        row.getLayoutParams().height= RoomListUIDefine.ITEM_HEIGHT();

        ivRoomAvatar.requestLayout();
        ivRoomAvatar.getLayoutParams().width= RoomListUIDefine.ROOMAVATARIV_WIDTH();
        ivRoomAvatar.getLayoutParams().height= RoomListUIDefine.ROOMAVATARIV_HEIGHT();

        ivRoomLock.requestLayout();
        ivRoomLock.getLayoutParams().width= RoomListUIDefine.ROOMLOCKIV_WIDTH();
        ivRoomLock.getLayoutParams().height= RoomListUIDefine.ROOMLOCKIV_HEIGHT();

        ivPlayerIcon.requestLayout();
        ivPlayerIcon.getLayoutParams().width= RoomListUIDefine.PLAYERICONIV_WIDTH();
        ivPlayerIcon.getLayoutParams().height= RoomListUIDefine.PLAYERICONIV_HEIGHT();

        tvRoomName.setTextSize(UIDefine.MEDIUMTEXT_SIZE());
        tvCountPlayer.setTextSize(UIDefine.SMALLTEXT_SIZE());
        tvRoomInvite.setTextSize(UIDefine.SMALLTEXT_SIZE());
        tvRoomStatus.setTextSize(UIDefine.SMALLTEXT_SIZE());
    }

    public void setContentView(int position)
    {
        JsonObject room=roomArr.get(position);

        int roomAvatar=room.get(KJS.ROOM_AVATAR).getAsInt();
        String roomName=room.get(KJS.ROOM_NAME).getAsString();
        String roomInvite=room.get(KJS.ROOM_INVITE).getAsString();
        boolean roomLock=room.get(KJS.ROOM_LOCK).getAsBoolean();
        Integer playerCount=room.get(KJS.PLAYER_COUNT).getAsInt();
        Integer playerMax=room.get(KJS.PLAYER_MAX).getAsInt();
        String roomStatus=room.get(KJS.ROOM_STATUS).getAsString();
        ivRoomAvatar.setImageResource(TITRoomAvatarRouter.routerRoomAvatar(roomAvatar));
        tvRoomName.setText(roomName);
        tvRoomInvite.setText(roomInvite);
        if(roomLock)
            ivRoomLock.setImageResource(R.drawable.lock);
        else
            ivRoomLock.setImageResource(R.drawable.open);
        String playerRoom=playerCount.toString()+"/"+playerMax.toString();
        tvCountPlayer.setText(playerRoom);
        tvRoomStatus.setText(roomStatus);
    }
}
