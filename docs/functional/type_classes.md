---
id: type_classes
title:  "Type Classes"
---

***Type Classes Vs Algebraic Structures***
ypeT classes are used to implement algebraic structures. 
They’re a language feature, rather than a mathematical concept.

***Type Class***
Type classes are a way of doing polymorphism. 
And they happen to be most convenient for building algebraic structures.

A map type signature in Haskell
```haskell
-- Type signature of map for arrays/lists.
map :: (a -> b) -> [a] -> [b]

-- Type signature of map for Maybe
map :: (a -> b) -> Maybe a -> Maybe b
```
Two different type signatures. Because the types are different, Haskell’s compiler can figure out which map to call. 
It can look at the arguments, figure out their types, and call the correct version. 
And so the two versions of map can exist side-by-side (polymorphism).

Languages with this feature use it to create algebraic structures. 
We can say, for example, “I’m going to create a new instance of Functor. Here’s its map function.” 
In code, it might look like this:
```haskell
instance Functor List where
    map :: (a -> b) -> [a] -> [b]
    map f xs = foldl (\x arr -> arr ++ [f x]) [] xs
```
And we could declare Maybe a functor too:
```haskell
instance Functor Maybe where
    map :: (a -> b) -> Maybe a -> Maybe b
    map f (Just a) = Just f a
    map _ Nothing  = Nothing
```

We can define different versions of map for different types. 
This language feature is built into Haskell. 
And it let us declare a name for these *things-that-can-be-mapped*. In this case, Functor.

Languages providing this feature call this *thing-you-can-create-an-instance-of*, a type class. 
And type classes are often used to create algebraic structures.
What type classes do is enable a specific kind of polymorphism. 
That is, they let us use the same ‘function’ with different types. 
Even if we don’t know up front what those types might be. 
And that happens to be a convenient way to define algebraic structures.

How do we declare a new type class? In Haskell, the definition for functor looks something like this
```Haskell
class Functor f where
    map :: (a -> b) -> f a -> f b
```
This code says we’re creating a new type class called ‘Functor’. 
And we use the shortcut 'f' to refer to it in type definitions. 
For something to qualify as a functor, it must have a map function. 
And that map function must follow the given type signature. 
That is, map takes two parameters. 
The first is a function that takes something of type a and returns something of type b. 
The second is a functor of type f with something of type a ‘inside’ it. 
Given these, map must return another functor of the same type f with something of type b ‘inside’ it.

Here’s a shorter way to say it: This is a type class called functor. 
It has a map function. It does what you’d expect map to do.

The important thing to understand is that it’s about polymorphism. 
This particular kind is called parametric polymorphism. 
Type classes let us have many functions with the same name. 
That is, so long as those functions handle different types. 
In practice, it allows us to think of all those map functions as if it were one single function. 
And the Functor definition makes sure that they all do logically similar tasks.