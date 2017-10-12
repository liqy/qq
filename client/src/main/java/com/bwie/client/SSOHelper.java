package com.bwie.client;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import com.bwie.qq.RemoteSSO;

/**
 * 连接服务
 * Created by liqy on 2017/10/12.
 */

public class SSOHelper {
    private ServiceConnection conn = null;


    public SSOHelper() {
        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                RemoteSSO sso = RemoteSSO.Stub.asInterface(service);

                try {

                    sso.getActivityName();
                    sso.getPackageName();


                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
    }

    private boolean bindRemoteSSOService(Activity activity, String packageName) {
        Context context = activity.getApplicationContext();
        Intent intent = new Intent("com.bwie.qq.remoteservice");
        return context.bindService(intent, conn, Service.BIND_AUTO_CREATE);
    }

    private boolean startSingleSignOn(Activity activity, String applicationId, String permissions,
                                      int activityCode) {

        //启动Activity

        return false;
    }

    /**
     * 处理回调函数
     * @param requestCode
     * @param resultCode
     * @param data
     */
    public void authorizeCallBack(int requestCode, int resultCode, Intent data) {

    }
}
