package com.andryanstgkr.desmartweb.model;


import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseEntity {
    
    private String id;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private String updatedBy = "Admin";

    private String createdBy = "Admin";

    private Boolean isActive = true;

    private Boolean isDeleted = false;

}