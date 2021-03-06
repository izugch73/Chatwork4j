package izumi.cw4j;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import izumi.cw4j.bean.NetRoomTask;
import izumi.cw4j.bean.NetRoomMember;
import izumi.cw4j.bean.NetMessage;
import izumi.cw4j.bean.NetSendMessage;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by izumi on 2016/08/01.
 */
public class ChatworkRoom {

    private String token;
    private int roomId;

    private static final String TO_MESSAGE_FORMAT = "[To:%s]\n%s";
    private static final String REPLY_MESSAGE_FORMAT = "[rp aid=%s to=%s-%s]\n%s";
    private static final String INFO_MESSAGE_FORMAT = "[info]%s[/info]";
    private static final String INFO_MESSAGE_FORMAT_WITH_TITLE = "[info][title]%s[/title]%s[/info]";

    protected ChatworkRoom(String token, int roomId) {
        this.token = token;
        this.roomId = roomId;
    }


    /**
     * この部屋のメンバ一覧を取得します。
     *
     * @return
     */
    public List<NetRoomMember> getMembers() throws IOException {
        String json = ChatworkConnection.get("https://api.chatwork.com/v1/rooms/" + this.roomId + "/members", token);
        if (json.isEmpty()) return Collections.emptyList();
        return new ObjectMapper().readValue(json, new TypeReference<List<NetRoomMember>>() {
        });
    }

    /**
     * この部屋にメッセージを送信します。
     *
     * @param message
     * @return
     * @throws IOException
     */
    public NetSendMessage sendMessage(String message) throws IOException {
        Map<String, String> msgMap = new HashMap<>();
        msgMap.put("body", message);
        String json = ChatworkConnection.post("https://api.chatwork.com/v1/rooms/" + this.roomId + "/messages", token, msgMap);
        return new ObjectMapper().readValue(json, NetSendMessage.class);
    }

    /**
     * この部屋にInformationとしてタイトル付きのメッセージを送信します。
     *
     * @param title
     * @param message
     * @return
     * @throws IOException
     */
    public NetSendMessage sendInformationMessage(String title, String message) throws IOException {
        String infoMsg = title == null ? String.format(INFO_MESSAGE_FORMAT, message) : String.format(INFO_MESSAGE_FORMAT_WITH_TITLE, title, message);
        return sendMessage(infoMsg);
    }

    /**
     * この部屋にInformationとしてメッセージを送信します。
     *
     * @param message
     * @return
     * @throws IOException
     */
    public NetSendMessage sendInformationMessage(String message) throws IOException {
        return sendInformationMessage(null, message);
    }

    /**
     * メッセージ一覧を取得します。未読のみか、未読にかかわらず100件取得かを選択できます。
     *
     * @param isUnreadOnly true:未読メッセージのみ取得<br/>false:未読かどうかにかかわらず最新から100件取得
     * @return 未読もしくは過去ログが全くがない場合、空配列を返します。
     * @throws IOException
     */
    public List<NetMessage> getMessages(boolean isUnreadOnly) throws IOException {
        String url = "https://api.chatwork.com/v1/rooms/" + this.roomId + "/messages?force=" + (isUnreadOnly ? 0 : 1);
        String json = ChatworkConnection.get(url, token);
        if (json.isEmpty()) return Collections.emptyList();
        return new ObjectMapper().readValue(json, new TypeReference<List<NetMessage>>() {
        });
    }

    /**
     * 自分へのリプライ付きのメッセージ一覧を取得します。未読のみか、未読にかかわらず100件取得かを選択できます。
     *
     * @param isUnreadOnly true:未読メッセージのみ取得<br/>false:未読かどうかにかかわらず最新から100件取得
     * @param myAccountId  このIDへのリプライもしくはToを検索します
     * @return 未読もしくは過去ログが全くがない場合、空配列を返します。
     * @throws IOException
     */
    public List<NetMessage> getReplyOrToMessages(boolean isUnreadOnly, int myAccountId) throws IOException {
        return getMessages(isUnreadOnly).stream()
                .filter(m -> m.getBody().contains("[To:" + myAccountId + "]") ||
                        m.getBody().contains("[rp aid=" + myAccountId))
                .collect(Collectors.toList());
    }

    /**
     * ルームIDを返します。
     *
     * @return
     */
    public int getRoomId() {
        return roomId;
    }
}
