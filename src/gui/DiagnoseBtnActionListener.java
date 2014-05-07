package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;

import jess.JessException;
import database.KnowledgeBase;
import engine.DiagnosisEngine;
import model.*;
public class DiagnoseBtnActionListener implements ActionListener{
	private MainForm form;
	
	public DiagnoseBtnActionListener(MainForm form){
		this.form = form;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		EarSymptom [] ears;
		BodySymptom [] body;
		BehaviorSymptom [] behavior;
		ExcretionSymptom [] excretion;
		EyeSymptom [] eyes;
		NoseSymptom [] nose;
		SkinSymptom [] skin;
		TeethSymptom [] teeth;
		
//		behavior =  form.getListBehavior().getSelectedValuesList();
//		body = ((BodySymptom []) form.getListBody().getSelectedValuesList().toArray());
//		ears = ((EarSymptom []) form.getListEars().getSelectedValuesList().toArray());
//		excretion = ((ExcretionSymptom []) form.getListExcretion().getSelectedValuesList().toArray());
//		eyes = ((EyeSymptom []) form.getListEyes().getSelectedValuesList().toArray());
//		nose = ((NoseSymptom []) form.getListNose().getSelectedValuesList().toArray());
//		skin = ((SkinSymptom []) form.getListSkin().getSelectedValuesList().toArray());
//		teeth = ((TeethSymptom []) form.getListTeeth().getSelectedValuesList().toArray());
//		
		KnowledgeBase kb = new KnowledgeBase();
		kb.setBehavior(form.getListBehavior().getSelectedValuesList());
		kb.setBody(form.getListBody().getSelectedValuesList());
		kb.setEars(form.getListEars().getSelectedValuesList());
		kb.setExcrete(form.getListExcretion().getSelectedValuesList());
		kb.setEyes(form.getListEyes().getSelectedValuesList());
		kb.setNose(form.getListNose().getSelectedValuesList());
		kb.setSkin(form.getListSkin().getSelectedValuesList());
		kb.setTeeth(form.getListTeeth().getSelectedValuesList());
		
		try {
			DiagnosisEngine engine = new DiagnosisEngine(kb);
			Iterator<Diagnosis> a = engine.run();
			DiagnosisResultDialog dlg = new DiagnosisResultDialog();
			if(!a.hasNext()){ // empty
				System.out.println("no symptoms");
				dlg.getLblHeader().setIcon(new ImageIcon(DiagnosisResultDialog.class.getResource("/resources/1399450955_accepted_48.png")));
				dlg.getLblHeader().setText("Healthy rabbit!");
				dlg.getLblResults().setText("Your rabbit is not ill.");
			} else {
				ArrayList<Diagnosis> ds = new ArrayList<>();
				System.out.println(ds);

				boolean unhealthy = false;
				boolean ill = false;
				boolean immediateDanger = false;
				while(a.hasNext()){
					ds.add(a.next());
				}

				
				for(Diagnosis d : ds){
					if(d.getDangerLevel() == 0){
						unhealthy = true;
					}
					if(d.getDangerLevel() == 1){
						ill = true;
					}
					if(d.getDangerLevel() > 1){
						immediateDanger = true;
					}
				}
				
				String start = "<html>";
				String end = "</html>";
				String results = "";

				if(ds.size() == 1){
					if(unhealthy && !ill && !immediateDanger){
						dlg.getLblHeader().setIcon(new ImageIcon(DiagnosisResultDialog.class.getResource("/resources/1399450955_accepted_48.png")));
						dlg.getLblHeader().setText("Healthy rabbit!");
						results = "Your rabbit is not ill. "+ "He/she is facing " + ds.get(0).getDisease() + ".<br>" + ds.get(0).getDescription();
					}else if(ill && !immediateDanger){
						dlg.getLblHeader().setIcon(new ImageIcon(DiagnosisResultDialog.class.getResource("/resources/1399451353_warning_48.png")));
						dlg.getLblHeader().setText("Some attention needed.");
						results = "Your rabbit is ill. He/she is suffering from " + ds.get(0).getDisease() + ".<br>" + ds.get(0).getDescription();
					} else if(immediateDanger){
						dlg.getLblHeader().setIcon(new ImageIcon(DiagnosisResultDialog.class.getResource("/resources/1399450958_cancel_48.png")));
						dlg.getLblHeader().setText("Immediate attention needed.");
						results = "Your rabbit is seriously ill. He/she is suffering from " + ds.get(0).getDisease() + ".<br>" + ds.get(0).getDescription();
					} else { // 
						dlg.getLblHeader().setIcon(new ImageIcon(DiagnosisResultDialog.class.getResource("/resources/1399451353_warning_48.png")));
						dlg.getLblHeader().setText("Some attention needed!");
						results = "There is " + ds.get(0).getDisease() + "<br>" + ds.get(0).getDescription();
					}
				} else {
//					for(int i = 0; i < ds.size(); i++){
//						if(ds.get(i).getDangerLevel() == -1){
//							ds.remove(i);
//						}
//					}
					
					
					if(unhealthy && !ill && !immediateDanger){
						dlg.getLblHeader().setIcon(new ImageIcon(DiagnosisResultDialog.class.getResource("/resources/1399450955_accepted_48.png")));
						dlg.getLblHeader().setText("Healthy rabbit!");
						String result = "";
						for(Diagnosis d : ds){
							result += d.getDisease() + "--" + d.getDescription() + "<br>";
						}
						results = "Your rabbit is not ill. "
								+ "We found the following problems.<br> " + result;
					} else if(ill && !immediateDanger){
						dlg.getLblHeader().setIcon(new ImageIcon(DiagnosisResultDialog.class.getResource("/resources/1399451353_warning_48.png")));
						dlg.getLblHeader().setText("Some attention needed!");
						String result = "";
						for(Diagnosis d : ds){
							result += d.getDisease() + "--" + d.getDescription() + "<br>";
						}
						results = "Your rabbit is ill. "
								+ "We could not rule out all causes, and found the following problems.<br> " + result;

					} else {
						dlg.getLblHeader().setIcon(new ImageIcon(DiagnosisResultDialog.class.getResource("/resources/1399450958_cancel_48.png")));
						dlg.getLblHeader().setText("Immediate attention needed.");
						String result = "";
						for(Diagnosis d : ds){
							result += d.getDisease() + "--" + d.getDescription() + "<br>";
						}
						results = "Your rabbit is seriously ill. "
								+ "We could not rule out all causes, and found the following problems.<br> " + result;

					}
				}
				dlg.getLblResults().setText(start + results + end);
			}
			
			dlg.setVisible(true);
		} catch (JessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
