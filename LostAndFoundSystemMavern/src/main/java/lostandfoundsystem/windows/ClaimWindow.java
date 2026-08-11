// 221106901

package lostandfoundsystem.windows;

import lostandfoundsystem.components.PageHeaderPanel;
import lostandfoundsystem.components.SideBarPanel;
import lostandfoundsystem.components.UIComponents;
import lostandfoundsystem.constants.Colors;
import lostandfoundsystem.constants.Fonts;

import lostandfoundsystem.domain.User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ClaimWindow extends JFrame {
    
    private User currentUser;
    private JPanel claimsContainer;

    public ClaimWindow(User currentUser) {
        this.currentUser = currentUser;
        super("Campus Finder - Claims");
        guiSetUp();
    }

    private void guiSetUp() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(73, 107, 145));
        setLayout(new BorderLayout(15, 15));

        SideBarPanel sidebarPanel = new SideBarPanel(currentUser);

        JPanel center = new JPanel(new BorderLayout(15, 15));
        center.setOpaque(false);

        PageHeaderPanel headerPanel = new PageHeaderPanel("CLAIMS", currentUser);

        center.add(headerPanel, BorderLayout.NORTH);
        center.add(createContentPanel(), BorderLayout.CENTER);

        add(sidebarPanel, BorderLayout.WEST);
        add(center, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createContentPanel() {
        JPanel contentPanel = new JPanel(new BorderLayout(0, 15));
        contentPanel.setBackground(new Color(220, 220, 220));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel lblTitle = new JLabel("View All Claims");
        lblTitle.setOpaque(true);
        lblTitle.setBackground(new Color(40, 90, 255));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBorder(new EmptyBorder(8, 15, 8, 15));
        lblTitle.setFont(Fonts.Bold.deriveFont(16f));

        contentPanel.add(lblTitle, BorderLayout.NORTH);

        claimsContainer = new JPanel();
        claimsContainer.setLayout(new BoxLayout(claimsContainer, BoxLayout.Y_AXIS));
        claimsContainer.setBackground(new Color(240, 240, 240));

        loadDummyClaims();

        JScrollPane scrollPane = new JScrollPane(claimsContainer);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(12);

        contentPanel.add(scrollPane, BorderLayout.CENTER);

        return contentPanel;
    }

    private void loadDummyClaims() {
        addClaimCard("Laptop", "12-March-2026", "Library", "Pending");
        addClaimCard("Student Card", "12-March-2026", "Library", "Approved");
        addClaimCard("Wallet", "12-March-2026", "Cafeteria", "Rejected");
        addClaimCard("Phone", "13-March-2026", "Student Centre", "Pending");
        addClaimCard("Backpack", "14-March-2026", "Computer Lab", "Approved");
        addClaimCard("Calculator", "15-March-2026", "Engineering Block", "Rejected");
    }

    public void addClaimCard(String item, String date, String location, String status) {
        JPanel cardWrapper = new JPanel();
        cardWrapper.setLayout(new BoxLayout(cardWrapper, BoxLayout.Y_AXIS));
        cardWrapper.setOpaque(false);
        cardWrapper.setAlignmentX(LEFT_ALIGNMENT);

        UIComponents.RoundedPanel card = new UIComponents.RoundedPanel(15, Color.WHITE);
        card.setLayout(new BorderLayout(10, 10));
        card.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Colors.BORDER_GRAY, 1), new EmptyBorder(15, 20, 15, 20)));
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
        card.setPreferredSize(new Dimension(700, 150));

        JPanel infoPanel = new JPanel(new GridLayout(4, 1, 0, 5));
        infoPanel.setOpaque(false);

        JLabel lblItem = new JLabel("Item Name : " + item);
        lblItem.setFont(Fonts.Bold.deriveFont(15f));
        lblItem.setForeground(Colors.DARK_BLUE_TEXT_COLOR);

        JLabel lblDate = new JLabel("Date Lost : " + date);
        lblDate.setFont(Fonts.Medium.deriveFont(14f));

        JLabel lblLocation = new JLabel("Location : " + location);
        lblLocation.setFont(Fonts.Medium.deriveFont(14f));

        JLabel lblStatus = new JLabel("Status : " + status);
        lblStatus.setFont(Fonts.Medium.deriveFont(14f));

        if (status.equalsIgnoreCase("Pending")) {
            lblStatus.setForeground(Colors.YELLOW_STATUS_COLOR);
        } else if (status.equalsIgnoreCase("Approved")) {
            lblStatus.setForeground(Colors.GREEN_STATUS_COLOR);
        } else if (status.equalsIgnoreCase("Rejected")) {
            lblStatus.setForeground(Colors.RED_STATUS_COLOR);
        }

        infoPanel.add(lblItem);
        infoPanel.add(lblDate);
        infoPanel.add(lblLocation);
        infoPanel.add(lblStatus);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setOpaque(false);

        JButton btnCancel = new JButton("Cancel");
        JButton btnEdit = new JButton("Edit");
        JButton btnView = new JButton("View");

        btnCancel.setFont(Fonts.Bold.deriveFont(13f));
        btnEdit.setFont(Fonts.Bold.deriveFont(13f));
        btnView.setFont(Fonts.Bold.deriveFont(13f));

        btnCancel.setBackground(Colors.DARK_BLUE_TEXT_COLOR);
        btnEdit.setBackground(Colors.DARK_BLUE_TEXT_COLOR);
        btnView.setBackground(Colors.DARK_BLUE_TEXT_COLOR);

        btnCancel.setForeground(Color.WHITE);
        btnEdit.setForeground(Color.WHITE);
        btnView.setForeground(Color.WHITE);

        btnCancel.setFocusPainted(false);
        btnEdit.setFocusPainted(false);
        btnView.setFocusPainted(false);

        btnCancel.setPreferredSize(new Dimension(100, 30));
        btnEdit.setPreferredSize(new Dimension(100, 30));
        btnView.setPreferredSize(new Dimension(100, 30));

        btnCancel.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel this claim?", "Cancel Claim", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "Claim cancelled successfully.");
            }
        });

        btnEdit.addActionListener(e -> {
            new ClaimFormWindow(currentUser);
            dispose();
        });

        btnView.addActionListener(e -> {
            new ItemDetailsWindow(currentUser);
            dispose();
        });

        buttonPanel.add(btnCancel);
        buttonPanel.add(btnEdit);
        buttonPanel.add(btnView);

        card.add(infoPanel, BorderLayout.CENTER);
        card.add(buttonPanel, BorderLayout.SOUTH);

        cardWrapper.add(card);
        cardWrapper.add(Box.createVerticalStrut(15));

        claimsContainer.add(cardWrapper);
    }
}