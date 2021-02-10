package classes;

public class NetworkNode implements Comparable<NetworkNode> {

    private int index;
    private double peso;

    NetworkNode(int index, double peso){
        this.peso = peso;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public int compareTo(NetworkNode o) {
        if(this.peso > o.getPeso()){
            return 1;
        }

        if(this.peso == o.getPeso()){
            return 0;
        }
        return -1;
    }
}
