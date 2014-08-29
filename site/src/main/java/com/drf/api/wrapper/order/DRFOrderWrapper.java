package com.drf.api.wrapper.order;
import org.broadleafcommerce.core.web.api.wrapper.OrderWrapper;


/**
 * Extended in order to provide a getter
 * 
 * @author Phillip Verheyden (phillipuniverse)
 */
public class DRFOrderWrapper extends OrderWrapper {

    public Long getId() {
        return id;
    }
    
}
