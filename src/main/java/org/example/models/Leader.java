package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Leader {
    private Integer id;
    private String name;
    private String lastName;
    private String city;
}
