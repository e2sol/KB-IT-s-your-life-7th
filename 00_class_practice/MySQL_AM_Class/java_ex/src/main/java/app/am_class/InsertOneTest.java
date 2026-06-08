package app.am_class;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;

public class InsertOneTest {
    public static void main(String[] args) {
        // Database 클래스 작성 시 static { }이 실행 > db 서버 연결 및 db연결이 준비됨
        MongoCollection<Document> collection = Database.getCollection("todo");
        System.out.println("3. todo 컬렉션 연결 성공");

        // CRUD 작업 중 create(insert)
        // 몽고DB는 json 형태의 Document를 insert
        // Document(json)을 먼저 생성 후 컬렉션에 insert
        Document document = new Document(); // Document 생성 { }
        document.append("title", "MongoDB"); // { "title" : "MongoDB" }
        document.append("desc", "MongoDB 공부하기"); // { "title" : "MongoDB", "desc" : "MongoDB 공부하기" }
        document.append("done", false); // { "title" : "MongoDB", "desc" : "MongoDB 공부하기", "done" : false }

        InsertOneResult result = collection.insertOne(document);
        System.out.println("4. document insert 몽고DB로 전달");
        System.out.println("5. insert후 결과" + result);
        System.out.println("==> InsertOneResult : " + result.getInsertedId());
        Database.close();
    }
}
