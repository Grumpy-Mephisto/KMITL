import com.assignment.graphics.GraphicPanel;

import javax.swing.JFrame;

public class Main {
  public static void main(String[] args) {
    GraphicPanel graphicPanel = new GraphicPanel();

    JFrame frame = new JFrame();
    frame.add(graphicPanel);
    frame.setTitle("New Year's Theme");
    frame.setSize(600, 600);
    frame.setPreferredSize(frame.getSize());
    frame.setResizable(false);
    frame.setMaximumSize(frame.getSize());
    frame.setMinimumSize(frame.getSize());
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
