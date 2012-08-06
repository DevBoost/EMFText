componentmodel reusejava.ReuseJava 
implements     reusejava.ReuseJava
epackages    <http://www.emftext.org/java> <http://www.emftext.org/reusejava>
rootclass    java::containers::CompilationUnit, reusejava::StatementUnit
{
	fragment role ReuseableStatement {
		port Statements {
  			reusejava::StatementUnit.statements is prototype {
    			port expr = $name$ 
    		}
    	}
    }
    
    fragment role StatementVP {
		port VP {
  			reusejava::StatementVariationPoint is hook {
    			port expr = $name$ 
    		}
    	}
	}
}