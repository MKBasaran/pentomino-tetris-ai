# Pentomino Tetris AI 🎮

## Overview  
This project is a **Tetris-style game** built using **Java**, featuring **Pentomino shapes** instead of traditional Tetriminoes.  
It includes a **graphical user interface (GUI)**, a **high-score tracking system**, and an **AI bot** that plays the game autonomously.

## Features  
✔️ **Fully Playable Game:** Drop and rotate Pentomino pieces in a 5x15 grid.  
✔️ **AI Bot:** Uses heuristics to optimize piece placement.  
✔️ **High Score System:** Keeps track of the best runs.  
✔️ **Piece Order Optimization:** Identifies an ideal piece sequence for maximizing the score.  
✔️ **Collision Detection & Line Clearing:** Implements classic Tetris mechanics with Pentominoes.  

## Installation & Running  

### **1️⃣ Clone the Repository**  
git clone https://github.com/MKBasaran/pentomino-tetris-ai.git

cd pentomino-tetris-ai

### **2️⃣ Compile the Code
javac -d bin src/*.java  

### **3️⃣ Run the Program
java -cp bin Main

## AI Strategy  
- The AI bot evaluates **column heights, line clear potential, and future piece impact**.  
- Implements **greedy heuristics** to optimize each move.  

## Technologies Used  
- 🟡 **Java** (No external libraries)  
- 🟡 **Swing** (For GUI elements)  
- 🟡 **Backtracking & Heuristic Algorithms** (For AI decision-making)  

## Contributors  
👤 **Kaan Basaran**  
👤 **Nikita Souslau**  
👤 **Vasil Raychev**  
👤 **Luca Nichifor**  
👤 **Théo Massignan**  
👤 **Matteo Cannata**  
👤 **Kennedy Fernandes**  
