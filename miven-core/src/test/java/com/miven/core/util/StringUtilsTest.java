package com.miven.core.util;

import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void testFormatComment() {
        String comment = "Extension to the standard {@link BeanFactoryPostProcessor} SPI, allowing for\n" +
                " * the registration of further bean definitions <i>before</i> regular\n" +
                " * BeanFactoryPostProcessor detection kicks in. In particular,\n" +
                " * BeanDefinitionRegistryPostProcessor may register further bean definitions\n" +
                " * which in turn define BeanFactoryPostProcessor instances.";
        comment = StringUtils.formatComment(comment);
        System.out.println(comment);
    }
}