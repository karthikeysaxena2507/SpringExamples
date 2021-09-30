package SpringArango.entity;

import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Document;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@ToString
@Document("users")
public class User {

    @Id
    private String id;

    @ArangoId
    private String arangoId;

    private String name;
    private String surName;
    private Integer age;

    public User(String name, String surName, Integer age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

}
