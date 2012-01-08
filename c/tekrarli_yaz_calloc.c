#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char *tekrarli_yaz(char *metin, int n) {
	int boyut = n * strlen(metin) + 1;
	char *hedef = (char *)calloc(boyut, sizeof(char));
	int tekrar = 0, i = 0, j = 0;

	for(i=0; metin[i] != '\0'; i++) {
		while (tekrar++ < n) {
			hedef[j++] = metin[i];
		}
		tekrar = 0;
	}

	return hedef;
}

int main(void) {
	char *metin = "gceylan";

	printf("%s\n", tekrarli_yaz(metin, 2));

	return 0;
}
