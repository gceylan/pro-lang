#include <stdio.h>

int tersini_dondur(int sayi) {
	int son_bsmk;
	int sonuc = 0;

	while (sayi) {
		if (sayi > 10) {
			son_bsmk = sayi % 10;
			sonuc = (sonuc * 10 + son_bsmk);
			sayi /= 10;
		}
		else
			return sonuc * 10 + sayi;
	}
}

int main(void) {
	int sayi;

	printf("sayinin tersini dondur: ");
	scanf("%d", &sayi);

	printf("sayinin tersi %d\n", tersini_dondur(sayi));

	return 0;
}
