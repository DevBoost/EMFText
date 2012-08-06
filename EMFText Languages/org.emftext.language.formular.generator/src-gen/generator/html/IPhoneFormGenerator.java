package generator.html;

import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.formular.*;;

public class IPhoneFormGenerator extends org.emftext.language.formular.resource.formular.custom.AbstractGenerator implements org.emftext.language.formular.resource.formular.custom.IGenerator {
  protected static String nl;
  public static synchronized IPhoneFormGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    IPhoneFormGenerator result = new IPhoneFormGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">" + NL + "" + NL + "<html>" + NL + "<head> " + NL + "\t<title> ";
  protected final String TEXT_3 = " </title>" + NL + "\t<link rel=\"stylesheet\" href=\"WebApp/Design/Render.css\" />" + NL + "\t<script type=\"text/javascript\" scr=\"WebApp/Action/Logic.js\"></script>" + NL + "\t<meta name=\"viewport\" content=\"width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;\" />" + NL + "\t<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />" + NL + "\t<meta names=\"apple-mobile-web-app-status-bar-style\" content=\"black-translucent\" />" + NL + "" + NL + "\t<link rel=\"Stylesheet\" href=\"WebApp/Design/Render.css\" />" + NL + "\t<script type=\"text/javascript\" src=\"WebApp/Action/Logic.js\"></script>" + NL + "" + NL + "\t<style>" + NL + "\t\t*[dir=rtl] #iHeader .iTab {margin-left:40px;margin-right:15px }" + NL + "\t\t#iHeader .iTab {margin-right:55px}" + NL + "" + NL + "\t\t.iPanel label + input[type] {" + NL + "\t\t\tpadding-left:95px;" + NL + "\t\t}" + NL + "" + NL + "\t\t*[dir=rtl] .iPanel label + input[type] {" + NL + "\t\t\tpadding-right:95px;" + NL + "\t\t}" + NL + "" + NL + "/* Fix to test in firefox" + NL + "\t\t.iPanel label + input[type] {" + NL + "\t\t\tpadding-bottom:0;" + NL + "\t\t\tpadding-top:0;" + NL + "\t\t\ttop:-16px;" + NL + "\t\t}" + NL + "*/" + NL + "" + NL + "\t\t.iTab li { width:33%}" + NL + "\t\t.iTab li:first-child { width:34%}" + NL + "" + NL + "\t\t.msg {" + NL + "\t\t\tbackground-color:#080;" + NL + "\t\t\tcolor:#fff;" + NL + "\t\t\tfont-size:11px;" + NL + "\t\t\tpadding:5px;" + NL + "\t\t\t-webkit-border-radius:4px;" + NL + "\t\t\tmargin:8px;" + NL + "\t\t}" + NL + "\t\t.err {" + NL + "\t\t\tbackground-color:#800;" + NL + "\t\t\tcolor:#fff;" + NL + "\t\t\tfont-size:11px;" + NL + "\t\t\tpadding:5px;" + NL + "\t\t\t-webkit-border-radius:4px;" + NL + "\t\t\tmargin:8px;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t</style>" + NL + "" + NL + "" + NL + "" + NL + "</head>" + NL + "" + NL + "<body>" + NL + "<div id=\"WebApp\">" + NL + "" + NL + "<div id=\"iHeader\">" + NL + "    <a href=\"#\" id=\"waBackButton\">Back</a>" + NL + "    <span id=\"waHeadTitle\">iFrage</span>" + NL + "</div>" + NL + "" + NL + "<div id=\"iGroup\">" + NL + "" + NL + "    <div class=\"iLayer\" id=\"waHome\" title=\"&Uuml;berblick\">" + NL + "        <div class=\"iBlock\">" + NL + "            <h1>Fragebogen: ";
  protected final String TEXT_4 = "</h1>" + NL + "            <p>Bitte w&auml;hlen sie den Bereich des Formulars, den sie bearbeiten m&ouml;chten:</p>" + NL + "            " + NL + "            " + NL + "            " + NL + "        </div>" + NL + "        " + NL + "        <div class=\"iMenu\">" + NL + "        <h3>Bereich ausw&auml;hlen: </h3>" + NL + "        \t<ul class=\"iArrow\">" + NL + "\t        \t";
  protected final String TEXT_5 = NL + "\t" + NL + "\t        \t<li><a href=\"#_Gruppe_";
  protected final String TEXT_6 = "\">";
  protected final String TEXT_7 = "</a></li>" + NL + "\t        \t";
  protected final String TEXT_8 = NL + "            </ul>" + NL + "        </div>" + NL + "    </div>" + NL + "" + NL + "    " + NL + "\t";
  protected final String TEXT_9 = NL + NL + "\t    <div class=\"iLayer\" id=\"waGruppe_";
  protected final String TEXT_10 = "\" title=\"";
  protected final String TEXT_11 = "\">" + NL + "\t\t   \t    <div class=\"iPanel\">" + NL + "\t\t\t\t\t<div id=\"form-res\"></div>" + NL + "\t\t\t\t\t\t<fieldset>\t<legend>";
  protected final String TEXT_12 = "</legend>" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t    \t";
  protected final String TEXT_14 = " " + NL + "\t\t\t\t\t    \t\t<p>";
  protected final String TEXT_15 = "</p>" + NL + "\t\t\t\t\t    \t";
  protected final String TEXT_16 = NL + "\t\t\t\t\t    " + NL + "\t\t\t\t\t    \t";
  protected final String TEXT_17 = NL + "\t\t\t\t\t \t\t\t(Nur bei: " + NL + "\t\t\t\t\t \t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t\t \t\t\t\t";
  protected final String TEXT_19 = "  " + NL + "\t\t\t\t\t \t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\t\t \t\t\t)" + NL + "\t\t\t\t\t \t  \t";
  protected final String TEXT_21 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t    \t";
  protected final String TEXT_22 = " " + NL + "\t\t\t\t\t \t\t\t<ul><li><label>";
  protected final String TEXT_23 = ":</label><input type=\"text\" size=30></input></li></ul>\t" + NL + "\t\t\t\t\t \t\t";
  protected final String TEXT_24 = NL + "\t\t\t\t\t \t" + NL + "\t\t\t\t\t    \t";
  protected final String TEXT_25 = " " + NL + "\t\t\t\t\t \t\t\t<ul><li><label>";
  protected final String TEXT_26 = ":</label><br/>" + NL + "\t\t\t\t\t \t\t\t<input size=\"2\" maxlength=\"2\" value=\"DD\"/>." + NL + "\t\t\t\t\t \t\t\t<input size=\"2\" maxlength=\"2\" value=\"MM\"/>." + NL + "\t\t\t\t\t \t\t\t<input size=\"4\" maxlength=\"4\" value=\"YYYY\"/>" + NL + "\t\t\t\t\t \t\t\t</li></ul>" + NL + "\t\t\t\t\t \t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\t    \t";
  protected final String TEXT_28 = " " + NL + "\t\t\t\t\t \t\t\t<ul><li><label>";
  protected final String TEXT_29 = ":</label>" + NL + "\t\t\t\t\t \t\t\t<input size=10></input>" + NL + "\t\t\t\t\t \t\t\t</li></ul>\t" + NL + "\t\t\t\t\t \t\t";
  protected final String TEXT_30 = NL + "\t\t\t\t\t    \t\t" + NL + "\t\t\t\t\t    \t\t\t\t<ul><li class=\"iCheck\">";
  protected final String TEXT_31 = NL + "\t\t\t\t\t\t    \t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\t    \t\t\t<ul><li class=\"iRadio\">";
  protected final String TEXT_33 = NL + "\t\t\t\t\t\t    \t\t";
  protected final String TEXT_34 = " " + NL + "\t\t\t\t\t\t\t \t\t\t <input type=\"check\" name=\"";
  protected final String TEXT_35 = "\" value=\"";
  protected final String TEXT_36 = "\"> ";
  protected final String TEXT_37 = NL + "\t\t\t\t\t\t\t \t\t\t \t";
  protected final String TEXT_38 = " (beachte: ";
  protected final String TEXT_39 = " )";
  protected final String TEXT_40 = NL + "\t\t\t\t\t\t\t \t\t\t ";
  protected final String TEXT_41 = NL + "\t\t\t\t\t\t\t \t\t\t\t<label><input type=\"radio\" name=\"radio\" value=\"";
  protected final String TEXT_42 = "\" checked=\"checked\"/>";
  protected final String TEXT_43 = "\t \t\t\t\t" + NL + "\t\t\t\t\t\t\t \t\t\t\t\t";
  protected final String TEXT_44 = " (beachte: ";
  protected final String TEXT_45 = " )";
  protected final String TEXT_46 = NL + "\t\t\t\t\t\t\t \t\t\t\t\t</label>\t \t\t\t" + NL + "\t\t\t\t\t\t\t \t\t\t ";
  protected final String TEXT_47 = NL + "\t\t\t\t\t\t\t \t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t\t\t\t \t\t</li></ul>" + NL + "\t\t\t\t\t    \t" + NL + "\t\t\t\t\t\t \t";
  protected final String TEXT_49 = NL + "\t\t\t\t    \t\t\t\t<ul><li><input type=\"checkbox\" name=\"";
  protected final String TEXT_50 = "\" id=\"";
  protected final String TEXT_51 = "\" class=\"iToggle\" title=\"Ja|Nein\" checked=\"checked\" value=\"ok\" /> " + NL + "\t\t\t\t    \t\t\t\t<label for=\"";
  protected final String TEXT_52 = "\">";
  protected final String TEXT_53 = "</label></li></ul>" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t        \t</fieldset>" + NL + "\t\t\t\t\t</div>" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t       " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_55 = NL + "\t\t\t\t\t\t<div class=\"iMenu\">" + NL + "\t\t\t\t\t\t\t<ul class=\"iArrow\">" + NL + "\t\t\t\t\t\t\t\t<li><a href=\"#_Gruppe_";
  protected final String TEXT_56 = "\">";
  protected final String TEXT_57 = "</a></li>" + NL + "\t\t\t\t\t\t\t</ul>" + NL + "\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t</div>" + NL + "\t\t  ";
  protected final String TEXT_59 = NL + "\t</div>" + NL + "</body>" + NL + "</html>";

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
	        	int i = 0;
	            for (Gruppe gruppe : gruppen) {
	        		i++;
    stringBuffer.append(TEXT_5);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(gruppe.getName());
    stringBuffer.append(TEXT_7);
     
		        }
		        
