package usp.ime.line.ivprog.model;

import java.util.Vector;
import java.util.HashMap;

import usp.ime.line.ivprog.model.domain.IVPDomainConverter;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import usp.ime.line.ivprog.view.IVPAuthoringGUI;
import usp.ime.line.ivprog.view.IVPDomainGUI;
import ilm.framework.SystemFactory;
import ilm.framework.assignment.model.AssignmentState;
import ilm.framework.config.SystemConfig;
import ilm.framework.domain.DomainConverter;
import ilm.framework.domain.DomainGUI;
import ilm.framework.domain.DomainModel;
import ilm.framework.gui.AuthoringGUI;
import ilm.framework.modules.IlmModule;

public class IVPSystemFactory extends SystemFactory {

    public DomainModel createDomainModel() {
        return new IVPDomainModel();
    }

    public DomainConverter createDomainConverter() {
        return new IVPDomainConverter();
    }

    public DomainGUI createDomainGUI(SystemConfig config, DomainModel model) {
        IVPDomainGUI domainGUI = new IVPDomainGUI();
        domainGUI.initDomainActionList(model);
        return domainGUI;
    }

    public AuthoringGUI createAuthoringGUI(DomainGUI domainGUI, String proposition,
            AssignmentState initial, AssignmentState current, AssignmentState expected,
            HashMap config, HashMap metadata) {
        AuthoringGUI gui = new IVPAuthoringGUI();
        gui.setComponents(config, domainGUI, metadata);
        gui.setAssignment(proposition, initial, current, expected);
        return gui;
    }

    protected Vector getIlmModuleList() {
        Vector list = new Vector();
        // list.add(new ScriptModule());
        // list.add(new ExampleTracingTutorModule());
        // list.add(new ScormModule());
        return list;
    }
}