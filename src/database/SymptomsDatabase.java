package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import model.*;


public class SymptomsDatabase {
	private ArrayList<TeethSymptom> teeth;
	private ArrayList<BodySymptom> body;
	private ArrayList<SkinSymptom> skin;
	private ArrayList<ExcretionSymptom> excrete;
	private ArrayList<EyeSymptom> eyes;
	private ArrayList<NoseSymptom> nose;
	private ArrayList<BehaviorSymptom> behavior;
	private ArrayList<EarSymptom> ears;
	private String delimiter = "----";
	
	public SymptomsDatabase() throws FileNotFoundException{
			Scanner scan = new Scanner(new File("symptoms.txt"));
			while(scan.hasNext()){
				String token = scan.next();
				scan.nextLine();
				
				if(token.equals("Eyes")){
					eyes = new ArrayList<>();
					String line = scan.nextLine();
					while(!line.equals(delimiter)){
						Scanner scan2 = new Scanner(line);
						int value = scan2.nextInt();
						String description = scan2.nextLine();
						line = scan.nextLine();
						eyes.add(new EyeSymptom(value, description));
					}
					Collections.sort(eyes);
				} else if(token.equals("Teeth")){
					teeth = new ArrayList<>();
					String line = scan.nextLine();
					while(!line.equals(delimiter)){
						Scanner scan2 = new Scanner(line);
						int value = scan2.nextInt();
						String description = scan2.nextLine();
						line = scan.nextLine();
						teeth.add(new TeethSymptom(value, description));
					}
					Collections.sort(teeth);
				}else if(token.equals("Body")){
					body = new ArrayList<>();
					String line = scan.nextLine();
					while(!line.equals(delimiter)){
						Scanner scan2 = new Scanner(line);
						int value = scan2.nextInt();
						String description = scan2.nextLine();
						line = scan.nextLine();
						body.add(new BodySymptom(value, description));
					}
					Collections.sort(body);
				}else if(token.equals("Nose")){
					nose = new ArrayList<>();
					String line = scan.nextLine();
					while(!line.equals(delimiter)){
						Scanner scan2 = new Scanner(line);
						int value = scan2.nextInt();
						String description = scan2.nextLine();
						line = scan.nextLine();
						nose.add(new NoseSymptom(value, description));
					}
					Collections.sort(nose);
				}else if(token.equals("Skin")){
					skin = new ArrayList<>();
					String line = scan.nextLine();
					while(!line.equals(delimiter)){
						Scanner scan2 = new Scanner(line);
						int value = scan2.nextInt();
						String description = scan2.nextLine();
						line = scan.nextLine();
						skin.add(new SkinSymptom(value, description));
					}
					Collections.sort(skin);
				}else if(token.equals("Ears")){
					ears = new ArrayList<>();
					String line = scan.nextLine();
					while(!line.equals(delimiter)){
						Scanner scan2 = new Scanner(line);
						int value = scan2.nextInt();
						String description = scan2.nextLine();
						line = scan.nextLine();
						ears.add(new EarSymptom(value, description));
					}
					Collections.sort(ears);
				}else if(token.equals("Excretion")){
					excrete = new ArrayList<>();
					String line = scan.nextLine();
					while(!line.equals(delimiter)){
						Scanner scan2 = new Scanner(line);
						int value = scan2.nextInt();
						String description = scan2.nextLine();
						line = scan.nextLine();
						excrete.add(new ExcretionSymptom(value, description));
					}
					Collections.sort(excrete);
				}else if(token.equals("Behavior")){
					behavior = new ArrayList<>();
					String line = scan.nextLine();
					while(!line.equals(delimiter)){
						Scanner scan2 = new Scanner(line);
						int value = scan2.nextInt();
						String description = scan2.nextLine();
						line = scan.nextLine();
						behavior.add(new BehaviorSymptom(value, description));
					}
					Collections.sort(behavior);
				}
			}
			scan.close();
	}
	
	private Symptom readSymptom(String line){
		Scanner scan = new Scanner(line);
		int value = scan.nextInt();
		String description = scan.next();
		scan.close();
		Symptom s = new Symptom(value, description);
		return s;
	}

	public ArrayList<TeethSymptom> getTeeth() {
		return teeth;
	}

	public void setTeeth(ArrayList<TeethSymptom> teeth) {
		this.teeth = teeth;
	}

	public ArrayList<BodySymptom> getBody() {
		return body;
	}

	public void setBody(ArrayList<BodySymptom> body) {
		this.body = body;
	}

	public ArrayList<SkinSymptom> getSkin() {
		return skin;
	}

	public void setSkin(ArrayList<SkinSymptom> skin) {
		this.skin = skin;
	}

	public ArrayList<ExcretionSymptom> getExcrete() {
		return excrete;
	}

	public void setExcrete(ArrayList<ExcretionSymptom> excrete) {
		this.excrete = excrete;
	}

	public ArrayList<EyeSymptom> getEyes() {
		return eyes;
	}

	public void setEyes(ArrayList<EyeSymptom> eyes) {
		this.eyes = eyes;
	}

	public ArrayList<NoseSymptom> getNose() {
		return nose;
	}

	public void setNose(ArrayList<NoseSymptom> nose) {
		this.nose = nose;
	}

	public ArrayList<BehaviorSymptom> getBehavior() {
		return behavior;
	}

	public void setBehavior(ArrayList<BehaviorSymptom> behavior) {
		this.behavior = behavior;
	}

	public ArrayList<EarSymptom> getEars() {
		return ears;
	}

	public void setEars(ArrayList<EarSymptom> ears) {
		this.ears = ears;
	}

	public String getDelimiter() {
		return delimiter;
	}

	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}
	

}
