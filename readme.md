# Tic Tac Toe (Console Version)

This is a simple **Tic Tac Toe** game implemented in **Java**, playable via the **console**, supporting both human players and AI opponents with three difficulty levels.

---

## 🧰 Build System

This project uses **Maven** as its build and dependency management tool.  
It includes static code analysis tools to ensure code quality and maintainability:

- ✅ **PMD** – Detects programming flaws like unused variables, empty catch blocks, etc.
- ✅ **Checkstyle** – Enforces code style and formatting rules (Google Java Style)
- ✅ **SpotBugs + FindSecurityBugs** – Finds potential bugs and security issues in bytecode

These tools run automatically with:

```bash
mvn verify
```

And will **fail the build** if violations are found.

---

## 🎮 How to Play

When you run the program, you'll be prompted with a command menu.

To start a game, use the following command:

```
start <player1> <player2>
```

Where `<player1>` and `<player2>` can be:

- `user` → Human player (manually enters coordinates)
- `easy` → AI that makes random moves
- `medium` → AI that:
  - Wins if possible
  - Blocks the opponent from winning
  - Otherwise, makes a random move
- `hard` → AI that uses the **Minimax algorithm** to play optimally (unbeatable)

To exit the menu, type:

```
exit
```

---

## 📦 Example Commands

```bash
start user user
start user easy
start medium hard
exit
```

---

## 🧠 AI Levels Explained

| Level   | Description                                                                 |
|---------|------------------------------------------------------------------------------|
| easy    | Makes random valid moves                                                    |
| medium  | Basic logic: tries to win, blocks opponent, otherwise moves randomly        |
| hard    | Uses **Minimax** to evaluate all possible outcomes and always plays optimally |

---

## ✅ Requirements

- Java 17 or higher
- Maven 3.8+ (or just use the wrapper `mvnw`)
- Any IDE (e.g. IntelliJ IDEA) or terminal that supports running `.jar`

---

## 🚀 Running the Game

You can run the game from the terminal using:

```bash
java -jar "Tic Tac Toe Game.jar"
```

Make sure you're in the root folder of the project when running the above command.

---

## 🧱 Project Structure

- `Game` → Handles game logic and flow
- `Board` → Represents the game board
- `Player` → Abstract base class for all players
- `MovementStrategy` → Contains `Easy`, `Medium`, and `Hard` AI strategies
- `Menu` → Command-line interface to interact with the game

---

## 📝 Features

- Fully playable from the console
- Handles invalid input gracefully
- Tracks and enforces game rules
- Modular and extensible code structure

---


---

## ✅ Tests and Plugins

This project includes a full test suite using **JUnit 5** and **Mockito**, covering:

- Game logic (`Game`, `Board`, `Player`, `PlayerFactory`, etc.)
- AI behavior for all difficulty levels (`Easy`, `Medium`, `Hard`)
- User interaction (`Menu`, `Main`), with input simulated via `Scanner`

You can run all tests with:

```bash
mvn clean verify
```

This command also runs all quality plugins:

- ✅ **PMD**
- ✅ **Checkstyle**
- ✅ **SpotBugs + FindSecurityBugs**
- ✅ **JaCoCo** for code coverage (if configured)

The build will fail if any rule violation or test failure occurs.



---

## 📊 Test Coverage

Code coverage is measured using **JaCoCo**, and can be viewed by running:

```bash
mvn clean verify
```
Then open the following file in your browser:

```
target/site/jacoco/index.html
```
## 📌 License

This project is open for educational use and modification.
