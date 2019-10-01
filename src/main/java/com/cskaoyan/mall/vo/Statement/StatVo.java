package com.cskaoyan.mall.vo.Statement;

import java.util.List;

/**
 * @author adore
 * @date 2019/10/1 17:23
 */
public class StatVo<T> {
    List<String> columns;
    List<T> rows;

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
