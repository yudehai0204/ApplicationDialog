package com.commondialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.commondialog.dialog.CommonData;
import com.commondialog.dialog.ToastUtils;

/**
 * Created by 于德海 on 2016/9/8.
 *
 * @version ${VERSION}
 * @decpter
 */
public class ThreeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_text = (TextView) findViewById(R.id.tv_text);
        tv_text.setText("ThreeActivity");
        btn = (Button) findViewById(R.id.go);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CommonData.applicationContext,"已经是最后一个页面了",Toast.LENGTH_SHORT).show();
            }
        });
        btn = (Button) findViewById(R.id.back);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.getInstances().showDialog();
                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(3000);
                                    ThreeActivity.this.finish();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                ).start();
            }
        });
    }
}
