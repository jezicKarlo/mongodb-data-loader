package hr.fer.advanced_databases.parser;

import hr.fer.advanced_databases.models.MusicalInstrument;
import hr.fer.advanced_databases.models.Product;
import hr.fer.advanced_databases.models.Review;
import hr.fer.advanced_databases.reader.DataReader;

import java.util.List;

public class MusicalInstrumentsParser implements DataParser{

    private final DataReader reader;

    public MusicalInstrumentsParser(DataReader reader) {
        this.reader = reader;
    }

    @Override
    public List<MusicalInstrument> parse() {
        return null;
    }

    public void addFiled(String field, MusicalInstrument instrument) {
        String productReview = field.split("/")[0];
        if ("product".equals(productReview)) {
            addProductField(field.split("/")[1], instrument.getProduct());
        } else if ("review".equals(productReview)) {
            addReviewField(field.split("/")[1], instrument.getReview());
        }
    }

    private void addProductField(String field, Product product) {
        String productField = field.split(" ")[0].replace(":", "");
        if ("productId".equals(productField)) {
            product.setProductId(field.split(" ")[1]);
            return;
        }
        if ("title".equals(productField)) {
            product.setTitle(field.split(" ")[1]);
            return;
        }
        if ("price".equals(productField)) {
            product.setPrice(Double.parseDouble(field.split(" ")[1]));
        }
    }

    private void addReviewField(String field, Review review) {
        String reviewField = field.split(" ")[0].replace(":", "");
        if ("userId".equals(reviewField)) {
            review.setUserId(field.split(" ")[1]);
            return;
        }
        if ("profileName".equals(reviewField)) {
            review.setProfileName(field.split(" ")[1]);
            return;
        }
        if ("helpfulness".equals(reviewField)) {
            review.setHelpfulness(field.split(" ")[1]);
            return;
        }
        if ("score".equals(reviewField)) {
            review.setScore(Double.parseDouble(field.split(" ")[1]));
            return;
        }
        if ("time".equals(reviewField)) {
            review.setTime(field.split(" ")[1]);
            return;
        }
        if ("summary".equals(reviewField)) {
            review.setSummary(field.split(" ")[1]);
            return;
        }
        if ("text".equals(reviewField)) {
            review.setText(field.split(" ")[1]);
        }
    }
}
