(import model.*)
(deftemplate Symptom (declare (from-class Symptom)))
(deftemplate TeethSymptom (declare (from-class TeethSymptom)))
(deftemplate EarSymptom (declare (from-class EarSymptom)))
(deftemplate SkinSymptom (declare (from-class SkinSymptom)))
(deftemplate BehaviorSymptom (declare (from-class BehaviorSymptom)))
(deftemplate EyeSymptom (declare (from-class EyeSymptom)))
(deftemplate BodySymptom (declare (from-class BodySymptom)))
(deftemplate ExcretionSymptom (declare (from-class ExcretionSymptom)))
(deftemplate NoseSymptom (declare (from-class NoseSymptom)))
(deftemplate Diagnosis (declare (from-class Diagnosis)))
;(set-strategy engine.DiagnosisStrategy)

(defrule abnormal-teeth-grow
    "Diagnosis for abnormal teeth growth in rabbits."
    (TeethSymptom {value == 0})
    =>
    (add (new Diagnosis "Abnormal teeth growth." "Natural, traumatic or dietary cause." 1)))

(defrule teeth-misalignment
    "Diagnosis for teeth misalignment in rabbits. 
    Wet chin is a direct indication, while a combination of not eating and constant teeth grinding is also accepted as a diagnosis."
    (or (TeethSymptom {value == 1})
       (and (TeethSymptom {value == 2}) (BehaviorSymptom {value == 2})))
    =>
    (add (new Diagnosis "Abnormal teeth growth." "Natural, traumatic or dietary cause." 1)))

(defrule gi-stasis
    "Diagnosis for GI stasis in rabbits. (Not eating) Rabbit must display unusual faeces accompanied by Unusual behavior."
    (or (ExcretionSymptom {value == 0}) (ExcretionSymptom {value == 1}))
    (or (BehaviorSymptom {value == 2})  (BehaviorSymptom {value == 3}))
    => (add (new Diagnosis "GI Stasis" "Indigestion that causes accumulation of gas in intestines. Can be fatal, if not treated right away." 2))
)

(defrule bloody-urine
    "Diagnosis for bloody urine. Rabbits must have red coloured urine, accompanied by behavioral problem."
    (ExcretionSymptom {value == 2})
    (or (BehaviorSymptom {value == 5}) (BehaviorSymptom {value == 6}))
    => (add (new Diagnosis "Bloody urine" "Bloody urine indicates a problem with kidney or bladder." 2)))

(defrule possible-bloody-urine
    "Diagnosis for possible false positive bloody urine. Rabbits only have red coloured urine."
    (ExcretionSymptom {value == 2}) (not (BehaviorSymptom {value == 5})) (not (BehaviorSymptom {value == 6}))
    => (add (new Diagnosis "Possible bloody urine" "Rabbits may have reddish urine naturally. Monitor the situation for any other behavioral changes." 0)))

(defrule fur-mites
    "Diagnosis for fur mites. Flaking with hair loss."
    (SkinSymptom {value == 2}) (SkinSymptom {value == 0})
    => (add (new Diagnosis "Fur mites" "Mites can be treated easily with proper medication." 1)))
    
