package atinyshop.hacorp.laplq.restapi.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import atinyshop.hacorp.laplq.restapi.R;
import atinyshop.hacorp.laplq.restapi.restapis.RestApi;
import atinyshop.hacorp.laplq.restapi.restapis.TrackRestApi;


public class TrackListActivity extends BaseActivity {
    TextView listTracks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_list);


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

        new HttpGetAsyncTask().execute();
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
    public String doGetBackground() {

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
    public void onGetExecute(String response)
    {
        listTracks.setText("results: " + response);
       Log.v("mess",response);
    }
}


