package com.nigelwilliams.app.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseActivity extends BaseDocument{
    private int experiencePoints; // Experience associated with the activity
}
