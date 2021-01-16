package summative;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

public class TextAdventure extends Applet implements ActionListener, KeyListener, MouseListener {

    Timer timer;
    String sceneID;

    //pictures
    Image house1;
    Image basement1;
    Image basement2;
    Image stairs1;
    Image temple_entrance;
    Image chest_end;
    Image hallway1;
    Image diamond;
    Image room1;
    Image emerald;
    Image room1_door;
    Image hallway2;
    Image hallway3;
    Image sword;
    Image trap1;
    Image monkey;
    Image room2;
    Image hallway4;
    Image waterfall;
    Image rope1;
    Image rope2;
    Image rope3;
    Image snake;
    Image rope_pit;
    Image rope_puzzle_door;
    Image decoder_out;
    Image decoder_in;
    Image torch;
    Image hanging_skeleton;
    Image tablet;
    Image door;
    Image pit_climb;
    Image lever;
    Image pit_end;
    Image golem;

    AudioClip punch_attack;
    AudioClip sword_attack;
    AudioClip heal;
    AudioClip stun;

    Random rand;

    boolean spaceKey;
    boolean spaceSwitch;
    boolean fade;
    boolean hasChoice;
    boolean mouseHold;
    boolean startTrap;

    boolean inMenu;
    ArrayList<Integer> titleLetters = new ArrayList();
    int animationDelay;
    int maxDelay;
    double torchAngle;
    int rulesLetterCounter;
    int letterAmount;

    boolean hasTorch;
    boolean hasEmerald;
    boolean hasSword;
    boolean hasTotem;
    boolean hasTablet;
    boolean hasCrown;

    int skeletonHealth;
    int golemHealth;
    int playerHealth;
    int turnDelay;
    int specialCountdown;
    String turn;
    String message;
    String job;
    boolean stunned;

    int runCount;
    int runTimer;

    boolean goneMiddle;
    boolean d1;
    boolean d2;

    int mouseX;
    int mouseY;
    int alpha;
    int diamonds;
    double decoderAngle;
    boolean keyLeft;
    boolean keyRight;
    boolean checkInput;
    String input;

    public void init() {
        this.setSize(600, 400);

        timer = new Timer(10, this);
        sceneID = "rules";

        spaceKey = false;
        spaceSwitch = true;
        fade = true;
        hasChoice = false;
        mouseHold = false;
        startTrap = false;

        punch_attack = getAudioClip(getDocumentBase(), "Sounds/punch_attack.wav");
        sword_attack = getAudioClip(getDocumentBase(), "Sounds/sword_attack.wav");
        heal = getAudioClip(getDocumentBase(), "Sounds/heal.wav");
        stun = getAudioClip(getDocumentBase(), "Sounds/stun.wav");

        rand = new Random();

        inMenu = true;
        animationDelay = 0;
        maxDelay = 300;
        torchAngle = 0;
        rulesLetterCounter = 0;
        letterAmount = 0;

        //items and artifacts
        hasTorch = false;
        hasEmerald = false;
        hasSword = false;
        hasTotem = false;
        hasTablet = false;
        hasCrown = false;

        skeletonHealth = 50;
        golemHealth = 200;
        playerHealth = 100;
        turnDelay = 0;
        turn = "player";
        message = "";
        job = "fighter";
        specialCountdown = 0;
        stunned = false;

        runCount = 0;
        runTimer = 0;

        goneMiddle = false;
        d1 = true;
        d2 = true;

        mouseX = 0;
        mouseY = 0;
        alpha = 0;
        diamonds = 0;
        
        decoderAngle = 0;
        keyLeft = false;
        keyRight = false;
        checkInput = false;
        input = "";

        house1 = getImage(getDocumentBase(), "Pics/house1.jpg");
        basement1 = getImage(getDocumentBase(), "Pics/basement1.jpg");
        basement2 = getImage(getDocumentBase(), "Pics/basement2.jpg");
        stairs1 = getImage(getDocumentBase(), "Pics/stairs1.jpg");
        temple_entrance = getImage(getDocumentBase(), "Pics/temple_entrance.jpg");
        chest_end = getImage(getDocumentBase(), "Pics/chest_end.jpg");
        hallway1 = getImage(getDocumentBase(), "Pics/hallway1.jpg");
        diamond = getImage(getDocumentBase(), "Pics/diamond.jpg");
        room1 = getImage(getDocumentBase(), "Pics/room1.jpg");
        emerald = getImage(getDocumentBase(), "Pics/emerald1.jpg");
        room1_door = getImage(getDocumentBase(), "Pics/room1_door.jpg");
        hallway2 = getImage(getDocumentBase(), "Pics/hallway2.jpg");
        hallway3 = getImage(getDocumentBase(), "Pics/hallway3.jpg");
        sword = getImage(getDocumentBase(), "Pics/sword.png");
        trap1 = getImage(getDocumentBase(), "Pics/trap1.jpg");
        monkey = getImage(getDocumentBase(), "Pics/monkey.jpg");
        room2 = getImage(getDocumentBase(), "Pics/room2.jpg");
        hallway4 = getImage(getDocumentBase(), "Pics/hallway4.jpg");
        waterfall = getImage(getDocumentBase(), "Pics/waterfall.jpg");
        rope1 = getImage(getDocumentBase(), "Pics/rope1.jpg");
        rope2 = getImage(getDocumentBase(), "Pics/rope2.jpg");
        rope3 = getImage(getDocumentBase(), "Pics/rope3.jpg");
        snake = getImage(getDocumentBase(), "Pics/snake.jpg");
        rope_pit = getImage(getDocumentBase(), "Pics/rope_pit.jpg");
        rope_puzzle_door = getImage(getDocumentBase(), "Pics/rope_puzzle_door.jpg");
        decoder_out = getImage(getDocumentBase(), "Pics/decoder_out.png");
        decoder_in = getImage(getDocumentBase(), "Pics/decoder_in.png");
        torch = getImage(getDocumentBase(), "Pics/torch.jpg");
        hanging_skeleton = getImage(getDocumentBase(), "Pics/hanging_skeleton.jpg");
        tablet = getImage(getDocumentBase(), "Pics/tablet.jpg");
        door = getImage(getDocumentBase(), "Pics/door.jpg");
        pit_climb = getImage(getDocumentBase(), "Pics/pit_climb.jpg");
        lever = getImage(getDocumentBase(), "Pics/lever.jpg");
        pit_end = getImage(getDocumentBase(), "Pics/pit_end.jpg");
        golem = getImage(getDocumentBase(), "Pics/golem.jpg");

        addKeyListener(this);
        addMouseListener(this);
    }
    public void reset()//resets the game
    {
        sceneID = "rules";
        spaceKey = false;
        spaceSwitch = true;
        fade = true;
        hasChoice = false;
        mouseHold = false;
        startTrap = false;
        inMenu = true;
        animationDelay = 0;
        maxDelay = 300;
        torchAngle = 0;
        rulesLetterCounter = 0;
        letterAmount = 0;
        hasTorch = false;
        hasEmerald = false;
        hasSword = false;
        hasTotem = false;
        hasTablet = false;
        hasCrown = false;
        skeletonHealth = 50;
        golemHealth = 200;
        playerHealth = 100;
        turnDelay = 0;
        turn = "player";
        message = "";
        job = "fighter";
        specialCountdown = 0;
        stunned = false;
        runCount = 0;
        runTimer = 0;
        goneMiddle = false;
        d1 = true;
        d2 = true;
        mouseX = 0;
        mouseY = 0;
        alpha = 0;
        diamonds = 0;
        decoderAngle = 0;
        keyLeft = false;
        keyRight = false;
        checkInput = false;
        input = "";
    }

    public void stop() {
        timer.stop();
    }

