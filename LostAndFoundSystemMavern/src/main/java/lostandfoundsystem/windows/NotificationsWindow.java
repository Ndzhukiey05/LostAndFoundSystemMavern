// 230236901
package lostandfoundsystem.windows;

import lostandfoundsystem.constants.Fonts;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

public class NotificationsWindow extends JFrame {

    private JPanel northPanel;
    private JLabel title;

    private JPanel centerPanel;

    private JPanel notificationPanel1;
    private JPanel notificationPanel2;
    private JPanel notificationPanel3;

    private JPanel buttonPanel1;
    private JPanel buttonPanel2;
    private JPanel buttonPanel3;

    private JTextArea txtNotificationMessage1;
    private JTextArea txtNotificationMessage2;
    private JTextArea txtNotificationMessage3;

    private JButton btnMarkAsRead1;
    private JButton btnDelete1;
    private JButton btnMarkAsRead2;
    private JButton btnDelete2;
    private JButton btnMarkAsRead3;
    private JButton btnDelete3;

    public NotificationsWindow() {

        title = new JLabel("Notifications");
        title.setFont(Fonts.Bold.deriveFont(24f));

        northPanel = new JPanel();

        centerPanel = new JPanel();

        notificationPanel1 = new JPanel();
        notificationPanel2 = new JPanel();
        notificationPanel3 = new JPanel();

        buttonPanel1 = new JPanel();
        buttonPanel2 = new JPanel();
        buttonPanel3 = new JPanel();

        txtNotificationMessage1 = new JTextArea("Notification Message 1");
        txtNotificationMessage2 = new JTextArea("Notification Message 2");
        txtNotificationMessage3 = new JTextArea("Notification Message 3");

        btnMarkAsRead1 = new JButton("Mark As Read");
        btnDelete1 = new JButton("Delete");

        btnMarkAsRead2 = new JButton("Mark As Read");
        btnDelete2 = new JButton("Delete");

        btnMarkAsRead3 = new JButton("Mark As Read");
        btnDelete3 = new JButton("Delete");

        guiSetUp();
    }

    private void guiSetUp() {

        northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        northPanel.add(title);

        centerPanel.setLayout(new GridLayout(3, 1, 20, 20));

        notificationPanel1.setLayout(new BorderLayout(5, 5));

        txtNotificationMessage1.setRows(4);
        txtNotificationMessage1.setColumns(30);
        txtNotificationMessage1.setEditable(false);

        buttonPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));

        buttonPanel1.add(btnMarkAsRead1);
        buttonPanel1.add(btnDelete1);

        notificationPanel1.add(new JScrollPane(txtNotificationMessage1), BorderLayout.CENTER);
        notificationPanel1.add(buttonPanel1, BorderLayout.SOUTH);

        notificationPanel2.setLayout(new BorderLayout(5, 5));

        txtNotificationMessage2.setRows(4);
        txtNotificationMessage2.setColumns(30);
        txtNotificationMessage2.setEditable(false);

        buttonPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        buttonPanel2.add(btnMarkAsRead2);
        buttonPanel2.add(btnDelete2);

        notificationPanel2.add(new JScrollPane(txtNotificationMessage2), BorderLayout.CENTER);
        notificationPanel2.add(buttonPanel2, BorderLayout.SOUTH);

        notificationPanel3.setLayout(new BorderLayout(5, 5));

        txtNotificationMessage3.setRows(4);
        txtNotificationMessage3.setColumns(30);
        txtNotificationMessage3.setEditable(false);

        buttonPanel3.setLayout(new FlowLayout(FlowLayout.CENTER));

        buttonPanel3.add(btnMarkAsRead3);
        buttonPanel3.add(btnDelete3);

        notificationPanel3.add(new JScrollPane(txtNotificationMessage3), BorderLayout.CENTER);
        notificationPanel3.add(buttonPanel3, BorderLayout.SOUTH);

        centerPanel.add(notificationPanel1);
        centerPanel.add(notificationPanel2);
        centerPanel.add(notificationPanel3);

        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.add(centerPanel);

        setLayout(new BorderLayout());
        add(northPanel, BorderLayout.NORTH);

        add(wrapper, BorderLayout.CENTER);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
