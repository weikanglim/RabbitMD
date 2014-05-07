package engine;


import java.util.Iterator;

import model.Diagnosis;
import database.KnowledgeBase;
import jess.Filter;
import jess.JessException;
import jess.Rete;
import jess.WorkingMemoryMarker;

public class DiagnosisEngine {
    private Rete engine;
    private WorkingMemoryMarker marker;
    private KnowledgeBase kb;

    public DiagnosisEngine(KnowledgeBase kb) throws JessException {
        // Create a Jess rule engine
        engine = new Rete();
        engine.reset();

        // Load the pricing rules
        engine.batch("diagnosis.clp");

        // Load the catalog data into working memory
        engine.addAll(kb.getBehavior());
        engine.addAll(kb.getBody());
        engine.addAll(kb.getEars());
        engine.addAll(kb.getEyes());
        engine.addAll(kb.getExcrete());
        engine.addAll(kb.getSkin());
        engine.addAll(kb.getNose());
        engine.addAll(kb.getTeeth());

        // Mark end of catalog data for later
        marker = engine.mark();
    }


    public Iterator run() throws JessException {
        // Remove any previous order data, leaving only catalog data
    	engine.resetToMark(marker);
    	
        // Fire the rules that apply to this order
        engine.run();
        System.out.println("Engine running.");
        
        // Return the list of offers created by the rules
        return engine.getObjects(new Filter.ByClass(Diagnosis.class));
    }

}
