componentmodel org.emftext.language.appflow.meta.appflow_componentmodel_model
implements org.emftext.language.appflow.meta.appflow
epackages <http://www.emftext.org/language/appflow>
rootclass appflow::Application {

	fragment role Model {
		port type ScreenImport {
			appflow::screenimport::ScreenImport is hook {
    			port = $self.name$ 
    		}
    		appflow::screenmodel::Screen is value prototype {
    			port = $self.name$ 
    			value = $self.name$
    		}
    	}
    }
}