import java.util.*;

public class tradutorpapainoel {
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);

        String[] paises = {                                        
            "brasil",               
            "alemanha",    
            "austria",      
            "coreia",      
            "espanha",      
            "grecia",     
            "estados-unidos",
            "inglaterra",  
            "australia",   
            "portugal",    
            "suecia",   
            "turquia",    
            "argentina",   
            "chile",    
            "mexico",     
            "antartida",     
            "canada",     
            "irlanda",     
            "belgica",     
            "italia",     
            "libia",     
            "siria",      
            "marrocos",    
            "japao" 
        };

        String[] traducao = { 
            "Feliz Natal!",          
            "Frohliche Weihnachten!",
            "Frohe Weihnacht!",      
            "Chuk Sung Tan!",        
            "Feliz Navidad!",        
            "Kala Christougena!",    
            "Merry Christmas!",      
            "Merry Christmas!",      
            "Merry Christmas!",      
            "Feliz Natal!",          
            "God Jul!",              
            "Mutlu Noeller",         
            "Feliz Navidad!",        
            "Feliz Navidad!",        
            "Feliz Navidad!",        
            "Merry Christmas!",      
            "Merry Christmas!",      
            "Nollaig Shona Dhuit!",  
            "Zalig Kerstfeest!",     
            "Buon Natale!",          
            "Buon Natale!",          
            "Milad Mubarak!",        
            "Milad Mubarak!",        
            "Merii Kurisumasu!"     
        };

        
        
        while(sc.hasNextLine()){
            int j =0;
            boolean achou = false;
            String escolhida = sc.nextLine();
            for(int i=0; i<paises.length;i++){
                if(escolhida.equals(paises[i])){
                    j = i;
                    achou = true;
                    break;
                }
            }
            if(achou == true){
            System.out.println(traducao[j]);
            }else{
                System.out.println("--- NOT FOUND ---");
            }
        }
        sc.close();
    }
}

/*
brasil              Feliz Natal!               
alemanha            Frohliche Weihnachten!       
austria             Frohe Weihnacht!                  
coreia              Chuk Sung Tan!                  
espanha             Feliz Navidad!                  
grecia              Kala Christougena!           
estados-unidos      Merry Christmas!                         
inglaterra          Merry Christmas!              
australia           Merry Christmas!              
portugal            Feliz Natal!              
suecia              God Jul!                                  
turquia             Mutlu Noeller                    
argentina           Feliz Navidad!                    
chile               Feliz Navidad!                    
mexico              Feliz Navidad!                             
antardida           Merry Christmas!         
canada              Merry Christmas!         
irlanda             Nollaig Shona Dhuit!         
belgica             Zalig Kerstfeest!         
italia              Buon Natale!             
libia               Buon Natale!             
siria               Milad Mubarak!             
marrocos            Milad Mubarak!             
japao               Merii Kurisumasu!                     
*/