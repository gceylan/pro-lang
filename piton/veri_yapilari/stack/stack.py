# -*- coding: utf-8 -*-


class Stack:
    def __init__(self, size=10):
        self.items = []
        self.len_items = size

# yığıtta kaç eleman var?
    def size(self):
        return len(self.items)

#item i (öğeyi) yığıtın tepesine ekler. Dönüș yok.
    def push(self, item):
        if self.size() != self.len_items:
            self.items.append(item)
        else:
            print "Yığıt dolu. %s eklenemedi." % (item)

#tepeden bir öğeyi çıkarır, geri döndürür. Yığıt güncellenir.
    def pop(self):
        if self.isEmpty():
            print "Yığıt boş"
        else:
            return self.items.pop()

#tepedeki değer döndürülür, çıkarılmaz. Yığıt güncellenmez.
    def peek(self):
        if not self.isEmpty():
            return self.items[len(self.items) - 1]
        print "Yığıt boş"

#yığıt boş mu? (True - False)
    def isEmpty(self):
        return self.items == []
