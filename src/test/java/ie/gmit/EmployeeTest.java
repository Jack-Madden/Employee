/*
Jack Madden
G00338579@gmit.ie

Tests that Employee objects are created when all requirements specified in the Employee class are met, and that the
expected exceptions and error messages are thrown when one is not.
 */
package ie.gmit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class EmployeeTest {

    @BeforeAll
    static void startTest() {
        System.out.println("Beginning tests");
    }

    @AfterAll
    static void finishTest() {
        System.out.println("Finished tests");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        testReporter.publishEntry("Testing" + testInfo.getDisplayName());
        System.out.println();
    }

    @Test
    void testConstructor() {
        Employee employee = new Employee("Mr", "Jack Madden", "01234567", "012345678",
                "Full-time", 22);
        assertEquals("Mr", employee.getTitle());
        assertEquals("Jack Madden", employee.getName());
        assertEquals("01234567", employee.getPps());
        assertEquals("012345678", employee.getPhoneNo());
        assertEquals("Full-time", employee.getEmploymentType());
        assertEquals(22, employee.getAge());
    }

    @Test
    @DisplayName("testEmployeeTitle - testing employee title is valid (must be Mr, Mrs, or Ms)")
    void testEmployeeTitle() {
        final String error = "Title must be Mr, Mrs, or Ms";
        //Testing exception is thrown when title is invalid
        Exception titleException = assertThrows(IllegalArgumentException.class, ()->
                new Employee("", "Jack Madden", "01234567",
                        "012345678", "Full-time", 22));
        assertEquals(error, titleException.getMessage());
    }

    @Test
    @DisplayName("testEmployeeName - testing employee name is valid (between 3 and 25 characters")
    void testEmployeeName() {
        final String error = "Name must be 3–25 characters";
        //Testing exception is thrown when name is an invalid length
        Exception nameException = assertThrows(IllegalArgumentException.class, ()->
                new Employee("Mr", "", "01234567",
                        "012345678", "Full-time", 22));
        assertEquals(error, nameException.getMessage());
    }

    @Test
    @DisplayName("testEmployeePPS - testing employee PPS number is valid (must be 8 characters)")
    void testEmployeePPS() {
        final String error = "PPS number must have 8 characters";
        //Testing exception is thrown when PPS number is the wrong length
        Exception ppsException = assertThrows(IllegalArgumentException.class, ()->
                new Employee("Mr", "Jack Madden", "", "012345678", "Full-time", 22));
        assertEquals(error, ppsException.getMessage());
    }

    @Test
    @DisplayName("TestEmployeePhoneNo - testing employee phone number is valid (must be 9 digits")
    void testEmployeePhoneNo() {
        final String error = "Phone number must have 9 digits";
        //Testing exception is thrown when phone number is the wrong length
        Exception phoneNoException = assertThrows(IllegalArgumentException.class, ()->
                new Employee("Mr", "Jack Madden", "01234567",
                        "", "Full-time", 22));
        assertEquals(error, phoneNoException.getMessage());
    }

    @Test
    @DisplayName("testEmploymentType - testing employment type is valid (Full-time, Part-time, or Contract")
    void testEmploymentType() {
        final String error = "Employment type must be Full-time, Part-time, or Contract";
        //Testing exception is thrown when employment type is invalid
        Exception employmentTypeException = assertThrows(IllegalArgumentException.class, ()->
                new Employee("Mr", "Jack Madden", "01234567",
                        "012345678", "", 22));
        assertEquals(error, employmentTypeException.getMessage());
    }

    @Test
    @DisplayName("testEmployeeAge - testing employee is over 16")
    void testEmployeeAge() {
        final String error = "Employee must be over 16";
        //Testing exception is thrown when age is too young
        Exception employeeAgeException = assertThrows(IllegalArgumentException.class, ()->
                new Employee("Mr", "Jack Madden", "01234567",
                        "012345678", "Full-time", 15));
        assertEquals(error, employeeAgeException.getMessage());
    }
}
