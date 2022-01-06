Lab 10
Zaimplementuj w Google Colab całkowanie numeryczne metodą prostokątów, trapezów oraz Simpsona w wersji na CPU i GPU. Przestaw różnice w czasie obliczeń w zależności od rozmiaru problemu (liczby przedziałów całkowania) w postaci wykresów oraz wniosków.

![image](https://user-images.githubusercontent.com/80579076/148446046-c15fd2eb-a879-498c-9113-842164d2fae6.png)

Podana tabela zawiera czas wykonania poszczególnych metod całkowania w wersji na CPU i GPU. Całka, która została wykorzystana to x*x+3.
Pierwszą rzeczą na którą zwróciłem uwagę to różnica czasu wykonywania przez CPU I GPU. Okazuje się, że w wersji CPU podane metody wykonują się dużo szybciej niż na GPU. Program potrzebuje najmniej czasu w momencie, gdy nasze N jest mniejsze niż 100000 i w wersji na CPU. Dodatkowo warto dodać, że w momencie w którym zwiększamy wartość N czas wykonywania cały czas się zwiększa.
By lepiej zobrazować dane postanowiłem stworzyć wykres, który podkreśla różnicę czasu, warto tutaj zwrócić uwagę na różnice wersji CPU i GPU.

![image](https://user-images.githubusercontent.com/80579076/148447265-47189459-ae38-4941-a882-af4836fc1346.png)

Kolejna rzecz, na którą zwróciłem uwagę to Wyniki poszczególnych metod. Okazuje się, że program nie liczy całki poprawnie dla N =100000000. 

![image](https://user-images.githubusercontent.com/80579076/148447597-8f38de23-e7d1-41bd-88cf-80ceab14284f.png)
