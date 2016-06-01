package aisoai.screens.hometabscreen.topuser;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import aisoai.R;
import aisoai.config.UIDefine;
import aisoai.screens.titentities.activity.TITNormalActivity;

public class TopPlayerArrayAdapter extends ArrayAdapter
{
    private TITNormalActivity titActivity;
    private ArrayList<TopPlayerInfo> topPlayerArr;
    private TopPlayerControl control;

    private View row;
    private ImageView ivPlayerAvatar;
    private TextView tvFullName;

    private TextView tvRankPoint;
    private ImageView ivUserRank;
    private TextView tvMatchCount;

    private TextView tvRankPostion;
    private ImageView ivMoreInfo;

    public TopPlayerArrayAdapter(TITNormalActivity titActivity,TopPlayerControl control,
                                                            ArrayList<TopPlayerInfo> topPlayerArr)
    {
        super(titActivity, R.layout.top_player_item, topPlayerArr);
        this.titActivity=titActivity;
        this.topPlayerArr = topPlayerArr;
        this.control=control;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent)
    {
        LayoutInflater inflater=titActivity.getLayoutInflater();
        row=inflater.inflate(R.layout.top_player_item,parent,false);
        linkToLayout(position);
        scaleView();
        setContentView(position);
        return row;
    }

    public void linkToLayout(final int postion)
    {
        ivPlayerAvatar =(ImageView) row.findViewById(R.id.ivPlayerAvatar);
        tvFullName =(TextView) row.findViewById(R.id.tvFullName);
        tvRankPoint=(TextView) row.findViewById(R.id.tvRankPoint);
        ivUserRank=(ImageView) row.findViewById(R.id.ivUserRank);
        tvMatchCount=(TextView) row.findViewById(R.id.tvMatchCount);

        tvRankPostion=(TextView) row.findViewById(R.id.tvRankPostion);
        ivMoreInfo=(ImageView) row.findViewById(R.id.ivMoreInfo);

        ivMoreInfo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                control.moreInfoEvent(postion);
            }
        });
    }

    public void scaleView()
    {
        row.requestLayout();
        row.getLayoutParams().width= TopPlayerUIDefine.ITEM_WIDTH();
        row.getLayoutParams().height= TopPlayerUIDefine.ITEM_HEIGHT();

        ivPlayerAvatar.requestLayout();
        ivPlayerAvatar.getLayoutParams().width= TopPlayerUIDefine.PLAYERAVATARIV_WIDTH();
        ivPlayerAvatar.getLayoutParams().height= TopPlayerUIDefine.PLAYERAVATAR_HEIGHT();

        ivUserRank.requestLayout();
        ivUserRank.getLayoutParams().width=TopPlayerUIDefine.RANKIV_WIDTH();
        ivUserRank.getLayoutParams().height=TopPlayerUIDefine.RANKIV_HEIGHT();


        ivMoreInfo.requestLayout();
        ivMoreInfo.getLayoutParams().width= TopPlayerUIDefine.MOREINFOIBT_WIDTH();
        ivMoreInfo.getLayoutParams().height= TopPlayerUIDefine.MOREINFOIBT_HEIGHT();

        tvFullName.setTextSize(UIDefine.MEDIUMTEXT_SIZE());
        tvMatchCount.setTextSize(UIDefine.SMALLTEXT_SIZE());
        tvRankPostion.setTextSize(UIDefine.SMALLTEXT_SIZE());
    }

    public void setContentView(int position)
    {
        TopPlayerInfo topPlayerInfo= topPlayerArr.get(position);
        Bitmap avatarBitmap=topPlayerInfo.getUserProfile().getAvatarBitmap();
        String fullName=topPlayerInfo.getUserProfile().getFullName();
        Integer rankPoint=topPlayerInfo.getRankPoint();
        Integer matchCount=topPlayerInfo.getGameUserInfo().getTotalRankMatchCount();
        Integer rankPostion=topPlayerInfo.getRankPostion();

        ivPlayerAvatar.setImageBitmap(avatarBitmap);
        tvFullName.setText(fullName);
        tvRankPoint.setText(rankPoint.toString());

        ivUserRank.setImageResource(R.drawable.brass_tier);
        tvMatchCount.setText(matchCount + " trận");
        tvRankPostion.setText(rankPostion.toString());
    }
}
