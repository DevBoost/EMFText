package generator.html;

import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.forms.*;;

public class IPhoneFormGenerator extends org.emftext.language.forms.resource.forms.custom.AbstractGenerator implements org.emftext.language.forms.resource.forms.custom.IGenerator {
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
  protected final String TEXT_3 = " </title>" + NL + "\t<link rel=\"stylesheet\" href=\"WebApp/Design/Render.css\" />" + NL + "\t<script type=\"text/javascript\" scr=\"WebApp/Action/Logic.js\"></script>" + NL + "\t<meta name=\"viewport\" content=\"width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;\" />" + NL + "\t<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />" + NL + "\t<meta names=\"apple-mobile-web-app-status-bar-style\" content=\"black-translucent\" />" + NL + "" + NL + "\t<link rel=\"Stylesheet\" href=\"WebApp/Design/Render.css\" />" + NL + "\t<script type=\"text/javascript\" src=\"WebApp/Action/Logic.js\"></script>" + NL + "" + NL + "\t<style>" + NL + "\t\t*[dir=rtl] #iHeader .iTab {margin-left:40px;margin-right:15px }" + NL + "\t\t#iHeader .iTab {margin-right:55px}" + NL + "" + NL + "\t\t.iPanel label + input[type] {" + NL + "\t\t\tpadding-left:95px;" + NL + "\t\t}" + NL + "" + NL + "\t\t*[dir=rtl] .iPanel label + input[type] {" + NL + "\t\t\tpadding-right:95px;" + NL + "\t\t}" + NL + "" + NL + "/* Fix to test in firefox" + NL + "\t\t.iPanel label + input[type] {" + NL + "\t\t\tpadding-bottom:0;" + NL + "\t\t\tpadding-top:0;" + NL + "\t\t\ttop:-16px;" + NL + "\t\t}" + NL + "*/" + NL + "" + NL + "\t\t.iTab li { width:33%}" + NL + "\t\t.iTab li:first-child { width:34%}" + NL + "" + NL + "\t\t.msg {" + NL + "\t\t\tbackground-color:#080;" + NL + "\t\t\tcolor:#fff;" + NL + "\t\t\tfont-size:11px;" + NL + "\t\t\tpadding:5px;" + NL + "\t\t\t-webkit-border-radius:4px;" + NL + "\t\t\tmargin:8px;" + NL + "\t\t}" + NL + "\t\t.err {" + NL + "\t\t\tbackground-color:#800;" + NL + "\t\t\tcolor:#fff;" + NL + "\t\t\tfont-size:11px;" + NL + "\t\t\tpadding:5px;" + NL + "\t\t\t-webkit-border-radius:4px;" + NL + "\t\t\tmargin:8px;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t</style>" + NL + "" + NL + "" + NL + "" + NL + "</head>" + NL + "" + NL + "<body>" + NL + "<div id=\"WebApp\">" + NL + "" + NL + "<div id=\"iHeader\">" + NL + "    <a href=\"#\" id=\"waBackButton\">Back</a>" + NL + "    <span id=\"waHeadTitle\">iForm</span>" + NL + "</div>" + NL + "" + NL + "<div id=\"iGroup\">" + NL + "" + NL + "    <div class=\"iLayer\" id=\"waHome\" title=\"Overview\">" + NL + "        <div class=\"iBlock\">" + NL + "           " + NL + "            <h1>Form: ";
  protected final String TEXT_4 = "</h1>" + NL + "            <p>Please select the form section you want to fill:</p>" + NL + "            " + NL + "            " + NL + "            " + NL + "        </div>" + NL + "        " + NL + "        <div class=\"iMenu\">" + NL + "        <h3>Select Section: </h3>" + NL + "        \t<ul class=\"iArrow\">" + NL + "\t        \t";
  protected final String TEXT_5 = NL + "\t" + NL + "\t        \t<li><a href=\"#_Group_";
  protected final String TEXT_6 = "\">";
  protected final String TEXT_7 = "</a></li>" + NL + "\t        \t";
  protected final String TEXT_8 = NL + "            </ul>" + NL + "        </div>" + NL + "    </div>" + NL + "" + NL + "    " + NL + "\t";
  protected final String TEXT_9 = NL + NL + "\t    <div class=\"iLayer\" id=\"waGroup_";
  protected final String TEXT_10 = "\" title=\"";
  protected final String TEXT_11 = "\">" + NL + "\t\t   \t    <div class=\"iPanel\">" + NL + "\t\t\t\t\t<div id=\"form-res\"></div>" + NL + "\t\t\t\t\t\t<fieldset>\t<legend>";
  protected final String TEXT_12 = "</legend>" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t    \t";
  protected final String TEXT_14 = " " + NL + "\t\t\t\t\t    \t\t<p>";
  protected final String TEXT_15 = "</p>" + NL + "\t\t\t\t\t    \t";
  protected final String TEXT_16 = NL + "\t\t\t\t\t    " + NL + "\t\t\t\t\t    \t";
  protected final String TEXT_17 = NL + "\t\t\t\t\t \t\t\t(Only if  " + NL + "\t\t\t\t\t \t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t\t \t\t\t\t";
  protected final String TEXT_19 = " = ";
  protected final String TEXT_20 = "  " + NL + "\t\t\t\t\t \t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t\t \t\t\t)" + NL + "\t\t\t\t\t \t  \t";
  protected final String TEXT_22 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t    \t";
  protected final String TEXT_23 = " " + NL + "\t\t\t\t\t \t\t\t<ul><li><label>";
  protected final String TEXT_24 = ":</label><input type=\"text\" size=30></input></li></ul>\t" + NL + "\t\t\t\t\t \t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t\t \t" + NL + "\t\t\t\t\t    \t";
  protected final String TEXT_26 = " " + NL + "\t\t\t\t\t \t\t\t<ul><li><label>";
  protected final String TEXT_27 = ":</label><br/>" + NL + "\t\t\t\t\t \t\t\t<input size=\"2\" maxlength=\"2\" value=\"DD\"/>." + NL + "\t\t\t\t\t \t\t\t<input size=\"2\" maxlength=\"2\" value=\"MM\"/>." + NL + "\t\t\t\t\t \t\t\t<input size=\"4\" maxlength=\"4\" value=\"YYYY\"/>" + NL + "\t\t\t\t\t \t\t\t</li></ul>" + NL + "\t\t\t\t\t \t\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\t    \t";
  protected final String TEXT_29 = " " + NL + "\t\t\t\t\t \t\t\t<ul><li><label>";
  protected final String TEXT_30 = ":</label>" + NL + "\t\t\t\t\t \t\t\t<input size=10></input>" + NL + "\t\t\t\t\t \t\t\t</li></ul>\t" + NL + "\t\t\t\t\t \t\t";
  protected final String TEXT_31 = NL + "\t\t\t\t\t    \t\t" + NL + "\t\t\t\t\t    \t\t\t\t<ul><li class=\"iCheck\">";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\t    \t\t";
  protected final String TEXT_33 = NL + "\t\t\t\t\t\t    \t\t\t<ul><li class=\"iRadio\">";
  protected final String TEXT_34 = NL + "\t\t\t\t\t\t    \t\t";
  protected final String TEXT_35 = " " + NL + "\t\t\t\t\t\t\t \t\t\t <input type=\"check\" name=\"";
  protected final String TEXT_36 = "\" value=\"";
  protected final String TEXT_37 = "\"> ";
  protected final String TEXT_38 = NL + "\t\t\t\t\t\t\t \t\t\t \t";
  protected final String TEXT_39 = " (beachte: ";
  protected final String TEXT_40 = " )";
  protected final String TEXT_41 = NL + "\t\t\t\t\t\t\t \t\t\t ";
  protected final String TEXT_42 = NL + "\t\t\t\t\t\t\t \t\t\t\t<label><input type=\"radio\" name=\"radio\" value=\"";
  protected final String TEXT_43 = "\" checked=\"checked\"/>";
  protected final String TEXT_44 = "\t \t\t\t\t" + NL + "\t\t\t\t\t\t\t \t\t\t\t\t";
  protected final String TEXT_45 = " (beachte: ";
  protected final String TEXT_46 = " )";
  protected final String TEXT_47 = NL + "\t\t\t\t\t\t\t \t\t\t\t\t</label>\t \t\t\t" + NL + "\t\t\t\t\t\t\t \t\t\t ";
  protected final String TEXT_48 = NL + "\t\t\t\t\t\t\t \t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\t\t\t \t\t</li></ul>" + NL + "\t\t\t\t\t    \t" + NL + "\t\t\t\t\t\t \t";
  protected final String TEXT_50 = NL + "\t\t\t\t    \t\t\t\t<ul><li><input type=\"checkbox\" name=\"";
  protected final String TEXT_51 = "\" id=\"";
  protected final String TEXT_52 = "\" class=\"iToggle\" title=\"Yes|No\" checked=\"checked\" value=\"ok\" /> " + NL + "\t\t\t\t    \t\t\t\t<label for=\"";
  protected final String TEXT_53 = "\">";
  protected final String TEXT_54 = "</label></li></ul>" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_55 = NL + "\t\t\t        \t</fieldset>" + NL + "\t\t\t\t\t</div>" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t       " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\t\t\t<div class=\"iMenu\">" + NL + "\t\t\t\t\t\t\t<ul class=\"iArrow\">" + NL + "\t\t\t\t\t\t\t\t<li><a href=\"#_Group_";
  protected final String TEXT_57 = "\">";
  protected final String TEXT_58 = "</a></li>" + NL + "\t\t\t\t\t\t\t</ul>" + NL + "\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_59 = NL + "\t\t\t</div>" + NL + "\t\t  ";
  protected final String TEXT_60 = NL + "\t</div>" + NL + "</body>" + NL + "</html>";

