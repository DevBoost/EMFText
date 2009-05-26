package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.TokenResolverGenerator;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.TokenDefinition;

/**
 * Creates the Java files for the token resolvers using the content
 * provided by TokenResolverGenerator. A token resolver is generated
 * for all tokens that are used and that are not imported.
 */
public class TokenResolversCreator extends AbstractArtifactCreator {

	private final ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();

	public TokenResolversCreator() {
		super("token resolvers");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		Collection<IArtifact> artifacts = new ArrayList<IArtifact>();
		
		ConcreteSyntax syntax = context.getConcreteSyntax();
		
		for (TokenDefinition tokenDefinition : syntax.getAllTokens()) {
			if (!tokenDefinition.isUsed()) {
				continue;
			}
			// do not generate a resolver for imported tokens
			if (csUtil.isImportedToken(syntax, tokenDefinition)) {
				continue;
			}
			File resolverFile = context.getTokenResolverFile(syntax, tokenDefinition);
			IGenerator resolverGenerator = new TokenResolverGenerator(context, tokenDefinition);
			Artifact artifact = new Artifact(resolverFile, invokeGeneration(resolverGenerator, context.getProblemCollector()));
			artifacts.add(artifact);
		}

		return artifacts;
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_TOKEN_RESOLVERS;
	}
}
