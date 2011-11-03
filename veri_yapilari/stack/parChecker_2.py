# -*- coding: utf-8 -*-
from stack import *


def matches(open, close):
    opens = "([{"
    closes = ")]}"

    return opens.index(open) == closes.index(close)


def parChecker2(str_symbol):
    s = Stack(20)
    ind = 0
    L = len(str_symbol)
    balanced = True

    while ind < L and balanced:
        symbol = str_symbol[ind]
        if symbol in "([{":
            s.push(symbol)
        else:
            if s.isEmpty():
                balanced = False
                print "%s. indexdeki \"%s\" açılmadan kapandı." %(ind, symbol)
            else:
                top = s.pop()
                if not matches(top, symbol):
                    balanced = False
                    print "\"%s\" kapatılmadı." %(top)
                    print "%s. indexdeki \"%s\" açılmadan kapandı." %(ind, symbol)
        ind += 1

    if not s.isEmpty():
        for i in range(0, s.size()):
            n = s.pop()
            print "\"%s\" kapatılmadı." %(n)
    else:
        return balanced and s.isEmpty()
    
if __name__ == "__main__":
    import doctest
    doctest.testmod()
