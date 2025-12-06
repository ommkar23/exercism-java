import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DialingCodes {
    private final Map<Integer, String> codes = new HashMap<>();

    public Map<Integer, String> getCodes() {
        return new HashMap<>(this.codes);
    }

    public void setDialingCode(Integer code, String country) {
        this.codes.put(code, country);
    }

    public String getCountry(Integer code) {
        return this.codes.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        // Only add if the code doesn't exist AND the country isn't already mapped
        if (!codes.containsKey(code) && !codes.containsValue(country)) {
            codes.put(code, country);
        }
    }

    public Integer findDialingCode(String country) {
        // Iterate through the map to find the key for a specific value
        for (Map.Entry<Integer, String> entry : codes.entrySet()) {
            if (Objects.equals(entry.getValue(), country)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void updateCountryDialingCode(Integer code, String country) {
        // 1. Check if the country exists in our map
        Integer oldCode = findDialingCode(country);

        // 2. If it exists, remove the old entry and add the new one
        if (oldCode != null) {
            codes.remove(oldCode);
            codes.put(code, country);
        }
    }
}