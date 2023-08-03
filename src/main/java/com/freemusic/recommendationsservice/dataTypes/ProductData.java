package com.freemusic.recommendationsservice.dataTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductData {

    private Integer productId;

    private String productName;
}
