import org.junit.Assert;
import org.junit.Test;
import request.QueryString;

import java.util.HashMap;

/**
 * Created by sisqualis on 09/11/16.
 */
public class QueryStringTest {

    @Test
    public void getOneParam() {
        HashMap<String, String> parametros = new HashMap<>();
        parametros.put("foo", "bar");
        Assert.assertEquals(new QueryString().getQueryParams(parametros), "foo=bar");
    }

    @Test
    public void getMultiplesParams() {
        HashMap<String, String> parametros = new HashMap<>();
        parametros.put("foo", "bar");
        parametros.put("foo1", "bar");
        parametros.put("foo11", "bar");
        parametros.put("foo111", "bar");
        Assert.assertEquals(new QueryString().getQueryParams(parametros),
                "foo111=bar&foo=bar&foo11=bar&foo1=bar");
    }

}
