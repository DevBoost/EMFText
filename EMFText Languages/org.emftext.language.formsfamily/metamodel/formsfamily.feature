<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="FormsFamily Features">
  <root minCardinality="1" maxCardinality="1" name="FormsFamily">
    <groups maxCardinality="2">
      <childFeatures maxCardinality="1" name="DependentItems"/>
      <childFeatures maxCardinality="1" name="EmpiricalScales">
        <groups maxCardinality="2">
          <childFeatures maxCardinality="1" name="LikertScale"/>
          <childFeatures maxCardinality="1" name="GuttmanScale"/>
        </groups>
      </childFeatures>
      <childFeatures maxCardinality="1" name="MultipleChoices"/>
    </groups>
  </root>
</feature:FeatureModel>
