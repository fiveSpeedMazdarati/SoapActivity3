package gov.noaa;

import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;

import static org.junit.jupiter.api.Assertions.*;

class NdfdXMLBindingStubTest {

    @Test
    void latLonListZipCode() throws Exception {
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub) new NdfdXMLLocator().getndfdXMLPort();
        String result = binding.latLonListZipCode("53589");
        String otherResult = JAXBXMLToJava.parse(result);
        //two different tests - the first checks just for the lat/lon string created by the unmarshalling process
        assertEquals("42.9211,-89.2228", otherResult);
        // this checks the entire return string
        assertEquals("<?xml version='1.0'?><dwml version='1.0' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:noNamespaceSchemaLocation='https://graphical.weather.gov/xml/DWMLgen/schema/DWML.xsd'><latLonList>42.9211,-89.2228</latLonList></dwml>", result);
    }
}