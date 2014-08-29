package com.drf.core.domain.catalog;

import org.broadleafcommerce.common.extensibility.jpa.clone.ClonePolicyCollection;
import org.broadleafcommerce.common.presentation.AdminPresentationClass;
import org.broadleafcommerce.common.presentation.AdminPresentationCollection;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.drf.core.domain.entitlement.DigitalDownload;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DRF_SKU")
@AdminPresentationClass(ceilingDisplayEntity = "com.drf.core.domain.catalog.DRFSku")
public class DRFSku extends SkuImpl {

    private static final long serialVersionUID = 1L;
    
    @OneToMany(mappedBy = "sku", targetEntity = DigitalDownload.class, cascade = { CascadeType.ALL }, orphanRemoval = true)
    @Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region="blProducts")
    @BatchSize(size = 50)
    @AdminPresentationCollection(friendlyName = "Digital Downloads")
    @ClonePolicyCollection
    protected List<DigitalDownload> digitalDownloads = new ArrayList<DigitalDownload>();

}
