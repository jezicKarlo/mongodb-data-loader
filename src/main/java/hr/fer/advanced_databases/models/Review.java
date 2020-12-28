package hr.fer.advanced_databases.models;

import lombok.Data;

@Data
public class Review {

    private String userId;
    private String profileName;
    private String helpfulness;
    private Double score;
    private String time;
    private String summary;
    private String text;
}
