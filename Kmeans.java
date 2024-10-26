import java.lang.*;

class Main{
    public static void main(String args[]) {
        int N = 9;
        int arr[] = {2, 4, 10, 12, 3, 20, 30, 11, 25}; // initial data
        int i, m1, m2, a, b, n = 0;
        boolean flag = true;
        a = arr[0];
        b = arr[1];
        m1 = a;
        m2 = b;
        int cluster1[] = new int[N];
        int cluster2[] = new int[N];

        System.out.println("Initial data:");
        for (i = 0; i < N; i++)
            System.out.print(arr[i] + "\t");
        System.out.println();

        do {
            n++;
            int k = 0, j = 0;
            float sum1 = 0, sum2 = 0; // Reset sum1 and sum2 for each iteration

            for (i = 0; i < N; i++) {
                if (Math.abs(arr[i] - m1) <= Math.abs(arr[i] - m2)) {
                    cluster1[k] = arr[i];
                    sum1 += arr[i];
                    k++;
                } else {
                    cluster2[j] = arr[i];
                    sum2 += arr[i];
                    j++;
                }
            }

            int newM1 = k == 0 ? m1 : Math.round(sum1 / k);
            int newM2 = j == 0 ? m2 : Math.round(sum2 / j);

            if (newM1 == m1 && newM2 == m2)
                flag = false;
            else
                flag = true;

            m1 = newM1;
            m2 = newM2;

            System.out.println("After iteration " + n + ", cluster 1:");
            for (i = 0; i < k; i++)
                System.out.print(cluster1[i] + "\t");
            System.out.println();

            System.out.println("After iteration " + n + ", cluster 2:");
            for (i = 0; i < j; i++)
                System.out.print(cluster2[i] + "\t");
            System.out.println();

        } while (flag);

        System.out.println("Final cluster 1:");
        for (i = 0; i < N && cluster1[i] != 0; i++)
            System.out.print(cluster1[i] + "\t");
        System.out.println();

        System.out.println("Final cluster 2:");
        for (i = 0; i < N && cluster2[i] != 0; i++)
            System.out.print(cluster2[i] + "\t");
        System.out.println();
    }
}
