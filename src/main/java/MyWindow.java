import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by taras_000 on 30.05.2016.
 */
public class MyWindow extends JFrame{
    PrintWriter pw = null;

    public MyWindow(){

        try {
            pw = new PrintWriter(new FileWriter("1.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setTitle("Чат");
        setBounds(0,0,500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Закрыть процессы при закрытии окна приложения
        setLayout(new GridLayout(1,2));
        JPanel jp3 = new JPanel();
        JPanel jp4 = new JPanel();
        add(jp3);
        add(jp4);
        JButton jb1 = new JButton("JB1");
        final JTextArea jta1 = new JTextArea();
        final JTextField jtf1 = new JTextField();
        JScrollPane jsp = new JScrollPane(jta1);
        jp3.setLayout(new BorderLayout());
        jp3.add(jsp, BorderLayout.CENTER);
        jp3.add(jtf1, BorderLayout.NORTH);
        jp3.add(jb1, BorderLayout.SOUTH);
        JLabel jl1 = new JLabel("Пользователи в сети");
        JTextArea jta2 = new JTextArea();
        jp4.setLayout(new BorderLayout());
        jp4.add(jl1, BorderLayout.NORTH);
        jp4.add(jta2,BorderLayout.CENTER);
        MenuBar mb = new MenuBar();
        Menu mFile = new Menu("Файл");
        Menu mEdit = new Menu("Настройки");
        mb.add(mFile);
        mb.add(mEdit);
        MenuItem mFileExit = new MenuItem("Выход");
        MenuItem mEditHistory = new MenuItem("История");
        mFile.add(mFileExit);
        mEdit.add(mEditHistory);
        mFileExit.setShortcut(new MenuShortcut(KeyEvent.VK_X,true));
        setMenuBar(mb);
        setVisible(true);
        //Работа меню
        mFileExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pw.print(jta1.getText());// При нажатие на крестик функция не отработает!
                pw.close();
                System.exit(0);
            }
        });
        //Работа кнопок в TextField
        jtf1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jta1.append(jtf1.getText() + "\n");
                jtf1.setText("");
            }
        });
        //Работа кнопок в Button
        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jta1.append(jtf1.getText() + "\n");
                jtf1.setText("");
            }
        });
    }
}
