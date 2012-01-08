#include <stdio.h>

void tekrar_yaz(char *metin, int n) {
	int tekrar = 0;
	int i = 0;

	for(i=0; metin[i] != '\0'; i++) {
		while (tekrar++ < n) {
			printf("%c", metin[i]);
		}
		tekrar = 0;
	}
}

int main(void) {
	char *metin = "Matlab-R2008b";

	tekrar_yaz(metin, 2);
	//printf("\n%s\n", tekrar_yaz(metin, 2));
	//printf("\n%s\n", tekrar_yaz(metin, 3));

	return 0;
}
