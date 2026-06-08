package app.sec02;

import app.sec01.Database;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Iterator;

public class FindTest {
    public static void main(String[] args) {
        // Database 유틸리티 클래스를 이용해서 study 컬렉션(테이블)
        MongoCollection<Document> collection = Database.getCollection("study");

        FindIterable<Document> result = collection.find();

        // 반복자 형태로 반환
        Iterator<Document> it = result.iterator();

        while (it.hasNext()) { // 다음 행이 있으면 true
            // it.next() : 다음 행(문서) 반환
            System.out.println("FindResultRow : " + it.next());
        }
    }
}
