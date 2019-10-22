# PokemonApi

I would like to present you a Pokemon Api. Get data about pokemons, their moves, trainers and gyms they beaten. Try out one of two features allowing to fight or catch a pokemon. Below is a list with endpoints You can use:
 
- # Catch pokemon
     - /api/trainers/catch_pokemon?trainerId={trainerId}&pokemonId={pokemonId} - use this endpoint to simulate trainer's attempt to catch pokemon.

- # Fight another trainer
     - /api/fight?trainer1={trainer1Id}&trainer2={trainer2Id} - use this endpoint to simulate fight between two trainers with given id's. Trainer whose pokemons have moves with better attackDamage wins.
 
 
 
- # Pokemons
     - **GET methods**
          - /api/pokemons - all pokemons
          - /api/pokemons/{id} - pokemon with given id
          - /api/pokemons/{id)/moves - moves of pokemon with given id
          - /api/pokemons?name={nameOfPokemon} - pokemons with given name
          - /api/pokemons?type={typeOfPokemon} - pokemons with given type
          
     - **DELETE methods**
          - /api/pokemons/{id} - delete pokemon with given id
     
     - **POST methods**
          - /api/pokemons - add new pokemon 
     
     - **PUT methods**
          - /api/pokemons/{id} - update pokemon with given id
 
 - # Trainers
     - **GET methods**
          - /api/trainers - all trainers
          - /api/trainers/{id} - trainer with given id
          
     - **DELETE methods**
          - /api/trainers/{id} - delete trainer with given id
     
     - **POST methods**
          - /api/trainers - add new trainer 
     
     - **PUT methods**
          - /api/trainers/{id} - update trainer with given id
  
  - # Gyms
     - **GET methods**
          - /api/gyms - all gyms
          - /api/gyms/{id} - gym with given id
          
     - **DELETE methods**
          - /api/gyms/{id} - delete gym with given id
     
     - **POST methods**
          - /api/gyms - add new gym 
     
     - **PUT methods**
          - /api/gyms/{id} - update gym with given id
          
- # Documentation
     - /api - that is where documentation is going to be located (in progress)   
