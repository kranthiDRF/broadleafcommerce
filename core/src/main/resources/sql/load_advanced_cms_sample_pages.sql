-- Home page
INSERT INTO BLC_PAGE_TYPE (PAGE_TYPE_ID, HAS_MENU_ENTRY, IS_COLLECTION, PAGE_TYPE_KEY, NAME, SECONDARY_PAGE_TYPE, URL_PREFIX, PARENT_PAGE_TYPE_ID) VALUES (-1, 0, 0, NULL, 'Homepage Template', 'TEMPLATE', NULL, NULL);

INSERT INTO BLC_FLD_DEF (FLD_DEF_ID, FLD_ORDER, FLD_TYPE, FRIENDLY_NAME, HELP_TEXT, HIDDEN_FLAG, HINT, MAX_LENGTH, NAME) VALUES (-1, 1, 'STRING', 'Product Title', NULL, 0, NULL, NULL, 'productTitle');
INSERT INTO BLC_FLD_DEF (FLD_DEF_ID, FLD_ORDER, FLD_TYPE, FRIENDLY_NAME, HELP_TEXT, HIDDEN_FLAG, HINT, MAX_LENGTH, NAME) VALUES (-2, 2, 'ADDITIONAL_FOREIGN_KEY|org.broadleafcommerce.core.catalog.domain.Product', 'Product 1', NULL, 0, NULL, NULL, 'product1');
INSERT INTO BLC_FLD_DEF (FLD_DEF_ID, FLD_ORDER, FLD_TYPE, FRIENDLY_NAME, HELP_TEXT, HIDDEN_FLAG, HINT, MAX_LENGTH, NAME) VALUES (-3, 3, 'ADDITIONAL_FOREIGN_KEY|org.broadleafcommerce.core.catalog.domain.Product', 'Product 2', NULL, 0, NULL, NULL, 'product2');
INSERT INTO BLC_FLD_DEF (FLD_DEF_ID, FLD_ORDER, FLD_TYPE, FRIENDLY_NAME, HELP_TEXT, HIDDEN_FLAG, HINT, MAX_LENGTH, NAME) VALUES (-4, 4, 'ADDITIONAL_FOREIGN_KEY|org.broadleafcommerce.core.catalog.domain.Product', 'Product 3', NULL, 0, NULL, NULL, 'product3');
INSERT INTO BLC_FLD_DEF (FLD_DEF_ID, FLD_ORDER, FLD_TYPE, FRIENDLY_NAME, HELP_TEXT, HIDDEN_FLAG, HINT, MAX_LENGTH, NAME) VALUES (-5, 5, 'ADDITIONAL_FOREIGN_KEY|org.broadleafcommerce.core.catalog.domain.Product', 'Product 4', NULL, 0, NULL, NULL, 'product4');

INSERT INTO BLC_PAGE_TYPE_FLDDEF_MAP (BLC_PAGE_TYPE_PAGE_TYPE_ID, FLD_DEF_ID) VALUES (-1, -1);
INSERT INTO BLC_PAGE_TYPE_FLDDEF_MAP (BLC_PAGE_TYPE_PAGE_TYPE_ID, FLD_DEF_ID) VALUES (-1, -2);
INSERT INTO BLC_PAGE_TYPE_FLDDEF_MAP (BLC_PAGE_TYPE_PAGE_TYPE_ID, FLD_DEF_ID) VALUES (-1, -3);
INSERT INTO BLC_PAGE_TYPE_FLDDEF_MAP (BLC_PAGE_TYPE_PAGE_TYPE_ID, FLD_DEF_ID) VALUES (-1, -4);
INSERT INTO BLC_PAGE_TYPE_FLDDEF_MAP (BLC_PAGE_TYPE_PAGE_TYPE_ID, FLD_DEF_ID) VALUES (-1, -5);

INSERT INTO BLC_PAGE (PAGE_ID, DESCRIPTION, FULL_URL, PAGE_TYPE_ID) VALUES (-1, 'Homepage', -1, '/', -1);

