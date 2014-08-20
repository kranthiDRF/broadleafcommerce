/*
 * Copyright 2008-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mycompany.controller.checkout;

import com.broadleafcommerce.accountcredit.core.web.controller.BroadleafManageGiftCardController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.checkout.model.BillingInfoForm;
import org.broadleafcommerce.core.web.checkout.model.GiftCardInfoForm;
import org.broadleafcommerce.core.web.checkout.model.OrderInfoForm;
import org.broadleafcommerce.core.web.checkout.model.ShippingInfoForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Elbert Bautista (elbertbautista)
 */
@Controller
public class GiftCardController extends BroadleafManageGiftCardController {

    protected static final Log LOG = LogFactory.getLog(GiftCardController.class);

    @RequestMapping(value="/checkout/giftcard/apply", method = RequestMethod.POST)
    public String applyGiftCard(HttpServletRequest request, HttpServletResponse response, Model model,
                                @ModelAttribute("orderInfoForm") OrderInfoForm orderInfoForm,
                                @ModelAttribute("shippingInfoForm") ShippingInfoForm shippingForm,
                                @ModelAttribute("billingInfoForm") BillingInfoForm billingForm,
                                @ModelAttribute("giftCardInfoForm") GiftCardInfoForm giftCardInfoForm,
                                BindingResult result) throws PricingException {
        return super.applyGiftCard(request, response, model, giftCardInfoForm, result);

    }

    @RequestMapping(value = "/checkout/giftcard/remove", method = RequestMethod.GET)
    public String removeGiftCard(HttpServletRequest request, HttpServletResponse response, Model model,
                                 @ModelAttribute("orderInfoForm") OrderInfoForm orderInfoForm,
                                 @ModelAttribute("shippingInfoForm") ShippingInfoForm shippingForm,
                                 @ModelAttribute("billingInfoForm") BillingInfoForm billingForm,
                                 @ModelAttribute("giftCardInfoForm") GiftCardInfoForm giftCardInfoForm,
                                 BindingResult result) throws PricingException {
        return super.removeGiftCard(request, response, model, giftCardInfoForm, result);
    }

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        super.initBinder(request, binder);
    }
}
