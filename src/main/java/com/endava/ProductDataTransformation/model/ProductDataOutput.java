package com.endava.ProductDataTransformation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDataOutput {

    private String sku;
    private String warehouse;
    private String barcode;
    private String description;
    private String value;
    private String department;
    private String packaging;
}
