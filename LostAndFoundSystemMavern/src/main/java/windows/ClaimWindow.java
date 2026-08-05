// 221106901
package windows;

import constants.Colors;
import constants.Fonts;
import constants.Icons;
import constants.UIComponents;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


public class ClaimWindow extends JFrame {

    private JPanel claimsContainer;

    public ClaimWindow() {
        super("Campus Finder - Claims");
        guiSetUp();
    }

    private void guiSetUp() {
        setTitle("Campus Finder - Claims");
        setSize(1100, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        PUSH DEV BRANCH
        
        // Main Background Panel
        JPanel backgroundPanel = new JPanel(new BorderLayout(20, 20));
        backgroundPanel.setBackground(Colors.DARK_BLUE_TEXT_COLOR);
        backgroundPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        setContentPane(backgroundPanel);

        // 1. Sidebar Menu (Left)
        backgroundPanel.add(createSidebarPanel(), BorderLayout.WEST);

        // 2. Right Workspace Area
        JPanel rightWorkspace = new JPanel(new BorderLayout(0, 15));
        rightWorkspace.setOpaque(false);

        JPanel topHeaderSection = new JPanel();
        topHeaderSection.setLayout(new BoxLayout(topHeaderSection, BoxLayout.Y_AXIS));
        topHeaderSection.setOpaque(false);

        topHeaderSection.add(createTitleBanner());
        topHeaderSection.add(Box.createRigidArea(new Dimension(0, 12)));
        topHeaderSection.add(createTopNavBar());

        rightWorkspace.add(topHeaderSection, BorderLayout.NORTH);

        // Claims Cards Scrollable Workspace
        UIComponents.RoundedPanel mainContentContainer = new UIComponents.RoundedPanel(25, Colors.MOCKUP_CARD_BG);
        mainContentContainer.setLayout(new BorderLayout());
        mainContentContainer.setBorder(new EmptyBorder(20, 20, 20, 20));

        claimsContainer = new JPanel();
        claimsContainer.setLayout(new BoxLayout(claimsContainer, BoxLayout.Y_AXIS));
        claimsContainer.setOpaque(false);

        loadDummyClaims();

        JScrollPane scrollPane = new JScrollPane(claimsContainer);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(12);

        mainContentContainer.add(scrollPane, BorderLayout.CENTER);
        rightWorkspace.add(mainContentContainer, BorderLayout.CENTER);

        backgroundPanel.add(rightWorkspace, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createSidebarPanel() {
        UIComponents.RoundedPanel sidebar = new UIComponents.RoundedPanel(25, Colors.SIDEBAR_COLOR);
        sidebar.setPreferredSize(new Dimension(240, 0));
        sidebar.setLayout(new BorderLayout(0, 10));
        sidebar.setBorder(new EmptyBorder(25, 20, 20, 20));

        JLabel lblProfile = new JLabel("PROFILE");
        lblProfile.setFont(Fonts.Bold.deriveFont(22f));
        lblProfile.setForeground(Colors.DARK_BLUE_TEXT_COLOR);

        JPanel topSidebar = new JPanel();
        topSidebar.setLayout(new BoxLayout(topSidebar, BoxLayout.Y_AXIS));
        topSidebar.setOpaque(false);
        topSidebar.add(lblProfile);
        topSidebar.add(Box.createRigidArea(new Dimension(0, 15)));

        JSeparator line = new JSeparator();
        line.setForeground(Colors.BORDER_GRAY);
        line.setMaximumSize(new Dimension(200, 2));
        topSidebar.add(line);
        topSidebar.add(Box.createRigidArea(new Dimension(0, 15)));

        JPanel menuList = new JPanel();
        menuList.setLayout(new BoxLayout(menuList, BoxLayout.Y_AXIS));
        menuList.setOpaque(false);

        String[] menuItems = {"Report Lost Item", "Report Found Item", "View All Posts", "Claims", "Help"};

        for (String item : menuItems) {
            JPanel btnWrapper = new JPanel(new BorderLayout());
            btnWrapper.setOpaque(false);
            btnWrapper.setMaximumSize(new Dimension(200, 38));

            JButton menuBtn = new JButton(item);
            menuBtn.setFont(Fonts.Medium.deriveFont(13f));
            menuBtn.setForeground(Colors.BLACK_TEXT_COLOR);
            menuBtn.setContentAreaFilled(false);
            menuBtn.setBorderPainted(false);
            menuBtn.setFocusPainted(false);
            menuBtn.setHorizontalAlignment(SwingConstants.LEFT);
            menuBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

            if (item.contains("Lost")) menuBtn.setIcon(Icons.LostItem);
            else if (item.contains("Found")) menuBtn.setIcon(Icons.FoundItem);
            else if (item.equals("Claims")) menuBtn.setIcon(Icons.Claims);
            else if (item.equals("View All Posts")) menuBtn.setIcon(Icons.ViewAllPosts);

            if (item.equals("Claims")) {
                btnWrapper.setOpaque(true);
                btnWrapper.setBackground(Colors.MOCKUP_HIGHLIGHT_BG);
                menuBtn.setFont(Fonts.Bold.deriveFont(13f));
            }

            menuBtn.addActionListener(e -> {});

            btnWrapper.add(menuBtn, BorderLayout.CENTER);
            menuList.add(btnWrapper);
            menuList.add(Box.createRigidArea(new Dimension(0, 8)));
        }

        topSidebar.add(menuList);
        sidebar.add(topSidebar, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);

        JSeparator bottomLine = new JSeparator();
        bottomLine.setForeground(Colors.BORDER_GRAY);

        JButton btnLogout = new JButton("Logout", Icons.Home);
        btnLogout.setFont(Fonts.Medium.deriveFont(14f));
        btnLogout.setContentAreaFilled(false);
        btnLogout.setBorderPainted(false);
        btnLogout.setFocusPainted(false);
        btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
        btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnLogout.addActionListener(e -> {});

        bottomPanel.add(bottomLine, BorderLayout.NORTH);
        bottomPanel.add(btnLogout, BorderLayout.SOUTH);

        sidebar.add(bottomPanel, BorderLayout.SOUTH);

        return sidebar;
    }

    private JPanel createTitleBanner() {
        UIComponents.RoundedPanel banner = new UIComponents.RoundedPanel(20, Colors.HEADER_COLOR);
        banner.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 12));
        banner.setMaximumSize(new Dimension(2000, 50));

        JLabel lblClaims = new JLabel("CLAIMS");
        lblClaims.setFont(Fonts.Bold.deriveFont(20f));
        lblClaims.setForeground(Colors.DARK_BLUE_TEXT_COLOR);

        banner.add(lblClaims);
        return banner;
    }

    private JPanel createTopNavBar() {
        UIComponents.RoundedPanel navBar = new UIComponents.RoundedPanel(20, Colors.NAVBAR_COLOR);
        navBar.setLayout(new BorderLayout());
        navBar.setBorder(new EmptyBorder(8, 20, 8, 20));
        navBar.setMaximumSize(new Dimension(2000, 50));

        JLabel homeIcon = new JLabel(Icons.Home);
        homeIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JPanel rightIcons = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 0));
        rightIcons.setOpaque(false);

