package com.nigelwilliams.app.models;

import com.nigelwilliams.app.models.enums.CleaningActivityType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "cleaning_activity")
public class CleaningActivity extends BaseActivity {
    private CleaningActivityType type;
}
