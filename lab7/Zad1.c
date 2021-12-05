#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include "mpi.h"
#define REZERWA 500
#define ZAJEZDNIA 1
#define WYJAZD 2
#define JAZDA 3
#define KONIEC_TRASY 4
#define WYKOLEJENIE 5
#define TANKUJ 5000
int paliwo = 5000;
int ZATRZYMAJ=1, NIE_ZATRZYMUJ=0;
int liczba_procesow;
int nr_procesu;
int ilosc_tramwajow;
int ilosc_tras=4;
int ilosc_zajetych_tras=0;
int tag=1;
int wyslij[2];
int odbierz[2];
MPI_Status mpi_status;
void Wyslij(int nr_tramwaju, int stan)
{
  wyslij[0]=nr_tramwaju;
  wyslij[1]=stan;
  MPI_Send(&wyslij, 2, MPI_INT, 0, tag, MPI_COMM_WORLD);
  sleep(1);
}

void Zajezdnia(int liczba_procesow){
  int nr_tramwaju,status;
  ilosc_tramwajow = liczba_procesow - 1;
  printf("Halo, Witam serdecznie, tu zajezdnia \n");
  if(rand()%2==1){
    printf("Mamy dobre warunki na trasie\n");
  }
  else{
   printf("Moga wystapic utrudnienia na trasie\n");
  }
  printf("Zyczymy Panstwu, przyjemnej podrozy \n \n \n");
  printf("Dysponujemy %d torowiskami\n", ilosc_tras);
  sleep(2);
  while(ilosc_tras<=ilosc_tramwajow){
    MPI_Recv(&odbierz,2,MPI_INT,MPI_ANY_SOURCE,tag,MPI_COMM_WORLD, &mpi_status); 
    nr_tramwaju=odbierz[0];
    status=odbierz[1];
    if(status==1){
      printf("Tramwaj %d stoi na zajezdni, przynajmniej sie nie wykolei\n", nr_tramwaju);
    }
    if(status==2){
      printf("Tramwaj %d pozwolenie na wyjazd na trase nr %d\n", nr_tramwaju, ilosc_zajetych_tras);
      ilosc_zajetych_tras--;
    }
    if(status==3){
      printf("Tramwaj %d JEDZIE\n", nr_tramwaju);
    }
    if(status==4){
       if(ilosc_zajetych_tras<ilosc_tras){
          ilosc_zajetych_tras++;
          MPI_Send(&ZATRZYMAJ, 1, MPI_INT, nr_tramwaju, tag, MPI_COMM_WORLD);
        }
    else{
      MPI_Send(&NIE_ZATRZYMUJ, 1, MPI_INT, nr_tramwaju, tag, MPI_COMM_WORLD);
        }
      }
    if(status==5){
      ilosc_tramwajow--;
      printf("Ilosc tramwajow %d\n", ilosc_tramwajow);
      }
    } 
   printf("Program zakonczyl dzialanie:)\n");
  }
void Tramwaj(){
  int stan,suma,i;
  stan=JAZDA; 
  while(1){
    if(stan==1){
      if(rand()%2==1){
        stan=WYJAZD;
        paliwo=TANKUJ;
        printf("Prosze o pozwolenie na wyjazd, tramwaj %d\n",nr_procesu);
        Wyslij(nr_procesu,stan);
    }
    else{
      Wyslij(nr_procesu,stan);
    }
  }
    else if(stan==2){
        printf("Wyjechalem, tramwaj %d\n",nr_procesu);
        stan=JAZDA;
        Wyslij(nr_procesu,stan);
    }
    else if(stan==3){
      paliwo-=rand()%500; 
      if(paliwo<=REZERWA){
        stan=KONIEC_TRASY;
        printf("prosze o pozwolenie na powrot do zajezdni\n");
        Wyslij(nr_procesu,stan);
    }
    else{
      for(i=0; rand()%10000;i++);
      }
    }
    else if(stan==4){
    int temp;
    MPI_Recv(&temp, 1, MPI_INT, 0, tag, MPI_COMM_WORLD, &mpi_status);
    if(temp==ZATRZYMAJ){
      stan=ZAJEZDNIA;
      printf("Wrocilem, tramwaj %d\n", nr_procesu);
    }
    else
    {
      paliwo-=rand()%500;
    if(paliwo>0){
    Wyslij(nr_procesu,stan);
    }
    else{
    stan=WYKOLEJENIE;
    printf("Wykoleilem sie\n");
    Wyslij(nr_procesu,stan);
    return;
    }
  }
 }
}
}
int main(int argc, char *argv[])
{
  MPI_Init(&argc, &argv);
  MPI_Comm_rank(MPI_COMM_WORLD,&nr_procesu);
  MPI_Comm_size(MPI_COMM_WORLD,&liczba_procesow);
  srand(time(NULL));
  if(nr_procesu == 0){
  Zajezdnia(liczba_procesow);
	}
  else{
  Tramwaj();
	}
  MPI_Finalize();
  return 0;
}
