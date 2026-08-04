//250055392
package windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ReportLostItemWindow extends JFrame implements ActionListener, MouseListener {

    private JButton profileBtn, cancelBtn, subBtn, lostBtn, foundBtn, viewPostBtn, claimsBtn, helpBtn, homeBtn, searchBtn, notificationBtn, logoutBtn, uploadBtn;
    private JLabel devideLineLbl1, devideLineLbl2, pageHeading, itemTypeheading, itemlbl, categorylbl, datelbl, locationLbl, descriptionlbl, itemImagelbl, imageSpaceLbl;
    private JTextField nameFiled, dateField, locationFiled, searchBar;
    private JPanel mainPanel, sideMenuPanel, headingPanel, middlePanel, formWindowPanel, centrePanel, searchBarPanel;
    private JComboBox categories;
    private JTextArea descriptionArea;
    private JPanel sideButtonsPanel, sideHeadingPanel, logoutPanel, itemTypePanel, formPnel, fillPanel, uploadImagePanel, namesPanel, buttonsPanel, descriptionPanel;
    private JPanel serachBarLeftPanel, searBarCenterPanel, searchBarRightPanel, uploadLblPanel, uploadButtonPanel;
    private JScrollPane scrollpane;
    private ImageIcon home, search, notification, uploadedImage, originalImage;
    private JFileChooser fileChooser;

    public ReportLostItemWindow() {
        super("Report Lost Item WIndow");
        setSize(1400, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(6, 57, 112));
        mainPanel.setOpaque(true);

        add(mainPanel);

        // The side menu panel;
        sideMenuPanel = new JPanel(new BorderLayout());
        //mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10, 10, 10));
        profileBtn = new JButton("PROFILE");
        profileBtn.setBorderPainted(false);
        profileBtn.setFocusPainted(false);
        profileBtn.setContentAreaFilled(false);

        lostBtn = new JButton("Report Lost Item");
        lostBtn.setBorderPainted(false);
        lostBtn.setFocusPainted(false);
        lostBtn.setContentAreaFilled(false);

        foundBtn = new JButton("Report Found Item");
        foundBtn.setBorderPainted(false);
        foundBtn.setFocusPainted(false);
        foundBtn.setContentAreaFilled(false);

        viewPostBtn = new JButton("View All Posts");
        viewPostBtn.setBorderPainted(false);
        viewPostBtn.setFocusPainted(false);
        viewPostBtn.setContentAreaFilled(false);

        claimsBtn = new JButton("Claims");
        claimsBtn.setBorderPainted(false);
        claimsBtn.setFocusPainted(false);
        claimsBtn.setContentAreaFilled(false);

        helpBtn = new JButton("Help");
        helpBtn.setBorderPainted(false);
        helpBtn.setFocusPainted(false);
        helpBtn.setContentAreaFilled(false);

        logoutBtn = new JButton("      Logout");
        logoutBtn.setBorderPainted(false);
        logoutBtn.setFocusPainted(false);
        logoutBtn.setContentAreaFilled(false);

        devideLineLbl1 = new JLabel("________________________");
        devideLineLbl2 = new JLabel("________________________");

        sideHeadingPanel = new JPanel(new GridLayout(2, 1));
        profileBtn.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 0));
        profileBtn.setFont(new Font("Arial", Font.BOLD, 28));
        profileBtn.setForeground(new Color(6, 57, 112));

        sideHeadingPanel.add(profileBtn);
        sideHeadingPanel.add(devideLineLbl1);
        sideMenuPanel.add(sideHeadingPanel, BorderLayout.NORTH);

        helpBtn.setHorizontalAlignment(SwingConstants.LEFT);
        foundBtn.setHorizontalAlignment(SwingConstants.LEFT);
        lostBtn.setHorizontalAlignment(SwingConstants.LEFT);
        claimsBtn.setHorizontalAlignment(SwingConstants.LEFT);
        viewPostBtn.setHorizontalAlignment(SwingConstants.LEFT);
        logoutBtn.setHorizontalAlignment(SwingConstants.LEFT);

        sideButtonsPanel = new JPanel(new GridLayout(5, 1));
        sideButtonsPanel.add(lostBtn);
        sideButtonsPanel.add(foundBtn);
        sideButtonsPanel.add(viewPostBtn);
        sideButtonsPanel.add(claimsBtn);
        sideButtonsPanel.add(helpBtn);
        sideMenuPanel.add(sideButtonsPanel, BorderLayout.CENTER);
        sideButtonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 400, 0));

        logoutPanel = new JPanel(new GridLayout(2, 1));
        logoutPanel.add(devideLineLbl2);
        logoutPanel.add(logoutBtn);
        logoutBtn.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        sideMenuPanel.add(logoutPanel, BorderLayout.SOUTH);

        mainPanel.add(sideMenuPanel, BorderLayout.WEST);

        sideMenuPanel.setBackground(Color.WHITE);
        sideMenuPanel.setOpaque(true);

        foundBtn.setOpaque(false);
        viewPostBtn.setOpaque(false);
        claimsBtn.setOpaque(false);
        helpBtn.setOpaque(false);
        logoutBtn.setOpaque(false);
        devideLineLbl1.setOpaque(false);
        devideLineLbl2.setOpaque(false);
        sideButtonsPanel.setOpaque(false);
        sideHeadingPanel.setOpaque(false);
        logoutPanel.setOpaque(false);

        //The Centre Panel
        centrePanel = new JPanel(new BorderLayout(0, 10));
        mainPanel.add(centrePanel, BorderLayout.CENTER);
        centrePanel.setOpaque(false);

        headingPanel = new JPanel(new GridLayout(2, 1, 0, 10));

        pageHeading = new JLabel("REPORT LOST ITEM");
        headingPanel.add(pageHeading);

        centrePanel.add(headingPanel, BorderLayout.NORTH);
        pageHeading.setFont(new Font("Arial", Font.BOLD, 30));
        pageHeading.setForeground(new Color(6, 57, 112));
        pageHeading.setBackground(Color.WHITE);
        pageHeading.setOpaque(true);
        centrePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        searchBarPanel = new JPanel(new BorderLayout());

        serachBarLeftPanel = new JPanel(new FlowLayout());
        serachBarLeftPanel.setOpaque(false);
        searchBarRightPanel = new JPanel(new FlowLayout());
        searchBarRightPanel.setOpaque(false);

        home = new ImageIcon("pictures/home-icon.png");
        Image originalHomeImg = home.getImage();
        Image scaledImg = originalHomeImg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        home = new ImageIcon(scaledImg);
        homeBtn = new JButton(home);
        homeBtn.setPreferredSize(new Dimension(30, 30));
        homeBtn.setBorderPainted(false);
        homeBtn.setFocusPainted(false);
        homeBtn.setContentAreaFilled(false);

        search = new ImageIcon("pictures/Search.png");
        Image originalSearchImage = search.getImage();
        scaledImg = originalSearchImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

        search = new ImageIcon(scaledImg);
        searchBtn = new JButton(search);
        searchBtn.setPreferredSize(new Dimension(30, 30));
        searchBtn.setBorderPainted(false);
        searchBtn.setFocusPainted(false);
        searchBtn.setContentAreaFilled(false);

        notification = new ImageIcon("pictures/Nottification.png");
        Image originalNotifImage = notification.getImage();
        scaledImg = originalNotifImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        notification = new ImageIcon(scaledImg);

        notificationBtn = new JButton(notification);
        notificationBtn.setPreferredSize(new Dimension(30, 30));
        notificationBtn.setBorderPainted(false);
        notificationBtn.setFocusPainted(false);
        notificationBtn.setContentAreaFilled(false);

        searchBar = new JTextField(35);
        searchBar.setPreferredSize(new Dimension(1, 30));

        serachBarLeftPanel.add(homeBtn);
        searchBarRightPanel.add(searchBar);
        searchBarRightPanel.add(searchBtn);
        searchBarRightPanel.add(notificationBtn);

        searchBarPanel.add(serachBarLeftPanel, BorderLayout.WEST);
        searchBarPanel.add(searchBarRightPanel, BorderLayout.EAST);

        searchBarPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
        headingPanel.add(searchBarPanel);
        headingPanel.setOpaque(false);
        searchBarPanel.setOpaque(true);
        searchBarPanel.setBackground(Color.WHITE);

        itemTypeheading = new JLabel("Lost Item");
        itemlbl = new JLabel("Item Name:");
        categorylbl = new JLabel("Category:");
        datelbl = new JLabel("Date Lost:");
        locationLbl = new JLabel("Location:");
        descriptionlbl = new JLabel("Description:");
        itemImagelbl = new JLabel("Upload Image:");

        nameFiled = new JTextField(15);
        dateField = new JTextField(15);
        locationFiled = new JTextField(15);
        descriptionArea = new JTextArea(15, 20);
        categories = new JComboBox(new String[]{"Select category", "Electronics", "Books & Stationary", "Cards and Document", "Sport Equipment", "Clothing", "Keys", "Bottles & Boxes", "Jewellery", "Other"});
        uploadBtn = new JButton("Upload Image");

        formWindowPanel = new JPanel(new BorderLayout());
        formWindowPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 0, 30));
        //formWindowPanel.setBackground(Color.gray);

        itemTypePanel = new JPanel(new GridLayout());
        formPnel = new JPanel(new GridLayout(1, 2));
        fillPanel = new JPanel(new BorderLayout(0, 30));

        namesPanel = new JPanel(new GridLayout(4, 2, -300, 30));
        buttonsPanel = new JPanel(new FlowLayout());
        descriptionPanel = new JPanel(new BorderLayout(0, 15));

        centrePanel.add(formWindowPanel, BorderLayout.CENTER);
        formWindowPanel.add(itemTypePanel, BorderLayout.NORTH);
        itemTypePanel.add(itemTypeheading);
        itemTypeheading.setFont(new Font("Arial", Font.BOLD, 20));
        itemTypeheading.setForeground(new Color(6, 57, 112));

        formWindowPanel.add(formPnel, BorderLayout.CENTER);
        formPnel.add(fillPanel);

        fillPanel.add(namesPanel, BorderLayout.NORTH);

        namesPanel.add(itemlbl);
        namesPanel.add(nameFiled);
        namesPanel.add(categorylbl);
        namesPanel.add(categories);
        namesPanel.add(datelbl);
        namesPanel.add(dateField);
        namesPanel.add(locationLbl);
        namesPanel.add(locationFiled);
        namesPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

        descriptionPanel.add(descriptionlbl, BorderLayout.NORTH);

        scrollpane = new JScrollPane(descriptionArea);
        descriptionPanel.add(scrollpane, BorderLayout.CENTER);
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 150));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);

        fillPanel.add(descriptionPanel, BorderLayout.CENTER);

        fillPanel.add(descriptionPanel, BorderLayout.CENTER);

        buttonsPanel = new JPanel(new FlowLayout());

        subBtn = new JButton("Submit");
        subBtn.setBackground(Color.BLUE);
        subBtn.setForeground(Color.WHITE);
        subBtn.setFocusPainted(false);
        cancelBtn = new JButton("Cancel");
        buttonsPanel.add(subBtn);
        buttonsPanel.add(cancelBtn);
        fillPanel.add(buttonsPanel, BorderLayout.SOUTH);
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 230, 20, 0));

        uploadImagePanel = new JPanel(new BorderLayout(0, 20));
        uploadLblPanel = new JPanel(new GridLayout());
        uploadButtonPanel = new JPanel(new BorderLayout());

        imageSpaceLbl = new JLabel();

        formPnel.add(uploadImagePanel);
        uploadImagePanel.add(uploadLblPanel, BorderLayout.NORTH);
        uploadImagePanel.add(uploadButtonPanel, BorderLayout.CENTER);
        uploadLblPanel.add(itemImagelbl);

        imageSpaceLbl.setBackground(Color.WHITE);
        imageSpaceLbl.setOpaque(true);
        imageSpaceLbl.setPreferredSize(new Dimension(0, 120));

        uploadButtonPanel.add(imageSpaceLbl, BorderLayout.NORTH);
        uploadButtonPanel.add(uploadBtn, BorderLayout.CENTER);

        uploadImagePanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 310, 150));

        homeBtn.addActionListener(this);
        lostBtn.addActionListener(this);
        foundBtn.addActionListener(this);
        notificationBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        helpBtn.addActionListener(this);
        claimsBtn.addActionListener(this);
        profileBtn.addActionListener(this);
        logoutBtn.addActionListener(this);

        lostBtn.addMouseListener(this);
        foundBtn.addMouseListener(this);
        helpBtn.addMouseListener(this);
        claimsBtn.addMouseListener(this);
        viewPostBtn.addMouseListener(this);
        uploadBtn.addActionListener(this);
        imageSpaceLbl.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeBtn) {
            new Dashboard();
        }

        if (e.getSource() == foundBtn) {
            new ReportFoundItemWindow();
        }

        if (e.getSource() == lostBtn) {
            new ReportLostItemWindow();
        }

        if (e.getSource() == claimsBtn) {
            new ClaimWindow();
        }

        if (e.getSource() == profileBtn) {
            new ProfileWindow();
        }

        if (e.getSource() == helpBtn) {
            new HelpWindow();
        }

        if (e.getSource() == cancelBtn) {
            nameFiled.setText("");
            dateField.setText("");
            locationFiled.setText("");
            descriptionArea.setText("");
            categories.setSelectedIndex(0);
        }

        if (e.getSource() == notificationBtn) {
            new NotificationsWindow();
        }

        if (e.getSource() == logoutBtn) {
            new LogInWindow();

            JOptionPane.showMessageDialog(this, "Loging out...");
        }

        if (e.getSource() == uploadBtn) {
            fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File filePath = new File(fileChooser.getSelectedFile().getAbsolutePath());

                originalImage = new ImageIcon(filePath.getAbsolutePath());

                Image scaledImage = originalImage.getImage().getScaledInstance(320, 150, Image.SCALE_SMOOTH);

                ImageIcon scaledIcon = new ImageIcon(scaledImage);
                imageSpaceLbl.setIcon(scaledIcon);

                Image prevImage = originalImage.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH);

                originalImage = new ImageIcon(prevImage);

            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (originalImage != null) {

            JLabel expandSpace = new JLabel(originalImage);
            expandSpace.setPreferredSize(new Dimension(1250, 750));
            expandSpace.setBackground(Color.BLACK);
            expandSpace.setOpaque(true);
            JOptionPane.showMessageDialog(this, expandSpace, "Image Preview", JOptionPane.PLAIN_MESSAGE);

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == lostBtn) {
            lostBtn.setBorderPainted(true);
            lostBtn.setFocusPainted(true);
            lostBtn.setContentAreaFilled(true);
        }

        if (e.getSource() == foundBtn) {
            foundBtn.setBorderPainted(true);
            foundBtn.setFocusPainted(true);
            foundBtn.setContentAreaFilled(true);
        }
        if (e.getSource() == claimsBtn) {
            claimsBtn.setBorderPainted(true);
            claimsBtn.setFocusPainted(true);
            claimsBtn.setContentAreaFilled(true);
        }

        if (e.getSource() == viewPostBtn) {
            viewPostBtn.setBorderPainted(true);
            viewPostBtn.setFocusPainted(true);
            viewPostBtn.setContentAreaFilled(true);
        }

        if (e.getSource() == helpBtn) {
            helpBtn.setBorderPainted(true);
            helpBtn.setFocusPainted(true);
            helpBtn.setContentAreaFilled(true);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == lostBtn) {
            lostBtn.setBorderPainted(false);
            lostBtn.setFocusPainted(false);
            lostBtn.setContentAreaFilled(false);
        }

        if (e.getSource() == foundBtn) {
            foundBtn.setBorderPainted(false);
            foundBtn.setFocusPainted(false);
            foundBtn.setContentAreaFilled(false);
        }
        if (e.getSource() == claimsBtn) {
            claimsBtn.setBorderPainted(false);
            claimsBtn.setFocusPainted(false);
            claimsBtn.setContentAreaFilled(false);
        }

        if (e.getSource() == viewPostBtn) {
            viewPostBtn.setBorderPainted(false);
            viewPostBtn.setFocusPainted(false);
            viewPostBtn.setContentAreaFilled(false);
        }

        if (e.getSource() == helpBtn) {
            helpBtn.setBorderPainted(false);
            helpBtn.setFocusPainted(false);
            helpBtn.setContentAreaFilled(false);

        }
    }

}
