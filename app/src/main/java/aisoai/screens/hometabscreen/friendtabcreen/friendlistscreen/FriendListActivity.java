package aisoai.screens.hometabscreen.friendtabcreen.friendlistscreen;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import aisoai.R;
import aisoai.TITApplication;
import aisoai.screens.titentities.activity.TITSpecActivity;

public class FriendListActivity extends TITSpecActivity
{
    private ListView lvFriend;
    private MoreFriendInfoDialog dlMoreFriendInfo;

    @Override
    protected void linkToLayout()
    {
        setContentView(R.layout.friend_list);
        lvFriend=(ListView) findViewById(R.id.lvFriend);

        lvFriend.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                getControl().friendItemClickEvent(position);
            }
        });
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
    protected FriendListControl linkControl()
    {
        return TITApplication.getScreenControlManager().getFriendListControl();
    }

    @Override
    public FriendListControl getControl()
    {
        return (FriendListControl) control;
    }

    public MoreFriendInfoDialog getDlMoreFriendInfo()
    {
        return dlMoreFriendInfo;
    }

    public void setDlMoreFriendInfo(MoreFriendInfoDialog dlMoreFriendInfo)
    {
        this.dlMoreFriendInfo = dlMoreFriendInfo;
    }
}