    stringBuffer.append(TEXT_8);
    
	i = 0;
    for (Gruppe gruppe : gruppen) {
	    i++;
		
    stringBuffer.append(TEXT_9);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(gruppe.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append( gruppe.getName());
    stringBuffer.append(TEXT_12);
     
					   	for (Frage frage : gruppe.getFragen()) {
					   	
    stringBuffer.append(TEXT_13);
     
					    	if (frage.getErklaerung() != null) { 
					    	
    stringBuffer.append(TEXT_14);
    stringBuffer.append( frage.getErklaerung());
    stringBuffer.append(TEXT_15);
     
					    	} 
					    	
    stringBuffer.append(TEXT_16);
     
					    	if (frage.getAbhaengigVon().size() > 0) { 
    stringBuffer.append(TEXT_17);
     
					 			for(Option option : frage.getAbhaengigVon()) { 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(option.getId() );
    stringBuffer.append(TEXT_19);
    
					 			}
					 			
    stringBuffer.append(TEXT_20);
     
					 	  	} 
					    	
    stringBuffer.append(TEXT_21);
     
					    	if (frage.getAntwortTyp() instanceof Freitext) { 
    stringBuffer.append(TEXT_22);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_23);
     
					 		} 
					    	
    stringBuffer.append(TEXT_24);
     
					    	if (frage.getAntwortTyp() instanceof Datum) { 
    stringBuffer.append(TEXT_25);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_26);
     
					 		} 
					    	
    stringBuffer.append(TEXT_27);
     
					    	if (frage.getAntwortTyp() instanceof Zahl) { 
    stringBuffer.append(TEXT_28);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_29);
     
					 		} 
					    	 
