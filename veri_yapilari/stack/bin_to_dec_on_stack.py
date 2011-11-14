# -*- coding: utf-8 -*-

def bin_to_dec(sayi):
    """
      >>> bin_to_dec("1111")
      15
      >>> bin_to_dec("1101")
      13
    """
    s = Stack(100)

    for i in sayi:
        s.push(i)

    dec = 0

    for i in range(0, s.size()):
        dec += 2**i * int(s.pop())

    return dec
        
if __name__ == "__main__":
    from stack import*
    import doctest
    doctest.testmod()
