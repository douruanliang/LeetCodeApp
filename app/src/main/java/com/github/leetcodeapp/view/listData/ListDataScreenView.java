package com.github.leetcodeapp.view.listData;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * @author: douruanliang
 * @date: 2020/8/20
 */
public class ListDataScreenView extends LinearLayout implements View.OnClickListener {

    private Context mContext;
    // 创建头部 存放Tab
    private LinearLayout mMenuTabView;
    // 创建 内容+阴影
    private FrameLayout mTabMenuLayoutContainer;
    // 阴影
    private View mShadowView;
    // 内容
    private FrameLayout mMenuLayout;
    // 阴影的颜色
    private int mShadowColor = 0x88888888;
    // 菜单适配器
    private BaseMenuAdapter mAdapter;
    // 内容菜单的高度
    private int mMenuContainerHeight;
    // 当前打开的位置
    private int mCurrentPosition = -1;
    // 动画是否在执行
    private boolean mAnimatorExecute;

    private long DURATION_TIME = 350;
    public ListDataScreenView(Context context) {
        this(context, null);
    }

    public ListDataScreenView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ListDataScreenView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initLayout();
    }

    /**
     * 布局实例化（组合控件）
     */
    private void initLayout() {
        setOrientation(VERTICAL);
        // 1 创建菜单
        mMenuTabView = new LinearLayout(mContext);
        mMenuTabView.setLayoutParams(
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
        addView(mMenuTabView);

        // 2 创建 FrameLayout 用来存放 = 阴影（View） + 菜单内容布局(FrameLayout)
        mTabMenuLayoutContainer = new FrameLayout(mContext);
        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                0);
        mParams.weight = 1;
        mTabMenuLayoutContainer.setLayoutParams(mParams);


        // 3 创建阴影
        mShadowView = new View(mContext);
        mShadowView.setBackgroundColor(mShadowColor);
        mShadowView.setAlpha(0f);
        mShadowView.setOnClickListener(this);
        mShadowView.setVisibility(GONE);
        //加上 阴影
        mTabMenuLayoutContainer.addView(mShadowView);
        // 4 创建菜单内容
        mMenuLayout = new FrameLayout(mContext);
        mMenuLayout.setBackgroundColor(Color.WHITE);
        mTabMenuLayoutContainer.addView(mMenuLayout);

        addView(mTabMenuLayoutContainer);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        Log.e("TAG", "onMeasure");

        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (mMenuContainerHeight == 0 && height > 0) {
            mMenuContainerHeight =(int) (height * 75f /100);
            ViewGroup.LayoutParams params = mMenuLayout.getLayoutParams();
            params.height = mMenuContainerHeight;
            mMenuLayout.setLayoutParams(params);
            //进来的时候阴影不显示 ，内容也是不显示的（把它移上去）
            mMenuLayout.setTranslationY(-1);
        }


    }


    public void setAdapter(BaseMenuAdapter adapter) {
        this.mAdapter = adapter;
        //获取个数
        int count = mAdapter.getCount();
        for (int i = 0; i < count; i++) {
            //获取 TAB
            View tab = mAdapter.getTabView(i, mMenuTabView);
            mMenuTabView.addView(tab);
            LinearLayout.LayoutParams tabParams = (LayoutParams) tab.getLayoutParams();
            tabParams.weight =1;
            tab.setLayoutParams(tabParams);
            // 设置tab点击事件
            setTabClick(tab, i);
            //获取 菜单内容
            View menuView = mAdapter.getMenuView(i,mMenuLayout);
            menuView.setVisibility(GONE);
            mMenuLayout.addView(menuView);
        }


    }

    private void setTabClick(final View tabView, final int position) {
        tabView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (mCurrentPosition == -1){
                    openMenu(position, tabView);
                }else{
                    if (mCurrentPosition == position){
                        closeMenu();
                    }else{
                        //切换下页面
                        View currentMenu = mMenuLayout.getChildAt(mCurrentPosition);
                        currentMenu.setVisibility(View.GONE);
                        mAdapter.menuClose(currentMenu);
                        mCurrentPosition = position;
                        currentMenu = mMenuLayout.getChildAt(mCurrentPosition);
                        currentMenu.setVisibility(VISIBLE);
                        mAdapter.menuOpen(mMenuTabView.getChildAt(mCurrentPosition));
                    }
                }
            }
        });

    }

    private void closeMenu() {
        if (mAnimatorExecute) {
            return;
        }

        ObjectAnimator translationAnimator = ObjectAnimator.ofFloat(mMenuLayout, "translationY", 0, -mMenuContainerHeight);
        translationAnimator.setDuration(DURATION_TIME);
        translationAnimator.start();
        mShadowView.setVisibility(View.VISIBLE);
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(mShadowView, "alpha", 1f, 0f);
        alphaAnimator.setDuration(DURATION_TIME);
        // 要等关闭动画执行完才能去隐藏当前菜单
        alphaAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                View menuView = mMenuLayout.getChildAt(mCurrentPosition);
                menuView.setVisibility(View.GONE);
                mCurrentPosition = -1;
                mShadowView.setVisibility(GONE);
                mAnimatorExecute = false;
            }

            @Override
            public void onAnimationStart(Animator animation) {
                mAnimatorExecute = true;
                mAdapter.menuClose(mMenuTabView.getChildAt(mCurrentPosition));
            }
        });
        alphaAnimator.start();
    }

    private void openMenu(int position, View tabView) {
        if (mAnimatorExecute) return;
        mShadowView.setVisibility(View.VISIBLE);

        Log.e("TAG","position"+position +"child[]"+mMenuLayout.getChildCount());

        View menuView = mMenuLayout.getChildAt(position);
        menuView.setVisibility(View.VISIBLE);

        // 打开开启动画  位移动画  透明度动画
        ObjectAnimator translationAnimator = ObjectAnimator.ofFloat(mMenuLayout, "translationY", -mMenuContainerHeight, 0);
        translationAnimator.setDuration(DURATION_TIME);
        translationAnimator.start();
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(mShadowView, "alpha", 0f, 1f);
        alphaAnimator.setDuration(DURATION_TIME);

        alphaAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mAnimatorExecute = false;
                mCurrentPosition = position;
            }

            @Override
            public void onAnimationStart(Animator animation) {
                mAnimatorExecute = true;
                // 把当前的 tab 传到外面
                mAdapter.menuOpen(tabView);
            }
        });
        alphaAnimator.start();

    }

    @Override
    public void onClick(View v) {
        closeMenu();
    }
}
