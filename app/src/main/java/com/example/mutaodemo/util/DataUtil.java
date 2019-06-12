package com.example.mutaodemo.util;

import android.content.Context;
import android.widget.ImageView;

import com.example.mutaodemo.entity.Menu;
import com.example.mutaodemo.entity.SubMenu;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class DataUtil {

    /**
     * 头部广告
     *
     * @param context
     * @param icons
     * @return
     */
    public static List<ImageView> getHeaderAddInfo(Context context, int icons[]) {
        List<ImageView> datas = new ArrayList<>();

        for (int i = 0; i < icons.length; i++) {
            ImageView icon = new ImageView(context);
            icon.setScaleType(ImageView.ScaleType.CENTER_CROP);
            icon.setImageResource(icons[i]);
            datas.add(icon);
        }

        return datas;
    }

    /**
     * 主菜单
     *
     * @param icons
     * @param names
     * @return
     */
    public static List<Menu> getMainMenu(int icons[], String names[]) {
        List<Menu> menus = new ArrayList<>();

        for (int i = 0; i < icons.length; i++) {
            Menu menu = new Menu(icons[i], names[i]);
            menus.add(menu);
        }

        return menus;
    }

    /**
     * 二级菜单
     *
     * @param icons
     * @param names
     * @return
     */
    public static List<SubMenu> getSubMenu(int icons[], String names[]) {
        List<SubMenu> subMenus = new ArrayList<>();

        for (int i = 0; i < icons.length; i++) {
            SubMenu subMenu = new SubMenu(icons[i], names[i]);
            subMenus.add(subMenu);
        }
        return subMenus;
    }
}
