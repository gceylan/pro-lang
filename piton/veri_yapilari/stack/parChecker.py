from stack import *


def parChecker(str_symbol):
    """
     >>> parChecker("(()(()))")
     True
     >>> parChecker("(()")
     False
    """
    s = Stack()
    ind = 0
    balanced = True
    L = len(str_symbol)

    while ind < L and balanced:
        symbol = str_symbol[ind]
        if symbol == '(':
            s.push(symbol)
        else:
            if s.isEmpty():
                balanced = False
            else:
                s.pop()

        ind += 1

    return balanced and s.isEmpty()

if __name__ == "__main__":
    import doctest
    doctest.testmod()
