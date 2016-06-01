package aisoai.screens.hometabscreen.friendtabcreen.chatfriendscreen;

import java.util.ArrayList;

import aisoai.config.ClientConfig;
import aisoai.screens.hometabscreen.friendtabcreen.friendlistscreen.FriendInfo;
import aisoai.screens.titentities.model.TITModel;

public class ChatFriendModel extends TITModel
{
    private FriendInfo friendInfo;

    public FriendInfo getFriendInfo()
    {
        return friendInfo;
    }

    public void setFriendInfo(FriendInfo friendInfo)
    {
        this.friendInfo = friendInfo;
    }

    private MessageArrayList messageArr=new MessageArrayList();

    public MessageArrayList getMessageArr()
    {
        return messageArr;
    }
}

class MessageArrayList extends ArrayList<FriendMessageInfo>
{
    @Override
    public boolean add(FriendMessageInfo messageInfo)
    {
        String messageId=messageInfo.getMessageId();
        int postion=0;
        for(int i=size()-1;i>=0;i--)
        {
            FriendMessageInfo anotherMessageInfo=get(i);
            String anotherMessageId=anotherMessageInfo.getMessageId();
            if(messageId.compareTo(anotherMessageId)>=0)
            {
                postion=i+1;
                break;
            }
        }
        add(postion, messageInfo);
        if(size()> ClientConfig.MAX_FIREBASEMESSAGE_CHAT)
            remove(0);
        System.out.println("----------------------------------------------");
        System.out.println(messageId+"\t"+messageInfo.getMessage());
        for(int i=0;i<size();i++)
        {
            System.out.println(get(i).getMessageId());
        }
        System.out.println("--------------------------------------------");
        return true;
    }
}