    public void start() {
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        //checking for space key
        //only if not in fade sequence or if scene has a choice
        if (spaceKey && !fade && !hasChoice) {
            switchScene(sceneID);
            spaceKey = false;
            fade = true;
            alpha = 0;
        }
        
        //fade in scene text
        if (fade) {
            if (alpha >= 254) {
                fade = false;
            } else {
                alpha += 2;
            }
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (inMenu) {
            g.setColor(Color.white);
            g.fillRect(0, 0, 600, 400);
            String charList = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String startTitle = "HOME OF SECRETS";
            String newTitle = "";

            if (titleLetters.size() < 15) {
                //randomizes the title
                for (int i = 0; i < startTitle.length(); i++) {
                    if (startTitle.toCharArray()[i] == ' ') {
                        newTitle += " ";
                    } else {
                        if (titleLetters.contains(i)) {
                            newTitle += startTitle.toCharArray()[i];
                        } else {
                            newTitle += charList.charAt(rand.nextInt(charList.length()));
                        }
                    }
                }

                if (animationDelay == maxDelay) {
                    while (true) {
                        int toAdd = rand.nextInt(startTitle.length());
                        if (!titleLetters.contains(toAdd)) {
                            titleLetters.add(toAdd);
                            break;
                        }
                        if (titleLetters.size() == startTitle.length()) {
                            break;
                        }
                    }
                    animationDelay = 0;
                    maxDelay -= 15;
                } else {
                    animationDelay++;
                }
            } else {//when all letters are displayed
                newTitle = "HOME OF SECRETS";
                g2d.rotate(Math.toRadians(torchAngle), 37, 173);
                g2d.drawImage(torch, 0, -20, 50, 200, this);
                g2d.rotate(-Math.toRadians(torchAngle), 37, 173);

                g2d.rotate(-Math.toRadians(torchAngle), 561, 173);
                g2d.drawImage(torch, 600, -20, -50, 200, this);
                g2d.rotate(Math.toRadians(torchAngle), 561, 173);

                //changing angle
                if (torchAngle < 60) {
                    torchAngle += 0.1;
                } else {//when torches are in place, go to menu
                    g.setColor(Color.black);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.drawString("Start Game", 230, 300);
                    Polygon start = new Polygon();
                    start.addPoint(230, 300);
                    start.addPoint(380, 300);
                    start.addPoint(380, 280);
                    start.addPoint(230, 280);
                    if (start.contains(mouseX, mouseY)) {
                        inMenu = false;
                    }
                }
            }

            //splitting up the string
            String word1 = newTitle.split(" ")[0];
            String word2 = newTitle.split(" ")[1];
            String word3 = newTitle.split(" ")[2];
            //drawing strings
            g.setFont(new Font("TimesRoman", Font.BOLD, 60));
            g.setColor(Color.black);
            g.drawString(String.valueOf(word1.charAt(0)), 200, 100);
            g.drawString(String.valueOf(word1.charAt(1)), 245, 100);
            g.drawString(String.valueOf(word1.charAt(2)), 290, 100);
            if (titleLetters.contains(3)) {
                g.drawString(String.valueOf(word1.charAt(3)), 350, 100);
            } else {
                g.drawString(String.valueOf(word1.charAt(3)), 335, 100);
            }

            g.drawString(String.valueOf(word2.charAt(0)), 250, 150);
            g.drawString(String.valueOf(word2.charAt(1)), 300, 150);
            g.setColor(Color.red);
            g.setFont(new Font("TimesRoman", Font.BOLD, 100));
            if (titleLetters.contains(8)) {
                g.drawString(String.valueOf(word3.charAt(0)), 70, 250);
            } else {
                g.drawString(String.valueOf(word3.charAt(0)), 60, 250);
            }
            g.drawString(String.valueOf(word3.charAt(1)), 125, 250);
            g.drawString(String.valueOf(word3.charAt(2)), 185, 250);
            g.drawString(String.valueOf(word3.charAt(3)), 255, 250);
            g.drawString(String.valueOf(word3.charAt(4)), 330, 250);
            g.drawString(String.valueOf(word3.charAt(5)), 395, 250);
            g.drawString(String.valueOf(word3.charAt(6)), 460, 250);
        } else {
            switch (sceneID) {
                case "rules":
                    g.setColor(Color.blue);
                    g.fillRect(0, 0, 600, 400);
                    g.setColor(Color.orange);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 100));
                    g.drawString("RULES", 125, 80);

                    String rule1 = "To navigate the scenes press the space key, or if there is a choice, use your mouse.";
                    String rule2 = "Some scenes will have minigames you will have to complete.";
                    String rule3 = "There is also 5 diamonds and a few artifacts that you can choose to find.";
                    String rule4 = "There are multiple possible endings, some are good, some are bad.";
                    String rule5 = "Select a job to start (this will only affect you in battles)";
                    String rule6 = "(Doctors can heal themselves, and fighters can do a very strong attack)";

                    //draw words in increments
                    rulesLetterCounter++;
                    if (rulesLetterCounter % 50 == 0) {
                        letterAmount = rulesLetterCounter / 50;
                    }

                    g.setFont(new Font("TimesRoman", Font.BOLD, 15));
                    if (letterAmount > rule1.length()) {
                        g.drawString(rule1.substring(0, rule1.length()), 20, 130);
                    } else {
                        g.drawString(rule1.substring(0, letterAmount), 20, 130);
                    }
                    if (letterAmount > rule2.length()) {
                        g.drawString(rule2.substring(0, rule2.length()), 20, 150);
                    } else {
                        g.drawString(rule2.substring(0, letterAmount), 20, 150);
                    }
                    if (letterAmount > rule3.length()) {
                        g.drawString(rule3.substring(0, rule3.length()), 20, 170);
                    } else {
                        g.drawString(rule3.substring(0, letterAmount), 20, 170);
                    }
                    if (letterAmount > rule4.length()) {
                        g.drawString(rule4.substring(0, rule4.length()), 20, 190);
                    } else {
                        g.drawString(rule4.substring(0, letterAmount), 20, 190);
                    }
                    if (letterAmount > rule5.length()) {
                        g.drawString(rule5.substring(0, rule5.length()), 20, 210);
                    } else {
                        g.drawString(rule5.substring(0, letterAmount), 20, 210);
                    }
                    if (letterAmount > rule6.length()) {
                        g.drawString(rule6.substring(0, rule6.length()), 20, 230);
                    } else {
                        g.drawString(rule6.substring(0, letterAmount), 20, 230);
                    }

                    g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                    g.drawString("Doctor", 100, 350);
                    g.drawString("Fighter", 400, 350);

                    Rectangle doctor = new Rectangle(100, 330, g.getFontMetrics().stringWidth("Doctor"), 20);
                    Rectangle fighter = new Rectangle(400, 330, g.getFontMetrics().stringWidth("Fighter"), 20);

                    if (doctor.contains(mouseX, mouseY)) {
                        job = "doctor";
                        sceneID = "house1";
                    }
                    if (fighter.contains(mouseX, mouseY)) {
                        job = "fighter";
                        sceneID = "house1";
                    }
                    break;
                case "house1":
                    g.drawImage(house1, 0, 0, 600, 400, this);
                    drawText("One morning, you wake up in your house and decide to clean out the basement.  You have not been down there in years, so you decide it would be a good idea.", Color.black, g);
                    break;
                case "basement1":
                    g.drawImage(basement1, 0, 0, 600, 400, this);
                    drawText("A few hours later, you decide to take a break.  Then, you notice a stack of boxes placed against the wall.  You are curious why they are there, so you get up and move them.", Color.black, g);
                    break;
                case "basement2":
                    hasChoice = true;
                    g.drawImage(basement2, 0, 0, 600, 400, this);
                    drawText("Behind the boxes, you find an old, rusty door.  Your basement does not connect to the outside, so you wonder where it leads to.", Color.black, g);

                    Polygon choice1_1 = new Polygon();
                    choice1_1.addPoint(0, 350);
                    choice1_1.addPoint(0, 400);
                    choice1_1.addPoint(175, 400);
                    choice1_1.addPoint(175, 350);
                    Polygon choice1_2 = new Polygon();
                    choice1_2.addPoint(425, 350);
                    choice1_2.addPoint(600, 350);
                    choice1_2.addPoint(600, 400);
                    choice1_2.addPoint(425, 400);

                    g.setColor(Color.black);
                    g.fillPolygon(choice1_1);
                    g.fillPolygon(choice1_2);
                    g.setColor(Color.lightGray);
                    g.fillRect(5, 355, 165, 40);
                    g.fillRect(430, 355, 165, 40);

                    g.setColor(Color.blue);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 14));
                    g.drawString("Open the door", 38, 378);
                    g.drawString("Leave", 497, 378);

