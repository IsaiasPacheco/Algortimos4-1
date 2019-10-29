import java.util.Comparator;

public class Comparador implements Comparator<Nodo>{
    public int compare( Nodo x, Nodo y){
        if( x.frecuencia == y.frecuencia ){
            return 0;
        }else if( x.frecuencia > y.frecuencia ) {
            return 1;
        }else{
            return -1;
        }
    }
}