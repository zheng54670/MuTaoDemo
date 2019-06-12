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
import com.example.mutaodemo.entity.Menu;

import java.util.List;

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuViewholder> {

    private Context context;
    private List<Menu> menus;

    public MainMenuAdapter(Context context, List<Menu> menus) {
        this.context = context;
        this.menus = menus;
    }

    @NonNull
    @Override
    public MainMenuViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MainMenuViewholder(LayoutInflater.from(context).inflate(R.layout.item_main_menu, null));
    }

    @Override
    public void onBindViewHolder(@NonNull MainMenuViewholder mainMenuViewholder, int i) {
        Menu menu = menus.get(i);
        mainMenuViewholder.imageView.setImageResource(menu.icon);
        mainMenuViewholder.textView.setText(menu.menuName);
    }

    @Override
    public int getItemCount() {
        return null != menus ? menus.size() : 0;
    }
}

class MainMenuViewholder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView textView;

    public MainMenuViewholder(@NonNull View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.img_menu_icon);
        textView = (TextView) itemView.findViewById(R.id.txt_menu_name);
    }
}
