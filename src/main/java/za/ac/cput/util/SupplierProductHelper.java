package za.ac.cput.util;

import java.net.URL;
import java.time.LocalDate;

public class SupplierProductHelper {


    public static boolean isLessThanZero(double b){
        if(b < 0){
            return true;
        }
        return false;
    }

    public static boolean isValidPrice(double b){
        if(b <= 0){
            return true;
        }
        return false;
    }


    public static boolean isValidUrl(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static  boolean isNull(LocalDate date){
        if(date == null)
            return true;
        return false;


    }
    public static boolean isDescriptionValid(String description) {
        if (description == null || description.trim().isEmpty()) {
            return false;
        }

        String[] words = description.trim().split("\\s+");
        int wordCount = words.length;

        // Check if the word count is between 20 and 50
        return wordCount >= 20 && wordCount <= 50;
    }

}
