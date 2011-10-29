//string içinde isteninlen harfin kaç tane olduğunu bulma

#include <stdio.h>
#include <string.h>

int harf_sayisi(char string[], char harf) {
        int i;
        int s=0;

        for(i=0; i<strlen(string); i++) {
                if (string[i] == harf)
                        s++;
        }
        return s;
}

int main(void){
        char string[20];
        char c;
        int snc;

        printf("Kelimeyi giriniz: ");
        scanf("%s %c", string, &c);

        printf("Girilen kelime: %s\n", string);
        printf("aranacak harf: %c\n", c);

        snc = harf_sayisi(string, c);
        printf("%s kelimesindeki %c harfi sayisi: %d dir.\n", string, c, snc);
        return 0;
}
