package aisoai.screens.hometabscreen.roomlistscreen.createroomdialog;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import aisoai.R;
import aisoai.config.UIDefine;
import aisoai.screens.hometabscreen.roomlistscreen.RoomListControl;
import aisoai.screens.titentities.control.TITControl;
import aisoai.screens.titentities.dialog.TITIDialog;

public class CreateRoomDialog extends TITIDialog
{
    private TextView tvInvite;
    private EditText etInvite;
    private TextView tvAvatar;
    private Spinner spAvatar;
    private TextView tvPass;
    private EditText etPass;
    private ImageButton ibtConfirm;
    private ImageButton ibtCancel;

    public CreateRoomDialog(Context context, TITControl control)
    {
        super(context, control);
    }

    @Override
    public int getIcon()
    {
        return R.drawable.add;
    }

    @Override
    protected String getTitle()
    {
        return "Tạo Room";
    }

    @Override
    protected int getLayout()
    {
        return R.layout.create_room_dialog;
    }

    @Override
    protected void linkToLayout()
    {
        tvInvite=(TextView) findViewById(R.id.tvInvite);
        etInvite=(EditText) findViewById(R.id.etInvite);

        tvAvatar=(TextView) findViewById(R.id.tvAvatar);
        spAvatar=(Spinner) findViewById(R.id.spAvatar);

        tvPass=(TextView) findViewById(R.id.tvPass);
        etPass=(EditText) findViewById(R.id.etPass);
        ibtConfirm=(ImageButton) findViewById(R.id.ibtConfirm);
        ibtCancel=(ImageButton) findViewById(R.id.ibtCancel);

        ibtConfirm.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getControl().confirmCreateRoomEvent();
            }
        });

        ibtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    protected void scaleView()
    {
        etInvite.requestLayout();
        etInvite.getLayoutParams().width= CreateRoomUIDefine.INVITEET_WIDTH();
        etInvite.getLayoutParams().height= CreateRoomUIDefine.INVITEET_HEIGHT();

        spAvatar.requestLayout();
        spAvatar.getLayoutParams().width= CreateRoomUIDefine.ROOMAVATARSP_WIDTH();
        spAvatar.getLayoutParams().height= CreateRoomUIDefine.ROOMAVATARSP_HEIGHT();

        etPass.requestLayout();
        etPass.getLayoutParams().width= CreateRoomUIDefine.PASSET_WIDTH();
        etPass.getLayoutParams().height= CreateRoomUIDefine.PASSET_HEIGHT();

        ibtConfirm.requestLayout();
        ibtConfirm.getLayoutParams().width= CreateRoomUIDefine.CONFIRMIBT_WIDTH();
        ibtConfirm.getLayoutParams().height= CreateRoomUIDefine.CONFIRMIBT_HEIGHT();

        ibtCancel.requestLayout();
        ibtCancel.getLayoutParams().width= CreateRoomUIDefine.CANCELIBT_WIDTH();
        ibtCancel.getLayoutParams().height= CreateRoomUIDefine.CANCELIBT_HEIGHT();

        tvInvite.setTextSize(UIDefine.MEDIUMTEXT_SIZE());
        tvAvatar.setTextSize(UIDefine.MEDIUMTEXT_SIZE());
        tvPass.setTextSize(UIDefine.MEDIUMTEXT_SIZE());

        etInvite.setTextSize(UIDefine.MEDIUMTEXT_SIZE());
        etPass.setTextSize(UIDefine.MEDIUMTEXT_SIZE());
    }

    @Override
    protected void closeEvent()
    {
        dismiss();
    }

    @Override
    protected int getWidth()
    {
        return CreateRoomUIDefine.CREATEROOMDL_WIDTH();
    }

    @Override
    protected int getHeight()
    {
        return CreateRoomUIDefine.CREATEROOMDL_HEIGHT();
    }

    @Override
    public RoomListControl getControl()
    {
        return (RoomListControl) control;
    }

    public EditText getEtInvite()
    {
        return etInvite;
    }

    public Spinner getSpAvatar()
    {
        return spAvatar;
    }

    public EditText getEtPass()
    {
        return etPass;
    }
}
