import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class BlocNotas3 {

    private JPanel VentanaPr;
    private JLabel logoLabel;
    private JTextField usuarioField;
    private JPasswordField passwordField;
    private JCheckBox aceptarCheck;
    private JButton accederButton;
    private JRadioButton recordarRadioButton;
    private JComboBox comboIdiomas;
    private JProgressBar carga;

    class PanelConFondo extends JPanel{
        private Image fondo;

        public PanelConFondo(String rutaImagen){
            fondo = new ImageIcon(rutaImagen).getImage();
        }
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(fondo,0,0,getWidth(),getHeight(),this);
        }
    }

    public BlocNotas3(){
        VentanaPr = new BlocNotas3.PanelConFondo("C:\\Users\\Miguel\\IdeaProjects\\BlocNotas\\src\\images\\atardecer_chill.jpg");
        VentanaPr.setLayout(new BorderLayout(10,10));
        VentanaPr.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        //Panel superior con logo e idiomas
        JPanel superior = new JPanel();
        superior.setOpaque(false);
        superior.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        //Logo
        ImageIcon icono = new ImageIcon("C:\\Users\\Miguel\\IdeaProjects\\BlocNotas\\src\\images\\logo_empresa.png");
        Image img = icono.getImage().getScaledInstance(120,120, Image.SCALE_SMOOTH);
        logoLabel.setIcon(new ImageIcon(img));
        logoLabel.setOpaque(false);
        logoLabel.setForeground(Color.WHITE);
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        superior.add(logoLabel);

        //Idiomas
        String[] idiomas = {"Español", "Inglés", "Fránces", "Alemán", "Ruso", "Élfico", "Italiano", "Japones", "Chino"};
        JComboBox<String> comboIdiomas= new JComboBox<>(idiomas);
        comboIdiomas.setToolTipText("Seleccione el idioma deseado");
        comboIdiomas.setOpaque(false);
        comboIdiomas.setMaximumSize(new Dimension(120,25));
        comboIdiomas.setPreferredSize(new Dimension(120,25));
        comboIdiomas.setMinimumSize(new Dimension(120,25));
        superior.add(comboIdiomas);

        VentanaPr.add(superior, BorderLayout.NORTH);

        //Panel central con etiquetas y campos
        JPanel centro = new JPanel(new GridLayout(2,2,10,10));
        centro.setOpaque(false);

        //Usuario
        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioLabel.setForeground(Color.WHITE);
        centro.add(usuarioLabel);
        usuarioField = new JTextField(15);
        usuarioField.setToolTipText("Introduce tu nombre de usuario");
        usuarioField.setOpaque(false);
        usuarioField.setForeground(Color.WHITE);
        usuarioField.setCaretColor(Color.WHITE);
        usuarioField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        centro.add(usuarioField);

        //Contraseña
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setForeground(Color.WHITE);
        centro.add(passwordLabel);
        passwordField = new JPasswordField(15);
        passwordField.setToolTipText("Introduce tu contraseña");
        passwordField.setOpaque(false);
        passwordField.setForeground(Color.WHITE);
        passwordField.setCaretColor(Color.WHITE);
        passwordField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        centro.add(passwordField);
        VentanaPr.add(centro, BorderLayout.CENTER);

        //Panel inferior para Checkbox, RadioButton, botón y BarraProgreso
        JPanel inferior = new JPanel();
        inferior.setOpaque(false);
        inferior.setLayout(new BoxLayout(inferior, BoxLayout.Y_AXIS));

        //Checkbox
        aceptarCheck = new JCheckBox("Aceptar términos y condiciones");
        aceptarCheck.setToolTipText("Debes aceptar los términos y condiciones para continuar");
        aceptarCheck.setOpaque(false);
        aceptarCheck.setForeground(Color.WHITE);
        aceptarCheck.setAlignmentX(Component.CENTER_ALIGNMENT);
        inferior.add(aceptarCheck);

        //RadioButton
        recordarRadioButton = new JRadioButton("Recordar usuario");
        recordarRadioButton.setToolTipText("Marca esta casilla si quieres que este equipo recuerde tu usuario");
        recordarRadioButton.setOpaque(false);
        recordarRadioButton.setForeground(Color.WHITE);
        recordarRadioButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        inferior.add(recordarRadioButton);

        //Botón
        accederButton = new JButton("Acceder");
        accederButton.setToolTipText("Haz clic aquí para iniciar sesión");
        accederButton.setPreferredSize(new Dimension(100,30));
        accederButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        inferior.add(Box.createRigidArea(new Dimension(0,10)));
        inferior.add(accederButton);

        //Barra de Progreso
        carga = new JProgressBar(0,100);
        carga.setStringPainted(true);
        inferior.add(carga);

        VentanaPr.add(inferior, BorderLayout.SOUTH);

        //Acción del botón para simular la carga
        accederButton.addActionListener(e->simularCarga());
    }

    private void simularCarga(){
        new Thread(()->{
            for(int i=0; 0<=100; i++){
                try{
                    Thread.sleep(30);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                carga.setValue(i);
            }
        }).start();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Inicio de Sesión");
        frame.setContentPane(new BlocNotas3().VentanaPr);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
