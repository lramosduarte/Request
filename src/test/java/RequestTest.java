import org.junit.Assert;
import org.junit.Test;
import request.Request;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by sisqualis on 10/11/16.
 */
public class RequestTest {

    private String url = "https://www.google.com.br";

    @Test
    public void checkUrlValid() {
        Assert.assertNotNull(new Request(url));
    }

    @Test
    public void request() throws IOException {
        Request request = new Request(url);
        String resposta = request.send();
        Assert.assertNotNull(resposta);
        Assert.assertEquals(200, request.responseCode);
        Assert.assertEquals("OK", request.responseMessage);
        Assert.assertTrue(resposta.contains("Fazer login"));
    }

    @Test
    public void requestGet() throws IOException {
        Request request = new Request(url, "GET");
        String resposta = request.send();
        Assert.assertNotNull(resposta);
        Assert.assertTrue(resposta.contains("Fazer login"));
    }

    @Test
    public void requestGetUserAgent() throws IOException {
        Request request = new Request(url, "GET", "Mozila/5.0");
        String resposta = request.send();
        Assert.assertNotNull(resposta);
        Assert.assertTrue(resposta.contains("Fazer login"));
    }

    @Test
    public void requestPost() throws IOException {
        Request request = new Request("http://requestb.in/vly62bvl", "POST");
        String resposta = request.send();
        Assert.assertNotNull(resposta);
        Assert.assertTrue(resposta.contains("ok"));
    }

    @Test
    public void requestPostParams() throws IOException {
        Request request = new Request("http://requestb.in/vly62bvl", "POST");
        HashMap<String, String> parametros = new HashMap<>();
        parametros.put("fizz", "buzz");
        request.setParametros(parametros);
        String resposta = request.send();
        Assert.assertNotNull(resposta);
        Assert.assertTrue(resposta.contains("ok"));
    }

}
