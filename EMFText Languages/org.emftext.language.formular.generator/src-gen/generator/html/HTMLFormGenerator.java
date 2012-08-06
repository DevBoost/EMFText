package generator.html;

import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.formular.*;;

public class HTMLFormGenerator extends org.emftext.language.formular.resource.formular.custom.AbstractGenerator implements org.emftext.language.formular.resource.formular.custom.IGenerator {
  protected static String nl;
  public static synchronized HTMLFormGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    HTMLFormGenerator result = new HTMLFormGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">" + NL + "" + NL + "<html> " + NL + "" + NL + "<head> <title> ";
  protected final String TEXT_3 = " </title>" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "</head>" + NL + "" + NL + "<body>" + NL + "" + NL + "<h1> Formular: ";
  protected final String TEXT_4 = "</h1>" + NL;
  protected final String TEXT_5 = " <fieldset>" + NL + "\t\t    <legend>";
  protected final String TEXT_6 = "</legend>";
  protected final String TEXT_7 = NL + "\t\t" + NL + "\t\t<b> " + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t" + NL + "\t\t</b>" + NL + "\t\t\t";
  protected final String TEXT_9 = " ";
  protected final String TEXT_10 = " ";
  protected final String TEXT_11 = NL + "\t\t<br>\t" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\t(Nur bei: " + NL + "\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\t";
  protected final String TEXT_14 = "  " + NL + "\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t)" + NL + "\t\t\t " + NL + "\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t<br>" + NL + "\t\t" + NL + "\t\t\t";
  protected final String TEXT_17 = " " + NL + "\t\t\t\t<input size=30></input>\t" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t";
  protected final String TEXT_19 = " " + NL + "\t\t\t\t<input size=\"2\" maxlength=\"2\" value=\"DD\"/>." + NL + "\t\t\t\t<input size=\"2\" maxlength=\"2\" value=\"MM\"/>." + NL + "\t\t\t\t<input size=\"4\" maxlength=\"4\" value=\"YYYY\"/>\t" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t";
  protected final String TEXT_21 = " " + NL + "\t\t\t\t<input size=10></input>\t" + NL + "\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t";
  protected final String TEXT_23 = " " + NL + "\t\t\t\t\t <input type=\"checkbox\" name=\"";
  protected final String TEXT_24 = "\" value=\"";
  protected final String TEXT_25 = "\"> ";
  protected final String TEXT_26 = NL + "\t\t\t\t\t ";
  protected final String TEXT_27 = " (beachte: ";
  protected final String TEXT_28 = " )";
  protected final String TEXT_29 = NL + "\t\t\t\t\t ";
  protected final String TEXT_30 = NL + "\t\t\t\t\t <input type=\"radio\" name=\"";
  protected final String TEXT_31 = "\" value=\"";
  protected final String TEXT_32 = "\"> ";
  protected final String TEXT_33 = NL + "\t\t\t\t\t ";
  protected final String TEXT_34 = " (beachte: ";
  protected final String TEXT_35 = " )";
  protected final String TEXT_36 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t ";
  protected final String TEXT_37 = NL + "\t\t\t\t\t <br>" + NL + "\t\t\t";
  protected final String TEXT_38 = "<input type=\"checkbox\" name=\"";
  protected final String TEXT_39 = "\" title=\"Ja|Nein\" checked=\"checked\" value=\"ok\" /> " + NL + "\t\t\t\t<label for=\"";
  protected final String TEXT_40 = "\">";
  protected final String TEXT_41 = "</label>" + NL + "\t\t\t\t";
  protected final String TEXT_42 = " (Ja: ";
  protected final String TEXT_43 = " )" + NL + "\t\t\t\t";
  protected final String TEXT_44 = " (Nein: ";
  protected final String TEXT_45 = " )" + NL + "\t\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t<br>" + NL + "\t\t" + NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_47 = NL + "\t\t   </fieldset>" + NL + "\t";
  protected final String TEXT_48 = NL + "\t\t" + NL + "\t" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "</body>" + NL + "" + NL + "" + NL + "" + NL + "</html>";

	/* (non-javadoc)
    * @see IGenerator#generate(Object)
    */
	public String generateString(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     Formular formular = (Formular) argument; 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(formular.getTitel());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(formular.getTitel() );
    stringBuffer.append(TEXT_4);
    EList<Gruppe> gruppen = formular.getGruppen();
	
	for (Gruppe gruppe : gruppen) {
		 
    stringBuffer.append(TEXT_5);
    stringBuffer.append(gruppe.getName());
    stringBuffer.append(TEXT_6);
    

		EList<Frage> list = gruppe.getFragen();
		
		    for (Iterator<Frage> iterator = list.iterator(); iterator.hasNext();) {
		
			Frage frage = iterator.next();
		
		
    stringBuffer.append(TEXT_7);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_8);
     if (frage.getErklaerung() != null) { 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(frage.getErklaerung());
    stringBuffer.append(TEXT_10);
     } 
    stringBuffer.append(TEXT_11);
     if (frage.getAbhaengigVon().size() > 0) { 
    stringBuffer.append(TEXT_12);
     for(Option option : frage.getAbhaengigVon()) { 
    stringBuffer.append(TEXT_13);
    stringBuffer.append(option.getId() );
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
     } 
    stringBuffer.append(TEXT_16);
     if (frage.getAntwortTyp() instanceof Freitext) { 
    stringBuffer.append(TEXT_17);
     } 
    stringBuffer.append(TEXT_18);
     if (frage.getAntwortTyp() instanceof Datum) { 
    stringBuffer.append(TEXT_19);
     } 
    stringBuffer.append(TEXT_20);
     if (frage.getAntwortTyp() instanceof Zahl) { 
    stringBuffer.append(TEXT_21);
     } 
    stringBuffer.append(TEXT_22);
     if (frage.getAntwortTyp() instanceof Auswahl) { 
				Auswahl auswahl = (Auswahl) frage.getAntwortTyp();
				for(Option option : auswahl.getOptionen()) {
					if (auswahl.isMehrfach()) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(option.getText());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(option.getText());
    stringBuffer.append(TEXT_26);
     if (option.getId() != null) {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(option.getId());
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    } else { 
    stringBuffer.append(TEXT_30);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(option.getText());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(option.getText());
    stringBuffer.append(TEXT_33);
     if (option.getId() != null) {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(option.getId());
    stringBuffer.append(TEXT_35);
    }
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
     	 }
			}
			if (frage.getAntwortTyp() instanceof Entscheidung) { 
				Entscheidung entscheidung = (Entscheidung) frage.getAntwortTyp();
				
    stringBuffer.append(TEXT_38);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_41);
     
				if (entscheidung.getOptionen().get(0).getId() != null) {
					
    stringBuffer.append(TEXT_42);
    stringBuffer.append(entscheidung.getOptionen().get(0).getId());
    stringBuffer.append(TEXT_43);
    
				}
				if (entscheidung.getOptionen().get(1).getId() != null) {
					
    stringBuffer.append(TEXT_44);
    stringBuffer.append(entscheidung.getOptionen().get(1).getId());
    stringBuffer.append(TEXT_45);
    
				}
			}
			
			
    stringBuffer.append(TEXT_46);
    
		  }
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    return stringBuffer.toString();
  }
}