import com.conti.FingerTable;
import com.conti.UserInput;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class NodeTest {
    @Test
    void whenNodeIsCreatedItIsAssignedACustomID(){
        FingerTable myFingerTable = new FingerTable(3, new HashMap<>());
        UserInput myUserInput = new UserInput(5,5);
        //TODO this test does not properly validate the expected request
    }
}