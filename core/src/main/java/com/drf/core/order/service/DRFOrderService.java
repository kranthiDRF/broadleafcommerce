package com.drf.core.order.service;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.OrderServiceImpl;
import org.broadleafcommerce.profile.core.domain.Customer;

import com.drf.core.order.domain.DRFOrder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Overrides for specific methods in the Broadleaf order service. The session attribute should be put on the current request
 * by the OrderChannelFilter in the site project.
 * 
 * @author Phillip Verheyden (phillipuniverse)
 */
public class DRFOrderService extends OrderServiceImpl {

    public static final String CHANNEL_SESSION_ATTRIBUTE = "session_channel";
    
    @Override
    public Order createNewCartForCustomer(Customer customer) {
        Order newOrder = orderDao.createNewCartForCustomer(customer);
        
        /**
         * Convenience method to grab the request off of thread local that was put on by {@link BroadleafRequestProcessor}
         */
        HttpServletRequest request = BroadleafRequestContext.getBroadleafRequestContext().getRequest();
        HttpSession session = request.getSession(false);
        if (session != null) {
            String channel = (String) session.getAttribute(CHANNEL_SESSION_ATTRIBUTE);
            if (channel != null) {
                ((DRFOrder) newOrder).setChannel(channel);
            }
        }
        return newOrder;
    }
}
