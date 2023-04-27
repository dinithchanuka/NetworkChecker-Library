package ase.dinith.networkcheckerlibrary;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkChecker {
    private static final String TAG = "NetworkChecker";
    private Activity activity;

    public NetworkChecker(Activity activity) {
        this.activity = activity;
    }

    public boolean getNetworkStatus() {
        Log.d(TAG, "getNetworkStatus: " );
        ConnectivityManager connectivityManager
                = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
