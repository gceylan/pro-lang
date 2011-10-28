#!/usr/bin/env python
#-*- coding: utf-8 -*-
import doctest


def add_column(a):
    """
     >>> a = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
     >>> add_column(a)
     [[1, 2, 3, 3], [4, 5, 6, 6], [7, 8, 9, 9]]
     >>> a
     [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    """
    t = []
    for i in a:
        t.append(i + [i[len(i) - 1]])
    return t


def add_column_one(a):
    """
     >>> a = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
     >>> add_column_one(a)
     [[1, 1, 2, 3], [4, 4, 5, 6], [7, 7, 8, 9]]
     >>> a
     [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    """
    t = []
    for i in a:
        t.append([i[0]] + i)
    return t


def add_row(a):
    """
     >>> a = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
     >>> add_row(a)
     [[1, 2, 3], [4, 5, 6], [7, 8, 9], [7, 8, 9]]
     >>> a
     [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    """
    t = []
    t.extend(a + [a[len(a) - 1]])
    return t


def add_row_one(a):
    """
     >>> a = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
     >>> add_row_one(a)
     [[1, 2, 3], [1, 2, 3], [4, 5, 6], [7, 8, 9]]
    """
    t = []
    t.extend([a[0]] + a)
    return t


def array_pading(a):
    n = add_row(a)
    m = add_row_one(n)
    k = add_column(m)
    L = add_column_one(k)
    return L
doctest.testmod()
