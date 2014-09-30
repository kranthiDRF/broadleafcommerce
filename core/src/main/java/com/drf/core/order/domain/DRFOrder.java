package com.drf.core.order.domain;
import org.broadleafcommerce.common.presentation.AdminPresentation;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.core.order.domain.OrderImpl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DRF_ORDER")
public class DRFOrder extends OrderImpl {

    /**
     * Required on all entities for proper operation in the Broadleaf Admin
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "CHANNEL")
    @AdminPresentation(friendlyName = "Channel",
        prominent = true,
        fieldType = SupportedFieldType.BROADLEAF_ENUMERATION,
        broadleafEnumeration="com.drf.core.order.domain.OrderChannel")
    protected String channel;

    
    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
    
}
