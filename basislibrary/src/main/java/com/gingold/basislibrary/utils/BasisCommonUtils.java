package com.gingold.basislibrary.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * 通用方法工具类
 */

public class BasisCommonUtils {

    /**
     * 打电话
     *
     * @param phone 电话号码
     */
    public static void callTel(Context context, String phone) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
        context.startActivity(intent);
    }

    /**
     * 发短信
     *
     * @param phone   电话号码
     * @param message 信息内容
     */
    public static void sendSMS(Context context, String phone, String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phone));
        intent.putExtra("sms_body", message);
        context.startActivity(intent);
    }

    /**
     * 获取异常信息
     *
     * @param e 异常
     */
    public static String getExceptionInfo(Exception e) {
        Writer writer = new StringWriter();
        PrintWriter pw = new PrintWriter(writer);
        e.printStackTrace(pw);
        pw.close();
        String info = writer.toString();
        return info;
    }

    /**
     * 安装本地.apk文件
     */
    public static void installApk(Context context, File apk) {
        if (!apk.exists()) {
            return;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(apk), "application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //安装完后打开开始页面
        context.startActivity(intent);
    }
}
