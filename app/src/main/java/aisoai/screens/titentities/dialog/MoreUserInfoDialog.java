package aisoai.screens.titentities.dialog;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import aisoai.R;
import aisoai.config.ClientConfig;
import aisoai.config.UIDefine;
import aisoai.screens.titentities.model.TITUserInfo;
import aisoai.screens.titentities.control.TITControl;

abstract public class MoreUserInfoDialog extends TITIDialog
{
    private ImageView ivPlayerAvatar;
    private TextView tvPlayerName;
    private ImageView ivGender;

    private TextView tvTotalNormalMatchCount;
    private TextView tvTotalNormalWinMatchCount;
    private TextView tvTotalRankMatchCount;
    private TextView tvTotalRankWinMatchCount;

    private TextView tvLbGameName;
    private TextView tvLbGameMatchCount;
    private TextView tvLbGameWinPercent;
    private TextView tvLbExperiencePoint;
    private TextView tvLbRank;

    private ListView lvGameMaturity;


    public MoreUserInfoDialog(Context context, TITControl control)
    {
        super(context, control);
    }

    @Override
    public int getIcon()
    {
        return R.drawable.user_profile;
    }

    @Override
    protected void linkToLayout()
    {
        ivPlayerAvatar =(ImageView) findViewById(R.id.ivPlayerAvatar);
        tvPlayerName =(TextView) findViewById(R.id.tvPlayerName);
        ivGender=(ImageView) findViewById(R.id.ivGender);
        tvTotalNormalMatchCount =(TextView) findViewById(R.id.tvTotalNormalMatchCount);
        tvTotalNormalWinMatchCount =(TextView) findViewById(R.id.tvTotalNormalWinMatchCount);
        tvTotalRankMatchCount =(TextView) findViewById(R.id.tvTotalRankMatchCount);
        tvTotalRankWinMatchCount =(TextView) findViewById(R.id.tvTotalRankWinMatchCount);

        tvLbGameName=(TextView) findViewById(R.id.tvLbGameName);
        tvLbGameMatchCount=(TextView) findViewById(R.id.tvLbGameMatchCount);
        tvLbGameWinPercent=(TextView) findViewById(R.id.tvLbGameWinPercent);
        tvLbExperiencePoint=(TextView) findViewById(R.id.tvLbExperiencePoint);
        tvLbRank=(TextView) findViewById(R.id.tvLbRank);

        lvGameMaturity=(ListView) findViewById(R.id.lvGameMaturity);
    }

    @Override
    protected void scaleView()
    {
        ivPlayerAvatar.requestLayout();
        ivPlayerAvatar.getLayoutParams().width =MoreUserInfoDialogUIDefine.USERAVATARIV_WIDTH();
        ivPlayerAvatar.getLayoutParams().height =MoreUserInfoDialogUIDefine.USERAVATARIV_HEIGHT();

        ivGender.requestLayout();
        ivGender.getLayoutParams().width=MoreUserInfoDialogUIDefine.GENDERIV_WIDTH();
        ivGender.getLayoutParams().height=MoreUserInfoDialogUIDefine.GENDERIV_HEIGHT();

        tvPlayerName.setTextSize(UIDefine.BIGTEXT_SIZE());
        tvTotalNormalMatchCount.setTextSize(UIDefine.MEDIUMTEXT_SIZE());
        tvTotalNormalWinMatchCount.setTextSize(UIDefine.MEDIUMTEXT_SIZE());
        tvTotalRankMatchCount.setTextSize(UIDefine.MEDIUMTEXT_SIZE());
        tvTotalRankWinMatchCount.setTextSize(UIDefine.MEDIUMTEXT_SIZE());

        tvLbGameName.setTextSize(UIDefine.SMALLTEXT_SIZE());
        tvLbGameMatchCount.setTextSize(UIDefine.SMALLTEXT_SIZE());
        tvLbGameWinPercent.setTextSize(UIDefine.SMALLTEXT_SIZE());
        tvLbExperiencePoint.setTextSize(UIDefine.SMALLTEXT_SIZE());
        tvLbRank.setTextSize(UIDefine.SMALLTEXT_SIZE());
    }

    public void setContent(TITUserInfo userInfo)
    {
        ivPlayerAvatar.setImageBitmap(userInfo.getUserProfile().getAvatarBitmap());
        tvPlayerName.setText(userInfo.getUserProfile().getFullName());

        if(userInfo.getUserProfile().getGender().equals("male"))
        {
            ivGender.setImageResource(R.drawable.male);
        }
        if(userInfo.getUserProfile().getGender().equals("female"))
        {
            ivGender.setImageResource(R.drawable.female);
        }

        tvTotalNormalMatchCount.setText
                        (userInfo.getGameUserInfo().getTotalNormalMatchCount() + " thường");
        tvTotalNormalWinMatchCount.setText
                        ((userInfo.getGameUserInfo().getTotalNormalWinMatchCount())+" thắng");
        tvTotalRankMatchCount.setText
                                (userInfo.getGameUserInfo().getTotalRankMatchCount()+" hạng");
        tvTotalRankWinMatchCount.setText
                (userInfo.getGameUserInfo().getTotalRankWinMatchCount() + " thắng");
        GameMaturityArrayAdapter gameMaturityArrayAdapter=new GameMaturityArrayAdapter
                (control.getActivity().getActivity(),userInfo.getGameUserInfo().getGameMaturityArr());
        lvGameMaturity.setAdapter(gameMaturityArrayAdapter);
        lvGameMaturity.invalidateViews();
    }

    @Override
    protected void closeEvent()
    {
        dismiss();
    }

    @Override
    protected int getWidth()
    {
        return MoreUserInfoDialogUIDefine.MOREUSERINFODL_WIDTH();
    }
}