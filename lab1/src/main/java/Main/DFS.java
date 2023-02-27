package Main;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

@Data
public class DFS {
    private boolean [] visited;
    private int [] parent;

    private Stack<Integer> stack = new Stack<>();
    private int size;
    public DFS(int size){
        this.visited = new boolean[size];
        Arrays.fill(this.visited,false);
        this.parent = new int[size];
        Arrays.fill(this.parent,-1);
        this.size = size;
    }

    private int findFree(int [] node){
        for(int i = 0; i < node.length; i++){
            if(!this.visited[node[i]]){
                return i;
            }
        }
        return -1;
    }
    public void solve(int[][] map,int start){
        if(start >= this.size){
            throw new IllegalArgumentException("Start index out of range");
        }
        for(int i = 0; i < map.length; i++){
            int [] node = map[i];
            Arrays.sort(node);
            for(int j = 0; j < node.length; j++){
                if(j + 1 > this.size){
                    throw new IllegalArgumentException("Amount of node in map is out of range");
                }
                if(node[j] + 1 > this.size){
                    throw new IllegalArgumentException("Value of node in map is out of range");
                }
            }
        }
        this.visited[start] = true;
        boolean firstLoop = true;
        int temp = start;
        this.stack.push(temp);
        while(true){
            if(!firstLoop && temp == start && findFree(map[temp])==-1){
                break;
            }else{
                firstLoop = false;
            }
            int[] node = map[temp];
            if (node.length != 0){
                int result = findFree(node);
                if(result == -1){
                    temp = this.stack.pop();
                    if (!this.stack.empty()) {
                        temp = this.stack.peek();
                    }
                }else{
                    parent[node[result]] = temp;
                    temp = node[result];
                    this.visited[node[result]] = true;
                    this.stack.push(node[result]);
                }
            }else {
                temp = this.stack.pop();
                if (!this.stack.empty()) {
                    temp = this.stack.peek();
                }
            }
        }
    }
}
