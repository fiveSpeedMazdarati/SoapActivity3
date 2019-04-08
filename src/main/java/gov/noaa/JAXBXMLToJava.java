package gov.noaa;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;

public class JAXBXMLToJava {
    /**
     *
     * @param parseMe the XML to parse
     * @return the latLon value from the unmarshalled XML object
     */
    public static String parse(String parseMe) {

        try {

           JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            DwmlType latLon = (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(parseMe));

            return(latLon.getLatLonList());

        } catch (JAXBException exception) {
            System.out.println("There was a problem..." + exception.getMessage());
        } catch (Exception ioe) {
            System.out.println("There was a problem..." + ioe.getMessage());
        }
    return "";
    }
}
