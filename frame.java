import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
class frame extends JFrame{
    public static void main(String args[]){
        frame frame = new frame("タイトル");
        frame.setVisible(true);
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 300));
        panel.setBackground(Color.BLACK);
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(100,100));
        p.setBackground(Color.RED);
        panel.add(p, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.CENTER);
    }
    frame(String title){
        setTitle(title);
        setBounds(100, 100, 400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        JButton btn = new JButton("ボタン");
        contentPane.add(btn, BorderLayout.NORTH);
        
    }
}