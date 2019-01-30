package com.example.vinay.fragmentapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }
    public void Fragment_Selection(View v)
    {
        Fragment fragment=new FirstFragment();
        if(v.getId()==R.id.first)
            fragment=new FirstFragment();
        else
        if(v.getId()==R.id.second)
            fragment=new SecondFragment();

        FragmentManager manager=getSupportFragmentManager();

        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.fragment,fragment);
        transaction.commit();
    }
}
