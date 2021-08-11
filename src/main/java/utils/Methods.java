
package utils;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

public class Methods {
    public static HttpPost getHttpPost(String url,String requestBody, RequestHear requestHear){
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(requestBody, "utf-8");
        httpPost.setEntity(entity);
        httpPost.setHeader(requestHear.getName(), requestHear.getName());
        return httpPost;
    }
}
