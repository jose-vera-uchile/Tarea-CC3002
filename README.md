<!-- 1.0.3-b1 -->
# 99.7% Citric Liquid

Base code for CC3002's *99.7% Citric Juice* Project.

The project consists in creating a (simplified) clone of the game **100% Orange Juice**
developed by [Orange_Juice](http://daidai.moo.jp) and distributed by 
[Fruitbat Factory](https://fruitbatfactory.com).

This project contains three main packages corresponding to each part of the document 
with the especifications (parts 1.1, 1.2 and 1.3).

- Board: For the board we defined an Interface for the panels and then an AbstractClass with
the methods in common between the different panels. After that we created a class for each type of
panel, and defined the method ActivatedBy corresponding to the action of each panel. There are some
which were left empty due to the battle part not being implemented yet.
- Normas: For the normas, we used an interface which only contains a method to check if the 
condition for the norma clear were met. Then we created a class for each method to get a 
norma clear and specified the actions for the method.
- Unidades: Finally, for the units we used an interface that unifies the behaviour of every unit
and an abstract class to specify the behaviour of each method. After this, we created the 
Player Class which contains the method exclusives to the playable characters (normas and 
win count). And then created the class for the wild and boss units. These are basically empty, 
since the behaviour is almost fully covered in the abstract Class, and the only thing that could
differ is the battle mechanics.

The things that are left to do are the battle implementation and the cards. After that we should
have all the classes to start working on the controller and the view.


Notes:
I didn't have time to do the tests, I'm sorry for that. The only thing in the tests part of the code
are the ones included in the original template. I'm writing this to save some time of the aux,
it's not necessary to check that.

In another note, I said we not because i worked with someone else on this project, I'm used 
to writing using the plural of the first person, sorry if that's confusing

