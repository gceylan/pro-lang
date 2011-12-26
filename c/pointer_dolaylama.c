#include <stdio.h>

int main(void) {
	int x = 10;
	int *i;
	int **j;
	int ***k;

	printf("x : %d\n", x);

	i = &x;
	j = &i;
	k = &j; 	// pointer işaret eden pointer' i işaret edecek bir pointer. :-)

	***k = 100;

	printf("x : %d\n", x);
	
	return 0;
}
