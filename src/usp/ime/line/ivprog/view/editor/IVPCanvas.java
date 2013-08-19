package usp.ime.line.ivprog.view.editor;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JPanel;

import usp.ime.line.ivprog.IVProg2;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.CodeComposite;
import usp.ime.line.ivprog.view.constants.CommonNames;
import usp.ime.line.ivprog.view.editor.codeblocks.CodeBaseGUI;
import usp.ime.line.ivprog.view.interfaces.CatchableObject;
import usp.ime.line.ivprog.view.interfaces.ViewDomainObject;
import usp.ime.line.ivprog.view.utils.language.ResourceBundleIVP;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Vector;

public class IVPCanvas extends JPanel {

	private boolean isInternal = false;
	private Component ivpContainer = null; 

	public IVPCanvas(boolean isInternalCanvas, Component ivpContainer) {
		isInternal = isInternalCanvas;
		this.ivpContainer = ivpContainer;
		setBackground(Color.WHITE);
		setForeground(Color.LIGHT_GRAY);
		if (getComponentCount() == 0)
			setToolTipText(ResourceBundleIVP
					.getString("canvasWriteCodeMessage"));
		setLayout(new GridBagLayout());
        if (isInternal)
            setPreferredSize(new Dimension(10, 30));
        addMouseListener(IVProg2.getMouseListener());
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (getComponentCount() == 0)
			g.drawString(ResourceBundleIVP.getString("canvasWriteCodeMessage"),
					40, 20);
		for (int i = 0; i <= getSize().height; i += 30) {
			g.drawLine(0, i, getSize().width, i);
		}
		if (!isInternal) {
			for (int j = 0; j <= getSize().height; j += 30) {
				int result = j / 30;
				g.drawString(new String("" + result + ""), 5, j - 10);
			}
			g.setColor(Color.gray);
			g.drawLine(30, 0, 30, getSize().height);
		}
	}

	public boolean isInternal() {
		return isInternal;
	}

	public void setInternal(boolean isInternal) {
		this.isInternal = isInternal;
	}
	
	public void addComponentToCanvas(CatchableObject c){
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 2, 2, 2);
        gbc.gridy = getComponentCount() - 1;
        //atualizo o index do catchable aqui
        c.setIndexAtContainer(getComponentCount()-1);
        add((Component) c, gbc);
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = getComponentCount() - 1;
        Component strut = Box.createVerticalStrut(1);
        add(strut, gbc);
        revalidate();
        repaint();
	}
    
    private void initCanvasHeight() {
        if (getComponentCount() == 0) {
            setPreferredSize(new Dimension(10, 30));
        } else {
            setPreferredSize(null);
        }
    }
    
    public int getDropIndex(int eventY){
    	Component[] components = getComponents();
    	int i = 0;
    	if(components.length > 0)
    		while(components[i].getY() < eventY){
    			i++;
    		}
    	return i;
    }

	public Component getIVPContainer() {
		return ivpContainer;
	}

	public void setIVPContainer(Component ivpContainer) {
		this.ivpContainer = ivpContainer;
	}

	public Vector getIndexVector(int clickY) {
		Vector navigationIndexes = new Vector();
		if(ivpContainer instanceof IVPFunctionBody){
			navigationIndexes.add(((IVPFunctionBody)ivpContainer).getFunctionName());
			navigationIndexes.add(getDropIndex(clickY));
		}else if(ivpContainer instanceof CatchableObject){
			Object container = ivpContainer;
			while(container instanceof CatchableObject){
				navigationIndexes.add(((CatchableObject) container).getIndexOnContainer());
				container = ((CatchableObject) container).getIVPContainer();
			}
			navigationIndexes.add(0,((IVPFunctionBody)ivpContainer).getFunctionName());
			navigationIndexes.add(getDropIndex(clickY));
		}
		return navigationIndexes;
	}

}