                    //checking for choice
                    if (choice1_1.contains(mouseX, mouseY) && !fade) {
                        sceneID = "stairs1";
                        hasChoice = false;
                        fade = true;
                        alpha = 0;
                    }

                    if (choice1_2.contains(mouseX, mouseY) && !fade) {
                        sceneID = "leave_end";
                        hasChoice = false;
                        fade = true;
                        alpha = 0;
                    }
                    break;
                case "leave_end":
                    g.drawImage(house1, 0, 0, 600, 400, this);
                    drawText("Deciding to not open the door, you go back upstairs and continue your regular life.  You will never know what was behind that door.", Color.black, g);
                    break;
                case "stairs1":
                    g.drawImage(stairs1, 0, 0, 600, 400, this);
                    drawText("You open the door, and find a set of stairs leading downwards.  Wanting to know what is under your house, you climb down the stairs.", Color.black, g);
                    break;
                case "temple_entrance1":
                    g.drawImage(temple_entrance, 0, 0, 600, 400, this);
                    drawText("At the bottom of the stairs, the walls are made of what looks like old stone.  That's when you realize this must be an ancient temple!  You decide to explore the temple to see if you can find any artifacts or treasure.", Color.black, g);
                    break;
                case "temple_entrance2":
                    hasChoice = true;
                    g.drawImage(temple_entrance, 0, 0, 600, 400, this);
                    drawText("To your left, there is a small treasure chest.  To your right, there is a gloomy hallway lit by torches.  In front of you, there are stairs that you think lead deeper into the temple.  Where do you choose to go?", Color.black, g);

                    Polygon choice2_1 = new Polygon();
                    choice2_1.addPoint(0, 350);
                    choice2_1.addPoint(0, 400);
                    choice2_1.addPoint(175, 400);
                    choice2_1.addPoint(175, 350);
                    Polygon choice2_2 = new Polygon();
                    choice2_2.addPoint(210, 350);
                    choice2_2.addPoint(210, 400);
                    choice2_2.addPoint(385, 400);
                    choice2_2.addPoint(385, 350);
                    Polygon choice2_3 = new Polygon();
                    choice2_3.addPoint(425, 350);
                    choice2_3.addPoint(600, 350);
                    choice2_3.addPoint(600, 400);
                    choice2_3.addPoint(425, 400);

                    g.setColor(Color.black);
                    g.fillPolygon(choice2_1);
                    g.fillPolygon(choice2_2);
                    g.fillPolygon(choice2_3);
                    g.setColor(Color.lightGray);
                    g.fillRect(5, 355, 165, 40);
                    g.fillRect(215, 355, 165, 40);
                    g.fillRect(430, 355, 165, 40);

