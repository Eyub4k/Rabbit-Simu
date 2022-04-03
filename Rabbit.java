import java.util.ArrayList;
import java.util.Random;

public class Rabbit 
{
    public int      ageMois,diff,nbDePortee;
    public String   genre;
    public boolean  adult,life,fertile;
    public float    survie;
    public MTwister x_random;

    /*----------------------------------------------------------------------*
    * Rabbit : Premier constructeur initialise avec des valeurs par defaut  *
    * Ce constructeur nous permet de creer des enfants lapins               *
    * (d'ou la variable adulte est false)                                   *
    *                                                                       *
    * Ces lapins vont ensuite subir les tests definis dans les methodes     *
    *                                                                       *
    * En entree : -                                                         *
    * En sortie : -                                                         *
    *----------------------------------------------------------------------*/
    public Rabbit () 
    {
        this.ageMois = 0;
        this.life    = true;
        this.survie  = (float) 0.75;
        this.fertile = true;
        this.adult   = false;
        this.nbDePortee = 0; 
    }

   
    /*----------------------------------------------------------------------*
    * Rabbit : Deuxieme constructeur initialise avec son age par rapport aux*
    * mois, a son genre, s'il est adulte, son taux de survie et si le lapin *
    * en question est une femelle, son nombre de portee ainsi que sa        *
    * fertilite                                                             *
    * Ces lapins vont ensuite subir les tests definis dans les methodes     *
    *                                                                       *
    * En entree : -                                                         *
    * En sortie : -                                                         *
    *----------------------------------------------------------------------*/
    public Rabbit (int ageMois, String genre, boolean adult) 
    {
        this.ageMois = ageMois;
        this.genre   = genre;
        this.adult   = adult;
        this.life    = true;
        this.survie  = (float) 0.75;
        this.fertile = true;
        this.nbDePortee = 0; 
    }


    /*----------------------------------------------------------------------*
    * verifGenre : methode qui va nous permettre d'attribuer un sexe au     *
    * nouveau née                                                           *                                                       
    *                                                                       *
    * En entree : un chiffre aleatoire entre 0 et 1                         *
    * En sortie : -                                                         *
    *----------------------------------------------------------------------*/
    public void verifGenre(double x_random)
    {
        if (x_random <= 0.5 )
        {
            this.genre = "femelle";
        }
        else
        {
            this.genre = "male";
        }
    }


    /*----------------------------------------------------------------------*
    * fertilite : methode qui va nous permettre de verifié la fertilité des *
    * femelles et en rendant infertille 10 % des lapines                    *
    *                                                                       *
    * En entree : un chiffre aleatoire entre 0 et 1                         *
    * En sortie : -                                                         *
    *----------------------------------------------------------------------*/
    public void fertilite(double x_random)
    {
        if(this.genre == "femelle")
        {
            if(x_random <= 0.10)
            {
                this.fertile = false;
            } 
        }
    }


    /*----------------------------------------------------------------------*
    * verifMaturite : methode qui va permettre au lapin d'etre adulte       *
    *                                                                       *
    * En entree : un chiffre aleatoire entre 0 et 1                         *
    * En sortie : -                                                         *
    *----------------------------------------------------------------------*/
    public void verifMaturite(double x_random) 
    {
        if(ageMois >= 5 && ageMois < 8)
        { 
            if (x_random <= 0.5 )
            {
                this.adult = true;
            }
        }
        else if (ageMois >= 8)
        {
            this.adult = true;
        }
        else 
        {
            this.adult = false;
        }
    }


    /*----------------------------------------------------------------------*
    * survieAge : methode qui va nous permettre de MAJ le taux de survie    *
    * des lapins et ainsi tuer les lapins ayant un taux de survie null      *
    *                                                                       *
    * En entree : un chiffre aleatoire entre 0 et 1                         *
    * En sortie : -                                                         *
    *----------------------------------------------------------------------*/
    public void survieAge()
    {
        if (this.survie <= 0)
        {
            this.life = false;
        }
        if(this.ageMois >= 84)
        { 
            this.survie -= 0.15;
        }
    }


    /*----------------------------------------------------------------------*
    * verifDeath : methode qui va nous permettre de verifié la mort des     *
    * lapins et ainsi tuer les lapins ayant un taux de survie inferieur     *
    * au chiffre aleatoire et que les lapin enfant ont une 1/2 de mourrir à *
    * la naissance                                                          *
    *                                                                       *
    * En entree : un chiffre aleatoire entre 0 et 1                         *
    * En sortie : -                                                         *
    *----------------------------------------------------------------------*/
    public void verifDeath(double x_random)
    {
        //survie adulte
        if(this.adult == true && this.ageMois >= 84)
        { 
            if(x_random > this.survie)
            {
                this.life = false;
            }
        }
        //survie enfant
        if(this.adult == false)
        { 
            if(x_random > 0.5)
            {
                this.life = false;
            }
        }  
    }


    /*----------------------------------------------------------------------*
    * verifAccouchement : methode qui va nous permettre de tuer 15% des     *
    * femelle lors de l'accouchement                                        *
    *                                                                       *
    * En entree : un chiffre aleatoire entre 0 et 1                         *
    * En sortie : -                                                         *
    *----------------------------------------------------------------------*/
    public void verifAccouchement(double x_random)
    {
        if(this.genre == "femelle" && this.adult == true)
        { 
            if(x_random < 0.15)
            {
                this.life = false;
            }
        }
    }


