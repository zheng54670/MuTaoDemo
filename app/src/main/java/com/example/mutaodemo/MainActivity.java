package com.example.mutaodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.mutaodemo.fragment.FindFragment;
import com.example.mutaodemo.fragment.MainFragment;
import com.example.mutaodemo.fragment.MeFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    protected LinearLayout mMenuMain;
    protected LinearLayout mMenuFind;
    protected LinearLayout mMenuMe;

    protected MainFragment mainFragment = new MainFragment();//首页
    protected FindFragment findFragment = new FindFragment();//发现
    protected MeFragment meFragment = new MeFragment();//我的
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        initViews();

        //获取管理类
        this.getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_context,mainFragment)
                .add(R.id.container_context,findFragment)
                .hide(findFragment)
                .add(R.id.container_context,meFragment)
                .hide(meFragment)

        //实物添加 默认：显示首页 其他页面：隐藏
        //提交

                .commit();
    }


    /**
     * 初始化视图
     */
    public void initViews(){
        mMenuMain = (LinearLayout) findViewById(R.id.menu_main);
        mMenuFind = (LinearLayout) findViewById(R.id.menu_find);
        mMenuMe = (LinearLayout) findViewById(R.id.menu_me);

        mMenuMain.setOnClickListener(this);
        mMenuFind.setOnClickListener(this);
        mMenuMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.menu_main://首页
                //获取管理类
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .show(mainFragment)
                        .hide(findFragment)
                        .hide(meFragment)
                        .commit();
                break;
            case R.id.menu_find://发现
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .show(findFragment)
                        .hide(mainFragment)
                        .hide(meFragment)
                        .commit();
                break;
            case R.id.menu_me://我的
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .show(meFragment)
                        .hide(findFragment)
                        .hide(mainFragment)
                        .commit();
                break;
        }
    }
}
