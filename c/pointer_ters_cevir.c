// pointer kullanarak diziyi ters cevirmek...

#include <stdio.h>

void pointer_ters_cevir(char* dizi, int dizi_boyu) {
	int i = 0;
	char degisecek;

	for (i=0; i < dizi_boyu/2; i++) {
		degisecek = *(dizi + i);
		*(dizi + i) = *(dizi + dizi_boyu - 1 - i);
		*(dizi + dizi_boyu - 1 - i) = degisecek;
	}
}

int main(void) {
	int len = 7, i = 0;
	char dizi[] = "gceylan";

	pointer_ters_cevir(dizi, len);

	for(i=0; i < len; i++) {
		printf("%c", dizi[i]);
	}

	printf("\n");
	return 0;
}
