package aqcxbom;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;

import com.crackUtil.LogUtils;

/**
 * Created by AqCxBoM on 2017/1/25.
 */

public class KernelUtils {
    public static void doWork(Dialog dlgArg ){
        try{
            if(isNeedContinu(dlgArg.getWindow().getDecorView())){
                dlgArg.setOnKeyListener(new DialogInterface.OnKeyListener() {
                    @Override
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        return i == KeyEvent.FLAG_KEEP_TOUCH_MODE ? true : false;
                    }
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static boolean isNeedContinu(View viewArg){
        boolean bRet = false;
        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        if(stackTraceElements != null && stackTraceElements.length > 0){
            ergodicStackElement(stackTraceElements);
        }
        return bRet;
    }
    /**
       遍历打印栈信息
     */
    public static void ergodicStackElement(StackTraceElement[] stacks){
        String strClassPath = null;
        String strMethodName = null;
        for(int i = 0; i < stacks.length; i++){
            strClassPath = stacks[i].getClassName();
            strMethodName = stacks[i].getMethodName();
            LogUtils.DOLOG("====================================================================");
            LogUtils.DOLOG("Index: " + i + ": " + strClassPath);
            LogUtils.DOLOG(strMethodName);
            LogUtils.DOLOG("====================================================================");
        }
    }
}
