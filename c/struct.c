#include <stdio.h>

struct node {
	int val;
	struct node *next;
};

int topla(struct node x, struct node y) {
	return x.val + y.val;
}

int main(void) {
	struct node a;
	struct node b;
	//struct node c;
	int n = 0;
	
	a.val = 120;
	a.next = &b;
	
	b.val = 110;
	b.next = NULL;
	
	n = topla(a, b);
	
	printf("%d\n", n);
	
	return 0;
}
