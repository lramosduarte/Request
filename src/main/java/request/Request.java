package main.java.request;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by sisqualis on 09/11/16.
 */
public class Request {

    private String userAgent = "SimpleRequest/1.0";
    private URL url;
    private HttpURLConnection request;

    public Request(String url) {
        this.url = checkUrl(url);
    }

    public Request(String url, String userAgent) {
        this(url);
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