	/* (non-javadoc)
    * @see IGenerator#generate(Object)
    */
	public String generateString(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     Form form = (Form) argument; 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(form.getCaption());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(form.getCaption() );
    stringBuffer.append(TEXT_4);
    
	        	EList<Group> gruppen = form.getGroups();
	        	int i = 0;
	            for (Group gruppe : gruppen) {
	        		i++;
    stringBuffer.append(TEXT_5);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(gruppe.getName());
    stringBuffer.append(TEXT_7);
     
		        }
		        
    stringBuffer.append(TEXT_8);
    
	i = 0;
    for (Group gruppe : gruppen) {
	    i++;
		
    stringBuffer.append(TEXT_9);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(gruppe.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append( gruppe.getName());
    stringBuffer.append(TEXT_12);
     
					   	for (Item frage : gruppe.getItems()) {
					   	
    stringBuffer.append(TEXT_13);
     
					    	if (frage.getExplanation() != null) { 
					    	
    stringBuffer.append(TEXT_14);
    stringBuffer.append( frage.getExplanation());
    stringBuffer.append(TEXT_15);
     
					    	} 
					    	
    stringBuffer.append(TEXT_16);
     
					    	if (frage.getDependentOf().size() > 0) { 
    stringBuffer.append(TEXT_17);
     
					 			for(Option option : frage.getDependentOf()) { 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(generateItemText(option) );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(option.getText() );
    stringBuffer.append(TEXT_20);
    
					 			}
					 			
    stringBuffer.append(TEXT_21);
     
					 	  	} 
					    	
    stringBuffer.append(TEXT_22);
     
					    	if (frage.getItemType() instanceof FreeText) { 
    stringBuffer.append(TEXT_23);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_24);
     
					 		} 
					    	
    stringBuffer.append(TEXT_25);
     
					    	if (frage.getItemType() instanceof Date) { 
    stringBuffer.append(TEXT_26);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_27);
     
					 		} 
					    	
    stringBuffer.append(TEXT_28);
     
					    	if (frage.getItemType() instanceof org.emftext.language.forms.Number) { 
    stringBuffer.append(TEXT_29);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_30);
     
					 		} 
					    	 
					    	if (frage.getItemType() instanceof Choice) { 
					    		Choice auswahl = (Choice) frage.getItemType();
					    			if (auswahl.isMultiple()) {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_32);
    
						    		} else {
						    		
    stringBuffer.append(TEXT_33);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_34);
    
						    		}
					 						 		
