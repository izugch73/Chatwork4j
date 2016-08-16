package izumi.cw4j;

import izumi.cw4j.bean.NetSendMessage;

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

    public void testInfoMessage() throws Exception {
        ChatworkRoom room = Chatwork4j.getRoom(chatworkAPI, roomId);
        NetSendMessage info = room.sendInformationMessage("INFO MESSAGE");
        assertNotNull(info.getMessage_id());
    }

    public void testInfoTitleMessage() throws Exception {
        ChatworkRoom room = Chatwork4j.getRoom(chatworkAPI, roomId);
        NetSendMessage titleInfo = room.sendInformationMessage("TITLE MESSAGE","INFO TITLE");
        assertNotNull(titleInfo.getMessage_id());
    }

}
