//230236901

package windows;

import components.PageHeaderPanel;
import components.SideBarPanel;
import constants.Colors;
import constants.Fonts;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ViewAllPostsWindow extends JFrame {

    private JPanel sidebarPanel;
    private JPanel headerPanel;
    private JPanel filterPanel;
    private JPanel centerPanel;
    private JPanel itemsPanel;
    private JComboBox<String> cmbFilter;

    public ViewAllPostsWindow() {
        guiSetUp();
    }

    private void guiSetUp() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(73, 107, 145));
        setLayout(new BorderLayout(15, 15));

        sidebarPanel = new SideBarPanel();
        headerPanel = createHeaderPanel();
        centerPanel = createCenterPanel();

        JPanel center = new JPanel(new BorderLayout(15, 15));
        center.setOpaque(false);
        center.add(headerPanel, BorderLayout.NORTH);
        center.add(centerPanel, BorderLayout.CENTER);

        add(sidebarPanel, BorderLayout.WEST);
        add(center, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createHeaderPanel() {
        return new PageHeaderPanel("VIEW ALL POSTS");
    }

    private JPanel createCenterPanel() {
        centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        centerPanel.setBackground(new Color(73, 107, 145));
        centerPanel.add(createContentPanel(), BorderLayout.CENTER);

        return centerPanel;
    }

    private JPanel createContentPanel() {
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(220, 220, 220));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        contentPanel.add(createFilterPanel());
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(createItemsPanel());

        return contentPanel;
    }

    private JPanel createFilterPanel() {
        filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filterPanel.setBackground(Color.WHITE);
        filterPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
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

    private JPanel createItemsPanel() {
        itemsPanel = new JPanel(new GridLayout(0, 2, 20, 20));
        itemsPanel.setBackground(new Color(240, 240, 240));

        itemsPanel.add(createItemCard("Phone", "05/08/2026", "Library", "Pending"));
        itemsPanel.add(createItemCard("Wallet", "03/08/2026", "Student Centre", "Found"));
        itemsPanel.add(createItemCard("Laptop", "01/08/2026", "Computer Lab", "Claimed"));
        itemsPanel.add(createItemCard("House Keys", "01/08/2026", "Computer Lab", "Claimed"));
        itemsPanel.add(createItemCard("USB-Stick", "01/08/2026", "Computer Lab", "Claimed"));

        return itemsPanel;
    }

    private JPanel createItemCard(String itemName, String dateLost, String location, String status) {
        JPanel card = new JPanel(new BorderLayout(10, 10));
        card.setBackground(Color.WHITE);
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