package aisoai.screens.hometabscreen.friendtabcreen.chatfriendscreen;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import aisoai.R;
import aisoai.TITApplication;
import aisoai.config.UIDefine;
import aisoai.screens.titentities.activity.TITSpecActivity;
import aisoai.screens.titentities.control.TITSpecControl;

public class ChatFriendActivity extends TITSpecActivity
{
    private ListView lvMessage;
    private EditText etTypingMessage;
    private ImageButton ibtEmoticon;
    private ImageButton ibtSend;

    @Override
    protected void linkToLayout()
    {
        setContentView(R.layout.chat_friend);
        lvMessage=(ListView) findViewById(R.id.lvMessage);
        etTypingMessage=(EditText) findViewById(R.id.etTypingMessage);
        ibtEmoticon=(ImageButton) findViewById(R.id.ibtEmoticon);
        ibtSend=(ImageButton) findViewById(R.id.ibtSend);

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
        lvMessage.getLayoutParams().width= ChatFriendUIDefine.MESSAGELV_WIDTH();
        lvMessage.getLayoutParams().height= ChatFriendUIDefine.MESSAGELV_HEIGHT();

        etTypingMessage.requestLayout();
        etTypingMessage.getLayoutParams().width= ChatFriendUIDefine.TYPINGMESSAGEET_WIDTH();
        etTypingMessage.getLayoutParams().height= ChatFriendUIDefine.TYPINGMESSAGEET_HEIGHT();

        ibtEmoticon.requestLayout();
        ibtEmoticon.getLayoutParams().width= ChatFriendUIDefine.EMOTICONIBT_WIDTH();
        ibtEmoticon.getLayoutParams().height= ChatFriendUIDefine.EMOTICONIBT_HEIGHT();

        ibtSend.requestLayout();
        ibtSend.getLayoutParams().width= ChatFriendUIDefine.SENDIBT_WIDTH();
        ibtSend.getLayoutParams().height= ChatFriendUIDefine.SENDIBT_HEIGHT();

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
        return TITApplication.getScreenControlManager().getChatFriendControl();
    }

    @Override
    public ChatFriendControl getControl()
    {
        return (ChatFriendControl) control;
    }
}
