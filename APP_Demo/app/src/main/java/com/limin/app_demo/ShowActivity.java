package com.limin.app_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowActivity extends Activity {
    ImageView imageView;
    TextView tv_title, tv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        Intent intent = getIntent();
        /* 第一种方式传值取值 需要有一个实体类*/
        /* IndexBean indexBean = (IndexBean) intent.getSerializableExtra("indexBean");
        String mainStr = indexBean.getMainStr();
        Integer imagesIDs = indexBean.getImagesIDs();
        String TitleStr = indexBean.getTitleStrs();*/

        Bundle bundle = this.getIntent().getExtras();
        String mainStr = bundle.getString("MainStr");
        Integer imagesIDs = bundle.getInt("imagesIDs");
        String TitleStr = bundle.getString("TitleStrs");

        imageView = findViewById(R.id.iv_icon);
        imageView.setImageResource(imagesIDs);

        tv_title = findViewById(R.id.tv_title);
        tv_title.setText(TitleStr);

        tv_title = findViewById(R.id.tv_main);
        tv_title.setText(mainStr);
    }
}
