public class ValidatorFactory {

    public Validator getValidator(String stringToCheck) {
        String strippedStr = stringToCheck.replaceAll("[- ]", "");
        switch (stringToCheck.length()) {
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
