import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
//import javafx.util.Pair;

public class Window extends JFrame implements Runnable{

    Pattern mail = Pattern.compile("^([a-zA-Z0-9]|_)+@([a-z0-9]|-|_){3,16}\\.com$", Pattern.MULTILINE);
    Pattern tel = Pattern.compile("^\\+*[0-9]{11}$", Pattern.MULTILINE);
    Pattern tg = Pattern.compile("@\\w+");
    private final int thickness = 1;
    int state = 0;
    String str;
    ArrayList<ContactButton> ibl;
    JList<ContactButton> jl;
    DefaultListModel<ContactButton> model;
    Point pt;
    public Window(String name){
        super(name);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon plus = new ImageIcon( "res/plus.png");
        ImageIcon minus = new ImageIcon("res/minus.png");
        ImageIcon red = new ImageIcon("res/pencil.png");
        InvisibleButton jb_add = new InvisibleButton(1, plus, this);
        InvisibleButton jb_del = new InvisibleButton(2, minus, this);
        InvisibleButton jb_red = new InvisibleButton(3, red, this);

        JPanel filler1 = new JPanel();
        JPanel filler2 = new JPanel();
        JPanel filler3 = new JPanel();

        BorderLayout layout = new BorderLayout(20, 10);
        FlowLayout layoutp = new FlowLayout(FlowLayout.CENTER);

        InvisibleButton[] iba = {jb_add, jb_del, jb_red};

        ibl = new ArrayList<>();
        kostil();
        model = new DefaultListModel<>();
        for(ContactButton cb: ibl){
            model.addElement(cb);
        }
        jl = new JList<>(model);
        jl.setCellRenderer(new ButtonListRenderer());
        jl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    buttonAt(e.getPoint());
            }
        });

        JPanel jp = new JPanel();
        Font fn = new Font("Arial", Font.BOLD, 16);

        filler1.setPreferredSize(new Dimension(getWidth(), thickness));
        filler2.setPreferredSize(new Dimension(thickness, getHeight()));
        filler3.setPreferredSize(new Dimension(thickness, getHeight()));

        jb_add.setMnemonic(KeyEvent.VK_PLUS);
        jb_red.setMnemonic(KeyEvent.VK_MINUS);
        jb_red.setMnemonic(KeyEvent.VK_R);

        jl.setFont(fn);
        jl.setVisibleRowCount(5);
        jp.add(jb_add);
        jp.add(jb_del);
        jp.add(jb_red);
        jp.setLayout(layoutp);


        //String str1 = JOptionPane.showInputDialog(this, "avcvva");
        //System.out.println(str1);

        setLayout(layout);
        add(jp, BorderLayout.SOUTH);
        add(filler1, BorderLayout.NORTH);
        add(filler2, BorderLayout.WEST);
        add(filler3, BorderLayout.EAST);
        add(new JScrollPane(jl), BorderLayout.CENTER);
        setLocation(500, 500);
        pack();
        setResizable(true);
        setVisible(true);
    }

    private void buttonAt(Point point){
        int index = jl.locationToIndex(point);
        ContactButton ib = jl.getModel().getElementAt(index);
        ib.doClick();
        jl.repaint(jl.getCellBounds(index, index));
    }

    private void kostil(){
        ibl.add(new ContactButton("1a", this));
        ibl.add(new ContactButton("2a", this));
        ibl.add(new ContactButton("3a", this));
        ibl.add(new ContactButton("4a", this));
        ibl.add(new ContactButton("5a", this));
        ibl.add(new ContactButton("6a", this));
        ibl.add(new ContactButton("7a", this));
        ibl.add(new ContactButton("8a", this));
        ibl.add(new ContactButton("9a", this));

    }

    @Override
    public void run() {
        //System.out.println(ibl.size());
    }
}
