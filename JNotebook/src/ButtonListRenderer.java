import javax.swing.*;
import java.awt.*;

public class ButtonListRenderer extends JButton implements ListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus)
    {
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setText(value.toString());

        if(isSelected){
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionBackground());
        }else{
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        return this;

    }
}
