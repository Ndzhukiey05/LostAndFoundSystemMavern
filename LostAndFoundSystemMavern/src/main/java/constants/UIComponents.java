/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constants;

import constants.Colors;
import constants.Fonts;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 *
 * @author 240822757
 */
public class UIComponents {

    public static class RoundedPanel extends JPanel {

        private int cornerRadius;

        public RoundedPanel(int radius, Color bgColor) {
            super();
            this.cornerRadius = radius;
            setOpaque(false);
            setBackground(bgColor);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
            g2.dispose();
        }
    }

    public static class RoundedTextField extends JTextField {

        private int cornerRadius = 20;

        public RoundedTextField(int columns) {
            super(columns);
            setOpaque(false);
            setBorder(new EmptyBorder(8, 12, 8, 12));
            setFont(Fonts.Regular.deriveFont(13f));
            setForeground(Colors.BLACK_TEXT_COLOR);
            setBackground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
            g2.dispose();
            super.paintComponent(g);
        }
    }

    public static class RoundedPasswordField extends JPasswordField {

        private int cornerRadius = 20;

        public RoundedPasswordField(int columns) {
            super(columns);
            setOpaque(false);
            setBorder(new EmptyBorder(8, 12, 8, 12));
            setFont(Fonts.Regular.deriveFont(13f));
            setForeground(Colors.BLACK_TEXT_COLOR);
            setBackground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
            g2.dispose();
            super.paintComponent(g);
        }
    }

    public static class RoundedButton extends JButton {

        private int cornerRadius;

        public RoundedButton(String text, Color bg, Color fg, int radius) {
            super(text);
            this.cornerRadius = radius;
            setOpaque(false);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setBackground(bg);
            setForeground(fg);
            setFont(Fonts.SemiBold.deriveFont(13f));
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
            g2.dispose();
            super.paintComponent(g);
        }
    }
}
