package aisoai.screens.insidetabscreen.insideroomscreen;

import android.content.Context;
import android.widget.TextView;

import aisoai.screens.titentities.dialog.TITIDialog;
import aisoai.R;
import aisoai.screens.titentities.control.TITNormalControl;

public class DownTimeDialog extends TITIDialog
{
    private TextView tvTime;

    public DownTimeDialog(Context context,TITNormalControl control)
    {
        super(context,control);
    }

    @Override
    protected int getLayout()
    {
        return R.layout.down_time_dialog;
    }

    protected void linkToLayout()
    {
        tvTime=(TextView) findViewById(R.id.tvTime);
    }

    protected void scaleView()
    {
        tvTime.requestLayout();
        tvTime.getLayoutParams().width= InsideRoomUIDefine.TIMEDL_WIDTH();
        tvTime.getLayoutParams().height= InsideRoomUIDefine.TIMEDL_HEIGHT();
        tvTime.setTextSize(InsideRoomUIDefine.TIMETEXT_SIZE());
    }

    @Override
    protected void closeEvent()
    {

    }

    @Override
    public int getIcon()
    {
        return R.drawable.hourglass_icon;
    }

    @Override
    public String getTitle()
    {
        return "Vui Lòng Chờ!";
    }

    @Override
    protected int getWidth()
    {
        return InsideRoomUIDefine.TIMEDL_WIDTH();
    }

    @Override
    protected int getHeight()
    {
        return InsideRoomUIDefine.TIMEDL_HEIGHT();
    }

    @Override
    public InsideRoomControl getControl()
    {
        return (InsideRoomControl) control;
    }

    public TextView getTvTime()
    {
        return tvTime;
    }
}
