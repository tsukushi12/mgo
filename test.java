import javax.swing.JFrame;
public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("タイトル");
        frame.setVisible(true);
        frame.setSize(500, 400);
//        frame.setBounds(0, 0, 400, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


