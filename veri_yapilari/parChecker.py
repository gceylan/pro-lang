from stack import *

def parChecker(str_symbol):
    s = Stack()
    ind = 0
    balanced = True
    L = len(str_symbol)

    while ind < L and balanced:
        symbol = str_symbol[ind]
        if symbol == '(':
            s.push(str_symbol[ind])
        else:
            if s.isEmpty():
                balancef = False
            else:
                s.pop()

        ind += 1

    return balanced and s.isEmpty()
