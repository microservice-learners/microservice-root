package com.edureka.ms.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class OrderEntity {

    @Id
    @GeneratedValue
    Integer id;

    String userId;

    String name;

    String description;

    Integer quantity;

    String address;
}