							 		for(Option option : auswahl.getOptions()) {
							 			if (auswahl.isMultiple()) {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(option.getText());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(option.getText());
    stringBuffer.append(TEXT_38);
     if (option.getId() != null) {
    stringBuffer.append(TEXT_39);
    stringBuffer.append(option.getId());
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    } else { 
    stringBuffer.append(TEXT_42);
    stringBuffer.append(option.getText());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(option.getText());
    stringBuffer.append(TEXT_44);
     if (option.getId() != null) {
    stringBuffer.append(TEXT_45);
    stringBuffer.append(option.getId());
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    
					 	    } 
					    	
					    	if (frage.getItemType() instanceof Decision) {
				    			Decision e = (Decision) frage.getItemType();
    stringBuffer.append(TEXT_50);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(frage.getText());
    stringBuffer.append(TEXT_54);
    
				    		}
					   	}
					 			 	
						
    stringBuffer.append(TEXT_55);
     
						if (i < gruppen.size() ) { 
    stringBuffer.append(TEXT_56);
    stringBuffer.append(i+1);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(gruppen.get(i).getName());
    stringBuffer.append(TEXT_58);
     
				    	}
						
    stringBuffer.append(TEXT_59);
    
		  }
		  
    stringBuffer.append(TEXT_60);
    return stringBuffer.toString();
  }
}