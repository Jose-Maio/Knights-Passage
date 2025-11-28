## LDTS_T02G09 - Knights Passage

In this thrilling game you can guide the player through multiple levels, collecting keys and avoiding or defeating enemies to reach the exit. 
Each level features unique arenas with walls, trees, and other obstacles, and the game offers multiple difficulty settings.

This project was developed by José Maio (up202404872@up.pt) and Pedro Vilaça (up202404967@up.pt) for LDTS 2025⁄26.


### IMPLEMENTED FEATURES

- **Multiple Levels** - The player can progress into the next level when collects a key or when kills all enemies.
- **Various Game Configurations** - The game difficulty changes depending on the configuration set (enemies are stronger and have more hp).

### PLANNED FEATURES

- **Attacking Enemies** - The game character is able to damage enemies when close to them.
- **Getting Hidden Keys** - When the game character gets close to a hidden key it reveals its position so the player can collect it.
- **Starting Menu** - The game will include a starting menu that will allow the user to choose the configuration/difficulty settings for the game.
- **Basic Enemy Moving Algorithm** - The enemies will follow a strict algorithm, making them always move closer to the player.  

### DESIGN

#### THE LEVELS SHOULD NOT BE CREATED BY THE GAME CLASS

**Problem in Context**

A major challenge in the project was the complexity of building levels, arenas, and all their elements (enemies, walls, keys, spawn positions, exit positions…).
At first, this logic was grouped in the Game class, making it and its constructor huge, even for just one level.
This caused the Game class to have too many responsabilities, violating the Single Responsability Pattern.

**The Pattern**

To solve this problem we applied the **Factory Method** pattern. This pattern allows us to centralize level objects creation in a single class that will have

**Implementation**

UML :

![img](https://www.fe.up.pt/~arestivo/page/img/examples/lpoo/state.svg)

This class can be found in the following file:

- [LevelFactory](https://github.com/FEUP-LDTS-2025/project-t02g09/blob/504947cb5df0180ccc2882429f0d2288fa7f98a8/src/main/java/model/game/LevelFactory.java)

**Consequences**

The use of the Factory Method Pattern in the current design allows the following benefits:

- Centralizes complex level creation logic, as all level construction rules are in a single class.
- Supports scalability as adding a new level is as simple as creating a new method, for example createLevel5().
- Cleaner and more maintainable code because Game goes back to only managing gameplay flow and not constructing complex objects.
  
#### RENDERER SYSTEM 

**Problem in Context**

In our project, we needed to create ways to render our different game entities on the Lanterna Screen. A first thought would be to create a single Render class that would contain methods to render each type of entity. However this implied that a simple bug fix or change in any of the methods would affect the whole class and each time we decided to add a new type of entity to the game that class would double in size. This violated the Open/Closed Principle.

**The Pattern**

To solve this problem we applied the **Strategy** pattern. This pattern allows us to define a family of classes, that extend a simple interface making them interchangeable.

**Implementation**

UML do pattern:

![img](https://www.fe.up.pt/~arestivo/page/img/examples/lpoo/state.svg)

These classes can be found in the following files:

- [EntityRenderer](https://github.com/FEUP-LDTS-2025/project-t02g09/blob/504947cb5df0180ccc2882429f0d2288fa7f98a8/src/main/java/view/entities/EntityRenderer.java)
- [EnemyRenderer](https://github.com/FEUP-LDTS-2025/project-t02g09/blob/504947cb5df0180ccc2882429f0d2288fa7f98a8/src/main/java/view/entities/EnemyRenderer.java)
- [PlayerRenderer](https://github.com/FEUP-LDTS-2025/project-t02g09/blob/504947cb5df0180ccc2882429f0d2288fa7f98a8/src/main/java/view/entities/PlayerRenderer.java)
- [WallRenderer](https://github.com/FEUP-LDTS-2025/project-t02g09/blob/504947cb5df0180ccc2882429f0d2288fa7f98a8/src/main/java/view/entities/WallRenderer.java)
- [TreeRenderer](https://github.com/FEUP-LDTS-2025/project-t02g09/blob/504947cb5df0180ccc2882429f0d2288fa7f98a8/src/main/java/view/entities/TreeRenderer.java)
- [KeyRenderer](https://github.com/FEUP-LDTS-2025/project-t02g09/blob/504947cb5df0180ccc2882429f0d2288fa7f98a8/src/main/java/view/entities/KeyRenderer.java)

**Consequences**

The use of the Strategy Pattern in the current design allows the following benefits:

- Ensures Open/Closed Principle.
- Allows us to isolate the details of the implementation of the render methods in each class.

#### LEVELFACTORY SHOULD ONLY HAVE A SINGLE INSTANCE

**Problem in Context**

After we created LevelFactory class we wanted to ensure that it would only have one single instance, as our game would have fixed levels and we wanted to prevent possible code duplication or extra levels being created, as well as giving global acess to this class to any class that would need to create or fetch a level such as the Game class.

**The Pattern**

To solve this problem we applied the **Singleton** pattern. This pattern allows us to define class that is guaranteed to have only one instance, and provide global acess to it.

**Implementation**

UML do pattern:

![img](https://www.fe.up.pt/~arestivo/page/img/examples/lpoo/state.svg)

This class can be found in the following file:

- [LevelFactory](https://github.com/FEUP-LDTS-2025/project-t02g09/blob/504947cb5df0180ccc2882429f0d2288fa7f98a8/src/main/java/model/game/LevelFactory.java)
  
**Consequences**

The use of the Singleton Pattern in the current design allows the following benefits:

- Single acess point for level creation that assures consistent level initialization. 
- LevelFactory is only initialized when asked for the first time.

However this Pattern also comes with certain liabilities:

- Can make unit testing hard.
- Violates the Single Responsability Principle.

#### KNOWN CODE SMELLS

The LevelFactory is also responsible for creating the arena for each level, taking another domain of responsability, something that we hope to change soon.

The LevelRenderer and ArenaRenderer both violate the Open/Closed Principle as if we were to add a new object class to our game we would need to modidy this classes. This will be hopefully solved by using a map to track each class to its designated renderer.

### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

### SELF-EVALUATION

> In this section describe how the work regarding the project was divided between the students. In the event that members of the group do not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.

**Example**:

- John Doe: 40%
- Jane Doe: 60%
