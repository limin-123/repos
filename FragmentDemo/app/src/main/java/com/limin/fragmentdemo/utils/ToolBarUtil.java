package com.limin.fragmentdemo.utils;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.limin.fragmentdemo.R;

import java.util.ArrayList;
import java.util.List;

public class ToolBarUtil {
    private List<TextView> mTextView=new ArrayList<TextView>();

    public void createToolBar(LinearLayout container, String[] toolBarTitleArr) {
        for (int i = 0; i < toolBarTitleArr.length; i++) {
            TextView textView = (TextView) View.inflate(container.getContext(), R.layout.bar_buttom, null);
            textView.setText(toolBarTitleArr[i]);
            //动态修改TextView的属性
            int width=0;
            int height=LinearLayout.LayoutParams.MATCH_PARENT;
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(width,height);

            //设置weight属性
            params.weight=1;
            container.addView(textView,params);

            //保存TextView到集合中
            mTextView.add(textView);

            //设置点击事件
            final int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //模块之间传值要用接口回调
                    //3.传值的地方用接口对象调用接口方法
                    mOnToolBarClickListener.OnToolBarClick(finalI);
                }
            });
        }
    }

    public void changeColor(int position){
        //还原所有的颜色
        for(TextView textView:mTextView){
            textView.setSelected(false);
        }
        mTextView.get(position).setSelected(true);  //通过设置selected属性，控制为选中效果
    }

    //1.创建接口方法
    public  interface OnToolBarClickListener{
        void OnToolBarClick(int position);
    }
    //2.定义接口变量
    OnToolBarClickListener mOnToolBarClickListener;

    //4.set一个公共的方法
    public void setmOnToolBarClickListener(OnToolBarClickListener mOnToolBarClickListener) {
        this.mOnToolBarClickListener = mOnToolBarClickListener;
    }
}
