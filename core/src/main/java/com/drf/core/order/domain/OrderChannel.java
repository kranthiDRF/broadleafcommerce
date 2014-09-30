package com.drf.core.order.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.broadleafcommerce.common.BroadleafEnumerationType;

import java.io.Serializable;
import java.util.LinkedHashMap;

/**
 * Extensible list of channels that an {@link DRFOrder} could come from. This should be set on {@link 
 * 
 * @author Phillip Verheyden (phillipuniverse)
 */
public class OrderChannel implements Serializable, BroadleafEnumerationType {

    private static final long serialVersionUID = 1L;

    private static final LinkedHashMap<String, OrderChannel> TYPES = new LinkedHashMap<String, OrderChannel>();

    /**
     * The order came from somewhere on the web
     */
    public static final OrderChannel WEB = new OrderChannel("WEB", "Web");
    
    /**
     * The order came from an email promotion
     */
    public static final OrderChannel EMAIL = new OrderChannel("EMAIL", "Email");
    
    /**
     * The order came from a targeted advertisement
     */
    public static final OrderChannel ADVERTISEMENT = new OrderChannel("ADVERTISEMENT", "Advertisement");
    
    public static OrderChannel getInstance(final String type) {
        return TYPES.get(type);
    }

    private String type;
    private String friendlyType;

    public OrderChannel() {
        //do nothing
    }

    public OrderChannel(final String type, final String friendlyType) {
        this.friendlyType = friendlyType;
        setType(type);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getFriendlyType() {
        return friendlyType;
    }

    private void setType(final String type) {
        this.type = type;
        if (!TYPES.containsKey(type)) {
            TYPES.put(type, this);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && getClass().isAssignableFrom(obj.getClass())) {
            OrderChannel other = (OrderChannel) obj;
            return new EqualsBuilder()
                .append(type, other.type)
                .build();
        }
        return false;
    }

}
