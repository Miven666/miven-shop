package com.miven.spring.boot.autoconfigure.logging;

import com.miven.logging.Level;
import org.slf4j.Logger;

/**
 * @author mingzhi.xie
 * @since 1.0
 */
public class LogUtils {

    public static void log(Level level, Logger logger, String msg) {
        switch (level) {
            case ERROR:
                logger.error(msg);
                break;
            case WARN:
                logger.warn(msg);
                break;
            case INFO:
                logger.info(msg);
                break;
            case DEBUG:
                logger.debug(msg);
                break;
            case TRACE:
                logger.trace(msg);
                break;
        }
    }
}
