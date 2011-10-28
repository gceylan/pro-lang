def alfabetik_artan(kelime):
    m = list(kelime)
    n = list(kelime)
    n.sort()
    if m == n:
        return True
    else:
        return False
alfabetik_artan('abc')
