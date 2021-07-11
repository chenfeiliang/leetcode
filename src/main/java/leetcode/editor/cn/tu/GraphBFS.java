package leetcode.editor.cn.tu;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {

    public void BFSraverse(Graph gh){

        Queue<Integer> que =  new LinkedList<Integer>();
        boolean[] visited = new boolean[gh.numVexs];
        for(int i = 0; i < gh.numVexs; i++)
            visited[i] = false;

        for(int i = 0; i < gh.numVexs; i++){

            if(!visited[i]){

                visited[i] = true;
                System.out.println("正在访问的节点是 ：" + gh.vexs[i]);
                que.add(i);

                while(!que.isEmpty()){
                    que.remove();

                    for(int j = 0; j <gh.numVexs; j++){

                        if(gh.arc[i][j] == 1 && !visited[j]){
                            visited[j] = true;
                            System.out.println("正在访问的节点是 ：" + gh.vexs[j]);
                            que.add(j);
                        }
                    }
                }
            }
        }
    }
}
