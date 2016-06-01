package aisoai.screens.insidetabscreen.insideroomscreen.invitation;

import android.content.Context;
import android.widget.ListView;

import aisoai.R;
import aisoai.screens.insidetabscreen.insideroomscreen.InsideRoomControl;
import aisoai.screens.insidetabscreen.insideroomscreen.InsideRoomUIDefine;
import aisoai.screens.titentities.dialog.TITIDialog;
import aisoai.screens.titentities.control.TITNormalControl;

public class FriendListDialog extends TITIDialog
{
    private ListView lvFriend;

    public FriendListDialog(Context context, TITNormalControl control)
    {
        super(context, control);
    }

    @Override
    protected int getLayout()
    {
        return R.layout.friend_list_dialog;
    }

    @Override
    protected void linkToLayout()
    {
        lvFriend=(ListView) findViewById(R.id.lvFriend);
    }

    @Override
    protected void scaleView()
    {
    }

    public ListView getLvFriend()
    {
        return lvFriend;
    }

    @Override
    protected void closeEvent()
    {
        dismiss();
        getControl().closeFriendListDialogEvent();
    }

    @Override
    public int getIcon()
    {
        return R.drawable.invite_friend;
    }

    @Override
    public String getTitle()
    {
        return "Mời Bạn Bè";
    }

    @Override
    protected int getWidth()
    {
        return InsideRoomUIDefine.FRIENDLISTDL_WIDTH();
    }

    @Override
    protected int getHeight()
    {
        return InsideRoomUIDefine.FRIENDLISTDL_HEIGHT();
    }

    @Override
    public InsideRoomControl getControl()
    {
        return (InsideRoomControl) control;
    }
}