        JLabel searchIcon = new JLabel(Icons.Search);
        JLabel bellIcon = new JLabel(Icons.Bell);

        searchIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bellIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));

        rightIcons.add(searchIcon);
        rightIcons.add(bellIcon);

        navBar.add(homeIcon, BorderLayout.WEST);
        navBar.add(rightIcons, BorderLayout.EAST);

        return navBar;
    }

    private void loadDummyClaims() {
        addClaimCard("Laptop", "12-March-2026", "Library", "Pending");
        addClaimCard("Student Card", "12-March-2026", "Library", "Approved");
        addClaimCard("Wallet", "12-March-2026", "Cafeteria", "Rejected");
    }

    public void addClaimCard(String item, String date, String location, String status) {
        JPanel cardWrapper = new JPanel();
        cardWrapper.setLayout(new BoxLayout(cardWrapper, BoxLayout.Y_AXIS));
        cardWrapper.setOpaque(false);
        cardWrapper.setAlignmentX(Component.CENTER_ALIGNMENT);

        UIComponents.RoundedPanel detailsPanel = new UIComponents.RoundedPanel(15, Colors.LOGIN_BACKGROUND_COLOR);
        detailsPanel.setLayout(new BorderLayout());
        detailsPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Colors.BORDER_GRAY, 1),
                new EmptyBorder(12, 16, 12, 16)
        ));
        detailsPanel.setMaximumSize(new Dimension(420, 100));
        detailsPanel.setPreferredSize(new Dimension(420, 100));

        JPanel leftDetails = new JPanel(new GridLayout(3, 1, 0, 3));
        leftDetails.setOpaque(false);

        JLabel lblItem = new JLabel("Item: " + item);
        lblItem.setFont(Fonts.SemiBold.deriveFont(13f));

        JLabel lblDate = new JLabel("Date Lost : " + date);
        lblDate.setFont(Fonts.Regular.deriveFont(13f));
        lblDate.setForeground(Colors.DASHBOARD_BACKGROUND_COLOR);

        JLabel lblLocation = new JLabel("Location : " + location);
        lblLocation.setFont(Fonts.Regular.deriveFont(13f));
        lblLocation.setForeground(Colors.DASHBOARD_BACKGROUND_COLOR);

        leftDetails.add(lblItem);
        leftDetails.add(lblDate);
        leftDetails.add(lblLocation);

        JLabel lblStatus = new JLabel("Status: " + status);
        lblStatus.setFont(Fonts.Bold.deriveFont(13f));

        if ("Pending".equalsIgnoreCase(status)) {
            lblStatus.setForeground(Colors.YELLOW_STATUS_COLOR);
        } else if ("Approved".equalsIgnoreCase(status)) {
            lblStatus.setForeground(Colors.GREEN_STATUS_COLOR);
        } else {
            lblStatus.setForeground(Colors.RED_STATUS_COLOR);
        }

        JPanel statusWrapper = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        statusWrapper.setOpaque(false);
        statusWrapper.add(lblStatus);

        detailsPanel.add(leftDetails, BorderLayout.WEST);
        detailsPanel.add(statusWrapper, BorderLayout.EAST);

        JPanel buttonsRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonsRow.setOpaque(false);
        buttonsRow.setBorder(new EmptyBorder(8, 0, 0, 0));
        
        // Make that btns Work boi
        // Instantiating buttons and adding action listeners for window navigation
        UIComponents.RoundedButton btnCancel = new UIComponents.RoundedButton("Cancel Claim", Colors.LOGIN_BACKGROUND_COLOR, Colors.BLACK_TEXT_COLOR, 15);
        UIComponents.RoundedButton btnEdit = new UIComponents.RoundedButton("Edit Claim", Colors.LOGIN_BACKGROUND_COLOR, Colors.BLACK_TEXT_COLOR, 15);
        UIComponents.RoundedButton btnView = new UIComponents.RoundedButton("View Claim", Colors.LOGIN_BACKGROUND_COLOR, Colors.BLACK_TEXT_COLOR, 15);

        // Edit Claim Button > Opens ClaimFormWindow and closes current window
        btnEdit.addActionListener(e -> {
            new ClaimFormWindow();
            dispose();
        });

        // View Claim Button > Opens ItemDetailsWindow and closes current window
        btnView.addActionListener(e -> {
            new ItemDetailsWindow();
            dispose();
        });
        // Cancel Claim Button > Placeholder for cancel logic
        btnCancel.addActionListener(e -> {
            
        });
        //we now added some movement 
        
