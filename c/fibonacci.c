#include <stdio.h>

int main(void) {
	int a = 0;
	int b = 1;
	int c, n, i;

	printf("kaca kadar fibonacci?: ");
	scanf("%d", &n);

	for(i=1; i<=n; i++) {
		printf("%d ", a);
		c = a + b;
		a = b;
		b = c;
	}

	return 0;
}
