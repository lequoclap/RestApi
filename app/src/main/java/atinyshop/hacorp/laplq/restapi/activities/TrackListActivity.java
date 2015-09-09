package atinyshop.hacorp.laplq.restapi.activities;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;

import atinyshop.hacorp.laplq.restapi.R;
import atinyshop.hacorp.laplq.restapi.RestApi.RestApi;
import atinyshop.hacorp.laplq.restapi.RestApi.TrackRestApi;


public class TrackListActivity extends BaseActivity {
    TextView listTracks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_list);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


         listTracks = (TextView) findViewById(R.id.list_tracks);

//        TrackRestApi restApi = new TrackRestApi();

//        try {
//            restApi.execute(RestApi.METHOD_GET);
//        } catch (Exception e) {
//
//            Log.v("except", e.toString());
//        }

//        String response = restApi.getResponse();
//        String response = GET(restApi.getURL());

//        listTracks.setText("results: " + response);

//        new HttpAsyncTask().execute(restApi.getURL());

        new HttpAsyncTask().execute();
    }


    public static String GET(String url) {
        InputStream inputStream = null;
        String result = "";
        try {

            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // convert inputstream to string
            if (inputStream != null)
                result = RestApi.convertStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.v("InputStream", e.getLocalizedMessage());
        }

        return result;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_track_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public String doBackground() {

        TrackRestApi restApi = new TrackRestApi();

        try {
            restApi.execute(RestApi.METHOD_GET);
        } catch (Exception e) {

            Log.v("except", e.toString());
        }

        String response = restApi.getResponse();
        return response;

    }

    @Override
    public void onExecute(String response)
    {
        listTracks.setText("results: " + response);

//       Log.v("mess",response);

    }
}


