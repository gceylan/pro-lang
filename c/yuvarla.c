//girilen sayiyi yuvarla
#include <stdio.h>

int main(void) {
	float girilen_sayi;

	printf("Bir sayi giriniz :\n");
	scanf("%f", &girilen_sayi);

	printf("Sayinin yuvarlanmis sekli : %d\n", (int)(girilen_sayi + 0.5));
	return 0;
}
