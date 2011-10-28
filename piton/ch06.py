#!/usr/bin/env python
#-*- coding: utf-8 -*-


def mutlak_al(n):
    if n < 0:
        return -1 * n
    else:
        return n


def num_digits(n):
    """
      >>> num_digits(12345)
      5
      >>> num_digits(0)
      1
      >>> num_digits(-12345)
      5
    """
    n = mutlak_al(n)
    bs = 0
    if n == 0:
        return 1
    while n:
        bs += 1
        n = n / 10
    return bs


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
    s = 0
    while n:
        kalan = n % 10
        if kalan % 2 == 0:
            s += 1
        n = n / 10
    return s


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
        print n % 10,
        n = n / 10


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
    if n == 1:
        return 1
    else:
        s = 0
        while n:
            kalan = n % 10
            s += kalan ** 2
            n = n / 10
        return s


if __name__ == '__main__':
    import doctest
    doctest.testmod()
