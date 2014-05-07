package database;


import java.util.List;

import model.BehaviorSymptom;
import model.BodySymptom;
import model.EarSymptom;
import model.ExcretionSymptom;
import model.EyeSymptom;
import model.NoseSymptom;
import model.SkinSymptom;
import model.TeethSymptom;

public class KnowledgeBase {
	private List<TeethSymptom> teeth;
	private List<BodySymptom> body;
	private List<SkinSymptom> skin;
	private List<ExcretionSymptom> excrete;
	private List<EyeSymptom> eyes;
	private List<NoseSymptom> nose;
	private List<BehaviorSymptom> behavior;
	private List<EarSymptom> ears;
	public List<TeethSymptom> getTeeth() {
		return teeth;
	}
	public void setTeeth(List<TeethSymptom> teeth) {
		this.teeth = teeth;
	}
	public List<BodySymptom> getBody() {
		return body;
	}
	public void setBody(List<BodySymptom> body) {
		this.body = body;
	}
	public List<SkinSymptom> getSkin() {
		return skin;
	}
	public void setSkin(List<SkinSymptom> skin) {
		this.skin = skin;
	}
	public List<ExcretionSymptom> getExcrete() {
		return excrete;
	}
	public void setExcrete(List<ExcretionSymptom> excrete) {
		this.excrete = excrete;
	}
	public List<EyeSymptom> getEyes() {
		return eyes;
	}
	public void setEyes(List<EyeSymptom> eyes) {
		this.eyes = eyes;
	}
	public List<NoseSymptom> getNose() {
		return nose;
	}
	public void setNose(List<NoseSymptom> nose) {
		this.nose = nose;
	}
	public List<BehaviorSymptom> getBehavior() {
		return behavior;
	}
	public void setBehavior(List<BehaviorSymptom> behavior) {
		this.behavior = behavior;
	}
	public List<EarSymptom> getEars() {
		return ears;
	}
	public void setEars(List<EarSymptom> ears) {
		this.ears = ears;
	}

	
}
