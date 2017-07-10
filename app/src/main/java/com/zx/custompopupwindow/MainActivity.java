package com.zx.custompopupwindow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CustomPopupWindow customPopupWindow;
    private Button showPopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showPopBtn = (Button) findViewById(R.id.show_pop_btn);
        initPop();

        showPopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示pop
                customPopupWindow.showAtLocation(showPopBtn, Gravity.BOTTOM, 0, 0);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        customPopupWindow.dismiss();
    }

    //初始化PopupWindow
    private void initPop() {
        customPopupWindow = new CustomPopupWindow.Builder(this)
                .setContentView(R.layout.pop_layout)
                .setwidth(LinearLayout.LayoutParams.MATCH_PARENT)
                .setheight(LinearLayout.LayoutParams.WRAP_CONTENT)
                .setAnimationStyle(R.style.anim_popUpWindow_bottom)
                .build();

        customPopupWindow.getItemView(R.id.cancel_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击了取消", Toast.LENGTH_SHORT).show();
                customPopupWindow.dismiss();
            }
        });
    }
}
