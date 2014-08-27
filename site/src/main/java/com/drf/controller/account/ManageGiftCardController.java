/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.drf.controller.account;

import com.broadleafcommerce.accountcredit.core.web.controller.BroadleafManageGiftCardController;
import org.broadleafcommerce.core.web.checkout.model.GiftCardInfoForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jerry Ocanas (jocanas)
 */
@Controller
@RequestMapping(value = "/account/giftcard")
public class ManageGiftCardController extends BroadleafManageGiftCardController {

    @Override
    @RequestMapping(value = "/redeem", method = RequestMethod.GET)
    public String viewRedeemGiftCard(HttpServletRequest request, HttpServletResponse response, Model model,
            @ModelAttribute("giftCardInfoForm") GiftCardInfoForm giftCardInfoForm, BindingResult result) {
        return super.viewRedeemGiftCard(request, response, model, giftCardInfoForm, result);
    }

    @Override
    @RequestMapping(value = "/redeem", method = RequestMethod.POST)
    public String redeemGiftCard(HttpServletRequest request, HttpServletResponse response, Model model,
            @ModelAttribute("giftCardInfoForm") GiftCardInfoForm giftCardInfoForm, BindingResult result) {
        return super.redeemGiftCard(request, response, model, giftCardInfoForm, result);
    }

}
