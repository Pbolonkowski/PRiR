#include<unistd.h>
#include <stdio.h>
#include<stdlib.h>
#include<time.h>
float func(float x)
{
return 4*x*x-6*x+5;
}

float M_Trapezow(float a, float b, int n)
{
float calka = 0;
float dx= (b-a)/n;

for(int i=1;i<=n-1;i++)
{
calka += func(a+i*dx);
}
calka += (func(a)+func(b))/2;
calka *= dx;
return calka;
}

int main()
{
printf("ilosc procesow: ");
int procesy;
scanf("%d",&procesy);

for(int i=0;i<procesy;i++)
{
if(fork()==0)
{
srand(time(NULL) ^ (getpid()<<16));
int a = rand()%50;
int b = a + 1 + rand()%50;
int n = 50 + rand()%50;
float wynik = M_Trapezow(a, b, n);

printf("Przedzial a: %d\n", a, b);
printf("przedzial b: %d\n", b);
printf("Wynik metoda trapezow: %f\n", wynik);
exit(0);
}
}
}
