#!/usr/bin/env python
#-*- coding: utf-8 -*-


def birinci_soru():
    print "bu\nçýktýyý\nüretmeli."


def sqrt(n):
    approx = n / 2.0
    better = (approx + n / approx) / 2.0
    while better != approx:
        approx = better
        better = (approx + n / approx) / 2.0
        print better
    return approx


def print_triangular_numbers(satir):
    i, j = 0, 0
    while i <= satir:
        i += 1
        j += i
        print i, "\t", j


def num_digits(n):
    """
      >>> num_digits(12345)
      5
      >>> num_digits(0)
      1
      >>> num_digits(-12345)
      5
    """
    n = abs(n)
    t = 0
    if n == 0:
        return 1
    while n:
        n = n / 10
        t += 1
    return t


def num_even_digits(n):
    """
      >>> num_even_digits(123456)
      3
      >>> num_even_digits(2468)
      4
      >>> num_even_digits(1357)
      0
      >>> num_even_digits(2)
      1
      >>> num_even_digits(20)
      2
    """
    c = 0
    while n:
        k = n % 10
        if k % 2 == 0:
            c += 1
        n = n / 10
    return c


def print_digits(n):
    """
      >>> print_digits(13789)
      9 8 7 3 1
      >>> print_digits(39874613)
      3 1 6 4 7 8 9 3
      >>> print_digits(213141)
      1 4 1 3 1 2
    """
    while n:
        k = n % 10
        print k,
        n = n / 10
    return


def sum_of_squares_of_digits(n):
    """
      >>> sum_of_squares_of_digits(1)
      1
      >>> sum_of_squares_of_digits(9)
      81
      >>> sum_of_squares_of_digits(11)
      2
      >>> sum_of_squares_of_digits(121)
      6
      >>> sum_of_squares_of_digits(987)
      194
    """
    s = 0
    while n:
        k = n % 10
        s += k ** 2
        n /= 10
    return s


if __name__ == '__main__':
    import doctest
    doctest.testmod()
