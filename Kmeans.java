import java.io.*;
import java.lang.*;

class Kmean {
    public static void main(String args[]) {
        int N = 9;
        int arr[] = {2, 4, 10, 12, 3, 20, 30, 11, 25}; // initial data
        int i, m1, m2, a, b, n = 0;
        boolean flag = true;
        float sum1 = 0, sum2 = 0;
        a = arr[0]; 
        b = arr[1];
        m1 = a; 
        m2 = b;
        int cluster1[] = new int[9];
        int cluster2[] = new int[9];

        for (i = 0; i < 9; i++)
            System.out.print(arr[i] + "\t");
        System.out.println();

        do {
            n++;
            int k = 0, j = 0;
            sum1 = 0; // Reset sum1 and sum2 for each iteration
            sum2 = 0;

            for (i = 0; i < 9; i++) {
                if (Math.abs(arr[i] - m1) <= Math.abs(arr[i] - m2)) {
                    cluster1[k] = arr[i];
                    k++;
                } else {
                    cluster2[j] = arr[i];
                    j++;
                }
            }

            m1 = Math.round(sum1 / k);
            m2 = Math.round(sum2 / j);

            if (m1 == a && m2 == b)
                flag = false;
            else
                flag = true;

            System.out.println("After iteration " + n + ", cluster 1:");
            for (i = 0; i < k; i++)
                System.out.print(cluster1[i] + "\t");
            System.out.println();

            System.out.println("After iteration " + n + ", cluster 2:");
            for (i = 0; i < j; i++)
                System.out.print(cluster2[i] + "\t");
            System.out.println();

            a = m1;
            b = m2;

        } while (flag);

        System.out.println("Final cluster 1:");
        for (i = 0; i < N; i++)
            if (i < k) System.out.print(cluster1[i] + "\t");
        System.out.println();

        System.out.println("Final cluster 2:");
        for (i = 0; i < N; i++)
            if (i < j) System.out.print(cluster2[i] + "\t");
        System.out.println();
    }
}
