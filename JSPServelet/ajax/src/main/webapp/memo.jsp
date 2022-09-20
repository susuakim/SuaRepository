<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<head>
<div module="product_detail">
    <!--
        $coupon_download_page = /coupon/coupon_productdetail.html
      -->
    <span module="Layout_MobileAction" class="btnBack">
        <a href="#none" onclick="{$go_back}">뒤로 가기</a>
    </span>
    <div class="productDetailImageView swiper-carousel" module="product_addimage">
        <div class="productDetailImageViewThumList swiper-wrapper">
            <div class="item swiper-slide">{$add_big_img}</div>
            <div class="item swiper-slide">{$add_big_img}</div>
        </div>
        <div module="product_image">
            <span module="product_Imagestyle"><span class="prdIcon {$icon_class_name}" style="background-image:url('{$icon_url}');"></span></span>
        </div>
        <div class="navigation"></div>
    </div>
    <div class="prdDescription">
        <div class="prdTitle">
            <h2 class="name">{$name}</h2>
            <div class="icon">{$soldout_icon} {$stock_icon} {$recommend_icon} {$new_icon} {$img_mileage_icon} {$product_icons} {$pickup_icon} {$benefit_icons}</div>
            <div class="topLogo {$supply_link_display|display}">
                <span>{$supply_top_logo}</span>
                <a href="#none" onclick="{$supply_go_action}"><img src="{$supply_go_img}" alt="공급사 바로가기" /></a>
            </div>
        </div>
        <div module="product_detaildesign" class="prdBoard info">
            <!--
				count = 10
			-->
            <table border="1" summary="">
                <caption>{$name} 기본 정보</caption>
                <colgroup>
                    <col style="width:93px;">
                    <col style="width:auto;">
                </colgroup>
                <tbody>
                    <tr class="{$item_display|display} displaynone">
                        <th scope="row">{$item_title}</th>
                        <td>{$item_content}</td>
                    </tr>
                    <tr class="{$item_display|display}">
                        <th scope="row">{$item_title}</th>
                        <td>{$item_content}</td>
                    </tr>
                </tbody>
            </table>
        </div>
        
        <div class="quantity_single_div">
            <table border="1">
                <colgroup>
                    <col style="width:93px;">
                    <col style="width:auto;">
                </colgroup>
                <tbody>
                    <tr module="product_quantity">
                        <th scope="row">수량</th>
                        <td>
                            <div class="ec-base-qty">
                                {$form.quantity}
                                <a href="javascript:;" class="qtyUp eClearUp"><img src="//img.echosting.cafe24.com/skin/base/common/btn_quantity_up.gif" id="{$quantity_up_id}" alt="증가" class="up {$quantity_up_class}"></a>
                                <a href="javascript:;" class="qtyDown eClearDown"><img src="//img.echosting.cafe24.com/skin/base/common/btn_quantity_down.gif" id="{$quantity_down_id}" alt="감소" class="down {$quantity_down_class}"></a>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="ec-base-table gClearCell {$regular_delivery_display|display}">
            <table border="1">
                <colgroup>
                    <col style="width:100px;">
                    <col style="width:auto;">
                </colgroup>
                <tbody>
                    <tr>
                        <th scope="row">구매방법</th>
                        <td>
                            <label>{$regular_deliveryF}1회구매</label>
                            <label>{$regular_deliveryT}정기배송</label>
                        </td>
                    </tr>
                    <tr class="{$regular_cycle_period|display}"  id="{$regular_cycle_period_id}">
                        <td colspan="2" class="shippingCycle">
                            <strong class="title">배송주기</strong>
                            <div class="button" module="product_regularPeriod">
                                <label class="gLabel">{$item_form}<span class="txt">{$item_content}</span></label>
                                <label class="gLabel">{$item_form}<span class="txt">{$item_content}</span></label>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        
        <div class="fundingProduct {$funding_element_display|display}">
            <div class="title">
                <strong class="name">{$name}</strong>
                <div class="prdState {$funding_ready_display|display}">
                    <span class="state">펀딩예정</span>
                </div>
                <div class="prdState {$funding_doing_display|display}">
                    <span>D-{$remain_date}</span>
                </div>
                <div class="prdState {$funding_end_display|display}">
                    <span class="state">펀딩종료</span>
                    <span class="money">{$current_money|numberformat}원</span>
                </div>
            </div>
            <p class="summary">{$summary_desc}</p>
            <div class="fundingStatus">
                <span class="goalNumber">목표금액 {$goal_money|numberformat}원</span>
                <span class="perNumber">{$progress}%</span>
                <span class="monenyNum"><em>{$current_money|numberformat}원</em></span>
                <span class="graphBar"><span style="width:{$progress}%"></span> </span>
            </div>
            <div class="fundingShipping">
                <i class="iconShipping"></i>{$delivery_date_year}년 {$delivery_date_month}월 {$delivery_date_range}배송
            </div>
        </div>
        
        <div class="prdBoard option">
            <table border="1" summary="" module="product_option">
                <!--
                    $use_per_add_option = yes
                    $default_option = yes
                -->
                <caption>상품 옵션</caption>
                <colgroup>
                    <col style="width:93px;">
                    <col style="width:auto;">
                </colgroup>
                
                <tbody module="product_option">
                    <tr>
                        <th scope="row">{$option_name}</th>
                        <td>{$form.option}<p class="value">{$option_desc}</p></td>
                    </tr>
                    <tr module="product_quantity">
                        <th scope="row">수량</th>
                        <td>
                            <div class="ec-base-qty">
                                {$form.quantity}
                                <a href="javascript:;" class="qtyUp eClearUp"><img src="//img.echosting.cafe24.com/skin/base/common/btn_quantity_up.gif" id="{$quantity_up_id}" alt="증가" class="up {$quantity_up_class}"></a>
                                <a href="javascript:;" class="qtyDown eClearDown"><img src="//img.echosting.cafe24.com/skin/base/common/btn_quantity_down.gif" id="{$quantity_down_id}" alt="감소" class="down {$quantity_down_class}"></a>
                            </div>
                        </td>
                    </tr>
                </tbody>
                <tbody>
                    <tr module="product_addoption">
                        <th scope="row">{$add_option_name}</th>
                        <td>
                            {$form.add_option}
                            <span class="txtByte" title="현재글자수/최대글자수"><strong class="length">0</strong>/{$option_maxlength}</span>
                        </td>
                    </tr>
                </tbody>
                <tbody>
                    <tr class="{$option_push_button_display|display}" id="{$option_push_button_id}">
                        <td colspan="2" class="selectButton"><a href="#none" class="btnSubmit sizeS" onclick="{$action_push_button}">옵션선택</a></td>
                    </tr>
                    <tr module="product_fileoption">
                        <th scope="row">{$file_option_name}</th>
                        <td class="fileInfo">
                            <div class="fileOption">
                                {$form.file_option}
                            </div>
                            <ul class="infoDesc">
                                <li>- 파일은 최대 5개까지 ({$file_option_limit}M 이하) 개별업로드 가능합니다.</li>
                            </ul>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="fundingProductSet">
            <div module="product_funding" class="productSet ec-base-fold theme1 eToggle {$class_composition_over}">
                <div class="title">
                    <h2>{$composition_header_name}</h2>
                </div>
                <div class="contents">
                    <div class="product">
                        <div class="information">
                            <div class="prdPrice">
                                <div class="checkbox">{$form.funding_checkbox}<label for="{$funding_checkbox_id}">{$price|numberformat}원 펀딩하기</label></div>
                                <span class="remaining {$composition_remain_display|display}">{$limit_quantity|numberformat}개 남음</span>
                                <span class="remaining {$composition_over_display|display}">마감</span>
                            </div>
                            <div class="prdDescription">
                                <strong class="name">{$composition_name}</strong>
                                <div class="description">{$description}</div>
                                <div class="quantity">
                                    <div class="ec-base-qty">
                                        <img class="QuantityDown" alt="down" src="//img.echosting.cafe24.com/skin/mobile/common/ico_quantity_down.jpg" width="33" height="29">
                                        {$form.quantity}
                                        <img class="QuantityUp" alt="up" src="//img.echosting.cafe24.com/skin/mobile/common/ico_quantity_up.jpg" width="33" height="29"></div>
                                </div>
                            </div>
                        </div>
                        <div class="option" module="product_compositionproduct">
                            <table border="1" summary="" class="">
                                <caption>상품 옵션</caption>
                                <tbody class="" module="product_compositionaddoption">
                                    <tr>
                                        <th scope="row">{$add_option_name}</th>
                                        <td>
                                            {$form.add_option}
                                            <span class="txtByte" title="현재글자수/최대글자수">(<strong class="length">0</strong>/{$option_maxlength})</span>
                                        </td>
                                    </tr>
                                </tbody>
                                <tbody class="" module="product_compositionfileoption">
                                    <tr>
                                        <th scope="row">{$file_option_name}</th>
                                        <td class="fileInfo">
                                            {$form.file_option}
                                            <ul class="infoDesc">
                                                <li>- 파일은 최대 5개까지 {$file_option_limit}M 이하로 개별업로드 가능합니다.</li>
                                                <li>- 동일상품이 장바구니에 있을 경우 현재 업로드 되는 파일로 교체됩니다.</li>
                                            </ul>
                                        </td>
                                    </tr>
                                </tbody>
                                <tbody class="" module="product_compositionoption">
                                    <tr>
                                        <th scope="row">{$option_name}</th>
                                        <td>
                                            {$form.option}
                                            <p class="value">{$option_desc}</p>
                                        </td>
                                    </tr>
                                </tbody>
                                <tbody class=""  module="product_compositionnoneoption">
                                    <tr>
                                        <th scope="row">{$option_name}</th>
                                        <td>
                                            {$form.noneoption}
                                            <p class="value">{$option_desc}</p>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--@import(/coupon/coupon_productdetail.html)-->
        <div class="sizeGuide {$size_guide_display|display}">
            <a href="#none" class="{$size_guide_class}" product_no="{$product_no}">사이즈 가이드</a>
        </div>
        <div class="productSet" module="product_setproduct">
            <!--
                $use_per_add_option = yes
            -->
            <div class="title">
                <h3>세트상품</h3>
                <a href="#self" class="btnCover eToggleSet">추가구성상품 닫기</a>
            </div>
            <ul class="product">
                <li>
                    <div class="information">
                        <div class="thumbnail"><a href="/product/detail.html?product_no={$product_no}"><img src="{$product_image}" alt="" id="{$image_id}" /></a></div>
                        <div class="description">
                            <strong class="prdName" title="상품명"><a href="{$link_bind_product_detail}">{$product_name}</a> <span class="{$set_quantity_display|display}">({$set_quantity}개씩 구매되는 상품)</span></strong>
                            <span class="prdPrice {$product_price_display|display}" title="판매가"><span class="{$product_price_del}">{$product_price}{$product_tax_type_text}</span></span>
                            <span class="prdSalePrice {$product_sale_price_display|display}" title="할인판매가">{$product_sale_price}</span>
                            <div class="stock">
                                <span class="gLabel {$stock_quantity_display|display}"><a href="#none" class="btnNormal" {$bind_stock_quantity}>재고수량보기</a></span>
                                <span class="{$product_restock_button_display|display}"><a href="#none" class="btnNormal" {$product_restock_link}>재입고 알림 SMS</a></span>
                            </div>
                            <ul class="option">
                                
                                <li module="product_option">
                                    <ul>
                                        <li>
                                            <strong class="name">{$option_name}</strong>
                                            {$form.option}
                                        </li>
                                        <li module="product_quantity">
                                            <div class="ec-base-qty">
                                                {$form.quantity}
                                                <a href="javascript:;" class="qtyUp eClearUp"><img src="//img.echosting.cafe24.com/skin/base/common/btn_quantity_up.gif" id="{$quantity_up_id}" alt="증가" class="up {$quantity_up_class}"></a>
                                                <a href="javascript:;" class="qtyDown eClearDown"><img src="//img.echosting.cafe24.com/skin/base/common/btn_quantity_down.gif" id="{$quantity_down_id}" alt="감소" class="down {$quantity_down_class}"></a>
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                                <li module="product_noneoption">
                                    <ul>
                                        <li>
                                            <strong class="name">상품선택</strong>
                                            {$form.noneoption}
                                        </li>
                                        <li module="product_quantity">
                                            <div class="ec-base-qty">
                                                {$form.quantity}
                                                <a href="javascript:;" class="qtyUp eClearUp"><img src="//img.echosting.cafe24.com/skin/base/common/btn_quantity_up.gif" id="{$quantity_up_id}" alt="증가" class="up {$quantity_up_class}"></a>
                                                <a href="javascript:;" class="qtyDown eClearDown"><img src="//img.echosting.cafe24.com/skin/base/common/btn_quantity_down.gif" id="{$quantity_down_id}" alt="감소" class="down {$quantity_down_class}"></a>
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                                <li module="product_addoption">
                                    <strong class="name">{$add_option_name}</strong>
                                    {$form.add_option} 
                                    <span class="txtByte" title="현재글자수/최대글자수"><strong class="length">0</strong>/{$option_maxlength}</span>
                                </li>
                                <li class="{$add_option_push_button_display|display} selectButton" id="{$add_option_push_button_id}">
                                    <a href="#none" class="btnSubmit sizeS" onclick="{$add_action_push_button}">옵션선택</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="guide">
                        <p class="qty {$product_min_display|display}">(최소주문수량 {$product_min}개 이상 <span class="{$product_max_display|display}">/ 최대주문수량 {$product_max}개 이하</span>)</p>
                        <div class="sizeGuide {$size_guide_display|display}">
                            <a href="#none" class="{$size_guide_class}" product_no="{$product_no}">사이즈 가이드</a>
                        </div>
                    </div>
                    <div class="description eToggle" id="eDescriptionToggle_{$product_no}">
                        <div class="ec-base-button gCenter"><button type="button" class="btnBasic icoToggle eProductDetailInfo" id="eProductDetailInfo_{$product_no}"><span>추가정보</span></button></div>
                        <div class="inner" id="product_description_{$product_no}"></div>
                    </div>
                </li>
                <li>
                    <div class="information">
                        <div class="thumbnail"><a href="/product/detail.html?product_no={$product_no}"><img src="{$product_image}" alt="" id="{$image_id}" /></a></div>
                        <div class="description">
                            <strong class="prdName" title="상품명"><a href="{$link_bind_product_detail}">{$product_name}</a> <span class="{$set_quantity_display|display}">({$set_quantity}개씩 구매되는 상품)</span></strong>
                            <span class="prdPrice {$product_price_display|display}" title="판매가"><span class="{$product_price_del}">{$product_price}{$product_tax_type_text}</span></span>
                            <span class="prdSalePrice {$product_sale_price_display|display}" title="할인판매가">{$product_sale_price}</span>
                            <div class="stock">
                                <span class="gLabel {$stock_quantity_display|display}"><a href="#none" class="btnNormal" {$bind_stock_quantity}>재고수량보기</a></span>
                                <span class="{$product_restock_button_display|display}"><a href="#none" class="btnNormal" {$product_restock_link}>재입고 알림 SMS</a></span>
                            </div>
                            <ul class="option">
                                
                                <li module="product_option">
                                    <ul>
                                        <li>
                                            <strong class="name">{$option_name}</strong>
                                            {$form.option}
                                        </li>
                                        <li module="product_quantity">
                                            <div class="ec-base-qty">
                                                {$form.quantity}
                                                <a href="javascript:;" class="qtyUp eClearUp"><img src="//img.echosting.cafe24.com/skin/base/common/btn_quantity_up.gif" id="{$quantity_up_id}" alt="증가" class="up {$quantity_up_class}"></a>
                                                <a href="javascript:;" class="qtyDown eClearDown"><img src="//img.echosting.cafe24.com/skin/base/common/btn_quantity_down.gif" id="{$quantity_down_id}" alt="감소" class="down {$quantity_down_class}"></a>
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                                <li module="product_noneoption">
                                    <ul>
                                        <li>
                                            <strong class="name">상품선택</strong>
                                            {$form.noneoption}
                                        </li>
                                        <li module="product_quantity">
                                            <div class="ec-base-qty">
                                                {$form.quantity}
                                                <a href="javascript:;" class="qtyUp eClearUp"><img src="//img.echosting.cafe24.com/skin/base/common/btn_quantity_up.gif" id="{$quantity_up_id}" alt="증가" class="up {$quantity_up_class}"></a>
                                                <a href="javascript:;" class="qtyDown eClearDown"><img src="//img.echosting.cafe24.com/skin/base/common/btn_quantity_down.gif" id="{$quantity_down_id}" alt="감소" class="down {$quantity_down_class}"></a>
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                                <li module="product_addoption" class="addOption">
                                    <strong class="name">{$add_option_name}</strong>
                                    <div>
                                        {$form.add_option}
                                        <span class="txtByte" title="현재글자수/최대글자수"><strong class="length">0</strong>/{$option_maxlength}</span>
                                    </div>
                                </li>
                                <li class="{$add_option_push_button_display|display} selectButton" id="{$add_option_push_button_id}">
                                    <a href="#none" class="btnSubmit sizeS" onclick="{$add_action_push_button}">옵션선택</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="guide">
                        <p class="qty {$product_min_display|display}">(최소주문수량 {$product_min}개 이상 <span class="{$product_max_display|display}">/ 최대주문수량 {$product_max}개 이하</span>)</p>
                        <div class="sizeGuide {$size_guide_display|display}">
                            <a href="#none" class="{$size_guide_class}" product_no="{$product_no}">사이즈 가이드</a>
                        </div>
                    </div>
                    <div class="description eToggle" id="eDescriptionToggle_{$product_no}">
                        <div class="ec-base-button gCenter"><button type="button" class="btnBasic icoToggle eProductDetailInfo" id="eProductDetailInfo_{$product_no}"><span>추가정보</span></button></div>
                        <div class="inner" id="product_description_{$product_no}"></div>
                    </div>
                </li>
            </ul>
            <div class="quantity_single_div quantity_single_div2">
                <table border="1">
                    <colgroup>
                        <col style="width:74px;">
                        <col style="width:auto;">
                    </colgroup>
                    <tbody>
                        <tr module="product_quantity">
                            <th scope="row">수량</th>
                            <td>
                                <div class="ec-base-qty">
                                    {$form.quantity}
                                    <a href="javascript:;" class="qtyUp eClearUp"><img src="//img.echosting.cafe24.com/skin/base/common/btn_quantity_up.gif" id="{$quantity_up_id}" alt="증가" class="up {$quantity_up_class}"></a>
                                    <a href="javascript:;" class="qtyDown eClearDown"><img src="//img.echosting.cafe24.com/skin/base/common/btn_quantity_down.gif" id="{$quantity_down_id}" alt="감소" class="down {$quantity_down_class}"></a>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="productSet additional" module="product_addproduct">
            <!--
                $use_per_add_option = yes
            -->
            <div class="title">
                <h3>추가구성상품</h3>
                <a href="#self" class="btnCover eToggleSet">추가구성상품 닫기</a>
            </div>
            <ul class="product">
                <li>
                    <div class="information">
                        <div class="thumbnail"><a href="{$link_product_detail}"><img src="{$product_image}" alt="" id="{$image_id}" /></a></div>
                        <div class="description">
                            <strong class="prdName" title="상품명">{$product_name}</strong>
                            <span class="prdPrice {$product_price_display|display}" title="판매가"><span class="{$product_price_del}">{$product_price}{$product_tax_type_text}</span></span>
                            <span class="prdSalePrice {$product_sale_price_display|display}" title="할인판매가">{$product_sale_price}</span>
                            <ul class="option">
                                
                                <li module="product_option">
                                    <ul>
                                        <li>
                                            <strong class="name">{$option_name}</strong>
                                            {$form.option}
                                        </li>
                                        <li module="product_quantity" class="quantity_single_li">
                                            <div class="quantity_title">
                                                수량
                                            </div>
                                            <div class="ec-base-qty">
                                                {$form.quantity}
                                                <a href="javascript:;" class="qtyUp eClearUp"><img src="//img.echosting.cafe24.com/skin/base/common/btn_quantity_up.gif" id="{$quantity_up_id}" alt="증가" class="up {$quantity_up_class}"></a>
                                                <a href="javascript:;" class="qtyDown eClearDown"><img src="//img.echosting.cafe24.com/skin/base/common/btn_quantity_down.gif" id="{$quantity_down_id}" alt="감소" class="down {$quantity_down_class}"></a>
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                                <li module="product_noneoption">
                                    <ul>
                                        <li>
                                            <strong class="name">상품선택</strong>
                                            {$form.noneoption}
                                        </li>
                                        <li module="product_quantity" class="quantity_single_li">
                                            <div class="quantity_title">
                                                수량
                                            </div>
                                            <div class="ec-base-qty">
                                                {$form.quantity}
                                                <a href="javascript:;" class="qtyUp eClearUp"><img src="//img.echosting.cafe24.com/skin/base/common/btn_quantity_up.gif" id="{$quantity_up_id}" alt="증가" class="up {$quantity_up_class}"></a>
                                                <a href="javascript:;" class="qtyDown eClearDown"><img src="//img.echosting.cafe24.com/skin/base/common/btn_quantity_down.gif" id="{$quantity_down_id}" alt="감소" class="down {$quantity_down_class}"></a>
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                                <li module="product_addoption" class="addOption">
                                    <strong class="name">{$add_option_name}</strong>
                                    <div>
                                        {$form.add_option}
                                        <span class="txtByte" title="현재글자수/최대글자수"><strong class="length">0</strong>/{$option_maxlength}</span>
                                    </div>
                                </li>
                                <li class="{$add_option_push_button_display|display} selectButton" id="{$add_option_push_button_id}">
                                    <a href="#none" class="btnSubmit sizeS" onclick="{$add_action_push_button}">옵션선택</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="information">
                        <div class="thumbnail"><a href="{$link_product_detail}"><img src="{$product_image}" alt="" id="{$image_id}" /></a></div>
                        <div class="description">
                            <strong class="prdName" title="상품명">{$product_name}</strong>
                            <span class="prdPrice {$product_price_display|display}" title="판매가"><span class="{$product_price_del}">{$product_price}{$product_tax_type_text}</span></span>
                            <span class="prdSalePrice {$product_sale_price_display|display}" title="할인판매가">{$product_sale_price}</span>
                            <ul class="option">
                                
                                <li module="product_option">
                                    <ul>
                                        <li>
                                            <strong class="name">{$option_name}</strong>
                                            {$form.option}
                                        </li>
                                        <li module="product_quantity" class="quantity_single_li">
                                            <div class="quantity_title">
                                                수량
                                            </div>
                                            <div class="ec-base-qty">
                                                {$form.quantity}
                                                <a href="javascript:;" class="qtyUp eClearUp"><img src="//img.echosting.cafe24.com/skin/base/common/btn_quantity_up.gif" id="{$quantity_up_id}" alt="증가" class="up {$quantity_up_class}"></a>
                                                <a href="javascript:;" class="qtyDown eClearDown"><img src="//img.echosting.cafe24.com/skin/base/common/btn_quantity_down.gif" id="{$quantity_down_id}" alt="감소" class="down {$quantity_down_class}"></a>
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                                <li module="product_noneoption">
                                    <ul>
                                        <li>
                                            <strong class="name">상품선택</strong>
                                            {$form.noneoption}
                                        </li>
                                        <li module="product_quantity" class="quantity_single_li">
                                            <div class="quantity_title">
                                               수량
                                            </div>
                                            <div class="ec-base-qty">
                                                {$form.quantity}
                                                <a href="javascript:;" class="qtyUp eClearUp"><img src="//img.echosting.cafe24.com/skin/base/common/btn_quantity_up.gif" id="{$quantity_up_id}" alt="증가" class="up {$quantity_up_class}"></a>
                                                <a href="javascript:;" class="qtyDown eClearDown"><img src="//img.echosting.cafe24.com/skin/base/common/btn_quantity_down.gif" id="{$quantity_down_id}" alt="감소" class="down {$quantity_down_class}"></a>
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                                <li module="product_addoption">
                                    <strong class="name">{$add_option_name}</strong>
                                    {$form.add_option}
                                    <span class="txtByte" title="현재글자수/최대글자수"><strong class="length">0</strong>/{$option_maxlength}</span>
                                </li>
                                <li class="{$add_option_push_button_display|display} selectButton" id="{$add_option_push_button_id}">
                                    <a href="#none" class="btnSubmit sizeS" onclick="{$add_action_push_button}">옵션선택</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <div id="{$total.total_id}" class="{$total.total_display|display}">
            <table border="1" summary="">
                <caption>상품 목록</caption>
                <colgroup>
                    <col style="width:auto;" />
                    <col style="width:125px;" />
                    <col style="width:auto;" />
                </colgroup>
                <thead>
                    <tr>
                        <th scope="col">상품명</th>
                        <th scope="col">상품수</th>
                        <th scope="col">가격</th>
                    </tr>
                </thead>
                <tbody class="{$quantity_display|display}">
                    <tr>
                        <td>{$name}</td>
                        <td>
                            <span class="quantity">
                                {$quantity}
                                <a href="javascript:;" class="up {$quantity_up_class}"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/product/btn_count_up.gif" alt="수량증가" /></a>
                                <a href="javascript:;" class="down {$quantity_down_class}"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/product/btn_count_down.gif" alt="수량감소" /></a>
                            </span>
                        </td>
                        <td class="right"><span class="{$total.quantity_price}">{$product_price}</span> <span class="mileage {$mileage_display|display}">(<img src="{$mileage_mileage_icon}" /><span class="{$total.mileage_price}">{$mileage_value}</span>)</span></td>
                    </tr>
                </tbody>
                <!-- Do not delete. -->
                <tbody>
                    <!--tr>
						<td>
							<p class="product">
								$상품명<br />
								<span>$옵션</span>
							</p>
						</td>
						<td>
							<span class="quantity">
								<input type="text" class="quantity_opt" /><a href="#none"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/product/btn_count_up.gif" alt="up" class="up" /></a>
								<a href="#none"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/product/btn_count_down.gif" alt="down" class="down" /></a>
							</span>
							<a href="#none" class="delete"><img src="//img.echosting.cafe24.com/design/skin/default/product/btn_price_delete.gif" alt="Remove" class="option_box_del" /></a>
						</td>
						<td class="right">
							<span>$가격</span>
							<span class="mileage">(<img src="//img.echosting.cafe24.com/design/skin/admin/ko_KR/product/ico_pay_point.gif" /><span class="mileage_price">$적립금</span>)</span>
						</td>
					</tr-->
                </tbody>
                <!-- // Do not delete. -->
            </table>
        </div>
        <div id="{$total.total_price_id}" class="totalPrice {$total.funding_price_class}">
            <strong class="title">총 상품금액(수량)</strong>
            <span class="{$total.total_cnt}">
               <strong>0</strong> (0개)
            </span>
        </div>
        <div module="product_action" id="{$fixed_action_button}" class="productAction {$funding_action_class}">
            <div class="fundingLayer" id="{$funding_alert_layer_id}" style="display:none;">
                <div class="inner {$funding_alert_layer_class}">
                    <h1>펀딩 신청 전 확인하세요.</h1>
                    <div class="wrap">
                        <p class="notice">목표 달성 시 주문서에서 입력한 카드정보로
                            <em>{$reserve_year}.{$reserve_month}.{$reserve_day}</em>에 결제되는 예약 결제입니다.</p>
                        <ul class="help">
                            <li>
                                결제가 진행된 이후에는 단순 변심으로 인한 취소나 환불이 어려울 수 있습니다.
                            </li>
                            <li>
                                펀딩 성공 후, 상품 제작/준비를 진행함으로 결제 후 바로 배송되지 않습니다.
                            </li>
                        </ul>
                    </div>
                    <div class="ec-base-button gCenter">
                        <button type="button" class="btnStrong {$funding_alert_confirm_class}" id="">동의함</button>
                    </div>
                    <button type="button" class="btnClose" onclick="closePopup()">CLOSE.001</button>
                </div>
            </div>
            <div class="buyButton {$action_display|display}">
                <a href="#none" class="btnBuy {$buy_display|display}" onclick="{$action_buy}"><span id="{$btn_buy_mobile_id}">BUY NOW</span><span class="{$btn_reserve_class|display}" id="{$btn_reserve_mobile_id}">예약주문</span><span id="{$btn_regular_delivery_id}" class="{$btn_regular_delivery|display}">정기배송 신청하기</span></a>
                <div class="addition">
                    <button type="button" class="button actionCart {$basket_display|display}" onclick="{$action_basket}">ADD TO CART</button>
                    <button type="button" class="button actionWish {$wishlist_display|display}" onclick="{$action_wishlist}">WISH LIST</button>
                </div>
            </div>
            <div class="soldoutButton {$action_soldout_display|display}">
                <button type="button" class="button soldout {$soldout_display|display}">SOLD OUT</button>
                <button type="button" class="button {$wishlist_display|display}" onclick="{$action_wishlist}" id="actionWishSoldout">WISH LIST</button>
            </div>
            <div class="ec-base-button gColumn {$funding_action_display|display}">
               <a href="#none" class="btnSubmit sizeL {$funding_ready_display|display}"><span>{$start_year}년 {$start_month}월 {$start_day}일 진행예정</span></a>
               <a href="#none" class="btnSubmit sizeL {$funding_evolve_display|display} {$btn_funding_class}"><span>펀딩하기</span></a>
               <a href="#none" class="btnSubmit sizeL {$funding_over_display|display}"><span>펀딩종료</span></a>
            </div>
            <div id="NaverChk_Button"></div>
            <div id="{$app_payment_button_box_id}"></div>
        </div>
        <div module="product_action" id="orderFixArea" class="productAction gFixed {$funding_action_class}">
            <div class="inner">
                <div class="buyButton {$action_display|display}">
                    <button type="button" class="button actionCart {$basket_display|display}" onclick="{$action_basket}">ADD TO CART</button>
                    <button type="button" class="button actionWish {$wishlist_display|display}" onclick="{$action_wishlist}">WISH LIST</button>
                    <a href="#none" class="btnBuy {$buy_display|display}" onclick="{$action_buy}"><span id="{$btn_buy_mobile_id}">BUY NOW</span><span class="{$btn_reserve_class|display}" id="{$btn_reserve_mobile_id}">예약주문</span><span id="{$btn_regular_delivery_id}" class="{$btn_regular_delivery|display}">정기배송 신청하기</span></a>
                </div>
                <div class="soldoutButton {$action_soldout_display|display}">
                    <button type="button" class="button soldout {$soldout_display|display}">SOLD OUT</button>
                    <button type="button" class="button {$wishlist_display|display}" onclick="{$action_wishlist}" id="actionWishSoldout">WISH LIST</button>
                </div>
                <div class="ec-base-button gColumn {$funding_action_display|display}">
                    <a href="#none" class="btnSubmit sizeL {$funding_ready_display|display}"><span>{$reserve_year}년 {$reserve_month}월 {$reserve_day}일 진행예정</span></a>
                    <a href="#none" class="btnSubmit sizeL {$funding_evolve_display|display} {$btn_funding_class}"><span>펀딩하기</span></a>
                    <a href="#none" class="btnSubmit sizeL {$funding_over_display|display}"><span>펀딩종료</span></a>
                </div>
            </div>
        </div>
    </div>
    <div class="event">
        {$common_event_a}
        {$common_event_b}
    </div>
</div>
</body>
</html>