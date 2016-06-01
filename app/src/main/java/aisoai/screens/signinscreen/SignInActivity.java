package aisoai.screens.signinscreen;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;

import aisoai.TITApplication;
import aisoai.facebookcommunincate.TITFacebookCommunicate;
import aisoai.screens.titentities.activity.TITNormalActivity;
import aisoai.R;
import aisoai.screens.titentities.control.TITNormalControl;

public class SignInActivity extends TITNormalActivity
{
    private ImageView ivLogo;
    private LoginDialog dlLogin;
    private LoginButton btFbLogin;
    private CallbackManager callbackManager;

    @Override
    protected void linkToLayout()
    {
        TITFacebookCommunicate.newFacebookCommunicate(this);
        setContentView(R.layout.sign_in);
        ivLogo=(ImageView) findViewById(R.id.ivLogo);
        ivLogo.setImageResource(R.drawable.logo);
        ivLogo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                getControl().logoEvent();
            }
        });

        btFbLogin=(LoginButton)findViewById(R.id.btFbLogin);
    }

    @Override
    protected void scaleView()
    {
        ivLogo.requestLayout();
        ivLogo.getLayoutParams().width=SignInAcUIDefine.LOGOIV_WIDTH();
        ivLogo.getLayoutParams().height=SignInAcUIDefine.LOGOIV_HEIGHT();

        btFbLogin.requestLayout();
        btFbLogin.getLayoutParams().width=SignInAcUIDefine.LOGINFBBT_WIDTH();
        btFbLogin.getLayoutParams().height=SignInAcUIDefine.LOGINFBBT_HEIGHT();
    }

    //Get Set Method

    @Override
    public SignInControl getControl()
    {
        return (SignInControl) this.control;
    }


    @Override
    protected TITNormalControl linkControl()
    {
        return TITApplication.getScreenControlManager().getSignInControl();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        TITFacebookCommunicate.getCurrentFacebookCommunicate().
                                getCallbackManager().onActivityResult(requestCode, resultCode, data);
    }

    public LoginDialog getDlLogin()
    {
        return dlLogin;
    }

    public void setDlLogin(LoginDialog dlLogin)
    {
        this.dlLogin = dlLogin;
    }
}
