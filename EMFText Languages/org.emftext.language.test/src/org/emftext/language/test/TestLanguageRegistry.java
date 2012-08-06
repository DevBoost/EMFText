/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.test;

import java.util.LinkedHashSet;
import java.util.Set;

import org.emftext.access.EMFTextAccessPlugin;
import org.emftext.language.abnf.resource.abnf.mopp.AbnfMetaInformation;
import org.emftext.language.appflow.resource.appflow.mopp.AppflowMetaInformation;
import org.emftext.language.aterms.resource.aterms.mopp.AtermsMetaInformation;
import org.emftext.language.b.resource.mch.mopp.MchMetaInformation;
import org.emftext.language.bool.resource.bool.mopp.BoolMetaInformation;
import org.emftext.language.bibtex.resource.bib.mopp.BibMetaInformation;
import org.emftext.language.c_sharp.resource.csharp.mopp.CsharpMetaInformation;
import org.emftext.language.calc.resource.calc.mopp.CalcMetaInformation;
import org.emftext.language.chess.resource.cg.mopp.CgMetaInformation;
import org.emftext.language.conference.resource.conference.mopp.ConferenceMetaInformation;
import org.emftext.language.csv.resource.csv.mopp.CsvMetaInformation;
import org.emftext.language.customer.resource.customer.mopp.CustomerMetaInformation;
import org.emftext.language.customsandwich.resource.customsandwich.mopp.CustomsandwichMetaInformation;
import org.emftext.language.dbschema.resource.dbschema.mopp.DbschemaMetaInformation;
import org.emftext.language.dot.resource.dot.mopp.DotMetaInformation;
import org.emftext.language.dynamicui.resource.dynamicui.mopp.DynamicuiMetaInformation;
import org.emftext.language.ecore.resource.facade.mopp.FacadeEcoreMetaInformation;
import org.emftext.language.mecore.resource.mecore.mopp.MecoreMetaInformation;
import org.emftext.language.ecore.resource.text.mopp.TextEcoreMetaInformation;
import org.emftext.language.efactory.resource.efactory.mopp.EfactoryMetaInformation;
import org.emftext.language.emfdoc.resource.emfdoc.mopp.EmfdocMetaInformation;
import org.emftext.language.featherweightjava.resource.fj.mopp.FjMetaInformation;
import org.emftext.language.feature.resource.feature.mopp.FeatureMetaInformation;
import org.emftext.language.filesystem.resource.fs.mopp.FsMetaInformation;
import org.emftext.language.forms.resource.forms.mopp.FormsMetaInformation;
import org.emftext.language.formular.resource.formular.mopp.FormularMetaInformation;
import org.emftext.language.functions.resource.functions.mopp.FunctionsMetaInformation;
import org.emftext.language.hedl.resource.hedl.mopp.HedlMetaInformation;
import org.emftext.language.java.closures.resource.closure.mopp.ClosureMetaInformation;
import org.emftext.language.java.ejava.resource.ejava.mopp.EjavaMetaInformation;
import org.emftext.language.java.javabehavior4uml.resource.javabehavior.mopp.JavabehaviorMetaInformation;
import org.emftext.language.java.jtemplates.resource.javatemplate.mopp.JavatemplateMetaInformation;
import org.emftext.language.java.properties.resource.propjava.mopp.PropjavaMetaInformation;
import org.emftext.language.java.resource.java.mopp.JavaMetaInformation;
import org.emftext.language.java.reusejava.resource.reusejava.mopp.ReusejavaMetaInformation;
import org.emftext.language.java.treejava.resource.treejava.mopp.TreejavaMetaInformation;
import org.emftext.language.javaproperties.resource.properties.mopp.PropertiesMetaInformation;
import org.emftext.language.km3.resource.km3.mopp.Km3MetaInformation;
import org.emftext.language.manifest.resource.manifest.mopp.MFMetaInformation;
import org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.mopp.MartinfowlerdslMetaInformation;
import org.emftext.language.modelquery.resource.modelquery.mopp.ModelqueryMetaInformation;
import org.emftext.language.models.resource.model.mopp.ModelMetaInformation;
import org.emftext.language.notes.resource.notes.mopp.NotesMetaInformation;
import org.emftext.language.office.resource.office.mopp.OfficeMetaInformation;
import org.emftext.language.office2.resource.office2.mopp.Office2MetaInformation;
import org.emftext.language.owl.resource.owl.mopp.OwlMetaInformation;
import org.emftext.language.owlcl.resource.owlcl.mopp.OwlclMetaInformation;
import org.emftext.language.parametercheck.resource.pcheck.mopp.PcheckMetaInformation;
import org.emftext.language.petrinet.resource.petrinet.mopp.PetrinetMetaInformation;
import org.emftext.language.pico.resource.pico.mopp.PicoMetaInformation;
import org.emftext.language.pl0.resource.pl0.mopp.Pl0MetaInformation;
import org.emftext.language.pl0extended.resource.pl0extended.mopp.Pl0extendedMetaInformation;
import org.emftext.language.plugin.resource.topf.mopp.TopfMetaInformation;
import org.emftext.language.quickuml.resource.quml.mopp.QumlMetaInformation;
import org.emftext.language.rails.resource.rails.mopp.RailsMetaInformation;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingMetaInformation;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextMetaInformation;
import org.emftext.language.refactoring.specification.resource.mopp.RefspecMetaInformation;
import org.emftext.language.regexp.resource.regexp_antlr.mopp.Regexp_antlrMetaInformation;
import org.emftext.language.regexp.resource.regexp_automaton.mopp.Regexp_automatonMetaInformation;
import org.emftext.language.regexp.resource.regexp_sdf.mopp.Regexp_sdfMetaInformation;
import org.emftext.language.sandwich.resource.sandwich.mopp.SandwichMetaInformation;
import org.emftext.language.secprop.resource.text.secprop.mopp.TextSecpropMetaInformation;
import org.emftext.language.simplec.resource.c.mopp.CMetaInformation;
import org.emftext.language.simplegui.resource.simplegui.mopp.SimpleguiMetaInformation;
import org.emftext.language.simplemath.resource.sm.mopp.SmMetaInformation;
import org.emftext.language.simpleweave.resource.simpleweave.mopp.SimpleweaveMetaInformation;
import org.emftext.language.sparql.resource.sparql.mopp.RqMetaInformation;
import org.emftext.language.sql.resource.sql.mopp.SqlMetaInformation;
import org.emftext.language.statemachine.resource.statemachine.mopp.StatemachineMetaInformation;
import org.emftext.language.swrl.resource.swrl.mopp.SwrlMetaInformation;
import org.emftext.language.tbool.resource.tbool.mopp.TboolMetaInformation;
import org.emftext.language.tcltk.resource.tcl.mopp.TclMetaInformation;
import org.emftext.language.templateconcepts.call.resource.templatecall.mopp.TemplatecallMetaInformation;
import org.emftext.language.textadventure.resource.tas.mopp.TasMetaInformation;
import org.emftext.language.theater.resource.theater.mopp.TheaterMetaInformation;
import org.emftext.language.threevaluedlogic.resource.tvl.mopp.TvlMetaInformation;
import org.emftext.language.timedautomata.resource.ta.mopp.TaMetaInformation;
import org.emftext.language.usecaseinvariant.resource.ucinv.mopp.UcinvMetaInformation;
import org.emftext.language.valueflow.resource.valueflow.mopp.TextValueflowMetaInformation;
import org.emftext.language.webtest.resource.webtest.mopp.WebtestMetaInformation;
import org.emftext.language.xml.resource.xml.mopp.XmlMetaInformation;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation;
import org.emftext.test.booleanterminal.resource.booleanterminal.mopp.BooleanterminalMetaInformation;
import org.emftext.test.bug1154.resource.bug1154.mopp.Bug1154MetaInformation;
import org.emftext.test.bug1233.resource.bug1233.mopp.Bug1233MetaInformation;
import org.emftext.test.bug1709.resource.bug1709.mopp.Bug1709MetaInformation;
import org.emftext.test.bug933.resource.bug933.mopp.Bug933MetaInformation;
import org.emftext.test.cct1.resource.cct1.mopp.Cct1MetaInformation;
import org.emftext.test.cct2.resource.cct2.mopp.Cct2MetaInformation;
import org.emftext.test.cct3.resource.cct3.mopp.Cct3MetaInformation;
import org.emftext.test.cct4.resource.cct4.mopp.Cct4MetaInformation;
import org.emftext.test.escaping.resource.escaping.mopp.EscapingMetaInformation;
import org.emftext.test.generics.resource.generics.mopp.GenericsMetaInformation;
import org.emftext.test.grammar_features.resource.grammar_features.mopp.Grammar_featuresMetaInformation;
import org.emftext.test.noeclipse.resource.noeclipse.mopp.NoeclipseMetaInformation;
import org.emftext.test.printing.resource.printing.mopp.PrintingMetaInformation;
import org.emftext.test.printing.modellayout.resource.modellayout.mopp.ModellayoutMetaInformation;
import org.emftext.test.resolving.resource.resolving.mopp.ResolvingMetaInformation;
import org.emftext.test.multicharsuffix.resource.multicharsuffix.mopp.MulticharsuffixMetaInformation;
import org.reuseware.coconut.fracol.resource.fracol.mopp.FracolMetaInformation;
import org.reuseware.coconut.reuseextension.resource.rex.mopp.RexMetaInformation;
import org.reuseware.coconut.reuseextensionactivator.resource.rexactivator.mopp.Rex_activatorMetaInformation;

