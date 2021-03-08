package com.jy.bron.we.utils;

import com.jy.bron.core.utils.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * @author yangzhi
 * @create 2021/3/3
 */
public class SHA1 {
    /**
     * 串接arr参数，生成sha1 digest.
     */
    public static String gen(String... arr) {
        if (StringUtils.isAllBlank(arr)) {
            throw new IllegalArgumentException("非法请求参数，有部分参数为空 : " + Arrays.toString(arr));
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (String a : arr) {
            sb.append(a);
        }
        return DigestUtils.sha1Hex(sb.toString());
    }

    /**
     * 用&串接arr参数，生成sha1 digest.
     */
    public static String genWithAmple(String... arr) {
        if (StringUtils.isAllBlank(arr)) {
            throw new IllegalArgumentException("非法请求参数，有部分参数为空 : " + Arrays.toString(arr));
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String a = arr[i];
            sb.append(a);
            if (i != arr.length - 1) {
                sb.append('&');
            }
        }
        return DigestUtils.sha1Hex(sb.toString());
    }


    public static String getSHA1(String token, String timestamp, String nonce, String encrypt) throws RuntimeException {
        try {
            String[] array = new String[]{token, timestamp, nonce, encrypt};
            StringBuffer sb = new StringBuffer();
            Arrays.sort(array);

            for(int i = 0; i < 4; ++i) {
                sb.append(array[i]);
            }

            String str = sb.toString();
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());
            byte[] digest = md.digest();
            StringBuffer hexstr = new StringBuffer();
            String shaHex = "";

            for(int i = 0; i < digest.length; ++i) {
                shaHex = Integer.toHexString(digest[i] & 255);
                if (shaHex.length() < 2) {
                    hexstr.append(0);
                }

                hexstr.append(shaHex);
            }

            return hexstr.toString();
        } catch (Exception var12) {
            var12.printStackTrace();
            throw new RuntimeException("sha加密生成签名失败");
        }
    }
}
