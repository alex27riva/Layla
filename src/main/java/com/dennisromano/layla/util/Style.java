package com.dennisromano.layla.util;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Style {
    public static final Font PLAIN_FONT = generateFont(Font.PLAIN, 14f);
    public static final Font BOLD_FONT = generateFont(Font.BOLD, 44f);

    private static Font generateFont(int type, float size) {
        try {
            final URL resource = Style.class.getClassLoader().getResource("font/DMSans.ttf");

            if (resource != null && resource.getPath() != null) {
                final String fontPath = resource.getPath();
                final File fontFile = new File(fontPath);

                return Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(type, size);
            }
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }

        throw new RuntimeException("Errore nel generateFont!");
    }

    public static JButton customButton(String text) {
        final Border border = new EmptyBorder(8, 8, 8, 8);

        final JButton button = new JButton(text);
        button.setFont(PLAIN_FONT);
        button.setBorder(border);
        button.setForeground(new Color(56, 58, 66));
        button.setBackground(new Color(228, 192, 122));
        button.setFocusable(false);

        return button;
    }

    public static JButton menuButton(String text) {
        final Border border = new EmptyBorder(8, 8, 8, 8);

        final JButton button = new JButton(text);
        button.setFont(PLAIN_FONT);
        button.setBorder(border);
        button.setForeground(new Color(56, 58, 66));
        button.setBackground(null);
        button.setFocusable(false);

        return button;
    }

    public static JTextField customTextField(String pageNumber) {
        Border lineBorder = BorderFactory.createLineBorder(new Color(204, 204, 204), 1);
        Border emptyBorder = new EmptyBorder(8, 8, 8, 8);
        Border border = BorderFactory.createCompoundBorder(lineBorder, emptyBorder);

        final JTextField textField = new JTextField(8);
        textField.setForeground(new Color(56, 58, 66));
        textField.setBorder(border);
        textField.setText(pageNumber);
        textField.setFont(PLAIN_FONT);
        textField.setHorizontalAlignment(SwingConstants.CENTER);

        return textField;
    }
}