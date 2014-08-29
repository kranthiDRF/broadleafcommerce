package com.drf.core.domain.entitlement;

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
@Table(name = "DRF_DIGITAL_DOWNLOAD_ATTRIBUTE")
@DirectCopyTransform({
    @DirectCopyTransformMember(templateTokens = DirectCopyTransformTypes.SANDBOX, skipOverlaps=true),
    @DirectCopyTransformMember(templateTokens = DirectCopyTransformTypes.SANDBOX_PRECLONE_INFORMATION, skipOverlaps=true)    
})
public class DigitalDownloadAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "DigitalDownloadAttributeId")
    @GenericGenerator(
        name = "DigitalDownloadAttributeId",
        strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator",
        parameters = {
            @Parameter(name = "segment_value", value = "DigitalDownloadAttribute"),
            @Parameter(name = "entity_name", value = "com.drf.core.domain.entitlement.DigitalDownloadAttribute")
        }
    )
    @Column(name = "DIGITAL_DOWNLOAD_ATTRIBUTE_ID")
    @AdminPresentation(visibility = VisibilityEnum.HIDDEN_ALL)
    protected Long id;

    @ManyToOne(targetEntity = DigitalDownload.class, optional=false)
    @JoinColumn(name = "DIGITAL_DOWNLOAD_ID")
    @Index(name="DIGITAL_DOWNLOAD_INDEX", columnNames={"DIGITAL_DOWNLOAD_ID"})
    protected DigitalDownload digitalDownload;
    
    @Column(name = "NAME", nullable=false)
    @Index(name="DIGITAL_DOWNLOAD_ATTR_NAME_IDX", columnNames={"NAME"})
    @AdminPresentation(visibility = VisibilityEnum.HIDDEN_ALL)
    protected String name;

    /** The value. */
    @Column(name = "VALUE")
    @AdminPresentation(friendlyName = "Attribute Value", prominent=true)
    protected String value;
    
}
