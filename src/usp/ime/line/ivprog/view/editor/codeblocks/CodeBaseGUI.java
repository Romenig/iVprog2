package usp.ime.line.ivprog.view.editor.codeblocks;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import usp.ime.line.ivprog.IVProg2;
import usp.ime.line.ivprog.view.editor.IVPFunctionBody;
import usp.ime.line.ivprog.view.utils.GripArea;
import usp.ime.line.ivprog.view.utils.RoundedJPanel;

public abstract class CodeBaseGUI extends RoundedJPanel {

    private static final long serialVersionUID = 1L;
    protected JPanel compositePanel = new JPanel();
    protected IVPFunctionBody escope = null;
    protected JComponent ivpContainer = null;
    private JPanel gripArea = new JPanel();
    protected int indexAtContainer = -1;

    public CodeBaseGUI() {
        setLayout(new BorderLayout());
        initGripArea();
        initCompositePanel();
        addMouseListener(IVProg2.getMouseListener());
    }

    private void initCompositePanel() {
        compositePanel.setBorder(new EmptyBorder(2, 0, 2, 2));
        compositePanel.setOpaque(false);
        compositePanel.setLayout(new BorderLayout(0, 0));
        add(compositePanel, BorderLayout.CENTER);
    }

    private void initGripArea() {
        GripArea grip = new GripArea();
        gripArea.setLayout(new BorderLayout());
        gripArea.add(grip, BorderLayout.CENTER);
        gripArea.setBorder(new EmptyBorder(0, 2, 2, 2));
        gripArea.add(grip, BorderLayout.CENTER);
        gripArea.setOpaque(false);
        add(gripArea, BorderLayout.WEST);
    }

}
