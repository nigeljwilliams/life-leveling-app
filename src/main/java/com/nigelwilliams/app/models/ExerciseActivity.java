package com.nigelwilliams.app.models;

import com.nigelwilliams.app.models.enums.ExerciseActivityType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "exercise_activity") // Tells MongoDB to create collection of this name
public class ExerciseActivity extends BaseActivity {
    private ExerciseActivityType type;
}
