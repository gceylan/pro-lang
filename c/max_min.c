// klavyeden -1 girene kadar girilen sayılardan en büyük ve en küçüğünü bulma

#include <stdio.h>

int main(void) {
	int sayi = 0;
	int min;
	int max;
	int i = 1;

	while (i) {
		printf("%d sayiyi giriniz: ", i);
		scanf("%d", &sayi);

		if (sayi != -1) {
			if (sayi >= max)
				max = sayi;
			if (sayi <= min)
				min = sayi;
		} else break;

		i++;
	}

	printf("en buyuk sayi: %d\nen kucuk sayi: %d\n", max, min);

	return 0;
}
