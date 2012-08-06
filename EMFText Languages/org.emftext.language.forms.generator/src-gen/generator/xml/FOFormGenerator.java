package generator.xml;

import java.util.List;
import org.emftext.language.forms.*;;

public class FOFormGenerator extends org.emftext.language.forms.resource.forms.custom.AbstractGenerator implements org.emftext.language.forms.resource.forms.custom.IGenerator {
  protected static String nl;
  public static synchronized FOFormGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    FOFormGenerator result = new FOFormGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"no\"?>" + NL + "<root xmlns=\"http://www.w3.org/1999/XSL/Format\">" + NL + "" + NL + "<layout-master-set>" + NL + "  <simple-page-master master-name=\"A4\" " + NL + "   \tpage-height=\"297mm\" page-width=\"210mm\"" + NL + "   \tmargin-top=\"1cm\"   margin-bottom=\"1cm\"" + NL + "   \tmargin-left=\"1cm\"  margin-right=\"1cm\">" + NL + "    <region-body   margin=\"2cm\"/>" + NL + "  \t<region-before extent=\"2cm\"/>" + NL + "  \t<region-after  extent=\"2cm\"/>" + NL + "  \t<region-start  extent=\"2cm\"/>" + NL + "  \t<region-end    extent=\"2cm\"/>" + NL + "  </simple-page-master>" + NL + "</layout-master-set>" + NL + "" + NL + "<page-sequence master-reference=\"A4\">" + NL + "<flow flow-name=\"xsl-region-body\">" + NL + "\t<block font-size=\"14pt\" font-family=\"sans-serif\">" + NL + "\t\t";
  protected final String TEXT_2 = NL + "\t</block>";
  protected final String TEXT_3 = NL + "\t<block font-size=\"12pt\" font-family=\"sans-serif\" space-before=\"5mm\" space-after=\"0mm\">" + NL + "\t\t";
  protected final String TEXT_4 = NL + "\t</block>" + NL + "\t<table table-layout=\"fixed\"  width=\"100%\" border-width=\"1pt\" border-style=\"solid\">" + NL + "\t<table-column column-width=\"5%\"/>" + NL + "\t<table-column column-width=\"30%\"/>" + NL + "    <table-column column-width=\"65%\"/>" + NL + "\t<table-body>";
  protected final String TEXT_5 = NL + "\t\t<table-row>" + NL + "\t\t\t<table-cell number-columns-spanned=\"3\">" + NL + "\t\t\t \t<block font-size=\"8pt\">" + NL + "\t\t\t \t\tonly when for Item ";
  protected final String TEXT_6 = " \"";
  protected final String TEXT_7 = "\" ";
  protected final String TEXT_8 = ":" + NL + "\t\t\t \t</block>" + NL + "\t\t\t</table-cell>" + NL + "\t\t</table-row>";
  protected final String TEXT_9 = NL + "\t\t<table-row border-bottom-width=\"0.5pt\" border-bottom-style=\"solid\">" + NL + "\t\t<table-cell padding=\"2pt 2pt\">" + NL + "\t\t\t<block font-size=\"10pt\" margin-left=\"0cm\" font-family=\"sans-serif\">" + NL + "\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t</block>" + NL + "\t\t</table-cell>" + NL + "\t\t<table-cell padding=\"2pt 2pt\">" + NL + "\t\t\t<block font-size=\"10pt\" margin-left=\"1cm\" font-family=\"sans-serif\" space-before=\"2mm\">" + NL + "\t\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t</block>";
  protected final String TEXT_12 = NL + "\t\t\t<block font-size=\"6pt\" margin-left=\"1cm\" font-family=\"sans-serif\">" + NL + "\t\t\t\t(";
  protected final String TEXT_13 = ")" + NL + "\t\t\t</block>" + NL + "\t\t\t";
  protected final String TEXT_14 = NL + "\t\t</table-cell>" + NL + "\t\t<table-cell padding=\"2pt 2pt\">";
  protected final String TEXT_15 = NL + "\t\t\t<block text-align=\"left\" font-size=\"12pt\">" + NL + "  \t\t\t\t<inline border-style=\"none\" background-color=\"rgb(80%,80%,80%)\" color=\"rgb(80%,80%,80%)\">&#160;&#160;&#160;&#160;</inline> " + NL + "  \t\t\t\t<inline>.</inline> " + NL + "  \t\t\t\t<inline border-style=\"none\" background-color=\"rgb(80%,80%,80%)\" color=\"rgb(80%,80%,80%)\">&#160;&#160;&#160;&#160;</inline> " + NL + "  \t\t\t\t<inline>.</inline> " + NL + "  \t\t\t\t<inline border-style=\"none\" background-color=\"rgb(80%,80%,80%)\" color=\"rgb(80%,80%,80%)\">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;</inline>" + NL + "  \t\t\t\t<inline font-size=\"8pt\">(month-day-year)</inline> " + NL + "  \t\t\t</block>" + NL + "\t\t\t" + NL + "\t\t";
  protected final String TEXT_16 = NL + "\t\t\t<block  background-color=\"rgb(80%,80%,80%)\" color=\"rgb(80%,80%,80%)\" border-after-style=\"solid\" border-after-width=\"thin\" text-align=\"left\" font-size=\"12pt\">\t" + NL + "\t\t\t\t&#160;" + NL + "\t\t\t</block>" + NL + "\t\t";
  protected final String TEXT_17 = NL + "\t\t\t<block text-align=\"left\" font-size=\"10pt\">" + NL + "  \t\t\t\t<inline border-after-style=\"solid\" border-after-width=\"thin\" background-color=\"rgb(80%,80%,80%)\" color=\"rgb(80%,80%,80%)\">&#160;&#160;&#160;&#160;&#160;&#160;&#160;</inline> " + NL + "  \t\t\t\t<inline font-size=\"8pt\">(please give a number)</inline> " + NL + "  \t\t\t</block>" + NL + "\t\t";
  protected final String TEXT_18 = NL + "\t\t\t<block text-align=\"left\" font-size=\"10pt\">" + NL + "  \t\t\t\t<inline border-width=\"thin\" border-style=\"solid\" color=\"white\">&#160;&#160;&#160;</inline> " + NL + "  \t\t\t\t<inline font-size=\"8pt\">";
  protected final String TEXT_19 = "&#160;</inline> " + NL + "  \t\t\t\t<inline border-width=\"thin\" border-style=\"solid\" color=\"white\">&#160;&#160;&#160;</inline> " + NL + "  \t\t\t\t<inline font-size=\"8pt\">";
  protected final String TEXT_20 = "</inline>" + NL + "  \t\t\t</block>" + NL + "\t\t";
  protected final String TEXT_21 = NL + "\t\t\t<block text-align=\"center\" font-size=\"8pt\">" + NL + "\t\t\t\tPlease check ";
  protected final String TEXT_22 = ":" + NL + "\t\t\t</block>" + NL + "\t\t\t<list-block>";
  protected final String TEXT_23 = NL + "\t\t\t\t<list-item>" + NL + " \t\t\t\t\t<list-item-label>" + NL + " \t\t\t\t\t\t<block/>" + NL + " \t\t\t\t\t</list-item-label>" + NL + " \t\t\t\t\t<list-item-body>" + NL + " \t\t\t\t\t\t<block>" + NL + " \t\t\t\t\t  \t<inline font-size=\"10pt\" border-style=\"solid\" border-width=\"thin\" color=\"white\">&#160;&#160;&#160;</inline>" + NL + "   \t\t\t\t\t\t<inline font-size=\"8pt\"> ";
  protected final String TEXT_24 = "</inline>" + NL + " \t\t\t\t\t\t</block>" + NL + " \t\t\t\t\t</list-item-body>" + NL + "\t\t\t\t</list-item>" + NL + "\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t</list-block>" + NL + "\t\t";
  protected final String TEXT_26 = "\t" + NL + "\t\t</table-cell>" + NL + "\t\t</table-row>" + NL + "\t\t";
  protected final String TEXT_27 = NL + "\t</table-body>" + NL + "\t</table>";
  protected final String TEXT_28 = NL + "</flow>" + NL + "</page-sequence>" + NL + "" + NL + "</root>";
  protected final String TEXT_29 = NL;

