package generator.xml;

import java.util.List;
import org.emftext.language.formular.*;;

public class FOFormGenerator extends org.emftext.language.formular.resource.formular.custom.AbstractGenerator implements org.emftext.language.formular.resource.formular.custom.IGenerator {
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
  protected final String TEXT_5 = NL + "\t\t<table-row>" + NL + "\t\t\t<table-cell number-columns-spanned=\"3\">" + NL + "\t\t\t \t<block font-size=\"8pt\">" + NL + "\t\t\t \t\tNur ";
  protected final String TEXT_6 = " wenn bei Frage ";
  protected final String TEXT_7 = " \"";
  protected final String TEXT_8 = "\" ";
  protected final String TEXT_9 = ":" + NL + "\t\t\t \t</block>" + NL + "\t\t\t</table-cell>" + NL + "\t\t</table-row>";
  protected final String TEXT_10 = NL + "\t\t<table-row border-bottom-width=\"0.5pt\" border-bottom-style=\"solid\">" + NL + "\t\t<table-cell padding=\"2pt 2pt\">" + NL + "\t\t\t<block font-size=\"10pt\" margin-left=\"0cm\" font-family=\"sans-serif\">" + NL + "\t\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t</block>" + NL + "\t\t</table-cell>" + NL + "\t\t<table-cell padding=\"2pt 2pt\">" + NL + "\t\t\t<block font-size=\"10pt\" margin-left=\"1cm\" font-family=\"sans-serif\" space-before=\"2mm\">" + NL + "\t\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t</block>";
  protected final String TEXT_13 = NL + "\t\t\t<block font-size=\"6pt\" margin-left=\"1cm\" font-family=\"sans-serif\">" + NL + "\t\t\t\t(";
  protected final String TEXT_14 = ")" + NL + "\t\t\t</block>" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t</table-cell>" + NL + "\t\t<table-cell padding=\"2pt 2pt\">";
  protected final String TEXT_16 = NL + "\t\t\t<block text-align=\"left\" font-size=\"12pt\">" + NL + "  \t\t\t\t<inline border-style=\"none\" background-color=\"rgb(80%,80%,80%)\" color=\"rgb(80%,80%,80%)\">&#160;&#160;&#160;&#160;</inline> " + NL + "  \t\t\t\t<inline>.</inline> " + NL + "  \t\t\t\t<inline border-style=\"none\" background-color=\"rgb(80%,80%,80%)\" color=\"rgb(80%,80%,80%)\">&#160;&#160;&#160;&#160;</inline> " + NL + "  \t\t\t\t<inline>.</inline> " + NL + "  \t\t\t\t<inline border-style=\"none\" background-color=\"rgb(80%,80%,80%)\" color=\"rgb(80%,80%,80%)\">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;</inline>" + NL + "  \t\t\t\t<inline font-size=\"8pt\">(Tag.Monat.Jahr)</inline> " + NL + "  \t\t\t</block>" + NL + "\t\t\t" + NL + "\t\t";
  protected final String TEXT_17 = NL + "\t\t\t<block  background-color=\"rgb(80%,80%,80%)\" color=\"rgb(80%,80%,80%)\" border-after-style=\"solid\" border-after-width=\"thin\" text-align=\"left\" font-size=\"12pt\">\t" + NL + "\t\t\t\t&#160;" + NL + "\t\t\t</block>" + NL + "\t\t";
  protected final String TEXT_18 = NL + "\t\t\t<block text-align=\"left\" font-size=\"10pt\">" + NL + "  \t\t\t\t<inline border-after-style=\"solid\" border-after-width=\"thin\" background-color=\"rgb(80%,80%,80%)\" color=\"rgb(80%,80%,80%)\">&#160;&#160;&#160;&#160;&#160;&#160;&#160;</inline> " + NL + "  \t\t\t\t<inline font-size=\"8pt\">(bitte eine Zahl angeben)</inline> " + NL + "  \t\t\t</block>" + NL + "\t\t";
  protected final String TEXT_19 = NL + "\t\t\t<block text-align=\"left\" font-size=\"10pt\">" + NL + "  \t\t\t\t<inline border-width=\"thin\" border-style=\"solid\" color=\"white\">&#160;&#160;&#160;</inline> " + NL + "  \t\t\t\t<inline font-size=\"8pt\">";
  protected final String TEXT_20 = "&#160;</inline> " + NL + "  \t\t\t\t<inline border-width=\"thin\" border-style=\"solid\" color=\"white\">&#160;&#160;&#160;</inline> " + NL + "  \t\t\t\t<inline font-size=\"8pt\">";
  protected final String TEXT_21 = "</inline>" + NL + "  \t\t\t</block>" + NL + "\t\t";
  protected final String TEXT_22 = NL + "\t\t\t<block text-align=\"center\" font-size=\"8pt\">" + NL + "\t\t\t\tBitte ankreuzen (";
  protected final String TEXT_23 = "):" + NL + "\t\t\t</block>" + NL + "\t\t\t<list-block>";
  protected final String TEXT_24 = NL + "\t\t\t\t<list-item>" + NL + " \t\t\t\t\t<list-item-label>" + NL + " \t\t\t\t\t\t<block/>" + NL + " \t\t\t\t\t</list-item-label>" + NL + " \t\t\t\t\t<list-item-body>" + NL + " \t\t\t\t\t\t<block>" + NL + " \t\t\t\t\t  \t<inline font-size=\"10pt\" border-style=\"solid\" border-width=\"thin\" color=\"white\">&#160;&#160;&#160;</inline>" + NL + "   \t\t\t\t\t\t<inline font-size=\"8pt\"> ";
  protected final String TEXT_25 = "</inline>" + NL + " \t\t\t\t\t\t</block>" + NL + " \t\t\t\t\t</list-item-body>" + NL + "\t\t\t\t</list-item>" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t</list-block>" + NL + "\t\t";
  protected final String TEXT_27 = "\t" + NL + "\t\t</table-cell>" + NL + "\t\t</table-row>" + NL + "\t\t";
  protected final String TEXT_28 = NL + "\t</table-body>" + NL + "\t</table>";
  protected final String TEXT_29 = NL + "</flow>" + NL + "</page-sequence>" + NL + "" + NL + "</root>";
  protected final String TEXT_30 = NL;

