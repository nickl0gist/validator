public class CreditCardValidator implements Validator {

    /**
     * Credit Card Validator is valid for 16 digits cards
     */
    private final int DIGITS_QTY = 16;
    String type = "Credit Card number";

    @Override
    public boolean validate(String id_number) {
        int sum = 0;
        id_number = id_number.replaceAll("[- ]", "").toUpperCase();
        if (id_number.length() != DIGITS_QTY || !id_number.matches("^[0-9]{" + DIGITS_QTY + "}$")) return false;
        int control_sum = Character.getNumericValue(id_number.charAt(DIGITS_QTY - 1));
        StringBuilder sb = new StringBuilder(id_number.substring(0, DIGITS_QTY - 1));
        String reversedStr = sb.reverse().toString();
        for (int i = 0; i < DIGITS_QTY - 1; i++) {
            if (i % 2 == 0) {
                sum += (Character.getNumericValue(reversedStr.charAt(i)) * 2) > 9 ?
                        (Character.getNumericValue(reversedStr.charAt(i)) * 2) - 9 :
                        Character.getNumericValue(reversedStr.charAt(i)) * 2;
            } else {
                sum += Character.getNumericValue(reversedStr.charAt(i));

            }
        }
        return sum % 10 == control_sum;
    }
}
