package com.example.reemaaziry;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.io.File;
import java.util.ArrayList;

public class CustomGalleryActivity extends AppCompatActivity {

    ArrayList<String> f = new ArrayList<>();//List of file paths
    File[] listFile;
    private String folderName = "MyPhotoDir";
    //Creating object of ViewPager
    ViewPager mViewPager;
    //Creating object of ViewPagerAdapter;
    ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        getFormSdcard();
        //Initializing the ViewPager Object
        mViewPager = findViewById(R.id.viewPagerMain);
        //Initializing the ViewPagerAdapter
        mViewPagerAdapter = new ViewPagerAdapter(this, f);
        //Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPagerAdapter);
    }

    public void getFormSdcard() {
        File file = new File(getExternalFilesDir(folderName), "/");
        if (file.isDirectory()) {
            listFile = file.listFiles();
            for (int i = 0; i < listFile.length; i++) {
                f.add(listFile[i].getAbsolutePath());
            }
        }
    }
}
