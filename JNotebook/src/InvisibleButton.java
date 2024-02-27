import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InvisibleButton extends JButton {

    int type;
    String name;
    Window wnd;
    public InvisibleButton(int type, ImageIcon icon, Window wnd){

        super(icon);
        setOpaque(false);
        setBorderPainted(true);
        setFocusPainted(false);
        setContentAreaFilled(false);
        this.type = type;
        name = Integer.toString(type);
        this.wnd = wnd;

        addActionListener(new ButtonListener(wnd));

    }

    @Override
    public String toString() {
        return name;
    }
}
