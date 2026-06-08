package app.am_class;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConnectionTest {
    public static void main(String[] args) {
        String uri = "mongodb://127.0.0.1:27017";
        String db = "todo_db";

        // 몽고DB와 Java 연동
        // 몽고DB와 연동할 수 있는 Java 라이브러리가 필요
        // 몽고DB driver 필요

        // 1. 몽고DB 서버 연결 > 외부 자원(네트워크)연결은 반드시 예외 처리
        // -> try-catch-resources(close 자동) 이용
        // 2. 몽고DB 서버의 DB 연결
        // 3. 몽고DB의 Collection 연결
        // 4. Collection에 document(json) crud
        // 5. 몽고DB close
        try (MongoClient client = MongoClients.create(uri)) {
            System.out.println("1. 몽고DB 연결 성공" + client);
            MongoDatabase database = client.getDatabase(db);
            System.out.println("2. 몽고DB 연결(todo_db) 성공" + database);
        } catch (Exception e) {
            System.out.println("연결 중 오류 발생");
            e.printStackTrace();
        }
    }
}
