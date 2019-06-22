import java.util.HashMap;
import java.util.Map;

public class ID_Validator implements Validator {

    private String type = "ID number";

    private final static int[] POINTS = {7, 3, 1, 9, 7, 3, 1, 7, 3};
    private Map<Character, Integer> signMap = new HashMap<>();

    public ID_Validator() {
        int counter = 0;
        for (char digit = '0'; digit <= '9'; digit++){
            this.signMap.put(digit, counter++);
        }
        for (char alpha = 'A'; alpha <= 'Z'; alpha++){
            this.signMap.put(alpha, counter++);
        }
    }

    @Override
    public boolean validate(String id_number) {
        int control_sum = 0;
        id_number = id_number.replaceAll("[- ]", "").toUpperCase();
        if (id_number.length() != POINTS.length || !id_number.matches("^[A-Z]{3}[0-9]{6}$")) return false;

        for (int i = 0; i < id_number.length(); i++) {
                control_sum += signMap.get(id_number.charAt(i)) * POINTS[i];
        }
        return control_sum % 10 == 0;
    }

    @Override
    public String getType() {
        return type;
    }
}
