package izumi.cw4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import izumi.cw4j.bean.*;

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
     * 自分の未読数、未読To数、未完了タスク数を返します。
     * @param token
     * @return
     * @throws IOException
     */
    public static NetStatus getMyStatus(String token) throws IOException {
        return new ObjectMapper().readValue(ChatworkConnection.get("https://api.chatwork.com/v1/my/status", token), NetStatus.class);
    }

    /**
     * 自分のタスク一覧を取得します。
     * @param token
     * @param assigner タスクを依頼した人のアカウントID
     * @param status
     * @return
     * @throws IOException
     */
    public static NetTask[] getMyTasks(String token, int assigner, TaskStatus status) throws IOException {
        String url = "https://api.chatwork.com/v1/my/tasks?assigned_by_account_id=" + assigner + "&status=" + status.getValue();
        String json = ChatworkConnection.get(url, token);
        if( json.isEmpty() ) return new NetTask[]{};
        return new ObjectMapper().readValue(json, NetTask[].class);
    }

    /**
     * 自分で設定した自分のタスク一覧を取得します。
     * @param token
     * @param status
     * @return
     * @throws IOException
     */
    public static NetTask[] getMyTasks(String token, TaskStatus status) throws IOException {
        int assigner = getMe(token).getAccount_id();
        String url = "https://api.chatwork.com/v1/my/tasks?assigned_by_account_id=" + assigner + "&status=" + status.getValue();
        String json = ChatworkConnection.get(url, token);
        if( json.isEmpty() ) return new NetTask[]{};
        return new ObjectMapper().readValue(json, NetTask[].class);
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

    /**
     * タスク取得用列挙型
     */
    public enum TaskStatus {

        OPEN("open"),
        DONE("done");

        private String status;

        TaskStatus(String value){
            this.status = value;
        }

        public String getValue(){
            return this.status;
        }
    }


}

