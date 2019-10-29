import java.util.PriorityQueue; 
import java.util.Scanner;
import java.util.StringTokenizer;

import java.util.ArrayList;
import java.util.Comparator; 

import java.io.*;


public class Main{

    public static void main(String[] args) {
        

        //Creamos los elemetos
        //El caracter / representa al espacio

        ArrayList<Nodo> arr = new ArrayList<>();
        llenarLista(arr, args);

        //Creamos la cola con prioridad indicando el número de elementos y el comparador
        
        int tam = arr.size();
        PriorityQueue<Nodo> q = new PriorityQueue<>( tam, new Comparador());

        //añadiendo los Nodos a la cola
        for( int i=0; i<arr.size(); i++){
            q.add(arr.get(i));
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

    public static void llenarLista( ArrayList<Nodo> arr , String args[] ){

        try{

            File archivo = new File("pruebas\\" + args[0]);
            FileReader fr = new FileReader (archivo);
            BufferedReader br = new BufferedReader(fr);
    
            String lista = br.readLine();

            StringTokenizer st_b = new StringTokenizer(lista, ",");
            
            while( st_b.hasMoreTokens()){
                StringTokenizer pares = new StringTokenizer(st_b.nextToken(), "_");
                arr.add(new Nodo( pares.nextToken().charAt(0), Float.parseFloat(pares.nextToken()) ));
            }
            
            br.close();
            
            }catch( Exception e ){
                System.out.println(e);
            }

    } 

}