/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.ui;

import java.util.List;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class Cct5ProposalPostProcessor {
	
	public List<org.emftext.test.cct5.resource.cct5.ui.Cct5CompletionProposal> process(List<org.emftext.test.cct5.resource.cct5.ui.Cct5CompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
