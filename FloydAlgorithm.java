package com.mycompany.floydalgorithm;
import static java.lang.String.format;
import java.util.Scanner;

public class FloydAlgorithm {
    
    public FloydAlgorithm(){
        
    }//Class'ın boş constructoru
    
    public FloydAlgorithm(int [][]d0, int [][] s0,int node){
        
        for (int i = 0; i < node; i++) {                                        //d0 matrisi main metodunda oluştuğu için bu constructorda  
            for (int j = 0; j < node; j++) {                                    //s0 matrisinin başlangıç değeri oluşturulur
                if (i==j) {
                    s0[i][j]=0;
                }
                else{
                    s0[i][j]=j+1;
                }
            }
        }

         printMatrix(d0, s0, node);                                             //ilk başta girilen d0 ve oluşan s0 matrisinin doğruluğunu teyit etmek için
                                                                                //her iki matris de parametrelere girilerek yazdırma metodu çalıştırılır ve consolede ilk basılandır.
                                                                                
         solution(d0, s0, node);                                                //verilen matrislere göre algoritmanın/förmülün uygulandığı metod çağırılır. Bu metod sonucu
                                                                                //d0 ve s0 matrisleri son değerlerini alır.
                                                                                //(kağıt üzerinde uygulandığında son adımı oluşturur ara adımları göstermez)
                                                                                
         printMatrix(d0, s0, node);                                             //işlemler sonucu oluşan d0 ve s0 matrisinin doğruluğu için tekrar yazdırma işlemi
         
         printPath(d0, s0,node);                                                //oluşan matrisler sonucu en kısa yolu bulmak için çağırılan metoddur.
    }
    public void printPath(int[][]d0, int [][]s0,int nodenumber){                //en sonda oluşan matrise göre hangi nodeden hangi nodeye en kısa şekilde
         System.out.println("pair     distance    path");                       //hangi yolları takip edileceğini gösterir
        for (int i = 0; i < nodenumber; i++) {
            for (int j = 0; j < nodenumber; j++) {
                if (i != j) {
                    int startNode = i + 1;
                    int destinationNode = j + 1;
                    String path = format("%d --- %d    %2d     %s",startNode , destinationNode,
                            (int) d0[i][j], startNode);
                    do {
                        startNode = s0[startNode - 1][destinationNode - 1];
                        path += " --- " + startNode;
                    } while (startNode != destinationNode);
                    System.out.println(path);
                }
            }
        }
        
    }  //destination method
    public void solution(int [][]d0, int[][]s0, int nodenumber){                //d0 ve s0 matrislerini uzunluklar toplamının küçük olup olmamasına göre düzenler
        for (int pivot = 0; pivot < nodenumber; pivot++) {
            for (int i = 0; i < nodenumber; i++) {
                for (int j = 0; j < nodenumber; j++) {
                    if (pivot==i && pivot==j) {
                        continue;
                    }
                    if (d0[i][pivot]+d0[pivot][j] < d0[i][j]){
                        d0[i][j] = d0[i][pivot]+d0[pivot][j];
                        s0[i][j]=pivot+1;                        
                    }                    
                }
            }
        }
    }  //prepare s0 and d0 matrix for destination
    
    public void printMatrix(int [][]d0,int[][]s0,int nodenumber){               //when need to print for d0 and s0 matrix this method will do 
        System.out.println("Matrix D0:");
        for (int i = 0; i < nodenumber; i++) {
            for (int j = 0; j < nodenumber; j++) {
                System.out.print(d0[i][j]+",");                                 //parametrede girilen matrisleri yazdıran metod
            }
            System.out.println("");
        }
        System.out.println("Matrix S0:");
        for (int i = 0; i < nodenumber; i++) {
            for (int j = 0; j < nodenumber; j++) {
                System.out.print(s0[i][j]+",");
            }
            System.out.println("");
        }
    } //print for d0 and s0 matrix
    
