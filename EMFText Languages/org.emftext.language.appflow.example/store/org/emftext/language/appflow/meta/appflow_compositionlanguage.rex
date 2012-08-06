compositionlanguage org.emftext.language.appflow.meta.appflow_compositionlanguage
implements org.emftext.language.appflow.meta.appflow
epackages <http://www.emftext.org/language/appflow>
rootclass appflow::Application if $not (ufi.trimExtension().extension() = 'composed')$
ucpi = $ufi.trimExtension().appendExtension('ucl')$
location = $'out'$ {

	fragment role Model {
		appflow::Application {
    		fragment = $'CORE'$
    		ufi = $ufi$
    		target ufi = $ufi.trimExtension().appendExtension('composed').appendExtension('appflow')$
    		target location = $'out'$
    	}
    }
    
	fragment role Template { 
		appflow::screenimport::ScreenImport {
			fragment = $self.name$
			ufi = $self.id.split('/')$
		}
	}
	fragment role Template { 
		appflow::screenimport::ParameterSetting {
			fragment = $screenImport.name$
			ufi = $screenImport.id.split('/')$
			port Contents {
				$parameter$ = $value$
			}
		}
    }
    
    association import {
    	appflow::screenimport::ScreenImport {
			fragment = $name$
			-->
			fragment = $'CORE'$
			port = $self.name$
		}
    }
}