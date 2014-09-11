package com.drf.core.domain.subscription;

import org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransform;
import org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember;
import org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes;
import org.broadleafcommerce.common.presentation.AdminPresentation;
import org.broadleafcommerce.common.presentation.client.VisibilityEnum;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Parameter;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DRF_SUBSCRIPTION_OPTION")
@DirectCopyTransform({
    @DirectCopyTransformMember(templateTokens = DirectCopyTransformTypes.SANDBOX, skipOverlaps=true),
    @DirectCopyTransformMember(templateTokens = DirectCopyTransformTypes.SANDBOX_PRECLONE_INFORMATION, skipOverlaps=true)    
})
public class SubscriptionOption implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "SubscriptionOptionId")
    @GenericGenerator(
        name = "SubscriptionOptionId",
        strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator",
        parameters = {
            @Parameter(name = "segment_value", value = "SubscriptionOption"),
            @Parameter(name = "entity_name", value = "com.drf.core.domain.subscription.SubscriptionOption")
        }
    )
    @Column(name = "SUBSCRIPTION_OPTION_ID")
    @AdminPresentation(visibility = VisibilityEnum.HIDDEN_ALL)
    protected Long id;

    @ManyToOne(targetEntity = Subscription.class, optional=false)
    @JoinColumn(name = "SUBSCRIPTION_ID")
    @Index(name="SUBSCRIPTION_INDEX", columnNames={"SUBSCRIPTION_ID"})
    protected Subscription subscription;
    
    @Column(name = "NAME", nullable=false)
    @Index(name="SUBSCRIPTION_OPTION_NAME_IDX", columnNames={"NAME"})
    @AdminPresentation(visibility = VisibilityEnum.HIDDEN_ALL)
    protected String name;

    /** The value. */
    @Column(name = "VALUE")
    @AdminPresentation(friendlyName = "Option Value", prominent=true)
    protected String value;
    
}
