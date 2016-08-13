package izumi.cw4j;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by izumi on 2016/08/01.
 */
public class ChatworkConnection {


    protected static String get(String urlString, String token){

        try {
            URL e = new URL(urlString);
            java.net.URLConnection uc = e.openConnection();
            uc.setDoOutput(true);
            uc.setRequestProperty("X-ChatWorkToken", token);
            InputStream is = uc.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String s;
            String str = "";
            for(; (s = reader.readLine()) != null; str = str + s + "\n") {
                System.out.println(s);
            }

            reader.close();
            return str;
        } catch (MalformedURLException mue) {
            return "Invalid URL format: " + urlString;
        } catch (IOException ioe) {
            return "Can\'t connect to " + urlString;
        }


    }

    protected static  String post(String urlString, String token, Map<String,String> header){

        try {
            URL e = new URL(urlString);
            java.net.URLConnection uc = e.openConnection();
            uc.setDoOutput(true);
            uc.setRequestProperty("X-ChatWorkToken", token);
            OutputStream os = uc.getOutputStream();
            PrintStream ps = new PrintStream(os);

            header.forEach((key, val) -> {
                try {
                    String postStr = key + "=" + URLEncoder.encode(val, "UTF-8");
                    ps.print(postStr);
                } catch(UnsupportedEncodingException uee) {
                    //
                }
            });

            ps.close();
            InputStream is = uc.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String s;
            String str = "";
            for(; (s = reader.readLine()) != null; str = str + s + "\n") {
                System.out.println(s);
            }

            reader.close();

            return str;

        } catch (MalformedURLException mue) {
            return "Invalid URL format: " + urlString;
        } catch (IOException ioe) {
            return "Can\'t connect to " + urlString;
        }
    }

}
