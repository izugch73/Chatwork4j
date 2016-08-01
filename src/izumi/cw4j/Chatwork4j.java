package izumi.cw4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import izumi.cw4j.bean.NetMyInfo;

import java.io.IOException;

public class Chatwork4j {

    public static ChatworkRoom createRoom(String token, int roomId){
        return new ChatworkRoom(token, roomId);
    }

    /**
     * 自分自身の情報を取得します。
     * @return
     */
    public static NetMyInfo GetMyInfo(String token) throws IOException {
        return new ObjectMapper().readValue(ChatworkConnection.get("https://api.chatwork.com/v1/me", token), NetMyInfo.class);
    }


}
