package leetcode.editor.cn.tu;

public class Demo {
    public static void main(String[] args) {
        int numVexs = 7;
        int numEdges = 6;
        Graph gh = new Graph(numVexs,numEdges);
        gh.vexs = new char[numVexs];
        gh.vexs[0] = 'A';
        gh.vexs[1] = 'B';
        gh.vexs[2] = 'C';
        gh.vexs[3] = 'D';
        gh.vexs[4] = 'E';
        gh.vexs[5] = 'F';
        gh.vexs[6] = 'G';

        gh.arc = new int[numVexs][numVexs];
        gh.arc[0][1] = 1;
        gh.arc[1][0] = 1;
        gh.arc[0][4] = 1;
        gh.arc[4][0] = 1;
        gh.arc[1][2] = 1;
        gh.arc[2][1] = 1;
        gh.arc[2][3] = 1;
        gh.arc[3][2] = 1;
        gh.arc[3][4] = 1;
        gh.arc[4][3] = 1;
        gh.arc[2][5] = 1;
        gh.arc[5][2] = 1;
        gh.arc[1][5] = 1;
        gh.arc[5][1] = 1;
        gh.arc[6][3] = 1;
        gh.arc[3][6] = 1;

        System.out.println("********************广度优先搜索********************");
        GraphDFS ghDFS = new GraphDFS();
        ghDFS.DFSraverse(gh);
        System.out.println("********************广度优先搜索********************");
        GraphBFS ghBFS = new GraphBFS();
        ghBFS.BFSraverse(gh);
    }
}
