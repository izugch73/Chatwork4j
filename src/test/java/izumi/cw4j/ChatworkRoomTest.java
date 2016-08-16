package izumi.cw4j;

/**
 * ChatworkRoom class test
 *
 * Created by dys on 2016/08/16.
 */
public class ChatworkRoomTest extends ChatworkTestBase {
    public ChatworkRoomTest(String name) {
        super(name);
    }

    public void testGetMembers() throws Exception {
        ChatworkRoom room = Chatwork4j.getRoom(chatworkAPI, roomId);
        assertNotNull(room.getMembers());
    }
}
