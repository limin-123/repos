package com.limin.fragmentdemo.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 此类是一个工具类，作用是随时随地都可以调用此类退出整个程序
 */
public class AcitivityCollector {
    //暂存活动
    public static List<Activity> activities=new ArrayList<>();

    //向List中添加一份活动
    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    //从List中移除一个活动
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    //将List中的活动全部销毁掉
    public static void finishAll(){
        for(Activity activity:activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
