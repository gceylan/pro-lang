import doctest


def tur(seq):
    if type(seq) == type([]):
        return []
    if type(seq) == type(''):
        return ''
    return ()


def tur2(val, seq):
    if type(seq) == type(''):
        return str(val)
    if type(seq) == type([]):
        return [val]
    return (val,)


def remove_all(val, seq):
    """
      >>> remove_all(1, (1, 2, 3 ,1))
      (2, 3)
      >>> remove_all(11, [1, 7, 11, 9, 11, 10, 2, 11])
      [1, 7, 9, 10, 2]
      >>> remove_all('i', 'Mississippi')
      'Msssspp'
    """
    m = tur(seq)
    for i in seq:
        if i != val:
            m += tur2(i, seq)
    return m
doctest.testmod()
