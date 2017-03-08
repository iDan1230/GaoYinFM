package com.bella.fm.framwork.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;


/**
 *  * author：zipingfang on 2016/10/18 08:40
 *  * function: 通知栏
 *  
 */

public class NotifiUtil {

    public Context context;

    public Notification notification;
    public NotificationManager notificationManager;


    public static NotifiUtil notifi;
    private NotifiUtil(Context context){
        this.context = context;



    }

    public static NotifiUtil getInstance(Context context){

        if (notifi == null)
            notifi = new NotifiUtil(context);
        return notifi;
    }

    /**
     *
     * @param title 通知栏的标题
     * @param text 通知的内容
     * @param icon 通知栏的图标
     * @param activityClass 点击通知栏跳转的Activity
     */
    public void initNotifi(String title, String text, int icon, Class activityClass) {
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        builder.setContentTitle(title);
        builder.setContentText(text);
//        builder.setColor(context.getResources().getColor(R.color.title_green));
        builder.setContentIntent(getIntent(activityClass));//点击跳转
        builder.setTicker("通知来了！");
        builder.setWhen(System.currentTimeMillis());
        builder.setSmallIcon(icon);


        notification = builder.build();
        notification.flags= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(0,notification);
    }
    /*
    * 第三步：对Builder进行配置：
    * mBuilder.setContentTitle("测试标题 测试标题")
    * // 设 置 通 知 栏 标 题
    * .setContentText("测试内容 测试内容") // 设 置 通 知 栏 显 示 内 容
    * .setContentIntent(getDefalutIntent()) // 设 置 通 知 栏 点 击 意 图        //
    * .setNumber(number) // 设 置 通 知 集 合 的 数 量
    * .setTicker("测试通知来啦 测试通知来啦") // 通 知 首 次 出 现 在 通 知 栏 ， 带 上 升 动 画 效 果 的
      * .setWhen(System .currentTimeMillis())// 通 知 产 生 的 时 间 ， 会 在 通 知 信 息 里 显 示 ， 一 般 是 系 统 获 取 到 的 时 间
      * .setPriority(Notification.PRIORITY_DEFAULT) // 设 置 该 通 知 优 先 级        //
      * .setAutoCancel(true)// 设 置 这 个 标 志 当 用 户 单 击 面 板 就 可 以 让 通 知 将 自 动 取 消
      * .setOngoing(false)//ture ， 设 置 他 为 一 个 正 在 进 行 的 通 知 。 他 们 通 常 是 用 来 表 示 一 个 后 台 任 务 , 用 户 积 极 参 与 ( 如 播 放 音 乐 ) 或 以 某 种 方 式 正 在 等 待 , 因 此 占 用 设 备 ( 如 一 个 文 件 下 载 , 同 步 操 作 , 主 动 网 络 连 接 )
      * .setDefaults(Notification.DEFAULT_VIBRATE)// 向 通 知 添 加 声 音 、 闪 灯 和 振 动 效 果 的 最 简 单 、 最 一 致 的 方 式 是 使 用 当 前 的 用 户 默 认 设 置 ， 使 用 defaults 属 性 ， 可 以 组 合        //Notificati
      * llIcon(R.drawable.ic_launcher);// 设 置 通 知 小 ICON
      * */

    private PendingIntent getIntent(Class activityClass) {
        Intent intent = new Intent(context, activityClass);
        PendingIntent pendIntent = PendingIntent.getActivity(context,0,intent,0);
        return pendIntent;
    }
}
