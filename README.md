# Algorithm Journey


## LeetCode刷题列表(按题型分类)


- 双指针:
    - [141. 环形链表](https://leetcode.cn/problems/linked-list-cycle/description/)
        - 思路: 快慢指针或哈希表
        - 代码: [LeetCode141.java](./LeetCode/LeetCode141.java)

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
        - 思路: 注意需要保证返回值为末端元素
        - 代码: [LeetCode206.java](./LeetCode/LeetCode206.java)

- 栈:
    - [20. 有效的括号](https://leetcode.cn/problems/valid-parentheses/)
        - 代码: [LeetCode20.java](./LeetCode/LeetCode20.java)
    - [71. 简化路径](https://leetcode.cn/problems/simplify-path/)
        - 代码: [LeetCode71.java](./LeetCode/LeetCode71.java)
    - [84. 柱状图中最大的矩形](https://leetcode.cn/problems/largest-rectangle-in-histogram/)
        - 代码: [LeetCode84.java](./LeetCode/LeetCode84.java)
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
    - [199. 二叉树的右视图](https://leetcode.cn/problems/binary-tree-right-side-view/)
        - 代码: [LeetCode199.java](./LeetCode/LeetCode199.java)

- 图:
    - [127. 单词接龙](https://leetcode.cn/problems/word-ladder/)
        - 思路: 按照要求先构图，降低复杂度
        - 代码: [LeetCode127.java](./LeetCode/LeetCode127.java)
    - [542. 01 矩阵](https://leetcode.cn/problems/01-matrix/description/)
        - 思路: 
            - 直接思维: 对于每一个1，利用BFS找他最近的0[O(mn*mn)]
            - 逆向思维: 对于所有的0，利用BFS填充到每一个1的距离[O(mn)]
        - 代码: [LeetCode542.java](./LeetCode/LeetCode542.java)

- 并查集:
    - [547. 省份数量](https://leetcode.cn/problems/number-of-provinces/)
        - 代码: [LeetCode547.java](./LeetCode/LeetCode547.java)
    - [1584. 连接所有点的最小费用](https://leetcode.cn/problems/min-cost-to-connect-all-points/)
        - 思路: 用并查集解决最小生成树问题
        - 代码: [LeetCode1584.java](./LeetCode/LeetCode1584.java)
    - [1971. 寻找图中是否存在路径](https://leetcode.cn/problems/find-if-path-exists-in-graph/)
        - 代码: [LeetCode1971.java](./LeetCode/LeetCode1971.java)

- 动态规划:
    - [55. 跳跃游戏](https://leetcode.cn/problems/jump-game/)
        - 思路: 其实不用动态规划，直接使用贪心算法更新最远位置就行
        - 代码: [LeetCode55.java](./LeetCode/LeetCode55.java)
    - [115. 不同的子序列](https://leetcode.cn/problems/distinct-subsequences/)
        - 思路: 二维动态规划
        - 代码: [LeetCode115.java](./LeetCode/LeetCode115.java)

- 数据库:
    - [175. 组合两个表](https://leetcode.cn/problems/combine-two-tables/)
        - 代码: [LeetCode175.sql](./LeetCode/LeetCode175.sql)
    - [181. 超过经理收入的员工](https://leetcode.cn/problems/employees-earning-more-than-their-managers/)
        - 代码: [LeetCode181.sql](./LeetCode/LeetCode181.sql)