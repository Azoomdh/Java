import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class FlappyBird 
    extends JPanel 
    implements ActionListener, KeyListener
{
    int boardWidth = 360;
    int boardHeight = 640;

    // image
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;

    // Bird
        int birdX = boardWidth/8;
        int birdY = boardHeight/2;
        int birdWidth = 34;
        int birdHeight = 24;

        class Bird {
            int x = birdX;
            int y = birdY;
            int width = birdWidth;
            int height = birdHeight;
            Image img;

            public Bird(Image img) {
                this.img = img;
            }

        }
    // pipes
    int pipeX = boardWidth;
    int pipeY = 0;
    int pipeWidth = 64;
    int pipeHeight = 512;

    class Pipe {
        int x = pipeX;
        int y = pipeY;
        int width = pipeWidth;
        int height = pipeHeight;
        Image img;
        boolean passed = false;

        Pipe(Image img){
            this.img = img;
        }
    }

    // game logic 
    Bird bird;
    int vantocX = -4; // di chuyển pipe -4
    int vantocY = 0; // di chuyển bird 
    int trongLuc = 1;

    ArrayList<Pipe> pipes;

    Timer gameLoop;
    Timer placePipesTimer;

    boolean gameOver = false;
    double score = 0;

    FlappyBird(){
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        // setBackground(Color.BLUE);
        setFocusable(true);
        addKeyListener(this);

        // load img
        backgroundImg   = new ImageIcon(getClass().getResource("./image/flappybirdbg.png")).getImage();
        birdImg         = new ImageIcon(getClass().getResource("./image/flappybird.png")).getImage();
        topPipeImg      = new ImageIcon(getClass().getResource("./image/toppipe.png")).getImage();
        bottomPipeImg   = new ImageIcon(getClass().getResource("./image/bottompipe.png")).getImage();

        // bird
        bird = new Bird(birdImg);

        // pipe
        pipes = new ArrayList<Pipe>();
        Random random = new Random();

        // placePipesTimer 
        ActionListener actionListener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                placePipes();
            }
        };
        placePipesTimer = new Timer(1500, actionListener2);
        placePipesTimer.start();

        // game timer
        gameLoop = new Timer(1000/60, this);
        gameLoop.start();
    }

    public void placePipes(){

        int randomPipeY = (int) (pipeY- pipeHeight/4 - Math.random()*pipeHeight/2);
        int openingSpace = boardHeight/4;

        Pipe topPipe = new Pipe(topPipeImg);
        topPipe.y = randomPipeY;
        pipes.add(topPipe);

        Pipe bottomPipe = new Pipe(bottomPipeImg);
        bottomPipe.y = topPipe.y + pipeHeight + openingSpace;
        pipes.add(bottomPipe);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        // draw background
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null);
        
        // draw bird
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null );

        // draw pipes
        for(int i=0; i<pipes.size(); i++){
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height, null);
        }

        // draw score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 32));
        if(gameOver == true){
            g.drawString("Game Over : "+ String.valueOf((int)score), 10, 35);
        }
        else{
            g.drawString(String.valueOf((int)score), 10, 35);
        }
    }

    public void move(){
        // bird
        vantocY = vantocY + trongLuc;
        bird.y = bird.y+ vantocY;
        bird.y = Math.max(0, bird.y);

        // pipes
        for(int i=0; i<pipes.size(); i++){
            Pipe pipe = pipes.get(i);
            pipe.x = pipe.x + vantocX;

            if(pipe.passed== false && bird.x > pipe.x+ pipe.width){
                pipe.passed = true;
                score = score + 0.5;
            }
            
            if(vaCham(bird, pipe)== true){
                gameOver = true;
            }
        }

        if(bird.y> boardHeight){
            gameOver = true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if(gameOver == true){
            placePipesTimer.stop();
            gameLoop.stop();
        }
    }

    public boolean vaCham(Bird bird, Pipe pipe){
        if(
            bird.x < pipe.x+ pipe.width
            && bird.x + bird.width > pipe.x
            && bird.y < pipe.y + pipe.height
            && bird.y+ bird.height > pipe.y
        )
        {
            return true;
        }
        return false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_SPACE) {
            vantocY = -9;

            if(gameOver== true){
                // restart game
                bird.y= birdY;
                vantocY =0;
                pipes.clear();
                score = 0;
                gameOver = false;
                gameLoop.start();
                placePipesTimer.start();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }

    
}
