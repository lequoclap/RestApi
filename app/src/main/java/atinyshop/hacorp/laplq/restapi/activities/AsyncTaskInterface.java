package atinyshop.hacorp.laplq.restapi.activities;

/**
 * Created by laplq on 15/09/09.
 */
public interface AsyncTaskInterface {

    public String doBackground();

    public void onExecute(String result);


}
