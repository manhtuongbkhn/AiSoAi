package aisoai.screens.hometabscreen.roomlistscreen;

import android.content.Context;

import aisoai.screens.titentities.control.TITControl;
import aisoai.screens.titentities.dialog.choicegamedialog.ChoiceGameDialog;

public class RLChoiceGameDialog extends ChoiceGameDialog
{
    public RLChoiceGameDialog(Context context, TITControl control)
    {
        super(context, control);
    }

    @Override
    protected void onItemClickEvent(int position)
    {
        getControl().choiceGameEvent(position);
    }

    @Override
    public RoomListControl getControl()
    {
        return (RoomListControl) control;
    }
}
