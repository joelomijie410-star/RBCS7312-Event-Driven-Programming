import javax.swing.*;import java.awt.*;
/** Listener/state example with reset and a non-negative boundary. */
public class Counter extends JFrame{
 private int value=0;private final JLabel display=new JLabel("0",SwingConstants.CENTER);
 Counter(){super("Week 4 — Counter");setDefaultCloseOperation(EXIT_ON_CLOSE);setSize(340,180);setLocationRelativeTo(null);display.setFont(display.getFont().deriveFont(32f));JButton minus=new JButton("−"),plus=new JButton("+"),reset=new JButton("Reset");minus.addActionListener(e->setValue(Math.max(0,value-1)));plus.addActionListener(e->setValue(value+1));reset.addActionListener(e->setValue(0));JPanel buttons=new JPanel();buttons.add(minus);buttons.add(reset);buttons.add(plus);add(display,BorderLayout.CENTER);add(buttons,BorderLayout.SOUTH);}
 private void setValue(int n){value=n;display.setText(Integer.toString(value));}
 public static void main(String[]a){SwingUtilities.invokeLater(()->new Counter().setVisible(true));}
}
