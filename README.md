# Simulation de la Population de Lapins

## Description du Projet

Ce projet simule la croissance et la survie d'une population de lapins en utilisant un modèle probabiliste, avec des événements aléatoires gérés par le générateur de nombres aléatoires Mersenne Twister (MT19937). La simulation permet de suivre l'évolution de la population de lapins en fonction de divers paramètres tels que la fertilité, la survie, la mortalité, et la reproduction des lapins. Les lapins peuvent se reproduire, survivre ou mourir selon des probabilités définies dans les méthodes du code.

### But du Projet
L'objectif principal est de simuler l'évolution d'une population de lapins au fil du temps, en prenant en compte différents paramètres génétiques et environnementaux, avec des tirages aléatoires pour déterminer le sexe des lapins, leur taux de fertilité, et leurs chances de survie.

## Explication du Code

### Classes et Méthodes

1. **Classe `Rabbit`** :
    - Représente un lapin avec des attributs comme l'âge, le sexe, la fertilité, la survie, et l'état de vie.
    - Méthodes principales :
      - `verifGenre(double x_random)`: Détermine le sexe du lapin à la naissance.
      - `fertilite(double x_random)`: Vérifie si une femelle est fertile ou non.
      - `verifMaturite(double x_random)`: Vérifie si un lapin devient adulte en fonction de son âge.
      - `survieAge()`: Met à jour le taux de survie des lapins avec l'âge.
      - `verifDeath(double x_random)`: Détermine si un lapin meurt selon son taux de survie.
      - `verifAccouchement(double x_random)`: Vérifie si une femelle meurt lors de l'accouchement.
      - `naissance(double x_random)`: Détermine le nombre de lapins nés d'une femelle.
      - `portee(double x_random)`: Attribue le nombre de portées pour une femelle fertile.
      - `toString()`: Retourne les informations d'un lapin.

2. **Classe `MTwister`** :
    - Implémentation du générateur de nombres aléatoires Mersenne Twister (MT19937).
    - Ce générateur est utilisé pour obtenir des valeurs aléatoires qui influencent le sexe, la fertilité, et la survie des lapins, ainsi que pour déterminer les événements dans la simulation.

3. **Méthode `fibonacci(int MAX)`** :
    - Simule la population de lapins suivant le modèle de Fibonacci, c'est-à-dire que chaque mois la population double, mais cette méthode n'est pas directement utilisée dans la simulation.

### Logique de la Simulation
1. **Initialisation** :
    - Une population initiale de lapins (2 femelles et 2 mâles) est créée avec des valeurs par défaut.
    - Le générateur de nombres aléatoires est initialisé à l'aide de la méthode `init_by_array`.

2. **Évolution Mensuelle** :
    - Chaque mois, les lapins adultes peuvent se reproduire en fonction de leur fertilité et du nombre de portées.
    - Les lapins peuvent mourir en fonction de leur survie, de leur âge, ou de complications pendant l'accouchement.
    - Les nouveaux lapins nés sont ajoutés à la population.
    - Les lapins vieillissent, et des tests de mortalité sont effectués.

3. **Affichage** :
    - À la fin de chaque mois, le nombre total de lapins vivants dans la population est affiché.

### Utilisation de la Méthode `MTwister`
La méthode `genrand_real1()` du générateur MTwister est utilisée pour obtenir des nombres aléatoires entre 0 et 1. Ces nombres sont ensuite utilisés pour déterminer divers événements dans la simulation, comme le sexe des lapins, la fertilité, la survie, et les naissances.
