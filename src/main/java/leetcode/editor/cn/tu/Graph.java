package leetcode.editor.cn.tu;

public class Graph {

    public char[] vexs;     //顶点
    public int[][] arc;     //邻接矩阵
    int numVexs;            //顶点数
    int numEdges;           //边数

    public Graph(int nVexs,int nEdg){
        this.numVexs = nVexs;
        this.numEdges = nEdg;
    }
}