<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="Company Features">
  <constraints language="OWL" expression="EMF" constrainedFeatures="EMFText Mentoring"/>
  <constraints language="OWL" expression="EMF" constrainedFeatures="EMFText Parsing"/>
  <constraints language="OWL" expression="EMF" constrainedFeatures="EMFText Serialization"/>
  <root minCardinality="1" maxCardinality="1" name="Company">
    <groups maxCardinality="2">
      <childFeatures minCardinality="1" maxCardinality="3" name="Basics">
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures minCardinality="1" maxCardinality="1" name="CompanyModel">
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="EMF"/>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="2">
          <childFeatures minCardinality="1" maxCardinality="2" name="Fuctionalities">
            <groups minCardinality="1" maxCardinality="2">
              <childFeatures maxCardinality="1" name="Cut"/>
              <childFeatures maxCardinality="1" name="Total"/>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
      <childFeatures maxCardinality="10" name="Capabilities">
        <groups maxCardinality="10">
          <childFeatures maxCardinality="1" name="AccessControl"/>
          <childFeatures maxCardinality="1" name="Distribution"/>
          <childFeatures maxCardinality="1" name="FaultTolerance"/>
          <childFeatures maxCardinality="1" name="Interaction"/>
          <childFeatures maxCardinality="1" name="Logging"/>
          <childFeatures maxCardinality="1" name="Parallelism"/>
          <childFeatures maxCardinality="1" name="Parsing">
            <groups maxCardinality="1">
              <childFeatures maxCardinality="1" name="EMFText Parsing" constraints="//@constraints.1"/>
              <childFeatures maxCardinality="1" name="ANTLR Parsing"/>
            </groups>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Persistence"/>
          <childFeatures maxCardinality="1" name="Serialization">
            <groups maxCardinality="1">
              <childFeatures maxCardinality="1" name="EMFText Serialization" constraints="//@constraints.2"/>
            </groups>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Visualization"/>
        </groups>
      </childFeatures>
      <childFeatures maxCardinality="3" name="Extras">
        <groups maxCardinality="3">
          <childFeatures maxCardinality="1" name="Depth"/>
          <childFeatures maxCardinality="1" name="Mentoring">
            <groups maxCardinality="1">
              <childFeatures maxCardinality="1" name="EMFText Mentoring" constraints="//@constraints.0"/>
            </groups>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Precedence"/>
        </groups>
      </childFeatures>
    </groups>
  </root>
</feature:FeatureModel>
