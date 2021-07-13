//给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 
//JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。 
//
// 
//
// 提示： 
//
// 
// 如果存在多种有效的行程，请你按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序
//更靠前 
// 所有的机场都用三个大写字母表示（机场代码）。 
// 假定所有机票至少存在一种合理的行程。 
// 所有的机票必须都用一次 且 只能用一次。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//输出：["JFK", "MUC", "LHR", "SFO", "SJC"]
// 
//
// 示例 2： 
//
// 
//输入：[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
//解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。 
// Related Topics 深度优先搜索 图 欧拉回路 
// 👍 422 👎 0

package leetcode.editor.cn;

import java.util.*;

public class P332_ReconstructItinerary {
    public static void main(String[] args) {
        Solution solution = new P332_ReconstructItinerary().new Solution();
        List<List<String>> lists = new ArrayList<List<String>>();
        String [][] x = new String[][]
                {{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};
        for(int i = 0;i<x.length;i++){
            List<String> listTemp = new ArrayList<String>();
            listTemp.add(x[i][0]);
            listTemp.add(x[i][1]);
            lists.add(listTemp);
        }
        solution.findItinerary(lists);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public Set<String> lines = new HashSet<String>();    //邻接矩阵
        public List<String> citys;    //邻接矩阵
        public List<String> result = new ArrayList<String>();
        public List<List<String>> resultList = new ArrayList<List<String>>();
        public List<String> findItinerary(List<List<String>> tickets) {
            init(tickets);
            result.add("JFK");
            dfs("JFK");
            if(resultList.isEmpty()) return new ArrayList<String>();
            return resultList.get(0);
        }

        public void dfs(String startCity){
           // System.out.println(startCity);

            if(lines.isEmpty()){
               // System.out.println(result);
                resultList.add(new ArrayList<String>(result));
                return;
            }else {//{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}}
                for(String city : citys){
                    String key = startCity+"_"+city;
                    if(lines.contains(key)){
                        result.add(city);
                        lines.remove(key);
                        dfs(city);
                        lines.add(key);
                        result.remove(result.size()-1);
                    }
                }
            }
        }

        public void init(List<List<String>> tickets){
            Set<String> set = new HashSet<String>();
            for(List<String> list : tickets){
                String a = list.get(0);
                String b = list.get(1);
                lines.add(a+"_"+b);
                set.add(a);
                set.add(b);
            }
            citys = new ArrayList<String>(set);
            Collections.sort(citys);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}