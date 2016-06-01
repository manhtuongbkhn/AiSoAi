package aisoai.screens.hometabscreen.roomlistscreen;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import aisoai.TITApplication;
import aisoai.config.UIDefine;
import aisoai.screens.titentities.dialog.choicegamedialog.ChoiceGameDialog;
import aisoai.screens.hometabscreen.roomlistscreen.createroomdialog.CreateRoomDialog;
import aisoai.R;
import aisoai.screens.titentities.activity.TITSpecActivity;
import aisoai.screens.titentities.control.TITSpecControl;

public class RoomListActivity extends TITSpecActivity
{
    private ImageView ivGameIcon;
    private ImageButton ibtCreateRoom;
    private EditText etSearchNameRoom;
    private ListView lvRoom;
    private PasswordDialog dlPassword;
    private CreateRoomDialog dlCreateRoom;
    private RLChoiceGameDialog dlChoiceGame;

    @Override
    protected void linkToLayout()
    {
        setContentView(R.layout.room_list);
        ivGameIcon=(ImageView) findViewById(R.id.ivGameIcon);
        etSearchNameRoom=(EditText) findViewById(R.id.etSearchRoom);
        ibtCreateRoom=(ImageButton) findViewById(R.id.ibtCreateRoom);
        lvRoom=(ListView) findViewById(R.id.lvRoom);
        etSearchNameRoom.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                getControl().searchRoomEvent();
            }
        });

        lvRoom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getControl().joinRoomEvent(position);
            }
        });

        ivGameIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getControl().gameIconEvent();
            }
        });

        ibtCreateRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getControl().creatRoomEvent();
            }
        });

        dlPassword=new PasswordDialog(this,null);
        dlCreateRoom=new CreateRoomDialog(this,null);
        dlChoiceGame=new RLChoiceGameDialog(this,null);

    }

    @Override
    public void scaleView()
    {
        ivGameIcon.requestLayout();
        ivGameIcon.getLayoutParams().width=RoomListUIDefine.GAMEICONIBT_WIDTH();
        ivGameIcon.getLayoutParams().height=RoomListUIDefine.GAMEICONIBT_HEIGHT();

        ibtCreateRoom.requestLayout();
        ibtCreateRoom.getLayoutParams().width= RoomListUIDefine.CREATEROOMIBT_WIDTH();
        ibtCreateRoom.getLayoutParams().height= RoomListUIDefine.CREATEROOMIBT_HEIGHT();

        etSearchNameRoom.requestLayout();
        etSearchNameRoom.getLayoutParams().width= RoomListUIDefine.ROOMSEARCHET_WIDTH();
        etSearchNameRoom.getLayoutParams().height= RoomListUIDefine.ROOMSEARCHET_HEIGHT();

        etSearchNameRoom.setTextSize(UIDefine.MEDIUMTEXT_SIZE());
    }

    public ListView getLvRoom()
    {
        return lvRoom;
    }

    public PasswordDialog getDlPassword()
    {
        return dlPassword;
    }

    public CreateRoomDialog getDlCreateRoom()
    {
        return dlCreateRoom;
    }

    public EditText getEtSearchNameRoom()
    {
        return etSearchNameRoom;
    }

    public RLChoiceGameDialog getDlChoiceGame()
    {
        return dlChoiceGame;
    }

    public void setDlChoiceGame(RLChoiceGameDialog dlChoiceGame)
    {
        this.dlChoiceGame = dlChoiceGame;
    }

    public ImageView getIvGameIcon()
    {
        return ivGameIcon;
    }

    @Override
    protected TITSpecControl linkControl()
    {
        return TITApplication.getScreenControlManager().getListRoomControl();
    }

    @Override
    public RoomListControl getControl()
    {
        return (RoomListControl) control;
    }

}
