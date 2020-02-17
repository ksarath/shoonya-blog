---
id: algebraic_structure
title:  "Algebraic Structure"
---

**What is an Algebraic Structure?**

According to Wikipedia
```
In mathematics, and more specifically in abstract algebra, 
an algebraic structure on a set A (called carrier set or underlying set) is a collection of finitary operations on A; 
the set A with this structure is also called an algebra.
```

***Examples***

Monad, Functor, Monoid, Applicative etc

***Why Algebraic Structures***

You might have heard about Software design patterns. According to Wikipedia

```
Design patterns not a finished design that can be transformed directly into source or machine code. 
It is a description or template for how to solve a problem that can be used in many different situations.
```

Like design patterns, algebraic structures also represent templates for solving a problem. 
Unlike design patterns though, algebraic structures have their base in mathematics.
This means that they tend to be more formally defined and more general. 

Algebraic structures have specific laws that they must conform to.
These laws helps us make deductions and assumptions about how the code works. 
And that in turn allows us to make optimisations and refactor code safely.

1. Algebraic structures help us in the same way all other abstractions help us. 
They hide some detail so we can think clearly about the bigger picture. 
2. Algebraic structures are based in mathematics. 
We can make that math do work for us. 
The specifications include laws — mathematical laws. 
We can take advantage of those laws to make the computer derive code for us. 
Compilers can use those laws to optimise our code. 
And do so with mathematical certainty (precision) that we’ll still get the same result.

Write once. Run in a bunch of different scenarios. That’s the promise of algebraic structures. 
Need a function to run even if we might have to deal with null? Stick it in a Maybe. 
Need a function that works with a value that we don’t have yet? No problem, stick it in a Future. 
Need precise control over when side-effects happen? The same code will work in an Effect too. 
Plus ‘free’ performance optimisations and other pre-written code. 
Algebraic structures make all this possible.

***Summary***

Algebraic Structures are a bit like code design patterns. 
Unlike design patterns though, they have a mathematical basis and are inter-related. 
Hence why they’re called ‘algebraic’. 

***Reference (Original Post)***

[James Sinclair - ALGEBRAIC STRUCTURES: THINGS I WISH SOMEONE HAD EXPLAINED ABOUT FUNCTIONAL PROGRAMMING](https://jrsinclair.com/articles/2019/algebraic-structures-what-i-wish-someone-had-explained-about-functional-programming/)
