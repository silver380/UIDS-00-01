import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sin = new Scanner(System.in);
        int  n = sin.nextInt();

        int [] arr = new int[n];

        for (int i = 0; i <n ; i++) {
            arr[i]=sin.nextInt();
        }

        int maxDiff = maxIndexDiff(arr,n);

        if(maxDiff==0){
            System.out.println("YOU DIED");
        }
        else
            System.out.println(maxDiff);
    }

    static int maxIndexDiff(int[] arr,int n){

        int maxDiff;
        int i, j;

        int[] LMin = new int[ n];
        int[] RMax = new int[ n];
        LMin[0] = arr[0];
        for (i = 1; i < n; ++i)
            LMin[i] = Math.min(arr[i], LMin[i - 1]);
        RMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j)
            RMax[j] = Math.max(arr[j], RMax[j + 1]);

        i = 0; j = 0; maxDiff = -1;
        while (j < n && i < n) {
            if (LMin[i] <= RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            }
            else
                i = i + 1;
        }

        return maxDiff;
    }





}

