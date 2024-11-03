public class Nodo {
    private int valor;
    private Nodo nodoIzquierdo;
    private Nodo nodoDerecho;

    public Nodo(int valor){
        this.valor = valor;
        this.nodoIzquierdo = nodoIzquierdo;
        this.nodoDerecho = nodoDerecho;
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

    public Nodo getNodoDerecho(){
        return this.nodoDerecho;
    }

    public void insertar(int valor){
        if (valor < this.valor){
            if(this.nodoIzquierdo == null){
                this.nodoIzquierdo = new Nodo(valor);
            }
    }
}
