
//有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。 
//
// 给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。请你找出并返回 edges 
//所表示星型图的中心节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：edges = [[1,2],[2,3],[4,2]]
//输出：2
//解释：如上图所示，节点 2 与其他每个节点都相连，所以节点 2 是中心节点。
// 
//
// 示例 2： 
//
// 
//输入：edges = [[1,2],[5,1],[1,3],[1,4]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 3 <= n <= 105 
// edges.length == n - 1 
// edges[i].length == 2 
// 1 <= ui, vi <= n 
// ui != vi 
// 题目数据给出的 edges 表示一个有效的星型图 
// 
// Related Topics 图 
// 👍 6 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P1791_FindCenterOfStarGraph {
    public static void main(String[] args) {
        Solution solution = new P1791_FindCenterOfStarGraph().new Solution();
        int center = solution.findCenter(new int[][]{
                {1, 2},
                {2, 3},
                {4, 2}
        });
        System.out.println(center);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public Map<Integer, Integer> emap = new HashMap<>();

        public int findCenter(int[][] edges) {

            for (int i = 0; i < edges.length; i++) {
                add(edges[i][0]);
                add(edges[i][1]);
            }
            for (Integer key : emap.keySet()) {
                if (emap.get(key) == emap.size() - 1) {
                    return key;
                }
            }
            return -1;
        }

        public void add(Integer key) {
            if (emap.containsKey(key)) {
                emap.put(key, emap.get(key) + 1);
            } else {
                emap.put(key, 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}