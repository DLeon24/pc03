package cjava.dao;

import cjava.service.CustomerService;
import cjava.service.impl.CustomerCSTDAO;
import static cjava.util.Util.CSTM;

public class DaoFactory {
    
    private DaoFactory() {
    }
    
    public static DaoFactory getInstance() {
        return DaoFactoryHolder.INSTANCE;
    }
    
    private static class DaoFactoryHolder {
        private static final DaoFactory INSTANCE = new DaoFactory();
    }
    
    public CustomerService getCustomerDao(int tipo){
        CustomerService customerService = null ;
        switch(tipo){
           case CSTM: customerService = new CustomerCSTDAO(); break;
           default: return null;    
        }
        return customerService;
    }
   
    
    
}
