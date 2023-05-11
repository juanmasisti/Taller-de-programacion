package clase2;
public class Estacionamiento {
    // Estado interno
    private String nombre;
    private String direccion;
    private String horaA;
    private String horaC;
    private int pisos;
    private int plazas;
    private Auto [][] autos;

    // Constructor
    public Estacionamiento() {};

    public Estacionamiento(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        horaA = "8:00";
        horaC = "21:00";
        pisos = 5;
        plazas = 10;
        autos = new Auto[pisos][plazas];
        this.inicializarMatriz();
    }

    public Estacionamiento(String nombre, String direccion, String horaA, String horaC, int pisos, int plazas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaA = horaA;
        this.horaC = horaC;
        this.pisos = pisos;
        this.plazas = plazas;
        autos = new Auto[pisos][plazas];
        this.inicializarMatriz();
    }

    // Comportamiento

        //Sets
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setHoraA(String horaA) {
        this.horaA = horaA;
    }

    public void setHoraC(String horaC) {
        this.horaC = horaC;
    }

    public void setPisos(int pisos) {
        this.pisos = pisos;
    }

    public void setPlaza(int plazas) {
        this.plazas = plazas;
    }

        //Gets
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getHoraA() {
        return horaA;
    }

    public String getHoraC() {
        return horaC;
    }

    public int getPisos() {
        return pisos;
    }

    public int getPlaza() {
        return plazas;
    }
    
        //Metodos
    public void registrarAuto(Auto auto, int piso, int plaza) {
        autos[piso][plaza] = auto;
    }

    public String buscarAuto(int patente) {
        boolean esta = false;
        int i = 0, j = 0;
        while (!esta && i < pisos) {
            j = 0;
            while (!esta && j < plazas) {
                if (autos[i][j] != null && autos[i][j].getPatente() ==  patente) 
                    esta = true;
                else
                    j++;
            }
            i++;
        }
        if (esta) {
            return "El Auto se encuentra en el piso " + (i-1) + " y la plaza " + j;
        }
        else {
            return "Auto inexistente";
        }
    }

    private void inicializarMatriz() {
        for (int i = 0; i < pisos; i++) 
            for (int j = 0; j < plazas; j++) 
                autos[i][j] = null;
    }

    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < pisos; i++) 
            for (int j = 0; j < plazas; j++)
                if (autos[i][j] == null) 
                    aux = aux + "Piso " + i + " Plaza " + j + ": Libre" + "\n";
                else 
                    aux = aux + "Piso " + i + " Plaza " + j + ": " + autos[i][j].toString() + "\n";
        return aux;
    }
}