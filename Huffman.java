
public class Huffman{

    //S es la cadena donde se escribe el código
    public void codigo(Nodo raiz, String s)  { 
        //case base donde el nodo es una hoja
        if (raiz.izquierda == null  && raiz.derecha == null
            && Character.isLetter(raiz.caracter) || raiz.caracter=='/') { 
            
            //Se muestra el caracter
            System.out.println(raiz.caracter + ":" + s); 
            return; 
        } 
        
        /*Cuando se va por la izquierda se agrega un 0
          Cuando se va por la derecha se agrega un 1*/
        codigo(raiz.izquierda, s + "0"); 
        codigo(raiz.derecha, s + "1"); 
    } 
    

}