//import java.lang.Math;

public class Walec {
    private double promienPodstawy;
    private double wysokosc;

    public Walec(double pp, double wys){
        promienPodstawy = pp;
        wysokosc = wys;
    }

    public Walec(){

    }

    public void ustawPromienPodstawy(double pp) {
        promienPodstawy = pp;
    }

    public void ustawWysokosc(double wys) {
        wysokosc = wys;
    }

    public double zwrocPromienPodstawy(){
        return promienPodstawy;
    }

    public double zwrocWysokosc(){
        return wysokosc;
    }

    public double obliczPolePowierzchniPodstawy(){
        return Math.PI * Math.pow(promienPodstawy, 2);
    }

    public double obliczPolePowierzchniBocznej(){
        return 2 * Math.PI * promienPodstawy * wysokosc;
    }

    public double obliczPolePowierzchniCalkowitej(){
        double polePodstawy = obliczPolePowierzchniPodstawy();
        double poleBoczne = obliczPolePowierzchniBocznej();
        return 2 * polePodstawy + poleBoczne;

    }

    public double obliczObjetosc(){
        double polePodstawy = obliczPolePowierzchniPodstawy();
        return polePodstawy * wysokosc;
    }

}
