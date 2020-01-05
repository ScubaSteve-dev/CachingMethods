# CachingMethods
See "CacheMethodsNoFluff.docx" for Program run Examples.
Read Me:
How to Run Program:
1.	Install Eclipse and Java SDK 12
2.	Uzip ProgramSrcFiles
3.	Create New Project in Eclipse
4.	Copy Unziped source files to Project and click run.

About Program:
Program simulates how different Caching methods take place within processor. Simulates Simple, 2 way associative, 3 way associative, 4 way associative, and fully associative caching.
How Program functions:
Program Prints "Number of cache blocks?: "    Asking the question: How Many Block Address locations does this cache have. The Block Address entered by user will be modulus divided by this number for direct, two-way, and four-way associative. Cache memory blocks are initialized with -1 to symbolize null or “nothing” there, this acts as a “dirty” bit. 
"Set associativity option : 1 for Simple, 2 for 2/way associative, 3 for 3/way associative, 4 for 4/way associative, 5 for fully associative, -1 to end program". If the user enters a character by mistake, the program will perform exception handling and give the user another chance to enter. If the user enters a number besides those listed here, the program will default to fully associative. 
Next program will display the selected cache method: eg "Two Way Associative Cache Selected:" . The program will then ask the user for a series of inputs to be terminated with -1. Eg "Block Address ["+cacheInput+"] entered, Input another Block Address, or -1 when done"   . Valid inputs will be displayed so that the user may confirm them, invalid input will prompt the program to ask for a valid input. An input of “-1” will terminate the looping query of inputs. Once the Cache input query loop is terminated, program will print Cache table, and reset eg 
