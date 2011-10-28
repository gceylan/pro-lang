#!/usr/bin/env python
#-*- coding: utf-8 -*-


def compare(a, b):
    """
      >>> compare(5, 4)
      1
      >>> compare(7, 7)
      0
      >>> compare(2, 3)
      -1
      >>> compare(42, 1)
      1
    """
    if a > b:
        return 1
    elif a < b:
        return -1
    return 0


def hypotenuse(a, b):       # iki dik kenar uzunluğu bilinen üçgenin hipotenüsü
    """
      >>> hypotenuse(3, 4)
      5.0
      >>> hypotenuse(12, 5)
      13.0
      >>> hypotenuse(7, 24)
      25.0
      >>> hypotenuse(9, 12)
      15.0
    """
    dik_k = (a ** 2 + b ** 2) ** 0.5
    return dik_k


def spole(x1, y1, x2, y2):      # iki noktası bilinen doğrunun eğimi
    """
      >>> spole(5, 3, 4, 2)
      1.0
      >>> spole(1, 2, 3, 2)
      0.0
      >>> spole(1, 2, 3, 3)
      0.5
      >>> spole(2, 4, 1, 2)
      2.0
    """
    egim = float(y2 - y1) / (x2 - x1)
    return egim


def intercept(x1, y1, x2, y2):
    """
      >>> intercept(1, 6, 3, 12)
      3.0
      >>> intercept(6, 1, 1, 6)
      7.0
      >>> intercept(4, 6, 12, 8)
      5.0
    """
    egim = spole(x1, y1, x2, y2)
    y_kesim_noktasi = egim * -x1 + y1
    return y_kesim_noktasi


def is_even(n):
    """
      >>> is_even(2)
      True
      >>> is_even(3)
      False
    """
    return n % 2 == 0


def is_odd(n):
    """
      >>> is_odd(2)
      False
      >>> is_odd(3)
      True
    """
    if n % 2 == 0:
        return False
    return True


def is_factor(f, n):
    """
      >>> is_factor(3, 12)
      True
      >>> is_factor(5, 12)
      False
      >>> is_factor(7, 14)
      True
      >>> is_factor(2, 14)
      True
      >>> is_factor(7, 15)
      False
    """
    return n % f == 0


def is_multiple(m, n):
    """
      >>> is_multiple(12, 3)
      True
      >>> is_multiple(12, 4)
      True
      >>> is_multiple(12, 5)
      False
      >>> is_multiple(12, 6)
      True
      >>> is_multiple(12, 7)
      False
    """
    m, n = n, m
    return is_factor(m, n)


def c2f(t):         # Celcius' u fahrenheit' a çevirmek
    """
      >>> c2f(0)
      32
      >>> c2f(100)
      212
      >>> c2f(-40)
      -40
      >>> c2f(12)
      53
      >>> c2f(18)
      64
      >>> c2f(-48)
      -54
    """
    f = t * 1.8 + 32
    f = int(f)
    return f


if __name__ == "__main__":
    import doctest
    doctest.testmod()
