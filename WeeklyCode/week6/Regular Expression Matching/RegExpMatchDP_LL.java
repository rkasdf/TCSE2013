/**
 * Created by LL on 2015/1/25.
 */
public class RegExpMatchDP {
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (pLen == 0) {
            return sLen == 0;
        }
        boolean[][] match = new boolean[sLen + 1][pLen + 1];
        match[0][0] = true;

        for (int pi = 0; pi < pLen; pi++) {
            if (p.charAt(pi) == '*') {
                if (pi > 0) match[0][pi + 1] = match[0][pi - 1];
                if (pi < 1) continue;
                if (p.charAt(pi - 1) != '.') {
                    for (int si = 0; si < sLen; si++) {
                        if (match[si + 1][pi]
                                || pi > 0 && match[si + 1][pi - 1]
                                || si > 0 && pi > 0 && match[si][pi + 1]
                                && s.charAt(si) == s.charAt(si - 1)
                                && s.charAt(si - 1) == p.charAt(pi - 1)) {
                            match[si + 1][pi + 1] = true;
                        }
                    }
                } else {
                    int si = 0;
                    while (si < sLen && !match[si + 1][pi - 1] && !match[si + 1][pi]) {
                        si++;
                    }
                    while (si < sLen) {
                        match[si + 1][pi + 1] = true;
                        si++;
                    }

                }
            } else {
                for (int si = 0; si < sLen; si++) {
                    if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) ==  '.') {
                        match[si + 1][pi + 1] = match[si][pi];
                    }
                }
            }
        }
        return match[sLen][pLen];
    } // dynamic program
}
