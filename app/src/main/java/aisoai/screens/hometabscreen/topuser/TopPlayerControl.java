package aisoai.screens.hometabscreen.topuser;

import android.graphics.Bitmap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import aisoai.R;
import aisoai.config.KJS;
import aisoai.screens.hometabscreen.HomeTabControl;
import aisoai.screens.titentities.model.TITModel;
import aisoai.screens.titentities.control.TITSpecControl;
import aisoai.screens.titentities.TITRequestFactory;

public class TopPlayerControl extends TITSpecControl
{
    @Override
    public void init()
    {
        super.init();
        TopPlayerArrayAdapter playerArrayAdapter=
                            new TopPlayerArrayAdapter(getActivity(),this,getModel().getPlayerArr());
        getActivity().getLvPlayer().setAdapter(playerArrayAdapter);

        getRequestFactory().topPlayerRequest();
    }

    @Override
    public void reinit()
    {
        getRequestFactory().topPlayerRequest();
    }

    public void moreInfoEvent(int postion)
    {
        TopPlayerInfo playerInfo=getModel().getPlayerArr().get(postion);
        getActivity().setDlMoreTopPlayerInfo(new MoreTopPlayerInfoDialog(getActivity(),this));
        getActivity().getDlMoreTopPlayerInfo().setContent(playerInfo);
        getActivity().getDlMoreTopPlayerInfo().show();
    }

    public void topPlayerResponse(JsonObject fromServerData)
    {
        //System.out.println("-Top Player Response");
    }

    public void reloadTopPlayerNotify(JsonObject fromServerData)
    {
        getModel().getPlayerArr().clear();
        JsonArray jsonArray=fromServerData.get(KJS.ARRAY).getAsJsonArray();
        //System.out.println(jsonArray.toString());
        for(int i=0;i<jsonArray.size();i++)
        {
            JsonObject playerInfoJs=jsonArray.get(i).getAsJsonObject();
            playerInfoJs.addProperty(KJS.AVATAR_PRIORITY,4);
            TopPlayerInfo topPlayerInfo = new TopPlayerInfo(playerInfoJs)
            {
                @Override
                public void reloadImage(Bitmap bitmap)
                {
                    getActivity().getLvPlayer().invalidateViews();
                }
            };
            getModel().getPlayerArr().add(topPlayerInfo);
        }
        getActivity().getLvPlayer().invalidateViews();
    }

    public void cancelTopPlayerResponse(JsonObject fromServerData)
    {
        //System.out.println("-Cancel Top Player Response");
    }

    @Override
    public void finish()
    {
        super.finish();
        getRequestFactory().cancelTopPlayerRequest();
    }

    @Override
    public TopPlayerActivity getActivity()
    {
        return (TopPlayerActivity) activity;
    }

    @Override
    public TopPlayerModel getModel()
    {
        return (TopPlayerModel) model;
    }

    @Override
    public TopPlayerRF getRequestFactory()
    {
        return (TopPlayerRF) requestFactory;
    }

    @Override
    public HomeTabControl getTabControl()
    {
        return (HomeTabControl) tabControl;
    }

    @Override
    public Class<? extends TopPlayerActivity> initActivity()
    {
        return TopPlayerActivity.class;
    }

    @Override
    protected TITModel initModel()
    {
        return new TopPlayerModel();
    }

    @Override
    protected TITRequestFactory initRequestFactory()
    {
        return new TopPlayerRF();
    }

    @Override
    public String initTitle()
    {
        return "Top User";
    }

    @Override
    public int initDrawableId()
    {
        return R.drawable.top20;
    }
}
