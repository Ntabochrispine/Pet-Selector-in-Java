import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetSelector extends JFrame {
    private final JRadioButton birdButton;
    private final JRadioButton catButton;
    private final JRadioButton dogButton;
    private final JRadioButton rabbitButton;
    private final JRadioButton pigButton;
    private final JLabel selectedPetLabel;
    private final JLabel petImageLabel;
    public PetSelector() {
        super("Pet Selector");
        setLayout(new BorderLayout());
        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");

        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        birdButton.addActionListener(new PetButtonListener());
        catButton.addActionListener(new PetButtonListener());
        dogButton.addActionListener(new PetButtonListener());
        rabbitButton.addActionListener(new PetButtonListener());
        pigButton.addActionListener(new PetButtonListener());

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(5, 1));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);


        selectedPetLabel = new JLabel("Select a pet", SwingConstants.CENTER);
        add(selectedPetLabel, BorderLayout.NORTH);

        petImageLabel = new JLabel("", SwingConstants.CENTER);
        add(petImageLabel, BorderLayout.CENTER);

        add(radioPanel, BorderLayout.WEST);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setVisible(true);
    }

    private class PetButtonListener implements ActionListener {
        private Icon petIcon;
        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton source = (JRadioButton) e.getSource();
            selectedPetLabel.setText("Selected Pet: " + source.getText());
            selectedPetLabel.setIcon(petIcon);
            // Load and set the corresponding pet image from the 'images' folder
            String petName = source.getText().toLowerCase();
            ImageIcon petIcon;
            petIcon = new ImageIcon("images/" + petName + ".png");
            petImageLabel.setIcon(petIcon);
        }
    }

    public static void main(String[] args) {
     
        SwingUtilities.invokeLater(() -> new PetSelector());
    }
}
