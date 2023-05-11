
package Practica2;

public class Triangulo {
    //Estado
    private double ladoA, ladoB, ladoC;
    private String linea, relleno;

    //Comportamiento
        //Setters
    public void setLadoA(double ladoA) {
        this.ladoA = ladoA;
    }

    public void setLadoB(double ladoB) {
        this.ladoB = ladoB;
    }

    public void setLadoC(double ladoC) {
        this.ladoC = ladoC;
    }

    public void setRelleno(String relleno) {
        this.relleno = relleno;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

        //Getters
    public double getLadoA() {
        return ladoA;
    }

    public double getLadoB() {
        return ladoB;
    }

    public double getLadoC() {
        return ladoC;
    }

    public String getRelleno() {
        return relleno;
    }

    public String getLinea() {
        return linea;
    }

        //Metodos
    public double calcularArea() {
        double s = (ladoA + ladoB + ladoC)/2;
        return Math.sqrt(s * (s - ladoA) * (s - ladoB) * (s - ladoC));
    }

    public double calcularPerimetro() {
        return ladoA + ladoB + ladoC;
    }

}
