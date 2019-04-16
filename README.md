# SciFi UI Project

Name: Andrew McGowan

Student Number: C16470866

Youtube link: 

# Description of the assignment

My User Interface is a Sci-Fi control panel. My idea came from Prometheus, when they go down to a desolate planet and 3 people stay up in the ship monitoring them. 
Mine is slightely different as it is 3 people, on different parts of the planet. 

# Instructions & How it works
To UI is very simple to use. Simply hover over the 3 idividuals for their information. To make contact with them simply hold down the 'space bar' after clicking on their icons. The icon will change when you click on their icon. 
The buttons on the top are to either communicate with 1 person or 3 people. The second last icon is to show you the location of each individual on the planet. The settings button resets everything.

# What I am most proud of in the assignment
What I am most proud about is the how I went about the project. Instead of trying to do it all in the space of 2 weeks I set myself a goal to make sure i work on it evry week and keep adding things to it. It gave me a chance to also think of new things and meant i was not worrying about getting it finished in time as I had the bulk of the assignment done with about a week or so to go. I am proud of many parts of the assignment but I feel my organisation and how I went about it really was my most proud aspect. My commits only date back a month ago when really I was working on it before hand and then we were sent a repo to fork and use for our projects.

# Markdown Tutorial

## CSV File
- The CSV file I used is Attributes.csv, whish contained the level of strengh etc. of the soldiers.
- The class Attributes.java is where get the details and get their values as local variables.
- In UI.java I load the table into an aray list called "attributes". I load and print the details in the same function ( void loadTable() ).

## Interactive ( Buttons )
- There are 8 buttons in my UI
![An image](images/buttons.PNG)
- Person Icon = Communicate with one person
- People Icon = Communicate with all three people
- Location Icon = Show where they are on the planet 
- Settings Icon - Reset Buttons
![An image](images/buttons2.PNG)
- When you click one of these 3 frames you begin to communicate with that one person
```Java
 // IN DRAW
 if(COLOR_W == 1)
        {
            fill(255, 0, 255);
            stroke(255, 0, 255);
            ellipse(530, 1500, 120,120);
            image(person, 470, 1440, 120,120);
            noFill();
        }

public void mousePressed()
{
        if(mouseX > 900 && mouseX < 1000 && mouseY > 75 && mouseY < 135)
        {
            COLOR_W = 1;
        }
}
```
I used a global variable 'int COLOR_W' which was then used in an if statement to make the given changes. 

## Interactive ( Floating )
![An image](images/float.PNG)
- When tou float over the frames on the right / midde you will get the attributes and details of each solider.

## PVectors
- Below is the code I used for the heart beat monitor. I have a global variable for this PVector.
- It is coded to change at certain X distances. When it hits that x distance its y will change.
```Java
 stroke(0, 255, 0);
 fill(0, 255, 0);
 ellipse(h1.x, h1.y, radius, radius);
        if(heart == 0)
        {
            h1.x += 6;
        }
        if(h1.x > 3300 && h1.x < 3340)
        {
            h1.y -= 9;
        }
        if(h1.x > 3340 && h1.x < 3420)
        {
            h1.y +=9;
        }
        if(h1.x > 3420 && h1.x < 3465)
        {
            h1.y -= 9;
        }
        if(h1.x > 3640)
        {
            h1.x = 3090;
        }
```
## Transforms
- Below is one of many examples of popMatrix and pushMatrix
- This was used for the main Planet for the location of the soldiers on the planet
- I used translate so that their location would rotate as if they were on the surface of the planet
```Java
float rotateX = 20 * radians(t += (TWO_PI / 360));
        pushMatrix();

            translate(width / 2, height / 2);
            rotateY(rotateX);
            noFill();
            stroke(0, 255, 255);
            strokeWeight(1f);
            sphere(r);

            // Soldier Locations on planet
            fill(255, 0, 0);
            stroke(255, 0, 0);
            translate(r - 80, r - 100);
            sphere(m);

            fill(255, 0, 255);
            stroke(255, 0, 255);
            translate(70 , -250);
            sphere(m);

            fill(255, 255, 0);
            stroke(255, 255, 0);
            translate(- 585, 70);
            sphere(m);

        popMatrix();
```
## Polymorphism
- Sun was created as child of Sphere
```Java
public class Sun extends Sphere
{

    Sun(float s, float r)
    {
        super(s, r);
    }

    void update()
    {
        //change in size
        sphereSize = 50;
        rotate = 20 * radians(t += (TWO_PI / 360));
        rotateY(rotate);
        sphere(sphereSize);
    }
}
```
## Abstract Classes

## Interfaces
