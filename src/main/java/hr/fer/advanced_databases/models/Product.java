package hr.fer.advanced_databases.models;

import lombok.Data;

@Data
public class Product {

    private String productId;
    private String title;
    private Double price;
}
