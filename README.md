# Battleship vs Computer (Java Console Game)

A console-based Battleship game written in Java where you place your ships on a 7×7 grid and battle against a computer opponent. You both take turns guessing coordinates, and the first to sink all of the opponent’s ship spaces wins.

---

## Overview

This project implements a simplified Battleship game:

- The game is played on a **7×7 grid**.
- There are **5 ships per side**:
  - Carrier – occupies 1 space  
  - Battleship – occupies 1 space  
  - Cruiser – occupies 2 adjacent spaces  
  - Submarine – occupies 2 adjacent spaces  
  - Destroyer – occupies 1 space
- You **manually place** your ships; the computer’s ships are placed **randomly**.
- Ships are represented internally by integers and shown on text-based maps with symbols.

You then take turns with the computer:

- You guess coordinates on the computer’s board.
- The computer guesses coordinates on your board.
- Hits and misses are tracked on separate **guess maps**, and the game ends when all 7 ship spaces for one side have been hit.

---

## Features

- **Manual ship placement for the player**
  - You place each ship by entering **row** and **column** coordinates.
  - The Cruiser and Submarine use **two adjacent cells** (horizontal or vertical).
  - Input is validated so you:
    - Stay within `0–6` for rows and columns.
    - Don’t overlap ships.
    - Don’t reuse occupied spaces.

- **Randomized ship placement for the computer**
  - The `placeShips` method:
    - Places 3 single-cell ships.
    - Places 2 two-cell ships (Cruiser and Submarine) horizontally or vertically if space allows.
  - Ensures no overlapping ships and no placements off the board.

- **Turn-based combat**
  - Each turn:
    1. You enter row and column guesses (`0–6`).
    2. The game validates that you’re not:
       - Out of range.
       - Reusing a previous guess.
    3. The game checks your guess on the computer’s ship map.
       - Hit → mark with `X` and increment your hit count.
       - Miss → mark with `0`.
    4. The computer then makes a random guess on your board.
       - Avoids repeating previous guesses.
       - Hit/miss logic mirrors the user’s.

- **Multiple maps**
  - `map1`: Computer’s ships (and hit/miss updates).
  - `map2`: Your ships.
  - `map3`: Your guess map (what you’ve tried on the computer).
  - `map4`: Computer’s guess map (what the computer has tried on you).

- **Symbol representation**
  - `~` – empty water (no ship / no hit yet)
  - `S` – ship cell
  - `X` – hit on a ship
  - `0` – miss (shot at water and missed)

- **Win detection**
  - Each ship cell is represented internally with value `4`.
  - Each hit is tracked by changing `4 → 2` and incrementing hit counters.
  - Once a player has **7 successful hits** (7 ship spaces), the game ends:
    - Displays both final boards.
    - Prints a message announcing the winner.
    - Shows how many ship spaces were hit on each side.

---

## Project Structure

All logic lives in a single class:

### `RohanBattleshipWithComputer.java`

Main fields:

- `map1` – computer’s ship map (7×7 `int` array)
- `map2` – user’s ship map
- `map3` – user’s guess map (against computer)
- `map4` – computer’s guess map (against user)

Key methods:

- `public static void main(String[] args)`
  - Creates maps and variables (ship positions, counters, guesses).
  - Calls `placeShips(map1)` to place computer ships.
  - Prints welcome + disclaimer.
  - Asks for **name** and **age**, enforcing minimum age 7.
  - Calls `generalRules()` to print detailed rules.
  - Guides you through **manual placement** of all 5 ships:
    - Carrier, Battleship, Cruiser (2 cells), Submarine (2 cells), Destroyer.
  - Enters the main **game loop**, where:
    - User and computer alternate turns.
    - Maps are printed at each stage.
    - Hits and misses update the maps.
    - `checkGameOver` is called after each round.

- `placeShips(int[][] map)`
  - Randomly places the computer’s 5 ships on the map:
    - 3 single-cell ships.
    - 2 two-cell ships (Cruiser and Submarine) in horizontal or vertical adjacent cells.
  - Ensures no overlap and no going out of bounds.

- `generalRules()`
  - Prints:
    - Game objective.
    - Ship sizes and how many spaces they occupy.
    - Ship placement rules (adjacency, no overlap).
    - Turn order (user then computer).
    - Coordinate format and symbol legend.
    - How to win (sink all 5 ships / 7 spaces).

- `mapPrint(int[][] map)`
  - Prints any given 7×7 map with labels.
  - Uses the following mapping:
    - `0` or `1` → `~` (water)
    - `2` → `X` (hit)
    - `3` → `0` (miss)
    - `4` → `S` (ship)

- `checkGameOver(int userShipCount, int computerShipCount, int[][] map1, int[][] map2, String userName)`
  - Checks if either side has hit **7 ship spaces**.
  - If the computer has all 7 of your spaces:
    - Prints both boards after the battle.
    - Announces the computer’s victory.
    - Shows how many spaces each side hit.
  - If you hit all 7 of the computer’s spaces:
    - Prints both boards after the battle.
    - Congratulates you by name.
    - Shows how many spaces each side hit.
  - Returns `true` if the game is over; otherwise `false`.

---

## How to Run

1. **Install Java**

   Make sure you have a Java JDK (e.g., Java 8 or later) installed.

2. **Compile the program**

   ```bash
   javac RohanBattleshipWithComputer.java
