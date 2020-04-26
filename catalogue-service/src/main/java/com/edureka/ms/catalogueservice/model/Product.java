package com.edureka.ms.catalogueservice.model;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    Long id;
    //name = name
    String name;
    String description; //description_local - snake case
    //...
}
