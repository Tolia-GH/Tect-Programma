package Main.Game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    private Team team1;
    private Team team2;
    private String result;

    public String play() {
        if (team1 == null || team2 == null) {
            throw new RuntimeException("There are no 2 teams.");
        }

        if (team1.equals(team2)){
            throw new RuntimeException("One team can't play with itself.");
        }

        // Make sure both of team have the same number of members.
        checkBalance();

        double teamScore1 = Math.random();
        double teamScore2 = Math.random();

        if (teamScore1 > teamScore2){
            result = team1.getName() + " win!";
        } else if (teamScore2 > teamScore1){
            result = team2.getName() + " win!";
        } else{
            result = "Game draws";
        }

        System.out.println(result);
        return result;
    }

    public void checkBalance() {
        if (team1 == null || team2 == null){
            throw new RuntimeException("Game must have 2 different teams.");
        }
        int size1 = team1.getTeamSize();
        int size2 = team2.getTeamSize();

        if (size1 == 0 || size2 == 0) {
            throw new RuntimeException("Team can't be empty!");
        }

        if (size1 == size2) {
            return;
        }
        System.out.println("The two teams have different numbers. \n" +
                "The team with the larger number of players will be randomly reduced.");
        if (size1 > size2) {
            team1.deleteRandomMembers(size1 - size2);
        } else {
            team2.deleteRandomMembers(size2 - size1);
        }
    }


}
