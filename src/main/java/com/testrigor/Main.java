package com.testrigor;

import java.util.HashMap;
import java.util.Map;

public class Main {

    /**
     *
     * Check README
     */
    public static void main(String[] args) {
        Map<String, String> criminals = new HashMap<>();
        criminals.put("Paul White Jr.", null);
        criminals.put("Paul White", "Roger Night, Peter Llong Jr.");
        criminals.put("Roger Fedexer", "Rob Ford, Pete Lord, Roger McWire");
        criminals.put("Red Fortress", "Roger Rabbit, Ross Winter");
        criminals.put("Redford Fort", "Red Strong, Red Fort");

        // Add as many as you want
        System.out.println(findCriminal(criminals, "Red "));
        System.out.println(findCriminal(criminals, "Roger"));
        System.out.println(findCriminal(criminals, "Red"));
        System.out.println(findCriminal(criminals, null));
        System.out.println(findCriminal(criminals, "Ford"));
    }

    /**
     * TODO: Implement
     *
     * @param criminals
     * @param possibleName
     * @return
     */
    public static String findCriminal(Map<String, String> criminals, String possibleName) {
        if (possibleName == null || possibleName.trim().isEmpty()) {
            return "No match";
        }

        possibleName = possibleName.toLowerCase().trim();

        for (Map.Entry<String, String> entry : criminals.entrySet()) {
            String actualName = entry.getKey().toLowerCase();
            String aliases = entry.getValue();

            if (actualName.equals(possibleName)) {
                return formatResult(actualName, aliases);
            }

            if (aliases != null && aliases.toLowerCase().contains(possibleName)) {
                return formatResult(actualName, aliases);
            }
        }

        return "No match";
    }

    private static String formatResult(String actualName, String aliases) {
        StringBuilder result = new StringBuilder("First name: " + actualName);
        if (aliases != null) {
            result.append(". Aliases: ").append(aliases);
        }
        return result.toString();
    }
}