//This is yo Dummy btns Boi --------------------------------------------------------------------------------------------------
  /*      UIComponents.RoundedButton btnCancel = new UIComponents.RoundedButton("Cancel Claim", Colors.LOGIN_BACKGROUND_COLOR, Colors.BLACK_TEXT_COLOR, 15);
        UIComponents.RoundedButton btnEdit = new UIComponents.RoundedButton("Edit Claim", Colors.LOGIN_BACKGROUND_COLOR, Colors.BLACK_TEXT_COLOR, 15);
        UIComponents.RoundedButton btnView = new UIComponents.RoundedButton("View Claim", Colors.LOGIN_BACKGROUND_COLOR, Colors.BLACK_TEXT_COLOR, 15);

        btnCancel.addActionListener(e -> {});
        btnEdit.addActionListener(e -> {});
        btnView.addActionListener(e -> {});
  */      
//---------------------------------------------------------------------------------------------------------------------------------  
  
        Border btnOutline = BorderFactory.createLineBorder(Colors.BORDER_GRAY, 1);
        btnCancel.setBorder(btnOutline);
        btnEdit.setBorder(btnOutline);
        btnView.setBorder(btnOutline);

        btnCancel.setPreferredSize(new Dimension(115, 30));
        btnEdit.setPreferredSize(new Dimension(115, 30));
        btnView.setPreferredSize(new Dimension(115, 30));

        buttonsRow.add(btnCancel);
        buttonsRow.add(btnEdit);
        buttonsRow.add(btnView);

        cardWrapper.add(detailsPanel);
        cardWrapper.add(buttonsRow);
        cardWrapper.add(Box.createRigidArea(new Dimension(0, 25)));

        claimsContainer.add(cardWrapper);
    }
/* This was just to view page
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ClaimWindow::new);
    }*/
}