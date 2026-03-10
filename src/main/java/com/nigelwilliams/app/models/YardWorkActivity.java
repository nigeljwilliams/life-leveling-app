package com.nigelwilliams.app.models;

import com.nigelwilliams.app.models.enums.YardWorkActivityType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "yard_work_activity")
public class YardWorkActivity extends BaseActivity {
    private YardWorkActivityType type;
}
