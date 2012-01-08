#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct personel {
	char *isim;
	struct personel *sonraki;
}PERSONEL;

PERSONEL *bas, *son;

PERSONEL *liste_olustur() {
	PERSONEL *p;
	p = (PERSONEL *)malloc(sizeof(PERSONEL));
	
	if (p == NULL) {
		printf("BELLEK HATASI: MALLOC\n");
		exit(1);
	}
	
	p -> sonraki = NULL;
	
	return p;
}

void eleman_ekle(PERSONEL *el) { 	//elemani ekle
	PERSONEL *p;
	
	if(bas == NULL) {
		bas = el;
		return;
	}
	
	for(p=bas; p->sonraki != NULL; p = p->sonraki);
	
	p->sonraki = el;
}

void sonrasina_ekle(PERSONEL *x, PERSONEL *y) { 	//x' i y den sonraki yere ekle.
	if(x == NULL || y == NULL || x == y || y->sonraki == x) {
		printf("ARGUMANLAR UYGUN DEGİL\n");
		return;
	}
	x->sonraki = y->sonraki;
	y->sonraki = x;
}

void eleman_sil(PERSONEL *sil){
	PERSONEL *p;
	if(sil == bas)
		bas = sil->sonraki;
	else {
		for(p=bas; p != NULL && p->sonraki != sil; p = p->sonraki);
	p->sonraki = p->sonraki->sonraki;
	
	free(sil);
	}
}

PERSONEL *elemani_bul(char *isim) {
	PERSONEL *p;
	
	for(p = bas; p != NULL; p = p -> sonraki) {
		if(strcmp(p->isim, isim) == 0)
			return p;
	}
	
	return NULL;
}

void listele() {
	PERSONEL *p;
	
	for(p = bas; p != NULL; p = p->sonraki) {
		printf("ad : %s\n", p->isim);
	}
}

int main(void) {
	PERSONEL a, *b;
	b = &a;
	
	b -> isim = "gceylan";
	b -> sonraki = NULL;
	
	eleman_ekle(b);
	
	listele();
}
