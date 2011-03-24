Metamodel files
---------------
 * TextualPathExp.ecore
 * TextualPathExp.km3
 * PathExp.ecore
 * PathExp.km3
 * PetriNet.ecore
 * PetriNet.km3
 * XML.ecore
 * XML.km3

Example files
-------------
 * example.tpe: textual path expression test file
 * textualpathexp-example.ecore: input TextualPathExp model (corresponding to the injection of the previous "tpe" file)
 * pathexp-example.ecore: corresponding PathExp model
 * petrinet-example.ecore: transformed PetriNet model
 * xml-example.ecore: corresponding XML model
 * example.xml: corresponding textual XML file

Transformation files
--------------------
 * TextualPathExp2PathExp.atl
 * PathExp2PetriNet.atl
 * PetriNet2XML.atl
 * XML2PetriNet.atl
 * PetriNet2PathExp.atl
 * PathExp2TextualPathExp.atl

"TextualPathExp.ecore", "PathExp.ecore", "PetriNet.ecore", and "XML.ecore" are the respective metamodels for TextualPathExp, PathExp, PetriNet, and XML models.
Km3 files provide readable versions of these metamodels in the km3 format.

The TextualPathExp2PathExp transformation ("TextualPathExp2PathExp.atl") can be tested with the TextualPathExp model ("textualpathexp-example.ecore") as input.
It returns a PathExp model ("pathexp-example.ecore").
The PathExp2PetriNet transformation ("PathExp2PetriNet.atl") can be tested with the PathExp model ("pathexp-example.ecore") as input.
It returns a PetriNet model ("petrinet-example.ecore").
The PetriNet2XML transformation ("PetriNet2XML.atl") can be tested with the PetriNet model ("petrinet-example.ecore") as input.
It returns a XML model ("xml-example.ecore").
The XML2PetriNet transformation ("XML2PetriNet.atl") can be tested with the XML model ("xml-example.ecore") as input.
It returns a PetriNet model ("petrinet-example.ecore").
The PetriNet2PathExp transformation ("PetriNet2PathExp.atl") can be tested with the PetriNet model ("petrinet-example.ecore") as input.
It returns a PathExp model ("pathexp-example.ecore").
The PathExp2TextualPathExp transformation ("PathExp2TextualPathExp.atl") can be tested with the PathExp model ("pathexp-example.ecore") as input.
It returns a TextualPathExp model ("textualpathexp-example.ecore").

"example.tpe" provides the textual source path expression.
First step in the transformation sequence is to inject it into a TextualPathExp model.
This preliminary transformation is not detailled in this example.

"example.xml" provides the textual XML description (in PNML format) of the Petri net.
This file is the result of four successives operations on the TextualPathExp model:
  1. A transformation from the TextualPathExp to the PathExp model
  2. A transformation from the PathExp to the PetriNet model
  3. A transformation from the PetriNet to the XML model
  4. An extraction from the XML model to text
Step 4 is detailled in this example.