	/* (non-javadoc)
    * @see IGenerator#generate(Object)
    */
	public String generateString(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Formular formular = (Formular) argument; 

    stringBuffer.append(TEXT_1);
    stringBuffer.append(formular.getTitel());
    stringBuffer.append(TEXT_2);
     
   List<Gruppe> gruppen=formular.getGruppen();
   for(Gruppe gruppe:gruppen){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(gruppe.getName());
    stringBuffer.append(TEXT_4);
    
		 List<Frage> fragen=gruppe.getFragen();
		 for(int f = 0; f < fragen.size(); f++){
		 	Frage frage = fragen.get(f);
		 	AntwortTyp typ = frage.getAntwortTyp();
		 	String erklaerung = frage.getErklaerung();
		 	String text = frage.getText();
		 	List<Option> vorbedingungen = frage.getAbhaengigVon();
		 	boolean hatVorbedingungen = !vorbedingungen.isEmpty(); 
    
		 	if(hatVorbedingungen){
    stringBuffer.append(TEXT_5);
    stringBuffer.append( "ausf\u00FCllen" );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(erzeugeFragenAdresse(vorbedingungen.get(0)));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(vorbedingungen.get(0).getText());
    stringBuffer.append(TEXT_8);
    stringBuffer.append( "gew\u00E4hlt wurde" );
    stringBuffer.append(TEXT_9);
    } 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(erzeugeFragenAdresse(frage));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(text);
    stringBuffer.append(TEXT_12);
    
			if(erklaerung!=null){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(erklaerung);
    stringBuffer.append(TEXT_14);
    } 
    stringBuffer.append(TEXT_15);
    
		if(typ instanceof Datum){
    stringBuffer.append(TEXT_16);
     }else if(typ instanceof Freitext){
    stringBuffer.append(TEXT_17);
     }else if(typ instanceof Zahl) {
    stringBuffer.append(TEXT_18);
     }else if(typ instanceof Entscheidung) {
				Entscheidung entscheidung = (Entscheidung)typ;
				Option option1 = entscheidung.getOptionen().get(0);
				Option option2 = entscheidung.getOptionen().get(1);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(option1.getText());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(option2.getText());
    stringBuffer.append(TEXT_21);
     }else if(typ instanceof Auswahl) {
				Auswahl auswahl= (Auswahl)typ;
    stringBuffer.append(TEXT_22);
    stringBuffer.append(auswahl.isMehrfach()? "Mehrfachauswahl m\u00F6glich" : "maximal eine M\u00F6glichkeit ausw\u00E4hlen" );
    stringBuffer.append(TEXT_23);
    
			for(Option option:auswahl.getOptionen()){
    stringBuffer.append(TEXT_24);
    stringBuffer.append(option.getText());
    stringBuffer.append(TEXT_25);
     }
    stringBuffer.append(TEXT_26);
     }
    stringBuffer.append(TEXT_27);
    } 
    stringBuffer.append(TEXT_28);
    } 
    stringBuffer.append(TEXT_29);
    stringBuffer.append(TEXT_30);
    return stringBuffer.toString();
  }
}