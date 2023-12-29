# Algorithm Journey


## LeetCode刷题列表(按题型分类)


- 双指针:
    - [141. 环形链表](https://leetcode.cn/problems/linked-list-cycle/description/)
        - 思路: 快慢指针或哈希表
        - 代码: [LeetCode141.java](./LeetCode/LeetCode141.java)
    - [344. 反转字符串](https://leetcode.cn/problems/reverse-string/)
        - 代码: [LeetCode344.java](./LeetCode/LeetCode344.java)

- 贪心算法:
    - [11. 盛最多水的容器](https://leetcode.cn/problems/container-with-most-water/description/):
        - 代码: [LeetCode11.java](./LeetCode/LeetCode11.java)

- 二分查找:
    - [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/):
        - 思路: 两次二分查找
        - 代码: [LeetCode34.java](./LeetCode/LeetCode34.java)
    - [1011.在D天内送达包裹的能力](https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/):
        - 思路: 先构造一个判别能否运送完成的函数，再确定二分的上下界，最后进行二分查找
        - 代码: [LeetCode1011.java](./LeetCode/LeetCode1011.java)

- 数组:
    - [118. 杨辉三角](https://leetcode.cn/problems/pascals-triangle/)
        - 代码: [LeetCode118.java](./LeetCode/LeetCode118.java)

- 链表:
    - [92. 反转链表 II](https://leetcode.cn/problems/reverse-linked-list-ii/)
        - 思路: 引入DummyNode解决特殊情况
        - 代码: [LeetCode92.java](./LeetCode/LeetCode92.java)
    - [206. 反转链表](https://leetcode.cn/problems/reverse-linked-list/)
        - 思路: 递归思路下，注意需要保证返回值为末端元素
        - 代码: [LeetCode206.java](./LeetCode/LeetCode206.java)

- 栈:
    - [20. 有效的括号](https://leetcode.cn/problems/valid-parentheses/)
        - 代码: [LeetCode20.java](./LeetCode/LeetCode20.java)
    - [71. 简化路径](https://leetcode.cn/problems/simplify-path/)
        - 代码: [LeetCode71.java](./LeetCode/LeetCode71.java)
    - [84. 柱状图中最大的矩形](https://leetcode.cn/problems/largest-rectangle-in-histogram/)
        - 代码: [LeetCode84.java](./LeetCode/LeetCode84.java)
    - [225. 用队列实现栈](https://leetcode.cn/problems/implement-stack-using-queues/)
        - 代码: [LeetCode225.java](./LeetCode/LeetCode225.java)
    - [232. 用栈实现队列](https://leetcode.cn/problems/implement-queue-using-stacks/)
        - 代码: [LeetCode232.java](./LeetCode/LeetCode232.java)
    - [394. 字符串解码](https://leetcode.cn/problems/decode-string/)
        - 代码: [LeetCode394.java](./LeetCode/LeetCode394.java)
    - [735. 小行星碰撞](https://leetcode.cn/problems/asteroid-collision/)
        - 代码: [LeetCode735.java](./LeetCode/LeetCode735.java)

- 字符串:
    - [93. 复原 IP 地址](https://leetcode.cn/problems/restore-ip-addresses/)
        - 代码: [LeetCode93.java](./LeetCode/LeetCode93.java)
    - [165. 比较版本号](https://leetcode.cn/problems/compare-version-numbers/)
        - 代码: [LeetCode165.java](./LeetCode/LeetCode165.java)

- 堆:
    - [23. 合并 K 个升序链表](https://leetcode.cn/problems/merge-k-sorted-lists/)
        - 代码: [LeetCode23.java](./LeetCode/LeetCode23.java)
    - [215. 数组中的第K个最大元素](https://leetcode.cn/problems/kth-largest-element-in-an-array/)
        - 思路: 直接原地排序 | 原地maxHeap | 长度为k的maxHeap
        - 代码: [LeetCode215.java](./LeetCode/LeetCode215.java)
    - [347. 前 K 个高频元素](https://leetcode.cn/problems/top-k-frequent-elements/)
        - 代码: [LeetCode347.java](./LeetCode/LeetCode347.java)
    - [373. 查找和最小的 K 对数字](https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/)
        - 代码: [LeetCode373.java](./LeetCode/LeetCode373.java)

- 哈希表:
    - [1. 两数之和](https://leetcode.cn/problems/two-sum/)
        - 代码: [LeetCode1.java](./LeetCode/LeetCode1.java)
    - [3. 无重复字符的最长子串](https://leetcode.cn/problems/longest-substring-without-repeating-characters/)
        - 思路: 滑动窗口
        - 代码: [LeetCode3.java](./LeetCode/LeetCode3.java)
    - [560. 和为 K 的子数组](https://leetcode.cn/problems/subarray-sum-equals-k/)
        - 思路: 子数组的sum = sum(0-y) - sum(0-x)
        - 代码: [LeetCode560.java](./LeetCode/LeetCode560.java)

- 树:
    - [94. 二叉树的中序遍历](https://leetcode.cn/problems/binary-tree-inorder-traversal/)
        - 代码: [LeetCode94.java](./LeetCode/LeetCode94.java)
    - [100. 相同的树](https://leetcode.cn/problems/same-tree/)
        - 思路: DFS角度实现起来更方便
        - 代码: [LeetCode100.java](./LeetCode/LeetCode100.java)
    - [102. 二叉树的层序遍历](https://leetcode.cn/problems/binary-tree-level-order-traversal/)
        - 思路: 用BFS实现
        - 代码: [LeetCode102.java](./LeetCode/LeetCode102.java)
    - [104. 二叉树的最大深度](https://leetcode.cn/problems/maximum-depth-of-binary-tree/)
        - 代码: [LeetCode104.java](./LeetCode/LeetCode104.java)
    - [105. 从前序与中序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
        - 思路: 根据中序遍历确定左右子树，根据前序遍历确定根节点
        - 代码: [LeetCode105.java](./LeetCode/LeetCode105.java)
    - [112. 路径总和](https://leetcode.cn/problems/path-sum/)
        - 思路: DFS角度，在没有左右节点时确定是否满足条件
        - 代码: [LeetCode112.java](./LeetCode/LeetCode112.java)
    - [124. 二叉树中的最大路径和](https://leetcode.cn/problems/binary-tree-maximum-path-sum/)
        - 代码: [LeetCode124.java](./LeetCode/LeetCode124.java)
    - [129. 求根节点到叶节点数字之和](https://leetcode.cn/problems/sum-root-to-leaf-numbers/)
        - 代码: [LeetCode129.java](./LeetCode/LeetCode129.java)
    - [144. 二叉树的前序遍历](https://leetcode.cn/problems/binary-tree-preorder-traversal/)
        - 代码: [LeetCode144.java](./LeetCode/LeetCode144.java)
    - [145. 二叉树的后序遍历](https://leetcode.cn/problems/binary-tree-postorder-traversal/)
        - 代码: [LeetCode145.java](./LeetCode/LeetCode145.java)
    - [199. 二叉树的右视图](https://leetcode.cn/problems/binary-tree-right-side-view/)
        - 代码: [LeetCode199.java](./LeetCode/LeetCode199.java)

- 图:
    - [126. 单词接龙 II](https://leetcode.cn/problems/word-ladder-ii/description/)
        - 思路: 按照要求先构图，用started跟ended降低复杂度
        - 代码: [LeetCode127.java](./LeetCode/LeetCode127.java)
    - [127. 单词接龙](https://leetcode.cn/problems/word-ladder/)
        - 思路: 按照要求先构图，用visited降低复杂度
        - 代码: [LeetCode127.java](./LeetCode/LeetCode127.java)
    - [133. 克隆图](https://leetcode.cn/problems/clone-graph/)
        - 思路: 深度优先比广度优先更易理解【每次返回新节点，用一个map记录新旧节点关系】
        - 代码: [LeetCode133.java](./LeetCode/LeetCode133.java)
    - [200. 岛屿数量](https://leetcode.cn/problems/number-of-islands/)
        - 代码: [LeetCode200.java](./LeetCode/LeetCode200.java)
    - [332. 重新安排行程](https://leetcode.cn/problems/reconstruct-itinerary/)
        - 思路: 针对边的post-order traversal(边的深度优先搜索)
        - 代码: [LeetCode332.java](./LeetCode/LeetCode332.java)
    - [542. 01 矩阵](https://leetcode.cn/problems/01-matrix/description/)
        - 思路: 
            - 直接思维: 对于每一个1，利用BFS找他最近的0[O(mn*mn)]
            - 逆向思维: 对于所有的0，利用BFS填充到每一个1的距离[O(mn)]
        - 代码: [LeetCode542.java](./LeetCode/LeetCode542.java)
    - [743. 网络延迟时间](https://leetcode.cn/problems/network-delay-time/)
        - 代码: [LeetCode743.java](./LeetCode/LeetCode743.java)
    - [787. K 站中转内最便宜的航班](https://leetcode.cn/problems/cheapest-flights-within-k-stops/)
        - 思路: 要确定节点是否真的算完全访问过，必要时留下记录
        - 代码: [LeetCode787.java](./LeetCode/LeetCode787.java)

- 并查集:
    - [547. 省份数量](https://leetcode.cn/problems/number-of-provinces/)
        - 代码: [LeetCode547.java](./LeetCode/LeetCode547.java)
    - [1584. 连接所有点的最小费用](https://leetcode.cn/problems/min-cost-to-connect-all-points/)
        - 思路: 用并查集解决最小生成树问题
        - 代码: [LeetCode1584.java](./LeetCode/LeetCode1584.java)
    - [1971. 寻找图中是否存在路径](https://leetcode.cn/problems/find-if-path-exists-in-graph/)
        - 代码: [LeetCode1971.java](./LeetCode/LeetCode1971.java)

- 搜索:
    - [78. 子集](https://leetcode.cn/problems/subsets/)
        - 代码: [LeetCode78.java](./LeetCode/LeetCode78.java)

- 动态规划:
    - [55. 跳跃游戏](https://leetcode.cn/problems/jump-game/)
        - 思路: 其实不用动态规划，直接使用贪心算法更新最远位置就行
        - 代码: [LeetCode55.java](./LeetCode/LeetCode55.java)
    - [62. 不同路径](https://leetcode.cn/problems/unique-paths/)
        - 代码: [LeetCode62.java](./LeetCode/LeetCode62.java)
    - [63. 不同路径 II](https://leetcode.cn/problems/unique-paths-ii/)
        - 代码: [LeetCode63.java](./LeetCode/LeetCode63.java)
    - [91. 解码方法](https://leetcode.cn/problems/decode-ways/)
        - 思路: 问题划分时需要考虑避免重合
        - 代码: [LeetCode91.java](./LeetCode/LeetCode91.java)
    - [96. 不同的二叉搜索树](https://leetcode.cn/problems/unique-binary-search-trees/)
        - 思路: 子问题的划分是根据连续的节点数量，与节点大小无关
        - 代码: [LeetCode96.java](./LeetCode/LeetCode96.java)
    - [115. 不同的子序列](https://leetcode.cn/problems/distinct-subsequences/)
        - 思路: 二维动态规划
        - 代码: [LeetCode115.java](./LeetCode/LeetCode115.java)
    - [139. 单词拆分](https://leetcode.cn/problems/word-break/)
        - 代码: [LeetCode139.java](./LeetCode/LeetCode139.java)
    - [198. 打家劫舍](https://leetcode.cn/problems/house-robber/)
        - 思路: 先找出最小的问题，再想想怎样扩大问题规模
        - 代码: [LeetCode198.java](./LeetCode/LeetCode198.java)
    - [1143. 最长公共子序列](https://leetcode.cn/problems/longest-common-subsequence/)
        - 代码: [LeetCode1143.java](./LeetCode/LeetCode1143.java)

- 数据库:
    - [175. 组合两个表](https://leetcode.cn/problems/combine-two-tables/)
        - 代码: [LeetCode175.sql](./LeetCode/LeetCode175.sql)
    - [181. 超过经理收入的员工](https://leetcode.cn/problems/employees-earning-more-than-their-managers/)
        - 代码: [LeetCode181.sql](./LeetCode/LeetCode181.sql)
    - [182. 查找重复的电子邮箱](https://leetcode.cn/problems/duplicate-emails/)
        - 代码: [LeetCode182.sql](./LeetCode/LeetCode182.sql)
    - [183. 从不订购的客户](https://leetcode.cn/problems/customers-who-never-order/)
        - 代码: [LeetCode183.sql](./LeetCode/LeetCode183.sql)
    - [196. 删除重复的电子邮箱](https://leetcode.cn/problems/delete-duplicate-emails/)
        - 代码: [LeetCode196.sql](./LeetCode/LeetCode196.sql)
    - [197. 上升的温度](https://leetcode.cn/problems/rising-temperature/)
        - 代码: [LeetCode197.sql](./LeetCode/LeetCode197.sql)
    - [627. 变更性别](https://leetcode.cn/problems/swap-salary/)
        - 代码: [LeetCode627.sql](./LeetCode/LeetCode627.sql)

- Shell:
    - [194. 转置文件](https://leetcode.cn/problems/transpose-file/)
        - 代码: [LeetCode194.sh](./LeetCode/LeetCode194.sh)
    - [195. 第十行](https://leetcode.cn/problems/tenth-line/)
        - 代码: [LeetCode195.sh](./LeetCode/LeetCode195.sh)