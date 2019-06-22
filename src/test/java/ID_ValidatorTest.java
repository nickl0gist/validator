import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ID_ValidatorTest {

    private ID_Validator validator;

    @Before
    public void setUp(){
        this.validator = new ID_Validator();
    }

    @Test
    public void ValidID_test(){
        assertTrue(validator.validate("NRX300202"));
    }

    @Test
    public void ValidID_with_space_test(){
        assertTrue(validator.validate("NRX 300202"));
    }

    @Test
    public void ValidID_with_dash_test(){
        assertTrue(validator.validate("NRX-300202"));
    }

    @Test
    public void ValidID_case_sensitive_test(){
        assertTrue(validator.validate("Nrx 300202"));
    }

    @Test
    public void InValidID_test(){
        assertTrue(validator.validate("NRX222333"));
    }

    @Test
    public void InValidID_with_space_test(){
        assertTrue(validator.validate("NRX 222333"));
    }

    @Test
    public void InValidID_with_dash_test(){
        assertTrue(validator.validate("NRX-222333"));
    }

    @Test
    public void InValidID_case_sensitive_test(){
        assertTrue(validator.validate("Nrx222333"));
    }
}
