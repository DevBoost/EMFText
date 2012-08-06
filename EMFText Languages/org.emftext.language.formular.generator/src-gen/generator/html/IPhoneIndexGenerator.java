package generator.html;

import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.formular.*;;

public class IPhoneIndexGenerator extends org.emftext.language.formular.resource.formular.custom.AbstractGenerator implements org.emftext.language.formular.resource.formular.custom.IGenerator {
  protected static String nl;
  public static synchronized IPhoneIndexGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    IPhoneIndexGenerator result = new IPhoneIndexGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "<html>" + NL + "<body style=\"background-color:#222222;\">" + NL + "<table align=\"center\" border=\"0\" style=\"background-image:url(./iphone.png);\">" + NL + "\t<tr height=\"143px\"/><td width=\"28px\"/><td width=\"318px\"/><td width=\"45px\"/></tr>" + NL + "\t<tr height=\"467px\"><td/><td>" + NL + "\t";
  protected final String TEXT_3 = NL + "\t<iframe src=\"./";
  protected final String TEXT_4 = "html\" width=\"100%\" height=\"100%\">" + NL + "\t</iframe>" + NL + "\t</td><td/></tr>" + NL + "\t<tr height=\"120px\"><td/><td/><td/></tr>" + NL + "</table>" + NL + "</body> " + NL + "</html>";

	/* (non-javadoc)
    * @see IGenerator#generate(Object)
    */
	public String generateString(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     Formular formular = (Formular) argument; 
    stringBuffer.append(TEXT_2);
     
            String filename = formular.eResource().getURI().lastSegment();
			filename = filename.substring(0, filename.length() - formular.eResource().getURI().fileExtension().length()); 
	
    stringBuffer.append(TEXT_3);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}