package com.miven.core.util;

import org.junit.Test;

public class RandomUtilsTest {

    @Test
    public void TestRandomPositiveInt() {
        int i = 0;
        while (i < 20) {
            System.out.println("number == " + RandomUtils.positiveNumber(5));
            i++;
            double decimal_1 = RandomUtils.positiveDecimal(4);
            double decimal_7 = RandomUtils.boundDecimal(decimal_1);
            double decimal_30 = RandomUtils.boundDecimal(decimal_7);
            System.out.println("decimal_1 == " + decimal_1);
            System.out.println("decimal_7 == " + decimal_7);
            System.out.println("decimal_30 == " + decimal_30);
        }
    }

}