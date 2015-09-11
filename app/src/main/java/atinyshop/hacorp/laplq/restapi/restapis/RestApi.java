package atinyshop.hacorp.laplq.restapi.restapis;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by dimage01 on 2015/09/01.
 */
public class RestApi {

    final public static int METHOD_GET = 1;
    final public static int METHOD_POST = 2;
    final public static int METHOD_PUT = 3;
    final public static int METHOD_DELETE = 4;

    final public static String  DOMAIN_NAME = "http://172.16.120.121:8000";
//    final public static String  DOMAIN_NAME = "http://127.0.0.0:8000/api";
//    final public static String  DOMAIN_NAME = "http://8tracks.com";


    String URL = "";
    String directory ="";

    String crfs = "";
    String token = "";

    ArrayList <NameValuePair> params = new ArrayList<NameValuePair>();
    ArrayList<NameValuePair> headers = new ArrayList<NameValuePair>();


    String response = "";

    int responseCode;
    String message;


    public void RestApi(){

        this.URL = DOMAIN_NAME + "/" + directory;

    }

    public  void execute(int method) throws Exception {

        switch (method) {

            case METHOD_GET:
                onGet();
                break;

            case METHOD_POST:
                onPost();
                break;

            case METHOD_PUT:
                onPut();
                break;
            case METHOD_DELETE:
                onDelete();
                break;

            default:
                break;
        }

    }

    public static String GET(String url){
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
            if(inputStream != null)
                result = convertStreamToString(inputStream);
            else

                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }


    public  void onGet() {



            HttpGet request = new HttpGet(this.URL);

            //adding params to header
            for (NameValuePair h : headers) {
                request.addHeader(h.getName(), h.getValue());
            }
            executeRequest(request, this.URL);


    }

    public  void onPost() throws UnsupportedEncodingException {
        HttpPost request = new HttpPost(this.URL);
        //adding params to header
        for(NameValuePair h : headers ){
            request.addHeader(h.getName(),h.getValue());
        }
        if(!params.isEmpty()){
            request.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
        }

        executeRequest(request,this.URL);

    }

    public  void onPut() throws UnsupportedEncodingException {
        HttpPut request = new HttpPut(this.URL);

         //adding params to header
        for(NameValuePair h : headers ){
            request.addHeader(h.getName(),h.getValue());
        }
        if(!params.isEmpty()){
            request.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
        }

        executeRequest(request,this.URL);

    }


    public  void onDelete() {

        HttpDelete request = new HttpDelete(this.URL);

        //adding params to header
        for(NameValuePair h : headers ){
            request.addHeader(h.getName(),h.getValue());
        }

        executeRequest(request, URL);


    }

    private void executeRequest(HttpUriRequest request, String url)
    {
        HttpClient client = new DefaultHttpClient();

        HttpResponse httpResponse;

        try {
            httpResponse = client.execute(request);
            responseCode = httpResponse.getStatusLine().getStatusCode();
            message = httpResponse.getStatusLine().getReasonPhrase();

            HttpEntity entity = httpResponse.getEntity();

            if (entity != null) {

                InputStream instream = entity.getContent();
                response = convertStreamToString(instream);

                // Closing the input stream will trigger connection release
                instream.close();
            }

        } catch (ClientProtocolException e)  {
            client.getConnectionManager().shutdown();
            e.printStackTrace();
        } catch (IOException e) {
            client.getConnectionManager().shutdown();
            e.printStackTrace();
        }
    }


    public void addParam(String name, String value)
    {
        params.add(new BasicNameValuePair(name, value));
    }

    public void addHeader(String name, String value)
    {
        headers.add(new BasicNameValuePair(name, value));
    }


    public static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }


    public String getResponse() {
        return response;
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
