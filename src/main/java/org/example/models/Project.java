package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Project {
    private Integer id;
    private String builder;
    private Integer rooms;
    private String city;
}
