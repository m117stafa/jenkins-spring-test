package org.idsit.coursspring.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Module {
    private int id;
    private String nom;
    private String description;
}
