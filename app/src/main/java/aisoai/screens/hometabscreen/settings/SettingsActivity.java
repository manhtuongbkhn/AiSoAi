package aisoai.screens.hometabscreen.settings;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;

import aisoai.R;
import aisoai.TITApplication;
import aisoai.facebookcommunincate.TITFacebookCommunicate;
import aisoai.screens.titentities.activity.TITSpecActivity;
import aisoai.screens.titentities.control.TITSpecControl;

public class SettingsActivity extends TITSpecActivity
{
    private ImageButton ibtConfig;
    private ImageButton ibtHistory;
    private ImageButton ibtShop;
    private ImageButton ibtProfile;
    private ImageButton ibtComment;
    private LoginButton btFbLogout;

    @Override
    protected void linkToLayout()
    {
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.settings);
        ibtConfig=(ImageButton) findViewById(R.id.ibtConfig);
        ibtHistory=(ImageButton) findViewById(R.id.ibtHistory);
        ibtShop=(ImageButton) findViewById(R.id.ibtShop);
        ibtProfile=(ImageButton) findViewById(R.id.ibtProfile);
        ibtComment=(ImageButton) findViewById(R.id.ibtComment);
        btFbLogout =(LoginButton) findViewById(R.id.btFbLogout);
        btFbLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                getControl().logoutEvent();
            }
        });
    }

    @Override
    protected void scaleView()
    {
        ibtConfig.requestLayout();
        ibtConfig.getLayoutParams().width=SettingsUIDefine.IBT_WIDTH();
        ibtConfig.getLayoutParams().height=SettingsUIDefine.IBT_HEIGHT();

        ibtHistory.requestLayout();
        ibtHistory.getLayoutParams().width=SettingsUIDefine.IBT_WIDTH();
        ibtHistory.getLayoutParams().height=SettingsUIDefine.IBT_HEIGHT();

        ibtShop.requestLayout();
        ibtShop.getLayoutParams().width=SettingsUIDefine.IBT_WIDTH();
        ibtShop.getLayoutParams().height=SettingsUIDefine.IBT_HEIGHT();

        ibtProfile.requestLayout();
        ibtProfile.getLayoutParams().width=SettingsUIDefine.IBT_WIDTH();
        ibtProfile.getLayoutParams().height=SettingsUIDefine.IBT_HEIGHT();

        ibtComment.requestLayout();
        ibtComment.getLayoutParams().width=SettingsUIDefine.IBT_WIDTH();
        ibtComment.getLayoutParams().height=SettingsUIDefine.IBT_HEIGHT();

        btFbLogout.requestLayout();
        btFbLogout.getLayoutParams().width=SettingsUIDefine.IBT_WIDTH();
        btFbLogout.getLayoutParams().height=SettingsUIDefine.IBT_HEIGHT();
    }

    @Override
    protected TITSpecControl linkControl()
    {
        return TITApplication.getScreenControlManager().getSettingsControl();
    }

    @Override
    public SettingsControl getControl()
    {
        return (SettingsControl) control;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        System.out.println("-ppppppppppppppppppppppppppppp");
        super.onActivityResult(requestCode, resultCode, data);
        TITFacebookCommunicate.getCurrentFacebookCommunicate().
                getCallbackManager().onActivityResult(requestCode, resultCode, data);
    }

}
