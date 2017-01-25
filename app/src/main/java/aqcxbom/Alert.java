package aqcxbom;

/**
 * Created by AqCxBoM on 2017/1/25.
 */

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

import aqcxbom.migudalvikhooktest.R;

public class Alert extends Dialog{
    private static Context mContext;
    private static Button payBtn;
    private static EditText etVerifyCode;
    private static Dialog dialog;
    public Alert(Context context) {
        super(context);
        //设置dialog的界面
        mContext = context;
        dialog = this;
        setCoustomView();
        payBtn = (Button) dialog.findViewById(R.id.pay_btn2);
        etVerifyCode = (EditText) dialog.findViewById(R.id.etVerifyCode);
        payBtn.setOnClickListener(new android.view.View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "支付结果: " + etVerifyCode.getText(), Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });
    }
    public void setCoustomView(){
        LinearLayout linearLayout = new LinearLayout(mContext);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        View view  =  View.inflate(mContext, R.layout.btn_lly, null);
        linearLayout.addView(view,params);
        setContentView(linearLayout);
        show();
    }
    /**
     * 重写改方法使外部调用时不会破坏控件的视图
     */
    @Override
    public void setContentView(View view) {
        super.setContentView(view);
    }
    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }
    @Override
    public void setTitle(int titleId) {
        super.setTitle(titleId);
    }
    public void setMessage(String msg){}
}