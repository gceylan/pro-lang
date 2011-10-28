#!/usr/bin/env python
#-*- coding: utf-8 -*-


def make_matrix(rows, columns):
    """
      >>> make_matrix(3, 5)
      [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]]
    """
    m = []
    for i in range(0, rows):
        m.append([0] * columns)
    return m


def soru_1():
    L = ['spam!', "one", ['Brie', 'Roquefort', 'Pol le Veq'], [1, 2, 3]]
    for i in L:
        print i, "boyut:", len(i)


def add_lists(a, b):
    """
      >>> add_lists([1, 1], [1, 1])
      [2, 2]
      >>> add_lists([1, 2], [1, 4])
      [2, 6]
      >>> add_lists([1, 2, 1], [1, 4, 3])
      [2, 6, 4]
    """
    s = []
    if len(a) == len(b):
        for i in range(0, len(a)):
            s.append(a[i] + b[i])
        return s
    print "Matris boyutları eşit değil!"


def mult_lists(a, b):
    """
      >>> mult_lists([1, 1], [1, 1])
      2
      >>> mult_lists([1, 2], [1, 4])
      9
      >>> mult_lists([1, 2, 1], [1, 4, 3])
      12
    """
    s = 0
    if len(a) == len(b):
        for i in range(0, len(a)):
            s += (a[i] * b[i])
        return s
    print "Matris boyutları eşit değil!"


def add_row(matrix):
    """
      >>> m = [[0, 0], [0, 0]]
      >>> add_row(m)
      [[0, 0], [0, 0], [0, 0]]
      >>> n = [[3, 2, 5], [1, 4, 7]]
      >>> add_row(n)
      [[3, 2, 5], [1, 4, 7], [0, 0, 0]]
      >>> n
      [[3, 2, 5], [1, 4, 7]]
    """
    L = len(matrix[0])
    return matrix + [[0] * L]


def add_column(matrix):
    """
      >>> m = [[0, 0], [0, 0]]
      >>> add_column(m)
      [[0, 0, 0], [0, 0, 0]]
      >>> n = [[3, 2], [5, 1], [4, 7]]
      >>> add_column(n)
      [[3, 2, 0], [5, 1, 0], [4, 7, 0]]
      >>> n
      [[3, 2], [5, 1], [4, 7]]
    """
    s = []
    L = len(matrix[0])
    for i in matrix:
        s.append(i + [0])
    return s


def add_matrices(m1, m2):
    """
      >>> a = [[1, 2], [3, 4]]
      >>> b = [[2, 2], [2, 2]]
      >>> add_matrices(a, b)
      [[3, 4], [5, 6]]
      >>> c = [[8, 2], [3, 4], [5, 7]]
      >>> d = [[3, 2], [9, 2], [10, 12]]
      >>> add_matrices(c, d)
      [[11, 4], [12, 6], [15, 19]]
      >>> c
      [[8, 2], [3, 4], [5, 7]]
      >>> d
      [[3, 2], [9, 2], [10, 12]]
    """
    x, y = len(m1), len(m1[0])
    s = make_matrix(x, y)
    for i in range(0, x):
        for j in range(0, y):
            s[i][j] = m1[i][j] + m2[i][j]
    return s


def scalar_mult(n, m):
    """
      >>> a = [[1, 2], [3, 4]]
      >>> scalar_mult(3, a)
      [[3, 6], [9, 12]]
      >>> b = [[3, 5, 7], [1, 1, 1], [0, 2, 0], [2, 2, 3]]
      >>> scalar_mult(10, b)
      [[30, 50, 70], [10, 10, 10], [0, 20, 0], [20, 20, 30]]
      >>> b
      [[3, 5, 7], [1, 1, 1], [0, 2, 0], [2, 2, 3]]
    """
    s = make_matrix(len(m), len(m[0]))
    for ind_1, i in enumerate(m):
        for ind_2, j in enumerate(i):
            s[ind_1][ind_2] = j * n
    return s


def matrix_mult(m1, m2):            # iki matrisin çarpımı
    """
      >>> matrix_mult([[1, 2], [3, 4]], [[5, 6], [7, 8]])
      [[19, 22], [43, 50]]
      >>> matrix_mult([[1, 2, 3], [4, 5, 6]], [[7, 8], [9, 1], [2, 3]])
      [[31, 19], [85, 55]]
    """
    n = []
    m = []
    for i in m2:
        n.append(i[0])
        m.append(i[1])

    m2 = [n] + [m]

    L = len(m1[0])
    t = 0
    s = []
    y = []
    for i in m1:
        for j in m2:
            for ind in range(0, L):
                t += (i[ind] * j[ind])
            s.append(t)
            t = 0
    return [s[:len(s) / 2]] + [s[len(s) / 2:]]


def replace(s, old, new):
    """
      >>> replace('Mississippi', 'i', 'I')
      'MIssIssIppI'
      >>> s = 'I love spom! Spom is my favorite food. Spom, spom, spom, yum!'
      >>> replace(s, 'am', 'om')
      'I love spom! Spom is my favorite food. Spom, spom, spom, yum!'
      >>> replace(s, 'o', 'a')
      'I lave spam! Spam is my favarite faad. Spam, spam, spam, yum!'
    """
    n = ''
    for i in s:
        if i == old:
            n += new
        else:
            n += i
    return n


def replace_v2(s, old, new):
    n = s.split(old)
    return new.join(n)


if __name__ == '__main__':
    import doctest
    doctest.testmod()
