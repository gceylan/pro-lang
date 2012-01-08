#include <stdio.h>

typedef struct node {
	int val;
	struct node *next;
}DUGUM;

DUGUM topla(DUGUM *x, DUGUM *y) {
	DUGUM A;
	
	A.val = x->val + y->val;
	A.next = NULL;
	
	return A;
}

int main(void) {
	DUGUM a;
	DUGUM b;
	DUGUM n;
	
	a.val = 120;
	a.next = &b;
	
	b.val = 22;
	b.next = NULL;
	
	n = topla(&a, &b);
	
	printf("%d\n", n.val);
	
	return 0;
}
