package com.ohar.pdbserver.helper;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class AbstractHelper {

    public static String encodeParam(String param) {
        try {
            return URLEncoder.encode(param, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            return param;
        }
    }

    public static String decodeParam(String param) {
        try {
            return URLDecoder.decode(param, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            return param;
        }
    }
}
