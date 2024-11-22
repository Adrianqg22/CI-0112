
import java.util.Arrays;



public class Recursividad{
    public static int sumarDigitos(int numero){
        if(numero == 0){
            return 0;
        }
        return numero % 10 + sumarDigitos(numero / 10);
    }

    public static int potencia(int x, int n){
            if(n == 0){
                return 1;
            }
            return x * potencia(x , n - 1);
    
    }

    public static String invertirCadena(String cadena){
        if(cadena.isEmpty()){
            return cadena;
        }
        return  invertirCadena(cadena.substring(1))+ cadena.charAt(0);
    }

    public static int mcd(int a, int b){
        if(b == 0){
            return a;
        }
        return mcd(b, a % b);
    }

    public static int sumarArray(int[] array, int indice){
        if(indice == array.length){
            return 0;
        }
        return sumarArray(array, indice + 1) + array[indice];
    }
    public static void main(String [] args){
        int [] array = {1,2,3,4};
        int resultado = sumarArray(array, 0);
        System.out.println(resultado);
    }
}
