package leetcode.editor.cn.sousuo;

import leetcode.editor.cn.tu.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyGraph {
    public  static char[] vexs = {};     //顶点
    public  static  int[][] arc= {};    //邻接矩阵
    public  static int numVexs = 7;
    public  static  boolean [] visited = new boolean[numVexs];;  //已经被拜访的点

    public static void main(String[] args) {
        init();
      //  dfs(0);
        bfs();
    }
    public static void bfs(){
        Queue<Integer> que =  new LinkedList<Integer>();

        for(int i = 0; i < numVexs; i++){
            if(!visited[i]){
                visited[i] = true;
                System.out.println("正在访问的节点是 ：" + vexs[i]);
                que.add(i);
                while(!que.isEmpty()){
                    que.remove();
                    for(int j = 0; j <numVexs; j++){
                        if(arc[i][j] == 1 && !visited[j]){
                            visited[j] = true;
                            System.out.println("正在访问的节点是 ：" + vexs[j]);
                            que.add(j);
                        }
                    }
                }
            }
        }
    }

    private static void dfs(int k) {
        visited[k] = true;
        System.out.println("正访问的结点是 ： " + vexs[k]);
        for(int i = 0; i < vexs.length; i++){
            if(arc[k][i] == 1 && !visited[i])
                dfs(i);
        }
    }
    
    public static void init(){
        vexs = new char[numVexs];
        vexs[0] = 'A';
        vexs[1] = 'B';
        vexs[2] = 'C';
        vexs[3] = 'D';
        vexs[4] = 'E';
        vexs[5] = 'F';
        vexs[6] = 'G';

        arc = new int[numVexs][numVexs];
        arc[0][1] = 1;
        arc[1][0] = 1;
        arc[0][4] = 1;
        arc[4][0] = 1;
        arc[1][2] = 1;
        arc[2][1] = 1;
        arc[2][3] = 1;
        arc[3][2] = 1;
        arc[3][4] = 1;
        arc[4][3] = 1;
        arc[2][5] = 1;
        arc[5][2] = 1;
        arc[1][5] = 1;
        arc[5][1] = 1;
        arc[6][3] = 1;
        arc[3][6] = 1;

        visited = new boolean[numVexs];
        for(int i = 0; i < numVexs; i++){
            visited[i] = false;
        }
    }
}
