#!/usr/bin/env python
#-*- coding: utf-8 -*-


def my_count(s, ch):
    c = 0
    for i in s:
        if i == ch:
            c += 1
    return c


def reverse(s):
    """
      >>> reverse('happy')
      'yppah'
      >>> reverse('Python')
      'nohtyP'
      >>> reverse("")
      ''
      >>> reverse("P")
      'P'
    """
    ters = ''
    ind = 1
    while ind <= len(s):
        ters += s[len(s) - ind]
        ind += 1
    return ters


def mirror(s):
    """
      >>> mirror("good")
      'gooddoog'
      >>> mirror("yes")
      'yessey'
      >>> mirror('Python')
      'PythonnohtyP'
      >>> mirror("")
      ''
      >>> mirror("a")
      'aa'
    """
    return s + reverse(s)


def remove_letter(letter, strng):
    """
      >>> remove_letter('a', 'apple')
      'pple'
      >>> remove_letter('a', 'banana')
      'bnn'
      >>> remove_letter('z', 'banana')
      'banana'
      >>> remove_letter('i', 'Mississippi')
      'Msssspp'
    """
    s = ''
    for i in strng:
        if i != letter:
            s += i
    return s


def is_palindrome(s):
    """
      >>> is_palindrome('abba')
      True
      >>> is_palindrome('tenet')
      True
      >>> is_palindrome('banana')
      False
      >>> is_palindrome('straw warts')
      True
    """
    ort = len(s) / 2
    text = s[:ort]
    if reverse(text) in s:
        return True
    return False


def count(sub, s):
    """
      >>> count('is', 'Mississippi')
      2
      >>> count('an', 'banana')
      2
      >>> count('ana', 'banana')
      2
      >>> count('nana', 'banana')
      1
      >>> count('nanan', 'banana')
      0
    """
    c = 0
    x = len(sub)
    for i in range(0, len(s)):
        if sub == s[i: i + x]:
            c += 1
    return c


def remove(sub, s):
    """
      >>> remove('an', 'banana')
      'bana'
      >>> remove('cyc', 'bicycle')
      'bile'
      >>> remove('iss', 'Mississippi')
      'Missippi'
      >>> remove('egg', 'bicycle')
      'bicycle'
    """
    if sub in s:
        ind = s.find(sub)
        return s[:ind] + s[ind + len(sub):]
    else:
        return s


def remove_all(sub, s):
    """
      >>> remove_all('an', 'banana')
      'ba'
      >>> remove_all('cyc', 'bicycle')
      'bile'
      >>> remove_all('iss', 'Mississippi')
      'Mippi'
      >>> remove_all('eggs', 'bicycle')
      'bicycle'
    """
    n = count(sub, s)
    for i in range(0, n):
        s = remove(sub, s)
    return s


if __name__ == '__main__':
    import doctest
    doctest.testmod()
