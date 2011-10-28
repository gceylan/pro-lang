#!/usr/bin/env python
#-*- coding: utf-8 -*-


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
    return s[::-1]


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
    return s[:] + s[::-1]


def remove_letter(letter, s):
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
    new_s = ''
    for i in s:
        if i != letter:
            new_s += i
    return new_s


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
    t = 0
    m = len(sub)
    for i in range(0, len(s)):
        n = s[i:i + m]
        if n == sub:
            t += 1
    return t


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
        m = len(sub)
        n = s.index(sub)
        return s[:n] + s[n + m:]
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
    if sub in s:
        while 0 < n:
            m = remove(sub, s)
            s = m
            n -= 1
        return m
    else:
        return s

if __name__ == '__main__':
    import doctest
    doctest.testmod()
