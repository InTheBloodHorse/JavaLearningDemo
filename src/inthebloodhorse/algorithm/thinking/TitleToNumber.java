package inthebloodhorse.algorithm.thinking;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 */
public class TitleToNumber {
    public int titleToNumber(String s) {
        int ans = 0;
        int len = s.length();
        int po = 1;
        for (int i = len - 1, j = 0; i >= 0; i--, j++) {
            char index = s.charAt(i);
            ans += (index - 'A' + 1) * po;
            po *= 26;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new TitleToNumber().titleToNumber("AAA"));
    }
}
