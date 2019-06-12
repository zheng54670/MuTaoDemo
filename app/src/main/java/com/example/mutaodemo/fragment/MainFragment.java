package com.example.mutaodemo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mutaodemo.R;
import com.example.mutaodemo.adapter.MainHeaderADAdapter;
import com.example.mutaodemo.adapter.MainMenuAdapter;
import com.example.mutaodemo.adapter.SubMenuAdapter;
import com.example.mutaodemo.util.DataUtil;


/**
 * 主界面视图
 */
public class MainFragment extends Fragment {

    private ViewPager viewPagerHeaderAD;//广告头部
    private int[] icons = {R.mipmap.header_pic_ad1, R.mipmap.header_pic_ad2, R.mipmap.header_pic_ad1};

    private RecyclerView recyclerView;//主菜单
    private int[] menuIcons = {R.mipmap.menu_airport, R.mipmap.menu_hatol,
            R.mipmap.menu_trav, R.mipmap.menu_nearby, R.mipmap.menu_ticket,
            R.mipmap.menu_train, R.mipmap.menu_course,
            R.mipmap.menu_trav

    };
    String[] menus;

    private RecyclerView subRecyclerView;//二级菜单
    private int[] subMenuIcons = {R.mipmap.menu_second_airport, R.mipmap.menu_second_play,
            R.mipmap.menu_second_quan};
    String[] subMenus;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        menus = this.getActivity().getResources().getStringArray(R.array.main_menu);
        subMenus = this.getActivity().getResources().getStringArray(R.array.sub_menu);
        viewPagerHeaderAD = (ViewPager) getView().findViewById(R.id.viewpager_header_ad);
        recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerview_main_menu);
        subRecyclerView = (RecyclerView) getView().findViewById(R.id.recyclerview_sub_menu);

        MainHeaderADAdapter adapter = new MainHeaderADAdapter(getActivity(), DataUtil.getHeaderAddInfo(getActivity(), icons));
        viewPagerHeaderAD.setAdapter(adapter);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        MainMenuAdapter mainMenuAdapter = new MainMenuAdapter(getActivity(), DataUtil.getMainMenu(menuIcons, menus));
        recyclerView.setAdapter(mainMenuAdapter);

        subRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        SubMenuAdapter subMenuAdapter = new SubMenuAdapter(getActivity(), DataUtil.getSubMenu(subMenuIcons, subMenus));
        subRecyclerView.setAdapter(subMenuAdapter);
    }
}
