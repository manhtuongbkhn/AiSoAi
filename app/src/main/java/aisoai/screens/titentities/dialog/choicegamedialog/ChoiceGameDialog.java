package aisoai.screens.titentities.dialog.choicegamedialog;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import aisoai.R;
import aisoai.screens.hometabscreen.roomlistscreen.RoomListControl;
import aisoai.screens.titentities.control.TITControl;
import aisoai.screens.titentities.dialog.TITIDialog;

abstract public class ChoiceGameDialog extends TITIDialog
{
    private GridView gvGame;

    public ChoiceGameDialog(Context context, TITControl control)
    {
        super(context, control);
    }

    @Override
    public int getIcon()
    {
        return R.drawable.default_game_icon;
    }

    @Override
    protected String getTitle()
    {
        return "Chọn game";
    }

    @Override
    protected int getLayout()
    {
        return R.layout.choice_game_dialog;
    }

    @Override
    protected void linkToLayout()
    {
        gvGame =(GridView) findViewById(R.id.gvGame);
        gvGame.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                onItemClickEvent(position);
            }
        });
    }

    abstract protected void onItemClickEvent(int position);

    @Override
    protected void scaleView()
    {

    }

    @Override
    protected void closeEvent()
    {
        dismiss();
    }

    @Override
    protected int getWidth()
    {
        return ChoiceGameUIDefine.CHOICEGAMEDL_WIDTH();
    }

    @Override
    protected int getHeight()
    {
        return ChoiceGameUIDefine.CHOICEGAMEDL_HEIGHT();
    }

    public GridView getGvGame()
    {
        return gvGame;
    }
}
