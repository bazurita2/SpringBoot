package ec.edu.espe.skiworkerselector.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Question {
    @Field("positive_emotions")
    private String positive_emotions;
    @Field("negative_emotions")
    private String negative_emotions;
    @Field("time")
    private String time;
    @Field("prediction")
    private String prediction;
}
