package inthebloodhorse.algorithm.string;

/*
    给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {

        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                stringBuilder.append(chars[i]);
            } else if (Character.isUpperCase(chars[i]) || Character.isLowerCase(chars[i])) {
                stringBuilder.append(Character.toUpperCase(chars[i]));
            }
        }
        chars = stringBuilder.toString().toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
