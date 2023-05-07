package ase.dinith.networkcheckerlibrary;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

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

        if(activeNetworkInfo != null && activeNetworkInfo.isConnected()){
            Toast.makeText(activity, "Internet connection detected.",
                    Toast.LENGTH_LONG).show();
        }else{
            openMessage();
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void openMessage(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        // Set the message show for the Alert time
        builder.setMessage("No internet connection. Please check your connection and try again.");

        // Set Alert Title
        builder.setTitle("Alert !");

        // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
        builder.setCancelable(false);

//        // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
//        builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
//            // When the user click yes button then app will close
//            this.finish();
//        });

        // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
        builder.setNegativeButton("OK", (DialogInterface.OnClickListener) (dialog, which) -> {
            // If user click no then dialog box is canceled.
            dialog.cancel();
        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();
        // Show the Alert Dialog box
        alertDialog.show();
    }
}
