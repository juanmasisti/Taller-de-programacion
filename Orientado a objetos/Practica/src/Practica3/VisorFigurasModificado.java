package Practica3;
public class VisorFigurasModificado {
    //Estado
    private int guardadas;
    private Figura [] vector;
   
    //Comportamiento
    public VisorFigurasModificado() {
        guardadas = 0;
        vector = new Figura[5];
    }
   
    public void guardar(Figura f){
        vector[guardadas] = f;
        guardadas++;
    }

    public boolean quedaEspacio() {
        return (guardadas < 5);
    }
       
    public void mostrar(){
        for (int i = 0; i < guardadas; i++) 
            System.out.println(vector[i].toString());
    }

    public int getGuardadas() {
        return guardadas;
    }
}