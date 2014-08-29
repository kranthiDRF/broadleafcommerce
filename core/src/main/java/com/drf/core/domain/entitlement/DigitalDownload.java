package com.drf.core.domain.entitlement;

import org.broadleafcommerce.common.extensibility.jpa.clone.ClonePolicyMap;
import org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransform;
import org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember;
import org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes;
import org.broadleafcommerce.common.presentation.AdminPresentation;
import org.broadleafcommerce.common.presentation.AdminPresentationClass;
import org.broadleafcommerce.common.presentation.AdminPresentationMap;
import org.broadleafcommerce.common.presentation.AdminPresentationMapKey;
import org.broadleafcommerce.common.presentation.PopulateToOneFieldsEnum;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.presentation.client.VisibilityEnum;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.drf.core.domain.catalog.DRFSku;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "DRF_DIGITAL_DOWNLOAD")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "blProducts")
@AdminPresentationClass(populateToOneFields = PopulateToOneFieldsEnum.FALSE)
@DirectCopyTransform({
        @DirectCopyTransformMember(templateTokens = DirectCopyTransformTypes.SANDBOX, skipOverlaps=true)
})
public class DigitalDownload implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "DigitalDownloadId")
    @GenericGenerator(
        name = "DigitalDownloadId",
        strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator",
        parameters = {
            @Parameter(name = "segment_value", value = "DigitalDownload"),
            @Parameter(name = "entity_name", value = "com.drf.core.domain.entitlement.DigitalDownload")
        }
    )
    @Column(name = "DIGITAL_DOWNLOAD_ID")
    @AdminPresentation(visibility = VisibilityEnum.HIDDEN_ALL)
    protected Long id;
    
    @ManyToOne(targetEntity = DRFSku.class)
    @JoinColumn(name = "SKU_ID")
    protected DRFSku sku;
    
    @Column(name = "NAME")
    @AdminPresentation(friendlyName = "Name", prominent = true, order = 1)
    protected String name;
    
    @Column(name = "DOWNLOAD_TYPE")
    @AdminPresentation(friendlyName = "Download Type",
        fieldType = SupportedFieldType.BROADLEAF_ENUMERATION,
        broadleafEnumeration = "com.drf.core.domain.entitlement.DownloadType")
    protected String downloadType;

    @Column(name = "START_DATE")
    @AdminPresentation(friendlyName = "Access Start Date", order = 100)
    protected Date startDate;
    
    @Column(name = "END_DATE")
    @AdminPresentation(friendlyName = "Access End Date", order = 200)
    protected Date endDate;
    
    @Column(name = "DURATION")
    @AdminPresentation(friendlyName = "Access Duration", helpText = "Only duration or start and end date should be specified")
    protected Integer duration;

    @Column(name = "TRACK")
    @AdminPresentation(friendlyName = "Track", prominent = true, order = 2)
    protected String track;

    @OneToMany(mappedBy = "digitalDownload", targetEntity = DigitalDownloadAttribute.class, cascade = { CascadeType.ALL }, orphanRemoval = true)
    @Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="blProducts")
    @MapKey(name="name")
    @BatchSize(size = 50)
    @AdminPresentationMap(friendlyName = "Attributes",
        deleteEntityUponRemove = true, keyPropertyFriendlyName = "Attribute Name",
        keys = {
            @AdminPresentationMapKey(keyName = "QUANTITY", friendlyKeyName = "Quantity")
        }
    )
    @ClonePolicyMap
    protected Map<String, DigitalDownloadAttribute> attributes = new HashMap<String, DigitalDownloadAttribute>();

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public DRFSku getSku() {
        return sku;
    }

    public void setSku(DRFSku sku) {
        this.sku = sku;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Map<String, DigitalDownloadAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, DigitalDownloadAttribute> attributes) {
        this.attributes = attributes;
    }

}