    /*----------------------------------------------------------------------*
    * naissance : methode qui va nous permettre de creer des lapins par     *
    * rapport au probabilité calculé                                        *
    *                                                                       *
    * En entree : un chiffre aleatoire entre 0 et 1                         *
    * En sortie : le nombre de lapin qui vont naitre                        *
    *----------------------------------------------------------------------*/
    public int naissance(double x_random)
    {
        if(this.genre == "femelle" && this.fertile != false && this.adult == true)
        { 
            if(x_random < 12/100)
            {
                return 2;
            }
            else if (x_random < 37/100)
            {
                return 3;
            }
            else if (x_random < 62/100)
            {
                return 4;
            }
            else if (x_random < 87/100)
            {
                return 5;
            }
            else
            {
                return 6;
            }
        }
        else 
        {
            return 0;
        }
    }

    /*----------------------------------------------------------------------*
    * portee : methode qui va nous permettre d'attribuer le nombre de       *
    * portée pour une femelle par raport au probabilité donnée              *
    *                                                                       *
    * En entree : un chiffre aleatoire entre 0 et 1                         *
    * En sortie : le nombre de portée pour une femelle fertile              *
    *----------------------------------------------------------------------*/
    public void portee(double x_random)
    {
        if(this.genre == "femelle" && this.fertile != false && this.adult == true)
        { 
            if(x_random < 1/16)
            {
                this.nbDePortee = 3;

            }
            else if (x_random < 3/16)
            {
                this.nbDePortee = 4;
            }
            else if (x_random < 6/16)
            {
                this.nbDePortee = 5;
            }
            else if (x_random < 10/16)
            {
                this.nbDePortee = 6;
            }
            else if (x_random < 13/16)
            {
                this.nbDePortee = 7;
            }
            else if (x_random < 15/16)
            {
                this.nbDePortee = 8;
            }
            else
            {
                this.nbDePortee = 9;
            }
        }
        else
        {
            this.nbDePortee = 0;  // pour le male
        }
    }
    

    public String toString()
    {
        return  ageMois + " " + genre + " " + adult + " " + life + " " + fertile + " " + survie;
    }

    /*----------------------------------------------------------------------*
    * fibonacci : fonction qui propose l'evolution d'un couple de lapin en  *
    * suivant le modele proposé par Leonardo de Pizza                       *
    *                                                                       *
    * En entree :                                                           *
    * - int MAX qui se le mois maximun                                      *
    *                                                                       *
    *                                                                       *
    * En sortie : -                                                         *
    *---------------------------------------------------------------------- */
    public static void fibonacci(int MAX)
    {
        int i,temp,
            adultRabbit = 0,
            youngRabbit = 2;
        System.out.printf("Nombres de couples le mois 0 : 1 \n");
        for(i = 0; i < MAX + 1; i++)
        {
            temp = youngRabbit;
            youngRabbit += adultRabbit;
            adultRabbit += temp;
            youngRabbit -= temp;
            System.out.printf("Nombres de couples le mois %d : %d\n",i + 1,(adultRabbit + youngRabbit)/2 );
        }
    }

    public static void main(String [] args) 
    {
        int                 i;
        int                 nbNaissance = 0;
        int                 nb          = 0;
        long[]              init        = {0x123, 0x234, 0x345, 0x456};
        MTwister            x_random    = new MTwister();
        Rabbit              a           = new Rabbit(10,"femelle",true);
        Rabbit              b           = new Rabbit(10,"male",true);
        Rabbit              c          = new Rabbit(10,"femelle",true);
        Rabbit              d          = new Rabbit(10,"male",true);
        ArrayList<Rabbit>   population  = new ArrayList<Rabbit>();
        
        population.add(a);
        population.add(b);
        population.add(c);
        population.add(d);

        x_random.init_by_array(init);

        
        for (i = 0; i < 180; i++)
        {
            if ((i%12) == 0){
                for (int n = 0; n < population.size(); n++)
                {
                    population.get(n).portee(x_random.genrand_real1());
                    population.get(n).verifAccouchement(x_random.genrand_real1());
                    population.get(n).fertilite(x_random.genrand_real1());
                }
            }

            for (int j = 0; j < population.size(); j++)
            { 
                if (population.get(j).nbDePortee >= 1)
                {
                    if (population.get(j).life == true )
                    {
                        nbNaissance = (population.get(j)).naissance(x_random.genrand_real1());
                        nb += nbNaissance;
                        population.get(j).nbDePortee --;
                    }
                }
            }

            for (int k = 0 ; k < nb; k++)
            {
                Rabbit r = new Rabbit();
                r.verifGenre(x_random.genrand_real1()); 
                population.add(r);
            } 
         
            for (int lapin = 0; lapin < population.size(); lapin++)
            {
                population.get(lapin).ageMois = population.get(lapin).ageMois + 1;
                population.get(lapin).survieAge();
                population.get(lapin).verifMaturite(x_random.genrand_real1());
                population.get(lapin).verifDeath(x_random.genrand_real1());
            }
            
            for(int h = 0; h < population.size(); h++ )
            {
                if (population.get(h).life == false)
                {
                    population.remove(population.get(h));
                }
            }
       
            nb = 0;

            System.out.println("mois " + i +" "+ "pop : " + population.size());   
        }

        //fibonacci(12);
        System.out.println(population.size());
    }
    
}   