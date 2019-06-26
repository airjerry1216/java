import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

class Ball
{
    double x,y;    //initial location
    //int x,y;
    double dx,dy;   //speed
    double dx_2,dy_2;
    int width;
    int height;
    Color color;
    
    public Ball(int x,int y)
    {   
        this.x=(double)x;
        this.y=(double)y;
        //this.x=x;
        //this.y=y;
        int x_dir=(Math.random()>0.5)?1:-1;
        int y_dir=(Math.random()>0.5)?1:-1;
        //int x_dir=1;
        //int y_dir=1;
        this.dx=x_dir*(Math.random()*3);   //0~2.99
        //this.dx=2.99;
        this.dx_2=Math.pow(dx,2);
        this.dy_2=9-this.dx_2;
        this.dy=y_dir*(Math.sqrt(dy_2));
        //this.dx=4;
        //this.dy=0;        

        this.width=50;
        this.height=50;

        int r=(int)(Math.random()*255);
        int g=(int)(Math.random()*255);
        int b=(int)(Math.random()*255);
        this.color=new Color(r,g,b);
        //System.out.printf("ball %f %f\n",this.dx,this.dy);
    } 
}

public class bouncing_balls extends JPanel implements Runnable,MouseListener
{
    public ArrayList<Ball> balls;
    public boolean hasBall;
    public int ballcnt;
    ExecutorService executorService;

    public bouncing_balls()  //constructor
    {   
        JFrame frame=new JFrame("Bouncing Ball");
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.add(this);    //add JPanel to JFrame
        //frame.setContentPane(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addMouseListener(this);
        //setForeground(Color.green);
        hasBall=false;
        ballcnt=0;
        balls=new ArrayList<Ball>();
        
        executorService=Executors.newCachedThreadPool(); 
    }
    public void run()
    {
        //System.out.printf("%d %d\n",getWidth(),getHeight());
        while(true)
        {
            try
            {
                Thread.sleep(5);
            }
            catch(InterruptedException e){}
            
            for(Ball ball:balls)
            {
                //System.out.printf("%f %f\n",ball.dx,ball.dy);
                if(ball.x<0)
                {
                    ball.dx=-ball.dx;
                }
                else if(ball.x>=getWidth()-50)   //JPanel edge
                {
                    ball.dx=-ball.dx;
                    ball.x=getWidth()-50;
                }    
                if(ball.y<0)
                {
                    ball.dy=-ball.dy;
                }
                else if(ball.y>=getHeight()-50)
                {    
                    ball.dy=-ball.dy;
                    ball.y=getHeight()-50;
                }
                ball.x+=ball.dx;
                ball.y+=ball.dy;
            }
            repaint();
        }
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        for(Ball ball:balls)
        {
            //System.out.println(ball.x);
            //super.paint(g);
            g.setColor(ball.color);
            g.fillOval((int)ball.x,(int)ball.y,ball.width,ball.height);   //paint
        }
    }
    @Override
    public void mousePressed(MouseEvent event)
    {
        //System.out.printf("%d %d\n",event.getX(),event.getY());
        //if(event.getX()>430||event.getY()>430)
          //  return;
        if(ballcnt<19)
        {
            //System.out.println("pressed");
            balls.add(new Ball(event.getX(),event.getY()));
            if(!hasBall)
                executorService.execute(this);
            hasBall=true;
            ++ballcnt;
        }
    }
    @Override
    public void mouseReleased(MouseEvent event){}
    @Override
    public void mouseClicked(MouseEvent event){}
    @Override
    public void mouseEntered(MouseEvent event){}
    @Override
    public void mouseExited(MouseEvent event){}

    public static void main(String[] args)
    {
        bouncing_balls b_ball=new bouncing_balls();
    }
}
