#include <stdio.h>

typedef struct kompleks { 	// a + bi
	double a;
	double b;
}COMPLEX;

COMPLEX topla(COMPLEX n, COMPLEX m) {
	COMPLEX sonuc;
	
	sonuc.a = n.a + m.a;
	sonuc.b = n.b + m.b;
	
	return sonuc;
}

int main(void) {
	COMPLEX x, y, z;
	
	x.a = 2.0;
	x.b = 3.0;
	
	y.a = 1.0;
	y.b = 1.0;
	
	z = topla(x, y);
	
	printf("x = %f + %fi\n", x.a, x.b);
	printf("y = %f + %fi\n", y.a, y.b);
	printf("z = %f + %fi\n", z.a, z.b);
	
	return 0;
}
