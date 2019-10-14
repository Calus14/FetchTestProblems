import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import service.TestFetchService;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@ActiveProfiles("unitTest")
@SpringBootTest
public class TestFetchServiceUnitTester {

    private TestFetchService service = new TestFetchService();
    private static final List<String> emailList1 = Arrays.asList("test.email@gmail.com", "test.email+spam@gmail.com", "testemail@gmail.com");
    private static final List<String> emailList2 = Arrays.asList("test.email@gmail.com", "test.email+spam@gmail2.com", "testemai3l@gmail.com");
    private static final List<String> emailList3 = Arrays.asList("test2.email@gmail.com", "tes1t.email+spam@gmail.com", "testemail@gmail.com");

    @Test
    public void testPyramidWord() {
        assertTrue( service.isWordPyramid("banana") );
        assertFalse(service.isWordPyramid("CalebHanselman"));
        assertFalse(service.isWordPyramid(""));
        assertTrue(service.isWordPyramid("abcbcb") );
        assertFalse(service.isWordPyramid("abcabbc"));
    }

    @Test
    public void testEmailCount(){
        assertEquals(service.getUniqueEmailCount(emailList1), 1);
        assertEquals(service.getUniqueEmailCount(emailList2), 3);
        assertEquals(service.getUniqueEmailCount(emailList3), 3);
    }

}