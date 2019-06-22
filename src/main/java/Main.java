import picocli.CommandLine;
import picocli.CommandLine.*;

@Command(description = "Compressing test to short messages using Native and Advanced methods",
        name = "validate", mixinStandardHelpOptions = true)
public class Main implements Runnable {

    @Option(names = { "-n", "--number" }, description = "Text message [Please use \"\"]", required = true)
    private static String document_number;

    public static void main(String[] args) {
        CommandLine.run(new Main(), args);
    }

    @Override
    public void run() {
        ValidatorFactory validatorFactory = new ValidatorFactory();
        Validator validator = validatorFactory.getValidator(document_number);
        if (validator == null){
            System.out.println("Given document number is neither an ID, nor PESEL, nor even CreditCard. \n You should try again.");
        } else {
            if (validator.validate(document_number)){
                System.out.println("This is correct " + validator.getType());
            } else {
                System.out.println("This " + validator.getType() + "is incorrect.");
            }
        }
    }
}
