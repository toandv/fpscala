# Programming paradigms

## Imperative Programming 
  
  Imperative programming is about:
  * modifying mutable variables
  * using assignments
  * control structures such as if-then-else, loops, break, continue, return

  The most common informal way to understand imperative programs is as instruction sequences for a Von Neuman computer.

  * Mutable varialbes ~= menory cells
  * Variable dereferences ~= load instructions
  * Variable assignments ~= store instructions
  * Control structures ~= jumps

## What is a Theory
  A theory consists of:
  
  * one ore more data types
  * operations on these types
  * laws that describe the relationships between values and operations

  Normally, a theory does not describle mutations, meaning changing a thing while keeping its identity the same.

## Consequences for Programming 
  If we want to implemnt high-level concepts following their mathematical theories, there's no place for mutation:
  * The theories do not admint it
  * Mutation can destroy useful laws in theories 
  
  Therefore, let's
  * concentrate on defining theories for operators expressed as funtions
  * avoid mutations,
  * have powerful ways to abstract and compose functions

## Functional Programming
  * In a restricted sense, a FP language is one which does not have variables, assignments, or imperative control structures
  * In a wider sense, a FP language enables the constructions of elegant programs that focus on functions
  * Functions are first-class citizens  


