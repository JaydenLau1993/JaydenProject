package com.bonc.jayden.utils;

public class TestCineseOrEnglish {

    public static void isChiness(String str) {
        String test = str;
        byte[] bytes = test.getBytes();
        int i = bytes.length;//i为字节长度
        int j = test.length();//j为字符长度
        System.out.println(i + " " + j);
    }

    public static boolean isChinese(char c) {
        return c >= 0x4E00 && c <= 0x9FA5;// 根据字节码判断
    }

    // 判断一个字符串是否含有中文
    public static boolean isChinese(String str) {
        if (str == null) return false;
        for (char c : str.toCharArray()) {
            if (isChinese(c)) return true;// 有一个中文字符就返回
        }
        return false;
    }

    public static void main(String arg[]) {
        TestCineseOrEnglish str = new TestCineseOrEnglish();
        System.out.println(str.isChinese("我心已死"));
        System.out.println(str.cutString("fqf.庆丰????????", 2));
        System.out.println(str.Chineses("fqf.庆丰????????"));
        isChiness("我心意");
    }

    /**
     * 获取字符串共有汉字的数目
     *
     * @param a String
     * @return int
     */
    public int Chineses(String a) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (isChinese(a.charAt(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * 根据字节数来剪切字符串,类似substring
     *
     * @param a String 字符串
     * @param n int 指定字节数 英文占1个字节 汉字占两个字节
     * @return String
     */
    public String cutString(String a, int n) {
        int num = 0;
        String b = "";
        for (int i = 0; i < a.length(); i++) {
            if (isChinese(a.charAt(i))) {
                num = num + 2;
            } else num++;
            b = b + a.charAt(i);
            if (num >= n - 1) {
                break;
            }

        }
        return b;
    }

}


