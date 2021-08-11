package webapp.servlet;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import utils.Methods;
import utils.RequestHear;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/testcenter")
public class TesterCenter extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestHear requestHear = new RequestHear();
        RequestHear requestHear = new RequestHear("Content-Type", "application/json;charset=utf8");
        System.out.println(req.getParameter("apiUrl"));
        HttpPost httpPost = Methods.getHttpPost(req.getParameter("apiUrl"), req.getParameter("requestBody"), requestHear);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(httpPost);
        System.out.println(response.getEntity().toString());
        String responseString = EntityUtils.toString(response.getEntity());
        resp.setContentType("application/json;charset=utf8");
        resp.setCharacterEncoding("utf-8");
        req.setAttribute("response",responseString);
        req.getRequestDispatcher("/api/result.jsp").forward(req,resp);
//        System.out.println(responseString);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
