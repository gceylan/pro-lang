# -*- coding: utf-8 -*-


class Stack:
    def __init__(self, size=10):
        self.items = []
        self.len_items = size

    def push(self, item):
        if self.size() != self.len_items:
            self.items.insert(0, item)
        else:
            print "Yığıt dolu. %s eklenemedi." % item

    def pop(self):
        if self.isEmpty():
            print "Yığıt boş"
        else:
            return self.items.pop(0)

    def peek(self):
        if not self.isEmpty():
            return self.items[0]
        print "Yığıt boş"

    def isEmpty(self):
        return self.items == []
        
    def size(self):
        return len(self.items)