INSERT INTO BLC_PAGE_FLD (PAGE_FLD_ID, FLD_KEY, LOB_VALUE, VALUE, PAGE_ID) VALUES (-1, 'product1', NULL, '1', -1);
INSERT INTO BLC_PAGE_FLD (PAGE_FLD_ID, FLD_KEY, LOB_VALUE, VALUE, PAGE_ID) VALUES (-2, 'product2', NULL, '2', -1);
INSERT INTO BLC_PAGE_FLD (PAGE_FLD_ID, FLD_KEY, LOB_VALUE, VALUE, PAGE_ID) VALUES (-3, 'product3', NULL, '7', -1);
INSERT INTO BLC_PAGE_FLD (PAGE_FLD_ID, FLD_KEY, LOB_VALUE, VALUE, PAGE_ID) VALUES (-4, 'product4', NULL, '8', -1);
INSERT INTO BLC_PAGE_FLD (PAGE_FLD_ID, FLD_KEY, LOB_VALUE, VALUE, PAGE_ID) VALUES (-5, 'productTitle', NULL, "The Heat Clinic's Top Selling Sauces", -1);

INSERT INTO BLC_THEME_FILE (ID, CONTENTS, FILE_TYPE, NAME, PATH, TEMPLATE_TYPE, PAGE_TYPE_ID, THEME_CONFIG_ID) VALUES (-1, '<!DOCTYPE HTML>\r\n<!--[if lt IE 7]> <html class=\"no-js lt-ie9 lt-ie8 lt-ie7\" lang=\"en\"> <![endif]-->\r\n<!--[if IE 7]>    <html class=\"no-js lt-ie9 lt-ie8\" lang=\"en\"> <![endif]-->\r\n<!--[if IE 8]>    <html class=\"no-js lt-ie9\" lang=\"en\"> <![endif]-->\r\n<!--[if gt IE 8]><!--> <html class=\"no-js\" lang=\"en\"> <!--<![endif]-->\r\n\r\n<head th:include=\"/layout/partials/head (pageTitle=\'Broadleaf Commerce Demo Store - Heat Clinic\')\"></head>\r\n\r\n<body>\r\n    <div id=\"notification_bar\"></div>\r\n    <header th:substituteby=\"layout/partials/header\" />\r\n    \r\n    <div id=\"content\" class=\"width_setter group\" role=\"main\">\r\n    \r\n        <nav th:substituteby=\"layout/partials/nav\" />\r\n        <blc:content-zone name=\"Homepage Banner Ad Zone\" deepLinks=\"deepLinks\" />\r\n        \r\n        <blc:content-zone name=\"Homepage Middle Promo Snippet Zone\" deepLinks=\"deepLinks\" />\r\n\r\n        <div class=\"title_bar\" th:text=\"${pageFields[productTitle]}\"></div>\r\n\r\n        <ul id=\"products\" class=\"group\">\r\n            <li th:with=\"product=${pageFields[product1]}\" th:object=\"${pageFields[product1]}\" th:include=\"catalog/partials/productListItem\" class=\"product_container\"></li>\r\n            <li th:with=\"product=${pageFields[product2]}\" th:object=\"${pageFields[product2]}\" th:include=\"catalog/partials/productListItem\" class=\"product_container\"></li>\r\n            <li th:with=\"product=${pageFields[product3]}\" th:object=\"${pageFields[product3]}\" th:include=\"catalog/partials/productListItem\" class=\"product_container\"></li>\r\n            <li th:with=\"product=${pageFields[product4]}\" th:object=\"${pageFields[product4]}\" th:include=\"catalog/partials/productListItem\" class=\"product_container\"></li>\r\n        </ul>\r\n        \r\n    </div>\r\n    \r\n    <footer th:substituteby=\"layout/partials/footer\" />\r\n    \r\n</body>\r\n</html>', 'html', 'Homepage Template', 'layout/homepage', 'page', -1, -1);

-- Featured product page
INSERT INTO BLC_PAGE_TYPE (PAGE_TYPE_ID, HAS_MENU_ENTRY, IS_COLLECTION, PAGE_TYPE_KEY, NAME, SECONDARY_PAGE_TYPE, URL_PREFIX, PARENT_PAGE_TYPE_ID) VALUES (-2, 0, 0, NULL, 'Featured Product Template', 'TEMPLATE', NULL, NULL);

