
//在一个小镇里，按从 1 到 n 为 n 个人进行编号。传言称，这些人中有一个是小镇上的秘密法官。 
//
// 如果小镇的法官真的存在，那么： 
//
// 
// 小镇的法官不相信任何人。 
// 每个人（除了小镇法官外）都信任小镇的法官。 
// 只有一个人同时满足条件 1 和条件 2 。 
// 
//
// 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示编号为 a 的人信任编号为 b 的人。 
//
// 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的编号。否则，返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2, trust = [[1,2]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：n = 3, trust = [[1,3],[2,3]]
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：n = 3, trust = [[1,3],[2,3],[3,1]]
//输出：-1
// 
//
// 示例 4： 
//
// 
//输入：n = 3, trust = [[1,2],[2,3]]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
//输出：3 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 0 <= trust.length <= 104 
// trust[i].length == 2 
// trust[i] 互不相同 
// trust[i][0] != trust[i][1] 
// 1 <= trust[i][0], trust[i][1] <= n 
// 
// Related Topics 图 数组 哈希表 
// 👍 128 👎 0

package leetcode.editor.cn;

import java.util.*;

public class P997_FindTheTownJudge {


    public static void main(String[] args) {
        Solution solution = new P997_FindTheTownJudge().new Solution();
        int judge = solution.findJudge(3, new int[][]{
                {1, 3},
                {2, 3},
                {3, 1}
        });
        System.out.println(judge);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] arc;    //邻接矩阵

        public int in[] ;

        public int out [];

        //        //已经被拜访的点
//        public int[] visited ;
        public int findJudge(int n, int[][] trust) {
            if (n == 1) return 1;
            init(n,trust);
            for(int i = 1 ;i<=n;i++){
                if(in[i]==n-1&&out[i]==0){
                    return i;
                }
            }
            return -1;
        }

//        public int findJudge(int n, int[][] trust) {
//            if(n==1) return 1;
//
//            init(n,trust);
//            for (int i = 1; i <= n; i++) {
//                boolean flag = true;
//                for(int j = 1;j<=n ;j++){
//                    if(i!=j&&arc[i][j]==0){
//                        flag = false;
//                        break;
//                    }
//                    if(i!=j&&arc[j][i]==1){
//                        flag = false;
//                        break;
//                    }
//                }
//                if(flag){
//                    return i;
//                }
//            }
//            return -1 ;
//        }

        public void init(int n, int[][] trust) {
            in = new int[n+1];
            out = new int[n+1];
            for (int i = 0; i < trust.length; i++) {
                int belive = trust[i][0];
                int belived = trust[i][1];
                in[belived]++;
                out[belive]++;
            }
        }

//        public void init(int n, int[][] trust) {
//            arc = new int[n + 1][n + 1];
//            // visited = new int[n+1];
//            for (int i = 0; i < trust.length; i++) {
//                int belive = trust[i][0];
//                int belived = trust[i][1];
//                arc[belived][belive] = 1;
//            }
//        }


//        public int findJudge(int n, int[][] trust) {
//            if (n == 1) {
//                return 1;
//            }
//            Set<Integer> beliveSet = new HashSet<>();
//            Set<Integer> belivedSet = new HashSet<>();
//            int[][] mytrust = new int[n + 1][n + 1];
//            for (int i = 0; i < trust.length; i++) {
//                int belive = trust[i][0];
//                int belived = trust[i][1];
//                mytrust[belive][belived] = 1;
//                beliveSet.add(belive);
//                belivedSet.add(belived);
//            }
//            Iterator<Integer> iterator = belivedSet.iterator();
//            while (iterator.hasNext()) {
//                Integer next = iterator.next();
//                if (beliveSet.contains(next)) {
//                    continue;
//                }
//                boolean flag = true;
//                for (int i = 1; i <= n; i++) {
//                    if (i != next && mytrust[i][next] == 0) {
//                        flag = false;
//                    }
//                }
//                if (flag) {
//                    return next;
//                }
//            }
//            return -1;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}