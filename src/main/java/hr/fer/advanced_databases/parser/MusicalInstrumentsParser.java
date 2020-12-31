package hr.fer.advanced_databases.parser;

import hr.fer.advanced_databases.models.MusicalInstrument;
import hr.fer.advanced_databases.models.Product;
import hr.fer.advanced_databases.models.Review;
import hr.fer.advanced_databases.reader.DataReader;
import hr.fer.advanced_databases.util.EpochConverter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MusicalInstrumentsParser implements DataParser {

    private final DataReader reader;

    public MusicalInstrumentsParser(DataReader reader) {
        this.reader = reader;
    }

    @Override
    public List<MusicalInstrument> parse() {
        String line = reader.readLine();
        List<MusicalInstrument> instruments = new ArrayList<>();
        while (line != null) {
            MusicalInstrument instrument = new MusicalInstrument();
            while (line != null && !line.isEmpty()) {
                addFiled(line, instrument);
                line = reader.readLine();
            }
            instruments.add(instrument);
            line = reader.readLine();
        }
        return instruments;
    }

    public void addFiled(String field, MusicalInstrument instrument) {
        String productReview = field.split("/", 2)[0];
        if ("product".equals(productReview)) {
            addProductField(field.split("/", 2)[1], instrument.getProduct());
        } else if ("review".equals(productReview)) {
            addReviewField(field.split("/", 2)[1], instrument.getReview());
        }
    }

    private void addProductField(String field, Product product) {
        String productField = field.split(" ", 2)[0].replace(":", "");
        if ("productId".equals(productField)) {
            product.setProductId(field.split(" ", 2)[1]);
            return;
        }
        if ("title".equals(productField)) {
            product.setTitle(field.split(" ", 2)[1]);
            return;
        }
        if ("price".equals(productField)) {
            String price = field.split(" ", 2)[1];
            if (!"unknown".equals(price)) {
                product.setPrice(Double.parseDouble(price));
            }
        }
    }

    private void addReviewField(String field, Review review) {
        String reviewField = field.split(" ", 2)[0].replace(":", "");
        if ("userId".equals(reviewField)) {
            review.setUserId(field.split(" ", 2)[1]);
            return;
        }
        if ("profileName".equals(reviewField)) {
            review.setProfileName(field.split(" ", 2)[1]);
            return;
        }
        if ("helpfulness".equals(reviewField)) {
            review.setHelpfulness(field.split(" ", 2)[1]);
            return;
        }
        if ("score".equals(reviewField)) {
            review.setScore(Double.parseDouble(field.split(" ", 2)[1]));
            return;
        }
        if ("time".equals(reviewField)) {
            String epochTime = field.split(" ", 2)[1];
            String time = EpochConverter.convertFromEpoch(epochTime);
            review.setTime(time);
            return;
        }
        if ("summary".equals(reviewField)) {
            review.setSummary(field.split(" ", 2)[1]);
            return;
        }
        if ("text".equals(reviewField)) {
            review.setText(field.split(" ", 2)[1]);
        }
    }


}
