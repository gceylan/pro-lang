#include <stdio.h>
#include <string.h>
#define MAX 2

typedef struct personel {
	int sicil;
	char ad[15];
	char soyad[15];
	float maas;
} PERSON;

void yazdir(PERSON dizi[], int len) {
	int i = 0;
	
	printf("\nsicil\tad\tsoyad\tmaas\n\n");
	
	for (i=0; i < len; i++) {
		printf("%d\t%s\t%s\t%f\n", dizi[i].sicil, dizi[i].ad, dizi[i].soyad, dizi[i].maas);
	}
}

void sirala(PERSON d[], int len) {
	int i = 0, j = 0;
	PERSON temp;
	
	for (i = 0; i < len - 1; i++) {
		for (j = i + 1; j < len; j++) {
			if (strcmp(d[i].ad, d[j].ad) > 0) {
				temp = d[i];
				d[i] = d[j];
				d[j] = temp;
			}
		}
	}
}

int main(void) {
	PERSON p[MAX];
	int i = 0;
	
	for(i = 0; i < MAX; i++) {
		printf("sicil : ");
		scanf("%d", &p[i].sicil);
		printf("ad    : ");
		scanf("%s", p[i].ad);
		printf("soyad : ");
		scanf("%s", p[i].soyad);
		printf("maas  : ");
		scanf("%f", &p[i].maas);
	}
	
	yazdir(p, MAX);
	
	printf("\nADLARA GORE SIRALANIYOR...\n");
	
	sirala(p, MAX);
	
	yazdir(p, MAX);
	
	return 0;
}