	/* (non-javadoc)
    * @see IGenerator#generate(Object)
    */
	public String generateString(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Form form = (Form) argument; 

    stringBuffer.append(TEXT_1);
    stringBuffer.append(form.getCaption());
    stringBuffer.append(TEXT_2);
     
   List<Group> gruppen=form.getGroups();
   for(Group gruppe:gruppen){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(gruppe.getName());
    stringBuffer.append(TEXT_4);
    
		 List<Item> fragen=gruppe.getItems();
		 for(int f = 0; f < fragen.size(); f++){
		 	Item frage = fragen.get(f);
		 	ItemType typ = frage.getItemType();
		 	String erklaerung = frage.getExplanation();
		 	String text = frage.getText();
		 	List<Option> vorbedingungen = frage.getDependentOf();
		 	boolean hatVorbedingungen = !vorbedingungen.isEmpty(); 
    
		 	if(hatVorbedingungen){
    stringBuffer.append(TEXT_5);
    stringBuffer.append(generateItemAddress(vorbedingungen.get(0)));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(vorbedingungen.get(0).getText());
    stringBuffer.append(TEXT_7);
    stringBuffer.append( "was selected." );
    stringBuffer.append(TEXT_8);
    } 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(generateItemAddress(frage));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(text);
    stringBuffer.append(TEXT_11);
    
			if(erklaerung!=null){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(erklaerung);
    stringBuffer.append(TEXT_13);
    } 
    stringBuffer.append(TEXT_14);
    
		if(typ instanceof org.emftext.language.forms.Date){
    stringBuffer.append(TEXT_15);
     }else if(typ instanceof FreeText){
    stringBuffer.append(TEXT_16);
     }else if(typ instanceof org.emftext.language.forms.Number) {
    stringBuffer.append(TEXT_17);
     }else if(typ instanceof Decision) {
				Decision entscheidung = (Decision)typ;
				Option option1 = entscheidung.getOptions().get(0);
				Option option2 = entscheidung.getOptions().get(1);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(option1.getText());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(option2.getText());
    stringBuffer.append(TEXT_20);
     }else if(typ instanceof Choice) {
				Choice auswahl= (Choice)typ;
    stringBuffer.append(TEXT_21);
    stringBuffer.append(auswahl.isMultiple()? "all relevant" : "only one" );
    stringBuffer.append(TEXT_22);
    
			for(Option option:auswahl.getOptions()){
    stringBuffer.append(TEXT_23);
    stringBuffer.append(option.getText());
    stringBuffer.append(TEXT_24);
     }
    stringBuffer.append(TEXT_25);
     }
    stringBuffer.append(TEXT_26);
    } 
    stringBuffer.append(TEXT_27);
    } 
    stringBuffer.append(TEXT_28);
    stringBuffer.append(TEXT_29);
    return stringBuffer.toString();
  }
}