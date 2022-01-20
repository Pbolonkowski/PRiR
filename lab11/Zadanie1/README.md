Znajdź i opisz/przetestuj/może rozwiń inne ciekawe zastosowanie biblioteki pyTorch/Tensorflow (można wykorzystać dostępne kody z Internetu)

Zadanie 1. 

Zastosowanie biblioteki pyTorch do transformacji obrazu.

Transfer stylu neuronowego to sztuczny system oparty na głębokiej sieci neuronowej do generowania obrazów artystycznych. To podejście wykorzystuje dwa losowe obrazy, treść i obraz stylu. Wyodrębnia cechy strukturalne z obrazu treści oraz cechy stylu z obrazu stylu.

Splotowa sieć neuronowa tworzy reprezentacje obrazu wzdłuż hierarchii przetwarzania. Gdy wejdziemy głębiej w sieć, reprezentacje będą bardziej dbać o cechy strukturalne lub rzeczywistą zawartość niż o szczegółowe dane pikseli. Aby uzyskać te reprezentacje, możemy zrekonstruować obrazy za pomocą map cech tej warstwy. Rekonstrukcja z dolnej warstwy odtworzy dokładny obraz. W przeciwieństwie do tego, rekonstrukcja wyższej warstwy przechwyci zawartość wysokiego poziomu, a zatem odpowiedzi na cechy z wyższej warstwy będziemy nazywać reprezentacją zawartości.

![image](https://user-images.githubusercontent.com/80579076/150417035-5be2a551-0787-4ca9-bb87-d22497fe0495.png)

Powyższy rysunek przedstawia rekonstrukcję obrazu wejściowego z warstw „conw1_1”, „conw2_1”, „conw3_1”, „conw4_1” i „conw5_1”. Odkrywamy, że rekonstrukcja z niższych warstw jest prawie taka sama jak na obrazie wejściowym, ale gdy wchodzimy głębiej w sieć, szczegółowe informacje o pikselach są tracone. W przeciwieństwie do tego, zawartość obrazu na wysokim poziomie zostaje zachowana.

Reprezentacja stylu

Aby wyodrębnić reprezentację zawartości stylu, budujemy przestrzeń funkcji na górze odpowiedzi filtra w każdej warstwie sieci. Składa się z korelacji między różnymi odpowiedziami filtrów w zakresie przestrzennym map cech. Korelacja filtrów różnych warstw przechwytuje informacje o teksturze obrazu wejściowego. Tworzy to obrazy, które pasują do stylu danego obrazu na coraz większą skalę, jednocześnie odrzucając informacje o globalnym układzie. Ta wieloskalowa reprezentacja nazywana jest reprezentacją stylu.

![image](https://user-images.githubusercontent.com/80579076/150417260-3df3d685-0b5e-4eed-b3fe-54de79a4dbf4.png)

Powyższy rysunek przedstawia przestrzeń cech nad każdą warstwą splotową, przedstawiającą korelację między różnymi cechami w różnych warstwach CNN. Gdy wchodzimy głębiej w sieć, widzimy, że układ globalny lub cechy strukturalne są odrzucane.

Architektura modelu

![image](https://user-images.githubusercontent.com/80579076/150417545-1f48ca5e-a04a-4d8c-b912-06b083a4973a.png)

Tutaj używamy konwolucyjnej sieci neuronowej sieci VGG19 wytrenowanej wcześniej i wykonujemy rekonstrukcje treści i stylu. Splątując informacje strukturalne z reprezentacji treści oraz informacje o teksturze/stylu z reprezentacji stylu, generujemy obraz artystyczny. Możemy położyć nacisk na odtworzenie stylu lub treści. Silny nacisk na styl zaowocuje obrazami, które będą pasować do wyglądu grafiki, skutecznie nadając jej teksturowaną wersję, ale prawie nie pokazują żadnej zawartości fotografii. Kładąc duży nacisk na treść, można zidentyfikować fotografię, ale styl malowania nie jest tak dobrze dopasowany. Wykonujemy schodzenie gradientowe na wygenerowanym obrazie, aby znaleźć inny obraz, który pasuje do odpowiedzi funkcji oryginalnego obrazu.

źródło: https://github.com/Octaves0911/Neural_Style_Transfer/blob/master/NST.py
