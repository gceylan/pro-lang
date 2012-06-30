# -*- coding: utf-8 -*-

def dec_to_bin(sayi):
    """
      >>> dec_to_bin(123)
      '1111011'
    """
    s = Stack(100)
    
    while sayi > 0:
        s.push(sayi % 2)
        sayi /= 2

    str_bin = ""

    for i in range(0, s.size()):
        str_bin += str(s.pop())

    return str_bin

if __name__ == "__main__":
    from stack import*
    import doctest
    doctest.testmod()
