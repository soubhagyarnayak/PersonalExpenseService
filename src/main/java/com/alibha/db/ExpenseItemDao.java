package com.alibha.db;

import com.alibha.api.ExpenseItem;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface ExpenseItemDao {
    @SqlQuery("select * from ExpenseItem where Id=:id")
    @RegisterBeanMapper(ExpenseItem.class)
    ExpenseItem findById(@Bind("id") long id);

    @SqlUpdate("insert into ExpenseItem (CreateTime,Category,Recipient,Description,Amount,Tags) values (:createtime,:category,:recipient,:description,:amount,:tags)")
    @GetGeneratedKeys
    long insert(@BindBean ExpenseItem team);
}
