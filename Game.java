import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
    public static ArrayList<ArrayList<Symbol>> Map = new ArrayList<>();
    public static Integer tempPoint = 0;
    public static Integer Points = 0;
    public static ArrayList<Gamer> players = new ArrayList<>();
    public static void Start(String[] args){
        DataReader.mapReader(args[0]);       
        DataReader.leaderboardReader();
        GameTools tool = new GameTools();
        try (Scanner scan = new Scanner(new BufferedReader(new FileReader(args[1])))){
            Printer.startGame();
            while(scan.hasNext()){
                String[] line = scan.nextLine().split(" ");
                switch (line[0]) {
                    case "E":
                        Gamer player = new Gamer(scan.next(), Points);
                        players.add(player);
                        Printer.leaderboardPrinter();
                        Collections.sort(players, Collections.reverseOrder());
                        Printer.CloseGame(player);
                        break;               
                    default:
                        Integer row = Integer.parseInt(line[0]);
                        Integer column = Integer.parseInt(line[1]);
                        if(row >= 0 && row < Game.Map.size() && column >= 0 && column < Game.Map.get(0).size() && !Game.Map.get(row).get(column).getShape().equals(" ")){
                            tool.Match(row, column);
                            Printer.writeInput(row, column);
                        }
                        else{Printer.WrongInput();}
                        break;
                }
            }
        }
        catch (Exception e){}
    }
}
