package com.ferhatozcelik.wordfilter;

import android.app.Activity;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class NetworkController {
    private  static Context mcontext;
    private  static NetworkController mInstance;
    private RequestQueue mRequestQueue;

    public NetworkController(Context context) {
        mcontext=context;
        this.mRequestQueue = getRequestQueue();

    }

    public static synchronized  NetworkController getInstance(Activity context){
        NetworkController networkController;
        synchronized (NetworkController.class){
            if (mInstance==null){
                mInstance = new NetworkController(context);

            }
            networkController = mInstance;
        }
        return networkController;
    }

    RequestQueue getRequestQueue() {
        if (this.mRequestQueue==null){
            mRequestQueue = Volley.newRequestQueue(mcontext.getApplicationContext());
        }
        return mRequestQueue;
    }
}
