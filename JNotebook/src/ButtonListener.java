import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ButtonListener implements ActionListener {
    private Window wnd;

    public ButtonListener(Window wnd){
        this.wnd = wnd;
    }
    String str;
    @Override
    public void actionPerformed(ActionEvent e) {
        int btnTxt = ((InvisibleButton) e.getSource()).type;
        System.out.println(btnTxt);
        switch(btnTxt){
            case 1:
                System.out.println("add");
                str = JOptionPane.showInputDialog(wnd, "Insert name:");
                if(!Objects.equals(str, "")) wnd.model.addElement(new ContactButton(str, wnd));
                wnd.jl.setModel(wnd.model);
                break;
            case 2:
                System.out.println("del");
                while(wnd.pt == null) {
                    if (wnd.pt != null) {
                        wnd.model.remove(wnd.jl.locationToIndex(wnd.pt));
                        System.out.println(wnd.jl.locationToIndex(wnd.pt));
                    }
                    wnd.jl.setModel(wnd.model);
                }
                break;
            case 3:
                System.out.println("red");
                break;
            default:
                break;
        }
    }
}
