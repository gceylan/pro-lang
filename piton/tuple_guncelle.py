import doctest


def tuple_guncelle(tup, yer, eleman):
    """
      >>> x = (1, 2, 3, 4, 5)
      >>> tuple_guncelle(x, 3, 'a')
      (1, 2, 3, 'a', 5)
    """
    n = tup[:yer] + (eleman,) + tup[yer + 1:]
    return n
print tuple_guncelle((1, 2, 3, 4, 5), 3, 'a')
doctest.testmod()
