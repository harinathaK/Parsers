/**
 * 
 */
/**
 * @author HARI
 *
 *SAX Parser is different from the DOM Parser where SAX parser doesn’t load the complete XML into the memory, 
 *instead it parses the XML line by line triggering different events as and when it encounters different elements like: 
 *opening tag, closing tag, character data, comments and so on. This is the reason why SAX Parser is called an event based parser.

Along with the XML source file, we also register a handler which extends the DefaultHandler class. 
The DefaultHandler class provides different callbacks out of which we would be interested in:

startElement() – triggers this event when the start of the tag is encountered.
endElement() – triggers this event when the end of the tag is encountered.
characters() – triggers this event when it encounters some text data.







As an example, I'm going to refer to the following XML sample:

<?xml version="1.0"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
  <xs:element name="note">
    <xs:complexType>
      <xs:sequence>
        <xs:element name="to" type="xs:string"/>
        <xs:element name="from" type="xs:string"/>
        <xs:element name="heading" type="xs:string"/>
        <xs:element name="body" type="xs:string"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
</xs:schema>
Namespace

A namespace is the logical container in which an element is defined. The XML Schema namespace 
(with uri: http://www.w3.org/2001/XMLSchema). In the above document, it is being referenced on line 2. 
XML document processing may occur using an XML parser which is either namespace-aware or not, 
but documents using namespaces will typically need to be parsed by namespace-aware parsers.

Namespaces are defined so that a) they can be cataloged by the parser and b) 
so that elements with the same name in different namespaces can exist in the same document without becoming ambiguously-defined.

Prefix

A prefix is the short-hand key used to refer to a namespace. In the above example, xs is used to refer to the XML Schema namespace.

Local Name (Part)

An element in a document has a name as it is defined in the namespace. 
In the above example, you can find schema, element, complexType, sequence, and element as local names. Local names can be ambiguous 
if you have multiple namespaces referenced in your document and one or more of those namespaces define elements with the same name.

Qualified Name (qName)

A qualified name consists of the prefix for the namespace (optionally, some implementations can use the namespace uri),
 followed by a :, followed by the element's local name. In the above example, you can find xs:schema, xs:element, xs:complexType, 
 xs:sequence, and xs:element as qualified names. These names are unambiguous, and can be processed by the parser and validated.
 */
package com.test.sax;