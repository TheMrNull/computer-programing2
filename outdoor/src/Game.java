import java.util.HashMap;
import java.util.Objects;

public class Game {
    static void main(String[] args) {
        HashMap<Player,Integer> leaderboard = new HashMap<>();

        Player p1 = new Player("zMxster5840");
        leaderboard.put(p1,5000);

        p1.username = "notModo";

        Integer score = leaderboard.get(p1);
        System.out.println("score: "+score);
    }

}


    class Player{
        String username;
        public Player(String username){
            this.username = username;
        }

        @Override
        public int hashCode(){
            return username.hashCode();
        }

        @Override
        public boolean equals(Object obj){
            if(this == obj){
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) return false;
            Player other = (Player) obj;
            return this.username.equals(other.username);
        }

    }
