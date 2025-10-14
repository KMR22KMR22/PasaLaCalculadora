import java.util.Scanner;
import java.util.Random;

public class PasaLaCalculadora {
    //Funcion para generar un número aleatorio entre 11 y 98 (incluyendo ambos)
    public static int randomNumber() {
        Random random = new Random();
        int numero = random.nextInt(88) + 11;
        return numero;
    }
    //Funcion para pedirle el nombre a los usuarios
    public static String player(String play) {
        System.out.println("Dame el nombre del " + play + " jugador");
        String player = (new Scanner(System.in)).next();
        return player;
    }
    //Funcion para verificar si los numeros estan en la misma linea y columna
    public static boolean sameLine(int n1, int n2) {
        boolean num1 = n1 == 1 && (n2 == 2 || n2 == 3 || n2 == 4 || n2 == 7);
        boolean num2 = n1 == 2 && (n2 == 1 || n2 == 3 || n2 == 5 || n2 == 8);
        boolean num3 = n1 == 3 && (n2 == 1 || n2 == 2 || n2 == 9 || n2 == 6);
        boolean num4 = n1 == 4 && (n2 == 1 || n2 == 7 || n2 == 5 || n2 == 6);
        boolean num5 = n1 == 5 && (n2 == 4 || n2 == 2 || n2 == 8 || n2 == 6);
        boolean num6 = n1 == 6 && (n2 == 9 || n2 == 3 || n2 == 5 || n2 == 4);
        boolean num7 = n1 == 7 && (n2 == 4 || n2 == 1 || n2 == 8 || n2 == 9);
        boolean num8 = n1 == 8 && (n2 == 9 || n2 == 7 || n2 == 5 || n2 == 2);
        boolean num9 = n1 == 9 && (n2 == 6 || n2 == 3 || n2 == 8 || n2 == 7);

        return  num1 || num2 || num3 || num4 || num5 || num6 || num7 || num8 || num9;

    }
    //Funcion para pedirle el numero al usuario
    public static int askNumber() {
        System.out.println("Dame un numero entre 1 y 9");
        int num1 = (new Scanner(System.in)).nextInt();
        return num1 ;
    }
    //En esta funcion esta todo los que se le pide a los usuarios en cada turno
    public static int turno(int newnumber, int ultnumb, String player) {
        System.out.println("Turno de " + player);
        System.out.println("Ultimo numero introducido: " + newnumber);
        newnumber = askNumber();
        while (newnumber < 1 || newnumber > 9 || newnumber == ultnumb || !sameLine(ultnumb, newnumber)) {
            System.err.println("no es valido");
            System.out.println("Turno de " + player);
            newnumber = askNumber();
        }
        return newnumber;
    }

    public static void main(String[] args) {
        //Variables de los nombres de los jugadores
        String player1 = "1mer";
        String player2 = "2do";
        String player3 = "3er";

        System.out.println("Cuantos jugadores van a jugar:");
        System.out.println("1: Para 2 jugadores");
        System.out.println("2: Para 3 jugadores");
        int players = (new Scanner(System.in)).nextInt();
        //Aqui guardo los nombres de los usuarios en su variable correspondiente
        player1 = player(player1);
        player2 = player(player2);

        if (players == 2){

            player3 = player(player3);
        }

        while (true) {
            System.out.println("Dame un numero mayor que 10 y menor que 99 (dame -1 para un numero aleatorio) para definir el numero maximo");
            int max = (new Scanner(System.in)).nextInt();

            if (max != -1) {
                while (max < 10 || max > 99) {
                    System.err.println("no es valido");
                    System.out.println("Dame un numero mayor que 10 y menor que 99");
                    max = (new Scanner(System.in)).nextInt();
                }
            }
            if (max == -1) {
                max = randomNumber();
            }
            //Variables de los numeros que ingresan los jugadores
            int newnumber = 0;
            int lastnumber = 0;
            int total = 0;

            System.out.println("El numero maximo es: " + max);

            //1mer turno
            System.out.println("Turno de " + player1);
            newnumber = askNumber();

            while (newnumber < 1 || newnumber > 9) {
                System.err.println("no es valido");
                System.out.println("Turno de " + player1);
                newnumber = askNumber();
            }
            total = newnumber;
            lastnumber = newnumber;
            while (true) {

                //Turno del 2do jugador

                newnumber = turno(newnumber, lastnumber, player2);
                lastnumber = newnumber;
                total = total + newnumber;
                if (total >= max) {
                    System.err.println("Pierde: " + player2);
                    break;
                }
                //turno del 3cer jugador

                if (players == 2){
                    newnumber = turno(newnumber, lastnumber, player3);
                    lastnumber = newnumber;
                    total = total + newnumber;
                }
                if (total >= max) {
                    System.err.println("Pierde: " + player3);
                    break;
                }

                //Turno del 1mer jugador
                newnumber = turno(newnumber, lastnumber, player1);
                lastnumber = newnumber;
                total = total + newnumber;
                if (total >= max) {
                    System.err.println("Pierde: " + player1);
                    break;
                }
            }
            System.out.println("Quieres volver a jugar?");
            System.out.println("1: Si");
            System.out.println("2: No");
            int replay = (new Scanner(System.in)).nextInt();
            if(replay == 2){
                break;
            }

        }
    }
}
