
public class Nodo {
    private int valor;
    private Nodo nodoIzquierdo;
    private Nodo nodoDerecho;

    public Nodo(int valor){
        this.valor = valor;
        this.nodoIzquierdo = null;
        this.nodoDerecho = null;
    }

    public int getValor(){
        return this.valor;
    }

    public void setValor(int valor){
        this.valor = valor;
    }

    public Nodo getNodoIzquierdo(){
        return this.nodoIzquierdo;
    }

    public void setNodoIzquierdo(Nodo nodoIzquierdo){
        this.nodoIzquierdo = nodoIzquierdo;
    }

    public Nodo getNodoDerecho(){
        return this.nodoDerecho;
    }

    public void setNodoDerecho(Nodo nodoDerecho){
        this.nodoDerecho = nodoDerecho;
    }
}