					    	if (frage.getAntwortTyp() instanceof Auswahl) { 
					    		Auswahl auswahl = (Auswahl) frage.getAntwortTyp();
					    			if (auswahl.isMehrfach()) {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_31);
    
						    		} else {
						    		
    stringBuffer.append(TEXT_32);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_33);
    
						    		}
					 						 		
							 		for(Option option : auswahl.getOptionen()) {
							 			if (auswahl.isMehrfach()) {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(option.getText());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(option.getText());
    stringBuffer.append(TEXT_37);
     if (option.getId() != null) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(option.getId());
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    } else { 
    stringBuffer.append(TEXT_41);
    stringBuffer.append(option.getText());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(option.getText());
    stringBuffer.append(TEXT_43);
     if (option.getId() != null) {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(option.getId());
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    
					 	    } 
					    	
					    	if (frage.getAntwortTyp() instanceof Entscheidung) {
				    			Entscheidung e = (Entscheidung) frage.getAntwortTyp();
    stringBuffer.append(TEXT_49);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_53);
    
				    		}
					   	}
					 			 	
						
    stringBuffer.append(TEXT_54);
     
						if (i < gruppen.size() ) { 
    stringBuffer.append(TEXT_55);
    stringBuffer.append(i+1);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(gruppen.get(i).getName());
    stringBuffer.append(TEXT_57);
     
				    	}
						
    stringBuffer.append(TEXT_58);
    
		  }
		  
    stringBuffer.append(TEXT_59);
    return stringBuffer.toString();
  }
}