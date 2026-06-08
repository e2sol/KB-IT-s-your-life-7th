package app.sec02;

import app.sec01.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class InsertManyTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("study");
        List<Document> documentList = new ArrayList<>();

        Document doc1 = new Document();
        doc1.append("title", "Dune2 영화보기");
        doc1.append("desc", "이번 주말 IMAX로 Dune2 영화보기");
        doc1.append("done", false);
        documentList.add(doc1);

        Document doc2 = new Document();
        doc2.append("title", "Java MongoDB 연동");
        doc2.append("desc", "Java로 MongoDB 연동 프로그래밍 연습하기");
        doc2.append("done", true);
        documentList.add(doc2);

        // 한 번에 insert
        InsertManyResult result = collection.insertMany(documentList);
        System.out.println("InsertManyResult : " + result.getInsertedIds());

        Database.close();
    }
}
