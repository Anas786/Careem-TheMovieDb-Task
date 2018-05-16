package Utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.anas.careemmoviedb.App;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by Anas on 15-May-18.
 */

public class SessionManager {

    // LogCat tag
    private static String TAG = SessionManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    ObjectMapper mapper;
//    private ImageLoader imageLoader;

    public ProgressDialog pDialog;
    public boolean countriesFetched;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "SmartLearnerLogin";

    private static SessionManager mInstance = null;

    private SessionManager(){

        _context = App.getInstance();
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        countriesFetched = false;
    }

    public static SessionManager getInstance(){
        if(mInstance == null)
        {
            mInstance = new SessionManager();
        }
        return mInstance;
    }

    public ObjectMapper getMapper() {

        if (mapper == null){
            mapper = new ObjectMapper();
        }
        return mapper;
    }

    public void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    public void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    public void setDialogMessage(String message){
        pDialog.setMessage(message);
    }


//    public void loadImage2(String url, final NetworkImageView imageView){
//
//        Request<Bitmap> imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
//            @Override
//            public void onResponse(Bitmap response) {
//                imageView.setImageBitmap(response);
//            }
//        }, maxWidth, maxHeight, ImageView.ScaleType.MATRIX, Bitmap.Config.RGB_565, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                imageView.setImageResource(R.drawable.top_logo_white);
//            }
//        });
//        imageRequest.setShouldCache(false);
//        //RequestEntity.getInstance(this).getRequestQueue().add(imageRequest);
//
//        RequestQueue requestQueue = Volley.newRequestQueue(_context);
//        requestQueue.add(imageRequest);
//    }
}
