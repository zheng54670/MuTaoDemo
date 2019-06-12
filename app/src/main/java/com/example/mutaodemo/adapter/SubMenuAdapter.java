package com.example.mutaodemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mutaodemo.R;
import com.example.mutaodemo.entity.SubMenu;

import java.util.List;

public class SubMenuAdapter extends RecyclerView.Adapter<SubMenuViewholder> {

    private Context context;
    private List<SubMenu> subMenus;

    public SubMenuAdapter(Context context, List<SubMenu> subMenus) {
        this.context = context;
        this.subMenus = subMenus;
    }

    @NonNull
    @Override
    public SubMenuViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new SubMenuViewholder(LayoutInflater.from(context).inflate(R.layout.item_sub_menu, null));

    }

    @Override
    public void onBindViewHolder(@NonNull SubMenuViewholder subMenuViewholder, int i) {
        SubMenu subMenu = subMenus.get(i);
        subMenuViewholder.imageView.setImageResource(subMenu.icon);
        subMenuViewholder.textView.setText(subMenu.menuName);
    }

    @Override
    public int getItemCount() {
        return null != subMenus ? subMenus.size() : 0;
    }
}


class SubMenuViewholder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView textView;

    public SubMenuViewholder(@NonNull View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.img_submenu_icon);
        textView = (TextView) itemView.findViewById(R.id.txt_submenu_name);
    }
}