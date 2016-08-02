package izumi.cw4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import izumi.cw4j.bean.NetContact;
import izumi.cw4j.bean.NetMe;

import java.io.IOException;

public class Chatwork4j {

    public static ChatworkRoom createRoom(String token, int roomId){
        return new ChatworkRoom(token, roomId);
    }

    /**
     * 自分自身の情報を取得します。
     * @param token
     * @return
     */
    public static NetMe getMe(String token) throws IOException {
        return new ObjectMapper().readValue(ChatworkConnection.get("https://api.chatwork.com/v1/me", token), NetMe.class);
    }

    /**
     * 自分のコンタクト一覧を取得します。
     * @param token
     * @return
     * @throws IOException
     */
    public static NetContact[] getContacts(String token) throws IOException {
        return new ObjectMapper().readValue(ChatworkConnection.get("https://api.chatwork.com/v1/contacts", token), NetContact[].class);
    }



}
