package aisoai.screens.insidetabscreen.insideroomscreen;

import android.content.Context;
import android.widget.ImageButton;
import aisoai.R;
import aisoai.config.ClientConfig;
import aisoai.screens.titentities.control.TITControl;
import aisoai.screens.titentities.dialog.MoreUserInfoDialog;

public class MorePlayerInfoDialog extends MoreUserInfoDialog
{
    private ImageButton ibtAddFriend;

    public MorePlayerInfoDialog(Context context, TITControl control)
    {
        super(context, control);
    }

    @Override
    protected int getLayout()
    {
        return R.layout.more_playerinfo_dialog;
    }

    @Override
    protected void linkToLayout()
    {
        super.linkToLayout();
        ibtAddFriend=(ImageButton) findViewById(R.id.ibtAddFriend);
    }

    @Override
    protected void scaleView()
    {
        super.scaleView();

        ibtAddFriend.requestLayout();
        ibtAddFriend.getLayoutParams().width=MorePlayerInfoDialogUIDefine.ADDFRIENDIV_WIDTH();
        ibtAddFriend.getLayoutParams().height=MorePlayerInfoDialogUIDefine.ROOMAVATARIV_HEIGHT();
    }

    @Override
    protected int getHeight()
    {
        Float f = 380f *ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }


    @Override
    public InsideRoomControl getControl()
    {
        return (InsideRoomControl) control;
    }

    @Override
    protected String getTitle()
    {
        return "Chi Tiết Người Chơi";
    }

}