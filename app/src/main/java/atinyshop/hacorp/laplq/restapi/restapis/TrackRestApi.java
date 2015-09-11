package atinyshop.hacorp.laplq.restapi.restapis;

/**
 * Created by laplq on 15/09/06.
 */
public class TrackRestApi extends RestApi {


//    final public static String DIRECTORY = "tracks";
    final public static String DIRECTORY = "NewDjango";

    public TrackRestApi(){

        directory = DIRECTORY;
        super.RestApi();
        init();
    }

    public void init(){

        addParam("name","laplq");

    }



}
