# Post-Reimaging Software Checker

A simple Java program that runs a PowerShell script to get all Windows programs (as listed in Control Panel, so it omits extra programs not typically seen by the end user).

The list is then sorted using a List and output, along with the total count.

Useful for quickly getting a text list of all installed software on a computer

## Motivation

I was tasked to reimage my workplace's computers in the Spring of 2022. It was my first time ever leading this project, and while it was successful, there was a lot of post-imaging testing to be done, which could take about 10 - 20 minutes per computer. 

When it came time to upgrade our computers to Windows 11 in 2024, I thought - "why not try to automate this?"

I could have probably written this program in Python or PowerShell, but I've been trying to improve my Java skills. All my knowledge in Java up to this point was limited to homework assignments. This project really helped me to better understand Java classes, constructors, and get/set methods.

## Features

- The program runs as part of a Post-Reimaging Checker I created (featured in another repo).
- Once executed, the program runs a PowerShell script to grab all software installed on the current PC. The software is exported into a Java list to be printed alphabetically
- A separate class hosts a master list of software that should be installed on the computer. The currently installed software is checked against the master list, and any missing software is printed out
- The program saves the results to a .txt file, titled with the hostname, for easy analysis of results

## Quick Start

Simply run the .jar file using ```java -jar CheckSoftware```

## Usage

- Can be run by exporting to a .jar file
- I created a separate batch script (not shown) so this program could be run from a USB drive

## Things I Would Change
If I was to start this project over, instead of hardcoding the list of software into the "Software" class, I would have developed the program to read the software list from an external file.
