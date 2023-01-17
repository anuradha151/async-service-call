package com.anuradha.asyncservicecall.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Institute {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String address;
}
