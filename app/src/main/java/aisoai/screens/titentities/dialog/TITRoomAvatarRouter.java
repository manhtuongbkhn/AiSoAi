package aisoai.screens.titentities.dialog;
import aisoai.R;

public class TITRoomAvatarRouter
{
    public static int routerRoomAvatar(int roomAvatar)
    {
        switch (roomAvatar)
        {
            case 1:
                return R.drawable.chicken;
            case 2:
                return R.drawable.fight;
            case 3:
            default:
                return R.drawable.friendly;
        }
    }
}
