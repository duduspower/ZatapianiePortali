import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Portal {
    private String name;
    private int [] rows = new int [7];
    private int [] columns = new int [7];

    public void setName(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public void setPosition(int x, int y, int a) {
        rows[x] = a;
        columns[y] = a;
    }

    public int[] getRows() {
        return rows;
    }

    public int[] getColumns() {
        return columns;
    }

//    public int getRandomNumber(){
//        randomNumber = (int) Math.random() * (maxNumber - minNumber + 1) + minNumber;
//        return randomNumber;
//    }

//    public String setRandomName(){
//        switch (randomNumber){
//            case 0:
//                name = "Wp.pl";
//                break;
//
//            case 1:
//                name = "Onet.pl";
//                break;
//
//            case 2:
//                name = "radiomaryja.pl";
//                break;
//
//            case 3:
//                name = "Interia.pl";
//                break;
//
//            case 4:
//                name = "o2.pl";
//                break;
//
//            case 5:
//                name = "Ceneo.pl";
//                break;
//
//            case 6:
//                name = "Pudelek.pl";
//                break;
//
//            case 7:
//                name = "Wyborcza.pl";
//                break;
//
//            case 8:
//                name = "Tvp.pl";
//                break;
//
//            case 9:
//                name = "Jbzddy.pl";
//                break;
//        }
//        return name;
//    }

}
    class Funkcje{
        private int generatedNumber;
        private int min;
        private int max;
        private int mind;
        private int maxd;
        private int generatedDir;
        int[][] plansza = new int[7][7];


        public void generatePlansza(){
            int x = 0;
        }

        public void setMin(int min){
            this.min = min;
        }

        public int getMin(){
            return min;
        }

        public void setMax(int max){
            this.min = max;
        }

        public int getMax(){
            return max;
        }

        public int getMind() {
            return mind;
        }

        public void setMind(int mind) {
            this.mind = mind;
        }

        public int getMaxd() {
            return maxd;
        }

        public void setMaxd(int maxd) {
            this.maxd = maxd;
        }

        public int generatePos(){
            generatedNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);
            return generatedNumber;
        }

        public int generateDirection(){
            generatedDir = (int) Math.random() * (maxd - mind + 1) + mind;
            return generatedDir;
        }

        public void setPlansza(int x, int y, int val){
            plansza[x][y] = val;
        }
    }

