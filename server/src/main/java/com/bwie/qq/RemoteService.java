package com.bwie.qq;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class RemoteService extends Service {

    public final String action = "com.bwie.qq.remoteservice";

    public RemoteService() {
    }


    RemoteSSO.Stub binder = new RemoteSSO.Stub() {
        /**
         * 返回应用程序包名
         * @return
         * @throws RemoteException
         */
        @Override
        public String getPackageName() throws RemoteException {
            //TODO
            return "com.bwie.qq";
        }

        /**
         * Activity名称
         * @return
         * @throws RemoteException
         */
        @Override
        public String getActivityName() throws RemoteException {
            //TODO
            return "com.bwie.qq.MainActivity";
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}