    public static void main(String[] args) {
        int numberofNode=9;
        int[][] d0 = new int[9][9];                                             // İki boyutlu 'D' matrisini tutan dizi.
        int[][] s0 = new int[9][9];                                             // İki boyutlu 'S' matrisini tutan dizi.
        
        
//        System.out.println("Enter of the number of node");                    //Bu kodlar, kullanıcı isterse verilen ödev haricinde
//        Scanner data = new Scanner(System.in);                                //farklı uzunluktaki matrisi girmek için            (93.satırdan 111'e kadar)
//        numberofNode = data.nextInt();                                        //yeni matrisin uzunluğunu ve içeriğini girmesini sağlar
//        
//        s0 = new int [numberofNode][numberofNode];
//        d0 = new int [numberofNode][numberofNode];
//        
//        System.out.println("Enter the matrix");        
//        for (int i = 0; i < numberofNode; i++) {
//            for (int j = 0; j < numberofNode; j++) {
//                if (i==j) {
//                    s0[i][j]=0;
//                    continue;
//                }
//                System.out.println("row"+(i+1)+" column"+(j+1));
//                d0[i][j] = data.nextInt();
//                s0[i][j]=j+1;
//            }
//        }
        

            d0[0][0] = 0;                                                     //Verilen ödevde 9x9 luk matrisin değerlerinin girilmiş hali
            d0[0][1] = 4;                                                     //kağıt üzerindeki "sonsuz" değeri yerine 9999, "-" yerine 0 kullanılmıştır
            d0[0][2] = 9999;
            d0[0][3] = 5;
            d0[0][4] = 9999;
            d0[0][5] = 9999;
            d0[0][6] = 2;
            d0[0][7] = 9999;
            d0[0][8] = 9999;
            d0[1][0] = 4;
            d0[1][1] = 0;
            d0[1][2] = 9999;
            d0[1][3] = 9999;
            d0[1][4] = 9999;
            d0[1][5] = 3;
            d0[1][6] = 1;
            d0[1][7] = 5;
            d0[1][8] = 9999;
            d0[2][0] = 9999;
            d0[2][1] = 9999;
            d0[2][2] = 0;
            d0[2][3] = 2;
            d0[2][4] = 1;
            d0[2][5] = 3;
            d0[2][6] = 9999;
            d0[2][7] = 9999;
            d0[2][8] = 3;
            d0[3][0] = 5;
            d0[3][1] = 9999;
            d0[3][2] = 2;
            d0[3][3] = 0;
            d0[3][4] = 9999;
            d0[3][5] = 2;
            d0[3][6] = 1;
            d0[3][7] = 9999;
            d0[3][8] = 9999;
            d0[4][0] = 9999;
            d0[4][1] = 9999;
            d0[4][2] = 1;
            d0[4][3] = 9999;
            d0[4][4] = 0;
            d0[4][5] = 9999;
            d0[4][6] = 9999;
            d0[4][7] = 1;
            d0[4][8] = 2;
            d0[5][0] = 9999;
            d0[5][1] = 3;
            d0[5][2] = 3;
            d0[5][3] = 2;
            d0[5][4] = 9999;
            d0[5][5] = 0;
            d0[5][6] = 9999;
            d0[5][7] = 2;
            d0[5][8] = 9999;
            d0[6][0] = 2;
            d0[6][1] = 1;
            d0[6][2] = 9999;
            d0[6][3] = 1;
            d0[6][4] = 9999;
            d0[6][5] = 9999;
            d0[6][6] = 0;
            d0[6][7] = 9999;
            d0[6][8] = 9999;
            d0[7][0] = 9999;
            d0[7][1] = 5;
            d0[7][2] = 9999;
            d0[7][3] = 9999;
            d0[7][4] = 1;
            d0[7][5] = 2;
            d0[7][6] = 9999;
            d0[7][7] = 0;
            d0[7][8] = 1;
            d0[8][0] = 9999;
            d0[8][1] = 9999;
            d0[8][2] = 3;
            d0[8][3] = 9999;
            d0[8][4] = 2;
            d0[8][5] = 9999;
            d0[8][6] = 9999;
            d0[8][7] = 1;
            d0[8][8] = 0; 
        new FloydAlgorithm(d0, s0, numberofNode);                               //Nesnemizi d0 s0 ve node sayısı 
                                                                                //parametreleri ile oluşturulur.
    }                                                                           
}
