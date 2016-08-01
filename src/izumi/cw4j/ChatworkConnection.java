package izumi.cw4j;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

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

    protected static  String post(String urlString, String token, String message){

        try {
            URL e = new URL(urlString);
            java.net.URLConnection uc = e.openConnection();
            uc.setDoOutput(true);
            uc.setRequestProperty("X-ChatWorkToken", token);
            OutputStream os = uc.getOutputStream();
            String postStr = "body=" + URLEncoder.encode(message, "UTF-8");
            PrintStream ps = new PrintStream(os);
            ps.print(postStr);
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
