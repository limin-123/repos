package com.limin.fragmentdemo.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.limin.fragmentdemo.R;
import com.limin.fragmentdemo.fragment.FirstFragment;
import com.limin.fragmentdemo.fragment.ForthFragment;
import com.limin.fragmentdemo.fragment.SecondFragment;
import com.limin.fragmentdemo.fragment.thredFragment;
import com.limin.fragmentdemo.utils.ToolBarUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    Button left_btn, right_btn;
    TextView bar_title;
    LinearLayout bar_list, title_bacg;
    ViewPager mMainViewpager;
    ToolBarUtil mtoolBarUtil;
    String[] mtoolBarTitleArr;
    private List<Fragment> mFragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//设置菜单选项列表
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "你点击的第1个菜单选项", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "你点击的第2个菜单选项", Toast.LENGTH_SHORT).show();
                break;
            case R.id.login_item:
                Toast.makeText(this, "你点击的第3个菜单选项", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }


    private void Init_Assembly() {    //初始化组件
        left_btn = findViewById(R.id.left_btn);
        right_btn = findViewById(R.id.right_btn);
        bar_title = findViewById(R.id.bar_title);
        bar_list = findViewById(R.id.bar_list);
        mMainViewpager = findViewById(R.id.viewpage);
        title_bacg = findViewById(R.id.title_bacg);
    }

    private void initData() {
        //添加fragment到集合中
        mFragments.add(new FirstFragment());
        mFragments.add(new SecondFragment());
        mFragments.add(new thredFragment());
        mFragments.add(new ForthFragment());

        mMainViewpager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        //底部按钮
        mtoolBarUtil = new ToolBarUtil();

        //文字内容
        mtoolBarTitleArr = new String[]{"微信", "朋友", "通信", "我的"};

        //设置默认选中第一个fragment
        mtoolBarUtil.changeColor(0);

        //修改title背景颜色
        // title_bacg.setBackground(mFragments.get(0).getView().getBackground());

    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }

}
