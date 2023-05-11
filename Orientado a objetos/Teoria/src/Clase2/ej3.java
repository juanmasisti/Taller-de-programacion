package clase2;
import PaqueteLectura.Lector;
public class ej3 {
    public static void main(String[] args) {
        Estacionamiento estac;
        String dueño;
        int i, patente, piso, plaza;
        estac = new Estacionamiento("ABC", "12 e/ 45 y 46", "6:00", "22:00", 3, 3);
        for (i = 0; i < 6; i++) {
            System.out.println("-------Nuevo Auto-------");
            System.out.println("Ingresar la patente del auto: ");
            patente = Lector.leerInt();
            System.out.println("Ingresar el dueño del auto: ");
            dueño = Lector.leerString();
            System.out.println("Ingresar el piso del auto: ");
            piso = Lector.leerInt();
            System.out.println("Ingresar la plaza del auto: ");
            plaza = Lector.leerInt();
            estac.registrarAuto(new Auto(dueño, patente), piso, plaza);
        }
        System.out.println(estac.toString());
        System.out.println("Ingresar la patente del auto a buscar: ");
        System.out.println(estac.buscarAuto(Lector.leerInt()));
    }
}