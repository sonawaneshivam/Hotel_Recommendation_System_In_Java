package com.hotel.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecomendationEntity {
private int h_id;
private String h_name;
private String h_add;
private String h_type;
private String h_conatct;
private Double price;
private String Aminity;
public boolean hasAmenity(String amenity) {
    return Aminity.contains(amenity.toLowerCase());
}
}
