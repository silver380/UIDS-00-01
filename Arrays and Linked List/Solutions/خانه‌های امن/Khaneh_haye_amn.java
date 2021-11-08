//Majid Soltanian
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class KhaneHayAmn
{
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        int n = input.nextInt();
        int m = input.nextInt();

        int[][] locations = new int[m][];

        boolean[] rows = new boolean[n];
        Arrays.fill(rows, true);

        boolean[] columns = new boolean[n];
        Arrays.fill(columns, true);

        for (int i = 0; i < m; ++i)
        {
            locations[i] = new int[2];

            locations[i][0] = input.nextInt() - 1;
            rows[locations[i][0]] = false;

            locations[i][1] = input.nextInt() - 1;
            columns[locations[i][1]] = false;

            BigInteger numberOfSafeRows = new BigInteger("0");
            BigInteger numberOfSafeColumns = new BigInteger("0");

            for (int j = 0; j < n; ++j)
            {
                if (rows[j])
                {
                    numberOfSafeRows = numberOfSafeRows.add(new BigInteger("1"));
                }

                if (columns[j])
                {
                    numberOfSafeColumns = numberOfSafeColumns.add(new BigInteger("1"));
                }
            }

            System.out.print(numberOfSafeRows.multiply(numberOfSafeColumns) + " ");
        }
    }
}