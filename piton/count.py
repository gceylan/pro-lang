def count(val, seq):
    """
      >>> count(5, (1, 5, 3, 7, 5, 8, 5))
      3
      >>> count('s', 'Mississippi')
      4
      >>> count((1, 2), [1, 5, (1, 2), 7, (1, 2), 8, 5])
      2
    """
    n = 0
    for i in seq:
        if i == val:
            n += 1
    return n
print count((1, 2), [1, 5, (1, 2), 7, (1, 2), 8, 5])
