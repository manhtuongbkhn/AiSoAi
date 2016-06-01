package aisoai.screens.startscreen;

import android.view.View;
import android.widget.ImageView;

import aisoai.TITApplication;
import aisoai.screens.titentities.activity.TITNormalActivity;
import aisoai.R;
import aisoai.screens.titentities.control.TITNormalControl;

public class StartActivity extends TITNormalActivity
{
    private ImageView ivLogo;

    @Override
    protected void linkToLayout()
    {
        getScreenConfig();
        setContentView(R.layout.start);
        ivLogo=(ImageView) findViewById(R.id.ivLogo);
        ivLogo.setImageResource(R.drawable.logo);
        ivLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getControl().startEvent();
            }
        });
    }

    @Override
    protected void scaleView()
    {
        ivLogo.requestLayout();
        ivLogo.getLayoutParams().width=StartAcUIDefine.LOGOIV_WIDTH();
        ivLogo.getLayoutParams().height=StartAcUIDefine.LOGOIV_HEIGHT();

        createSystem();
    }

    protected void createSystem()
    {
        TITApplication.init();
    }

    @Override
    protected TITNormalControl linkControl()
    {
        return TITApplication.getScreenControlManager().getStartControl();
    }

    public ImageView getIvAvarta()
    {
        return ivLogo;
    }

    @Override
    public StartControl getControl()
    {
        return (StartControl) control;
    }


}
