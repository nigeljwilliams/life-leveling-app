package com.nigelwilliams.app.models;

import com.nigelwilliams.app.models.enums.HygieneActivityType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "hygiene_activity")
public class HygieneActivity extends BaseActivity {
    private HygieneActivityType type;
}
