#include<unistd.h>
#include <stdio.h>
#include<stdlib.h>
#include<time.h>
#include<math.h>

float Leibniz(int n)
{
    float wynik = 0;
    float suma = 0;
    for (int i=1; i<=n; i++)
    {
        suma = powf(-1, i-1) / (2 * i - 1);
        wynik += suma;
    }
    return 4 * wynik;
}

int main ()
{
    int procesy;
    printf("Ilosc procesorow: ");
    
    scanf("%d", &procesy);

    for(int i=0; i<procesy; i++)
    {
        if(fork()==0)
        {
            srand(time(NULL) ^ (getpid()<<16));
            int n = 100 + rand()%5000+1;
            printf("N = %d\n", n);
            float wynik = Leibniz(n);
            printf("Przyblizenie liczby Pi z wozru Leibniz-a = %f\n", wynik);
            exit(0);
        }
    }
}
