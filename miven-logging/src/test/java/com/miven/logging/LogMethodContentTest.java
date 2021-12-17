package com.miven.logging;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class LogMethodContentTest {

    @Test
    public void testToString() {
        LogMethodContent<Object> content = new LogMethodContent<>();
        content.setModule("Controller");
        content.setMethodBehavior(MethodBehavior.invoke);
        log.info(content.toString());
    }
}