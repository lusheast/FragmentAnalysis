package moocollege.cn.fragmentanalysis;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.List;

/**
 * Created by zsd on 2017/8/10 15:14
 * desc:FragmentManager的操作类
 */

public class FragmentManagerOperator {
    private FragmentManager mFragmentManager;
    private int mContainerId;

    /**
     * 构造函数
     * @param fragmentManager 管理类FragmentManager
     * @param containerId 容器布局ID
     */
    public FragmentManagerOperator(@Nullable FragmentManager fragmentManager, @IdRes int containerId) {
        this.mFragmentManager = fragmentManager;
        this.mContainerId = containerId;
    }

    /**
     * 添加fragment
     * @param fragment
     */
    public void add(Fragment fragment){
        //开启事物
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.add(mContainerId, fragment);
        //提交
        fragmentTransaction.commit();
    }

    public void changeFragment(Fragment fragment){
        // 开启事物
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        // 先隐藏当前所有的Fragment
        List<Fragment> childFragments = mFragmentManager.getFragments();
        for (Fragment childFragment : childFragments) {
            fragmentTransaction.hide(childFragment);
        }

        // 2.如果容器里面没有我们就添加，否则显示
        if(!childFragments.contains(fragment)){
            fragmentTransaction.add(mContainerId,fragment);
        }else{
            fragmentTransaction.show(fragment);
        }
        // 一定要commit
        fragmentTransaction.commit();
    }

}
