/*
 * 
 * LInE
 * Free Software for Better Education (FSBE)
 * http://www.matematica.br
 * 
 */
package usp.ime.line.ivprog;

import java.util.zip.ZipFile;
import ilm.framework.IlmProtocol;
import ilm.framework.SystemControl;
import javax.swing.JApplet;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import usp.ime.line.ivprog.model.IVPSystemFactory;
import usp.ime.line.ivprog.view.utils.IVPMouseListener;


import com.l2fprod.common.swing.plaf.LookAndFeelAddons;
import com.l2fprod.common.swing.plaf.aqua.AquaLookAndFeelAddons;
import com.l2fprod.common.swing.plaf.metal.MetalLookAndFeelAddons;
import com.l2fprod.common.swing.plaf.windows.WindowsLookAndFeelAddons;

public class IVProg2 extends JApplet implements IlmProtocol {

    private static final long serialVersionUID = 1L;
    private static IlmProtocol _ilmProtocol;
    private static IVPMouseListener ivpML;

    public static void main(String[] args) {
    	ivpML = new IVPMouseListener();
    	try {
    		 LookAndFeelAddons.setAddon(AquaLookAndFeelAddons.class);
    	} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
        final SystemControl ilmControl = new SystemControl();
        ilmControl.initialize(false, args, new IVPSystemFactory());
        _ilmProtocol = ilmControl.getProtocol();
        try {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    ilmControl.startDesktopGUI();
                }
            });
        } catch (Exception e) {
            System.err.println("createGUI didn't complete successfully");
        }
    }

    public void init() {
        String[] args = GetParam();
        final SystemControl ilmControl = new SystemControl();
        ilmControl.initialize(false, args, new IVPSystemFactory());
        _ilmProtocol = ilmControl.getProtocol();
        try {
            SwingUtilities.invokeAndWait(new Runnable() {

                public void run() {
                    add(ilmControl.getAppletGUI());
                }
            });
        } catch (Exception e) {
            System.err.println("createGUI didn't complete successfully");
        }
    }

    private String[] GetParam() {
        String[] s = new String[1];
        s[0] = "";
        return s;
    }

    public float getEvaluation() {
        return _ilmProtocol.getEvaluation();
    }

    public String getAnswer() {
        return _ilmProtocol.getAnswer();
    }

    public ZipFile getAssignmentPackage() {
        return _ilmProtocol.getAssignmentPackage();
    }
    
    public static IVPMouseListener getMouseListener(){
    	return ivpML;
    }
}
