package demo;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import utils.Methods;
import utils.RequestHear;

import java.io.IOException;
@org.testng.annotations.Test
public class Test {
    public static void test() throws IOException {
        String request = "{\"poiId\":13412802,\"scene\":\"basic\",\"coordinate\":{\"coordinateType\":\"WGS84\",\"latitude\":31.2161077,\"longitude\":121.3427151},\"head\":{\"cid\":\"09031167115414294713\",\"ctok\":\"\",\"cver\":\"1.0\",\"lang\":\"01\",\"sid\":\"8888\",\"syscode\":\"09\",\"auth\":\"\",\"xsid\":\"\",\"extension\":[]}}";
        RequestHear requestHear = new RequestHear("Content-Type", "application/json;charset=utf8");
        HttpPost httpPost = Methods.getHttpPost("https://m.ctrip.com/restapi/soa2/18254/json/getPoiMoreDetail", request, requestHear);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(httpPost);
        System.out.println(response.getEntity().toString());
        String responseString = EntityUtils.toString(response.getEntity());
        System.out.println(responseString);
    }
}
