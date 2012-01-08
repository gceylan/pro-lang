#include <stdio.h>

int my_strcspn(char *s1, char *s2) {
	char *p1, *p2;
	p1 = s1;
	p2 = s2;
	
	for( ; *p1; p1++) {
		for( ; *p2; p2++) {
			if(*p1 == *p2)
				return p1 - s1;
		}
		p2 = s2;
	}
	
	return '\0';
}

int main(void) {
	char k1[8] = "gceylan";
	char k2[6] = "mrter";
	int a = 0;
	
	a = my_strcspn(k1, k2);
	printf("%s icinde %s' de rastlanan ilk karakterin indisi %d' dir.\n", k1, k2, a);
	
	return 0;
}
