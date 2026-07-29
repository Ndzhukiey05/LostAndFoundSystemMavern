//231323573
package windows;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AdminSupportWindow extends JFrame {

    private JPanel mainPanel;
    private JPanel formPanel;

    private JLabel lblTitle;
    private JLabel lblName;
    private JLabel lblStudentNo;
    private JLabel lblIssue;

    private JTextField txtName;
    private JTextField txtStudentNo;
    private JTextArea txtIssue;

    private JButton btnCancel;
    private JButton btnSubmit;

    public AdminSupportWindow() {
        guiSetUp();
    }

    private void guiSetUp() {

        Color background = new Color(79,113,146);

        getContentPane().setBackground(background);
        setLayout(new GridBagLayout());

        formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        lblTitle = new JLabel("Admin Support");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        formPanel.add(lblTitle, gbc);

        gbc.gridwidth = 1;

        lblName = new JLabel("Name:");
        lblName.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(lblName, gbc);

        txtName = new JTextField(15);

        gbc.gridx = 1;
        formPanel.add(txtName, gbc);

        lblStudentNo = new JLabel("Student/Staff Number:");
        lblStudentNo.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(lblStudentNo, gbc);

        txtStudentNo = new JTextField(15);

        gbc.gridx = 1;
        formPanel.add(txtStudentNo, gbc);

        lblIssue = new JLabel("Issue Description:");
        lblIssue.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        formPanel.add(lblIssue, gbc);

        txtIssue = new JTextArea(5,15);
        txtIssue.setLineWrap(true);
        txtIssue.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(txtIssue);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        formPanel.add(scroll, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));
        buttonPanel.setOpaque(false);

        btnCancel = new JButton("Cancel");
        btnSubmit = new JButton("Submit");

        btnCancel.setBackground(Color.BLACK);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFocusPainted(false);

        btnSubmit.setBackground(Color.WHITE);
        btnSubmit.setForeground(Color.BLACK);
        btnSubmit.setFocusPainted(false);

        buttonPanel.add(btnCancel);
        buttonPanel.add(btnSubmit);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;

        formPanel.add(buttonPanel, gbc);

        add(formPanel);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