public class ZatapianiePortaliGra {
    public static void main(String[] args){

        ArrayList<Integer> portal1PosX = new ArrayList<>();
        ArrayList<Integer> portal2PosX = new ArrayList<>();
        ArrayList<Integer> portal3PosX = new ArrayList<>();

        ArrayList<Integer> portal1PosY = new ArrayList<>();
        ArrayList<Integer> portal2PosY = new ArrayList<>();
        ArrayList<Integer> portal3PosY = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        Funkcje funkcje = new Funkcje();
        Portal portal1 = new Portal();
        Portal portal2 = new Portal();
        Portal portal3 = new Portal();

        int maxRandom = 7;
        int temp1 = 0;
        int temp2 = 0;
        byte showIndex = 1;
        byte level = 3;
        byte diff;
        boolean bool = false;
        byte x;
        byte y;

        portal1.setName("wp.pl");
        portal2.setName("onet.pl");
        portal3.setName("interia.pl");

        funkcje.setMin(0);
        funkcje.setMax(maxRandom); // to genetate start position of the ship

        temp1 = funkcje.generatePos();
        temp2 = funkcje.generatePos();
        portal1.setPosition(temp1, temp2, showIndex);// generateing start position of ship
        funkcje.setPlansza(temp1, temp2, showIndex);
        portal1PosX.add(temp1);
        portal1PosY.add(temp2);

        temp1 = funkcje.generatePos();
        temp2 = funkcje.generatePos();
        portal2.setPosition(temp1, temp2, showIndex);
        funkcje.setPlansza(temp1, temp2, showIndex);
        portal2PosX.add(temp1);
        portal2PosY.add(temp2);

        temp1 = funkcje.generatePos();
        temp2 = funkcje.generatePos();
        portal3.setPosition(temp1, temp2, showIndex);
        funkcje.setPlansza(temp1, temp2, showIndex);
        portal3PosX.add(temp1);
        portal3PosY.add(temp2);

        temp1 = 0;
        switch (temp1){
            case 0: //dół
                for(int j = 1; j < level; j++) {
                    temp2 = portal1PosX.get(0) + j;
                    if (temp2 < 7) {
                        portal1PosX.add(temp2);
                        funkcje.setPlansza(temp2, portal1PosY.get(0), showIndex);
                    }else{
                        diff = (byte) (temp2 - 7 + 1);
                        portal1PosX.add(portal1PosX.get(0) - diff);
                    }

                    temp2 = portal2PosX.get(0) + j;
                    if (temp2 < 7) {
                        portal2PosX.add(temp2);
                        funkcje.setPlansza(temp2, portal2PosY.get(0), showIndex);
                    }else{
                        diff = (byte) (temp2 - 7 + 1);
                        portal2PosX.add(portal2PosX.get(0) - diff);
                    }

                    temp2 = portal3PosX.get(0) + j;
                    if (temp2 < 7) {
                        portal3PosX.add(temp2);
                        funkcje.setPlansza(temp2, portal3PosY.get(0), showIndex);
                    }else{
                        diff = (byte) (temp2 - 7 + 1);
                        portal3PosX.add(portal3PosX.get(0) - diff);
                    }

                }
                break;
            case 1: //lewo

                break;
            case 2: //gora

                break;
            case 3: //dol

                break;
        }
        int k = 0;
        System.out.print("portal1PosX : ");
        while(k < 3){
            if(k != 2) {
                System.out.print(portal1PosX.get(k) + ",");
            }else{
                System.out.print(portal1PosX.get(k));
            }
            k++;
        }System.out.println();

        k = 0;
        System.out.print("portal2PosX : ");
        while(k < 3){
            if(k != 2) {
                System.out.print(portal2PosX.get(k) + ",");
            }else{
                System.out.print(portal2PosX.get(k));
            }
            k++;
        }System.out.println();

        k = 0;
        System.out.print("portal3PosX : ");
        while(k < 3){
            if(k != 2) {
                System.out.print(portal3PosX.get(k) + ",");
            }else{
                System.out.print(portal3PosX.get(k));
            }
            k++;
        }System.out.println();

        do{
            for(int i = 0; i < 7; i++){
                System.out.println(Arrays.toString(funkcje.plansza[i]));
            }
            System.out.print("Podaj X : ");
            x = in.nextByte();
            System.out.print("Podaj Y : ");
            y = in.nextByte();

//            for(int c = 0; c < 7; c++){
//                for(int v = 0; v < 7; v++) {     // test
//                    funkcje.plansza[c][v] = 0;
//                }
//            }

            if(x < 1){
                x = 1;
            }else if(x > 6){
                x = 6;
            }
            else{
                x--;
            }

            if(y < 1){
                y = 1;
            }else if(y > 6){
                y = 6;
            }
            else {
                y--;
            }

            if(funkcje.plansza[y][x] == 1){
                System.out.println("Trafiony");
                funkcje.plansza[y][x] = 0;
            }else{
                System.out.println("Nie trafiłeś");
            }

            bool = false;
            for(int h = 0; h < 7; h++){
                for(int f = 0; f < 7; f++) {     // sprawdzenie czy są jeszcze jakieś wartości w matrixie
                    if (funkcje.plansza[h][f] == 1){
                        bool = true;
                        break;
                    }
                }
            }

        }while(bool);
        System.out.print("Brawo wygrałeś!!!");
        System.exit(0);
    }
}
