package com.limin.app_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListActivity extends Activity {

    // 准备数据(文字(9组),图片(9张))
    String[] TitleStrs = new String[]{"抖音视频", "QQ音乐", "腾讯QQ", "腾讯视频", "微信", "口碑", "微博", "BILIBILI", "小红书"};
    String[] MainStr = new String[]{"抖音生活，记录你的美好时光", "QQ音乐，倾听你内心最美好的声音", "腾讯QQ，让你的朋友广遍天下", "腾讯视频，让你体验不一样的影视世界", "微信，打开另一个世界的大门", "口碑，让你的生活更加多姿多彩", "微博，让你第一时间了解各个地方的奇闻异事", "BILIBILI,让你追到更多的动漫，畅游在动漫世界里", "小红书，总能让你发现你想不到的秘密"};
    private int[] imagesIDs = new int[]{R.drawable.douyin, R.drawable.qqmuzic, R.drawable.tenxunqq, R.drawable.tenxunsp, R.drawable.weixin, R.drawable.koubei, R.drawable.weibo, R.drawable.bilibili, R.drawable.redbook};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Data_Deal();

        Button login, rigest;
        login = findViewById(R.id.login);
        rigest = findViewById(R.id.rigest);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, LoginActivity.class);
            /*    Bundle bundle=new Bundle();
                bundle.putString("login","login");
                intent.putExtras(bundle);*/
                startActivity(intent);
            }
        });

        rigest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, LoginActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("rigest", "rigest");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    private void Data_Deal() {
        //数据包装
        List<Map<String, Object>> listitems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < TitleStrs.length; i++) {
            Map<String, Object> listitem = new HashMap<String, Object>();
            listitem.put("iv_icon", imagesIDs[i]);
            listitem.put("tv_title", TitleStrs[i]);
            listitem.put("tv_main", MainStr[i]);
            listitems.add(listitem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listitems, R.layout.list_item, new String[]{"iv_icon", "tv_title", "tv_main"}, new int[]{R.id.iv_icon, R.id.tv_title, R.id.tv_main});
        listView = findViewById(R.id.mylist);
        listView.setAdapter(simpleAdapter);
        //绑定事件

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//              Toast.makeText(MainActivity.this, "被单击了" + TitleStrs[position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListActivity.this, ShowActivity.class); //从哪里跳转到哪里去

                /* 第一种方式传值取值 需要有一个实体类*/
                /* IndexBean indexBean = new IndexBean();
                indexBean.setTitleStrs(TitleStrs[position]);
                indexBean.setImagesIDs(imagesIDs[position]);
                indexBean.setMainStr(MainStr[position]);
                intent.putExtra("indexBean", indexBean);
                startActivity(intent);*/

                Bundle bundle = new Bundle();
                bundle.putString("TitleStrs", TitleStrs[position]);
                bundle.putInt("imagesIDs", imagesIDs[position]);
                bundle.putString("MainStr", MainStr[position]);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
