import java.util.Random;
import java.util.Scanner;

public class SayisalLoto {

    /*
Proje2: Sayısal Loto Uygulaması
        bilet için rastgele n tane sayı üretilsin.
        loto sonucu rastgele n tane sayı ile üretilsin.
        sayısal lotoda tekrarlı sayılar olmamalı.

        n(hane sayısı), sayılar için min ve max değerler
        kullanıcıdan alınsın.

        sonuç ve bilet karşılaştırılsın, kaç eşleşme olduğu
        kullanıcıya bildirilsin.

    */

    public static void main(String[] args) {

        startLoto();
    }

    public static void startLoto(){Scanner inp = new Scanner(System.in);

        System.out.println("Sayisal loto icin hane sayisini giriniz: ");
        int slots = inp.nextInt();

        System.out.println("Sayilar icin min deger giriniz: ");
        int min = inp.nextInt();

        System.out.println("Sayilar icin max deger giriniz: ");
        int max = inp.nextInt();

        int[] lotoArr = new int[slots];
        int[] ticketArr = new int[slots];

        int randomNumber1 = 0;
        int randomNumber2 = 0;

        Random random = new Random();

        boolean isRepeated;

        for (int i = 0; i < slots; i++) {
            do {
                isRepeated = false;
                randomNumber1 = random.nextInt(max + 1 - min) + min; // 0 ile deger arasinda rastgele sayi, deger dahil degil
                for (int j = 0; j < i; j++) {
                    if (lotoArr[i] == randomNumber1){
                        isRepeated = true;
                        break;
                    }
                }
            } while (isRepeated);
            lotoArr[i] = randomNumber1;

            do {
                isRepeated = false;
                randomNumber2 = random.nextInt(max + 1 - min) + min; // 0 ile deger arasinda rastgele sayi, deger dahil degil
                for (int j = 0; j < i; j++) {
                    if (lotoArr[i] == randomNumber2){
                        isRepeated = true;
                        break;
                    }
                }
            } while (isRepeated);
            lotoArr[i] = randomNumber2;
        }
        System.out.println("Benim biletim: ");
        for (int i = 0; i < ticketArr.length; i++) {
            System.out.println(ticketArr[i] + " ");
        }

        System.out.println();

        System.out.println("Loto sonucu: ");
        for (int i = 0; i < lotoArr.length; i++) {
            System.out.println(lotoArr[i] + " ");
        }

        System.out.println();
        int result = compareArr(lotoArr,ticketArr);
        if (result > 0){
            System.out.println("Tebrikler ! " + result + " tane eslesme var");
        } else System.out.println("Maalesef eslesme yok");
    }

    public static int compareArr(int[] arr, int [] brr){
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < brr.length; j++) {
                if (arr[i] == brr[j]){
                    counter++;
                }
            }
        }
        return  counter;
    }

}
