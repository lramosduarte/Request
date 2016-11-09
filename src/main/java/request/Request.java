package main.java.request;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by sisqualis on 09/11/16.
 */
public class Request {

    private String userAgent = "SimpleRequest/1.0";
    private URL url;
    private HttpURLConnection request;

    public Request(String url, String metodo) {
        this.url = checkUrl(url);
        try {
            request.setRequestMethod(metodo);
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setRequestProperty("User-Agent", getUserAgent());
        request.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
    }

    public Request(String url, String metodo, String userAgent) {
        this(url, metodo);
        this.userAgent = userAgent;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public URL checkUrl(String url) {
        try {
            return new URL(url);
        } catch (MalformedURLException ex) {
            return null;
        }
    }

}
