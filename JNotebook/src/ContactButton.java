import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactButton extends JButton {
    String name, email = "", tg = "", tel = "";
    Window wnd;

    public ContactButton(String str, Window wnd){
        super(str);
        this.name = str;
        this.wnd = wnd;
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(name);
                JOptionPane.showMessageDialog(wnd, "Tel:" + tel + "\n" +
                        "Email:" + email + "\n" +
                        "Tg:" + tg);
            }
        });
    }

    @Override
    public String toString() {
        return name;
    }
}
