package com.apine.socr.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.apine.socr.loginapp.were_the_magic_happens.I_got_nothing_to_do_sooo_i_did_this.Restdatahelper;
import com.apine.socr.loginapp.were_the_magic_happens.ItemDecoration;

import com.apine.socr.loginapp.were_the_magic_happens.linergridtitle;
import com.apine.socr.loginapp.were_the_magic_happens.menuADP;
import com.apine.socr.loginapp.were_the_magic_happens.menuitemholder;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {
    private RecyclerView restruns;
    private List<menuitemholder> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);
       // new Restdatahelper(this).datafill();
        restruns=(RecyclerView)findViewById(R.id.RESrecy);

        SnapHelper snapHelper = new PagerSnapHelper();
        new Restdatahelper(this).dataget(list);
        RecyclerView.LayoutManager ly = new linergridtitle(this,LinearLayoutManager.HORIZONTAL,true);

        restruns.addItemDecoration(new ItemDecoration(100,100));
        restruns.setLayoutManager(ly);
        snapHelper.attachToRecyclerView(restruns);
        restruns.setAdapter(new menuADP(list));
        restruns.getAdapter().notifyDataSetChanged();

    }
    public void fill(){

        for(int i =0;i<=10;i++){
            list.add(new menuitemholder(i+"rest",R.drawable.ic_launcher_background));

        }


    }
}
