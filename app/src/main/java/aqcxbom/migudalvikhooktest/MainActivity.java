package aqcxbom.migudalvikhooktest;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.crackUtil.LogUtils;

import aqcxbom.Alert;

public class MainActivity extends AppCompatActivity {
    private static Button btnPay;
    private static Button btnHook;
    public static Context context;
    public static Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        mActivity = this;
        btnPay = (Button) findViewById(R.id.btnPay);
        btnHook = (Button) findViewById(R.id.btnHook);
        btnHook.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                LogUtils.DOLOG("btnHook Click!");
            }
        });
        btnPay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Alert dialog = new Alert(context);
                dialog.setTitle("支付窗口");
            }
        });
    }
}
