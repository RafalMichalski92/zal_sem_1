import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// Klasa główna programu
public class Program {
    private Program() {
    }

    // Metoda główna programu
    public static void main(String[] args) {
        // Tworzymy listę przechowującą obiekty klasy Figura
        ArrayList<Figura> figury = new ArrayList<>();

        // Tworzymy zmienną do przechowywania wyboru użytkownika
        int wybor = 0;

        // Tworzymy pętlę do wyświetlania menu i obsługi wyboru użytkownika
        do {
            // Wyświetlamy menu z opcjami do wyboru
            String[] opcje = {"Prostokąt 2D", "Koło 2D", "Trójkąt 2D", "Prostokąt 3D", "Koło 3D", "Trójkąt 3D", "Odczyt danych", "Zakończ"};
            wybor = JOptionPane.showOptionDialog(null, "Wybierz figurę lub opcję:", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcje, opcje[0]);

            // Obsługujemy wybór użytkownika w zależności od wartości zmiennej wybor
            switch (wybor) {
                case 0: // Prostokąt 2D
                    // Pobieramy długości boków prostokąta od użytkownika
                    double a = Double.parseDouble(JOptionPane.showInputDialog("Podaj długość boku a:"));
                    double b = Double.parseDouble(JOptionPane.showInputDialog("Podaj długość boku b:"));

                    // Tworzymy obiekt klasy Prostokat2D i dodajemy go do listy figury
                    figury.add(new Prostokat2D(a, b));

                    // Wyświetlamy informację o utworzeniu figury
                    JOptionPane.showMessageDialog(null, "Utworzono prostokąt 2D o bokach " + a + " i " + b + ".");
                    break;
                case 1: // Koło 2D
                    // Pobieramy promień koła od użytkownika
                    double r = Double.parseDouble(JOptionPane.showInputDialog("Podaj promień koła:"));

                    // Tworzymy obiekt klasy Kolo2D i dodajemy go do listy figury
                    figury.add(new Kolo2D(r));

                    // Wyświetlamy informację o utworzeniu figury
                    JOptionPane.showMessageDialog(null, "Utworzono koło 2D o promieniu " + r + ".");
                    break;
                case 2: // Trójkąt 2D
                    // Pobieramy długości boków trójkąta od użytkownika
                    a = Double.parseDouble(JOptionPane.showInputDialog("Podaj długość boku a:"));
                    b = Double.parseDouble(JOptionPane.showInputDialog("Podaj długość boku b:"));
                    double c = Double.parseDouble(JOptionPane.showInputDialog("Podaj długość boku c:"));

                    // Tworzymy obiekt klasy Trojkat2D i dodajemy go do listy figury
                    figury.add(new Trojkat2D(a, b, c));

                    // Wyświetlamy informację o utworzeniu figury
                    JOptionPane.showMessageDialog(null, "Utworzono trójkąt 2D o bokach " + a + ", " + b + " i " + c + ".");
                    break;
                case 3: // Prostokąt 3D
                    // Pobieramy długości boków prostokąta od użytkownika
                    a = Double.parseDouble(JOptionPane.showInputDialog("Podaj długość boku a:"));
                    b = Double.parseDouble(JOptionPane.showInputDialog("Podaj długość boku b:"));
                    c = Double.parseDouble(JOptionPane.showInputDialog("Podaj długość boku c:"));

                    // Tworzymy obiekt klasy Prostokat3D i dodajemy go do listy figury
                    figury.add(new Prostokat3D(a, b, c));

                    // Wyświetlamy informację o utworzeniu figury
                    JOptionPane.showMessageDialog(null, "Utworzono prostokąt 3D o bokach " + a + ", " + b + " i " + c + ".");
                    break;
                case 4: // Koło 3D
                    // Pobieramy promień koła od użytkownika
                    r = Double.parseDouble(JOptionPane.showInputDialog("Podaj promień koła:"));

                    // Tworzymy obiekt klasy Kolo3D i dodajemy go do listy figury
                    figury.add(new Kolo3D(r));

                    // Wyświetlamy informację o utworzeniu figury
                    JOptionPane.showMessageDialog(null, "Utworzono koło 3D o promieniu " + r + ".");
                    break;
                case 5: // Trójkąt 3D
                    // Pobieramy długości boków podstawy i wysokość trójkąta od użytkownika
                    a = Double.parseDouble(JOptionPane.showInputDialog("Podaj długość boku a:"));
                    b = Double.parseDouble(JOptionPane.showInputDialog("Podaj długość boku b:"));
                    c = Double.parseDouble(JOptionPane.showInputDialog("Podaj długość boku c:"));
                    double h = Double.parseDouble(JOptionPane.showInputDialog("Podaj wysokość trójkąta:"));

                    // Tworzymy obiekt klasy Trojkat3D i dodajemy go do listy figury
                    figury.add(new Trojkat3D(a, b, c, h));

                    // Wyświetlamy informację o utworzeniu figury
                    JOptionPane.showMessageDialog(null, "Utworzono trójkąt 3D o bokach podstawy " + a + ", " + b + " i " + c + " i wysokości " + h + ".");
                    break;
                case 6: // Odczyt danych
                    // Sprawdzamy, czy lista figury jest pusta
                    if (figury.isEmpty()) {
                        // Jeśli tak, to wyświetlamy komunikat o braku figur
                        JOptionPane.showMessageDialog(null, "Nie utworzono żadnej figury.");
                    } else {
                        // Jeśli nie, to tworzymy zmienną do przechowywania danych o figurach
                        StringBuilder dane = new StringBuilder();

                        // Przechodzimy po wszystkich figurach z listy i dodajemy ich dane do zmiennej dane
                        for (Figura f : figury) {
                            // Dodajemy nazwę figury
                            dane.append(f.nazwa()).append("\n");

                            // Dodajemy pole, obwód lub pole siatki i objętość figury
                            dane.append("Pole: ").append(f.pole()).append("\n");
                            dane.append("Obwód lub pole siatki: ").append(f.obwod()).append("\n");
                            dane.append("Objętość: ").append(f.objetosc()).append("\n");

                            // Dodajemy pustą linię
                            dane.append("\n");
                        }

                        // Wyświetlamy dane o figurach
                        JOptionPane.showMessageDialog(null, dane.toString());
                    }
                    break;
                case 7: // Zakończ
                    // Wyświetlamy komunikat o zakończeniu programu
                    JOptionPane.showMessageDialog(null, "Zakończono program.");
                    break;
                default: // Nieprawidłowy wybór
                    // Wyświetlamy komunikat o błędnym wyborze
                    JOptionPane.showMessageDialog(null, "Nieprawidłowy wybór. Spróbuj ponownie.");
                    break;
            }
        } while (wybor != 7); // Powtarzamy pętlę, dopóki użytkownik nie wybierze opcji Zakończ

        // Tworzymy obiekt klasy File do reprezentowania pliku figury.txt
        File plik = new File("figury.txt");

        // Tworzymy obiekt klasy FileWriter do zapisywania danych do pliku
        try {
            FileWriter pisarz = new FileWriter(plik);

            // Przechodzimy po wszystkich figurach z listy i zapisujemy ich dane do pliku
            for (Figura f : figury) {
                // Zapisujemy nazwę figury
                pisarz.write(f.nazwa() + "\n");

                // Zapisujemy pole, obwód lub pole siatki i objętość figury
                pisarz.write("Pole: " + f.pole() + "\n");
                pisarz.write("Obwód lub pole siatki: " + f.obwod() + "\n");
                pisarz.write("Objętość: " + f.objetosc() + "\n");
                // Zapisujemy objętość figury
                pisarz.write("Objętość: " + f.objetosc() + "\n");

                // Zapisujemy pustą linię
                pisarz.write("\n");
            }

            // Zamykamy obiekt pisarz
            pisarz.close();

            // Wyświetlamy komunikat o zapisaniu danych do pliku
            JOptionPane.showMessageDialog(null, "Zapisano dane do pliku figury.txt.");
        } catch (IOException e) {
            // Obsługujemy wyjątek związany z błędem wejścia/wyjścia
            e.printStackTrace();

            // Wyświetlamy komunikat o błędzie zapisu do pliku
            JOptionPane.showMessageDialog(null, "Błąd zapisu do pliku figury.txt.");
        }
    }

    public static Program createProgram() {
        return new Program();
    }
}