INSERT INTO BLC_FLD_DEF (FLD_DEF_ID, FLD_ORDER, FLD_TYPE, FRIENDLY_NAME, HELP_TEXT, HIDDEN_FLAG, HINT, MAX_LENGTH, NAME) VALUES (-6, 1, 'ADDITIONAL_FOREIGN_KEY|org.broadleafcommerce.core.catalog.domain.Product', 'Product', NULL, 0, NULL, NULL, 'product');
INSERT INTO BLC_FLD_DEF (FLD_DEF_ID, FLD_ORDER, FLD_TYPE, FRIENDLY_NAME, HELP_TEXT, HIDDEN_FLAG, HINT, MAX_LENGTH, NAME) VALUES (-7, 2, 'STRING', 'Header', NULL, 0, NULL, NULL, 'header');
INSERT INTO BLC_FLD_DEF (FLD_DEF_ID, FLD_ORDER, FLD_TYPE, FRIENDLY_NAME, HELP_TEXT, HIDDEN_FLAG, HINT, MAX_LENGTH, NAME) VALUES (-8, 3, 'HTML', 'Description', NULL, 0, NULL, NULL, 'description');

INSERT INTO BLC_PAGE_TYPE_FLDDEF_MAP (BLC_PAGE_TYPE_PAGE_TYPE_ID, FLD_DEF_ID) VALUES (-2, -6);
INSERT INTO BLC_PAGE_TYPE_FLDDEF_MAP (BLC_PAGE_TYPE_PAGE_TYPE_ID, FLD_DEF_ID) VALUES (-2, -7);
INSERT INTO BLC_PAGE_TYPE_FLDDEF_MAP (BLC_PAGE_TYPE_PAGE_TYPE_ID, FLD_DEF_ID) VALUES (-2, -8);

INSERT INTO BLC_PAGE (PAGE_ID, DESCRIPTION, FULL_URL, PAGE_TYPE_ID) VALUES (-2, 'Featured Armageddon', '/featured-armageddon', -2);

INSERT INTO BLC_PAGE_FLD (PAGE_FLD_ID, FLD_KEY, LOB_VALUE, VALUE, PAGE_ID) VALUES (-6, 'product', NULL, '9', -2);
INSERT INTO BLC_PAGE_FLD (PAGE_FLD_ID, FLD_KEY, LOB_VALUE, VALUE, PAGE_ID) VALUES (-7, 'header', NULL, 'Current Staff Favorite', -2);
INSERT INTO BLC_PAGE_FLD (PAGE_FLD_ID, FLD_KEY, LOB_VALUE, VALUE, PAGE_ID) VALUES (-8, 'description', 'Here at the Heat Clinic, we absolutely <strong>love </strong>the Armageddon hot sauce.&nbsp;<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec luctus interdum lorem. Integer pulvinar volutpat nunc, nec pharetra leo tristique ac. In sit amet purus libero. Pellentesque eleifend elementum fermentum. Aenean semper metus quis magna blandit blandit. Integer pharetra tempus felis eu dictum. Proin quis gravida lacus. Nulla luctus ipsum nisl, vitae porta lorem vulputate non. Sed commodo et felis et ultrices. Nunc consequat condimentum libero. Proin eu ante et tortor auctor mattis. Integer eget ipsum odio.</p><p>Quisque sit amet cursus velit, vitae tincidunt turpis. Phasellus fermentum, urna nec molestie faucibus, ligula dui posuere neque, quis dapibus quam diam sit amet turpis. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Duis erat lorem, condimentum vel mattis cursus, feugiat non turpis. Integer venenatis nisi non nibh pellentesque, sit amet venenatis justo venenatis. Phasellus ultrices feugiat eros, nec facilisis leo vehicula non. Ut venenatis sollicitudin felis vel dapibus.</p>', NULL, -2);

INSERT INTO BLC_THEME_FILE (ID, CONTENTS, FILE_TYPE, NAME, PATH, TEMPLATE_TYPE, PAGE_TYPE_ID, THEME_CONFIG_ID) VALUES (-2, '<section id=\"left_column\" th:object=\"${pageFields[product]}\">\r\n    <div id=\"product_content\" class=\"product_container\">\r\n        <h2 th:text=\"${pageFields[header]}\" />\r\n        <div th:utext=\"${pageFields[description]}\" />\r\n    </div>\r\n\r\n    <div id=\"product_main_image\">\r\n        <img th:src=\"@{*{media[primary].url}}\" style=\"width: 400px;\" />\r\n    </div>\r\n</section>', 'html', 'Featured Product Template', 'featuredProduct', 'page', -2, -1);