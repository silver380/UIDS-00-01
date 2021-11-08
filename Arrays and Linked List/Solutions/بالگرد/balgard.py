#by Lida safari
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None


class LinkedList:
    def __init__(self, list):
        self.head = None
        self.tail = None
        self.size = 0
        for i in range(len(list)):
            self.push(list[len(list)-1-i])

    def find_index(self, name):
        tmp = self.head
        i = 1
        while tmp.data != name :
            if i > self.size:######################
                return #######################
            i += 1
            tmp = tmp.next

        return i

    def find_name(self, index):
        tmp = self.head
        while index-1:
            tmp = tmp.next
            index -= 1
        return tmp.data

    def push(self, data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
            self.tail = new_node
            self.size += 1
        else:
            self.head.prev = new_node
            new_node.next = self.head
            self.head = new_node
            self.size += 1

    def insert(self, name, location):
        if not self.head:
            new_node = Node(name)
            self.head = new_node
            self.tail = new_node
            self.size += 1
        elif location == 0:
            self.push(name)
            return
        elif location == self.size:
            new_node = Node(name)
            self.tail.next = new_node
            new_node.prev = self.tail
            self.tail = new_node
            self.size += 1
        else:
            new_node = Node(name)
            tmp = self.head
            for i in range(location):
                tmp = tmp.next
            tmp.prev.next = new_node
            new_node.prev = tmp.prev
            tmp.prev = new_node
            new_node.next=tmp
            self.size += 1

    def relocate(self, name, footpace):
        if footpace == 0:
            return
        tmp = self.head
        i = self.find_index(name)
        d = footpace + i - 1

        self.depart(name)

        if d < 0 :
            location = self.size+1+d
        else:
            location = d

        self.insert(name, location)

    def depart(self, name):
        if not self.head:
            return
        if self.size == 1:
            self.head = None
            self.size -= 1
            return
        index = self.find_index(name)
        if index == self.size:
            self.tail = self.tail.prev
            self.tail.next = None
        elif index == 1:
            self.head = self.head.next
            self.head.prev = None
        else:
            tmp = self.head
            for i in range(index-1):
                tmp = tmp.next
            tmp.prev.next = tmp.next
            tmp.next.prev = tmp.prev
        self.size -= 1

    def reverse(self, i, j):
        if i > self.size or j > self.size or i == j or i*j < 0:
            return
        tmp_first = self.head
        tmp_last = self.tail
        for z in range(i-1):
            tmp_first = tmp_first.next
        for z in range(self.size-j):
            tmp_last = tmp_last.prev
        for z in range((abs(j-i)+1)//2):
            tmp_last.data, tmp_first.data = tmp_first.data, tmp_last.data
            tmp_first = tmp_first.next
            tmp_last = tmp_last.prev
    def print(self):
        if not self.head:
            print("The airport is empty")
            return
        tmp = self.head
        while tmp.next:
            print(tmp.data, end=" ")
            tmp = tmp.next
        print(tmp.data)

s = input().split()
numb_H = int(s[0])
numb_O = int(s[1])
if numb_H != 0:
    h_list = input().split()
else:
    h_list = []
H_l_list = LinkedList(h_list)
for i in range(numb_O):
    order = input().split()
    if order[0] == "insert":
        H_l_list.insert(order[1], int(order[2]))
    if order[0] == "relocate":
        H_l_list.relocate(order[1], int(order[2]))
    if order[0] == "depart":
        H_l_list.depart(order[1])
    if order[0] == "reverse":
        H_l_list.reverse(int(order[1]), int(order[2]))
H_l_list.print()
