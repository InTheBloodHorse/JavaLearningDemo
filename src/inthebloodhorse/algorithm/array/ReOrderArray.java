package inthebloodhorse.algorithm.array;

/*
    输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
    使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
    并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public void reOrderArray(int[] array) {
        int index1 = 0;
        int index2 = 0;
        int[] odd = new int[array.length];
        int[] even = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                odd[index1++] = array[i];
            } else {
                even[index2++] = array[i];
            }
        }
        int[] result = new int[array.length];
        for (int i = 0; i < index1; i++) {
            result[i] = odd[i];
        }
        for (int i = 0; i < index2; i++) {
            result[i + index1] = even[i];
        }
//        System.out.println(Arrays.toString(result));
        System.arraycopy(result, 0, array, 0, result.length);
//        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        new ReOrderArray().reOrderArray(new int[]{1, 2, 3, 4, 5, 6, 6});
    }
}
