

public class ArbolBinario {
   private Nodo raiz;
   private int valor;

   public ArbolBinario(Nodo raiz){
    this.raiz = null;
   }
   //Metodo que retorna un String que indica si el valor fue encontrado o no al llamar el metodo buscar
   public String buscar(int valor){
      if (buscar(raiz, valor)) return "Número encontrado!!";
      return "Número no encontrado";
   }
   //Metodo que retorna un booleano que indica si el valor fue encontrado o no
   public boolean buscar(Nodo nodo,int valor){
      //Caso si la raiz es nula retorna falso pues no hay valor a buscar
      if(raiz == null){
         return false;
      }
      //Caso que el valor del nodo actual es igual al valor buscado
      if(raiz.getValor() == valor){
         return true;
      }
      //Si el valor es menor que el del nodo actual, realiza la busqueda en su hijo izquierdo
      if(raiz.getValor() < valor){
         return buscar(raiz.getNodoIzquierdo(), valor);
      }
      //Si el valor es mayor que el del nodo actual, realiza la busqueda en su hijo derecho
      return buscar(raiz.getNodoDerecho(), valor);
   }

}
