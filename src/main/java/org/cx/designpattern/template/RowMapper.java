package org.cx.designpattern.template;

import javax.xml.transform.Result;
import java.sql.ResultSet;

/**
 * @author grass
 * @date 2018/5/6
 */
public interface RowMapper<T> {
    T mapRow(ResultSet rs, int rowNum) throws Exception;
}
