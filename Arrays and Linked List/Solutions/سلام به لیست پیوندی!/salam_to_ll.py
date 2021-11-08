#Lida Safari
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
class LinkedList:
    def __init__(self):
        self.head = None
        self.size = 0
    def push(self, data):
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node
        self.size+=1
    def pop(self):
        if self.head == None:
            return
        else:
            self.head = self.head.next
            self.size -= 1
    def print(self):
        if self.head == None:
            print("list is empty")
            return
        tmp = self.head
        while tmp.next != None:
            print(tmp.data, end=" ")
            tmp = tmp.next
        print(tmp.data)
    def sort(self):
       # return
                for i in range(self.size):
                    tmp = self.head
                    while tmp.next != None:
                        if tmp.data > tmp.next.data:
                            tmp.data, tmp.next.data = tmp.next.data, tmp.data
                        tmp = tmp.next
my_linkedlist = LinkedList()
s = input().split()
order = s[0]
while order != "finish":
    if order == "push":
        my_linkedlist.push(int(s[1]))
    if order == "pop":
        my_linkedlist.pop()
    if order == "sort":
        my_linkedlist.sort()
    if order == "print":
        my_linkedlist.print()
    s = input().split()
    order = s[0]