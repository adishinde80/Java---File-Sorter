
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            
            JFrame frame = new JFrame("FILE CATEGORIZER");
            frame.setSize(1000, 800);
            frame.setResizable(false);

            
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

            
            JPanel panel = new JPanel();
            panel.setBackground(new Color(51, 51, 51)); 
            frame.getContentPane().add(panel);

            
            panel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 200));

            
            ImageIcon image1 = new ImageIcon("1st.png"); 
            JLabel label1 = new JLabel(image1);
            label1.setPreferredSize(new Dimension(250, 200));
            panel.add(label1);

            ImageIcon image2 = new ImageIcon("zip.png"); 
            JLabel label2 = new JLabel(image2);
            label2.setPreferredSize(new Dimension(250, 200));
            panel.add(label2);

            ImageIcon image3 = new ImageIcon("3rd.png"); 
            JLabel label3 = new JLabel(image3);
            label3.setPreferredSize(new Dimension(250, 200));
            panel.add(label3);

            label1.addMouseListener(new MouseClickListener(frame, "Folder Sort By Path"));
            label2.addMouseListener(new MouseClickListener(frame, "Second Image Frame"));
            label3.addMouseListener(new MouseClickListener(frame, "Third Image Frame"));

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    static class MouseClickListener implements java.awt.event.MouseListener {
        private JFrame mainFrame;
        private String frameTitle;

        public MouseClickListener(JFrame mainFrame, String frameTitle) {
            this.mainFrame = mainFrame;
            this.frameTitle = frameTitle;
        }

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            if (frameTitle.equals("Third Image Frame")) {
                new FileSearch();
            } else if (frameTitle.equals("Folder Sort By Path")) {
                new DirectoryChoseApp();
            } else if (frameTitle.equals("Second Image Frame")) {
                new ZipFolderGUI();
            } else {
              
                mainFrame.setVisible(false);

              
                JFrame newFrame = new JFrame(frameTitle);
                newFrame.setSize(1000, 800);
                newFrame.setResizable(false);

              
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.getContentPane().setBackground(new Color(51, 51, 51)); 
                newFrame.setVisible(true);

                
                newFrame.addWindowListener(new WindowAdapter() {
                    public void windowClosed(WindowEvent e) {
                        mainFrame.dispose();
                    }
                });
            }
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
        }
    }
}