                    g.setColor(Color.blue);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 14));
                    g.drawString("Open the chest", 38, 378);
                    g.drawString("Go down the stairs", 240, 378);
                    g.drawString("Go to the right", 468, 378);

                    //checking for choice
                    if (choice2_1.contains(mouseX, mouseY) && !fade) {//the chest
                        sceneID = "chest_end";
                        hasChoice = false;
                        fade = true;
                        alpha = 0;
                    }
                    if (choice2_2.contains(mouseX, mouseY) && !fade) {
                        sceneID = "trap1";
                        hasChoice = false;
                        fade = true;
                        alpha = 0;
                    }
                    if (choice2_3.contains(mouseX, mouseY) && !fade) {
                        sceneID = "hallway1";
                        hasChoice = false;
                        fade = true;
                        alpha = 0;
                    }
                    break;
                case "chest_end":
                    g.drawImage(chest_end, 0, 0, 600, 400, this);
                    drawText("You walk over to the small chest against the wall.  You open it, expecting it to be full of treasure.  The second you open it, you find yourself falling through a trapdoor.", Color.black, g);
                    break;
                case "hallway1":
                    g.drawImage(hallway1, 0, 0, 600, 400, this);
                    hasTorch = true;
                    drawText("You turn to your right and enter the gloomy hallway.  As you pass by, you grab one of the torches from the wall.  Then, you notice something shiny on the ground...", Color.black, g);
                    break;
                case "diamond1":
                    g.drawImage(diamond, 0, 0, 600, 400, this);
                    drawText("Its a diamond!  You are suprised to see it down here, so you pick it up and put it in your pocket.  You wonder if there are another others in this temple.", Color.black, g);
                    break;
                case "room1":
                    hasChoice = true;
                    g.drawImage(room1, 0, 0, 600, 400, this);
                    drawText("You continue to walk forward, and soon you find yourself in a small room.  To your left, there is a little pool of water in the corner.  Inside of the pool there is a shiny green rock.  To your right, there is a rotting wooden door covered in moss.  What do you choose to do?", Color.black, g);

                    Polygon choice3_1 = new Polygon();
                    choice3_1.addPoint(0, 350);
                    choice3_1.addPoint(0, 400);
                    choice3_1.addPoint(175, 400);
                    choice3_1.addPoint(175, 350);
                    Polygon choice3_2 = new Polygon();
                    choice3_2.addPoint(425, 350);
                    choice3_2.addPoint(600, 350);
                    choice3_2.addPoint(600, 400);
                    choice3_2.addPoint(425, 400);

                    g.setColor(Color.black);
                    g.fillPolygon(choice3_1);
                    g.fillPolygon(choice3_2);
                    g.setColor(Color.lightGray);
                    g.fillRect(5, 355, 165, 40);
                    g.fillRect(430, 355, 165, 40);

                    g.setColor(Color.blue);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 14));
                    g.drawString("Open the door", 38, 378);
                    g.drawString("Pick up the emerald", 450, 378);

                    //checking for choice
                    if (choice3_1.contains(mouseX, mouseY) && !fade) {
                        sceneID = "room1_door";
                        hasChoice = false;
                        fade = true;
                        alpha = 0;
                    }

                    if (choice3_2.contains(mouseX, mouseY) && !fade) {
                        sceneID = "emerald1";
                        hasChoice = false;
                        fade = true;
                        alpha = 0;
                    }
                    break;
                case "emerald1":
                    g.drawImage(emerald, 0, 0, 600, 400, this);
                    hasEmerald = true;
                    drawText("You reach into the pool and pull out the emerald.  It's lighter then you expected.  You shrug and put the emerald into your pocket.", Color.black, g);
                    break;
                case "room1_door":
                    g.drawImage(room1_door, 0, 0, 600, 400, this);
                    drawText("You walk over to the door and try to open it.  Seems as if it is stuck.  You decide to burn it down with your torch.", Color.black, g);
                    break;
                case "hallway2":
                    g.drawImage(hallway2, 0, 0, 600, 400, this);
                    drawText("After the fire has burnt out, you find yourself in a long corridor.  You think that you can see a treasure chest at the end of it.  You begin to carefully walk towards it.", Color.black, g);
                    break;
                case "hallway3":
                    hasChoice = true;
                    g.drawImage(hallway3, 0, 100, 600, 300, this);
                    drawText("As you walk down the corridor, a skeleton steps in front of the chest.  You back up, surprised to see this monster.  Before you can think too much about it, the skeleton starts creeping towards you.  There is a hole you could squeeze through to your right, or you can fight the monster.  What do you choose?", Color.black, g);

                    Polygon choice4_1 = new Polygon();
                    choice4_1.addPoint(0, 350);
                    choice4_1.addPoint(0, 400);
                    choice4_1.addPoint(175, 400);
                    choice4_1.addPoint(175, 350);
                    Polygon choice4_2 = new Polygon();
                    choice4_2.addPoint(425, 350);
                    choice4_2.addPoint(600, 350);
                    choice4_2.addPoint(600, 400);
                    choice4_2.addPoint(425, 400);

                    g.setColor(Color.black);
                    g.fillPolygon(choice4_1);
                    g.fillPolygon(choice4_2);
                    g.setColor(Color.lightGray);
                    g.fillRect(5, 355, 165, 40);
                    g.fillRect(430, 355, 165, 40);

                    g.setColor(Color.blue);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 14));
                    g.drawString("Fight", 65, 378);
                    g.drawString("Flee", 500, 378);

                    //checking for choice
                    if (choice4_1.contains(mouseX, mouseY) && !fade) {
                        sceneID = "skeleton_battle";
                        hasChoice = false;
                        fade = true;
                        alpha = 0;
                    }

                    if (choice4_2.contains(mouseX, mouseY) && !fade) {
                        sceneID = "hole1";
                        hasChoice = false;
                        fade = true;
                        alpha = 0;
                    }
                    break;
                case "skeleton_battle": //battle
                    g.drawImage(hallway3, 0, 0, 600, 400, this);

                    //creating action buttons
                    g.setColor(Color.lightGray);
                    g.fillRect(0, 300, 600, 100);//back
                    g.setColor(Color.white);
                    g.fillRect(0, 0, 600, 20);//message area
                    g.setColor(Color.black);
                    g.drawRect(0, 300, 600, 100);//back border
                    g.drawRect(0, 0, 600, 20);//message area border
                    g.setColor(Color.gray);
                    Polygon attack = new Polygon();
                    attack.addPoint(10, 310);
                    attack.addPoint(100, 310);
                    attack.addPoint(100, 390);
                    attack.addPoint(10, 390);
                    g.fillPolygon(attack);
                    Polygon special = new Polygon();
                    special.addPoint(120, 310);
                    special.addPoint(210, 310);
                    special.addPoint(210, 390);
                    special.addPoint(120, 390);
                    if (specialCountdown > 0) {
                        g.setColor(Color.DARK_GRAY);
                    }
                    g.fillPolygon(special);
                    g.setColor(Color.gray);
                    Polygon flee = new Polygon();
                    flee.addPoint(230, 310);
                    flee.addPoint(320, 310);
                    flee.addPoint(320, 390);
                    flee.addPoint(230, 390);
                    g.fillPolygon(flee);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 19));
                    g.setColor(Color.cyan);
                    g.drawString("Attack", 28, 355);
                    g.drawString("Special", 135, 355);
                    g.drawString("Flee", 258, 355);

                    //lifebars
                    drawPlayerLifeBar(g, playerHealth);
                    drawMonsterLifeBar(g, skeletonHealth, 50);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 13));
                    g.setColor(Color.darkGray);
                    g.drawString("You:", 345, 327);
                    g.drawString("Monster:", 330, 372);

                    //Fight Logic
                    if (turn.equals("player")) {
                        if (playerHealth <= 0) {//player dead
                            sceneID = "skeleton_lose";
                        } else //fight still going
                        {
                            if (turnDelay == 700) {
                                if (attack.contains(mouseX, mouseY)) {
                                    int damage = rand.nextInt(3) + 4;
                                    skeletonHealth -= damage;
                                    punch_attack.play();
                                    message = "You punched the skeleton.  You dealt " + Integer.toString(damage) + " damage!";
                                    turn = "monster";
                                    turnDelay = 0;
                                    specialCountdown--;
                                }
                                if (special.contains(mouseX, mouseY) && specialCountdown <= 0) {//depends on job
                                    switch (job) {
                                        case "doctor":
                                            heal.play();
                                            playerHealth += 20;
                                            if (playerHealth > 100) {
                                                playerHealth = 100;
                                            }
                                            message = "You healed yourself for 20 health!";
                                            break;
                                        case "fighter":
                                            skeletonHealth -= 20;
                                            punch_attack.play();
                                            message = "You dealt 20 damage to the skeleton";
                                            break;
                                    }
                                    turn = "monster";
                                    turnDelay = 0;
                                    specialCountdown = 5;
                                }
                                if (flee.contains(mouseX, mouseY)) {
                                    sceneID = "skeleton_flee";
                                }
                            } else {
                                turnDelay++;
                                g.setFont(new Font("TimesRoman", Font.BOLD, 13));
                                g.setColor(Color.red);
                                g.drawString(message, 5, 14);
                            }
                        }
                    } else {//monster turn
                        if (skeletonHealth <= 0) {//monster dead
                            sceneID = "skeleton_win";
                        } else {
                            if (turnDelay == 700) {
                                int rngAction = rand.nextInt(4);

                                if (rngAction == 1) {//heal
                                    skeletonHealth += 5;
                                    heal.play();
                                    message = "The skeleton healed itself for 5 health!";
                                } else {//attack
                                    int damage = rand.nextInt(4) + 5;
                                    playerHealth -= damage;
                                    punch_attack.play();
                                    message = "The skeleton attacked you.  It dealt " + Integer.toString(damage) + " damage!";
                                }
                                turn = "player";
                                turnDelay = 0;
                            } else {
                                turnDelay++;
                                g.setFont(new Font("TimesRoman", Font.BOLD, 13));
                                g.setColor(Color.red);
                                g.drawString(message, 5, 14);
                            }
                        }
                    }
                    break;
                case "skeleton_lose":
                    g.drawImage(hallway3, 0, 0, 600, 400, this);
                    drawText("The skeleton kills you after you collapse from exhaustion.", Color.black, g);
                    break;
                case "skeleton_flee":
                    g.drawImage(hallway3, 0, 0, 600, 400, this);
                    drawText("Deciding that you can not win this fight, you jump away from the skeleton.  You find that the hole is still to your right.  You quickly dive into the hole.", Color.black, g);
                    break;
                case "skeleton_win":
                    g.drawImage(hallway3, 0, 0, 600, 400, this);
                    drawText("The skeleton breaks apart into lifeless bones and falls onto the ground.  You walk past its remains and towards the chest.", Color.black, g);
                    break;
                case "sword_chest":
                    g.drawImage(sword, 0, 0, 600, 400, this);
                    hasSword = true;
                    drawText("In the chest you find a sword!  It will come in handy if you come across any more monsters.  You also find another diamond!  You then squeeze through the hole, since it is the only way to go.", Color.black, g);
                    break;
                case "hole1":
                    g.drawImage(temple_entrance, 0, 0, 600, 400, this);
                    drawText("When you go through the hole, you find out it is actually a slide.  After many twists and turns in pitch dark, it drops you into a familiar room.  It's the temple entrance!  You decide to go down the stairs in front of you.", Color.black, g);
                    break;
                case "trap1":
                    g.drawImage(trap1, 0, 0, 600, 400, this);
                    drawText("You find yourself in a long, narrow room when suddenly, the door slams shut, trapping you inside.  Then, spikes pop out of the ceiling, which is now slowly dropping down!  Luckily, you see a door on the other side of the room.  You quickly start to sprint to the other side.  Click to run faster!", Color.black, g);

                    if(mouseX != 0 && mouseY != 0){
                        startTrap = true;
                    }
                    
                    if(startTrap){
                        if (runTimer == 7000) {
                            if (runCount >= 20) {
                                sceneID = "trap1_escape";
                            } else {
                                System.out.println("failed");
                                sceneID = "trap1_end";
                            }
                        } else {
                            runTimer++;
                        }
                    }
                    System.out.println(runTimer);
                    break;
                case "trap1_end":
                    g.drawImage(trap1, 0, 0, 600, 400, this);
                    drawText("You are impaled by the spikes before you get to the door, you died.", Color.black, g);
                    break;
                case "trap1_escape":
                    g.drawImage(trap1, 0, 0, 600, 400, this);
                    drawText("Just as the spikes are about to kill you, you dive through the doorway.  You painfully pull yourself off the ground, to find your self face-to-face with a monkey.", Color.black, g);
                    break;
                case "monkey1":
                    g.drawImage(monkey, 0, 0, 600, 400, this);
                    drawText("\"Hi, i'm John McGee! What are you doing here?\" it says.  You back away in surprise, \"You..Yo..You're a talking monkey!\" You exclaim.  \"And what's so weird about that?\" John asks?  You decide not to push it any further.", Color.black, g);
                    break;
                case "monkey2":
                    g.drawImage(monkey, 0, 0, 600, 400, this);
                    hasEmerald = false;
                    hasTotem = true;
                    drawText("\"Hey, is that an emerald in your pocket?\" John asks \"I have been looking for that!\"  \"Can I have it? I'll give you this Ancient Totem!\"  \"Sure!\" you exclaim, excited to find an artifact.  John happily switches the emerald for the totem and then runs away.", Color.black, g);
                    break;
                case "room2":
                    hasChoice = true;
                    g.drawImage(room2, 0, 0, 600, 400, this);
                    drawText("You watch as John runs off and slips through a crack in the wall.  Looking around the room, you see a small hallway to your left, and a waterfall in front of you.  You think there may be something behind the waterfall.  Where do you choose to go?", Color.black, g);

                    Polygon choice5_1 = new Polygon();
                    choice5_1.addPoint(0, 350);
                    choice5_1.addPoint(0, 400);
                    choice5_1.addPoint(175, 400);
                    choice5_1.addPoint(175, 350);
                    Polygon choice5_2 = new Polygon();
                    choice5_2.addPoint(425, 350);
                    choice5_2.addPoint(600, 350);
                    choice5_2.addPoint(600, 400);
                    choice5_2.addPoint(425, 400);

                    g.setColor(Color.black);
                    g.fillPolygon(choice5_1);
                    g.fillPolygon(choice5_2);
                    g.setColor(Color.lightGray);
                    g.fillRect(5, 355, 165, 40);
                    g.fillRect(430, 355, 165, 40);

                    g.setColor(Color.blue);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 14));
                    g.drawString("Go into the waterfall", 20, 378);
                    g.drawString("Go to the left", 475, 378);

                    //checking for choice
                    if (choice5_1.contains(mouseX, mouseY) && !fade) {
                        sceneID = "waterfall";
                        hasChoice = false;
                        fade = true;
                        alpha = 0;
                    }

                    if (choice5_2.contains(mouseX, mouseY) && !fade) {
                        sceneID = "hallway4";
                        hasChoice = false;
                        fade = true;
                        alpha = 0;
                    }
                    break;
                case "hallway4":
                    g.drawImage(hallway4, 0, 0, 600, 400, this);
                    if (hasTorch) {
                        if (d1) {
                            diamonds++;
                            d1 = false;
                        }
                        drawText("You pull out your torch as you enter the dark hallway.  In the glare of the light, you notice a diamond on the ground!  You continue forward after grabbing it and putting it in your pocket.", Color.black, g);
                    } else {
                        g.setColor(Color.black);
                        g.fillRect(0, 0, 600, 400);
                        drawText("You enter the hallway in complete darkness, you can't even see your own hands!  After a few minutes of tripping over rocks, you finally see the way out.", Color.black, g);
                    }
                    break;
                case "waterfall":
                    g.drawImage(waterfall, 0, 0, 600, 400, this);
                    if (hasTorch) {
                        drawText("You duck under the waterfall, curious to see what is on the other side.  Instead, your face slams into a rock wall.  Unfortunately, your torch has also gone out.  With nowhere else to go, you walk towards the hallway that was to your left.", Color.black, g);
                    } else {
                        drawText("You duck under the waterfall, curious to see what is on the other side.  Instead, your face slams into a rock wall.  With nowhere else to go, you walk towards the hallway that was to your left.", Color.black, g);
                    }
                    break;
                case "rope_puzzle1":
                    hasChoice = true;
                    g.drawImage(rope1, 0, 0, 200, 400, this);
                    g.drawImage(rope2, 200, 0, 200, 400, this);
                    g.drawImage(rope3, 400, 0, 200, 400, this);
                    Rectangle choice6_1 = new Rectangle(1, 0, 200, 400);
                    Rectangle choice6_2 = new Rectangle(200, 0, 200, 400);
                    Rectangle choice6_3 = new Rectangle(400, 0, 200, 400);
                    drawText("You walk into a room with a large pit in the middle of it, and you need to get across it.  On your side of the pit, there are three ropes.  One looks like a vine, another looks ratty and frayed, and the last looks brand new.  Which rope do you choose to use?  Click on the picture of the rope you want to use.", Color.black, g);

                    //checking for choice
                    if (choice6_1.contains(mouseX, mouseY) && !fade) {
                        sceneID = "rope_snake";
                        hasChoice = false;
                        fade = true;
                        alpha = 0;
                    }
                    if (choice6_2.contains(mouseX, mouseY) && !fade) {
                        sceneID = "rope_frayed";
                        hasChoice = false;
                        fade = true;
                        alpha = 0;
                    }
                    if (choice6_3.contains(mouseX, mouseY) && !fade) {
                        sceneID = "rope_new";
                        hasChoice = false;
                        fade = true;
                        alpha = 0;
                    }
                    break;
                case "rope_snake":
                    g.drawImage(snake, 0, 0, 600, 400, this);
                    drawText("You choose to use the vine to swing across.  But, as you go to grab it, the vine starts to move.  Then, it drops onto the ground, and you realize that it is actually a snake!  The snake darts towards you, coiling around you, suffocating you.", Color.black, g);
                    break;
                case "rope_frayed":
                    g.drawImage(rope_pit, 0, 0, 600, 400, this);
                    drawText("You pull on the frayed rope to see if it will hold.  After deciding that it seems fine, you jump towards the rope.  Holding tightly to the rope, you swing across the pit.", Color.black, g);
                    break;
                case "rope_new":
                    g.drawImage(rope_pit, 0, 0, 600, 400, this);
                    drawText("You grab the rope and back up to get a running start.  Suddenly, you slip on a puddle of water and fall backwards, and you don't stop falling.  Turns out there was another pit behind the entire time!", Color.black, g);
                    break;
                case "rope_puzzle_door":
                    hasChoice = true;
                    g.drawImage(rope_puzzle_door, 0, 0, 600, 400, this);
                    drawText("You can see two possible paths for you to follow now.  You can climb down the pit to see if anything is down there, or go through the door in front of you.  The door seems to have some kind of word lock on it.  What do you choose to do?", Color.black, g);

                    Polygon choice7_1 = new Polygon();
                    choice7_1.addPoint(0, 350);
                    choice7_1.addPoint(0, 400);
                    choice7_1.addPoint(175, 400);
                    choice7_1.addPoint(175, 350);
                    Polygon choice7_2 = new Polygon();
                    choice7_2.addPoint(425, 350);
                    choice7_2.addPoint(600, 350);
                    choice7_2.addPoint(600, 400);
                    choice7_2.addPoint(425, 400);

                    g.setColor(Color.black);
                    g.fillPolygon(choice7_1);
                    g.fillPolygon(choice7_2);
                    g.setColor(Color.lightGray);
                    g.fillRect(5, 355, 165, 40);
                    g.fillRect(430, 355, 165, 40);

                    g.setColor(Color.blue);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 14));
                    g.drawString("Climb down the pit", 25, 378);
                    g.drawString("Open the door", 470, 378);

                    //checking for choice
                    if (choice7_1.contains(mouseX, mouseY) && !fade) {
                        sceneID = "pit_climb";
                        hasChoice = false;
                        fade = true;
                        alpha = 0;
                    }
                    if (choice7_2.contains(mouseX, mouseY) && !fade) {
                        sceneID = "door_puzzle";
                        hasChoice = false;
                        fade = true;
                        alpha = 0;
                    }
                    break;
                case "door_puzzle": //word lock
                    g.setColor(Color.lightGray);
                    g.fillRect(0, 0, 600, 400);//background

                    if (keyLeft) {
                        decoderAngle -= 0.2;
                    } else if (keyRight) {
                        decoderAngle += 0.2;
                    }
                    g.drawImage(decoder_out, 0, 25, 350, 350, this);//stays same

                    g2d.rotate(Math.toRadians(decoderAngle), 175, 200);//rotates screen
                    g2d.drawImage(decoder_in, 0, 25, 350, 350, this);//draws rotated decoder
                    g2d.rotate(-Math.toRadians(decoderAngle), 175, 200);//reverses rotation

                    g.setColor(Color.black);
                    g.drawOval(1, 26, 348, 348);
                    g.drawOval(36, 60, 278, 279);

                    g.drawString("Press the left and right arrow", 90, 200);
                    g.drawString("to move the decoder!", 115, 220);

                    g.setColor(Color.yellow);
                    g.fillRect(350, 30, 200, 20);
                    g.setColor(Color.darkGray);
                    g.drawRect(350, 30, 200, 20);//input box

                    g.setColor(Color.black);
                    g.setFont(new Font("Cambria", Font.PLAIN, 10));
                    g.drawString(input.toUpperCase(), 355, 45);

                    g.drawString("By each word there is a pair of letters.", 355, 70);
                    g.drawString("This is what you use to align the decoder.", 355, 85);
                    g.drawString("The words form a question about this game.", 355, 100);
                    g.drawString("Type the answer into the yellow box.", 355, 115);
                    g.drawString("Press enter to submit your answer.", 355, 130);

                    g.setFont(new Font("Cambria", Font.PLAIN, 21));
                    g.drawString("S D W P   M Q I", 390, 170);//what was
                    g.drawString("R F C     Q S R O I C W", 363, 240);//the monkeys
                    g.drawString("K X J B?", 430, 310);//name?

                    g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
                    g.drawString("G=K", 420, 190);
                    g.drawString("Y=I", 510, 190);
                    g.drawString("B=D", 383, 260);
                    g.drawString("P=L", 510, 260);
                    g.drawString("J=M", 450, 330);

                    //exit button
                    g.setColor(Color.white);
                    Rectangle exit = new Rectangle(425, 350, 90, 30);
                    g2d.fill(exit);
                    g.setColor(Color.black);
                    g.drawRect(425, 350, 90, 30);
                    if(exit.contains(mouseX, mouseY)){
                        sceneID = "rope_puzzle_door";
                    }
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                    g.setColor(Color.blue);
                    g.drawString("I Give Up", 430, 370);
                    
                    //checking the input
                    if (checkInput) {
                        if (input.toLowerCase().equals("john mcgee")) {
                            sceneID = "door_puzzle_solved";
                        }
                        checkInput = false;
                    }
                    break;
                case "door_puzzle_solved":
                    hasChoice = true;
                    g.drawImage(door, 0, 0, 200, 400, this);
                    g.drawImage(door, 200, 0, 200, 400, this);
                    g.drawImage(door, 400, 0, 200, 400, this);
                    drawText("You can hear a faint click after you enter to code, followed by the door opening.  Walking into the opening, you find yourself facing three identical doors.  Which door do you choose to go through?", Color.black, g);

                    Polygon choice8_1 = new Polygon();
                    choice8_1.addPoint(0, 350);
                    choice8_1.addPoint(0, 400);
                    choice8_1.addPoint(175, 400);
                    choice8_1.addPoint(175, 350);
                    Polygon choice8_2 = new Polygon();
                    choice8_2.addPoint(210, 350);
                    choice8_2.addPoint(210, 400);
                    choice8_2.addPoint(385, 400);
                    choice8_2.addPoint(385, 350);
                    Polygon choice8_3 = new Polygon();
                    choice8_3.addPoint(425, 350);
                    choice8_3.addPoint(600, 350);
                    choice8_3.addPoint(600, 400);
                    choice8_3.addPoint(425, 400);

                    g.setColor(Color.black);
                    g.fillPolygon(choice8_1);
                    if (!goneMiddle) {
                        g.fillPolygon(choice8_2);
                    }
                    g.fillPolygon(choice8_3);

                    g.setColor(Color.lightGray);
                    g.fillRect(5, 355, 165, 40);
                    if (!goneMiddle) {
                        g.fillRect(215, 355, 165, 40);
                    }
                    g.fillRect(430, 355, 165, 40);

                    g.setColor(Color.blue);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 14));
                    g.drawString("Left", 70, 378);
                    if (!goneMiddle) {
                        g.drawString("Middle", 280, 378);
                    }
                    g.drawString("Right", 500, 378);

                    //checking for choice
                    if (choice8_1.contains(mouseX, mouseY) && !fade) {//the chest
                        sceneID = "door_left";
                        hasChoice = false;
                        fade = true;
                        alpha = 0;
                    }
                    if (!goneMiddle) {
                        if (choice8_2.contains(mouseX, mouseY) && !fade) {
                            sceneID = "door_middle";
                            hasChoice = false;
                            fade = true;
                            alpha = 0;
                        }
                    }
                    if (choice8_3.contains(mouseX, mouseY) && !fade) {
                        sceneID = "door_right";
                        hasChoice = false;
                        fade = true;
                        alpha = 0;
                    }
                    break;
                case "door_left":
                    g.setColor(Color.black);
                    g.fillRect(0, 0, 600, 400);
                    drawText("You open the door to the left and walk inside.  The door slams shut behind you, leaving you in complete darkness.  Suddenly, you feel the floor disappear, dropping you down into a hole.", Color.black, g);
                    break;
                case "door_middle":
                    g.drawImage(hanging_skeleton, 0, 0, 600, 400, this);
                    if (hasSword) {
                        drawText("You open the middle door, and find a skeleton hanging over a pit!  You jump back in surprise, but you accidentally drop your sword into the pit.", Color.black, g);
                    } else {
                        drawText("You open the middle door, and find a skeleton hanging over a pit!  You jump back through the door in surprise.", Color.black, g);
                    }
                    break;
                case "door_right":
                    hasTablet = true;
                    g.drawImage(tablet, 0, 0, 600, 400, this);
                    drawText("You open the door to the right and are forced to cover your eyes from the light.  The room is filled with gold, gems and statues!  At the center of it all, there is a small stone tablet.  Sadly, it is the only thing you can take with you, so you put it in your pocket and leave the room.  You follow your path back to the rope pit and then climb down the pit.", Color.black, g);
                    break;
                case "pit_climb":
                    g.drawImage(pit_climb, 0, 0, 600, 400, this);
                    drawText("After walking around the pit, you find a spot to climb down.  Rock by rock, you slowly climb down the wall.  At one point, you find a diamond lodged into the wall!  After a couple of slips and near misses, you finally reach the bottom.", Color.black, g);
                    break;
                case "pit_levers":
                    hasChoice = true;
                    g.drawImage(lever, 0, 0, 600, 400, this);
                    drawText("At the bottom of the pit you can see the outline of a large door.  When you walk towards the door, torches suddenly spark to life, illuminating the pit.  You can now see that on either side of the door there is a lever.  Which do you choose to pull?", Color.black, g);

                    Polygon choice9_1 = new Polygon();
                    choice9_1.addPoint(0, 350);
                    choice9_1.addPoint(0, 400);
                    choice9_1.addPoint(175, 400);
                    choice9_1.addPoint(175, 350);
                    Polygon choice9_2 = new Polygon();
                    choice9_2.addPoint(425, 350);
                    choice9_2.addPoint(600, 350);
                    choice9_2.addPoint(600, 400);
                    choice9_2.addPoint(425, 400);

                    g.setColor(Color.black);
                    g.fillPolygon(choice9_1);
                    g.fillPolygon(choice9_2);
                    g.setColor(Color.lightGray);
                    g.fillRect(5, 355, 165, 40);
                    g.fillRect(430, 355, 165, 40);

                    g.setColor(Color.blue);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 14));
                    g.drawString("Left lever", 50, 378);
                    g.drawString("Right lever", 475, 378);

                    //checking for choice
                    if (choice9_1.contains(mouseX, mouseY) && !fade) {
                        sceneID = "pit_door";
                        hasChoice = false;
                        fade = true;
                        alpha = 0;
                    }

                    if (choice9_2.contains(mouseX, mouseY) && !fade) {
                        sceneID = "pit_end";
                        hasChoice = false;
                        fade = true;
                        alpha = 0;
                    }
                    break;
                case "pit_end":
                    g.drawImage(pit_end, 0, 0, 600, 400, this);
                    drawText("When you pull the lever, you can hear a very loud, mechanical, grinding sound.  Thats when you notice the floor is moving!  You rush over to the other lever and try to pull it, but it is locked.  Before you can react, the floor has already reached the wall, causing you tumble into oblivion.", Color.black, g);
                    break;
                case "pit_door":
                    g.drawImage(golem, 0, 0, 600, 400, this);
                    drawText("When you pull the lever, the door begins to shake as it opens.  Then you hear a loud 'thump', and then another.  It sounds like giant footsteps!  Then a giant stone golem steps through the door and looks straight at you.  The monster then roars and charges towards you.", Color.black, g);
                    break;
                case "golem_battle":
                    g.drawImage(golem, 0, 0, 600, 400, this);
                    
                    //reset values
                    if(d2){
                        playerHealth = 100;
                        specialCountdown = 0;
                        turn = "player";
                        d2 = false;
                    }
                    
                    //creating action buttons
                    g.setColor(Color.lightGray);
                    g.fillRect(0, 300, 600, 100);//back
                    g.setColor(Color.white);
                    g.fillRect(0, 0, 600, 20);//message area
                    g.setColor(Color.black);
                    g.drawRect(0, 300, 600, 100);//back border
                    g.drawRect(0, 0, 600, 20);//message area border
                    g.setColor(Color.gray);
                    Polygon attack2 = new Polygon();
                    attack2.addPoint(10, 310);
                    attack2.addPoint(100, 310);
                    attack2.addPoint(100, 390);
                    attack2.addPoint(10, 390);
                    g.fillPolygon(attack2);
                    Polygon special2 = new Polygon();
                    special2.addPoint(120, 310);
                    special2.addPoint(210, 310);
                    special2.addPoint(210, 390);
                    special2.addPoint(120, 390);
                    if (specialCountdown > 0 || stunned) {
                        g.setColor(Color.DARK_GRAY);
                    }
                    g.fillPolygon(special2);
                    g.setColor(Color.gray);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 19));
                    g.setColor(Color.cyan);
                    g.drawString("Attack", 28, 355);
                    g.drawString("Special", 135, 355);

                    //lifebars
                    drawPlayerLifeBar(g, playerHealth);
                    drawMonsterLifeBar(g, golemHealth, 200);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 13));
                    g.setColor(Color.darkGray);
                    g.drawString("You:", 345, 327);
                    g.drawString("Monster:", 330, 372);

                    //Fight Logic
                    if (turn.equals("player")) {
                        if (playerHealth <= 0) {//player dead
                            sceneID = "golem_lose";
                        } else //fight still going
                        {
                            if (turnDelay == 700) {
                                if (attack2.contains(mouseX, mouseY)) {
                                    int damage;
                                    if(hasSword)
                                        damage = rand.nextInt(6) + 13;
                                    else
                                        damage = rand.nextInt(4) + 5;
                                    golemHealth -= damage;
                                    
                                    if(hasSword){
                                        message = "You stabbed the golem.  You dealt " + Integer.toString(damage) + " damage!";
                                        sword_attack.play();
                                    }else{
                                        message = "You punched the golem.  You dealt " + Integer.toString(damage) + " damage!";
                                        punch_attack.play();
                                    }
                                    turn = "monster";
                                    turnDelay = 0;
                                    specialCountdown--;
                                    stunned = false;
                                }
                                if (special2.contains(mouseX, mouseY) && specialCountdown <= 0 && !stunned) {//depends on job
                                    switch (job) {
                                        case "doctor":
                                            heal.play();
                                            playerHealth += 20;
                                            if (playerHealth > 100) {
                                                playerHealth = 100;
                                            }
                                            message = "You healed yourself for 20 health!";
                                            break;
                                        case "fighter":
                                            if(hasSword){
                                                golemHealth -= 40;
                                                sword_attack.play();
                                            }else{
                                                golemHealth -= 20;
                                                punch_attack.play();
                                            }
                                            message = "You dealt 20 damage to the golem";
                                            break;
                                    }
                                    turn = "monster";
                                    turnDelay = 0;
                                    specialCountdown = 4;
                                }
                            } else {
                                turnDelay++;
                                g.setFont(new Font("TimesRoman", Font.BOLD, 13));
                                g.setColor(Color.red);
                                g.drawString(message, 5, 14);
                            }
                        }
                    } else {//monster turn
                        if (golemHealth <= 0) {//monster dead
                            sceneID = "golem_win";
                        } else {
                            if (turnDelay == 1000) {
                                int rngAction = rand.nextInt(5);

                                if (rngAction == 0 || rngAction == 1) {//stun
                                    stunned = true;
                                    stun.play();
                                    message = "The golem stunned you with some kind of electric field!  You are unable to use your special!";
                                } else {//attack
                                    int damage = rand.nextInt(4) + 8;
                                    playerHealth -= damage;
                                    punch_attack.play();
                                    message = "The golem attacked you.  It dealt " + Integer.toString(damage) + " damage!";
                                }
                                turn = "player";
                                turnDelay = 0;
                            } else {
                                turnDelay++;
                                g.setFont(new Font("TimesRoman", Font.BOLD, 13));
                                g.setColor(Color.red);
                                g.drawString(message, 5, 14);
                            }
                        }
                    }
                    break;
                case "golem_lose":
                    g.drawImage(golem, 0, 0, 600, 400, this);
                    drawText("With a massive swing of its club, the golem attacks you.  The force causes you to slam into the rock wall of the pit.  You are knocked unconsious by the impact.", Color.black, g);
                    break;
                case "golem_win":
                    hasChoice = true;
                    g.drawImage(golem, 0, 0, 600, 400, this);
                    if(hasSword)
                        drawText("You quickly dodge behind the golem, jump onto its back, and hit it on the head.  With a loud roar, the golem falls to the ground.  Do you let it live, or do you kill it?", Color.black, g);
                    else
                        drawText("You quickly dodge behind the golem, jump onto its back, and stab it.  With a loud roar, the golem falls to the ground.  Do you let it live, or do you kill it?", Color.black, g);
                    
                    Polygon choice10_1 = new Polygon();
                    choice10_1.addPoint(0, 350);
                    choice10_1.addPoint(0, 400);
                    choice10_1.addPoint(175, 400);
                    choice10_1.addPoint(175, 350);
                    Polygon choice10_2 = new Polygon();
                    choice10_2.addPoint(425, 350);
                    choice10_2.addPoint(600, 350);
                    choice10_2.addPoint(600, 400);
                    choice10_2.addPoint(425, 400);

                    g.setColor(Color.black);
                    g.fillPolygon(choice10_1);
                    g.fillPolygon(choice10_2);
                    g.setColor(Color.lightGray);
                    g.fillRect(5, 355, 165, 40);
                    g.fillRect(430, 355, 165, 40);

                    g.setColor(Color.blue);
                    g.setFont(new Font("TimesRoman", Font.BOLD, 14));
                    g.drawString("Kill it", 70, 378);
                    g.drawString("Let it live", 485, 378);

                    //checking for choice
                    if (choice10_1.contains(mouseX, mouseY) && !fade) {
                        sceneID = "golem_kill";
                        diamonds++;
                        hasChoice = false;
                        fade = true;
                        alpha = 0;
                    }

                    if (choice10_2.contains(mouseX, mouseY) && !fade) {
                        sceneID = "golem_live";
                        hasChoice = false;
                        fade = true;
                        alpha = 0;
                    }
                    break;
                case "golem_kill":
                    g.drawImage(golem, 0, 0, 600, 400, this);
                    if(!hasSword)
                        drawText("Deciding to not let this monstrosity live, you quickly grab a sharp rock from the ground.  You then stab it into the golem with all the force you can get.  The golem slumps onto the ground before breaking apart into dust and rocks.  All that is left is a diamond", Color.black, g);
                    else
                        drawText("Deciding to not let this monstrosity live, you stab the golem with your sword.  The golem slumps onto the ground before breaking apart into dust and rocks.  All that is left is a diamond", Color.black, g);
                    break;
                case "golem_live":
                    g.drawImage(golem, 0, 0, 600, 400, this);
                    hasCrown = true;
                    drawText("You back away from the golem, deciding to spare its life.  The golem slowly pulls itself up, looks at you and nods as a thanks.  It then pulls something out of the ground and gives it to you before walking away.  It's a gold crown!", Color.black, g);
                    break;
                case "epilogue":
                    g.drawImage(golem, 0, 0, 600, 400, this);
                    drawText("1 year later:  You are now well-known and respected as the richest person ever.  After you got out of the temple, you sold all of the treasure and made a small fortune.  You now are living a happy, peaceful life in your new mansion.  That is, until you find a trapdoor under your bed! To be continued...", Color.black, g);
                    break;
                case "reset":
                    g.setColor(Color.BLACK);
                    g.fillRect(0, 0, 600, 400);
                    
                    g.setFont(new Font("TimesRoman", Font.BOLD, 60));
                    g.setColor(Color.MAGENTA);
                    g.drawString("END", 220, 50);
                    
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.setColor(Color.cyan);
                    g.drawString("DIAMONDS = " + Integer.toString(diamonds), 20, 100);
                    g.setColor(Color.red);
                    g.drawString("TOTEM = " + (hasTotem ? "Yes" : "No"), 20, 140);
                    g.setColor(Color.green);
                    g.drawString("TABLET = " + (hasTablet ? "Yes" : "No"), 20, 180);
                    g.setColor(Color.yellow);
                    g.drawString("CROWN = " + (hasCrown ? "Yes" : "No"), 20, 220);
                    
                    g.setFont(new Font("TimesRoman", Font.BOLD, 20));
                    g.setColor(Color.BLUE);
                    g.drawString("Would you like to restart?", 20, 270);
                    g.setColor(Color.green);
                    g.drawString("YES", 20, 300);
                    g.setColor(Color.red);
                    g.drawString("NO", 150, 300);
                    
                    Rectangle yes = new Rectangle(20, 280, g.getFontMetrics().stringWidth("YES"), 20);
                    Rectangle no = new Rectangle(150, 280, g.getFontMetrics().stringWidth("NO"), 20);
                    if(yes.contains(mouseX, mouseY)){
                        reset();
                    }
                    if(no.contains(mouseX, mouseY)){
                        System.exit(0);
                    }
                    break;
            }
            mouseX = 0;
            mouseY = 0;
        }
        repaint();
    }

    public void update(Graphics g) { //for double buffering
        Graphics offg;
        Image offscreen;

        // create the offscreen buffer
        offscreen = createImage(600, 400);
        offg = offscreen.getGraphics();

        paint(offg);

        // draw offscreen on window
        g.drawImage(offscreen, 0, 0, this);
    }

    public void drawPlayerLifeBar(Graphics g, double health)//max is 100
    {
        int length = (int) Math.round(health / 100 * 200);
        g.setColor(Color.black);
        g.fillRect(385, 315, 210, 20);
        g.setColor(Color.white);
        g.fillRect(390, 320, 200, 10);
        g.setColor(Color.red);
        g.fillRect(390, 320, length, 10);
    }

    public void drawMonsterLifeBar(Graphics g, int health, double maxHealth) {
        int length = (int) Math.round(health / maxHealth * 200);
        g.setColor(Color.black);
        g.fillRect(385, 360, 210, 20);
        g.setColor(Color.white);
        g.fillRect(390, 365, 200, 10);
        g.setColor(Color.red);
        g.fillRect(390, 365, length, 10);
    }

    public void drawText(String text, Color color, Graphics g) //draws text box
    {
        g.setFont(new Font("TimesRoman", 0, 14));

        g.setColor(new Color(Color.black.getRed(), Color.black.getGreen(), Color.black.getBlue(), alpha));//text box edge
        g.fillRect(0, 0, 600, 100);

        g.setColor(new Color(Color.white.getRed(), Color.white.getGreen(), Color.white.getBlue(), alpha));//text box fill
        g.fillRect(5, 5, 590, 90);

        int lineY = 20;
        int lineX = 8;
        for (String sentence : text.split("  ")) {
            for (String word : sentence.split(" ")) {

                if (word.contains("diamond")) {
                    g.setColor(new Color(Color.cyan.getRed(), Color.cyan.getGreen(), Color.cyan.getBlue(), alpha));
                } else if (word.contains("torch")) {
                    g.setColor(new Color(Color.orange.getRed(), Color.orange.getGreen(), Color.orange.getBlue(), alpha));
                } else if (word.contains("temple")) {
                    g.setColor(new Color(Color.darkGray.getRed(), Color.darkGray.getGreen(), Color.darkGray.getBlue(), alpha));
                } else if (word.contains("emerald")) {
                    g.setColor(new Color(Color.green.getRed(), Color.green.getGreen(), Color.green.getBlue(), alpha));
                } else {
                    g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha));
                }
                g.drawString(word, lineX, lineY);
                lineX += (g.getFontMetrics().stringWidth(word)) + 4;
            }
            lineY += 15;
            lineX = 8;
        }
    }

    public void switchScene(String ID) {
        switch (sceneID) {
            case "house1":
                sceneID = "basement1";
                break;
            case "basement1":
                sceneID = "basement2";
                break;
            case "stairs1":
                sceneID = "temple_entrance1";
                break;
            case "temple_entrance1":
                sceneID = "temple_entrance2";
                break;
            case "leave_end":
                sceneID = "reset";
                break;
            case "chest_end":
                sceneID = "reset";
                break;
            case "hallway1":
                diamonds++;
                sceneID = "diamond1";
                break;
            case "diamond1":
                sceneID = "room1";
                break;
            case "emerald1":
                sceneID = "room1_door";
                break;
            case "room1_door":
                sceneID = "hallway2";
                break;
            case "hallway2":
                sceneID = "hallway3";
                break;
            case "skeleton_lose":
                sceneID = "reset";
                break;
            case "skeleton_flee":
                sceneID = "hole1";
                break;
            case "skeleton_win":
                sceneID = "sword_chest";
                diamonds++;
                break;
            case "sword_chest":
                sceneID = "hole1";
                break;
            case "hole1":
                sceneID = "trap1";
                break;
            case "trap1_end":
                sceneID = "reset";
                break;
            case "trap1_escape":
                sceneID = "monkey1";
                break;
            case "monkey1":
                if (hasEmerald) {
                    sceneID = "monkey2";
                } else {
                    sceneID = "room2";
                }
                break;
            case "monkey2":
                sceneID = "room2";
                break;
            case "hallway4":
                sceneID = "rope_puzzle1";
                break;
            case "waterfall":
                sceneID = "hallway4";
                hasTorch = false;
                break;
            case "rope_snake":
                sceneID = "reset";
                break;
            case "rope_frayed":
                sceneID = "rope_puzzle_door";
                break;
            case "rope_new":
                sceneID = "reset";
                break;
            case "door_middle":
                sceneID = "door_puzzle_solved";
                goneMiddle = true;
                hasSword = false;
                break;
            case "door_left":
                sceneID = "reset";
                break;
            case "door_right":
                diamonds++;
                sceneID = "pit_climb";
                break;
            case "pit_climb":
                sceneID = "pit_levers";
                break;
            case "pit_end":
                sceneID = "reset";
                break;
            case "pit_door":
                sceneID = "golem_battle";
                break;
            case "golem_lose":
                sceneID = "reset";
                break;
            case "golem_kill":
                sceneID = "epilogue";
                break;
            case "golem_live":
                sceneID = "epilogue";
                break;
            case "epilogue":
                sceneID = "reset";
                break;
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && !fade && !hasChoice) {
            spaceSwitch = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && sceneID.equals("door_puzzle")) {
            keyLeft = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && sceneID.equals("door_puzzle")) {
            keyRight = true;
        }
        if (sceneID.equals("door_puzzle")) {
            if (Character.isAlphabetic(e.getKeyChar())) {
                input += e.getKeyChar();
            } else if (e.getKeyChar() == ' ') {
                input += e.getKeyChar();
            } else if (e.getKeyChar() == 8 && input.length() > 0)//delete
            {
                input = input.substring(0, input.length() - 1);//removes last index
            } else if (e.getKeyChar() == '\n')//enter key
            {
                checkInput = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && !fade && !hasChoice) {
            if (spaceSwitch) {
                spaceKey = true;
                spaceSwitch = false;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && sceneID.equals("door_puzzle")) {
            keyLeft = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && sceneID.equals("door_puzzle")) {
            keyRight = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        if (sceneID.equals("trap1")) {
            runCount++;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseHold = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseHold = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
