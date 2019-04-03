// Andrew McGowan
//      Sci-fi UI for OOP
//                 

package ie.tudublin;

import processing.core.*;

public class UI extends PApplet
{
    PImage img;
    PImage person, people, settings, power, location;

    Button b;
    MovingCircle mc;
    Radar radar, radar1, radar2;
    Radar radar00, radar11, radar22;

    float t, r;
    Sphere sphere = new Sphere(80, 20 * radians(t += (TWO_PI / 360)));


    boolean[] keys = new boolean[1024]; 

    //Arc Details
    int AX = width / 2;
    int AY = height / 2;
    int rad = 300;
    int ang1 = 1;
    int ang2 = 1;

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = true;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }


    public void settings()
    {
        fullScreen(P3D, SPAN);

        img = loadImage("circle.png");
        people = loadImage("people.png");
        person = loadImage("person.png");
        location = loadImage("location.png");
        settings = loadImage("settings.png");
        power = loadImage("power.png");
    }

    public void setup()
    {
        //b = new Button(this, 50, 50, 100, 50, "I am a button");
        //mc = new MovingCircle(this, width / 2, height / 2, 50);
        radar = new Radar(this, width / 22, 640, 100);
        radar1 = new Radar(this, width / 22, 765, 100);
        radar2 = new Radar(this, width / 22, 890, 100);
        
        // Sphere
        t = 0;
        r = 300;
    }

    public void draw()
    {
        background(0);
        image(img, width / 3 + 155, height / 4 + 55, 970, 970);
    
        //PURPLE
        stroke(255, 0, 255);
        radar.update();
        radar.render();

        //YELLOW
        stroke(255, 255, 0);
        radar1.update();
        radar1.render();

        //RED
        stroke(255, 0, 0);
        radar2.update();
        radar2.render();

        // Hover
        
        /*if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }*/

        soldiers();
        buttons();
        console();
        drawLeftMid();
        drawArc();
        topRight();
        drawGrid();
        //drawRing();
        drawSphere();
        // Areas
    }

    public void soldiers()
    {
        float lenI = 100;
        
        //Soldier 1
        fill(255, 0, 255);
        stroke(255, 0, 255);
        ellipse(3000, 860, 120, 120);
            image(person, 2950, 815, lenI, lenI);

        //Soldier 2

        fill(255, 255, 0);
        stroke(255, 255, 0);
        ellipse(3000, 1060, 120, 120);
            image(person, 2950, 1015, lenI, lenI);
        

        //Soldier 3

        fill(255, 50, 50);
        stroke(255, 55, 55);
        ellipse(3000, 1260, 120, 120);
            image(person, 2950, 1215, lenI, lenI);
    
    }

    public void buttons()
    {
        float lenX = 100;
        float lenY = 60;

        fill(255);
        stroke(0, 255, 255);

        rect(770, 75, lenX, lenY, 10);
        rect(900, 75, lenX, lenY, 10);
        rect(1030, 75, lenX, lenY, 10);
        rect(1160, 75, lenX, lenY, 10);
        rect(1290, 75, lenX, lenY, 10);

        // Icons
        image(power, 795, 80, 50, 50);
        image(person, 925, 80, 50, 50);
        image(people, 1055, 80, 50, 50);
        image(location, 1185, 80, 50, 50);
        image(settings, 1315, 80, 50, 50);
        

    }

    public void console()
    {
        float wid1 = width / 22 - 50;
        float wid2 = width / 22 + 50f;

        float disX = 300;
        float disY = height / 8 * 6f + 250;
        
        
    // PURPLE RADAR
        if(mouseX >= wid1 && mouseX <= wid2 && mouseY >= 590 && mouseY <= 690 )
        {   
            pushMatrix();
                noFill();
                //ellipse(disX, disY, 130, 130);
                stroke(255, 0, 255);
                radar00 = new Radar(this, disX, disY, 300);
                radar00.render();
            popMatrix();
            
        }
    
    // YELLOW RADAR
        if(mouseX >= wid1 && mouseX <= wid2 && mouseY >= 715 && mouseY <= 815 )
        {   
            pushMatrix();
                noFill();
                //ellipse(disX, disY, 130, 130);
                stroke(255, 255, 0);
                radar11 = new Radar(this, disX, disY, 300);
                radar11.render();
            popMatrix();
        
        }
    
    // RED RADAR
        if(mouseX >= wid1 && mouseX <= wid2 && mouseY >= 840 && mouseY <= 940 )
        {   
            pushMatrix();
                noFill();
                //ellipse(disX, disY, 130, 130);
                stroke(255, 50, 50);
                radar22 = new Radar(this, disX, disY, 300);
                radar22.render();
            popMatrix();
            
        }

        
        
    }


    public void drawLeftMid()
    {
        float frame = 50;
        stroke(255);
        noFill();
        strokeWeight(2);
        rect(frame, height / 4, 700, 450, 15);

        // Three radars
    }


    public void drawArc()
    {
        stroke(255);
        strokeWeight(2);
        smooth();
        noFill();

        ang1 += 1;
        ang2 += 5;
        pushMatrix();
        translate(width / 2 - 50, height / 2 - 50);
            //arc(AX, AY, rad + 500, rad + 500, radians(ang1), radians(ang1+300));
            arc(AX, AY, rad + 600, rad + 200, radians(-ang2), radians(-ang2+150));
            
        popMatrix();
    }

    public void topRight()
    {
        pushMatrix();
            translate(width - (width / 8), height / 6);

            noFill();
            stroke(0, 255, 255);
            strokeWeight(2);
            polygon(6, 0, 0, 300);

            stroke(255);
            strokeWeight(0.5f);
            polygon(6, 0, 0, 200);
            polygon(6, 0, 0, 250);
            polygon(6, 0, 0, 150);

        popMatrix();

        // Attributes

        stroke(255);
        textSize(30);
        text("Strength", 3130, 75);
        text("Power", 3480, 75);
        text("Speed", 2950, 370);
        text("Sight", 3670, 370);
        text("Balance", 3130, 670);
        text("Agility", 3480, 670);
    }

    void polygon(int n, float cx, float cy, float r) {
        float angle = 360.0f / n;
      
        beginShape();
        for (int i = 0; i < n; i++) {
          vertex(cx + r * cos(radians(angle * i)),
            cy + r * sin(radians(angle * i)));
        }
        endShape(CLOSE);
      }

    public void drawGrid()
    {
        float frame = 20;
        float bigF = 80;
        float angleD = 50;
        float fractW = width / 5;
        float fractH = height / 5;

        float radius = 20;
        fill(255);

        stroke(255, 255, 255); //255-0-255 when finished 
        strokeWeight(2f);
        
        // Top Left

            ellipse(width / 6, height / 5, radius, radius);
        line(width / 6, height / 5, frame * 2, height / 5);
        line(frame * 2, height / 5, frame, height / 5 - frame);
        line(frame, height / 5 - frame, frame, frame * 2);
        line(frame, frame * 2, frame * 2, frame);
        line(frame * 2, frame, width / 6, frame);
        line(width / 6, frame, width / 6 + frame, frame * 2);
        line(width / 6 + frame, frame * 2, width / 6 + frame + angleD, frame * 2);
        line(width / 6 + frame + angleD, frame * 2, width / 6 + frame * 2 + angleD, frame);
        line(width / 6 + frame * 2 + angleD, frame, width / 2, frame);
        line(width / 2, frame, width / 2 + bigF / 2, frame + bigF / 2);
            ellipse(width / 2 + bigF / 2, frame + bigF / 2, radius, radius);
        

        // Top Right
        
            ellipse(fractW * 4 - (angleD / 2), frame + angleD / 2, radius, radius);
        line(fractW * 4 - (angleD / 2), frame + angleD / 2, fractW * 4, frame);
        line(fractW * 4, frame, width - (frame + angleD), frame);
        line(width - (frame + angleD), frame, width - frame, frame + angleD);
        line(width - frame, frame + angleD, width - frame, fractH);
        line(width - frame, fractH, width - (frame + angleD / 2), fractH + angleD / 2);
            ellipse(width - (frame + angleD / 2), fractH + angleD / 2, radius, radius);

        //Bottom Left

            ellipse(frame + angleD / 2, height - (height / 4) - angleD / 2, radius, radius);
        line(frame + angleD / 2, height - (height / 4) - angleD / 2, frame, height - (height / 4));
        line(frame, height - (height / 4), frame, height - frame);
        line(frame, height - frame, width / 3 - bigF, height - frame);
        line(width / 3 - bigF, height - frame, (width / 3 - bigF) + angleD / 2, (height - frame) - angleD / 2);
            ellipse((width / 3 - bigF) + angleD / 2, (height - frame) - angleD / 2, radius, radius);

                // Grid for Console
                noFill();
                stroke(0, 255, 255);
                strokeWeight(2);
                    textSize(40);
                    text("Console", angleD * 10, height / 8 * 6 - 5);
                        rect(angleD, height / 8 * 6, width / 3 - 150, 490, 10);
                stroke(255);
                strokeWeight(2);
                fill(255);

        // Bottom Right

            ellipse(width - bigF, height / 3, radius, radius);
        line(width - bigF, height / 3, width - bigF, height / 3 + bigF);
        line(width - bigF, height / 3 + bigF, width - frame, height / 3 + bigF +60);
        line(width - frame, height / 3 + bigF +60, width - frame, height / 10 * 9);
        line(width - frame, height / 10 * 9 , width - 60, height - bigF / 2 - 10);
        line(width - 60, height - bigF / 2 -10, width - 80,height - bigF / 2 -10 );
        line(width - 80,height - bigF / 2 -10, width - bigF - 30, height - frame);
        line(width - bigF - 30, height - frame, width - (width / 5), height - frame);
        line(width - (width / 5), height - frame, width / 5 * 4, height - frame);
        line(width / 5 * 4, height - frame, width / 5 * 4 - (bigF / 2), height - frame - bigF / 2);
        line(width / 5 * 4 - (bigF / 2), height - frame - bigF / 2, width / 5 * 4 - (bigF / 2 ) - (bigF * 2) ,height - frame - bigF / 2);
        line(width / 5 * 4 - (bigF / 2 ) - (bigF * 2) ,height - frame - bigF / 2, width / 5 * 4 - (bigF / 2 ) - (bigF * 2) - bigF /2, height - frame);
        line(width / 5 * 4 - (bigF / 2 ) - (bigF * 2) - bigF /2, height - frame, width / 2, height - frame);
            ellipse(width / 2, height - frame, radius, radius);
    }

    public void drawSphere()
    {
        float rotateX = 20 * radians(t += (TWO_PI / 360));

        translate(width / 2, height / 2);
        rotateY(rotateX);
        noFill();
        stroke(0, 255, 255);
        strokeWeight(1f);
        sphere(r);
    }

    /*public void drawRing()
    {
        pushMatrix();
        float h = height / 2;
        float w = width / 2;
        
        stroke(0, 255, 255);
        noFill();
        strokeWeight(2);
        ellipse(w, h, 300, 300);
        popMatrix();
    }*/

    
}

