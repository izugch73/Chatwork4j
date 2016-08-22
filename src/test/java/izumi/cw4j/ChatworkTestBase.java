package izumi.cw4j;

import junit.framework.TestCase;

import java.io.InputStream;
import java.util.Properties;

/**
 * base class to prepare to call the Chatwork API before the test
 * <p>
 * Created by dys on 2016/08/16.
 */
public class ChatworkTestBase extends TestCase {
    public ChatworkTestBase(String name) {
        super(name);
    }

    protected String chatworkAPI;
    protected int roomId;

    protected final Properties p = new Properties();

    protected void setUp() throws Exception {
        super.setUp();

        InputStream is = ChatworkTestBase.class.getResourceAsStream("/test.properties");
        p.load(is);
        is.close();

        chatworkAPI = p.getProperty("chatworkAPI");
        roomId = Integer.parseInt(p.getProperty("roomId"));
    }

    // to avoid no tests found exception
    public void testDummy() {
    }
}
