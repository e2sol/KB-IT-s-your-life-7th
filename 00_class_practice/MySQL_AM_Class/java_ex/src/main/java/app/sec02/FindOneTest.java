package app.sec02;

import app.sec01.Database;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import static com.mongodb.client.model.Filters.*;
// import static : 클래스명을 생략하고 메소드명만 작성 가능

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class FindOneTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("study");

        // 존재하는 _id
        String id = "6a226e28412cf536ca162645";

        // Filters.eq()
        Bson query = eq("_id", new ObjectId(id));

        // 조건을 만족하는 결과 중 1행(문서 1개)만 조회
        Document result = collection.find(query).first(); // first() 안 붙이면 오류 뜸
        System.out.println("FindById : " + result);

        Database.close();
    }
}
