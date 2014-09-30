package com.drf.web.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.drf.core.order.service.DRFOrderService;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Filter that looks for a {@link #CHANNEL_REQUEST_PARAMETER} request parameter on the current request. If it finds one,
 * it puts the value of the channel in session. This session attribute is then used by
 * {@link DRFOrderService#createNewCartForCustomer(org.broadleafcommerce.profile.core.domain.Customer)} to ensure that the
 * created cart has the channel that the customer had when they first came into the site.
 * 
 * @author Phillip Verheyden (phillipuniverse)
 */
@Component
public class OrderChannelFilter extends OncePerRequestFilter {

    public static final String CHANNEL_REQUEST_PARAMETER = "channel";
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String channel = request.getParameter(CHANNEL_REQUEST_PARAMETER);
        if (channel != null) {
            request.getSession().setAttribute(DRFOrderService.CHANNEL_SESSION_ATTRIBUTE, channel);
        }
        
        filterChain.doFilter(request, response);
    }

}
