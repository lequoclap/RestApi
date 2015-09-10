package atinyshop.hacorp.laplq.restapi.activities;

/**
 * Created by laplq on 15/09/09.
 */
public interface AsyncTaskInterface {

    public String doGetBackground();

    public void onGetExecute(String result);


    public String doPutBackground();

    public void onPutExecute(String result);


    public String doPostBackground();

    public void onPostExecute(String result);


    public String doDeleteBackground();

    public void onDeleteExecute(String result);



}
