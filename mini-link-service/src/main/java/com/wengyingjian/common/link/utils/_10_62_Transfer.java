package com.wengyingjian.common.link.utils;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by wengyingjian on 16/12/16.
 * <p>
 * 10机制、62进制转换器
 */
@Service
public class _10_62_Transfer {

    private static final char[] CHARACTER_LIST = {
            'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p',
            'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
            'z', 'x', 'c', 'v', 'b', 'n', 'm',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P',
            'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L',
            'Z', 'X', 'C', 'V', 'B', 'N', 'M'
    };
    private static Map<Long, Character> characterMap = new HashMap<>();

    static {
        for (int i = 0; i < 62; i++) {
            characterMap.put(Integer.valueOf(i).longValue(), CHARACTER_LIST[i]);
        }
    }

    private static final long MAX_SIZE = 62 ^ 6;

    /**
     * 将long类型的ID转换成6位62进制字符串
     *
     * @param number
     * @return
     */
    public String _10_2_62(Long number) {
        if (number > MAX_SIZE) {
            throw new RuntimeException("超过最大限制！");
        }
        int index = 6;
        char[] chars = new char[6];
        while (index-- > 0) {
            long key = 0;
            if (number != 0) {
                key = number - (number / 62) * 62;
                number = number / 62;
            }
            chars[index] = characterMap.get(key);
        }
        return String.valueOf(chars);
    }

    /**
     * 62进制转化为10进制
     *
     * @param str
     * @return
     */
    public long _62_2_10(String str) {
        if (str == null) {
            throw new RuntimeException("字符串为空!");
        }
        if (str.length() != 6) {
            throw new RuntimeException("只支持6位长度的字符！");
        }
        int multiple = 1;
        long result = 0;
        Character c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(str.length() - i - 1);
            result += _62_value(c) * multiple;
            multiple = multiple * 62;
        }
        return result;
    }

    private static int _62_value(Character c) {
        for (int i = 0; i < CHARACTER_LIST.length; i++) {
            if (c == CHARACTER_LIST[i]) {
                return i;
            }
        }
        throw new RuntimeException("不支持特殊字符");
    }
}
