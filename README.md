# Paging-Technique-Simulation

Overview
This repository contains a Java-based implementation of three page replacement algorithms: FIFO (First-In-First-Out), LRU (Least Recently Used), and Optimal. It includes both a command-line interface (CLI) and a graphical user interface (GUI) to simulate and visualize the behavior of these algorithms. The program is designed to help understand how different page replacement strategies work and to analyze their performance in terms of page faults.

Features
Frame Size Input: Allows users to specify the number of frames available in memory.

Page Sequence Input: Users can input a sequence of page references to simulate.

Algorithm Selection: Supports three page replacement algorithms: FIFO, LRU, and Optimal.

Simulation Output: Displays the content of frames after each page reference and the total number of page faults.

Graphical User Interface: A user-friendly GUI to input data and visualize the simulation results.

Getting Started

Prerequisites

Java Development Kit (JDK) 8 or higher

An Integrated Development Environment (IDE) such as IntelliJ IDEA, Eclipse, or NetBeans

Open the project in your preferred IDE.

Compile and run the CLI:
Navigate to the Paging.java file and run it as a Java application.

Compile and run the GUI:
Navigate to the PagingGUI.java file and run it as a Java application.

Usage
Command-Line Interface (CLI)

Run the program:
Execute Paging.java.

Input the required data:

Enter the frame size.

Enter the page sequence as a comma-separated list.

Enter the replacement algorithm (FIFO, LRU, Optimal).

View the output:

The program will display the frame contents after each page reference and the total number of page faults.

Graphical User Interface (GUI)
Run the program:
Execute PagingGUI.java.

Input the required data:

Enter the frame size in the designated text field.

Enter the page sequence as a comma-separated list.

Enter the replacement algorithm (FIFO, LRU, Optimal).

Simulate the algorithm:

Click the "Simulate" button to run the simulation.

View the output:
The results, including the total number of page faults, will be displayed in the result area.

Code Structure
Paging.java: Contains the core logic for simulating the page replacement algorithms.

PagingGUI.java: Implements the graphical user interface for the simulation.

README.md: This file, providing detailed information about the project.

Explanation of Code

Paging.java
Attributes:
frameSize: The number of frames available in memory.

pageSequence: The sequence of pages to be referenced.

frames: A list representing the current pages in the frames.

algorithm: The page replacement algorithm to be used.

pageFaults: The count of page faults during the simulation.

Constructor: Initializes the frame size, page sequence, algorithm, frames list, and page faults count.

simulatePaging: Determines which algorithm to use based on user input and calls the corresponding simulation method.

simulateFIFO: Implements the FIFO page replacement algorithm using a queue to track the order of pages.

simulateLRU: Implements the LRU page replacement algorithm using a list to track the least recently used pages.

simulateOptimal: Implements the Optimal page replacement algorithm by predicting future page references to decide which page to replace.

findOptimalPageToReplace: Helper method to find the page to replace in the Optimal algorithm by looking ahead in the page sequence.

displayFrames: Displays the current state of the frames.

getPageFaults: Returns the total number of page faults.

PagingGUI.java

Swing Components: Uses JLabel, JTextField, JButton, JTextArea, and JScrollPane to create the GUI.

ActionListener: Responds to the "Simulate" button click, reads user inputs, and displays the simulation results.

Usage of Java in Operating System Paging Techniques
Java is used to simulate the paging techniques as it provides a robust, platform-independent environment for building simulations and visualizations. The concepts of paging in operating systems involve managing how pages are loaded into frames in memory. This simulation helps in understanding how different algorithms manage memory and handle page faults.

FIFO (First-In-First-Out): Replaces the oldest page in memory. Implemented using a queue in Java.

LRU (Least Recently Used): Replaces the page that hasn't been used for the longest time. Implemented using a list in Java.

Optimal: Replaces the page that will not be used for the longest period in the future. Requires predicting future page references, implemented with a helper method in Java.

Example
Here is an example of how to run the CLI:

Enter frame size: 3

Enter page sequence (comma-separated): 1, 3, 0, 3, 5, 6, 3

Enter replacement algorithm (FIFO, LRU, Optimal): LRU

Frames: [1, -1, -1]
Frames: [1, 3, -1]
Frames: [1, 3, 0]
Frames: [1, 3, 0]
Frames: [5, 3, 0]
Frames: [5, 6, 0]
Frames: [5, 6, 3]
Total Page Faults: 6
