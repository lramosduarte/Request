package main.java.request;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * Created by sisqualis on 09/11/16.
 */
public class QueryString {

    public String getQueryParams(HashMap<String, String> parametros) {
        StringBuilder queryString = new StringBuilder();
        for (HashMap.Entry<String, String> parametro : parametros.entrySet()) {
            if (parametro != parametros.keySet().toArray()[0])
                queryString.append("&");
            try {
                queryString.append(URLEncoder.encode(parametro.getKey(), "UTF-8"));
                queryString.append(URLEncoder.encode(parametro.getValue(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return queryString.toString();
    }

}
