package com.drf.core.domain.entitlement;

import org.broadleafcommerce.common.BroadleafEnumerationType;

import java.util.LinkedHashMap;


public class DownloadType implements BroadleafEnumerationType {

    private static final LinkedHashMap<String, DownloadType> TYPES = new LinkedHashMap<String, DownloadType>();

    public static final DownloadType CLASSIC = new DownloadType("CLASSIC", "Classic");
    public static final DownloadType FORMULATOR = new DownloadType("FORMULATOR", "Formulator");
    public static final DownloadType EASYFORM = new DownloadType("EASYFORM", "EasyForm");
    public static final DownloadType HARNESS_EYE = new DownloadType("HARNESS_EYE", "HarnessEye");
    public static final DownloadType CLOCKER_REPORTS = new DownloadType("HARNESS_EYE", "HarnessEye");


    public static DownloadType getInstance(final String type) {
        return TYPES.get(type);
    }

    private String type;
    private String friendlyType;

    public DownloadType() {
        //do nothing
    }

    public DownloadType(final String type, final String friendlyType) {
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
        DownloadType other = (DownloadType) obj;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }
    
}
