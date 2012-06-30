class oncelikli_kuyruk:
    def __init__(self):
        self.items = []

    def peek(self):
        return self.items[0]

    def enq(self, item, priority):
        if self.isEmpty():
            self.items.insert(0, (item, priority))
            print self.items
        else:
            peek = self.peek()
            if priority < peek[1]:
                self.items.insert(0, (item, priority))
                print self.items
            else:
                for ind, i in enumerate(self.items[::-1]):
                    if priority == i[1]:
                        self.items.insert(self.size() - ind, (item, priority))
                        print self.items
                        break
                    elif priority > i[1]:
                        self.items.append((item, priority))
                        print self.items
                        break

    def deq(self):
        return self.items.pop(0)

    def size(self):
        return len(self.items)

    def isEmpty(self):
        return self.items == []
