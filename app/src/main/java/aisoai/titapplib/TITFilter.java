package aisoai.titapplib;

import java.util.ArrayList;

public class TITFilter
{
    public static ArrayList<String> getNewFriendFacebookId
        (ArrayList<String> facebookFromFacebookIdArr, ArrayList<String> firebaseFromFacebookIdArr)
    {
        ArrayList<String> newFriendFacebookIdArr=new ArrayList<String>();
        for(int i=0;i<facebookFromFacebookIdArr.size();i++)
        {
            String facebookId=facebookFromFacebookIdArr.get(i);
            if(!firebaseFromFacebookIdArr.contains(facebookId))
                newFriendFacebookIdArr.add(facebookId);
        }
        return newFriendFacebookIdArr;
    }

    public static ArrayList<String> getRemoveFriendFacebookId
        (ArrayList<String> facebookFromFacebookIdArr,ArrayList<String> firebaseFromFacebookIdArr)
    {
        ArrayList<String> removeFriendFacebookIdArr=new ArrayList<String>();
        for(int i=0;i<firebaseFromFacebookIdArr.size();i++)
        {
            String facebookId=firebaseFromFacebookIdArr.get(i);
            if(!facebookFromFacebookIdArr.contains(facebookId))
                removeFriendFacebookIdArr.add(facebookId);
        }
        return removeFriendFacebookIdArr;
    }

    public static String filterMessage(String message)
    {
        return message;
    }
}