public class TestLanguageRegistry {

	public void registerAllLanguages() {
		for (Object metaInformation : getAllMetaInformations()) {
			EMFTextAccessPlugin.registerConcreteSyntax(metaInformation);
		}
	}

	public Set<Object> getAllMetaInformations() {
		Set<Object> metaInformations = new LinkedHashSet<Object>();
		metaInformations.addAll(getMetaInformationsForLanguageOnUpdateSite());
		metaInformations.addAll(getMetaInformationsForInternalLanguages());
		return metaInformations;
	}

	public Set<Object> getMetaInformationsForLanguageOnUpdateSite() {
		Set<Object> metaInformations = new LinkedHashSet<Object>();
		metaInformations.add(new AbnfMetaInformation());
		metaInformations.add(new BibMetaInformation());
		metaInformations.add(new CalcMetaInformation());
		metaInformations.add(new CgMetaInformation());
		metaInformations.add(new ConferenceMetaInformation());
		metaInformations.add(new CustomsandwichMetaInformation());
		metaInformations.add(new CustomerMetaInformation());
		metaInformations.add(new CsvMetaInformation());
		metaInformations.add(new DbschemaMetaInformation());
		metaInformations.add(new DotMetaInformation());
		metaInformations.add(new DynamicuiMetaInformation());
		metaInformations.add(new FacadeEcoreMetaInformation());
		metaInformations.add(new TextEcoreMetaInformation());
		metaInformations.add(new MecoreMetaInformation());
		metaInformations.add(new EfactoryMetaInformation());
		metaInformations.add(new EmfdocMetaInformation());
		metaInformations.add(new FjMetaInformation());
		metaInformations.add(new FeatureMetaInformation());
		metaInformations.add(new FormularMetaInformation());
		metaInformations.add(new NotesMetaInformation());
		metaInformations.add(new FormsMetaInformation());
		metaInformations.add(new FunctionsMetaInformation()); // is not yet on update site, but will be added soon
		metaInformations.add(new HedlMetaInformation());
		metaInformations.add(new JavaMetaInformation());
		metaInformations.add(new JavabehaviorMetaInformation());
		metaInformations.add(new ClosureMetaInformation());
		metaInformations.add(new PropjavaMetaInformation());
		metaInformations.add(new ReusejavaMetaInformation());
		metaInformations.add(new TreejavaMetaInformation());
		metaInformations.add(new PropertiesMetaInformation());
		metaInformations.add(new Regexp_antlrMetaInformation());
		metaInformations.add(new Regexp_sdfMetaInformation());
		metaInformations.add(new JavatemplateMetaInformation());
		metaInformations.add(new Km3MetaInformation());
		metaInformations.add(new MFMetaInformation());
		metaInformations.add(new MartinfowlerdslMetaInformation());
		metaInformations.add(new ModelqueryMetaInformation());
		metaInformations.add(new ModelMetaInformation());
		metaInformations.add(new OfficeMetaInformation());
		metaInformations.add(new OwlMetaInformation());
		metaInformations.add(new OwlclMetaInformation());
		metaInformations.add(new PetrinetMetaInformation());
		metaInformations.add(new PicoMetaInformation());
		metaInformations.add(new TopfMetaInformation());
		metaInformations.add(new Pl0MetaInformation());
		metaInformations.add(new Pl0extendedMetaInformation());
		metaInformations.add(new QumlMetaInformation());
		metaInformations.add(new RailsMetaInformation());
		metaInformations.add(new CMetaInformation());
		metaInformations.add(new SandwichMetaInformation());
		metaInformations.add(new TextSecpropMetaInformation());
		metaInformations.add(new SimpleguiMetaInformation());
		metaInformations.add(new SimpleweaveMetaInformation());
		metaInformations.add(new SmMetaInformation());
		metaInformations.add(new StatemachineMetaInformation());
		metaInformations.add(new RqMetaInformation());
		metaInformations.add(new TboolMetaInformation());
		metaInformations.add(new TclMetaInformation());
		metaInformations.add(new TemplatecallMetaInformation());
		metaInformations.add(new TasMetaInformation());
		metaInformations.add(new TheaterMetaInformation());
		metaInformations.add(new TvlMetaInformation());
		metaInformations.add(new UcinvMetaInformation());
		metaInformations.add(new TextValueflowMetaInformation());
		metaInformations.add(new CsMetaInformation());
		metaInformations.add(new FormsMetaInformation());
		metaInformations.add(new EjavaMetaInformation());
		metaInformations.add(new WebtestMetaInformation());
		
		//Reuseware languages
		metaInformations.add(new RexMetaInformation());
		metaInformations.add(new FracolMetaInformation());
		metaInformations.add(new Rex_activatorMetaInformation());
		
		//Refactory languages
		metaInformations.add(new RolemappingMetaInformation());
		metaInformations.add(new RolestextMetaInformation());
		metaInformations.add(new RefspecMetaInformation());
		
		return metaInformations;
	}

