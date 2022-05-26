package com.example.restfulapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private String name;
    private String id;
    private List<String> orders;
    private Date lastModifiedDate;
    private Date createdDate;
    private boolean active;
}
