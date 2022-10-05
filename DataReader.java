import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class DataReader {
    public static void mapReader(String filename){
        try (Scanner scan = new Scanner(new BufferedReader(new FileReader(filename)))){
            while(scan.hasNextLine()){
                ArrayList<Symbol> lineOfMap = new ArrayList<>();
                String[] Line = scan.nextLine().split(" ");
                for(String shape : Line){
                    switch (shape) {
                        case "D":
                        case "S": 
                        case "T":
                        case "W":  
                            lineOfMap.add(new Jewel(shape));
                            break;                         
                        case "/":
                        case "-":
                        case "+":
                        case "\\":
                        case "|":
                            lineOfMap.add(new MathematicalSymbols(shape));
                            break;
                    }
                    
                }
                Game.Map.add(lineOfMap);
            }
        } catch (Exception e) {}
    }
    public static void leaderboardReader(){
        try (Scanner scan = new Scanner(new BufferedReader(new FileReader("leaderboard.txt")))){
            while(scan.hasNextLine()){
                Game.players.add(new Gamer(scan.next(), scan.nextInt()));
            }
        }
        catch(Exception e){}
    }
    
}
