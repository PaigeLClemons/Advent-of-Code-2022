package Day2;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day2Solution{
    public static void main(String[] args){
        try{
            File inputFile = new File("Day2/input.txt");
            Scanner scanner = new Scanner(inputFile);

            ArrayList<String> input = new ArrayList<String>();
            int score = 0;

            while(scanner.hasNextLine()){
                input.add(scanner.nextLine());
            }

            String game;
            /*
             * Scenarios:
             * - rock beats scissors
             * - paper beats rock
             * - scissors beats paper
             */
            for(int i = 0; i < input.size(); i++){
                game = input.get(i);
                score += scoreBasedOnMove(game.charAt(2));
                if((game.charAt(0) == 'A' && game.charAt(2) == 'X') || (game.charAt(0) == 'B' && game.charAt(2) == 'Y') || (game.charAt(0) == 'C' && game.charAt(2) == 'Z')){
                    score += 3;
                }
                else if(game.charAt(0) == 'C' && game.charAt(2) == 'X'){
                    score += 6;
                }
                else if(game.charAt(0) == 'A' && game.charAt(2) == 'Y'){
                    score += 6;
                }
                else if(game.charAt(0) == 'B' && game.charAt(2) == 'Z'){
                    score += 6;
                }
            }

            System.out.println("answer to part one = " + score);

            //Part 2
            score = 0;
            for(int i = 0; i < input.size(); i++){
                game = input.get(i);
                score += scoreBasedOnOutcome(game.charAt(2));
                //Draw
                if(game.charAt(2) == 'Y'){
                    if(game.charAt(0) == 'A'){
                        score += scoreBasedOnMove('X');
                    }
                    else if(game.charAt(0) == 'B'){
                        score += scoreBasedOnMove('Y');
                    }
                    else if(game.charAt(0) == 'C'){
                        score += scoreBasedOnMove('Z');
                    }
                }
                //Win
                else if(game.charAt(2) == 'Z'){
                    if(game.charAt(0) == 'A'){
                        score += scoreBasedOnMove('Y');
                    }
                    else if(game.charAt(0) == 'B'){
                        score += scoreBasedOnMove('Z');
                    }
                    else if(game.charAt(0) == 'C'){
                        score += scoreBasedOnMove('X');
                    }
                }
                //Lose
                else if(game.charAt(2) == 'X'){
                    if(game.charAt(0) == 'A'){
                        score += scoreBasedOnMove('Z');
                    }
                    else if(game.charAt(0) == 'B'){
                        score += scoreBasedOnMove('X');
                    }
                    else if(game.charAt(0) == 'C'){
                        score += scoreBasedOnMove('Y');
                    }
                }
            }

            System.out.println("answer to part two = " + score);

            scanner.close();
        }
        catch(FileNotFoundException e){
            System.out.println("There is no file you fool");
            e.printStackTrace();
        }
    }

    static private int scoreBasedOnMove(char move){
        if(move == 'X'){
            return 1;
        }
        else if(move == 'Y'){
            return 2;
        }
        return 3;
    }

    static private int scoreBasedOnOutcome(char outcome){
        if(outcome == 'Y'){
            return 3;
        }
        else if(outcome == 'Z'){
            return 6;
        }
        return 0;
    }
}