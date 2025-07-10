# Tic Tac Toe (Console Version)

This is a simple **Tic Tac Toe** game implemented in **Java**, playable via the **console**, supporting both human players and AI opponents with three difficulty levels.

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
- Any IDE (e.g. IntelliJ IDEA) or terminal that supports compiling and running Java

---

## 🚀 Running the Game

Compile and run the `Main` class (or entry point of your program).  
A menu will appear in the console to start and manage games.

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

## 📌 License

This project is open for educational use and modification.
