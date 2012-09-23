#!/usr/bin/python
# encoding: utf-8

# not: çözümle alakası yoktur
def bul(samanlik, igne, yer=0):
	i = 0
	index = len(igne) * yer

	# samanlıgı daralt
	samanlik = samanlik[index:]

	len_igne = len(igne)
	len_samanlik = len(samanlik)

	if len_samanlik - len_igne >= 0:
		while i <= len_samanlik - len_igne:
			k = 0
			while (samanlik[i + k] == igne[k]):
				if k == len_igne - 1:
					print "index: %d - %d" %(i + index, i + k + index)
					return index + i    # baslangic indisini dondur
				else:
					k += 1
			i += 1

	print "Aranan iğne bulunamadı."

	return 0


print bul("111010101101001", "101", 2)
print bul("11101011001", "01")
print bul("merhaba ben ******", "merhaba")
print bul("110110101011", "1010", 2)
