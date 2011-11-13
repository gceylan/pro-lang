// girilen cumle/kelimeyi tersten yazdirma

#include <stdio.h>
#include <string.h>

void ters_yaz(char* chpt) {
	int i = 0;
	int len = strlen(chpt);

	for(len; len > 0; len--) {
		printf("%c", chpt[len - 1]);
	}
}

int main(void) {
	char str[100];

	printf("bir cumle giriniz: ");
	gets(str);

	ters_yaz(str);
	printf("\n");

	return 0;
}
