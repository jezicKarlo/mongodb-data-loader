package hr.fer.advanced_databases.util;

import lombok.experimental.UtilityClass;

import java.text.SimpleDateFormat;
import java.util.Date;

@UtilityClass
public class EpochConverter {

    public String convertFromEpoch(String epochTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
        return sdf.format(new Date(Long.parseLong(epochTime) * 1000));
    }
}
