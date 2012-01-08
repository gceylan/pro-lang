#include <stdio.h>

int my_strncmp(char *s1, char *s2, int n) {
	int i = 0;
	
	for (i = 0; *s1 || *s2; s1++, s2++, i++) {
		if ((*s1 > *s2) && (i < n)) {
			return 1;
		}
		else if ((*s1 < *s2) && (i < n)) {
			return -1;
		}
	}
	return 0;
}

int main(void) {
	char x[8] = "TURKIYE";
	char y[20] = "TURKIYE-AZERBAYCAN";
	
	printf("%d\n", my_strncmp(x, y, 7));
	printf("%d\n", my_strncmp(x, y, 11));
	
	return 0;
}
