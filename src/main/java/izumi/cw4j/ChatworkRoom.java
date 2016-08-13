package izumi.cw4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import izumi.cw4j.bean.NetRoomTask;
import izumi.cw4j.bean.NetRoomMember;
import izumi.cw4j.bean.NetMessage;
import izumi.cw4j.bean.NetSendMessage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by izumi on 2016/08/01.
 */
public class ChatworkRoom {

    private String token;
    private int roomId;

    protected ChatworkRoom(String token, int roomId){
        this.token = token;
        this.roomId = roomId;
    }


     /**
     * この部屋のメンバ一覧を取得します。
     * @return
     */
    public NetRoomMember[] getMembers()throws IOException{
        return new ObjectMapper().readValue(ChatworkConnection.get("https://api.chatwork.com/v1/rooms/" + this.roomId + "/members", token), NetRoomMember[].class);
    }

    /**
     * この部屋にメッセージを送信します。
     * @param message
     * @return
     */
    public NetSendMessage sendMessage(String message) throws IOException {
        Map<String, String> msgMap = new HashMap<>();
        msgMap.put("body", message);
        return new ObjectMapper().readValue(ChatworkConnection.post("https://api.chatwork.com/v1/rooms/" + this.roomId + "/messages", token, msgMap), NetSendMessage.class);
    }

    /**
     * メッセージ一覧を取得します。未読のみか、未読にかかわらず100件取得かを選択できます。
     * @param isUnreadOnly true:未読メッセージのみ取得<br/>false:未読かどうかにかかわらず最新から100件取得
     * @return 未読もしくは過去ログが全くがない場合、空配列を返します。
     * @throws IOException
     */
    public NetMessage[] getMessages(boolean isUnreadOnly) throws IOException {
        String url = "https://api.chatwork.com/v1/rooms/" + this.roomId + "/messages?force=" + (isUnreadOnly ? 0 : 1);
        String json = ChatworkConnection.get(url,token);
        if( json.isEmpty() ) return new NetMessage[]{};
        return new ObjectMapper().readValue( json, NetMessage[].class);
    }

    /**
     * ルームIDを返します。
     * @return
     */
    public int getRoomId() {
        return roomId;
    }
}