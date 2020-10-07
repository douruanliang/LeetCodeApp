package com.github.leetcodeapp.imooc.nick.cardtestproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.core.os.TraceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.github.leetcodeapp.R;
import com.github.leetcodeapp.imooc.nick.cardtestproject.adapter.CardFragmentPagerAdapter;
import com.github.leetcodeapp.imooc.nick.cardtestproject.bean.QuestionInfo;
import com.github.leetcodeapp.imooc.nick.cardtestproject.emj.EmotionRainView;
import com.github.leetcodeapp.imooc.nick.cardtestproject.presenter.TestPresenter;
import com.github.leetcodeapp.imooc.nick.cardtestproject.transform.CardTransformer;
import com.github.leetcodeapp.imooc.nick.cardtestproject.util.InviteHelper;
import com.github.leetcodeapp.imooc.nick.cardtestproject.view.ITestView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends FragmentActivity implements ITestView {

    private ViewPager viewpager;
    private TextView tvBottomText;
    private CardFragmentPagerAdapter mAapter;
    private EmotionRainView emotion_rain_view;
    private LinearLayout invite_layout;
    private InviteHelper mInviteHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        TraceCompat.beginSection("activityOnCreate");
        setContentView(R.layout.activity_main);
        //add comment
        viewpager = (ViewPager)findViewById(R.id.viewpager);
        tvBottomText = (TextView)findViewById(R.id.tv_bottom_text);
        emotion_rain_view = (EmotionRainView)findViewById(R.id.emotion_rain_view);
        invite_layout = (LinearLayout)findViewById(R.id.invite_layout);
        TestPresenter presenter = new TestPresenter(this);
        presenter.getData();

        mInviteHelper = new InviteHelper(this,invite_layout);
        mInviteHelper.initInviteData();

        TextView rightBtn = (TextView)findViewById(R.id.btn_right);
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInviteHelper.hideInviteView();
            }
        });
        TraceCompat.endSection();
    }



    @Override
    public void updateUI(List<QuestionInfo> list) {
        Collections.reverse(list);
        mAapter = new CardFragmentPagerAdapter(getSupportFragmentManager(),
                list);
        viewpager.setAdapter(mAapter);
        viewpager.setOffscreenPageLimit(3);
        viewpager.setCurrentItem(list.size()-1);
        viewpager.setPageTransformer(true,new CardTransformer());
    }

    public void startRain() {
        emotion_rain_view.start(getBitmaps());
    }

    public List<Bitmap> getBitmaps() {
        List<Bitmap> bitmaps = new ArrayList<>();
        bitmaps.add(BitmapFactory.decodeResource(getResources(),R.mipmap.pic1));
        bitmaps.add(BitmapFactory.decodeResource(getResources(),R.mipmap.pic2));
        bitmaps.add(BitmapFactory.decodeResource(getResources(),R.mipmap.pic3));
        return bitmaps;
    }

    @Override
    public void setBottomTipView(String count) {
        tvBottomText.setText("恭喜你累计答对"+count+"题");
    }
}
