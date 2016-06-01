package aisoai.screens.hometabscreen.homeprofilescreen;

import android.net.Uri;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareButton;

import aisoai.TITApplication;
import aisoai.config.UIDefine;
import aisoai.R;
import aisoai.screens.titentities.activity.TITSpecActivity;
import aisoai.screens.titentities.control.TITSpecControl;

public class ProfileActivity extends TITSpecActivity
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

    private ImageButton ibtChallenge;
    private ImageButton ibtTraining;
    private ShareButton btFbShare;

    private ChallengeDialog dlchallenge;
    private ChallengeWaitingDialog dlChallengeWaiting;

    @Override
    protected void linkToLayout()
    {
        setContentView(R.layout.profile);
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

        ibtChallenge =(ImageButton) findViewById(R.id.ibtChallenge);
        ibtTraining =(ImageButton) findViewById(R.id.ibtTraining);
        btFbShare=(ShareButton) findViewById(R.id.btFbShare);

        ibtChallenge.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getControl().challengeEvent();
            }
        });

        ibtTraining.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getControl().trainingEvent();
            }
        });
        ShareLinkContent shareContent = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse("https://developers.facebook.com"))
                .build();
        btFbShare.setShareContent(shareContent);
        //dlchallenge=new ChallengeDialog(this,null);
        //dlChallengeWaiting=new ChallengeWaitingDialog(this,null);
    }

    @Override
    protected void scaleView()
    {
        ivPlayerAvatar.requestLayout();
        ivPlayerAvatar.getLayoutParams().width = ProfileUIDefine.USERAVATARIV_WIDTH();
        ivPlayerAvatar.getLayoutParams().height = ProfileUIDefine.USERAVATARIV_HEIGHT();

        ivGender.requestLayout();
        ivGender.getLayoutParams().width=ProfileUIDefine.GENDERIV_WIDTH();
        ivGender.getLayoutParams().height=ProfileUIDefine.GENDERIV_HEIGHT();

        ibtChallenge.requestLayout();
        ibtChallenge.getLayoutParams().width = ProfileUIDefine.CHALLENGEIBT_WIDTH();
        ibtChallenge.getLayoutParams().height = ProfileUIDefine.CHALLENGEIBT_HEIGHT();

        ibtTraining.requestLayout();
        ibtTraining.getLayoutParams().width = ProfileUIDefine.TRAININGIBT_WIDTH();
        ibtTraining.getLayoutParams().height = ProfileUIDefine.TRANINGIBT_HEIGHT();

        btFbShare.requestLayout();
        btFbShare.getLayoutParams().width=ProfileUIDefine.SHAREBT_WIDTH();
        btFbShare.getLayoutParams().height=ProfileUIDefine.SHAREBT_HEIGHT();
        btFbShare.setText("Share");

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

        btFbShare.setTextSize(ProfileUIDefine.SHARETEXT_SIZE());
    }

    public ImageView getIvPlayerAvatar()
    {
        return ivPlayerAvatar;
    }

    public TextView getTvPlayerName()
    {
        return tvPlayerName;
    }

    public ImageView getIvGender()
    {
        return ivGender;
    }

    public TextView getTvTotalNormalMatchCount()
    {
        return tvTotalNormalMatchCount;
    }

    public TextView getTvTotalNormalWinMatchCount()
    {
        return tvTotalNormalWinMatchCount;
    }

    public TextView getTvTotalRankMatchCount()
    {
        return tvTotalRankMatchCount;
    }

    public TextView getTvTotalRankWinMatchCount()
    {
        return tvTotalRankWinMatchCount;
    }

    public ListView getLvGameMaturity()
    {
        return lvGameMaturity;
    }

    public ChallengeDialog getDlchallenge()
    {
        return dlchallenge;
    }

    public void setDlchallenge(ChallengeDialog dlchallenge)
    {
        this.dlchallenge = dlchallenge;
    }

    public ChallengeWaitingDialog getDlChallengeWaiting()
    {
        return dlChallengeWaiting;
    }

    public void setDlChallengeWaiting(ChallengeWaitingDialog dlChallengeWaiting)
    {
        this.dlChallengeWaiting = dlChallengeWaiting;
    }

    @Override
    protected TITSpecControl linkControl()
    {
        return TITApplication.getScreenControlManager().getProfileControl();
    }

    @Override
    public ProfileControl getControl()
    {
        return (ProfileControl) control;
    }

}
