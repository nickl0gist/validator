public class ValidatorFactory {

    public Validator getValidator(String stringToCheck) {
        String strippedStr = stringToCheck.replaceAll("[- ]", "");
        switch (strippedStr.length()) {
            case 9:
                return new ID_Validator();
            case 11:
                return new PeselValidator();
            case 16:
                return new CreditCardValidator();
        }
        return null;
    }

}
