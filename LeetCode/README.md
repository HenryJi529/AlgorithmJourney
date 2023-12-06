# LeetCode刷题列表(按题型分类)


- 双指针:
    - [141. 环形链表](https://leetcode.cn/problems/linked-list-cycle/description/)
        - 思路: 快慢指针或哈希表
        - 代码: [LeetCode141.java](./LeetCode141.java)

- 贪心算法:
    - [11. 盛最多水的容器](https://leetcode.cn/problems/container-with-most-water/description/):
        - 代码: [LeetCode11.java](./LeetCode11.java)

- 二分查找:
    - [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/):
        - 思路: 两次二分查找
        - 代码: [LeetCode34.java](./LeetCode34.java)
    - [1011.在D天内送达包裹的能力](https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/):
        - 思路: 先构造一个判别能否运送完成的函数，再确定二分的上下界，最后进行二分查找
        - 代码: [LeetCode1011.java](./LeetCode1011.java)

- 链表递归:
    - [206. 反转链表](https://leetcode.cn/problems/reverse-linked-list/)
        - 思路: 注意需要保证返回值为末端元素
        - 代码: [LeetCode206.java](./LeetCode206.java)

- 栈:
    - [20. 有效的括号](https://leetcode.cn/problems/valid-parentheses/)
        - 代码: [LeetCode20.java](./LeetCode20.java)
    - [84. 柱状图中最大的矩形](https://leetcode.cn/problems/largest-rectangle-in-histogram/)
        - 代码: [LeetCode84.java](./LeetCode84.java)
    - [735. 小行星碰撞](https://leetcode.cn/problems/asteroid-collision/)
        - 代码: [LeetCode735.java](./LeetCode735.java)

- 二叉树:
    - [144. 二叉树的前序遍历](https://leetcode.cn/problems/binary-tree-preorder-traversal/)
        - 代码: [LeetCode144.java](./LeetCode144.java)

- 并查集:
    - [547. 省份数量](https://leetcode.cn/problems/number-of-provinces/)
        - 代码: [LeetCode547.java](./LeetCode547.java)
    - [1584. 连接所有点的最小费用](https://leetcode.cn/problems/min-cost-to-connect-all-points/)
        - 思路: 用并查集解决最小生成树问题
        - 代码: [LeetCode1584.java](./LeetCode1584.java)
    - [1971. 寻找图中是否存在路径](https://leetcode.cn/problems/find-if-path-exists-in-graph/)
        - 代码: [LeetCode1971.java](./LeetCode1971.java)

- 动态规划:
    - [55. 跳跃游戏](https://leetcode.cn/problems/jump-game/description/)
        - 思路: 其实不用动态规划，直接使用贪心算法更新最远位置就行
        - 代码: [LeetCode55.java](./LeetCode55.java)