import java.util.ArrayList;
import java.util.Random;

public class Rabbit {

    public int ageMois;
    public String genre;
    public boolean adult;
    public boolean life;
    public boolean fertile;
    public float survie;

    public int diff;

    public MTwister x_random;
    public double age_random, genre_random, death_random, fertile_random, birth_random;
    

    public Rabbit () {
        this.ageMois = 0;
        this.life = true;
        this.survie = (float) 0.75;
        this.fertile =true;
        this.adult = false;
    }
   

    public Rabbit (int ageMois, String genre, boolean adult) {
        this.ageMois = ageMois;
        this.genre = genre;
        this.adult = adult;
        this.life = true;
        this.survie = (float) 0.75;
        this.fertile =true;
    }


    public void verifGenre(){
        x_random = new MTwister(274983L);
        genre_random = x_random.genrand_real1();
        System.out.println(genre_random);
        if (genre_random <= 0.5 ){
            this.genre = "femelle";
        }
        else{
            this.genre = "male";
        }
    }


    public void fertilite(){
        if(this.genre == "femelle"){
            x_random = new MTwister(274983L);
            fertile_random = x_random.genrand_real1();
            if(fertile_random<=0.10){
                this.fertile=false;
            } 
        }
    }


    public void verifMaturite(){               // babytoadult
       if(ageMois>=5 && ageMois<8){ 
            x_random = new MTwister(274983L);
            age_random = x_random.genrand_real1();
            if (age_random <= 0.5 ){
                this.adult = true;
            }
        }
        else if (ageMois>=8){
            this.adult = true;
        }
        else {
            this.adult = false;
        }
    }


    public void survieAge(){
        //survie age
        if(this.ageMois >= 84){ 
            this.survie-=0.15;
        }
    }


    public void verifDeath(){
        //survie adulte
        if(this.adult == true){ 
            x_random = new MTwister(274983L);
            death_random = x_random.genrand_real1();
            if(death_random>this.survie){
                this.life=false;
            }
        }
        //survie enfant
        if(this.adult == false){ 
            x_random = new MTwister(274983L);
            death_random = x_random.genrand_real1();
            if(death_random>0.5){
                this.life=false;
            }
        }
        //survie femelle
        if(this.genre == "femelle"){ 
            x_random = new MTwister(274983L);
            death_random = x_random.genrand_real1();
            if(death_random<0.15){
                this.life=false;
            }
        }
    }


    public int naissance(){
        if(this.genre == "femelle"){ 
            x_random = new MTwister(274983L);
            birth_random = x_random.genrand_real1();
        
            if(birth_random < 1/16){
                return 3;
            }
            else if (birth_random  < 3/16){
                return 4;
            }
            else if (birth_random  < 6/16){
                return 5;
            }
            else if (birth_random  < 10/16){
                return 6;
            }
            else if (birth_random < 13/16){
                return 7;
            }
            else if (birth_random  < 15/16){
                return 8;
            }
            else{
                return 9;
            }
        }
        else{
            return 0;
        }
    }
    

    public String toString(){
        return  ageMois + " " + genre + " " + adult + " " + life + " " + fertile + " " + survie;
    }

    public static void fibonacci(int MAX){
        int i,temp,
            adultRabbit = 0,
            youngRabbit = 2;
        System.out.printf("Nombres de couples le mois 0 : 1 \n");
        for(i = 0; i<MAX+1; i++)
        {
            temp = youngRabbit;
            youngRabbit += adultRabbit;
            adultRabbit += temp;
            youngRabbit -= temp;
            System.out.printf("Nombres de couples le mois %d : %d\n",i+1,(adultRabbit+youngRabbit)/2);
        }
    }



    public static void main(String [] args) {

        ArrayList<Rabbit> population = new ArrayList<Rabbit>();

        Rabbit a = new Rabbit(10,"femelle",true);
        Rabbit b = new Rabbit(10,"male",true);

        int nbNaissance = 0;

        population.add(a);
        population.add(b);

        //Rabbit c = new Rabbit();
        //c.verifGenre();

        //System.out.println(c);

        
        for (i = 0; i < 12; i++){
            for (int j=0; j<=population.size(); j++){
                //nbNaissance = (population.get(j)).naissance();
                //System.out.println(nbNaissance);
            }    
        }
        
    }
}
