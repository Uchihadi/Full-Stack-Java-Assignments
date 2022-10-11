package com.example.week6day2.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class CityModel {
    String name;
    int peopleCount;
}
