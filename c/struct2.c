#include <stdio.h>

typedef struct node {
	int val;
	struct node *next;
}DUGUM;

int topla(DUGUM x, DUGUM y) {
	return x.val + y.val;
}

int main(void) {
	DUGUM a;
	DUGUM b;
	int n = 0;
	
	a.val = 120;
	a.next = &b;
	
	b.val = 22;
	b.next = NULL;
	
	n = topla(a, b);
	
	printf("%d\n", n);
	
	return 0;
}
