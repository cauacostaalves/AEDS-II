import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

class Pokemon{

    private int id;
    private int generation;
    private String name;
    private String description;
    private ArrayList<String> types;
    private ArrayList<String> abilities;
    private double weight;
    private double height;
    private int captureRate;
    private boolean isLegendary;
    private LocalDate captureDate;

    public Pokemon(){
        this.id = 0;
        this.generation = 0;
        this.name = "";
        this.description = "";
        this.types = new ArrayList<>();
        this.abilities = new ArrayList<>();
        this.weight = 0.0;
        this.height = 0.0;
        this.captureRate = 0;
        this.isLegendary = false;
        this.captureDate = null;
    }

    public Pokemon(int id , int generation , String name , String descripiton , ArrayList<String> types , ArrayList<String> abilities, double weight, double height , int captureRate,boolean isLegendary,LocalDate captureDate){
        this.id = id;
        this.generation = generation;
        this.name = name;
        this.description = descripiton;
        this.types = types;
        this.abilities = abilities;
        this.weight = weight;
        this.height = height;
        this.captureRate = captureRate;
        this.isLegendary = isLegendary;
        this.captureDate = captureDate;
    }

    //-------------------------------------Gets e Sets -----------------------------------------------------------------------------------
    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public int getGeneration(){return generation;}
    public void setGeneration(int generation){this.generation = generation;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}

    public ArrayList<String> getTypes() {return types;}
    public void setTypes(ArrayList<String> types) {this.types = types != null ? types : new ArrayList<>();    }

    public ArrayList<String> getAbilities() {return abilities;}
    public void setAbilities(ArrayList<String> abilities) {this.abilities = abilities != null ? abilities : new ArrayList<>(); }

    public double getWeight() {return weight;}
    public void setWeight(double weight) {this.weight = weight;}

    public double getHeight() {return height;}
    public void setHeight(double height) {this.height = height;}

    public int getCaptureRate() {return captureRate;}
    public void setCaptureRate(int captureRate) {this.captureRate = captureRate;}
    
    public boolean isLegendary() {return isLegendary;}
    public void setLegendary(boolean legendary) {isLegendary = legendary;}
    
    public LocalDate getCaptureDate() {return captureDate;}
    public void setCaptureDate(LocalDate captureDate) {this.captureDate = captureDate;}
    //----------------------------FIM gets e sets--------------------------------------------------------------------------------

    public Pokemon Pokemonclone(){
        Pokemon clonado = new Pokemon();
            
        // Clonando o Pokémon
        clonado.id = this.id;
        clonado.generation = this.generation;
        clonado.name = this.name;
        clonado.description = this.description;
        clonado.types = new ArrayList<>(this.types); 
        clonado.abilities = new ArrayList<>(this.abilities); 
        clonado.weight = this.weight;
        clonado.height = this.height;
        clonado.captureRate = this.captureRate;
        clonado.isLegendary = this.isLegendary;
        clonado.captureDate = this.captureDate;

        return clonado;
    }

    public ArrayList<Pokemon> lerPokemon(ArrayList<String> Pokes){
        int idPoke = 0;
        ArrayList<Pokemon> Pokedex = new ArrayList<>();
        while(idPoke < Pokes.size()){
            String pokemon = Pokes.get(idPoke);
            String [] temp = pokemon.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");  
            int id = Integer.parseInt(temp[0]);
            int generation = Integer.parseInt(temp[1]);
            String name = temp[2];
            String description = temp[3];
            ArrayList<String> types = new ArrayList<>();
            types.add(temp[4]);
            if(!temp[5].isEmpty()){
                types.add(temp[5]);
            }
            ArrayList<String> abilities = new ArrayList<>();
            abilities.add(temp[6]);
            double weight = 0.0;
            if(!temp[7].isEmpty()){
                weight = Double.parseDouble(temp[7]);
            }
            double height = 0.0;
            if(!temp[8].isEmpty()){
                height = Double.parseDouble(temp[8]);
            }
            int captureRat = Integer.parseInt(temp[9]);
            boolean isLegendary = Boolean.parseBoolean(temp[10]); 
            LocalDate captureDate = LocalDate.parse(temp[11], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Pokemon PokeTemp = new Pokemon(id, generation , name , description , types , abilities , weight , height , captureRat, isLegendary ,captureDate); 
            Pokedex.add(PokeTemp);
            idPoke++;
        }
        return Pokedex;
    }

    public void imprimirPokemon(){
        String FormatedTypes= types.stream().map(type -> "'" + type + "'") .collect(Collectors.joining(", "));

        String FormatedAbilities = abilities.toString();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String formattedDate = captureDate.format(dateFormatter);

        FormatedAbilities = FormatedAbilities.replace("[\"", "").replace("]\"", "");
        //System.out.println(FormatedAbilities);

        System.out.println("[#" + id + " -> " + name + ": " + description + " - [" 
            + FormatedTypes + "] - " + FormatedAbilities + " - " 
            + weight + "kg - " + height + "m - " + captureRate + "% - " 
            + isLegendary + " - " + generation + " gen] - " + formattedDate);
    }
}


class classeEmJava {
    
    public static ArrayList<String> LerCSV(){
        String csvFile = "/temp/pokemon.csv";
        ArrayList<String> TextoCSV = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine();
            String LinhaCSV;
            while((LinhaCSV = br.readLine()) != null ){
                TextoCSV.add(LinhaCSV);
            }
            br.close();
        }catch(Exception e){e.printStackTrace();}
        return TextoCSV;
    }

    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);

        //Lendo o arquivo csv e guardando em um array list 
        ArrayList<String> Pokes = LerCSV();
        ArrayList<Pokemon> Pokedex = new ArrayList<>();
        Pokemon ler = new Pokemon();
        Pokedex = ler.lerPokemon(Pokes);

        while(true){
            String idPokemon = sc.next();
            if(idPokemon.equals("FIM")){
            break;
            }
            int idPok = Integer.parseInt(idPokemon);
            Pokedex.get(idPok-1).imprimirPokemon();
        }
        sc.close();
    }
}
