package Main.Game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Siyuan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    private String name;
    private List<HyperintelligentBeing> members = new ArrayList<>();

    public void deleteRandomMembers(int numOfMem){
        int size = members.size();
        if (size <= numOfMem) {
            throw new IllegalArgumentException("Can't delete too many members. At the least leave one guy for the game.");
        }

        while (numOfMem > 0){
            int x = members.size();
            int random = new Random().nextInt(x);
            members.remove(random);
            numOfMem--;
        }
    }

    public int getTeamSize(){
        if (members == null) {
            members = new ArrayList<>();
        }
        return members.size();
    }

    public void addMember(HyperintelligentBeing hb){
        if (members == null) {
            members = new ArrayList<>();
        }
        members.add(hb);
    }


}
