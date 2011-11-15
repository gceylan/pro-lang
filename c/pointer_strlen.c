// pointer kullanarak dizi uzunlugu bulma

#include <stdio.h>

int len(char* dizi) {
	char* p;

	p = dizi;

	for(dizi; *dizi != '\0'; dizi++) {
	}

	return dizi - p;
}

int main(void) {
	char str[] = "merhaba ben gceylan";

	printf("dizinin uzunlugu: %d\n", len(str));

	return 0;
}
