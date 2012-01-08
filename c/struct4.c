#include <stdio.h>

typedef struct node {
	int val;
	struct node *next;
}DUGUM;

DUGUM *topla(DUGUM *x, DUGUM *y) {
	DUGUM p;
	
	p.val = x->val + y->val;
	p.next = NULL;
	
	return &p;
}

int main(void) {
	DUGUM a;
	DUGUM b;
	DUGUM *x;
	
	a.val = 120;
	a.next = &b;
	
	b.val = 52;
	b.next = NULL;
	
	x = topla(&a, &b);
	
	printf("%d\n", x->val);
	
	return 0;
}
