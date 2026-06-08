package app.am_class;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Database {
    static MongoClient client;
    static MongoDatabase database;

    static {
        // 다른 static 메서드 호출 전 미리 실행하고 싶은 부분
        String uri = "mongodb://127.0.0.1:27017";
        client = MongoClients.create(uri);
        database = client.getDatabase("todo_db");
    }

    public static MongoDatabase getDatabase() {
        return database;
    }

    public static void close() {
        client.close(); // 몽고DB 서버와 연결 끊기. close 이후 crud 작업 불가
    }

    public static MongoCollection<Document> getCollection(String colName) {
        MongoCollection<Document> collection = database.getCollection(colName);
        return collection;
    }
}
