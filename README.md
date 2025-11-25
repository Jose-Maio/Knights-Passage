## LDTS_T02G09 - Knights Passage

In this thrilling game you can guide the player through multiple levels, collecting keys and avoiding or defeating enemies to reach the exit. 
Each level features unique arenas with walls, trees, and other obstacles, and the game offers multiple difficulty settings.

This project was developed by José Maio (up202404872@up.pt) and Pedro Vilaça (up202404967@up.pt) for LDTS 2025⁄26.


### IMPLEMENTED FEATURES

- **Multiple levels** - The player can progress into the next level when collects a key or when kills all enemies.
- 

### PLANNED FEATURES

- **Attacking enemies** - The game character is able to damage enemies when close to them.
- **Getting hidden keys** - When the game character gets close to a hidden key it reveals its position so the player can collect it.

### DESIGN

(https://help.github.com/en/articles/creating-a-permanent-link-to-a-code-snippet) (https://help.github.com/en/articles/about-readmes#relative-links-and-image-paths-in-readme-files). 

#### THE LEVELS SHOULD NOT BE CREATED BY THE GAME CLASS

**Problem in Context**

A major challenge in the project was the complexity of building levels, arenas, and all their elements (enemies, walls, keys, spawn positions, exit positions…).
At first, this logic was grouped in the Game class, making it and its constructor huge, even for just one level.
This caused the Game class to have too many responsabilities, violating the SRP (Single Responsability Pattern).

**The Pattern**

To solve this problem we applied the **Factory Method** pattern. This pattern allows us to centralize level objects creation in a single class that will have

**Implementation**

The following figure shows how the pattern’s roles were mapped to the application classes.

![img](https://www.fe.up.pt/~arestivo/page/img/examples/lpoo/state.svg)

These classes can be found in the following files:

- [Character](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/Character.java)
- [JumpAbilityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/JumpAbilityState.java)
- [DoubleJumpState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/DoubleJumpState.java)
- [HelicopterState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/HelicopterState.java)
- [IncreasedGravityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/IncreasedGravityState.java)

**Consequences**

The use of the Factory Method Pattern in the current design allows the following benefits:

- Centralizes complex level creation logic, as all level construction rules are in a single class.
- Supports scalability as adding a new level is as simple as creating a new method, for example createLevel5().
- Cleaner and more maintainable code because Game goes back to only managing gameplay flow and not constructing complex objects. 

#### KNOWN CODE SMELLS

> This section should describe 3 to 5 different code smells that you have identified in your current implementation.

### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

### SELF-EVALUATION

> In this section describe how the work regarding the project was divided between the students. In the event that members of the group do not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.

**Example**:

- John Doe: 40%
- Jane Doe: 60%
