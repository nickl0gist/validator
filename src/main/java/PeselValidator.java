public class PeselValidator implements Validator {

    /**
     * Months
     * cyfry [1-6] – data urodzenia z określeniem stulecia urodzenia
     * cyfry [7-10] – numer serii z oznaczeniem płci
     * cyfra [10] – płeć
     * cyfra [11] – cyfra kontrolna
     *
     */

    private String type = "PESEL number";

    private int[] points = {9,7,3,1,9,7,3,1,9,7};

    @Override
    public boolean validate(String id_number) {
        int control_sum = 0;
        id_number = id_number.replaceAll("[- ]", "");
        if(id_number.length() != points.length + 1 || !id_number.matches("^[0-9]{11}$")) return false;
        for (int i = 0; i < points.length; i++) {
            control_sum += points[i] * Character.getNumericValue(id_number.charAt(i));
        }
        return control_sum % 10 == Character.getNumericValue(id_number.charAt(10));
    }
}
