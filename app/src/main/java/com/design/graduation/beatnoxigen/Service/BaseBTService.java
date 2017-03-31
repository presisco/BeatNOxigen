package com.design.graduation.beatnoxigen.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class BaseBTService extends Service {
    public BaseBTService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
