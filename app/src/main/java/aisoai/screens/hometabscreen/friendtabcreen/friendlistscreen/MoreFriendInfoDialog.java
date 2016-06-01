package aisoai.screens.hometabscreen.friendtabcreen.friendlistscreen;

import android.content.Context;

import aisoai.R;
import aisoai.config.ClientConfig;
import aisoai.screens.titentities.control.TITControl;
import aisoai.screens.titentities.dialog.MoreUserInfoDialog;

public class MoreFriendInfoDialog extends MoreUserInfoDialog
{

    public MoreFriendInfoDialog(Context context, TITControl control)
    {
        super(context, control);
    }

    @Override
    protected String getTitle()
    {
        return "Chi Tiết Bạn Bè";
    }

    @Override
    protected int getLayout()
    {
        return R.layout.more_friendinfo_dialog;
    }

    @Override
    protected int getHeight()
    {
        Float f = 320f *ClientConfig.SCREEN_HEIGHT_PX/480f;
        return f.intValue();
    }


    @Override
    public FriendListControl getControl()
    {
        return (FriendListControl) control;
    }
}
