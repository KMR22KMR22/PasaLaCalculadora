import java.util.Scanner;
import java.util.Random;

public class PasaLaCalculadora {

    public static int randomNumber() {
        Random random = new Random();

        // Generar un número aleatorio entre 11 y 98 (incluyendo ambos)
        int numero = random.nextInt(88) + 11;
        return numero;
    }

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

    public static int askNumber() {
        System.out.println("Dame un numero entre 1 y 9");
        int num1 = (new Scanner(System.in)).nextInt();
        return num1 ;
    }


    public static void main(String[] args) {

        String player3 = "";

        System.out.println("Cuantos jugadores: dame un 2 si son 2 y un 3 si son 3");
        int players = (new Scanner(System.in)).nextInt();

        System.out.println("Dame el nombre del 1mer jugador:");
        String player1 = (new Scanner(System.in)).next();

        System.out.println("Dame el nombre del 2do jugador:");
        String player2 = (new Scanner(System.in)).next();

        if (players == 3){

            System.out.println("Dame el nombre del 3cer jugador:");
            player3 = (new Scanner(System.in)).next();
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
            //Variables
            int num1;
            int num2;
            int num3;
            int total = 0;
            int ultnumb = 0;

            System.out.println("El numero maximo es: " + max);

            //1mer turno
            System.out.println("Turno de " + player1);
            num1 = askNumber();

            while (num1 < 1 || num1 > 9) {
                System.err.println("no es valido");
                System.out.println("Turno de " + player1);
                num1 = askNumber();
            }
            total = num1;
            ultnumb = num1;
            while (true) {

                //Turno del 2do jugador

                System.out.println("Turno de " + player2);
                num2 = askNumber();

                while (num2 < 1 || num2 > 9 || num2 == ultnumb || !sameLine(ultnumb, num2)) {
                    System.err.println("no es valido");
                    System.out.println("Turno de " + player2);
                    num2 = askNumber();
                }
                ultnumb = num2;
                total = total + num2;
                if (total >= max) {
                    System.err.println("Pierde: " + player2);
                    break;
                }
                //turno del 3cer jugador

                if (players == 3){
                    System.out.println("Turno de " + player3);
                    num3 = askNumber();

                    while (num2 < 1 || num2 > 9 || num3 == ultnumb || !sameLine(ultnumb, num3)) {
                        System.err.println("no es valido");
                        System.out.println("Turno de " + player3);
                        num3 = askNumber();
                    }
                    ultnumb = num3;
                    total = total + num3;
                }
                if (total >= max) {
                    System.err.println("Pierde: " + player3);
                    break;
                }

                //Turno del 1mer jugador
                System.out.println("Turno de " + player1);
                num1 = askNumber();

                while (num2 < 1 || num2 > 9 || num1 == ultnumb || !sameLine(ultnumb, num1)) {
                    System.err.println("no es valido");
                    System.out.println("Turno de " + player1);
                    num1 = askNumber();
                }
                ultnumb = num1;
                total = total + num1;
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
