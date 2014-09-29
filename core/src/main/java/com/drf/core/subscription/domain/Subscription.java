package com.drf.core.domain.subscription;

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
@Table(name = "DRF_SUBSCRIPTION")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "blProducts")
@AdminPresentationClass(populateToOneFields = PopulateToOneFieldsEnum.FALSE)
@DirectCopyTransform({
        @DirectCopyTransformMember(templateTokens = DirectCopyTransformTypes.SANDBOX, skipOverlaps=true)
})
public class Subscription implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "SubscriptionId")
    @GenericGenerator(
        name = "SubscriptionId",
        strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator",
        parameters = {
            @Parameter(name = "segment_value", value = "Subscription"),
            @Parameter(name = "entity_name", value = "com.drf.core.domain.subscription.Subscription")
        }
    )
    @Column(name = "SUBSCRIPTION_ID")
    @AdminPresentation(visibility = VisibilityEnum.HIDDEN_ALL)
    protected Long id;
    
    @ManyToOne(targetEntity = DRFSku.class)
    @JoinColumn(name = "SKU_ID")
    protected DRFSku sku;
    
    @Column(name = "NAME")
    @AdminPresentation(friendlyName = "Name", prominent = true, order = 1)
    protected String name;
    
    @Column(name = "SUBSCRIPTION_TYPE")
    @AdminPresentation(
    	order = 2,
    	friendlyName = "Subscription Type",
        fieldType = SupportedFieldType.BROADLEAF_ENUMERATION,
        broadleafEnumeration = "com.drf.core.domain.subscription.SubscriptionType")
    protected String subscriptionType;

    @Column(name = "START_DATE")
    @AdminPresentation(friendlyName = "Access Start Date", order = 100)
    protected Date startDate;
    
    @Column(name = "END_DATE")
    @AdminPresentation(friendlyName = "Access End Date", order = 200)
    protected Date endDate;
    
    @Column(name = "DURATION")
    @AdminPresentation(friendlyName = "Access Duration", helpText = "Only duration or start and end date should be specified")
    protected Integer duration;

    @OneToMany(mappedBy = "subscription", targetEntity = SubscriptionOption.class, cascade = { CascadeType.ALL }, orphanRemoval = true)
    @Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="blProducts")
    @MapKey(name="name")
    @BatchSize(size = 50)
    @AdminPresentationMap(friendlyName = "Option",
        deleteEntityUponRemove = true,
        keys = {
            @AdminPresentationMapKey(keyName = "NUMBER_OF_CARDS", friendlyKeyName = "Number of Cards"),
            @AdminPresentationMapKey(keyName = "TRACK", friendlyKeyName = "Track"),
            @AdminPresentationMapKey(keyName = "RACE_DATE_RANGE", friendlyKeyName = "Race Date Range")
        }
    )
    @ClonePolicyMap
    protected Map<String, SubscriptionOption> options = new HashMap<String, SubscriptionOption>();

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

    public Map<String, SubscriptionOption> getOptions() {
        return options;
    }

    public void setOptions(Map<String, SubscriptionOption> options) {
        this.options = options;
    }

}
