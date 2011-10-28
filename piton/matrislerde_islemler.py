#!/usr/bin/env python
#-*- coding: utf-8 -*-
import doctest


def add_column(a):
    """
     >>> a = [[1, 2], [3, 4]]
     >>> add_column(a)
     [[1, 2, 0], [3, 4, 0]]
     >>> a
     [[1, 2], [3, 4]]
    """
    t = []
    for i in a:
        t.append(i + [0])
    return t


def add_column_one(a):
    """
     >>> a = [[1, 2], [3, 4]]
     >>> add_column_one(a)
     [[0, 1, 2], [0, 3, 4]]
     >>> a
     [[1, 2], [3, 4]]
    """
    t = []
    for ind, i in enumerate(a):
        t.insert(ind, [0] + i)
    return t


def add_row(a):
    """
     >>> a = [[1, 2], [3, 4]]
     >>> add_row(a)
     [[1, 2], [3, 4], [0, 0]]
     >>> a
     [[1, 2], [3, 4]]
    """
    t = []
    for i in a:
        n = len(i)
        t.append(i)
    t.append([0] * n)
    return t


def add_row_one(a):
    """
     >>> a = [[1, 2], [3, 4]]
     >>> add_row_one(a)
     [[0, 0], [1, 2], [3, 4]]
    """
    t = []
    for i in a:
        n = len(i)
        t.append(i)
    t.insert(0, [0] * n)
    return t


def ana_islem(a):
    n = add_row(a)
    m = add_row_one(n)
    k = add_column(m)
    l = add_column_one(k)
    return l
doctest.testmod()
