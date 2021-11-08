//by Mahsa Aghaie
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ayrees {
    public static int largest(int[]arr)
    {
        int i;
        int max = arr[0];
        for (i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }
    public static int IndexOfLargest(int[]arr)
    {
        int i;
        int max = arr[0];
        int indexOfMax = 0;
        for (i = 1; i < arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
                indexOfMax=i;
            }
        }
        return indexOfMax;
    }
    // Function to remove the element
    public static int[] removeTheElement(int[] arr, int index)
    {
        if (arr == null || index < 0
                || index >= arr.length) {

            return arr;
        }
        int[] anotherArray = new int[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        ArrayList<int[]> arrays=new ArrayList<>();
        int[]zero={0};
        for(int k=0;k<num;k++){
            int n=sc.nextInt();
            int[]arr=new int[n+2];
            for(int i=0;i<arr.length;i++){
                arr[i]=sc.nextInt();
            }
            int max=largest(arr);
            long sum=0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]!=max){
                    sum+=arr[i];
                }
            }
            long supposed=sum-max;
            int indexOfS=0;
            boolean isTrue=false;
            for(int i=0;i<arr.length;i++){
                if(arr[i]==supposed){
                    isTrue=true;
                    indexOfS=i;
                }
            }
            if(isTrue){
                int[]arr1= removeTheElement(arr,indexOfS);
                int indexOfMax=IndexOfLargest(arr1);
                int[]arr2= removeTheElement(arr1,indexOfMax);
                Arrays.sort(arr2);
                arrays.add(arr2);
               /* for(int i=0;i<arr2.length;i++){
                    System.out.print(arr2[i]+" ");
                }*/
            }else{
                arrays.add(zero);
                //System.out.println(-1);
            }

        }
        for(int i=0;i<arrays.size();i++){
            if(arrays.get(i)!=zero){
                for(int j=0;j<arrays.get(i).length;j++){
                    System.out.print(arrays.get(i)[j]+" ");
                }
                System.out.println();
            }else{
                System.out.println(-1);
            }
        }
    }
}
