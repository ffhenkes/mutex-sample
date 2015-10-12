## Simple Mutual Exclusion Java Sample

This program is built to demonstrate the behaviour of mutual exclusion in java language.

 It is composed by a Mutex class that extends Thread and have some methods:

 * critical - Represents the critical area where the threads could exist at the same time.

 * busy - Evaluate the thread execution and add a random integer to an non occupied position called the orbital.

 * run - Loop to 100 launching the threads.

 * main - Create an array of Mutex with a size of two and initialize and start the program.