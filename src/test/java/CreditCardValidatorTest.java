import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CreditCardValidatorTest {

    private CreditCardValidator validator;

    @Before
    public void setUp() {
        this.validator = new CreditCardValidator();
    }

    @Test
    public void ValidCard_test() {
        assertTrue(validator.validate("4556737586899855"));
    }

    @Test
    public void ValidCard_with_space_test() {
        assertTrue(validator.validate("4556 7375 8689 9855"));
    }

    @Test
    public void ValidCard_with_dash_test() {
        assertTrue(validator.validate("4556-7375-8689-9855"));
    }

    @Test
    public void InValidCard_test() {
        assertFalse(validator.validate("4556737586899857"));
    }

    @Test
    public void InValidCard_with_space_test() {
        assertFalse(validator.validate("4556 7375 8689 9857"));
    }

    @Test
    public void InValidCard_with_dash_test() {
        assertFalse(validator.validate("4556-7375-8689-9857"));
    }

    @Test
    public void InValidCard_regex_test() {
        assertFalse(validator.validate("Ab56737586899855"));
    }

}

