package com.endava.ProductDataTransformation.processor;

import com.endava.ProductDataTransformation.model.ProductDataInput;
import com.endava.ProductDataTransformation.model.ProductDataOutput;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductDataProcessor {

    @Value("#{${category}}")
    private Map<String, String> categories;

    @Value("#{${occasion}}")
    private Map<String, String> occasion;

    public ProductDataOutput process(ProductDataInput data) throws Exception {

        String description = data.getSku().concat(" ").concat(data.getSize()).concat(" ").concat(data.getColour());
        String department = filterMap(categories, data.getCategory()).orElseThrow();
        String packaging = filterMap(occasion, data.getOccasion()).orElseThrow();

        return ProductDataOutput.builder()
                .sku(data.getSku())
                .warehouse(data.getWarehouse())
                .barcode(data.getBarcode())
                .description(description)
                .value(data.getValue())
                .department(department)
                .packaging(packaging)
                .build();
    }

    private Optional<String> filterMap(Map<String, String> categoriesOrOccasion, String data) {
        Optional<Set<String>> optionalCategories = Optional.of(categoriesOrOccasion
                .entrySet()
                .stream()
                .filter(map -> map.getKey().equals(data))
                .map(map -> map.getValue())
                .collect(Collectors.toSet()));

        return optionalCategories.get().stream().findFirst();
    }
}
