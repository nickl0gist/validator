import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PeselValidatorTest {

    private PeselValidator validator;

    @Before
    public void setUp() {
        this.validator = new PeselValidator();
    }

    @Test
    public void ValidID_test() {
        assertTrue(validator.validate("44051401359"));
    }

    @Test
    public void ValidID_with_space_test() {
        assertTrue(validator.validate("440 51 40 13 59"));
    }

    @Test
    public void ValidID_with_dash_test() {
        assertTrue(validator.validate("440-51401-359"));
    }

    @Test
    public void InValidID_test() {
        assertFalse(validator.validate("44051401358"));
    }

    @Test
    public void InValidID_with_space_test() {
        assertFalse(validator.validate("440 5140 1358"));
    }

    @Test
    public void InValidID_with_dash_test() {
        assertFalse(validator.validate("44051401357"));
    }

    @Test
    public void InValidID_regex_test() {
        assertFalse(validator.validate("440514X1359"));
    }

}

