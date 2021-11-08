//by Erfan Samimi
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){



        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        float[] allPrices = new float[testCases];


        for (int i =0 ; i<testCases ; i++){
            int characters = sc.nextInt();
            HashMap<String , Integer> prices = new HashMap<>();
            sc.nextLine();
            for (int j=0 ; j<characters ; j++){
                String temp = sc.nextLine();
                String [] character_price = temp.split(" ");
                prices.put(character_price[0], Integer.valueOf(character_price[1]));
            }

            int numberOfLines = sc.nextInt();
            String text = "";

            sc.nextLine();
            for (int j=0 ; j<numberOfLines ; j++){
                String str = sc.nextLine();
                text += str;
            }


            allPrices[i] = calculatePrice(text, prices);

        }

        showOutPut(allPrices);


    }



    static float calculatePrice(String text , HashMap<String , Integer> prices){

        int price = 0;

        for (String a : prices.keySet()){
            String regex = "[" + a + "]";
            int count = text.length() - text.replaceAll(regex,"").length();
            price += count * prices.get(a);
        }

        return price/100F;

    }

    static void showOutPut(float[] prices){

        for (float price : prices) {
            String output = String.format("%.2f$", price);
            System.out.println(output);

        }

    }
}
