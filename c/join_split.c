#include <stdio.h>
#include <string.h>

void split(char* dizi, char karakter) {
	int boyut = 2 * strlen(dizi) - 1;
	int dizi2[boyut];
	int i = 0, j = 0;

	while (i < boyut) {
		if (i % 2 == 0) {
			dizi2[i] = dizi[j];
			j++;
		} else
			dizi2[i] = karakter;
		i++;
	}

	for (i=0; i < boyut; i++) {
		printf("%c", dizi2[i]);
	}
}

int main(void) {
	int len_dizi = 7;
	char ch = '_';
	char dizi[] = "gceylan";

	split(dizi, ch);

	printf("\n");
	return 0;
}
