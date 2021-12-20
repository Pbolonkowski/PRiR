Zadanie: Przedstaw efektywność środowiska CUDA w Google Colab na podstawie 2 niebanalnych przykładów (porównanie efektywności obliczeń na CPU i GPU z zależności od rozmiaru problemu -> opis problemu, kody na CPU i GPU, wykresy, wnioski).
Pierwszym programem jest obliczenie punktów Fraktalu Julii. Obliczamy tu bardzo dużą ilość punktów, dzięki czemu lepiej radzi sobie tutaj GPU. CPU jest kilkakrotnie wolniejszy.
Fraktal Julii CPU:
2 min 10 sek, 1 min 58 sek, 2 min 18 sek, 2 min 4 sek, 2 min 21 sek.
Fraktal Julii GPU:
1 sek, 1 sek, 1 sek, 2 sek, 1 sek.
Drugim programem jest sumowanie wektorów na CPU I GPU. W przypadku gdy N będzie liczbą dość małą okazuje sie, że CPU radzi sobie nieznacznie lepiej, jednak w przypadku gdy pod N podstawimy bardzo duże liczby, wtedy GPU zaczyna pokazywać swoje zalety takie jak możliwość rozłożenia zadania na mniejsze wykonując je równolegle. W momencie w którym mamy do czynienia z obliczaniem mniejszej wielkości wektorów, CPU sprawdza się nieznacznie lepiej niz GPU.
![image](https://user-images.githubusercontent.com/80579076/146839635-f08d10b8-2e23-4d1a-b9e2-a60f38855865.png)

Wniosek:
Po przetestowaniu dwóch przykładów różniących się poziomem zaawansowania mogę śmiało stwierdzić, że GPU jest dużo wydajniejszy, dzięki temu że pozwala rozłożyć zadania na mniejsze zadania wykonywane równolegle. Jedynym momentem, w którym CPU okazał się lepszy było wtedy, gdy mieliśmy do czynienia z mniej skomplikowanymi programami. Co więcej, programy pisany na CPU ma nieco łatwiejszy kod jednak nie zmienia to mojego zdania że GPU jest zdecydowanie lepszym wyborem.


