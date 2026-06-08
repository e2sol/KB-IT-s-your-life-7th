package app.sec02;

import app.sec01.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsertManyTest2 {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("study");
        List<Document> list = new ArrayList<>();

        for (int i = 10; i < 21; i++) {
            Document doc = new Document();
            doc.append("name", "user_"+i);
            doc.append("age", i);
            doc.append("created", new Date());
            list.add(doc);
        }

        InsertManyResult result = collection.insertMany(list);
        System.out.println("InsertManyResult2 : " + result.getInsertedIds());

        Database.close();
    }
}
