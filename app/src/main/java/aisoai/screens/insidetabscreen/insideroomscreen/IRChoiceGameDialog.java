package aisoai.screens.insidetabscreen.insideroomscreen;

import android.content.Context;

import aisoai.screens.titentities.control.TITControl;
import aisoai.screens.titentities.dialog.choicegamedialog.ChoiceGameDialog;

public class IRChoiceGameDialog extends ChoiceGameDialog
{

    public IRChoiceGameDialog(Context context, TITControl control)
    {
        super(context, control);
    }

    @Override
    protected void onItemClickEvent(int position)
    {
        getControl().choiGameEvent(position);
    }

    @Override
    public InsideRoomControl getControl()
    {
        return (InsideRoomControl) control;
    }
}
