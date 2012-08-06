componentmodel org.emftext.language.appflow.meta.appflow_componentmodel_template
implements org.emftext.language.appflow.meta.appflow
epackages <http://www.emftext.org/language/appflow>
rootclass appflow::screenimport::ScreenTemplate {
	fragment role Template { 
		port type Contents {
			appflow::screenmodel::Screen is prototype {}
    		appflow::screenmodel::Screen.name is value hook {}
    		appflow::widgets::Text.text is value hook if $text.contains('<<') and text.contains('>>')$ {
    			point = $text.substring(text.indexOf('<<')+3, text.indexOf('>>'))$
    			begin idx = $text.indexOf('<<')$
    			end idx = $text.indexOf('>>')+3$
    		}
    	}
    }
}