import java.util.*;

class Pokemon{
    private int id;
    private int generation;
    private String name;
    private String description;
    private String[] types;
    private String[] abilities;
    private double weight;
    private double height;
    private int captureRate;
    private boolean isLegendary;
    private Date captureDate;

    public Pokemon(){
    }

    public Pokemon(int id , int generation){
        this.id = id;
        this.generation = generation;
    }

    public void imprimir(){
       // imprimir a lista inteira? ou um selecionado
    }

    public void ler(){
        // pegar o csv
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getGeneration(){
        return generation;
    }

    public void setGeneration(int generation){
        this.generation = generation;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    // public void clone(){ oq fazer?}
}
public class classeEmJava {
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);

        sc.close();
    }
}
