---
id: algebraic_data_types
title:  "Algebraic Data Types"
---

**What is an Algebraic Data Type?**

An algebraic data type is a structured type that’s formed by composing other types. 
Or, even shorter, it’s a type made of other types. 

***Product Types***

Product types allow you to have more than one value in a single structure, at the same time.
Why do we call them product types? It’s all about the possibilities.
We can calculate the number of possible values using multiplication.

***Sum Types***

Sum types are types where your value must be one of a fixed set of options. 
You may have seen enum types in languages like C# or Java. 
Sum types are similar, but more flexible. 

The Either is a sum type which can hold a Left or Right value, but never both at the same time.
And it has functions that behave differently depending on which side the data lies. 
If we map over a Left, it does nothing. 
If we map over a Right, then we get a new Right with a (potentially) different value.

What’s interesting here is that we can put any data we want in Either. 
We can put an array or an object (or whatever) in the Left or Right slots. 
So you might be wondering how this is any different from product types. 
And the difference is that with Either, the data must be inside either Left or Right. 
So, the data is always ‘tagged’ with a piece of information, encoded into the type. 
What the tag means is entirely up to us. 
For example, with Either, we might use the Left side to represent errors. 
If the data is inside Left, something has failed. 
If we’ve got a Right, then we’re still on the happy path. 
But they’re called Left and Right for a reason. 
We don’t have to make Left represent errors. 
It might represent something else. 
For example, we might decide that Right represents ‘logged in’. 
And the Left represents ‘unauthenticated.’ It’s entirely up to us what we use Either for.

So, Either has two possible tags: Left or Right. 
But there’s no reason we can’t create a type that has more tags. 
For example, we could have a type that models directions for a game. 
We might create tags for North, South, East, and West. 
Or, in a front-end application we might define states for a UI widget loaded via network request. 
It might have states like Loading, Display, and LoadingError.

That’s all fine. But why are they called sum types? 
Well, if the value can only be one of a fixed set of options, then we count the possible values using addition. 
For example, booleans are a sum type. 
They can be either true or false. 
Not both at the same time. 
And we count the values by addition 1 + 1 = 2.

***Summary***

Algebraic data types are not the same as algebraic structures. 
What are they? They’re composite data types made out of other types. 
There’s two main kinds of algebraic data types: Sum types and Product types. 
Together, they’re like a dynamic duo for encoding business logic. 
They help us make good things possible, and bad things impossible.

***Reference (Original Post)***

[James Sinclair - ALGEBRAIC DATA TYPES: THINGS I WISH SOMEONE HAD EXPLAINED ABOUT FUNCTIONAL PROGRAMMING](https://jrsinclair.com/articles/2019/algebraic-data-types-what-i-wish-someone-had-explained-about-functional-programming/)
