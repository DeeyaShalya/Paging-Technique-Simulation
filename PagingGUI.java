import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PagingGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Paging Technique Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new GridLayout(5, 2));

        JLabel frameSizeLabel = new JLabel("Frame Size:");
        JTextField frameSizeField = new JTextField();
        JLabel pageSequenceLabel = new JLabel("Page Sequence (comma-separated):");
        JTextField pageSequenceField = new JTextField();
        JLabel algorithmLabel = new JLabel("Replacement Algorithm (FIFO, LRU, Optimal):");
        JTextField algorithmField = new JTextField();
        JButton simulateButton = new JButton("Simulate");
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        frame.add(frameSizeLabel);
        frame.add(frameSizeField);
        frame.add(pageSequenceLabel);
        frame.add(pageSequenceField);
        frame.add(algorithmLabel);
        frame.add(algorithmField);
        frame.add(simulateButton);
        frame.add(new JScrollPane(resultArea));

        simulateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int frameSize;
                List<Integer> pageSequence = new ArrayList<>();
                String algorithm;
                try {
                    frameSize = Integer.parseInt(frameSizeField.getText());
                    String[] pages = pageSequenceField.getText().split(",");
                    for (String page : pages) {
                        pageSequence.add(Integer.parseInt(page.trim()));
                    }
                    algorithm = algorithmField.getText();
                } catch (NumberFormatException ex) {
                    resultArea.setText("Invalid input. Please enter valid numbers.");
                    return;
                }

                Paging paging = new Paging(frameSize, pageSequence, algorithm);
                paging.simulatePaging();
                resultArea.setText("Total Page Faults: " + paging.getPageFaults());
            }
        });

        frame.setVisible(true);
    }
}
