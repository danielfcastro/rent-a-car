package br.com.danielfcastro.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.danielfcastro.resources.AddressResource;

@ApplicationPath("/")
public class RentACarApplication extends Application{
    private Set<Object> singletons = new HashSet<Object>();
    
    public void RestEasyServices() {
        singletons.add(new AddressResource());
    }
 
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
