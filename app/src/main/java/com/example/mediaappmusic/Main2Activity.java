package com.example.mediaappmusic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private ArrayList<Music> arrayList;
    private CustomMusicAdapter adapter;
    private ListView songList;
    Animation animation;
    ImageView iv_dvd, iv_dvd1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        anhxadvd();
        animation = AnimationUtils.loadAnimation(this,R.anim.dvd__rotate);

        songList = (ListView) findViewById(R.id.songList);
        arrayList = new ArrayList<>();
        arrayList.add(new Music("Danh cho em","Hoang Ton",R.raw.danh_cho_em));
        arrayList.add(new Music("Hay xem la mot giac mo","Chu Bin",R.raw.hay_xem_giac_mo));
        arrayList.add(new Music("Quen cach yeu","Luong Bich Huu",R.raw.quen_cach_yeu));
        arrayList.add(new Music("Thu cuoi","MR.T",R.raw.thu_cuoi));
        arrayList.add(new Music("Vi mot nguoi ra di","Quang Vinh",R.raw.vi_mot_nguoi_ra_di));

        adapter = new CustomMusicAdapter(this,R. layout.custom_music_item, arrayList);
        songList.setAdapter(adapter);

        iv_dvd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_dvd.startAnimation(animation);
                iv_dvd1.startAnimation(animation);
            }
        });
        iv_dvd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_dvd.startAnimation(animation);
                iv_dvd1.startAnimation(animation);
            }
        });

    }
    private void anhxadvd(){
        iv_dvd1 = (ImageView) findViewById(R.id.ivdvd1);
        iv_dvd = (ImageView) findViewById(R.id.ivdvd);
    }
}
