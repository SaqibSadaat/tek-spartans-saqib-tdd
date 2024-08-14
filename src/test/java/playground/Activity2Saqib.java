package playground;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity2Saqib<NameFormatter> {
    /*
    Write a method that takes firstName and Last Name as parameters
    and Return full name in format LASTNAME, Firstname;
    saqib -> Saqib
     */

    //Step 2) Write A test in TestNG to test above method functionality
    public static String getFullName(String firstName, String lastName) {
        if (firstName == null || lastName == null)
            throw new RuntimeException("FirstName or Last Name can NOT be null");

        if (firstName.isEmpty() || lastName.isEmpty())
            throw new RuntimeException("First Name or Last Name can NOT be Empty");

        lastName = lastName.trim();
        firstName = firstName.trim();

        return lastName.toUpperCase() + ", " +
                firstName.substring(0, 1).toUpperCase() +
                firstName.substring(1).toLowerCase();

    }
    @Test
    public void testGetFullName_ValidInput() {
        String result = getFullName("Saqib", "Ali");
        Assert.assertEquals(result, "ALI, Saqib");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testGetFullName_NullFirstName() {
        getFullName(null, "Ali");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testGetFullName_NullLastName() {
        getFullName("Saqib", null);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testGetFullName_EmptyFirstName() {
        getFullName("", "Ali");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testGetFullName_EmptyLastName() {
        getFullName("Saqib", "");
    }

    @Test
    public void testGetFullName_TrimmedInput() {

        String result = getFullName(" Saqib ", " Ali ");
        Assert.assertEquals(result, "ALI, Saqib");
    }

}
