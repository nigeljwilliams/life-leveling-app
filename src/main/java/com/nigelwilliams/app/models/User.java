package com.nigelwilliams.app.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "user")
public class User extends BaseDocument {
    @Indexed(unique = true)
    private String name; // We want the User's name to be unique as an identifier
    private int level;
    private int maxExperiencePoints;
    private int currentExperiencePoints;
}