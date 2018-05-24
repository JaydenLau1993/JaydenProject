package com.bonc.jayden.utils;


import java.util.regex.Matcher;

import java.util.regex.Pattern;

/**
 * ClassName CharacterJudgeCHorEG
 * Description 判断字符串是中文或者是英文的
 * @return boolean 中文true；英文false
 * @author liuzhe
 * @version V1.0
 */

public class CharacterJudgeCHorEG {

    public static void main(String[] args) {
//        String str = "我爱你，！？（）：；“”、。";
//        String str = "菲菲的非常乘客从？？||恩赐rabcd???";
        String str = "中国网络上Chinese Pre\nsident Xi Jinping on Tuesday met with heads of foreign delegations attending the 13th meeting of Security Council Secretaries of the Shanghai Cooperation Organization (SCO) in Beijing.网民因中英文接触普及化而产生的语码混合现象,其中有网民以拼音化的汉语为词干及英语黏着词素结合成词,并加以使用,成为风潮。本文旨在从语码混合理论及优选论的角度研究这些新型的语码混合词的形成方式与过程,并探讨当中涉及的词干、黏着词素及额外构词成分的功能与作用,证明其造词过程、词素选取具有其系统性。";
        char[] charArray = str.toCharArray();
        System.out.println(characterChoose(str, 20));
        System.out.println(isEnglish(charArray[0]));
//        char[] charArray = str.toCharArray();
//        for (int i = 0; i < charArray.length; i++) {
//            isChinese(charArray[i]);
//        }
//        String chinese = "中国god damn";
//        System.out.println(isContainChinese(chinese));
//        String english = "dfafdabac";
//        System.out.println(isEnglish(english));
    }

    /**
     * Title: isChinese
     * Description: 该函数就用来打印一些字符看看属于什么
     * Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS ： 4E00-9FBF：CJK 统一表意符号
     * Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS ：F900-FAFF：CJK 兼容象形文字
     * Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A ：3400-4DBF：CJK 统一表意符号扩展 A
     * Character.UnicodeBlock.GENERAL_PUNCTUATION ：2000-206F：常用标点
     * Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION ：3000-303F：CJK 符号和标点
     * Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS ：FF00-FFEF：半角及全角形式
     *
     * @param c
     */

    public static void ChineseType(char c) {

        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) {
            System.out.println(c + "--CJK_UNIFIED_IDEOGRAPHS");
        } else if (ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) {
            System.out.println(c + "--CJK_COMPATIBILITY_IDEOGRAPHS");
        } else if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) {

            // CJK Unified Ideographs Extension WikipediaUnicode扩展汉字
            // CJK Unified Ideographs Extension A 中日韩统一表意文字扩展区A ; 表意文字扩充A
            // CJK Unified Ideographs Extension B 中日韩统一表意文字扩展区B
            System.out.println(c + "--CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A");
        } else if (ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {// 通用标点
            System.out.println(c + "--GENERAL_PUNCTUATION");
        } else if (ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) {
            System.out.println(c + "--CJK_SYMBOLS_AND_PUNCTUATION");
        } else if (ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            System.out.println(c + "--HALFWIDTH_AND_FULLWIDTH_FORMS");
        }
    }

    public static boolean isEnglish(String charaString) {
        return charaString.matches("^[a-zA-Z]*");
    }

    /*
     * Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS ： 4E00-9FBF：CJK 统一表意符号
     * Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS ：F900-FAFF：CJK 兼容象形文字
     * Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A ：3400-4DBF：CJK 统一表意符号扩展 A
     * Character.UnicodeBlock.GENERAL_PUNCTUATION ：2000-206F：常用标点
     * Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION ：3000-303F：CJK 符号和标点
     * Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS ：FF00-FFEF：半角及全角形式
    * */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
//                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
//                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
//                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
//                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
//                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                ) {
            return true;
        }
        return false;
    }

    public static boolean isContainChinese(String str) {// 检测是否包含中文
        String regEx = "[\\u4E00-\\u9FA5]+";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Title: isChinese
     * Description: 该函数根据指定个数的字符串中中文出现的个数是否占总个数的一半
     * 或者中文个数超过英文个数来判断是否是中英文
     *
     * @param str   传入判断中英文的字符串
     * @param index 传入判断的字符串个数（可传值为null，默认判断全部字符串）
     */
    public static boolean characterChoose(String str, Integer index) {
        System.out.println(str);
        str = str.replaceAll(" ", "").replaceAll("\t", "").replaceAll("\n", "").replaceAll("\r", "");
        if (index != null) {
            try {
                str = str.substring(0, index);
            } catch (Exception e) {
                index = str.length();
                str = str.substring(0, index);
            }
        }
        System.out.println(str);
        int chnum = 0;
        int egnum = 0;
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (isChinese(c)) {
                chnum++;
            } else if (isEnglish(c)) {
                egnum++;
            }
        }
        System.out.println("中文字符个数" + chnum);
        System.out.println("英文字符个数" + egnum);
        if (chnum >= index / 2 || chnum > egnum) {
            return true;
        }
        return false;
    }

    /**
     * 校验某个字符是否是a-z、A-Z、_、0-9
     *
     * @param c 被校验的字符
     * @return true代表符合条件
     */
    public static boolean isEnglish(char c) {
        String regEx = "^[a-zA-Z]*";  //[\w]
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher("" + c);
        return m.matches();
    }
}
