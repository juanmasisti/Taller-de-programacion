package Practica3;
public class mainVisorFigurasModificado {
    public static void main(String[] args) {
        VisorFigurasModificado visor = new VisorFigurasModificado();
        Cuadrado c1 = new Cuadrado(10, "Violeta", "Rosa");
        Cuadrado c2= new Cuadrado(30, "Rojo", "Naranja");
        Rectangulo r= new Rectangulo(20, 10, "Azul", "Celeste");
        visor.guardar(c1);
        visor.guardar(c2);
        visor.guardar(r);
        visor.mostrar();
    }
}