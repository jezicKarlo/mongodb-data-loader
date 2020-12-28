package hr.fer.advanced_databases.models;

import lombok.Data;

@Data
public class MusicalInstrument {

    private Product product;
    private Review review;

    public MusicalInstrument() {
        product = new Product();
        review = new Review();
    }
}
