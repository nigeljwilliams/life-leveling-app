package com.nigelwilliams.app.models;

import com.nigelwilliams.app.models.enums.FoodPrepActivityType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "food_prep_activity")
public class FoodPrepActivity extends BaseActivity {
    private FoodPrepActivityType type;
}
