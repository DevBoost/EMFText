public class ConstraintChecker implements 
	ILwc11OptionProvider, 
	ILwc11ResourcePostProcessorProvider, 
	ILwc11ResourcePostProcessor {

	public void process(Lwc11Resource resource) {
		EList<EObject> contents = resource.getContents();
		for (EObject contentObject : contents) {
			if (contentObject instanceof EntityModel) {
				EntityModel em = (EntityModel) contentObject;
				checkForDuplicateNames(em, resource);
			}
		}
	}

	private void checkForDuplicateNames(
			EntityModel em, 
			Lwc11Resource resource) {
		
		Set<String> usedNames = new LinkedHashSet<String>();
		TreeIterator<EObject> allContents = em.eAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (next instanceof NamedElement) {
				NamedElement element = (NamedElement) next;
				String name = element.getName();
				if (usedNames.contains(name)) {
					resource.addError("Found duplicate name.", element);
				} else {
					usedNames.add(name);
				}
			}
		}
	}

	public ILwc11ResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public Map<?, ?> getOptions() {
		return Collections.singletonMap(
				ILwc11Options.RESOURCE_POSTPROCESSOR_PROVIDER, 
				this);
	}
}
