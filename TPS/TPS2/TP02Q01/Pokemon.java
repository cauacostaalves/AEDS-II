
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
    private Date captureDate;

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

    public Pokemon(int id , int generation , String name , String descripiton , ArrayList<String> types , ArrayList<String> abilities, double weight, double height , int captureRate,boolean isLegendary,Date captureDate){
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
    
    public Date getCaptureDate() {return captureDate;}
    public void setCaptureDate(Date captureDate) {this.captureDate = captureDate;}
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
        clonado.captureDate = this.captureDate != null ? (Date) this.captureDate.clone() : null; 
            
        return clonado;
    }

    public void lerPokemon(){

    }

    public void imprimirPokemon(){
        System.out.println("[#" + id + " -> " + name + ": " + description + " - " + types + abilities + " - " 
        + weight + " - " + height + " - " + captureRate + "% - " + generation + " gen]" + " - " + captureDate);
    }
}