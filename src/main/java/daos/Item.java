package com.example.demo.daos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long ID;
    private String Title;
    private Double Price;
    private int Quantity;
}
