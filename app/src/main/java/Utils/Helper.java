package Utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by Anas on 15-May-18.
 */

public class Helper {

    public static ProgressDialog dialog;

    public boolean isInternetEnabled(final Context context) {
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm.getActiveNetworkInfo() == null) {
            return false;
        }
        else return true;
    }

    public static void showSpinner(String msg, Context context){
        dialog = new ProgressDialog(context);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage(msg);
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

}
