#include <stdio.h>
#include <string.h>

void ters_cevir(char* dizi) {
	char* b = dizi;
	char* s = dizi + strlen(dizi) - 1;
	char degis;
	int i = 0;

	while (i < strlen(dizi) / 2) {
		degis = *(b + i);
		*(b + i) = *(s - i);
		*(s - i) = degis;
		i++;
	}
}

int main(void) {
	char str[100];
	int i = 0;

	printf("bir ifade giriniz: ");
	gets(str);

	ters_cevir(str);

	for (i = 0; str[i] != '\0'; i++) {
		printf("%c", str[i]);
	}

	printf("\n");
	return 0;
}
