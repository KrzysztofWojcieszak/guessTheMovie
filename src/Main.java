import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        // ładowanie pliku
        File file = new File("movies_Names");
        Scanner scanner = new Scanner(file);

        //wrzucenie kolejnych linii do tabeli
        int c = 0;
        String[] movieTable = new String[15];
        while (scanner.hasNextLine()) {
            movieTable[c] = scanner.nextLine();
            c++;
        }

        //wylosowanie numeru wiersza tabeli do zgadywania
        double randomNumber = Math.random();
        randomNumber = randomNumber * c;
        int randomInt = (int) randomNumber;
       // System.out.println("haslo to "+movieTable[randomInt]);

        //konwersja tytulu na znaki oraz podanie dlugosci ciagu
        char[] temp = movieTable[randomInt].toCharArray();
        int wordLength = movieTable[randomInt].length();

        //stworzenie tablicy z _ do wyswietlenia, w której będą zgadywane hasla
        char []password = new char[10];
        char []misses = new char[20];
        for (int i = 0; i < wordLength; i++) {
            password[i] = '_';
        }

        int attempt=10; //max ilosc prob
        int letter = wordLength; //licznik liter pozostalych do zgadniecia
        Scanner scanner2 = new Scanner(System.in);

        while ((letter > 0) && (attempt>0)) {
            System.out.println(" Podaj litere:");
            char checkingLetter = scanner2.next().charAt(0);
           // System.out.println("proba "+attempt);
            misses[10-attempt]=checkingLetter;

            for (int j = 0; j < wordLength; j++) {
                if (temp[j] == checkingLetter) {
                    password[j] = checkingLetter;

                    System.out.println(" TRAFIONA LITERA ");
                    letter--;
                    attempt--;
                }
            }
                System.out.println(" Do zgadniecia zostalo/y: " + letter + " liter/y.");


                for (int i = 0; i < wordLength; i++) {
                    System.out.print(password[i]);

                }

            System.out.println();
            System.out.println("Wykorzystales juz nastepujace litery");
                for (int i = 0; i < wordLength; i++) {
                System.out.print(misses[i]+" ");

            }
                System.out.println();


        }

            //warunek przegranej
            if (letter > 0 && attempt<1){
                System.out.println(" Przegrales. Haslem był film : ");
                System.out.println();
                for (int i = 0; i < wordLength; i++) {
                    System.out.print(temp[i]);
                }
            }

            //warunek wygranej
	else if (letter < 1 && attempt>0){
                System.out.println(" wygrales ");
            }




    }
}

