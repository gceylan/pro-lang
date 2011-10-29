#include <stdio.h>

int main(void) {
	int sayi;

	printf("Bir sayi giriniz: ");
	scanf("%d", &sayi);

	while (sayi > 10) {
		printf("%d", sayi%10);
		sayi /= 10;
	}
	printf("%d\n", sayi);
	return 0;
}
