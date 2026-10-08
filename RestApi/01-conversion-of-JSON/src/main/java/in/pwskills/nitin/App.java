package in.pwskills.nitin;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.pwskills.nitin.beans.Customer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws StreamReadException, DatabindException, IOException
    {
        ObjectMapper mapper=new ObjectMapper();
        
        File file=new File("data/sample.json");
        
        Customer customer=mapper.readValue(file, Customer.class);
        
        System.out.println(customer);
    }
}
