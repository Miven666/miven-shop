package cn.miven.cloud.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * String安全加密
 *
 * @author mingzhi.xie
 * @date 2019/4/4
 */
public class StringEncodeUtils {

    private static char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    private static MessageDigest messagedigest = null;

    /**
     * 获取md5值
     *
     * @return md5串
     */
    public static String md5Encode(String plainText) {

        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messagedigest.update(plainText.getBytes());
        return bufferToHex(messagedigest.digest());
    }

    private static String bufferToHex(byte[] bytes) {
        return bufferToHex(bytes, bytes.length);
    }

    private static String bufferToHex(byte[] bytes, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        for (int l = 0; l < n; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        char c0 = hexDigits[(bt & 0xf0) >> 4];
        char c1 = hexDigits[bt & 0xf];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }
}
