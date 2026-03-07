package com.nigelwilliams.app.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Data
public abstract class BaseDocument {
    @Id
    private String id; // MongoDB will autogen this ID

    @CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    private Instant lastDateModified;
}