(defrule ringworm-fungus
    "Diagnosis for ringworm fungus. Flaking, multiple slots of hair loss."
    (SkinSymptom {value == 3}) (SkinSymptom {value == 4})
    => (add (new Diagnosis "Ringworm fungus" "Rabbit's environment should be cleansed. 
            May or may not need ringworm fungus. However, care should be taken to prevent spread of disease to humans." 1)))

(defrule sarcoptic-mange
    "Diagnosis for sarcoptic mange. Flaking skin, with unpleasant, musky smell near ears."
    (SkinSymptom {value == 3}) (EarSymptom {value == 1})
    => (add (new Diagnosis "Sarcoptic Mange" "Treated by injectivle ivermectin." 1)))

           
; TO-DO
(defrule normal-hair-loss
    "Normal hair loss"
    (SkinSymptom {value == 0}) => (add (new Diagnosis "Normal hair loss" "Possibly just normal shedding of fur. Occurs normally every three months or so." 0)))

(defrule cataracts
    "Cloudy eyes.Swollen iris / eye discharge."
    (EyeSymptom {value == 1}) (EyeSymptom {value == 2}) => (add (new Diagnosis "Cataracts" "Eye partially / entirely clouded. Affects vision of rabbits." 1)))

(defrule abscesses
    "Abscesses due to bacterial infection. Swelling under skin near jaw / Swollen skin near wounds."
    (or (TeethSymptom {value == 3}) (BodySymptom {value == 1})) => (add (new Diagnosis "Abscesses" "Swelling due to bacterial infection. Treat with peroxide and antibiotics if necessary." 1)))

(defrule ear-mites
    "Ear mites present in inner ear. Crust near ears, excessive shaking of head, ear scratching."
    (EarSymptom {value == 0}) (BehaviorSymptom {value == 9}) => (add (new Diagnosis "Ear mites" "Apply oil over visible crust." 1)))

(defrule eye-infection
    "Eye infection. Eye stuck shut / eye discharge."
    (EyeSymptom {value == 3 || value == 4})  => (add (new Diagnosis "Eye infection" "Requires antibiotic treatment." 1)))

(defrule heat-exhaustion
    "Heat exhaustion. Increased respiration rate, lethargic."
    (BehaviorSymptom {value == 4}) (BehaviorSymptom {value == 10}) => (add (new Diagnosis "Heat exhaustion" "Immerse rabbit in lukewarm water to reduce temperature to normal 101-104 Fahrenheit." 2)))

(defrule sore-hocks
    "Sore hocks. Swelling of feet."
    (BodySymptom {value == 2}) 
     => (add (new Diagnosis "Sore hocks" "Due to dirty floor, rough surfaces, or wiring on cage floor." 1))) 

(defrule uterine-cancer
    "Uterine cancer. Bloody urine, and maybe followed by abdominal mass, lethargy."
    (ExcretionSymptom {value == 2}) ( or (BehaviorSymptom {value == 8}) (BehaviorSymptom {value == 4}) (BodySymptom {value == 0})) => (add (new Diagnosis "Uterine Cancer" "Uterine cancer. Seek help from your vetenarian." 2)))

(defrule bot-fly
    "Bot fly larval infections. Swelling, visible hole near wounds."
    (BodySymptom {value == 1}) (BodySymptom {value == 3}) => (add (new Diagnosis  "Bot fly infection" "Requires surgical removal." 1)))

(defrule snuffles
    "Snuffles (Pasteurellosis). Runny eyes / nose, or nostril discharge."
    (or (EyeSymptom {value == 2}) (NoseSymptom {value == 1}) (NoseSymptom {value == 0})) => (add (new Diagnosis  "Snuffles (Pasteureollosis)" "Bacterial infection in respiratory tract." 1)))

(defrule neoplasms
    "Neoplasms. (Tumors). Bloody discharge from vaginal opening,  lumps found on belly/breast, bloody urine."
    (BodySymptom {value == 4}) (or (ExcretionSymptom {value == 3}) (ExcretionSymptom {value == 2})) => (add (new Diagnosis  "Neoplasm (Tumors)" "Requires surgical removal." 1)))

(defrule coccidiosis
    "Intestine bacterial infection. Diarrhoea, loss of appetite, bloated stomache, rough coat."
    (ExcretionSymptom {value == 4}) (BehaviorSymptom {value == 2}) (BodySymptom {value == 5}) (SkinSymptom {value == 5}) 
    => (add (new Diagnosis  "Coccidiosis (intestinal bacterrial infection)" "Stool sample analysis to confirm." 1)))

(defrule e-cuniculi
    "Protozoan E-cuniculi. Tremors, head tilt, loss of balance."
    (or (BehaviorSymptom {value == 11}) (BehaviorSymptom {value == 12}) (BehaviorSymptom {value == 13})) 
    => (add (new Diagnosis  "E-cuniculi infection" "Must be confirmed by blood test." 2)))

(defrule enteritis
    "Enteritis. Diarrhoe, swollen stomach, tremors, excessive drinking."
    (ExcretionSymptom {value == 4}) (BodySymptom {value == 5}) (BehaviorSymptom {value == 14}) (BehaviorSymptom {value == 11}) 
    => (add (new Diagnosis  "Enteritis" "Inflammation of intestine caused by sudden changes in diet. Must be treated immediately." 2)))

(defrule sticky-bottom
    "Sticky bottom. Droppings stuck to hair around its bottom."
    (ExcretionSymptom{value == 5}) => (add (new Diagnosis "Sticky bottom" "Incorrect diet given. Increase hay intake." 0)))

(defrule obesity
    "Obesity. Sticky bottom, unable to groom itself thoroughly, large dewlap, tires quickly."
    (Diagnosis {disease == "Sore hocks"})  (Diagnosis {disease == "Sticky bottom"}) (BodySymptom {value == 6}) (BehaviorSymptom {value == 15}) (BehaviorSymptom {value == 16}) 
    => (add (new Diagnosis  "Obesity" "Caused by high protein diet. Rabbit should be given more hay, and snacks should be cut down." 1)))

(defrule myxomatosis
    "Myxomatosis. Runny eyes, swelling eyelids, ears, nose, mouth, and ears or genitals. Discharge from nose." 
    (NoseSymptom {value == 1}) (EyeSymptom {value == 5}) (EyeSymptom {value == 2}) (or (EarSymptom {value == 2})) (BodySymptom {value == 7}) 
    => (add (new Diagnosis "Myxomatosis" "Viral infection. Treat immediately." 2)))

(defrule viral-haemorrhagic-disease
    "Viral Haemorrhagic Disease. Fever / bleeding from nose and bottom / difficulty breathing / spasms." 
    (or (BodySymptom {value == 8}) (NoseSymptom {value == 2}) (BodySymptom {value == 9}) (BehaviorSymptom {value == 18}) (BehaviorSymptom {value == 17}))
    => (add (new Diagnosis "Viral Haemorrhagic Disease" "Blood clotting disease." 2)))

(defrule poisoning
    "Poisoning. Spasms, lethargy, loss of appetite." 
    (BehaviorSymptom {value == 17}) (BehaviorSymptom {value == 4}) (BehaviorSymptom {value == 2})
    => (add (new Diagnosis "Poisoning" "Intake of poisonous material." 2)))

(defrule head-tumors
    "Head tumors / cancer. Lesions throughout body." 
    (BodySymptom {value == 10}) 
    => (add (new Diagnosis "Head tumor" "Biopsy needs to be performed to confirm." 2)))

(defrule rabies
    "Rabies. Bite wounds, fever, blindness, lethargy, paralysis." 
    (BodySymptom {value == 12}) (or (BodySymptom {value == 8}) (EyeSymptom {value == 6}) (BehaviorSymptom {value == 4}) 
    (BodySymptom {value == 11}))
    => (add (new Diagnosis "Rabies" "Usually caused by wounds or bite from another infected animal." 2)))

(defrule lung-cancer
    "Lung cancer. Bulging of eyes, swelling around upper torso, rapid breathing, shortness of breath."
    (or (EyeSymptom{value == 7}) (BodySymptom {value == 13})) (or (BehaviorSymptom {value == 10}) (BehaviorSymptom {value == 15})) 
    => (add (new Diagnosis "Lung cancer" "Further evaluation required to confirm." 2)))

(defrule symptoms-present
    "Fires if there are symptoms present in the rabbit, and no diagnosis is given."
    (declare (salience -100))
    (or (exists (BehaviorSymptom))  (exists (BodySymptom)) (exists(EarSymptom)) (exists(ExcretionSymptom)) 
        (exists(EyeSymptom)) (exists(NoseSymptom)) (exists(SkinSymptom)) (exists(TeethSymptom)) (exists (BodySymptom))
        ) (not (Diagnosis))
    => (add (new Diagnosis "some disease that RabbitMD hasn't been able to diagnose" 
            "Present more symptoms to maybe achieve a diagnosis. 
            If you find that the rabbit is behaving abnormally, do not hesitate to find a vetenarian." -1)))


(rules)