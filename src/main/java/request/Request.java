package request;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by sisqualis on 09/11/16.
 */
public class Request {

    private String userAgent = "SimpleRequest/1.0";
    private URL url;
    private HttpURLConnection request;
    private String responseMessage;
    private int responseCode;

    public Request(String url, String metodo) {
        this.url = checkUrl(url);
        try {
            request = (HttpURLConnection) this.url.openConnection();
            request.setRequestMethod(metodo);
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Request(String url) {
        this(url, "GET");
    }

    public Request(String url, String metodo, String userAgent) {
        this(url, metodo);
        this.userAgent = userAgent;
    }

    public void setParametros(HashMap<String, String> parametros) throws IOException {
        OutputStream stream = request.getOutputStream();
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(stream, "UTF-8"));
        writer.write(new QueryString().getQueryParams(parametros));
        writer.flush();
        stream.close();
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    private URL checkUrl(String url) {
        try {
            return new URL(url);
        } catch (MalformedURLException ex) {
            return null;
        }
    }

    public String send() throws IOException {
        this.request.setRequestProperty("User-Agent", getUserAgent());
        this.request.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        return getResponse();
    }

    private String getResponse() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(request.getInputStream(), "ISO-8859-1")
        );
        StringBuffer response = new StringBuffer();
        responseCode = request.getResponseCode();
        responseMessage = request.getResponseMessage();
        String linha;
        while ((linha= reader.readLine()) != null) {
            response.append(linha);
        }
        return response.toString();
    }

}
