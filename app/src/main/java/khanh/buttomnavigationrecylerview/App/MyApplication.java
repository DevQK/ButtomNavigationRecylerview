package khanh.buttomnavigationrecylerview.App;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MyApplication extends Application {
    public static final String TAG = MyApplication.class.getCanonicalName();
    private RequestQueue mRequesQueue;
    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
    }
    public static synchronized MyApplication getmInstance(){
        return mInstance;
    }

    public RequestQueue getmRequesQueue() {
        if (mRequesQueue == null)
            mRequesQueue = Volley.newRequestQueue(getApplicationContext());
        return mRequesQueue;
    }
    public <T> void addToRequesQueu(Request<T> req, String tag){
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getmRequesQueue().add(req);
    }
    public <T> void addToRequestQueue(Request<T> req){
        req.setTag(TAG);
        getmRequesQueue().add(req);
    }
    public void cancelPendingRequests(Object tag) {
        if (mRequesQueue != null) {
            mRequesQueue.cancelAll(tag);
        }
    }
}
