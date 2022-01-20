Zadanie 2

Znajdź i opisz/przetestuj/może rozwiń inne ciekawe zastosowanie biblioteki pyTorch/Tensorflow (można wykorzystać dostępne kody z Internetu) 1p

Klasyfikacja obrazu odzieży z użyciem biblioteki Tensorflow

Program szkoli model sieci neuronowej do klasyfikowania obrazów ubrań, takich jak trampki i koszule. Jest to szybki przegląd kompletnego programu TensorFlow ze szczegółami wyjaśnionymi na bieżąco.

Program wykorzystuje tf.keras , wysokopoziomowy interfejs API do budowania i trenowania modeli w TensorFlow.
Użytą bazą danych jest Fashion MNIST, który zawiera 70 000 obrazów w skali szarości w 10 kategoriach. Zdjęcia przedstawiają poszczególne artykuły odzieżowe w niskiej rozdzielczości (28 na 28 pikseli), jak widać tutaj:

![image](https://user-images.githubusercontent.com/80579076/150420684-5dbda2f0-b765-4163-b71a-975ddf7a796a.png)

Fashion MNIST ma zastąpić klasyczny zbiór danych MNIST — często używany jako „Hello, World” programów uczenia maszynowego do widzenia komputerowego. Zbiór danych MNIST zawiera obrazy odręcznych cyfr (0, 1, 2 itd.) w formacie identycznym z używanymi tutaj artykułami odzieżowymi.

Program wykorzystuje Fashion MNIST dla urozmaicenia i ponieważ jest to nieco trudniejszy problem niż zwykły MNIST. Oba zestawy danych są stosunkowo małe i służą do weryfikacji, czy algorytm działa zgodnie z oczekiwaniami. Są dobrym punktem wyjścia do testowania i debugowania kodu.

W tym przypadku 60 000 obrazów jest używanych do trenowania sieci, a 10 000 obrazów do oceny, jak dokładnie sieć nauczyła się klasyfikować obrazy. Możesz uzyskać dostęp do Fashion MNIST bezpośrednio z TensorFlow.
Załadowanie zestawu danych zwraca cztery tablice NumPy

Obrazy są tablicami 28x28 NumPy, z wartościami pikseli w zakresie od 0 do 255. Etykiety są tablicami liczb całkowitych z zakresu od 0 do 9.
Każdy obraz jest mapowany na pojedynczą etykietę. Ponieważ nazwy klas nie są dołączone do zestawu danych, zapije się je, aby użyć później podczas kreślenia obrazów.

Okazuje się, że dokładność zestawu danych testowych jest nieco mniejsza niż dokładność zestawu danych treningowych. Ta luka między dokładnością treningu a dokładnością testu oznacza przesadne dopasowanie . Overfitting ma miejsce, gdy model uczenia maszynowego działa gorzej na nowych, wcześniej niewidocznych danych wejściowych niż na danych szkoleniowych. Przesadnie dopasowany model „zapamiętuje” szum i szczegóły w uczącym zestawie danych do punktu, w którym negatywnie wpływa na wydajność modelu na nowych danych.

