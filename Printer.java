import java.io.FileWriter;
import java.util.ArrayList;

public class Printer {
    public static void PrintMap(ArrayList<ArrayList<Symbol>> Map){
        try (FileWriter writer = new FileWriter("monitoring.txt",true)){
            for(ArrayList<Symbol> partOfMap : Map){
                for(Symbol symb: partOfMap){
                    writer.write(symb + " ");
                }
                writer.write("\n");
            }
            writer.write("\n");
        } catch (Exception e) {System.out.println("File Not Found.");}       
    }
    public static void CloseGame(Gamer player){
        try (FileWriter writer = new FileWriter("monitoring.txt",true)){
            writer.write("Select coordinate or enter E to end the game: E\n\n");
            writer.write("Total score: " + Game.Points + " points\n\n");
            writer.write("Enter name: " + player.getName() + "\n\n");
            if(Game.players.indexOf(player) == 0){
                Integer higherpoint = Game.Points - Game.players.get(1).getPoint();
                writer.write("Your rank is " + (Game.players.indexOf(player) + 1) + "/" + Game.players.size() + ",your score is " + higherpoint + " points higher than " + 
                Game.players.get(1).getName() + "\n\n");
            }
            else if(Game.players.indexOf(player) == Game.players.size() - 1){
                Integer lowerpoint = Game.players.get(Game.players.size() - 2).getPoint() - Game.Points;
                writer.write("Your rank is " + (Game.players.indexOf(player) + 1) + "/" + Game.players.size() + ",your score is " + lowerpoint + " points lower than " + 
                Game.players.get(Game.players.size() - 2).getName() + "\n\n");
            }
            else{
                Integer higherpoint = Game.Points - Game.players.get(Game.players.indexOf(player) + 1).getPoint();
                Integer lowerpoint = Game.players.get(Game.players.indexOf(player) - 1).getPoint() - Game.Points;
                writer.write("Your rank is " + (Game.players.indexOf(player) + 1) + "/" + Game.players.size() + ",your score is " + lowerpoint + " points lower than " + 
                Game.players.get(Game.players.indexOf(player) - 1).getName() + " and " + higherpoint + " higher than " + Game.players.get(Game.players.indexOf(player) + 1).getName() + "\n\n");
            }
            writer.write("Good bye!");
        }
        catch (Exception e){}
    }
    public static void leaderboardPrinter(){
        try (FileWriter writer = new FileWriter("leaderboard.txt",true)){
            for(Gamer player: Game.players){
                writer.write(player + "\n");
            }
            
        }
        catch (Exception e){}
    }
    public static void startGame(){
        try (FileWriter writer = new FileWriter("monitoring.txt",true)){
            writer.write("Game grid: \n\n");                   
        }       
        catch (Exception e){}
        PrintMap(Game.Map);   
    }
    public static void writeInput(Integer row, Integer column){
        try (FileWriter writer = new FileWriter("monitoring.txt",true)){
            writer.write("Select coordinate or enter E to end the game:"+ row + " "+ column + "\n\n");
        }
        catch (Exception e){}
        PrintMap(Game.Map);
        try (FileWriter writer = new FileWriter("monitoring.txt",true)){
            writer.write("Score: "+ Game.tempPoint + " points\n\n");
        }
        catch (Exception e){}
    }
    public static void WrongInput(){
        try (FileWriter writer = new FileWriter("monitoring.txt",true)){
            writer.write("Please enter a valid coordinate\n\n");
        }
        catch (Exception e){}
    }
}
