import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

// Klasa abstrakcyjna reprezentująca figurę geometryczną
abstract class Figura {
    // Metoda abstrakcyjna do obliczania pola figury
    abstract double pole();

    // Metoda abstrakcyjna do obliczania obwodu lub pola siatki figury
    abstract double obwod();

    // Metoda abstrakcyjna do obliczania objętości figury
    abstract double objetosc();

    // Metoda do zwracania nazwy figury
    abstract String nazwa();
}

// Klasa reprezentująca prostokąt 2D
class Prostokat2D extends Figura {
    // Pola przechowujące długości boków prostokąta
    private double a;
    private double b;

    // Konstruktor klasy Prostokat2D
    public Prostokat2D(double a, double b) {
        this.a = a;
        this.b = b;
    }

    // Metoda do obliczania pola prostokąta
    @Override
    double pole() {
        return a * b;
    }

    // Metoda do obliczania obwodu prostokąta
    @Override
    double obwod() {
        return 2 * (a + b);
    }

    // Metoda do obliczania objętości prostokąta (zawsze równa zero)
    @Override
    double objetosc() {
        return 0;
    }

    // Metoda do zwracania nazwy figury
    @Override
    String nazwa() {
        return "Prostokąt 2D";
    }
}

// Klasa reprezentująca koło 2D
class Kolo2D extends Figura {
    // Pole przechowujące promień koła
    private double r;

    // Konstruktor klasy Kolo2D
    public Kolo2D(double r) {
        this.r = r;
    }

    // Metoda do obliczania pola koła
    @Override
    double pole() {
        return Math.PI * r * r;
    }

    // Metoda do obliczania obwodu koła
    @Override
    double obwod() {
        return 2 * Math.PI * r;
    }

    // Metoda do obliczania objętości koła (zawsze równa zero)
    @Override
    double objetosc() {
        return 0;
    }

    // Metoda do zwracania nazwy figury
    @Override
    String nazwa() {
        return "Koło 2D";
    }
}

// Klasa reprezentująca trójkąt 2D
class Trojkat2D extends Figura {
    // Pola przechowujące długości boków trójkąta
    private double a;
    private double b;
    private double c;

    // Konstruktor klasy Trojkat2D
    public Trojkat2D(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Metoda do obliczania pola trójkąta
    @Override
    double pole() {
        // Wzór Herona
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    // Metoda do obliczania obwodu trójkąta
    @Override
    double obwod() {
        return a + b + c;
    }

    // Metoda do obliczania objętości trójkąta (zawsze równa zero)
    @Override
    double objetosc() {
        return 0;
    }

    // Metoda do zwracania nazwy figury
    @Override
    String nazwa() {
        return "Trójkąt 2D";
    }
}

// Klasa reprezentująca prostokąt 3D
class Prostokat3D extends Figura {
    // Pola przechowujące długości boków prostokąta
    private double a;
    private double b;
    private double c;

    // Konstruktor klasy Prostokat3D
    public Prostokat3D(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Metoda do obliczania pola prostokąta (zawsze równa zero)
    @Override
    double pole() {
        return 0;
    }

    // Metoda do obliczania pola siatki prostokąta
    @Override
    double obwod() {
        return 2 * (a * b + b * c + a * c);
    }

    // Metoda do obliczania objętości prostokąta
    @Override
    double objetosc() {
        return a * b * c;
    }

    // Metoda do zwracania nazwy figury
    @Override
    String nazwa() {
        return "Prostokąt 3D";
    }
}

// Klasa reprezentująca koło 3D
class Kolo3D extends Figura {
    // Pole przechowujące promień koła
    private double r;

    // Konstruktor klasy Kolo3D
    public Kolo3D(double r) {
        this.r = r;
    }

    // Metoda do obliczania pola koła (zawsze równa zero)
    @Override
    double pole() {
        return 0;
    }

    // Metoda do obliczania pola siatki koła
    @Override
    double obwod() {
        return 4 * Math.PI * r * r;
    }

    // Metoda do obliczania objętości koła
    @Override
    double objetosc() {
        return (4.0 / 3.0) * Math.PI * r * r * r;
    }

    // Metoda do zwracania nazwy figury
    @Override
    String nazwa() {
        return "Koło 3D";
    }
}

// Klasa reprezentująca trójkąt 3D
class Trojkat3D extends Figura {
    // Pola przechowujące długości boków podstawy trójkąta
    private double a;
    private double b;
    private final double c;

    // Pole przechowujące wysokość trójkąta
    private final double h;

    // Konstruktor klasy Trojkat3D
    public Trojkat3D(double a, double b, double c, double h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }

    // Metoda do obliczania pola trójkąta (zawsze równa zero)
    @Override
    double pole() {
        return 0;
    }

    // Metoda do obliczania pola siatki trójkąta
    @Override
    double obwod() {
        // Wzór na pole trójkąta
        double p = (a + b + c) / 2;
        double pole = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        // Wzór na pole siatki trójkąta
        return a * h + 3 * pole;
    }

    // Metoda do obliczania objętości trójkąta
    @Override
    double objetosc() {
        // Wzór na pole trójkąta
        double p = (a + b + c) / 2;
        double pole = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        // Wzór na objętość trójkąta
        return (1.0 / 3.0) * pole * h;
    }

    // Metoda do zwracania nazwy figury
    @Override
    String nazwa() {
        return "Trójkąt 3D";
    }
}

