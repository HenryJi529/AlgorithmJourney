from utils import colored_print


class SequentialList:
    def __init__(self, capacity: int):
        self.eles = [None] * capacity
        self._length = 0

    def __iter__(self):
        def generator():
            for ele in self.eles[0 : self._length]:
                yield ele

        return generator()

    def resize(self, newSize: int):
        temp = self.eles
        self.eles = [None] * newSize
        for ind in range(self._length):
            self.eles[ind] = temp[ind]

    def clear(self):
        self._length = 0

    def isEmpty(self):
        return self._length == 0

    @property
    def length(self):
        return self._length

    def get(self, ind: int):
        return self.eles[ind]

    def append(self, ele):
        if self._length == len(self.eles):
            self.resize(len(self.eles) * 2)
        self.eles[self._length] = ele
        self._length += 1

    def insert(self, ind: int, ele):
        if self._length == len(self.eles):
            self.resize(len(self.eles) * 2)
        for i in range(ind + 1, self._length + 1):
            self.eles[i] = self.eles[i - 1]
        self.eles[ind] = ele
        self._length += 1

    def remove(self, ind):
        removed_ele = self.eles[ind]
        for i in range(ind, self._length - 1):
            self.eles[i] = self.eles[i + 1]
        self._length -= 1
        if self._length < len(self.eles) / 4:
            self.resize(int(len(self.eles) / 2))
        return removed_ele

    def indexOf(self, ele):
        for i in range(self._length):
            if self.eles[i] == ele:
                return i
        return -1

    @staticmethod
    def test():
        l1 = SequentialList(7)
        l1.append("H")
        l1.append("L")
        l1.insert(1, "E")
        l1.append("L")
        removed_ele = l1.remove(2)
        print(f"removed_ele: {removed_ele}")
        l1.append("L")
        l1.append("O")
        print(f"indexOf: {l1.indexOf('O')}")
        l1.append(" ")
        l1.append(" ")
        l1.append(" ")
        for ele in l1:
            print(ele, end="")
        print()


class LinkedList:
    class Node:
        def __init__(self, item=None, next: "LinkedList.Node" = None):
            self.item = item
            self.next = next

    def __init__(self):
        self.head = LinkedList.Node()
        self.N = 0

    def __iter__(self):
        def generator():
            node = self.head
            while node.next != None:
                node = node.next
                yield node.item

        return generator()

    def clear(self):
        self.head.next = None
        self.N = 0

    def isEmpty(self):
        return self.N == 0

    def __len__(self):
        return self.N

    def get(self, i: int):
        if i >= self.N:
            return None
        node = self.head
        for _ in range(i + 1):
            node = node.next
        return node.item

    def insert(self, item, i: int = None):
        if i:
            # 找到i位置前一个节点和i位置的节点
            node = self.head
            for j in range(i):
                node = node.next
            preNode = node
            nextNode = node.next
            # 创建新节点
            newNode = self.Node(item, next=nextNode)
            # 链接新节点
            preNode.next = newNode
            # 更新长度
            self.N += 1
        else:
            # 找到当前最后一个节点
            node = self.head
            while node.next != None:
                node = node.next
            # 创建新节点
            newNode = self.Node(item, next=None)
            # 让当前最后一个节点指向新节点
            node.next = newNode
            self.N += 1

    def remove(self, i: int):
        # 获取i前后的节点
        node = self.head
        for _ in range(i):
            node = node.next
        preNode = node
        currentNode = preNode.next
        nextNode = currentNode.next

        # 链接pre与after
        preNode.next = nextNode

        # 更新长度
        self.N -= 1
        return currentNode.item

    def indexOf(self, item):
        node = self.head
        for i in range(self.N):
            node = node.next
            if node.item == item:
                return i
        return -1

    def __str__(self):
        string = ""
        node = self.head
        string += "[ "
        for i in range(self.N):
            node = node.next
            string += node.item
            if i < self.N - 1:
                string += "->"
        string += " ]"

        return string

    @staticmethod
    def test():
        l1 = LinkedList()
        l1.insert("h")
        l1.insert("l")
        l1.insert("l")
        l1.insert("l")
        l1.insert("o")
        l1.insert("e", 1)
        l1.remove(l1.indexOf("l"))
        print(f"长度是: {len(l1)}")
        print(l1)
        for item in l1:
            print(item, end="")
        print()


if __name__ == "__main__":
    colored_print("Test SequentialList...")
    SequentialList.test()
    colored_print("=" * 90)
    colored_print("Test LinkedList...")
    LinkedList.test()
    colored_print("=" * 90)