	public Set<Object> getMetaInformationsForInternalLanguages() {
		Set<Object> metaInformations = new LinkedHashSet<Object>();
		metaInformations.add(new AtermsMetaInformation());
		metaInformations.add(new AppflowMetaInformation());
		metaInformations.add(new MchMetaInformation());
		metaInformations.add(new BoolMetaInformation());
		metaInformations.add(new CsharpMetaInformation());
		metaInformations.add(new FsMetaInformation());
		metaInformations.add(new Office2MetaInformation());
		metaInformations.add(new SqlMetaInformation());
		metaInformations.add(new XmlMetaInformation());
		metaInformations.add(new PcheckMetaInformation());
		metaInformations.add(new Cct1MetaInformation());
		metaInformations.add(new Cct2MetaInformation());
		metaInformations.add(new Cct3MetaInformation());
		metaInformations.add(new Cct4MetaInformation());
		metaInformations.add(new EscapingMetaInformation());
		metaInformations.add(new Grammar_featuresMetaInformation());
		metaInformations.add(new BooleanterminalMetaInformation());
		metaInformations.add(new Bug933MetaInformation());
		metaInformations.add(new Bug1154MetaInformation());
		metaInformations.add(new Bug1233MetaInformation());
		metaInformations.add(new Bug1709MetaInformation());
		metaInformations.add(new NoeclipseMetaInformation());
		metaInformations.add(new PrintingMetaInformation());
		metaInformations.add(new ModellayoutMetaInformation());
		metaInformations.add(new ResolvingMetaInformation());
		metaInformations.add(new SwrlMetaInformation());
		metaInformations.add(new TaMetaInformation());
		// TODO move this to getMetaInformationsForLanguageOnUpdateSite() once the automaton regex DSL is on the update site
		metaInformations.add(new Regexp_automatonMetaInformation());
		metaInformations.add(new MulticharsuffixMetaInformation());
		metaInformations.add(new GenericsMetaInformation());
		return metaInformations;
	}
}
