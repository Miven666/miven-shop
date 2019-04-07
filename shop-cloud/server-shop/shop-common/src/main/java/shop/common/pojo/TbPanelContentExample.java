package shop.common.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 面板内容示例
 *
 * @author mingzhi.xie
 * @date 2019/4/7
 */
public class TbPanelContentExample {

    private String orderByClause;

    private boolean distinct;

    private List<Criteria> orderCriteria;

    public TbPanelContentExample() {
        orderCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOrderCriteria() {
        return orderCriteria;
    }

    public void or(Criteria criteria) {
        orderCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        orderCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (orderCriteria.size() == 0) {
            orderCriteria.add(criteria);
        }
        return criteria;
    }

    private Criteria createCriteriaInternal() {
        return new Criteria();
    }

    public void clear() {
        orderCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

}
