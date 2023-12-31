package day16_iterator_collections;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class C10_Set {

    public static void main(String[] args) {

        // verilen bir array'den tekrar eden sayilari silip
        // array'i unique elementlerden olusan bir hale getirin
        // bunu 3 farkli method olusturarak
        // 1. method'da sadece array kullanarak yapin
        // 2. method'da ekstra bir list kullanarak yapin (ODEV)
        // 3. method'da ekstra bir set kullanarak yapin

        int[] arr = {2,4,3,5,6,4,3,2,1,2,1,2,3,4,3,2,5,6,5,4,3,7,9};
        // arr = arrayIleTekrarsizYap(arr);

        arr = setIleTekrarsizYap(arr);

        System.out.println(Arrays.toString(arr));

    }


    public static int[] arrayIleTekrarsizYap(int[] arr){

        // oncelikle array'den kac tane eleman silinecek
        // ve tekrar etmeyen kac tane element var bulmam gerek

        Arrays.sort(arr); // [1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6]

        int tekrarsizSayiSayaci = 1 ;
        for (int i = 0; i < arr.length-1 ; i++) {
            if (arr[i] != arr[i+1]){
                tekrarsizSayiSayaci++;
            }
        }

        int[] benzersizArray = new int[tekrarsizSayiSayaci];
        int index=0;
        benzersizArray[0] = arr[0];
        for (int i = 1; i < arr.length ; i++) {

            if (arr[i] != benzersizArray[index]){
                index++;
                benzersizArray[index] = arr[i];
            }

        }


        return benzersizArray;
    }

    public static int[] setIleTekrarsizYap(int[] arr){
        // once array'deki tum elementleri Set'e atip
        // tekrarlardan kurtulduk

        Set<Integer> tekrarsizSet = new TreeSet<>();

        for (Integer each: arr
             ) {

            tekrarsizSet.add(each);
        }

        // tekrarsiz hale gelen set'in size'ina uygun bir array olusturup
        // set index kullanmadigindan
        // for-each loop yardimi ile set'deki elementleri arr[] ye atadik
        arr = new int[tekrarsizSet.size()];

        int index=0;

        for (Integer each: tekrarsizSet
             ) {

            arr[index] = each;
            index++;
        }


        return arr;

    }



}
