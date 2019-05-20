package inthebloodhorse.algorithm.priorityqueue;

import java.util.PriorityQueue;
import java.util.Queue;

// 找出第K小的数字
public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                queue.add(matrix[i][j]);
            }
        }
        while(k-->1){
            queue.poll();
        }
        return queue.peek();

    }
}
