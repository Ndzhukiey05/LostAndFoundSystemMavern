//230236901
//MY WORK DON'T TOUCH OK.

package windows;

import constants.Colors;
import constants.Fonts;
import constants.Icons;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class ViewAllPostsWindow extends JFrame {

    private JPanel northPanel;
    private JLabel lbltitle;

    private JPanel sidebarPanel;
    private JPanel headerPanel;
    private JPanel navigationPanel;
    private JPanel filterPanel;
    private JPanel centerPanel;
    private JPanel itemsPanel;
    private JPanel topPanel;

    private JButton btnHome;
    private JButton btnSearch;
    private JButton btnNotification;

    private JButton btnReportLost;
    private JButton btnReportFound;
    private JButton btnViewPosts;
    private JButton btnClaims;
    private JButton btnHelp;
    private JButton btnLogout;

    private JComboBox<String> cmbFilter;

    public ViewAllPostsWindow() {

        northPanel = new JPanel();
        lbltitle = new JLabel("View All Posts");
        lbltitle.setFont(Fonts.Bold.deriveFont(24f));

        guiSetUp();
    }

    private void guiSetUp() {

        northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        northPanel.add(lbltitle);
        lbltitle.setFont(new Font("Arial", Font.BOLD, 24));

        setLayout(new BorderLayout(15, 15));
        getContentPane().setBackground(new Color(73, 107, 145));

        setLayout(new BorderLayout());

        add(createSidebarPanel(), BorderLayout.WEST);
        add(createCenterPanel(), BorderLayout.CENTER);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createSidebarPanel() {

        sidebarPanel = new JPanel();
        sidebarPanel.setPreferredSize(new Dimension(240, 0));
        sidebarPanel.setLayout(new BorderLayout());
        sidebarPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        sidebarPanel.setBackground(Color.WHITE);

        JLabel lblProfile = new JLabel("PROFILE");
        lblProfile.setFont(Fonts.Bold.deriveFont(24f));
        lblProfile.setForeground(Colors.DARK_BLUE_TEXT_COLOR);

        topPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(lblProfile);
        topPanel.add(Box.createVerticalStrut(15));

        btnReportLost = new JButton("Report Lost Item");
        btnReportLost.setFont(Fonts.Medium.deriveFont(15f));
        btnReportLost.setContentAreaFilled(false);
        btnReportLost.setBorderPainted(false);
        btnReportLost.setFocusPainted(false);
        btnReportLost.setHorizontalAlignment(SwingConstants.LEFT);

        btnReportFound = new JButton("Report Found Item");
        btnReportFound.setFont(Fonts.Medium.deriveFont(15f));
        btnReportFound.setContentAreaFilled(false);
        btnReportFound.setBorderPainted(false);
        btnReportFound.setFocusPainted(false);
        btnReportFound.setHorizontalAlignment(SwingConstants.LEFT);

        btnViewPosts = new JButton("View All Posts");
        btnViewPosts.setFont(Fonts.Medium.deriveFont(15f));
        btnViewPosts.setContentAreaFilled(false);
        btnViewPosts.setBorderPainted(false);
        btnViewPosts.setFocusPainted(false);
        btnViewPosts.setHorizontalAlignment(SwingConstants.LEFT);

        btnClaims = new JButton("Claims");
        btnClaims.setFont(Fonts.Medium.deriveFont(15f));
        btnClaims.setContentAreaFilled(false);
        btnClaims.setBorderPainted(false);
        btnClaims.setFocusPainted(false);
        btnClaims.setHorizontalAlignment(SwingConstants.LEFT);

        btnHelp = new JButton("Help");
        btnHelp.setFont(Fonts.Medium.deriveFont(15f));
        btnHelp.setContentAreaFilled(false);
        btnHelp.setBorderPainted(false);
        btnHelp.setFocusPainted(false);
        btnHelp.setHorizontalAlignment(SwingConstants.LEFT);

        topPanel.add(btnReportLost);
        topPanel.add(Box.createVerticalStrut(10));

        topPanel.add(btnReportFound);
        topPanel.add(Box.createVerticalStrut(10));

        topPanel.add(btnViewPosts);
        topPanel.add(Box.createVerticalStrut(10));

        topPanel.add(btnClaims);
        topPanel.add(Box.createVerticalStrut(10));

        topPanel.add(btnHelp);

        sidebarPanel.add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);

        btnLogout = new JButton("Logout");
        btnLogout.setFont(Fonts.Medium.deriveFont(15f));
        btnLogout.setContentAreaFilled(false);
        btnLogout.setBorderPainted(false);
        btnLogout.setFocusPainted(false);
        btnLogout.setHorizontalAlignment(SwingConstants.LEFT);

        bottomPanel.add(btnLogout, BorderLayout.SOUTH);

        sidebarPanel.add(bottomPanel, BorderLayout.SOUTH);

        return sidebarPanel;
    }

    private JPanel createHeaderPanel() {

        headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setPreferredSize(new Dimension(0, 55));

        JLabel lblHeader = new JLabel("VIEW ALL POSTS");
        lblHeader.setFont(Fonts.Bold.deriveFont(24f));
        lblHeader.setForeground(Colors.DARK_BLUE_TEXT_COLOR);

        headerPanel.add(lblHeader);

        return headerPanel;
    }

    private JPanel createNavigationPanel() {

        navigationPanel = new JPanel(new BorderLayout());
        navigationPanel.setBackground(Color.WHITE);
        navigationPanel.setPreferredSize(new Dimension(0, 55));

        btnHome = new JButton(Icons.Home);
        btnHome.setContentAreaFilled(false);
        btnHome.setBorderPainted(false);
        btnHome.setFocusPainted(false);

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setOpaque(false);

        btnSearch = new JButton(Icons.Search);
        btnSearch.setContentAreaFilled(false);
        btnSearch.setBorderPainted(false);
        btnSearch.setFocusPainted(false);

        btnNotification = new JButton(Icons.Bell);
        btnNotification.setContentAreaFilled(false);
        btnNotification.setBorderPainted(false);
        btnNotification.setFocusPainted(false);

        rightPanel.add(btnSearch);
        rightPanel.add(btnNotification);

        navigationPanel.add(btnHome, BorderLayout.WEST);
        navigationPanel.add(rightPanel, BorderLayout.EAST);

        return navigationPanel;
    }

    private JPanel createTopSection() {

        JPanel topSection = new JPanel();
        topSection.setLayout(new GridLayout(2, 1, 0, 10));
        topSection.setOpaque(false);

        topSection.add(createHeaderPanel());
        topSection.add(createNavigationPanel());

        return topSection;
    }

    private JPanel createCenterPanel() {

        centerPanel = new JPanel(new BorderLayout(0, 15));
        centerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        centerPanel.setBackground(new Color(73, 107, 145));

        centerPanel.add(createHeaderPanel(), BorderLayout.NORTH);
        centerPanel.add(createContentPanel(), BorderLayout.CENTER);

        return centerPanel;
    }

    private JPanel createContentPanel() {

        JPanel contentPanel = new JPanel(new BorderLayout(0, 15));
        contentPanel.setOpaque(false);

        contentPanel.add(createNavigationPanel(), BorderLayout.NORTH);
        contentPanel.add(createItemsSection(), BorderLayout.CENTER);

        return contentPanel;
    }

    private JPanel createItemsPanel() {

        itemsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        itemsPanel.setBackground(new Color(240, 240, 240));

        itemsPanel.add(createItemCard(
                "Phone",
                "05/08/2026",
                "Library",
                "Pending"));

        itemsPanel.add(createItemCard(
                "Wallet",
                "03/08/2026",
                "Student Centre",
                "Found"));

        itemsPanel.add(createItemCard(
                "Laptop",
                "01/08/2026",
                "Computer Lab",
                "Claimed"));

        itemsPanel.add(createItemCard(
                "House Keys",
                "01/08/2026",
                "Computer Lab",
                "Claimed"));

        itemsPanel.add(createItemCard(
                "USB-Stick",
                "01/08/2026",
                "Computer Lab",
                "Claimed"));

        return itemsPanel;
    }

    private JPanel createItemsSection() {

        JPanel itemsSection = new JPanel(new BorderLayout(0, 15));
        itemsSection.setOpaque(false);

        itemsSection.add(createFilterPanel(), BorderLayout.NORTH);
        itemsSection.add(createItemsPanel(), BorderLayout.CENTER);

        return itemsSection;
    }

    private JPanel createFilterPanel() {

        filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filterPanel.setBackground(Color.WHITE);
        filterPanel.setPreferredSize(new Dimension(0, 60));

        JLabel lblFilter = new JLabel("Filter Items");
        lblFilter.setFont(Fonts.Bold.deriveFont(16f));
        lblFilter.setForeground(Colors.DARK_BLUE_TEXT_COLOR);

        cmbFilter = new JComboBox<>();

        cmbFilter.addItem("All");
        cmbFilter.addItem("Lost");
        cmbFilter.addItem("Found");
        cmbFilter.addItem("Claimed");

        cmbFilter.setPreferredSize(new Dimension(170, 35));
        cmbFilter.setFont(Fonts.Medium.deriveFont(14f));

        filterPanel.add(lblFilter);
        filterPanel.add(Box.createHorizontalStrut(15));
        filterPanel.add(cmbFilter);

        return filterPanel;
    }

    private JPanel createItemCard(String itemName,
            String dateLost,
            String location,
            String status) {

        JPanel card = new JPanel(new BorderLayout(10, 10));
        card.setBackground(new Color(245, 245, 245));
        card.setPreferredSize(new Dimension(300, 180));
        card.setBorder(BorderFactory.createLineBorder(Colors.BORDER_GRAY, 1));
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setOpaque(false);

        JLabel lblItem = new JLabel("Item Name : " + itemName);
        lblItem.setFont(Fonts.Bold.deriveFont(15f));
        lblItem.setForeground(Colors.DARK_BLUE_TEXT_COLOR);

        JLabel lblDate = new JLabel("Date Lost : " + dateLost);
        lblDate.setFont(Fonts.Medium.deriveFont(14f));
        lblDate.setForeground(Colors.BLACK_TEXT_COLOR);

        JLabel lblLocation = new JLabel("Location : " + location);
        lblLocation.setFont(Fonts.Medium.deriveFont(14f));
        lblLocation.setForeground(Colors.BLACK_TEXT_COLOR);

        JLabel lblStatus = new JLabel("Status : " + status);
        lblStatus.setFont(Fonts.Medium.deriveFont(14f));
        lblStatus.setForeground(Colors.BLACK_TEXT_COLOR);

        detailsPanel.add(lblItem);
        detailsPanel.add(Box.createVerticalStrut(10));

        detailsPanel.add(lblDate);
        detailsPanel.add(Box.createVerticalStrut(10));

        detailsPanel.add(lblLocation);
        detailsPanel.add(Box.createVerticalStrut(10));

        detailsPanel.add(lblStatus);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setOpaque(false);

        JButton btnView = new JButton("View");
        btnView.setFont(Fonts.Bold.deriveFont(13f));
        btnView.setBackground(Colors.DARK_BLUE_TEXT_COLOR);
        btnView.setForeground(Color.WHITE);
        btnView.setFocusPainted(false);

        JButton btnClaim = new JButton("Claim");
        btnClaim.setFont(Fonts.Bold.deriveFont(13f));
        btnClaim.setBackground(Colors.DARK_BLUE_TEXT_COLOR);
        btnClaim.setForeground(Color.WHITE);
        btnClaim.setFocusPainted(false);

        buttonPanel.add(btnView);
        buttonPanel.add(btnClaim);

        card.add(detailsPanel, BorderLayout.CENTER);
        card.add(buttonPanel, BorderLayout.SOUTH);

        return card;
    }
}