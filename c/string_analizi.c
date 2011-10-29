//cümle analizi

#include <stdio.h>
#include <string.h>

void harf_sayilari(char *);

int harfler[26];

void harf_sayilari(char *chpt) {
        int i = 0, j = 0;
        char harf;

        for(i=0; i<strlen(chpt); i++) {
                harf = chpt[i];
                if (harf != ' ')
                        harfler[harf - 97]++;
        }

        for (j=0; j<26; j++) {
                if (harfler[j] != 0) {
                        printf("%c : %d\n", j + 97, harfler[j]);
                }
        }
}


int main(void) {
        char cumle[100];

        printf("Bir cümle giriniz (--en fazla 100 karakter--): \n");
        gets(cumle);

        harf_sayilari(cumle);

        return 0;
}

