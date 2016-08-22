package izumi.cw4j;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by izumi on 2016/08/01.
 */
public class ChatworkConnection {

    protected static String get(String urlString, String token) throws IOException {
        HttpGet method = new HttpGet(urlString);
        HttpResponse response = createChatworkClient(token).execute(method);

        return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
    }

    protected static String post(String urlString, String token, Map<String, String> header) throws IOException {
        HttpPost method = new HttpPost(urlString);
        List<NameValuePair> requestParams = header.entrySet().stream()
                .map(e -> new BasicNameValuePair(e.getKey(), e.getValue()))
                .collect(Collectors.toList());

        method.setEntity(new UrlEncodedFormEntity(requestParams));
        HttpResponse response = createChatworkClient(token).execute(method);

        return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
    }

    private static HttpClient createChatworkClient(String token) {
        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader("X-ChatWorkToken", token));

        return HttpClientBuilder.create()
                .setDefaultHeaders(headers)
                .build();
    }
}
