import java.util.HashMap;
import java.util.Map;

public class ID_Validator implements Validator {

    String type = "ID number";

    Map<Character, Integer> signMap = new HashMap<>();

    public ID_Validator() {
        this.signMap.put('A', 10); this.signMap.put('N', 23);
        this.signMap.put('B', 11); this.signMap.put('O', 24);
        this.signMap.put('C', 12); this.signMap.put('P', 25);
        this.signMap.put('D', 13); this.signMap.put('Q', 26);
        this.signMap.put('E', 14); this.signMap.put('R', 27);
        this.signMap.put('F', 15); this.signMap.put('S', 28);
        this.signMap.put('G', 16); this.signMap.put('T', 29);
        this.signMap.put('H', 17); this.signMap.put('U', 30);
        this.signMap.put('I', 18); this.signMap.put('V', 31);
        this.signMap.put('J', 19); this.signMap.put('W', 32);
        this.signMap.put('K', 20); this.signMap.put('X', 33);
        this.signMap.put('L', 21); this.signMap.put('Y', 34);
        this.signMap.put('M', 22); this.signMap.put('Z', 35);
    }

    @Override
    public boolean validate(String id_number) {
        return false;
    }
}
