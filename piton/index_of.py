#!/usr/bin/env python
#-*- coding: utf-8 -*-
import doctest


def index_of(val, seq, start=0):
    """
      >>> index_of(9, [1, 7, 11, 9, 10])
      3
      >>> index_of(5, (1, 2, 4, 5, 6, 10, 5, 5))
      3
      >>> index_of(5, (1, 2, 4, 5, 6, 10, 5, 5), 4)
      6
      >>> index_of('y', 'happy birthday')
      4
      >>> index_of('banana', ['apple', 'banana', 'cherry', 'date'])
      1
      >>> index_of(5, [2, 3, 4])
      -1
      >>> index_of('b', ['apple', 'banana', 'cherry', 'date'])
      -1
    """
    for i in seq:
        if start == 0:
            if i == val:
                return start
        else:
            n = seq[start:]
            for ind, j in enumerate(n):
                if j == val:
                    return start + ind
        if val not in seq:
            return -1
        start += 1
doctest.testmod()
