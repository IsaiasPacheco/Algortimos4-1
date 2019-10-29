import java.util.PriorityQueue; 
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.util.Comparator; 


public class Main{

    public static void main(String[] args) {
        

        //Creamos los elemetos
        //El caracter / representa al espacio

        Nodo arr[] = { 
            new Nodo('/', (float) 18.3),
            new Nodo('e', (float) 10.2),
            new Nodo('t', (float) 7.7),
            new Nodo('a', (float) 6.8),
            new Nodo('o', (float) 5.9),
            new Nodo('i', (float) 5.8),
            new Nodo('n', (float) 5.5),
            new Nodo('s', (float) 5.1),
            new Nodo('h', (float) 4.9),
            new Nodo('r', (float) 4.8),
            new Nodo('d', (float) 3.5),
            new Nodo('l', (float) 3.4),
            new Nodo('c', (float) 2.6),
            new Nodo('u', (float) 2.4),
            new Nodo('m', (float) 2.1),
            new Nodo('w', (float) 1.9),
            new Nodo('f', (float) 1.8),
            new Nodo('g', (float) 1.7),
            new Nodo('y', (float) 1.6),
            new Nodo('p', (float) 1.6),
            new Nodo('b', (float) 1.3),
            new Nodo('v', (float) 0.9),
            new Nodo('k', (float) 0.6),
            new Nodo('j', (float) 0.2),
            new Nodo('x', (float) 0.2),
            new Nodo('q', (float) 0.1),
            new Nodo('z', (float) 0.1),
         };

         

        //Creamos la cola con prioridad indicando el número de elementos y el comparador
        PriorityQueue<Nodo> q = new PriorityQueue<>(arr.length, new Comparador());

        //añadiendo los Nodos a la cola
        for( int i=0; i<arr.length; i++){
            q.add(arr[i]);
        }

        
        //Crear el nodo raiz
        Nodo raiz = null;

        //Se recorre la cola creando los nodos

        while (q.size() > 1) { 
  
            // Se obtiene uno de los nodos. 
            Nodo x = q.peek(); 
            q.poll();  
  
            // Se obtiene el segundo nodo. 
            Nodo y = q.peek(); 
            q.poll(); 
  
            // Se crea la raiz de estos nodos
            Nodo f = new Nodo(); 
  
            // La raiz tiene la suma de las frecuencias 
            f.frecuencia = x.frecuencia + y.frecuencia; 
            f.caracter = '-'; 
  
            // El primer nodo extraido se coloca a la izquierda. 
            f.izquierda = x; 
  
            // El segundo nodo se coloca a la derecha. 
            f.derecha = y; 
  
            // El nodo de la suma de frecuencias es colocado como raiz. 
            raiz = f; 
  
            // Se agrega el nuevo nodo a la lista. 
            q.add(f); 
        } 

        Huffman hf = new Huffman();

        hf.codigo(raiz, "");

    }

}