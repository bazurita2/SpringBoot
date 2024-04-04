package ec.edu.espe.skiworkerselector.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

@Data
@Document("Interview")
public class Interview {
    @Id
    private String _id;
    @Field(name = "key")
    private String key;
    @Field(name = "name")
    private String name;
    @Field(name = "questions")
    private ArrayList<Question> questions;
    @Field(name = "result")
    private String result;
    @Field(name = "date_start")
    private String date_start;
    @Field(name = "date_finish")
    private String date_finish;
}
