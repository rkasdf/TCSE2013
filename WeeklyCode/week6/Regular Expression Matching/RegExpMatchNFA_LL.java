import java.util.*;

/**
 * Created by LL on 2015/1/25.
 */
public class RegExpMatchNFA {
    class DiGraph {
        private int adjMatrix[][];

        DiGraph(int v) {
            adjMatrix = new int[v][v];
        }

        public void addEdge(int v, int w) {
            adjMatrix[v][w] = 1;
        }

        public int[][] getAdjMatrix() {
            return adjMatrix;
        }
    }

    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        int[][] matrix = genNFA(p).getAdjMatrix();
        LinkedList<Integer> pStack = new LinkedList<Integer>();

        int i = 0;
        int[] count = new int[sLen + 1]; // count stands for the total of next nodes
        while (i <= pLen) {
            int si = 0;
            pStack.push(i);
            count[si]++;
            while (!pStack.isEmpty()) {
                int pi = pStack.pop();
                while (si >= 0 && count[si] == 0) {
                    si--;
                }
                if (si < 0) break;
                count[si]--;

                if (pi == pLen && si == sLen) return true;

                if (pi < pLen && si < sLen && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.')) {
                    si++;
                    for (int j = 0; j < pLen + 1; j++) {
                        if (matrix[pi][j] == 1) {
                            if (j < pLen && p.charAt(j) == '*') {
                                for (int k = 0; k < pLen + 1; k++) {
                                    if (matrix[j][k] == 1) {
                                        pStack.push(k);
                                        count[si]++;
                                    }
                                }
                            } else {
                                pStack.push(j);
                                count[si]++;
                            }
                        }
                    }
                }
            }
            if (i < pLen - 1 && p.charAt(i + 1) == '*') {
                i += 2;
            } else {
                break;
            }
        }
        return false;
    }

    public DiGraph genNFA(String reg) {
        int len = reg.length();
        DiGraph dg = new DiGraph(len + 1); // the graph node start from 0
        for (int i = 0; i < len; i++) {
            dg.addEdge(i, i + 1);
            if (reg.charAt(i) == '*') {
                dg.addEdge(i, i - 1);
                int j = i - 2;
                while (j >= 0) {
                    dg.addEdge(j, i + 1);
                    if (reg.charAt(j) == '*') {
                        j -= 2;
                    } else {
                        break;
                    }
                }
            }
        }
        return dg;
    }

    public static void main(String[] args) {
        RegExpMatchNFA rem = new RegExpMatchNFA();
//        int[][] matrix = rem.genNFA("a*b*c").getAdjMatrix();
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(rem.isMatch("bc", "a*b*c"));
    }
}
