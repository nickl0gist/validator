import java.util.HashMap;
import java.util.Map;

public class ID_Validator implements Validator {

    private String type = "ID number";

    private Map<Character, Integer> signMap = new HashMap<>();
    private int[] points = {7, 3, 1, 9, 7, 3, 1, 7, 3};

    public ID_Validator() {
        this.signMap.put('A', 10);
        this.signMap.put('N', 23);
        this.signMap.put('B', 11);
        this.signMap.put('O', 24);
        this.signMap.put('C', 12);
        this.signMap.put('P', 25);
        this.signMap.put('D', 13);
        this.signMap.put('Q', 26);
        this.signMap.put('E', 14);
        this.signMap.put('R', 27);
        this.signMap.put('F', 15);
        this.signMap.put('S', 28);
        this.signMap.put('G', 16);
        this.signMap.put('T', 29);
        this.signMap.put('H', 17);
        this.signMap.put('U', 30);
        this.signMap.put('I', 18);
        this.signMap.put('V', 31);
        this.signMap.put('J', 19);
        this.signMap.put('W', 32);
        this.signMap.put('K', 20);
        this.signMap.put('X', 33);
        this.signMap.put('L', 21);
        this.signMap.put('Y', 34);
        this.signMap.put('M', 22);
        this.signMap.put('Z', 35);


    }

    @Override
    public boolean validate(String id_number) {
        int control_sum = 0;
        id_number = id_number.replaceAll("[- ]", "").toUpperCase();
        if (id_number.length() != points.length || !id_number.matches("^[A-Z]{3}[0-9]{6}$")) return false;
        for (int i = 0; i < id_number.length(); i++) {
            if (i < 3)
                control_sum += signMap.get(id_number.charAt(i)) * points[i];
             else
                control_sum += Character.getNumericValue(id_number.charAt(i)) * points[i];
        }
        return control_sum % 10 == 0;
    }
}
