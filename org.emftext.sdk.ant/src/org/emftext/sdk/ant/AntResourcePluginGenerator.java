package org.emftext.sdk.ant;

import org.eclipse.core.runtime.SubMonitor;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.generators.ResourcePluginGenerator;

/**
 * This class implements an ResourcePluginGenerator that does NOT create
 * the Eclipse project in the current workspace. ANT task can't do so,
 * because no running Eclipse platform is available. However, this generator
 * create all artifacts of the text resource plug-in. So the plug-in is
 * created, but not registered with the current Eclipse workspace.
 */
public class AntResourcePluginGenerator extends ResourcePluginGenerator {

	@Override
	public void createProject(GenerationContext context, SubMonitor progress) {
	}
}
