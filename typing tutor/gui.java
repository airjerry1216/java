import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.Box;
import java.util.*;

public class gui extends JFrame implements KeyListener
{
    public String row1="`1234567890-=";
    public String row2="QWERTYUIOP[]\\";
    public String row3="ASDFGHJKL;\"";
    public String row4="ZXCVBNM,./";
    public String prompt;
    private JButton button;
    private JButton[] buttons;
    public final JTextArea textprompt;
    public final JTextArea textarea;
    private final FlowLayout layout;
    //private final String Space = KeyEvent.getKeyText(KeyEvent.VK_SPACE);
    private final Container container;

    public gui()        //constructor
    {
        super("Typing Application");
        //setResizable(false);

        layout=new FlowLayout();
        setLayout(layout);
        container=getContentPane();
        buttons=new JButton[100];
        //buttons=new ArrayList<JButton>();

        prompt=new String("Type some text using your keyboard. The keys you press will be highlighted and the text will be displayed.\nNote: Clicking the buttons with your mouse will not perform any action.");
        
        textprompt=new JTextArea(prompt,2,63);
        //textprompt.setSize(300,300);
        textprompt.setFocusable(false);
        textprompt.setBackground(null);
        textprompt.setLineWrap(true);   
        textprompt.setWrapStyleWord(true);
        add(textprompt);

        textarea=new JTextArea(8,63);
        //textarea.setSize(300,300);
        textarea.setFocusable(true);
        textarea.setLineWrap(true);   
        textarea.setWrapStyleWord(true);
        add(textarea);
        //this.setFocusable(true);
        this.requestFocusInWindow();
        textarea.addKeyListener(this);
        
        int cnt=0;
        for(int i=0;i<13;++i)
        {
            buttons[cnt]=new JButton(Character.toString(row1.charAt(i)));
            //buttons[cnt].setName("")
            add(buttons[cnt]);
            cnt++;
        }
        buttons[cnt]=new JButton("Backspace");
        add(buttons[cnt]);
        cnt++;
        buttons[cnt]=new JButton("Tab");
        add(buttons[cnt]);
        cnt++;
        for(int i=0;i<13;++i)
        {
            buttons[cnt]=new JButton(Character.toString(row2.charAt(i)));
            add(buttons[cnt]);
            cnt++;
        }
        buttons[cnt]=new JButton("Caps Lock");
        add(buttons[cnt]);
        cnt++;
        for(int i=0;i<11;++i)
        {
            buttons[cnt]=new JButton(Character.toString(row3.charAt(i)));
            add(buttons[cnt]);
            cnt++;
        }
        buttons[cnt]=new JButton("Enter");
        add(buttons[cnt]);
        cnt++;
        buttons[cnt]=new JButton("Shift");
        add(buttons[cnt]);
        cnt++;
        for(int i=0;i<10;++i)
        {
            buttons[cnt]=new JButton(Character.toString(row4.charAt(i)));
            add(buttons[cnt]);
            cnt++;
        }
        buttons[cnt]=new JButton("^");
        add(buttons[cnt]);
        cnt++;
        add(Box.createHorizontalStrut(200));
        buttons[cnt]=new JButton("                                                ");
        add(buttons[cnt]);
        cnt++;
        add(Box.createHorizontalStrut(82));
        buttons[cnt]=new JButton("<");
         add(buttons[cnt]);
        cnt++;
        buttons[cnt]=new JButton("v");
        add(buttons[cnt]);
        cnt++;
        buttons[cnt]=new JButton(">");
        add(buttons[cnt]);
        
        layout.setAlignment(FlowLayout.LEFT);       //align
        layout.layoutContainer(container);
        
    }
    public void setColor(KeyEvent event,int set)
    {
        Color color;
        if(set==0)
                color=null;
        else
                color=Color.yellow;
        String key=KeyEvent.getKeyText(event.getKeyCode());
        if(key.equals("Back Quote"))
                buttons[0].setBackground(color);
        else if(key.equals("Minus"))
                buttons[11].setBackground(color);
        else if(key.equals("Equals"))
                buttons[12].setBackground(color);
        else if(key.equals("Open Bracket"))
                buttons[25].setBackground(color);
        else if(key.equals("Close Bracket"))
                buttons[26].setBackground(color);
        else if(key.equals("Back Slash"))
                buttons[27].setBackground(color);
        else if(key.equals("Semicolon"))
                buttons[38].setBackground(color);
        else if(key.equals("Quote"))
                buttons[39].setBackground(color);
        else if(key.equals("Comma"))
                buttons[49].setBackground(color);
        else if(key.equals("Period"))
                buttons[50].setBackground(color);
        else if(key.equals("Slash"))
                buttons[51].setBackground(color);
        else if(key.equals("Up"))
                buttons[52].setBackground(color);
        else if(key.equals("Space"))
                buttons[53].setBackground(color);
        else if(key.equals("Left"))
                buttons[54].setBackground(color);
        else if(key.equals("Down"))
                buttons[55].setBackground(color);
        else if(key.equals("Right"))
                buttons[56].setBackground(color);
        else
        {
            for(int i=1;i<49;++i)
            {
                if(key.equals(buttons[i].getText()))
                {
                    buttons[i].setBackground(color);
                    break;
                }
            }
        }
    }
    @Override
    public void keyPressed(KeyEvent event)
    {
        setColor(event,1);
        System.out.println(KeyEvent.getKeyText(event.getKeyCode()));
    }
    @Override
    public void keyReleased(KeyEvent event)
    {
        setColor(event,0);
    }
    @Override
    public void keyTyped(KeyEvent event){}
}