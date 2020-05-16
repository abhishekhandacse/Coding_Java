#!/bin/bash

javac -d . Generate_array.java
javac -d . Second_Largest_Number.java
for((i=1;i<=100;i++));do
  echo $i
  # Genreate the array with random seed
  java stress_testing.Generate_array $i
  # Input the generated array into BruteForce and optimized solution to check diff
  java stress_testing.Second_Largest_Number
  # Check the difference in the output of both the solutions and break when one of them deviates form other
  diff -w out1.txt out2.txt || break
done
