
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class DirectoryChoseApp {
    public DirectoryChoseApp() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Directory Chooser");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 800);
            frame.getContentPane().setBackground(new Color(32, 32, 32)); 

            JLabel imageLabel = new JLabel(new ImageIcon("4th.png")); 
            imageLabel.setPreferredSize(new Dimension(250, 200));

            JButton openButton = new JButton("Open");
            openButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    int result = fileChooser.showOpenDialog(frame);

                    if (result == JFileChooser.APPROVE_OPTION) {
                        File selectedDirectory = fileChooser.getSelectedFile();
                        if (selectedDirectory.isDirectory()) {
                            int yesorno = JOptionPane.showConfirmDialog(null,
                                    "Are you sure you want to delete duplicate files in the selected directory?",
                                    "Confirm Deletion", JOptionPane.YES_NO_OPTION);

                            if (yesorno == JOptionPane.YES_OPTION) {
                                JOptionPane.showMessageDialog(null, "You chose Yes!");
                                FileSorter.sortFiles(selectedDirectory.getAbsolutePath());
                                JOptionPane.showMessageDialog(null, "Operations are done.", "Done",
                                        JOptionPane.INFORMATION_MESSAGE);
                                openDeleteFile(); 
                            } else if (yesorno == JOptionPane.NO_OPTION) {
                                JOptionPane.showMessageDialog(null, "You chose No!");
                                FileSorter_NODelete.sortFiles(selectedDirectory.getAbsolutePath());
                                JOptionPane.showMessageDialog(null, "Operations are done.", "Done",
                                        JOptionPane.INFORMATION_MESSAGE);
                                openDeleteFile(); 
                            }
                        }
                    }
                }
            });

            JButton openDeleteButton = new JButton("Open delete.txt");
            openDeleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    openDeleteFile();
                }
            });

            JPanel panel = new JPanel();
            panel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(0, 0, 20, 0); 
            gbc.gridx = 0;
            gbc.gridy = 0;
            panel.add(imageLabel, gbc);
            gbc.insets = new Insets(0, 0, 0, 0); 
            gbc.gridy = 1;
            panel.add(openButton, gbc);
            gbc.gridy = 2;
            panel.add(openDeleteButton, gbc); 

            frame.add(panel);

            frame.setVisible(true);
        });
    }

    private void openDeleteFile() {
        try {
            
            File deleteFile = new File("deleted.txt");
            if (deleteFile.exists()) {
                Desktop.getDesktop().open(deleteFile);
            } else {
                JOptionPane.showMessageDialog(null, "The delete.txt file does not exist.", "File Not Found",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error opening the delete.txt file.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
