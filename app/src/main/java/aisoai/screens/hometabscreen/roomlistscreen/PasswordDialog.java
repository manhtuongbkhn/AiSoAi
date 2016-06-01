package aisoai.screens.hometabscreen.roomlistscreen;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import aisoai.R;
import aisoai.config.UIDefine;
import aisoai.screens.titentities.dialog.TITIDialog;
import aisoai.screens.titentities.control.TITNormalControl;

public class PasswordDialog extends TITIDialog
{
    private int postion;
    private EditText etPassword;
    private ImageButton ibtConfirm;

    public PasswordDialog(Context context,TITNormalControl control)
    {
        super(context,control);
    }

    public void setPostion(int postion)
    {
        this.postion = postion;
    }

    @Override
    protected int getLayout()
    {
        return R.layout.password_dialog;
    }

    @Override
    protected void linkToLayout()
    {
        etPassword=(EditText) findViewById(R.id.etPassword);
        ibtConfirm=(ImageButton) findViewById(R.id.ibtConfirm);

        ibtConfirm.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String password=etPassword.getText().toString();
                getControl().joinLockRoomEvent(postion,password);
            }
        });
    }

    @Override
    protected void scaleView()
    {
        etPassword.requestLayout();
        etPassword.getLayoutParams().width=RoomListUIDefine.PASSWORDET_WIDTH();
        etPassword.getLayoutParams().height=RoomListUIDefine.PASSWORDET_HEIGHT();

        ibtConfirm.requestLayout();
        ibtConfirm.getLayoutParams().width=RoomListUIDefine.CONFIRMIBT_WIDTH();
        ibtConfirm.getLayoutParams().height=RoomListUIDefine.CONFIRMIBT_HEIGHT();

        etPassword.setTextSize(UIDefine.MEDIUMTEXT_SIZE());

    }

    @Override
    protected void closeEvent()
    {
        dismiss();
    }

    @Override
    public int getIcon()
    {
        return R.drawable.key_icon;
    }

    @Override
    public String getTitle()
    {
        return "Nhập Password!";
    }

    @Override
    protected int getWidth()
    {
        return RoomListUIDefine.PASSWORDDL_WIDTH();
    }

    @Override
    protected int getHeight()
    {
        return RoomListUIDefine.PASSWORDDL_HEIGHT();
    }

    @Override
    public RoomListControl getControl()
    {
        return (RoomListControl) control;
    }
}
