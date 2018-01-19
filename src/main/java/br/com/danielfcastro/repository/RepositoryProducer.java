package br.com.danielfcastro.repository;


import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import br.com.danielfcastro.dao.AddressDAO;
import br.com.danielfcastro.dao.AddressTypeDAO;
import br.com.danielfcastro.dao.AgencyDAO;
import br.com.danielfcastro.dao.BranchDAO;
import br.com.danielfcastro.dao.CityDAO;
import br.com.danielfcastro.dao.CountryDAO;
import br.com.danielfcastro.dao.CustomerDAO;
import br.com.danielfcastro.dao.EmployeeDAO;
import br.com.danielfcastro.dao.FuelTypeDAO;
import br.com.danielfcastro.dao.ModelTypeDAO;
import br.com.danielfcastro.dao.RentDAO;
import br.com.danielfcastro.dao.ReservationDAO;
import br.com.danielfcastro.dao.SiteTypeDAO;
import br.com.danielfcastro.dao.StateDAO;
import br.com.danielfcastro.dao.TelephoneDAO;
import br.com.danielfcastro.dao.TelephoneTypeDAO;
import br.com.danielfcastro.dao.VehicleAccessoryDAO;
import br.com.danielfcastro.dao.VehicleCategoryDAO;
import br.com.danielfcastro.dao.VehicleDAO;
import br.com.danielfcastro.dao.VehicleTypeDAO;
import br.com.danielfcastro.qualifier.AddressQualifier;
import br.com.danielfcastro.qualifier.AddressTypeQualifier;
import br.com.danielfcastro.qualifier.AgencyQualifier;
import br.com.danielfcastro.qualifier.BranchQualifier;
import br.com.danielfcastro.qualifier.CityQualifier;
import br.com.danielfcastro.qualifier.CountryQualifier;
import br.com.danielfcastro.qualifier.CustomerQualifier;
import br.com.danielfcastro.qualifier.EmployeeQualifier;
import br.com.danielfcastro.qualifier.FuelTypeQualifier;
import br.com.danielfcastro.qualifier.ModelTypeQualifier;
import br.com.danielfcastro.qualifier.RentQualifier;
import br.com.danielfcastro.qualifier.ReservationQualifier;
import br.com.danielfcastro.qualifier.SiteTypeQualifier;
import br.com.danielfcastro.qualifier.StateQualifier;
import br.com.danielfcastro.qualifier.TelephoneQualifier;
import br.com.danielfcastro.qualifier.TelephoneTypeQualifier;
import br.com.danielfcastro.qualifier.VehicleAccessoryQualifier;
import br.com.danielfcastro.qualifier.VehicleCategoryQualifier;
import br.com.danielfcastro.qualifier.VehicleQualifier;
import br.com.danielfcastro.qualifier.VehicleTypeQualifier;


@ApplicationScoped
public class RepositoryProducer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3508668675344179865L;
	@PersistenceUnit(unitName = "camaro-renovacao-renovafacil")
	private EntityManagerFactory factoryCamaroApolice;
	@PersistenceUnit(unitName = "brasilia-comm-renovafacil")
	private EntityManagerFactory factoryBrasiliaComm;

    @RequestScoped
    @AddressQualifier
    @Default
    @Produces
    public IRepository createAddressRepository() {
        return new AddressDAO();
    }
 
    @RequestScoped
    @AddressTypeQualifier
    @Default
    @Produces
    public IRepository createAddressTypeRepository() {
        return new AddressTypeDAO();
    }

    @RequestScoped
    @AgencyQualifier
    @Default
    @Produces
    public IRepository createAgencyRepository() {
        return new AgencyDAO();
    }

    @RequestScoped
    @BranchQualifier
    @Default
    @Produces
    public IRepository createBranchRepository() {
        return new BranchDAO();
    }

    @RequestScoped
    @CityQualifier
    @Default
    @Produces
    public IRepository createCityRepository() {
        return new CityDAO();
    }

    @RequestScoped
    @CountryQualifier
    @Default
    @Produces
    public IRepository createCountryRepository() {
        return new CountryDAO();
    }

    @RequestScoped
    @CustomerQualifier
    @Default
    @Produces
    public IRepository createCustomerRepository() {
        return new CustomerDAO();
    }

    @RequestScoped
    @EmployeeQualifier
    @Default
    @Produces
    public IRepository createEmployeeRepository() {
        return new EmployeeDAO();
    }

    @RequestScoped
    @FuelTypeQualifier
    @Default
    @Produces
    public IRepository createFuelTypeRepository() {
        return new FuelTypeDAO();
    }

    @RequestScoped
    @ModelTypeQualifier
    @Default
    @Produces
    public IRepository createModelTypeRepository() {
        return new ModelTypeDAO();
    }

    @RequestScoped
    @RentQualifier
    @Default
    @Produces
    public IRepository createRentRepository() {
        return new RentDAO();
    }

    @RequestScoped
    @ReservationQualifier
    @Default
    @Produces
    public IRepository createReservationRepository() {
        return new ReservationDAO();
    }

    @RequestScoped
    @SiteTypeQualifier
    @Default
    @Produces
    public IRepository createSiteTypeRepository() {
        return new SiteTypeDAO();
    }
    
    @RequestScoped
    @StateQualifier
    @Default
    @Produces
    public IRepository createStateRepository() {
        return new StateDAO();
    }
    
    @RequestScoped
    @TelephoneQualifier
    @Default
    @Produces
    public IRepository createTelephoneRepository() {
        return new TelephoneDAO();
    }
    
    @RequestScoped
    @TelephoneTypeQualifier
    @Default
    @Produces
    public IRepository createTelephoneTypeRepository() {
        return new TelephoneTypeDAO();
    }
    
    @RequestScoped
    @VehicleQualifier
    @Default
    @Produces
    public IRepository createVehicleRepository() {
        return new VehicleDAO();
    }
    
    @RequestScoped
    @VehicleAccessoryQualifier
    @Default
    @Produces
    public IRepository createVehicleAccessoriesRepository() {
        return new VehicleAccessoryDAO();
    }

    @RequestScoped
    @VehicleCategoryQualifier
    @Default
    @Produces
    public IRepository createVehicleCategoryRepository() {
        return new VehicleCategoryDAO();
    }    
    
    @RequestScoped
    @VehicleTypeQualifier
    @Default
    @Produces
    public IRepository createVehicleTypeRepository() {
        return new VehicleTypeDAO();
    }    
}

