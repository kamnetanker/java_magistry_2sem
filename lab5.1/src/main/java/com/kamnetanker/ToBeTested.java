package com.kamnetanker;

public class ToBeTested {
    public static int[] method1(int[] a, int[] b) throws Exception {
        if (a.length != b.length) throw new Exception("Arrays must have equal length");
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = (a[i] > b[i]) ? a[i] : b[i];
        }
        return c;
    }

    public boolean isContainsDigit(String s) throws Exception {
        if (s == null) throw new Exception("String must be not null");
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    return true;
            }
        }
        return false;
    }
}
