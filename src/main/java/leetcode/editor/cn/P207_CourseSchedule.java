//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 105 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 866 👎 0

package leetcode.editor.cn;

public class P207_CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new P207_CourseSchedule().new Solution();
        System.out.println(solution.canFinish(2, new int[][]{{1,0}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] arc;    //邻接矩阵

        //已经被拜访的点
        public int[] visited;

        public boolean result = true;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            init(numCourses, prerequisites);
            for (int i = 0; i < numCourses; i++) {
                dfs(i,numCourses);
            }
            return result;
        }

        public void dfs(int n, int numCourses) {
            if (n >= numCourses) {
                return;
            } else {
                if (visited[n] == 2) return;
                if (visited[n] == 1) {
                    result = false;
                    return;
                }
                visited[n] = 1;
                for(int i = 0 ;i<numCourses;i++){
                    if(arc[n][i]==1){
                        dfs(i,numCourses);
                    }
                }
                visited[n] = 2;
            }
        }

        public void init(int n, int[][] trust) {
            arc = new int[n + 1][n + 1];

            visited = new int[n + 1];

            for (int i = 0; i < trust.length; i++) {
                int a = trust[i][0];
                int b = trust[i][1];
                arc[b][a] = 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}