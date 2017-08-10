package moocollege.cn.fragmentanalysis;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mFrameLayout;
    private BottomNavigationBar mBottomBar;
    private FragmentHome mFragmentHome;
    private FragmentDynamic mFragmentDynamic;
    private FragmentPractice mFragmentPractice;
    private FragmentMessage mFragmentMessage;
    private FragmentManagerOperator mFragmentManagerOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }


    private void initView() {
        mFrameLayout = (FrameLayout) findViewById(R.id.container);
        mBottomBar = (BottomNavigationBar) findViewById(R.id.bottom_bar);
        //mBottomBar一些基础配置 模式 添加内容 默认选中 添加监听

        mBottomBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomBar.addItem(new BottomNavigationItem(R.mipmap.tab_ic_home_pressed, "首页").setInactiveIconResource(R.mipmap.tab_ic_home_default))
                .addItem(new BottomNavigationItem(R.mipmap.tab_ic_dynamic_pressed, "动态").setInactiveIconResource(R.mipmap.tab_ic_dynamic_default))
                .addItem(new BottomNavigationItem(R.mipmap.tab_ic_practice_pressed, "实习").setInactiveIconResource(R.mipmap.tab_ic_practice_default))
                .addItem(new BottomNavigationItem(R.mipmap.tab_ic_message_pressed, "消息").setInactiveIconResource(R.mipmap.tab_ic_message_default))
                .setFirstSelectedPosition(0)
                .initialise();
        mBottomBar.setTabSelectedListener(mBottomBarSelectedListener);

    }

    private void initData() {
        //加载第一个fragment
        //getSupportFragmentManager()可以兼容11以下的版本
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        //开启事物
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        //把第一个fragment加进来
//        mFragmentHome = new FragmentHome();
//        fragmentTransaction.add(R.id.container, mFragmentHome);
//        //提交
//        fragmentTransaction.commit();
        mFragmentManagerOperator = new FragmentManagerOperator(getSupportFragmentManager(), R.id.container);
        mFragmentHome = new FragmentHome();
        mFragmentManagerOperator.add(mFragmentHome);

    }

    private BottomNavigationBar.OnTabSelectedListener mBottomBarSelectedListener = new BottomNavigationBar.OnTabSelectedListener() {
        @Override
        public void onTabSelected(int position) {
            switchTo(position);
        }

        @Override
        public void onTabUnselected(int position) {

        }


        @Override
        public void onTabReselected(int position) {

        }
    };
//
//    /**
//     * fragment的切换之replace方法
//     *
//     * @param position
//     */
//    private void switchTo(int position) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        switch (position) {
//            case 0:
//                if (mFragmentHome == null) {
//                    mFragmentHome = new FragmentHome();
//                }
//                fragmentTransaction.replace(R.id.container, mFragmentHome);
//                fragmentTransaction.commit();
//                break;
//            case 1:
//                if (mFragmentDynamic == null) {
//                    mFragmentDynamic = new FragmentDynamic();
//                }
//                fragmentTransaction.replace(R.id.container, mFragmentDynamic);
//                fragmentTransaction.commit();
//                break;
//            case 2:
//                if (mFragmentPractice == null) {
//                    mFragmentPractice = new FragmentPractice();
//                }
//                fragmentTransaction.replace(R.id.container, mFragmentPractice);
//                fragmentTransaction.commit();
//                break;
//            case 3:
//                if (mFragmentMessage == null) {
//                    mFragmentMessage = new FragmentMessage();
//                }
//                fragmentTransaction.replace(R.id.container, mFragmentMessage);
//                fragmentTransaction.commit();
//                break;
//        }
//    }


//    /**
//     * fragment的切换之hide和show
//     *
//     * @param position
//     */
//    private void switchTo(int position) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        // 开启事物
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        // 获得所有的Fragment
//        List<Fragment> childFragments = fragmentManager.getFragments();
//        //隐藏所有的Fragment
//        for (Fragment childFragment : childFragments) {
//            fragmentTransaction.hide(childFragment);
//        }
//        switch (position) {
//            case 0:
//                if (mFragmentHome == null) {
//                    mFragmentHome = new FragmentHome();
//                }
//                //如果容器里面没有我们就添加，否则显示
//                if (!childFragments.contains(mFragmentHome)) {
//                    fragmentTransaction.add(R.id.container, mFragmentHome);
//                } else {
//                    fragmentTransaction.show(mFragmentHome);
//                }
//                break;
//            case 1:
//                if (mFragmentDynamic == null) {
//                    mFragmentDynamic = new FragmentDynamic();
//                }
//                if (!childFragments.contains(mFragmentDynamic)) {
//                    fragmentTransaction.add(R.id.container, mFragmentDynamic);
//                } else {
//                    fragmentTransaction.show(mFragmentDynamic);
//                }
//                break;
//            case 2:
//                if (mFragmentPractice == null) {
//                    mFragmentPractice = new FragmentPractice();
//                }
//                if (!childFragments.contains(mFragmentPractice)) {
//                    fragmentTransaction.add(R.id.container, mFragmentPractice);
//                } else {
//                    fragmentTransaction.show(mFragmentPractice);
//                }
//                break;
//            case 3:
//                if (mFragmentMessage == null) {
//                    mFragmentMessage = new FragmentMessage();
//                }
//                if (!childFragments.contains(mFragmentMessage)) {
//                    fragmentTransaction.add(R.id.container, mFragmentMessage);
//                } else {
//                    fragmentTransaction.show(mFragmentMessage);
//                }
//                break;
//        }
//        fragmentTransaction.commit();
//    }


    /**
     * 封装后
     *
     * @param position
     */
    private void switchTo(int position) {

        switch (position) {
            case 0:
                if (mFragmentHome == null) {
                    mFragmentHome = new FragmentHome();
                }
                mFragmentManagerOperator.changeFragment(mFragmentHome);
                break;
            case 1:
                if (mFragmentDynamic == null) {
                    mFragmentDynamic = new FragmentDynamic();
                }
                mFragmentManagerOperator.changeFragment(mFragmentDynamic);
                break;
            case 2:
                if (mFragmentPractice == null) {
                    mFragmentPractice = new FragmentPractice();
                }
                mFragmentManagerOperator.changeFragment(mFragmentPractice);
                break;
            case 3:
                if (mFragmentMessage == null) {
                    mFragmentMessage = new FragmentMessage();
                }
                mFragmentManagerOperator.changeFragment(mFragmentMessage);
                break;
        }
    }
}
