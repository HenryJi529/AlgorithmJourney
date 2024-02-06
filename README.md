# Algorithm Journey


## LeetCode刷题列表(按题型分类)

- 枚举
    - [1534. 统计好三元组](https://leetcode.cn/problems/count-good-triplets/):
        - 代码: [LeetCode1534.java](./LeetCode/LeetCode1534.java)
    - [1995. 统计特殊四元组](https://leetcode.cn/problems/count-special-quadruplets/):
        - 代码: [LeetCode1995.java](./LeetCode/LeetCode1995.java)

- 贪心:
    - [11. 盛最多水的容器](https://leetcode.cn/problems/container-with-most-water/):
        - 思路: 双指针 + 贪心
        - 代码: [LeetCode11.java](./LeetCode/LeetCode11.java)
    - [605. 种花问题](https://leetcode.cn/problems/can-place-flowers/):
        - 思路: 找到连续的0，累计可种数
        - 代码: [LeetCode605.java](./LeetCode/LeetCode605.java)
    - [1642. 可以到达的最远建筑](https://leetcode.cn/problems/furthest-building-you-can-reach/):
        - 思路: 全梯子逐渐换砖头/全砖头逐渐换梯子
        - 代码: [LeetCode1642.java](./LeetCode/LeetCode1642.java)

- 双指针:
    - [9. 回文数](https://leetcode.cn/problems/palindrome-number/)
        - 思路: 双指针 或 递归
        - 代码: [LeetCode9.java](./LeetCode/LeetCode9.java)
    - [26. 删除有序数组中的重复项](https://leetcode.cn/problems/remove-duplicates-from-sorted-array)
        - 思路: LinkedHashSet 或 快慢指针
        - 代码: [LeetCode26.java](./LeetCode/LeetCode26.java)
    - [27. 移除元素](https://leetcode.cn/problems/remove-element/)
        - 思路: 快慢指针 或 反向指针【避免重复赋值】
        - 代码: [LeetCode27.java](./LeetCode/LeetCode27.java)
    - [42. 接雨水](https://leetcode.cn/problems/trapping-rain-water/)
        - 代码: [LeetCode42.java](./LeetCode/LeetCode42.java)
    - [80. 删除有序数组中的重复项 II](https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/)
        - 思路: 快慢指针
        - 代码: [LeetCode80.java](./LeetCode/LeetCode80.java)
    - [88. 合并两个有序数组](https://leetcode.cn/problems/merge-sorted-array/)
        - 代码: [LeetCode88.java](./LeetCode/LeetCode88.java)
    - [141. 环形链表](https://leetcode.cn/problems/linked-list-cycle/)
        - 思路: 快慢指针或哈希表
        - 代码: [LeetCode141.java](./LeetCode/LeetCode141.java)
    - [283. 移动零](https://leetcode.cn/problems/move-zeroes/)
        - 代码: [LeetCode283.java](./LeetCode/LeetCode283.java)
    - [344. 反转字符串](https://leetcode.cn/problems/reverse-string/)
        - 代码: [LeetCode344.java](./LeetCode/LeetCode344.java)

- 二分查找:
    - [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/):
        - 思路: 两次二分查找
        - 代码: [LeetCode34.java](./LeetCode/LeetCode34.java)
    - [35. 搜索插入位置](https://leetcode.cn/problems/search-insert-position/):
        - 代码: [LeetCode35.java](./LeetCode/LeetCode35.java)
    - [50. Pow(x, n)](https://leetcode.cn/problems/powx-n/):
        - 思路: 分而治之(注意边界问题)
        - 代码: [LeetCode50.java](./LeetCode/LeetCode50.java)
    - [69. x 的平方根](https://leetcode.cn/problems/sqrtx/):
        - 思路: 二分查找、数学公式替换、牛顿法
        - 代码: [LeetCode69.java](./LeetCode/LeetCode69.java)
    - [704. 二分查找](https://leetcode.cn/problems/binary-search/):
        - 代码: [LeetCode704.java](./LeetCode/LeetCode704.java)
    - [852. 山脉数组的峰顶索引](https://leetcode.cn/problems/peak-index-in-a-mountain-array/):
        - 代码: [LeetCode852.java](./LeetCode/LeetCode852.java)
    - [875. 爱吃香蕉的珂珂](https://leetcode.cn/problems/koko-eating-bananas/):
        - 代码: [LeetCode875.java](./LeetCode/LeetCode875.java)
    - [1011.在D天内送达包裹的能力](https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/):
        - 思路: 先构造一个判别能否运送完成的函数，再确定二分的上下界，最后进行二分查找
        - 代码: [LeetCode1011.java](./LeetCode/LeetCode1011.java)

- 排序:
    - [31. 下一个排列](https://leetcode.cn/problems/next-permutation/)
        - 代码: [LeetCode31.java](./LeetCode/LeetCode31.java)
    - [75. 颜色分类](https://leetcode.cn/problems/sort-colors/)
        - 代码: [LeetCode75.java](./LeetCode/LeetCode75.java)
    - [274. H 指数](https://leetcode.cn/problems/h-index/)
        - 思路: 选择排序并在适当时终止 或 对h值二分查找
        - 代码: [LeetCode274.java](./LeetCode/LeetCode274.java)

- 数组:
    - [118. 杨辉三角](https://leetcode.cn/problems/pascals-triangle/)
        - 代码: [LeetCode118.java](./LeetCode/LeetCode118.java)

- 链表:
    - [2. 两数相加](https://leetcode.cn/problems/add-two-numbers/)
        - 代码: [LeetCode2.java](./LeetCode/LeetCode2.java)
    - [15. 三数之和](https://leetcode.cn/problems/3sum/)
        - 代码: [LeetCode15.java](./LeetCode/LeetCode15.java)
    - [19. 删除链表的倒数第 N 个结点](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/)
        - 思路: 快慢指针(要注意边界情况)
        - 代码: [LeetCode19.java](./LeetCode/LeetCode19.java)
    - [21. 合并两个有序链表](https://leetcode.cn/problems/merge-two-sorted-lists/)
        - 思路: 多指针迭代或递归
        - 代码: [LeetCode21.java](./LeetCode/LeetCode21.java)
    - [83. 删除排序链表中的重复元素](https://leetcode.cn/problems/remove-duplicates-from-sorted-list/)
        - 代码: [LeetCode83.java](./LeetCode/LeetCode83.java)
    - [92. 反转链表 II](https://leetcode.cn/problems/reverse-linked-list-ii/)
        - 思路: 引入DummyNode解决特殊情况
        - 代码: [LeetCode92.java](./LeetCode/LeetCode92.java)
    - [206. 反转链表](https://leetcode.cn/problems/reverse-linked-list/)
        - 思路: 递归思路下，注意需要保证返回值为末端元素
        - 代码: [LeetCode206.java](./LeetCode/LeetCode206.java)
    - [234. 回文链表](https://leetcode.cn/problems/palindrome-linked-list/)
        - 代码: [LeetCode234.java](./LeetCode/LeetCode234.java)
    - [237. 删除链表中的节点](https://leetcode.cn/problems/delete-node-in-a-linked-list/)
        - 代码: [LeetCode237.java](./LeetCode/LeetCode237.java)
    - [876. 链表的中间结点](https://leetcode.cn/problems/middle-of-the-linked-list/)
        - 思路: 快慢指针
        - 代码: [LeetCode876.java](./LeetCode/LeetCode876.java)

- 栈:
    - [20. 有效的括号](https://leetcode.cn/problems/valid-parentheses/)
        - 代码: [LeetCode20.java](./LeetCode/LeetCode20.java)
    - [71. 简化路径](https://leetcode.cn/problems/simplify-path/)
        - 代码: [LeetCode71.java](./LeetCode/LeetCode71.java)
    - [84. 柱状图中最大的矩形](https://leetcode.cn/problems/largest-rectangle-in-histogram/)
        - 代码: [LeetCode84.java](./LeetCode/LeetCode84.java)
    - [155. 最小栈](https://leetcode.cn/problems/min-stack/)
        - 代码: [LeetCode155.java](./LeetCode/LeetCode155.java)
    - [169. 多数元素](https://leetcode.cn/problems/majority-element/)
        - 代码: [LeetCode169.java](./LeetCode/LeetCode169.java)
    - [225. 用队列实现栈](https://leetcode.cn/problems/implement-stack-using-queues/)
        - 代码: [LeetCode225.java](./LeetCode/LeetCode225.java)
    - [232. 用栈实现队列](https://leetcode.cn/problems/implement-queue-using-stacks/)
        - 代码: [LeetCode232.java](./LeetCode/LeetCode232.java)
    - [394. 字符串解码](https://leetcode.cn/problems/decode-string/)
        - 代码: [LeetCode394.java](./LeetCode/LeetCode394.java)
    - [735. 小行星碰撞](https://leetcode.cn/problems/asteroid-collision/)
        - 代码: [LeetCode735.java](./LeetCode/LeetCode735.java)
    - [739. 每日温度](https://leetcode.cn/problems/daily-temperatures/)
        - 思路: 存储中间结果以降低时间复杂度
        - 代码: [LeetCode739.java](./LeetCode/LeetCode739.java)
    - [1047. 删除字符串中的所有相邻重复项](https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/)
        - 代码: [LeetCode1047.java](./LeetCode/LeetCode1047.java)

- 字符串:
    - [67. 二进制求和](https://leetcode.cn/problems/add-binary/)
        - 代码: [LeetCode67.java](./LeetCode/LeetCode67.java)
    - [93. 复原 IP 地址](https://leetcode.cn/problems/restore-ip-addresses/)
        - 代码: [LeetCode93.java](./LeetCode/LeetCode93.java)
    - [165. 比较版本号](https://leetcode.cn/problems/compare-version-numbers/)
        - 代码: [LeetCode165.java](./LeetCode/LeetCode165.java)
    - [168. Excel表列名称](https://leetcode.cn/problems/excel-sheet-column-title/)
        - 代码: [LeetCode168.java](./LeetCode/LeetCode168.java)

- 哈希:
    - [1. 两数之和](https://leetcode.cn/problems/two-sum/)
        - 代码: [LeetCode1.java](./LeetCode/LeetCode1.java)
    - [3. 无重复字符的最长子串](https://leetcode.cn/problems/longest-substring-without-repeating-characters/)
        - 思路: 滑动窗口
        - 代码: [LeetCode3.java](./LeetCode/LeetCode3.java)
    - [128. 最长连续序列](https://leetcode.cn/problems/longest-consecutive-sequence/)
        - 代码: [LeetCode128.java](./LeetCode/LeetCode128.java)
    - [136. 只出现一次的数字](https://leetcode.cn/problems/single-number/description/)
        - 思路: HashSet不断增删，维持常数复杂度 或 位异或
        - 代码: [LeetCode136.java](./LeetCode/LeetCode136.java)
    - [217. 存在重复元素](https://leetcode.cn/problems/contains-duplicate/)
        - 思路: 遍历元素存入HashSet 或 先排序后遍历
        - 代码: [LeetCode217.java](./LeetCode/LeetCode217.java)
    - [219. 存在重复元素 II](https://leetcode.cn/problems/contains-duplicate-ii/)
        - 思路: 滑动窗口
        - 代码: [LeetCode219.java](./LeetCode/LeetCode219.java)
    - [560. 和为 K 的子数组](https://leetcode.cn/problems/subarray-sum-equals-k/)
        - 思路: 子数组的sum = sum(0-y) - sum(0-x)
        - 代码: [LeetCode560.java](./LeetCode/LeetCode560.java)
    - [706. 设计哈希映射](https://leetcode.cn/problems/design-hashmap/):
        - 代码: [LeetCode706.java](./LeetCode/LeetCode706.java)

- 堆:
    - [23. 合并 K 个升序链表](https://leetcode.cn/problems/merge-k-sorted-lists/)
        - 代码: [LeetCode23.java](./LeetCode/LeetCode23.java)
    - [150. 逆波兰表达式求值](https://leetcode.cn/problems/evaluate-reverse-polish-notation/)
        - 代码: [LeetCode150.java](./LeetCode/LeetCode150.java)
    - [215. 数组中的第K个最大元素](https://leetcode.cn/problems/kth-largest-element-in-an-array/)
        - 思路: 直接原地排序 | 原地maxHeap | 长度为k的maxHeap
        - 代码: [LeetCode215.java](./LeetCode/LeetCode215.java)
    - [347. 前 K 个高频元素](https://leetcode.cn/problems/top-k-frequent-elements/)
        - 代码: [LeetCode347.java](./LeetCode/LeetCode347.java)
    - [373. 查找和最小的 K 对数字](https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/)
        - 代码: [LeetCode373.java](./LeetCode/LeetCode373.java)
    - [378. 有序矩阵中第 K 小的元素](https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/)
        - 思路: 堆(只利用每行递增与"第K个") | BestFirstSearch+堆(需要注意查重以及堆的长度)
        - 代码: [LeetCode378.java](./LeetCode/LeetCode378.java)
    - [703. 数据流中的第 K 大元素](https://leetcode.cn/problems/kth-largest-element-in-a-stream/)
        - 代码: [LeetCode703.java](./LeetCode/LeetCode703.java)

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
    - [450. 删除二叉搜索树中的节点](https://leetcode.cn/problems/delete-node-in-a-bst/)
        - 思路: 考虑被删除节点的位置和被删除节点是否有左右子树
        - 代码: [LeetCode450.java](./LeetCode/LeetCode450.java)
    - [1123. 最深叶节点的最近公共祖先](https://leetcode.cn/problems/lowest-common-ancestor-of-deepest-leaves/)
        - 思路: 深度优先遍历(处理好子树高度、节点深度的关系)
        - 代码: [LeetCode1123.java](./LeetCode/LeetCode1123.java)

- 图:
    - [126. 单词接龙 II](https://leetcode.cn/problems/word-ladder-ii/)
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
    - [207. 课程表](https://leetcode.cn/problems/course-schedule/)
        - 思路: 问题转化为有向环检测
        - 代码: [LeetCode207.java](./LeetCode/LeetCode207.java)
    - [210. 课程表 II](https://leetcode.cn/problems/course-schedule-ii/)
        - 思路: 问题转化为拓扑排序(要注意有向环检测)
        - 代码: [LeetCode210.java](./LeetCode/LeetCode210.java)
    - [332. 重新安排行程](https://leetcode.cn/problems/reconstruct-itinerary/)
        - 思路: 针对边的post-order traversal(边的深度优先搜索)
        - 代码: [LeetCode332.java](./LeetCode/LeetCode332.java)
    - [399. 除法求值](https://leetcode.cn/problems/evaluate-division/)
        - 思路: 按照除法顺序构建连边，后DFS+回溯寻找路径
        - 代码: [LeetCode399.java](./LeetCode/LeetCode399.java)
    - [542. 01 矩阵](https://leetcode.cn/problems/01-matrix/)
        - 思路: 
            - 直接思维: 对于每一个1，利用BFS找他最近的0[O(mn*mn)]
            - 逆向思维: 对于所有的0，利用BFS填充到每一个1的距离[O(mn)]
        - 代码: [LeetCode542.java](./LeetCode/LeetCode542.java)
    - [743. 网络延迟时间](https://leetcode.cn/problems/network-delay-time/)
        - 代码: [LeetCode743.java](./LeetCode/LeetCode743.java)
    - [787. K 站中转内最便宜的航班](https://leetcode.cn/problems/cheapest-flights-within-k-stops/)
        - 思路: 要确定节点是否真的算完全访问过，必要时留下记录
        - 代码: [LeetCode787.java](./LeetCode/LeetCode787.java)
    - [841. 钥匙和房间](https://leetcode.cn/problems/keys-and-rooms/)
        - 代码: [LeetCode841.java](./LeetCode/LeetCode841.java)
    - [994. 腐烂的橘子](https://leetcode.cn/problems/rotting-oranges/)
        - 代码: [LeetCode994.java](./LeetCode/LeetCode994.java)

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
    - [5. 最长回文子串](https://leetcode.cn/problems/longest-palindromic-substring/)
        - 思路: 遍历节点(中心展开) 或 2维的DP
        - 代码: [LeetCode5.java](./LeetCode/LeetCode5.java)
    - [32. 最长有效括号](https://leetcode.cn/problems/longest-valid-parentheses/)
        - 思路: 考虑`(`与`)`对应关系【输入尺度太大，不能用2维DP】
        - 代码: [LeetCode32.java](./LeetCode/LeetCode32.java)
    - [55. 跳跃游戏](https://leetcode.cn/problems/jump-game/)
        - 思路: 其实不用动态规划，直接使用贪心算法更新最远位置就行
        - 代码: [LeetCode55.java](./LeetCode/LeetCode55.java)
    - [62. 不同路径](https://leetcode.cn/problems/unique-paths/)
        - 代码: [LeetCode62.java](./LeetCode/LeetCode62.java)
    - [63. 不同路径 II](https://leetcode.cn/problems/unique-paths-ii/)
        - 代码: [LeetCode63.java](./LeetCode/LeetCode63.java)
    - [70. 爬楼梯](https://leetcode.cn/problems/climbing-stairs/)
        - 代码: [LeetCode70.java](./LeetCode/LeetCode70.java)
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
    - [410. 分割数组的最大值](https://leetcode.cn/problems/split-array-largest-sum/)
        - 代码: [LeetCode410.java](./LeetCode/LeetCode410.java)
    - [486. 预测赢家](https://leetcode.cn/problems/predict-the-winner/)
        - 思路: Min-Max + DP
        - 代码: [LeetCode486.java](./LeetCode/LeetCode486.java)
    - [877. 石子游戏](https://leetcode.cn/problems/stone-game/)
        - 思路: Min-Max + DP 或 脑筋急转弯 
        - 代码: [LeetCode877.java](./LeetCode/LeetCode877.java)
    - [1143. 最长公共子序列](https://leetcode.cn/problems/longest-common-subsequence/)
        - 代码: [LeetCode1143.java](./LeetCode/LeetCode1143.java)

- 回溯:
    - [46. 全排列](https://leetcode.cn/problems/permutations/)
        - 代码: [LeetCode46.java](./LeetCode/LeetCode46.java)

- 数据库:
    - [175. 组合两个表](https://leetcode.cn/problems/combine-two-tables/)
        - 代码: [LeetCode175.sql](./LeetCode/sql/LeetCode175.sql)
    - [176. 第二高的薪水](https://leetcode.cn/problems/second-highest-salary/)
        - 代码: [LeetCode176.sql](./LeetCode/sql/LeetCode176.sql)
    - [177. 第N高的薪水](https://leetcode.cn/problems/nth-highest-salary/)
        - 代码: [LeetCode177.sql](./LeetCode/sql/LeetCode177.sql)
    - [181. 超过经理收入的员工](https://leetcode.cn/problems/employees-earning-more-than-their-managers/)
        - 代码: [LeetCode181.sql](./LeetCode/sql/LeetCode181.sql)
    - [182. 查找重复的电子邮箱](https://leetcode.cn/problems/duplicate-emails/)
        - 代码: [LeetCode182.sql](./LeetCode/sql/LeetCode182.sql)
    - [183. 从不订购的客户](https://leetcode.cn/problems/customers-who-never-order/)
        - 代码: [LeetCode183.sql](./LeetCode/sql/LeetCode183.sql)
    - [196. 删除重复的电子邮箱](https://leetcode.cn/problems/delete-duplicate-emails/)
        - 代码: [LeetCode196.sql](./LeetCode/sql/LeetCode196.sql)
    - [197. 上升的温度](https://leetcode.cn/problems/rising-temperature/)
        - 代码: [LeetCode197.sql](./LeetCode/sql/LeetCode197.sql)
    - [511. 游戏玩法分析 I](https://leetcode.cn/problems/game-play-analysis-i/)
        - 代码: [LeetCode511.sql](./LeetCode/sql/LeetCode511.sql)
    - [577. 员工奖金](https://leetcode.cn/problems/employee-bonus/)
        - 代码: [LeetCode577.sql](./LeetCode/sql/LeetCode577.sql)
    - [584. 寻找用户推荐人](https://leetcode.cn/problems/find-customer-referee/)
        - 代码: [LeetCode584.sql](./LeetCode/sql/LeetCode584.sql)
    - [586. 订单最多的客户](https://leetcode.cn/problems/customer-placing-the-largest-number-of-orders/)
        - 代码: [LeetCode586.sql](./LeetCode/sql/LeetCode586.sql)
    - [595. 大的国家](https://leetcode.cn/problems/big-countries/)
        - 代码: [LeetCode595.sql](./LeetCode/sql/LeetCode595.sql)
    - [596. 超过5名学生的课](https://leetcode.cn/problems/classes-more-than-5-students/)
        - 代码: [LeetCode596.sql](./LeetCode/sql/LeetCode596.sql)
    - [607. 销售员](https://leetcode.cn/problems/sales-person/)
        - 代码: [LeetCode607.sql](./LeetCode/sql/LeetCode607.sql)
    - [610. 判断三角形](https://leetcode.cn/problems/triangle-judgement/)
        - 代码: [LeetCode610.sql](./LeetCode/sql/LeetCode610.sql)
    - [619. 只出现一次的最大数字](https://leetcode.cn/problems/biggest-single-number/)
        - 代码: [LeetCode619.sql](./LeetCode/sql/LeetCode619.sql)
    - [620. 有趣的电影](https://leetcode.cn/problems/not-boring-movies/)
        - 代码: [LeetCode620.sql](./LeetCode/sql/LeetCode620.sql)
    - [627. 变更性别](https://leetcode.cn/problems/swap-salary/)
        - 代码: [LeetCode627.sql](./LeetCode/sql/LeetCode627.sql)
    - [1050. 合作过至少三次的演员和导演](https://leetcode.cn/problems/actors-and-directors-who-cooperated-at-least-three-times/)
        - 代码: [LeetCode1050.sql](./LeetCode/sql/LeetCode1050.sql)
    - [1068. 产品销售分析 I](https://leetcode.cn/problems/product-sales-analysis-i/description/)
        - 代码: [LeetCode1068.sql](./LeetCode/sql/LeetCode1068.sql)
    - [1075. 项目员工 I](https://leetcode.cn/problems/project-employees-i/)
        - 代码: [LeetCode1075.sql](./LeetCode/sql/LeetCode1075.sql)
    - [1084. 销售分析III](https://leetcode.cn/problems/sales-analysis-iii/)
        - 思路: 尽可能减少遍历次数
        - 代码: [LeetCode1084.sql](./LeetCode/sql/LeetCode1084.sql)
    - [1141. 查询近30天活跃用户数](https://leetcode.cn/problems/user-activity-for-the-past-30-days-i/)
        - 代码: [LeetCode1141.sql](./LeetCode/sql/LeetCode1141.sql)
    - [1148. 文章浏览 I](https://leetcode.cn/problems/article-views-i/)
        - 代码: [LeetCode1148.sql](./LeetCode/sql/LeetCode1148.sql)
    - [1179. 重新格式化部门表](https://leetcode.cn/problems/reformat-department-table/)
        - 代码: [LeetCode1179.sql](./LeetCode/sql/LeetCode1179.sql)
    - [1211. 查询结果的质量和占比](https://leetcode.cn/problems/queries-quality-and-percentage/)
        - 代码: [LeetCode1211.sql](./LeetCode/sql/LeetCode1211.sql)

- Shell:
    - [194. 转置文件](https://leetcode.cn/problems/transpose-file/)
        - 代码: [LeetCode194.sh](./LeetCode/shell/LeetCode194.sh)
    - [195. 第十行](https://leetcode.cn/problems/tenth-line/)
        - 代码: [LeetCode195.sh](./LeetCode/shell/LeetCode195.sh)


## LanQiao刷题列表(按题型分类)

- 字符串:
    - [504. 单词分析](https://www.lanqiao.cn/problems/504/learning/)
        - 代码: [LanQiao504](./LanQiao/LanQiao504.java)

- DFS:
    - [89. 路径之谜](https://www.lanqiao.cn/problems/89/learning/)
        - 代码: [LanQiao89](./LanQiao/LanQiao89.java)

