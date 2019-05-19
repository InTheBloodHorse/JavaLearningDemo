package inthebloodhorse.algorithm.string;

public class RemoveDuplicates {
    public String removeDuplicates(String S) {
        StringBuilder s = new StringBuilder(S);
        while (true) {
            int flag = 1;
            for (int i = s.length() - 1; i > 0; i--) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    s.deleteCharAt(i);
                    s.deleteCharAt(i - 1);
                    i--;
                    flag = 0;
                }
            }
            if (flag == 1) break;
        }
        return s.toString();
    }

    public static void main(String[] args) {
        new RemoveDuplicates().removeDuplicates("aaaaaaaa");
    }
}
