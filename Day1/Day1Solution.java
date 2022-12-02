package Day1;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day1Solution{
    public static void main(String[] args){
        try{
            File inputFile = new File("Day1/input.txt");
            Scanner scanner = new Scanner(inputFile);

            ArrayList<String> input = new ArrayList<String>();
            ArrayList<Integer> calorieTotals = new ArrayList<Integer>();

            while(scanner.hasNextLine()){
                input.add(scanner.nextLine());
            }

            int total = 0;

            for(int i = 0; i < input.size(); i++){
                System.out.println(input.get(i));
                if(!input.get(i).equals("")){
                    total += Integer.parseInt(input.get(i));
                }
                else if(input.get(i).equals("")){
                    calorieTotals.add(total);
                    total = 0;
                }
            }

            int max = calorieTotals.get(0);

            for(int i = 1; i < calorieTotals.size(); i++){
                if(calorieTotals.get(i) > max){
                    max = calorieTotals.get(i);
                }
            }

            System.out.println("answer to part one = " + max);

            //Part 2
            for(int i = 0; i < calorieTotals.size(); i++){
                for(int j = 0; j < calorieTotals.size() - 1; j++){
                    if(calorieTotals.get(j + 1) > calorieTotals.get(j)){
                        int temp = calorieTotals.get(j);
                        calorieTotals.set(j, calorieTotals.get(j + 1));
                        calorieTotals.set(j + 1, temp);
                    }
                }
            }

            System.out.println("Check sort:");
            for(int i = 0; i < calorieTotals.size(); i++){
                System.out.println(calorieTotals.get(i));
            }

            int topThreeTotal = calorieTotals.get(0) + calorieTotals.get(1) + calorieTotals.get(2);

            System.out.println("answer to part two = " + topThreeTotal);

            scanner.close();
        }
        catch(FileNotFoundException e){
            System.out.println("There is no file you fool");
            e.printStackTrace();
        }
    }
}