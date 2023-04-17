package Com.Anarchist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {

    private JTextField name_field, email_field;
    private JRadioButton male, female;
    private JCheckBox check;

    public ContactForm(){
        super("Contact form");
        super.setBounds(150, 250, 400, 400); //размеры
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // при выходе

        Container contain = super.getContentPane();
        contain.setLayout(new GridLayout(5, 2, 2, 25));

        JLabel name = new JLabel("Bezdars , dai name : ");
        name_field = new JTextField("", 1);
        JLabel email = new JLabel("Bezdars, dai milo : ");
        email_field = new JTextField("@" , 1);

        contain.add(name);
        contain.add(name_field);
        contain.add(email);
        contain.add(email_field);

        male   = new JRadioButton("Мужчина");
        female = new JRadioButton("Женщина");
        check = new JCheckBox("Soglasovano?", false);
        JButton sendbtn = new JButton("Otpravit");

        male.setSelected(true);
        contain.add(male);
        contain.add(female);

        ButtonGroup gr = new ButtonGroup();
        gr.add(male);
        gr.add(female);

        contain.add(check);
        contain.add(sendbtn);

        sendbtn.addActionListener(new ButtonEventManager());
    }

    class  ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
          String name = name_field.getText();
          String email = email_field.getText();

          String isMale = "Мужской";
          if(!male.isSelected()) {
              isMale = "Женский";
          }

          boolean checkbox = check.isSelected();

          JOptionPane.showMessageDialog(null, "Your email : " + email +
                  "\nВаш пол " + isMale + "\nВы согласны ? " + checkbox, "Hello, " + name, JOptionPane.PLAIN_MESSAGE);
        }
    }

}
