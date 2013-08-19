package usp.ime.line.ivprog.view.editor.codeblocks;

import ilm.framework.assignment.model.DomainObject;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import usp.ime.line.ivprog.IVProg2;
import usp.ime.line.ivprog.view.editor.IVPFunctionBody;
import usp.ime.line.ivprog.view.interfaces.CatchableObject;
import usp.ime.line.ivprog.view.utils.language.ResourceBundleIVP;

import java.awt.GridBagConstraints;

public class CodeMiniPanel extends CodeBaseGUI {

    private static final long serialVersionUID = 1L;
    private Color bgColor = null;
    private String labelText = null;
    private JPanel container = null;
    private JLabel label = null;
    private String className = null;

    public CodeMiniPanel(String text, String className) {
        initContainer();
        initSize();
        addComponents();
        this.className = className;
        labelText = text;
        setLabelText(labelText);
        addMouseListener(IVProg2.getMouseListener());
    }

    private void initContainer() {
        container = new JPanel();
        container.setLayout(new GridBagLayout());
        container.setOpaque(false);
    }

    private void initSize() {
        setPreferredSize(new Dimension(180, 25));
        setMinimumSize(new Dimension(180, 25));
    }

    private void initLabel(String text) {
        label = new JLabel(text);
        label.setFont(new Font("Dialog", Font.PLAIN, 12));
    }

    private void addComponents() {
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        gbc2.weightx = 1.0;
        Component strut = Box.createVerticalStrut(10);
        container.add(strut, gbc2);
        compositePanel.add(container, BorderLayout.CENTER);
    }

    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        setBackground(bgColor);
        this.bgColor = bgColor;
    }

    public String getLabelText() {
        return labelText;
    }

    public void setLabelText(String labelText) {
        this.labelText = labelText;
        initLabel(this.labelText);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        container.add(label, gbc);
    }

	public CatchableObject getCatchable() {
		return null;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
}
