package atinyshop.hacorp.laplq.restapi.RestApi;

/**
 * Created by dimage01 on 2015/09/01.
 */
public class RestApi {

    final public static int MODULE_GET = 1;
    final public static int MODULE_POST = 2;
    final public static int MODULE_PUT = 3;
    final public static int MODULE_DELETE = 4;

    final public static String  DOMAIN_NAME = "127.0.0.1";


    String URL = "";
    String directory ="";

    String crfs = "";
    String token = "";


    String params = "";
    String results = "";


    public void RestApi(){

        this.URL = DOMAIN_NAME + "/" + directory;

    }

    public  void execute(int module) {

        switch (module) {

            case MODULE_GET:
                onGet();
                break;

            case MODULE_POST:
                onPost();
                break;

            case MODULE_PUT:
                onPut();
                break;
            case MODULE_DELETE:
                onDelete();
                break;

            default:
                break;
        }

    }

    public static String onGet() {

        return "";
    }

    public static String onPost() {

        return "";
    }

    public static String onPut() {

        return "";
    }


    public static String onDelete() {
        return "";
    }


    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }


    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
}
