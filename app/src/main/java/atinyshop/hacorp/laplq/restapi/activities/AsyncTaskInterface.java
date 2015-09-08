package atinyshop.hacorp.laplq.restapi.activities;

/**
 * Created by laplq on 15/09/09.
 */
public interface AsyncTaskInterface {

    public String doInBackground();

    public void onPostExecute(String result);


}
