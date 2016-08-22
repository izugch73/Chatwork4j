package izumi.cw4j;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import izumi.cw4j.bean.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Chatwork4j {

    /**
     * チャットルームを取得します。
     *
     * @param token
     * @param roomId
     * @return
     */
    public static ChatworkRoom getRoom(String token, int roomId) {
        return new ChatworkRoom(token, roomId);
    }

    /**
     * 自分自身の情報を取得します。
     *
     * @param token
     * @return
     */
    public static NetMe getMe(String token) throws IOException {
        String json = ChatworkConnection.get("https://api.chatwork.com/v1/me", token);
        return new ObjectMapper().readValue(json, NetMe.class);
    }

    /**
     * 自分の未読数、未読To数、未完了タスク数を返します。
     *
     * @param token
     * @return
     * @throws IOException
     */
    public static NetStatus getMyStatus(String token) throws IOException {
        String json = ChatworkConnection.get("https://api.chatwork.com/v1/my/status", token);
        return new ObjectMapper().readValue(json, NetStatus.class);
    }

    /**
     * 自分のタスク一覧を取得します。
     *
     * @param token
     * @param assigner タスクを依頼した人のアカウントID
     * @param status
     * @return
     * @throws IOException
     */
    public static List<NetTask> getMyTasks(String token, int assigner, TaskStatus status) throws IOException {
        String url = "https://api.chatwork.com/v1/my/tasks?assigned_by_account_id=" + assigner + "&status=" + status.getValue();
        String json = ChatworkConnection.get(url, token);
        if (json.isEmpty()) return Collections.emptyList();
        return new ObjectMapper().readValue(json, new TypeReference<List<NetTask>>() {
        });
    }

    /**
     * 自分で設定した自分のタスク一覧を取得します。
     *
     * @param token
     * @param status
     * @return
     * @throws IOException
     */
    public static List<NetTask> getMyTasks(String token, TaskStatus status) throws IOException {
        int assigner = getMe(token).getAccount_id();
        String url = "https://api.chatwork.com/v1/my/tasks?assigned_by_account_id=" + assigner + "&status=" + status.getValue();
        String json = ChatworkConnection.get(url, token);
        if (json.isEmpty()) return Collections.emptyList();
        return new ObjectMapper().readValue(json, new TypeReference<List<NetTask>>() {
        });
    }


    /**
     * 自分のコンタクト一覧を取得します。
     *
     * @param token
     * @return
     * @throws IOException
     */
    public static List<NetContact> getContacts(String token) throws IOException {
        String json = ChatworkConnection.get("https://api.chatwork.com/v1/contacts", token);
        if (json.isEmpty()) return Collections.emptyList();
        return new ObjectMapper().readValue(json, new TypeReference<List<NetContact>>() {
        });
    }


    /**
     * @param name                 部屋名。必須
     * @param members_admin_ids    管理者となるユーザのアカウントIDリスト。必須
     * @param members_member_ids   通常メンバとなるユーザのアカウントIDリスト。Null可
     * @param members_readonly_ids 閲覧のみメンバとなるユーザのアカウントIDリスト。Null可
     * @param description          部屋の説明。Null可
     * @param icon                 部屋アイコン。Null可
     * @return
     */
    public int createRoom(String name, List<Integer> members_admin_ids, List<Integer> members_member_ids, List<Integer> members_readonly_ids, String description, ChatworkIcon icon) {
        return 0;
    }


    /**
     * タスク取得用列挙型
     */
    public enum TaskStatus {

        OPEN("open"),
        DONE("done");

        private String status;

        TaskStatus(String value) {
            this.status = value;
        }

        public String getValue() {
            return this.status;
        }
    }

    /**
     * アイコン用列挙型
     */
    public enum ChatworkIcon {

        group, check, document, meeting, event, project, business, study, security,
        star, idea, heart, magcup, beer, music, sports, travel

    }


}

