package com.bonc.jayden.utils;

import java.lang.*;
import java.util.*;

/**
 * 与终端交互，将两个字符串相同的部门置为“_”
 */
public class ScannerString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String a = in.nextLine();
            String b = in.nextLine();
            char[] c1 = a.toCharArray();
            char[] c2 = b.toCharArray();
            for (int i = 0; i < c1.length; i++) {
                for (int j = 0; j < c2.length; j++) {
                    if (c1[i] == c2[j]) {
                        a = a.toString().replace(c1[i], '_');
                        b = b.replace(c1[i], '_');

                    }
                }
            }
            System.out.println(a);
            System.out.println(b);
        }
    }
}

