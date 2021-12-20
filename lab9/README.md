Zadanie: Przedstaw efektywność środowiska CUDA w Google Colab na podstawie 2 niebanalnych przykładów (porównanie efektywności obliczeń na CPU i GPU z zależności od rozmiaru problemu -> opis problemu, kody na CPU i GPU, wykresy, wnioski).
Pierwszym przykładem jest sumowanie wektorów na CPU I GPU. Okazuje się, że CPU wypada zdecydowanie gorzej w porównaniu do GPU. Program ma za zadanie obliczyć bardzo dużo wektorów i okazuje się, że CPU jest kilkukrotnie wolniejszy niż GPU. W momencie w którym mamy do czynienia z obliczaniem mniejszej wielkości wektorów, CPU sprawdza się nieznacznie lepiej niz GPU.
Wniosek:
Po przetestowaniu dwóch przykładów różniących się poziomem zaawansowania mogę śmiało stwierdzić, że GPU jest dużo wydajniejszy, dzięki temu że pozwala rozłożyć zadania na mniejsze zadania wykonywane równolegle. Jedynym momentem, w którym CPU okazał się lepszy było wtedy, gdy mieliśmy do czynienia z mniej skomplikowanymi programami. Co więcej, programy pisany na CPU ma nieco łatwiejszy kod.


