package aisoai.screens.insidetabscreen.chatroomscreen;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import aisoai.TITApplication;
import aisoai.config.UIDefine;
import aisoai.R;
import aisoai.screens.titentities.activity.TITSpecActivity;
import aisoai.screens.titentities.control.TITSpecControl;

public class ChatRoomActivity extends TITSpecActivity
{
    private ListView lvMessage;
    private EditText etTypingMessage;
    private ImageButton ibtEmoticon;
    private ImageButton ibtSend;

    @Override
    protected void linkToLayout()
    {
        setContentView(R.layout.chat_room);
        lvMessage=(ListView) findViewById(R.id.lvMessage);
        etTypingMessage=(EditText) findViewById(R.id.etTypingMessage);
        etTypingMessage.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(s.length()>0)
                {
                    int len = s.length();
                    char key = s.charAt(len - 1);
                    if (key == '\n')
                    {
                        String message = s.toString().substring(0, len - 1);
                        getControl().sendMessageEvent(message);
                        etTypingMessage.setText("");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s)
            {
            }
        });

        ibtEmoticon=(ImageButton) findViewById(R.id.ibtEmoticon);
        ibtSend=(ImageButton) findViewById(R.id.ibtSend);
        ibtSend.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getControl().sendMessageEvent(etTypingMessage.getText().toString());
                etTypingMessage.setText("");
            }
        });
    }

    @Override
    protected void scaleView()
    {
        lvMessage.requestLayout();
        lvMessage.getLayoutParams().width= ChatRoomUIDefine.MESSAGELV_WIDTH();
        lvMessage.getLayoutParams().height= ChatRoomUIDefine.MESSAGELV_HEIGHT();

        etTypingMessage.requestLayout();
        etTypingMessage.getLayoutParams().width= ChatRoomUIDefine.TYPINGMESSAGEET_WIDTH();
        etTypingMessage.getLayoutParams().height= ChatRoomUIDefine.TYPINGMESSAGEET_HEIGHT();

        ibtEmoticon.requestLayout();
        ibtEmoticon.getLayoutParams().width= ChatRoomUIDefine.EMOTICONIBT_WIDTH();
        ibtEmoticon.getLayoutParams().height= ChatRoomUIDefine.EMOTICONIBT_HEIGHT();

        ibtSend.requestLayout();
        ibtSend.getLayoutParams().width= ChatRoomUIDefine.SENDIBT_WIDTH();
        ibtSend.getLayoutParams().height= ChatRoomUIDefine.SENDIBT_HEIGHT();

        etTypingMessage.setTextSize(UIDefine.MEDIUMTEXT_SIZE());
    }

    public ListView getLvMessage()
    {
        return lvMessage;
    }

    public EditText getEtTypingMessage()
    {
        return etTypingMessage;
    }

    @Override
    protected TITSpecControl linkControl()
    {
        return TITApplication.getScreenControlManager().getChatRoomControl();
    }

    @Override
    public ChatRoomControl getControl()
    {
        return (ChatRoomControl) control;
    }

}
