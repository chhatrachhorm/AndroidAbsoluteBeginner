package onenterprise.tra.bindingservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by chhatra on 9/28/2017.
 *
 */

public class MyBoundService extends Service {

    IBinder iBinder = new LocalBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    public class LocalBinder extends Binder {
        public MyBoundService getService(){
            return MyBoundService.this;
        }
    }
    public int add(int a, int b){
        return a + b;
    }
}
