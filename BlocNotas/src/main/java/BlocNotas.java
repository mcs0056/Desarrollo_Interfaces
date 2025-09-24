import javax.swing.*; import java.awt.*;

public class BlocNotas {
    private JPanel VentanaPr;
    private JLabel logoLabel;
    private JTextField usuarioField;
    private JPasswordField passwordField;
    private JCheckBox aceptarCheck;
    private JButton accederButton;

    public BlocNotas(){
        VentanaPr = new JPanel(new BorderLayout(10,10));
        VentanaPr.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); //Logo
        ImageIcon icono = new ImageIcon("C:\\Users\\Usuario1\\IdeaProjects\\BlocNotas\\src\\images\\logo_empresa.png");
        Image img = icono.getImage().getScaledInstance(120,120, Image.SCALE_SMOOTH);
        logoLabel.setIcon(new ImageIcon(img));
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        VentanaPr.add(logoLabel,BorderLayout.NORTH);

        //Panel central con etiquetas y campos
        JPanel centro = new JPanel(new GridLayout(2,2,10,10));
        centro.add(new JLabel("Usuario:"));
        usuarioField = new JTextField(15);
        centro.add(usuarioField);
        centro.add(new JLabel("Contraseña:"));
        passwordField = new JPasswordField(15);
        centro.add(passwordField); VentanaPr.add(centro, BorderLayout.CENTER);

        //Panel inferior para Checkbox y botón
        JPanel inferior = new JPanel();
        inferior.setLayout(new BoxLayout(inferior, BoxLayout.Y_AXIS));

        //Checkbox
        aceptarCheck = new JCheckBox("Aceptar términos y condiciones");
        aceptarCheck.setAlignmentX(Component.CENTER_ALIGNMENT);
        inferior.add(aceptarCheck);

        //Botón
        accederButton = new JButton("Acceder");
        accederButton.setPreferredSize(new Dimension(100,30));
        accederButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        inferior.add(Box.createRigidArea(new Dimension(0,10)));
        inferior.add(accederButton);

        VentanaPr.add(inferior, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Inicio de Sesión");
        frame.setContentPane(new BlocNotas().VentanaPr);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}