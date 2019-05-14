package inthebloodhorse.algorithm.array;

/*
    在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
    每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一
    个整数，判断数组中是否含有该整数。
 */

/*
    思路 二分
 */
public class findNumber {

    public Boolean bin(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] == target) {
                return true;
            }
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return false;
    }

    public boolean Find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (bin(array[i], target)) {
                return true;
            }
        }
        return false;
    }
}
