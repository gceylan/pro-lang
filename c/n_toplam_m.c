//girilen iki sayi arasindaki sayilarin toplamini bulan program

#include <stdio.h>

int main(void) {
	int alt = 0, ust = 0;
	int toplam = 0;

	printf("iki sayi giriniz(11 45): ");
	scanf("%d%d", &alt, &ust);

	if (ust >= alt) {
		for(alt; alt <= ust; alt++) {
			toplam += alt;
		}
	}

	printf("toplam: %d\n", toplam);

	return 0;
}
