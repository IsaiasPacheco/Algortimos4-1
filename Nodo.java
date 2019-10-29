public class Nodo{

    float frecuencia;
    char caracter;

    Nodo izquierda;
    Nodo derecha;

    public Nodo( char caracter, float frecuencia ){
        this.caracter = caracter;
        this.frecuencia = frecuencia;
    }

    public Nodo(){

    }

    @Override
    public String toString(){
        return "[ caracter: " + caracter + "," + " frec: " + frecuencia +" ]"; 
    }

}