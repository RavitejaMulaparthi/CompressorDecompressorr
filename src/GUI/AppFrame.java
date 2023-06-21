package GUI;
import comp_decomp.Compressor;
import comp_decomp.Decompressor;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.File;
import java.awt.event.ActionListener;
import javax.swing.*;


public class AppFrame extends JFrame implements ActionListener {
    private JButton compressButton;
    private JButton decompressButton;

    public AppFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        compressButton = new JButton("select file to compress");
        compressButton.setBounds(20, 100, 200, 30);
        compressButton.addActionListener(this);

        decompressButton = new JButton("select file to decompress");
        decompressButton.setBounds(250, 100, 200, 30);
        decompressButton.addActionListener(this);

        JLabel label = new JLabel("COMPRESSOR DECOMPRESSOR");
        label.setBounds(150, 20, 200, 20);
        label.setForeground(Color.orange);

        JLabel compressLabel = new JLabel("Compress File");
        compressLabel.setBounds(20, 70, 200, 30);
        compressLabel.setForeground(Color.white);

        JLabel decompressLabel = new JLabel("Decompress File");
        decompressLabel.setBounds(250, 70, 200, 30);
        decompressLabel.setForeground(Color.white);

        this.add(label);
        this.add(compressLabel);
        this.add(compressButton);
        this.add(decompressLabel);
        this.add(decompressButton);
        this.setSize(500, 250);
        this.getContentPane().setBackground(Color.black);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    Compressor.method(file);
                    JOptionPane.showMessageDialog(this, "Compression successful");
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(this, "Compression error" + exception.getMessage());
                }
            }
        }
        if (e.getSource() == decompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    Decompressor.method(file);
                    JOptionPane.showMessageDialog(this, "Decompression successful");
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(this, "Decompression error" + exception.getMessage());
                }
            }
        }
    }
}

