package aisoai.screens.hometabscreen.roomlistscreen.createroomdialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import aisoai.R;
import aisoai.config.UIDefine;
import aisoai.screens.titentities.activity.TITNormalActivity;

public class RoomAvatarArrayAdapter extends ArrayAdapter<String>
{
    private TITNormalActivity titActivity;
    private String[] strArr;

    private TextView tvRoomAvatar;
    private ImageView ivRoomAvatar;

    public RoomAvatarArrayAdapter(TITNormalActivity titActivity,String[]strArr)
    {
        super(titActivity, R.layout.roomavatar_spiner_item,strArr);
        this.titActivity=titActivity;
        this.strArr=strArr;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent)
    {
        LayoutInflater inflater=titActivity.getLayoutInflater();
        View row=inflater.inflate(R.layout.roomavatar_spiner_item,parent,false);
        tvRoomAvatar=(TextView) row.findViewById(R.id.tvSPRoomAvatar);
        ivRoomAvatar=(ImageView) row.findViewById(R.id.ivSPRoomAvatar);

        row.requestLayout();
        row.getLayoutParams().width= CreateRoomUIDefine.ROOMAVATARITEM_WIDTH();
        row.getLayoutParams().height= CreateRoomUIDefine.ROOMAVATARITEM_HEIGHT();

        ivRoomAvatar.requestLayout();
        ivRoomAvatar.getLayoutParams().width= CreateRoomUIDefine.ROOMAVATARIV_WIDTH();
        ivRoomAvatar.getLayoutParams().height= CreateRoomUIDefine.ROOMAVATARIV_HEIGHT();
        tvRoomAvatar.setTextSize(UIDefine.MEDIUMTEXT_SIZE());

        tvRoomAvatar.setText(strArr[position]);
        switch (position)
        {
            case 0:
                ivRoomAvatar.setImageResource(R.drawable.chicken);
                break;
            case 1:
                ivRoomAvatar.setImageResource(R.drawable.fight);
                break;
            case 2:
                ivRoomAvatar.setImageResource(R.drawable.friendly);
                break;
        }
        return row;
    }

    @Override
    public View getDropDownView(int position, View convertView,ViewGroup parent)
    {
        LayoutInflater inflater=titActivity.getLayoutInflater();
        View row=inflater.inflate(R.layout.roomavatar_spiner_item,parent,false);
        tvRoomAvatar=(TextView) row.findViewById(R.id.tvSPRoomAvatar);
        ivRoomAvatar=(ImageView) row.findViewById(R.id.ivSPRoomAvatar);

        row.requestLayout();
        row.getLayoutParams().width= CreateRoomUIDefine.ROOMAVATARITEM_WIDTH();
        row.getLayoutParams().height= CreateRoomUIDefine.ROOMAVATARITEM_HEIGHT();

        ivRoomAvatar.requestLayout();
        ivRoomAvatar.getLayoutParams().width= CreateRoomUIDefine.ROOMAVATARIV_WIDTH();
        ivRoomAvatar.getLayoutParams().height= CreateRoomUIDefine.ROOMAVATARIV_HEIGHT();
        tvRoomAvatar.setTextSize(UIDefine.MEDIUMTEXT_SIZE());

        tvRoomAvatar.setText(strArr[position]);
        switch (position)
        {
            case 0:
                ivRoomAvatar.setImageResource(R.drawable.chicken);
                break;
            case 1:
                ivRoomAvatar.setImageResource(R.drawable.fight);
                break;
            case 2:
                ivRoomAvatar.setImageResource(R.drawable.friendly);
                break;
        }
        return row;
    }
}
