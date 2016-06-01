package aisoai.screens.startscreen;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import aisoai.R;
import aisoai.TITApplication;
import aisoai.config.ClientConfig;
import aisoai.loadnetimage.TITDownLoadImage;
import aisoai.screens.signinscreen.SignInControl;
import aisoai.screens.titentities.activity.TITNormalActivity;
import aisoai.screens.titentities.TITRequestFactory;
import aisoai.screens.titentities.model.TITModel;
import aisoai.screens.titentities.control.TITNormalControl;

public class StartControl extends TITNormalControl
{
    @Override
    public void init()
    {
        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inPreferredConfig= Bitmap.Config.ARGB_8888;
        options.inMutable=true;
        Bitmap playerAvatar= BitmapFactory.decodeResource(getActivity().getResources(),
                                                                R.drawable.player_avarta,options);
        TITDownLoadImage.setDefaultPlayerAvatar(playerAvatar);
       new WaitTask().execute();
    }

    @Override
    public void finish()
    {

    }

    public void startEvent()
    {

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    class WaitTask extends AsyncTask<Void,Void,Void>
    {
        @Override
        protected Void doInBackground(Void... params)
        {
            try
            {
                Thread.sleep(ClientConfig.WAIT_START_TIME);
            } catch (InterruptedException e) {}
            return null;

        }
        @Override
        protected void onPostExecute(Void v)
        {
            TITApplication.getScreenControlManager().changeScreen(new SignInControl());
        }
    }

    @Override
    public Class<? extends TITNormalActivity> initActivity()
    {
        return StartActivity.class;
    }

    @Override
    protected TITModel initModel()
    {
        return null;
    }

    @Override
    protected TITRequestFactory initRequestFactory()
    {
        return null;
    }

    @Override
    public StartActivity getActivity()
    {
        return (StartActivity) activity;
    }

    @Override
    public TITModel getModel()
    {
        return model;
    }

    @Override
    public TITRequestFactory getRequestFactory()
    {
        return requestFactory;
    }

}
