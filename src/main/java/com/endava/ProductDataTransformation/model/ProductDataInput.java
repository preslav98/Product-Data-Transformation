package com.endava.ProductDataTransformation.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDataInput {

    private String sku;
    private String warehouse;
    private String barcode;
    private String colour;
    private String size;
    private String value;
    private String category;
    private String occasion;
}
