import java.util.Random;
public class Arrays{
    private static int [] array;
    private static Random random = new Random();
    
    public Arrays(int [] vector){
        this.array = vector;
    }
    
    public void setArray(int [] array){
        this.array = array;
    }
    
    public void imprimirArray(){
        for(int i = 0; i < this.array.length; i++){
            System.out.print(array[i]);
            if(i < array.length - 1)System.out.print(", ");
        }
        System.out.println();
    }
    
    public void randomArray(){
        for(int i = 0; i < this.array.length; i++){
            array[i] = random.nextInt(11);
        }
        this.imprimirArray();
    }
    
    public void ordenamientoArray(){
        
        for(int i = 0; i< this.array.length; i++){
            int posicionMenor = i;
            int valorMenor= array[i];
            
            for(int j = i + 1; j < array.length; j++){
                if(array[posicionMenor] > array[j]){
                    posicionMenor = j;
                    valorMenor = array[j];
                }
            }
            
            if(posicionMenor != i){
               int temp = array[i];
               array[i] = array[posicionMenor];
               array[posicionMenor] = temp;
            }
        }
        this.imprimirArray();
    }
    
    public void busquedaSecuencial(int numero){
        int indice;
        for(int i = 0; i < this.array.length; i++){
            if(numero == array[i]){
               indice = array[i];
               System.out.println("El indice es: "+ i);
            }
        }
    }
    
    public void busquedaParesImpares(){
        int contadorPares = 0;
        int contadorImpares = 0;
        for(int i = 0; i < this.array.length; i++){
            if(array[i] % 2 == 0){
                contadorPares++;
            }else{
                contadorImpares++;
            }
        }
        System.out.println("La cantidad de numeros pares es: "+ contadorPares + " y la cantidad de impares es: "+ contadorImpares);
    }
    
    public void restaMayorMenor(){
        int valorMayor = array [0];
        int valorMenor = array[0];
        for(int i = 0; i< this.array.length; i++){
            if(valorMayor < array[i]){
                valorMayor = array[i];
            }
            if(valorMenor > array[i]){
                valorMenor = array[i];
            }
        }
        int resta = valorMayor - valorMenor;
        System.out.println("El resultado del mayor menos el menor es: " + resta );
    }
    
    public void encontrarDosPequeños(){
        int menor = array[0];
        int sMenor = array[0];
        for(int i = 0; i<this.array.length; i++){
            if(menor < array[i]){
                
            }
        }
    }
}