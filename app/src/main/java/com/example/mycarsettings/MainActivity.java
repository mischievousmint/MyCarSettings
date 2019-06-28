package com.example.mycarsettings;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements NameFragment.OnNameFragmentIntListener, SettingsFragment.OnSettingsFragmentIntListener, FinalFragment.OnFinalFragmentIntListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        Fragment myFragment = new NameFragment();
        FT.add(R.id.frameLayout_container, myFragment);
        FT.commit();

        //Pasamos el contexto

        MySharedPreferences.init(getApplicationContext());

    }

    @Override
    public void btnNextClick(String carName) {
        MySharedPreferences.saveName(carName);

        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        Fragment myNewFragment = new SettingsFragment();
        FT.replace(R.id.frameLayout_container, myNewFragment);
        FT.commit();

    }

    @Override
    public void onNext2Click(String carColor) {
        MySharedPreferences.saveColor(carColor);

        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        Fragment myNew2Fragment = new FinalFragment();
        ((FinalFragment) myNew2Fragment).sendData(MySharedPreferences.loadName(), MySharedPreferences.loadColor());
        FT.replace(R.id.frameLayout_container, myNew2Fragment);
        FT.commit();
    }

    @Override
    public void finalData() {

    }

}
