package by.epam.task1.validators;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ReaderValidatorTest extends Assert {

    @DataProvider
    Object[][] parseData() {
        return new Object[][]{
                {
                        "1.9 1.34 1.3 1.2",
                        true
                },
                {
                        "-2 3 4 5",
                        true
                },
                {
                        "2.334 -45.3 6.78 3",
                        true
                },
                {
                        "22 33",
                        false
                },
                {
                        "-23.3 -343.2 -3 0.1",
                        true
                },
                {
                        "-23.3 34366.72 667 0",
                        true
                },
                {
                        "0x1.fffffffffffffP+1023 0x1.fffffffffffffP+1023" +
                                " 0x1.fffffffffffffP+1023 0x1.fffffffffffffP+1023",
                        true
                },
                {
                        "-0x0.0000000000001p-1022 -0x0.0000000000001p-1022" +
                                " -0x0.0000000000001p-1022 0x0.0000000000001p-1022",
                        true
                },
                {
                        "0x1.fffffffffffffp1023 0x1.fffffffffffffp1023 " +
                                "0x1.fffffffffffffp1023 -0x1.fffffffffffffp1023",
                        false
                }
        };
    }

    @Test(dataProvider = "parseData")
    void testIsSphereValid(final String str, final boolean res) {
        assertEquals(ReaderValidator.isSphereValid(str), res);
    }
}
