package shop.common.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author mingzhi.xie
 * @date 2019/4/8
 */
public abstract class AbstractCriteria {
    private List<Criterion> criteria;

    AbstractCriteria() {
        super();
        criteria = new ArrayList<>();
    }

    public boolean isValid() {
        return criteria.size() > 0;
    }

    public List<Criterion> getAllCriteria() {
        return criteria;
    }

    public List<Criterion> getCriteria() {
        return criteria;
    }

    private void addCriterion(String condition) {
        if (condition == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        criteria.add(new Criterion(condition));
    }

    private void addCriterion(String condition, Object value, String property) {
        if (value == null) {
            throw new RuntimeException("Value for " + property + " cannot be null");
        }
        criteria.add(new Criterion(condition, value));
    }

    private void addCriterion(String condition, Object value1, Object value2, String property) {
        if (value1 == null || value2 == null) {
            throw new RuntimeException("Between values for " + property + " cannot be null");
        }
        criteria.add(new Criterion(condition, value1, value2));
    }

    public AbstractCriteria andIdIsNull() {
        addCriterion("id is null");
        return this;
    }

    public AbstractCriteria andIdIsNotNull() {
        addCriterion("id is not null");
        return this;
    }

    public AbstractCriteria andIdEqualTo(Integer value) {
        addCriterion("id =", value, "id");
        return this;
    }

    public AbstractCriteria andIdNotEqualTo(Integer value) {
        addCriterion("id <>", value, "id");
        return this;
    }

    public AbstractCriteria andIdGreaterThan(Integer value) {
        addCriterion("id >", value, "id");
        return this;
    }

    public AbstractCriteria andIdGreaterThanOrEqualTo(Integer value) {
        addCriterion("id >=", value, "id");
        return this;
    }

    public AbstractCriteria andIdLessThan(Integer value) {
        addCriterion("id <", value, "id");
        return this;
    }

    public AbstractCriteria andIdLessThanOrEqualTo(Integer value) {
        addCriterion("id <=", value, "id");
        return this;
    }

    public AbstractCriteria andIdIn(List<Integer> values) {
        addCriterion("id in", values, "id");
        return this;
    }

    public AbstractCriteria andIdNotIn(List<Integer> values) {
        addCriterion("id not in", values, "id");
        return this;
    }

    public AbstractCriteria andIdBetween(Integer value1, Integer value2) {
        addCriterion("id between", value1, value2, "id");
        return this;
    }

    public AbstractCriteria andIdNotBetween(Integer value1, Integer value2) {
        addCriterion("id not between", value1, value2, "id");
        return this;
    }

    public AbstractCriteria andPanelIdIsNull() {
        addCriterion("panel_id is null");
        return this;
    }

    public AbstractCriteria andPanelIdIsNotNull() {
        addCriterion("panel_id is not null");
        return this;
    }

    public AbstractCriteria andPanelIdEqualTo(Integer value) {
        addCriterion("panel_id =", value, "panelId");
        return this;
    }

    public AbstractCriteria andPanelIdNotEqualTo(Integer value) {
        addCriterion("panel_id <>", value, "panelId");
        return this;
    }

    public AbstractCriteria andPanelIdGreaterThan(Integer value) {
        addCriterion("panel_id >", value, "panelId");
        return this;
    }

    public AbstractCriteria andPanelIdGreaterThanOrEqualTo(Integer value) {
        addCriterion("panel_id >=", value, "panelId");
        return this;
    }

    public AbstractCriteria andPanelIdLessThan(Integer value) {
        addCriterion("panel_id <", value, "panelId");
        return this;
    }

    public AbstractCriteria andPanelIdLessThanOrEqualTo(Integer value) {
        addCriterion("panel_id <=", value, "panelId");
        return this;
    }

    public AbstractCriteria andPanelIdIn(List<Integer> values) {
        addCriterion("panel_id in", values, "panelId");
        return this;
    }

    public AbstractCriteria andPanelIdNotIn(List<Integer> values) {
        addCriterion("panel_id not in", values, "panelId");
        return this;
    }

    public AbstractCriteria andPanelIdBetween(Integer value1, Integer value2) {
        addCriterion("panel_id between", value1, value2, "panelId");
        return this;
    }

    public AbstractCriteria andPanelIdNotBetween(Integer value1, Integer value2) {
        addCriterion("panel_id not between", value1, value2, "panelId");
        return this;
    }

    public AbstractCriteria andTypeIsNull() {
        addCriterion("type is null");
        return this;
    }

    public AbstractCriteria andTypeIsNotNull() {
        addCriterion("type is not null");
        return this;
    }

    public AbstractCriteria andTypeEqualTo(Integer value) {
        addCriterion("type =", value, "type");
        return this;
    }

    public AbstractCriteria andTypeNotEqualTo(Integer value) {
        addCriterion("type <>", value, "type");
        return this;
    }

    public AbstractCriteria andTypeGreaterThan(Integer value) {
        addCriterion("type >", value, "type");
        return this;
    }

    public AbstractCriteria andTypeGreaterThanOrEqualTo(Integer value) {
        addCriterion("type >=", value, "type");
        return this;
    }

    public AbstractCriteria andTypeLessThan(Integer value) {
        addCriterion("type <", value, "type");
        return this;
    }

    public AbstractCriteria andTypeLessThanOrEqualTo(Integer value) {
        addCriterion("type <=", value, "type");
        return this;
    }

    public AbstractCriteria andTypeIn(List<Integer> values) {
        addCriterion("type in", values, "type");
        return this;
    }

    public AbstractCriteria andTypeNotIn(List<Integer> values) {
        addCriterion("type not in", values, "type");
        return this;
    }

    public AbstractCriteria andTypeBetween(Integer value1, Integer value2) {
        addCriterion("type between", value1, value2, "type");
        return this;
    }

    public AbstractCriteria andTypeNotBetween(Integer value1, Integer value2) {
        addCriterion("type not between", value1, value2, "type");
        return this;
    }

    public AbstractCriteria andProductIdIsNull() {
        addCriterion("product_id is null");
        return this;
    }

    public AbstractCriteria andProductIdIsNotNull() {
        addCriterion("product_id is not null");
        return this;
    }

    public AbstractCriteria andProductIdEqualTo(Long value) {
        addCriterion("product_id =", value, "productId");
        return this;
    }

    public AbstractCriteria andProductIdNotEqualTo(Long value) {
        addCriterion("product_id <>", value, "productId");
        return this;
    }

    public AbstractCriteria andProductIdGreaterThan(Long value) {
        addCriterion("product_id >", value, "productId");
        return this;
    }

    public AbstractCriteria andProductIdGreaterThanOrEqualTo(Long value) {
        addCriterion("product_id >=", value, "productId");
        return this;
    }

    public AbstractCriteria andProductIdLessThan(Long value) {
        addCriterion("product_id <", value, "productId");
        return this;
    }

    public AbstractCriteria andProductIdLessThanOrEqualTo(Long value) {
        addCriterion("product_id <=", value, "productId");
        return this;
    }

    public AbstractCriteria andProductIdIn(List<Long> values) {
        addCriterion("product_id in", values, "productId");
        return this;
    }

    public AbstractCriteria andProductIdNotIn(List<Long> values) {
        addCriterion("product_id not in", values, "productId");
        return this;
    }

    public AbstractCriteria andProductIdBetween(Long value1, Long value2) {
        addCriterion("product_id between", value1, value2, "productId");
        return this;
    }

    public AbstractCriteria andProductIdNotBetween(Long value1, Long value2) {
        addCriterion("product_id not between", value1, value2, "productId");
        return this;
    }

    public AbstractCriteria andSortOrderIsNull() {
        addCriterion("sort_order is null");
        return this;
    }

    public AbstractCriteria andSortOrderIsNotNull() {
        addCriterion("sort_order is not null");
        return this;
    }

    public AbstractCriteria andSortOrderEqualTo(Integer value) {
        addCriterion("sort_order =", value, "sortOrder");
        return this;
    }

    public AbstractCriteria andSortOrderNotEqualTo(Integer value) {
        addCriterion("sort_order <>", value, "sortOrder");
        return this;
    }

    public AbstractCriteria andSortOrderGreaterThan(Integer value) {
        addCriterion("sort_order >", value, "sortOrder");
        return this;
    }

    public AbstractCriteria andSortOrderGreaterThanOrEqualTo(Integer value) {
        addCriterion("sort_order >=", value, "sortOrder");
        return this;
    }

    public AbstractCriteria andSortOrderLessThan(Integer value) {
        addCriterion("sort_order <", value, "sortOrder");
        return this;
    }

    public AbstractCriteria andSortOrderLessThanOrEqualTo(Integer value) {
        addCriterion("sort_order <=", value, "sortOrder");
        return this;
    }

    public AbstractCriteria andSortOrderIn(List<Integer> values) {
        addCriterion("sort_order in", values, "sortOrder");
        return this;
    }

    public AbstractCriteria andSortOrderNotIn(List<Integer> values) {
        addCriterion("sort_order not in", values, "sortOrder");
        return this;
    }

    public AbstractCriteria andSortOrderBetween(Integer value1, Integer value2) {
        addCriterion("sort_order between", value1, value2, "sortOrder");
        return this;
    }

    public AbstractCriteria andSortOrderNotBetween(Integer value1, Integer value2) {
        addCriterion("sort_order not between", value1, value2, "sortOrder");
        return this;
    }

    public AbstractCriteria andFullUrlIsNull() {
        addCriterion("full_url is null");
        return this;
    }

    public AbstractCriteria andFullUrlIsNotNull() {
        addCriterion("full_url is not null");
        return this;
    }

    public AbstractCriteria andFullUrlEqualTo(String value) {
        addCriterion("full_url =", value, "fullUrl");
        return this;
    }

    public AbstractCriteria andFullUrlNotEqualTo(String value) {
        addCriterion("full_url <>", value, "fullUrl");
        return this;
    }

    public AbstractCriteria andFullUrlGreaterThan(String value) {
        addCriterion("full_url >", value, "fullUrl");
        return this;
    }

    public AbstractCriteria andFullUrlGreaterThanOrEqualTo(String value) {
        addCriterion("full_url >=", value, "fullUrl");
        return this;
    }

    public AbstractCriteria andFullUrlLessThan(String value) {
        addCriterion("full_url <", value, "fullUrl");
        return this;
    }

    public AbstractCriteria andFullUrlLessThanOrEqualTo(String value) {
        addCriterion("full_url <=", value, "fullUrl");
        return this;
    }

    public AbstractCriteria andFullUrlLike(String value) {
        addCriterion("full_url like", value, "fullUrl");
        return this;
    }

    public AbstractCriteria andFullUrlNotLike(String value) {
        addCriterion("full_url not like", value, "fullUrl");
        return this;
    }

    public AbstractCriteria andFullUrlIn(List<String> values) {
        addCriterion("full_url in", values, "fullUrl");
        return this;
    }

    public AbstractCriteria andFullUrlNotIn(List<String> values) {
        addCriterion("full_url not in", values, "fullUrl");
        return this;
    }

    public AbstractCriteria andFullUrlBetween(String value1, String value2) {
        addCriterion("full_url between", value1, value2, "fullUrl");
        return this;
    }

    public AbstractCriteria andFullUrlNotBetween(String value1, String value2) {
        addCriterion("full_url not between", value1, value2, "fullUrl");
        return this;
    }

    public AbstractCriteria andPicUrlIsNull() {
        addCriterion("pic_url is null");
        return this;
    }

    public AbstractCriteria andPicUrlIsNotNull() {
        addCriterion("pic_url is not null");
        return this;
    }

    public AbstractCriteria andPicUrlEqualTo(String value) {
        addCriterion("pic_url =", value, "picUrl");
        return this;
    }

    public AbstractCriteria andPicUrlNotEqualTo(String value) {
        addCriterion("pic_url <>", value, "picUrl");
        return this;
    }

    public AbstractCriteria andPicUrlGreaterThan(String value) {
        addCriterion("pic_url >", value, "picUrl");
        return this;
    }

    public AbstractCriteria andPicUrlGreaterThanOrEqualTo(String value) {
        addCriterion("pic_url >=", value, "picUrl");
        return this;
    }

    public AbstractCriteria andPicUrlLessThan(String value) {
        addCriterion("pic_url <", value, "picUrl");
        return this;
    }

    public AbstractCriteria andPicUrlLessThanOrEqualTo(String value) {
        addCriterion("pic_url <=", value, "picUrl");
        return this;
    }

    public AbstractCriteria andPicUrlLike(String value) {
        addCriterion("pic_url like", value, "picUrl");
        return this;
    }

    public AbstractCriteria andPicUrlNotLike(String value) {
        addCriterion("pic_url not like", value, "picUrl");
        return this;
    }

    public AbstractCriteria andPicUrlIn(List<String> values) {
        addCriterion("pic_url in", values, "picUrl");
        return this;
    }

    public AbstractCriteria andPicUrlNotIn(List<String> values) {
        addCriterion("pic_url not in", values, "picUrl");
        return this;
    }

    public AbstractCriteria andPicUrlBetween(String value1, String value2) {
        addCriterion("pic_url between", value1, value2, "picUrl");
        return this;
    }

    public AbstractCriteria andPicUrlNotBetween(String value1, String value2) {
        addCriterion("pic_url not between", value1, value2, "picUrl");
        return this;
    }

    public AbstractCriteria andPicUrl2IsNull() {
        addCriterion("pic_url2 is null");
        return this;
    }

    public AbstractCriteria andPicUrl2IsNotNull() {
        addCriterion("pic_url2 is not null");
        return this;
    }

    public AbstractCriteria andPicUrl2EqualTo(String value) {
        addCriterion("pic_url2 =", value, "picUrl2");
        return this;
    }

    public AbstractCriteria andPicUrl2NotEqualTo(String value) {
        addCriterion("pic_url2 <>", value, "picUrl2");
        return this;
    }

    public AbstractCriteria andPicUrl2GreaterThan(String value) {
        addCriterion("pic_url2 >", value, "picUrl2");
        return this;
    }

    public AbstractCriteria andPicUrl2GreaterThanOrEqualTo(String value) {
        addCriterion("pic_url2 >=", value, "picUrl2");
        return this;
    }

    public AbstractCriteria andPicUrl2LessThan(String value) {
        addCriterion("pic_url2 <", value, "picUrl2");
        return this;
    }

    public AbstractCriteria andPicUrl2LessThanOrEqualTo(String value) {
        addCriterion("pic_url2 <=", value, "picUrl2");
        return this;
    }

    public AbstractCriteria andPicUrl2Like(String value) {
        addCriterion("pic_url2 like", value, "picUrl2");
        return this;
    }

    public AbstractCriteria andPicUrl2NotLike(String value) {
        addCriterion("pic_url2 not like", value, "picUrl2");
        return this;
    }

    public AbstractCriteria andPicUrl2In(List<String> values) {
        addCriterion("pic_url2 in", values, "picUrl2");
        return this;
    }

    public AbstractCriteria andPicUrl2NotIn(List<String> values) {
        addCriterion("pic_url2 not in", values, "picUrl2");
        return this;
    }

    public AbstractCriteria andPicUrl2Between(String value1, String value2) {
        addCriterion("pic_url2 between", value1, value2, "picUrl2");
        return this;
    }

    public AbstractCriteria andPicUrl2NotBetween(String value1, String value2) {
        addCriterion("pic_url2 not between", value1, value2, "picUrl2");
        return this;
    }

    public AbstractCriteria andPicUrl3IsNull() {
        addCriterion("pic_url3 is null");
        return this;
    }

    public AbstractCriteria andPicUrl3IsNotNull() {
        addCriterion("pic_url3 is not null");
        return this;
    }

    public AbstractCriteria andPicUrl3EqualTo(String value) {
        addCriterion("pic_url3 =", value, "picUrl3");
        return this;
    }

    public AbstractCriteria andPicUrl3NotEqualTo(String value) {
        addCriterion("pic_url3 <>", value, "picUrl3");
        return this;
    }

    public AbstractCriteria andPicUrl3GreaterThan(String value) {
        addCriterion("pic_url3 >", value, "picUrl3");
        return this;
    }

    public AbstractCriteria andPicUrl3GreaterThanOrEqualTo(String value) {
        addCriterion("pic_url3 >=", value, "picUrl3");
        return this;
    }

    public AbstractCriteria andPicUrl3LessThan(String value) {
        addCriterion("pic_url3 <", value, "picUrl3");
        return this;
    }

    public AbstractCriteria andPicUrl3LessThanOrEqualTo(String value) {
        addCriterion("pic_url3 <=", value, "picUrl3");
        return this;
    }

    public AbstractCriteria andPicUrl3Like(String value) {
        addCriterion("pic_url3 like", value, "picUrl3");
        return this;
    }

    public AbstractCriteria andPicUrl3NotLike(String value) {
        addCriterion("pic_url3 not like", value, "picUrl3");
        return this;
    }

    public AbstractCriteria andPicUrl3In(List<String> values) {
        addCriterion("pic_url3 in", values, "picUrl3");
        return this;
    }

    public AbstractCriteria andPicUrl3NotIn(List<String> values) {
        addCriterion("pic_url3 not in", values, "picUrl3");
        return this;
    }

    public AbstractCriteria andPicUrl3Between(String value1, String value2) {
        addCriterion("pic_url3 between", value1, value2, "picUrl3");
        return this;
    }

    public AbstractCriteria andPicUrl3NotBetween(String value1, String value2) {
        addCriterion("pic_url3 not between", value1, value2, "picUrl3");
        return this;
    }

    public AbstractCriteria andCreatedIsNull() {
        addCriterion("created is null");
        return this;
    }

    public AbstractCriteria andCreatedIsNotNull() {
        addCriterion("created is not null");
        return this;
    }

    public AbstractCriteria andCreatedEqualTo(Date value) {
        addCriterion("created =", value, "created");
        return this;
    }

    public AbstractCriteria andCreatedNotEqualTo(Date value) {
        addCriterion("created <>", value, "created");
        return this;
    }

    public AbstractCriteria andCreatedGreaterThan(Date value) {
        addCriterion("created >", value, "created");
        return this;
    }

    public AbstractCriteria andCreatedGreaterThanOrEqualTo(Date value) {
        addCriterion("created >=", value, "created");
        return this;
    }

    public AbstractCriteria andCreatedLessThan(Date value) {
        addCriterion("created <", value, "created");
        return this;
    }

    public AbstractCriteria andCreatedLessThanOrEqualTo(Date value) {
        addCriterion("created <=", value, "created");
        return this;
    }

    public AbstractCriteria andCreatedIn(List<Date> values) {
        addCriterion("created in", values, "created");
        return this;
    }

    public AbstractCriteria andCreatedNotIn(List<Date> values) {
        addCriterion("created not in", values, "created");
        return this;
    }

    public AbstractCriteria andCreatedBetween(Date value1, Date value2) {
        addCriterion("created between", value1, value2, "created");
        return this;
    }

    public AbstractCriteria andCreatedNotBetween(Date value1, Date value2) {
        addCriterion("created not between", value1, value2, "created");
        return this;
    }

    public AbstractCriteria andUpdatedIsNull() {
        addCriterion("updated is null");
        return this;
    }

    public AbstractCriteria andUpdatedIsNotNull() {
        addCriterion("updated is not null");
        return this;
    }

    public AbstractCriteria andUpdatedEqualTo(Date value) {
        addCriterion("updated =", value, "updated");
        return this;
    }

    public AbstractCriteria andUpdatedNotEqualTo(Date value) {
        addCriterion("updated <>", value, "updated");
        return this;
    }

    public AbstractCriteria andUpdatedGreaterThan(Date value) {
        addCriterion("updated >", value, "updated");
        return this;
    }

    public AbstractCriteria andUpdatedGreaterThanOrEqualTo(Date value) {
        addCriterion("updated >=", value, "updated");
        return this;
    }

    public AbstractCriteria andUpdatedLessThan(Date value) {
        addCriterion("updated <", value, "updated");
        return this;
    }

    public AbstractCriteria andUpdatedLessThanOrEqualTo(Date value) {
        addCriterion("updated <=", value, "updated");
        return this;
    }

    public AbstractCriteria andUpdatedIn(List<Date> values) {
        addCriterion("updated in", values, "updated");
        return this;
    }

    public AbstractCriteria andUpdatedNotIn(List<Date> values) {
        addCriterion("updated not in", values, "updated");
        return this;
    }

    public AbstractCriteria andUpdatedBetween(Date value1, Date value2) {
        addCriterion("updated between", value1, value2, "updated");
        return this;
    }

    public AbstractCriteria andUpdatedNotBetween(Date value1, Date value2) {
        addCriterion("updated not between", value1, value2, "updated");
        return this;
    }
}
