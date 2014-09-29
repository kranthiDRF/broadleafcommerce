package com.drf.core.subscription.domain;

import org.broadleafcommerce.common.BroadleafEnumerationType;

import java.util.LinkedHashMap;


public class SubscriptionType implements BroadleafEnumerationType {

    private static final LinkedHashMap<String, SubscriptionType> TYPES = new LinkedHashMap<String, SubscriptionType>();

    public static final SubscriptionType CLASSIC = new SubscriptionType("CLASSIC", "Classic");
    public static final SubscriptionType FORMULATOR = new SubscriptionType("FORMULATOR", "Formulator");
    public static final SubscriptionType EASYFORM = new SubscriptionType("EASYFORM", "EasyForm");
    public static final SubscriptionType HARNESS_EYE = new SubscriptionType("HARNESS_EYE", "HarnessEye");
    public static final SubscriptionType CLOCKER_REPORTS = new SubscriptionType("HARNESS_EYE", "HarnessEye");


    public static SubscriptionType getInstance(final String type) {
        return TYPES.get(type);
    }

    private String type;
    private String friendlyType;

    public SubscriptionType() {
        //do nothing
    }

    public SubscriptionType(final String type, final String friendlyType) {
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
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!getClass().isAssignableFrom(obj.getClass()))
            return false;
        SubscriptionType other = (SubscriptionType) obj;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }
    
}
